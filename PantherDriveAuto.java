import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorController;

public class PantherDriveAuto
{
	public DcMotor leftMotor;
    public DcMotor rightMotor;

    leftMotor = hardwareMap.dcMotor.get("leftMotor");
    rightMotor = hardwareMap.dcMotor.get("frontLeft");

    double TREAD_LENGTH = 36.25; 
    double ROBOT_WIDTH = 15.25;

	public void driveStraight(double distance, double speed) //distance is in inches
	{
		targetValue = distance / TREAD_LENGTH;

		double start = leftMotor.getCurrentPosition();

		targetValue += start;

		while(leftMotor.getCurrentPosition() &&  rightMotor.getCurrentPosition() < targetValue)
		{
			leftMotor.setPower(speed);
			rightMotor.setPower(speed);
		}
	}

	public void turnRight(double angle)
	{
		double start = leftMotor.getCurrentPosition();
		leftMotor.setPower(0);
		rightMotor.setPower(0);

		double targetValue = ((ROBOT_WIDTH * Math.PI) * (angle / 360)) / TREAD_LENGTH;

		targetValue += start;

		while(leftMotor.getCurrentPosition() < targetValue)
		{
			leftMotor.setPower(0.5);
			rightMotor.setPower(-0.5);
		}
	}

	public void turnLeft(double angle)
	{
		double start =  rightMotor.getCurrentPosition();
        leftMotor.setPower(0);
		rightMotor.setPower(0);

		double targetValue = ((ROBOT_WIDTH * Math.PI) * (angle / 360)) / TREAD_LENGTH;

		targetValue += start;

		while(rightMotor.getCurrentPosition() < targetValue)
		{
			leftMotor.setPower(-0.5);
			rightMotor.setPower(0.5);

		}
	}
}