class PidDrive {

	DcMotor left, right;
	SpeedChecker leftSpeed, rightSpeed;

	public PidDrive(DcMotor left, DcMotor right) {
		this.left = left;
		this.right = right;
		this.leftSpeed = new SpeedChecker(left);
		this.rightSpeed = new SpeedChecker(right);
	}

	public void moveForward(Queue queue, double power, long time) {
		queue.shift(new PidDriveAction(this, power, time));
	}

	public void setBothPowers(double power) {
		left.setPower(power);
		right.setPower(power);
	}

}

class PidDriveAction extends Routine {

	public static final double THRESHOLD = 0.05d;
	public static final long DELTA_TIME = 100l;

	DcMotor slave, master;
	SpeedChecker slaveSpeed, masterSpeed;
	double power;
	long end;

	public static final double sensitivity = 0.1d;

	public PidDriveAction(PidDrive drive, double power, long time) {
		
		this.power = power;
		this.end = System.currentTimeMillis() + time;
		
		drive.leftSpeed.update();
		drive.rightSpeed.update();
		drive.setBothPowers(power);
		drive.leftSpeed.update();
		drive.rightSpeed.update();

		if (drive.leftSpeed.getSpeed() > drive.rightSpeed.getSpeed()) {
			slave = drive.left;
			master = drive.right;
			slaveSpeed = drive.leftSpeed;
			masterSpeed = drive.rightSpeed;
		} else {
			slave = drive.right;
			master = drive.left;
			slaveSpeed = drive.rightSpeed;
			masterSpeed = drive.leftSpeed;
		}

	}

	@Override
	public boolean update() {
		slaveSpeed.update();
		masterSpeed.update();
		double vSlave = slaveSpeed.getSpeed(), vMaster = masterSpeed.getSpeed();
		boolean speedWithinThreshold = vMaster*(1-THRESHOLD) < vSlave && vSlave < vMaster*(1+THRESHOLD);
		if (!speedWithinThreshold) {
			double adjustment = 1 - (vMaster/vSlave);
			slave.setPower(slave.getPower() + adjustment*sensitivity*DELTA_TIME);
		}
		return isFinished();
	}

	@Override
	public boolean isFinished() {
		return System.currentTimeMillis() > time;
	}

}

class SpeedChecker {

	private long lastTime;
	private double lastPos;
	private DcMotor motor;

	public SpeedChecker(DcMotor motor) {
		this.motor = motor;
		this.lastPos = motor.getCurrentPosition();
		this.lastTime = System.currentTimeMillis();
	}

	public void update() {
		this.lastPos = motor.getCurrentPosition();
		this.lastTime =  System.currentTimeMillis();
	}

	public double getSpeed() {
		int currentPos = motor.getCurrentPosition();
		long currentTime = System.currentTimeMillis();
		double speed = (currentPos-lastPos)/(currentTime-lastTime)/1000;
		return speed;
	}

}
