import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorController;

public class PantherDriveAuto
{
	public DcMotor leftMotor;
    public DcMotor rightMotor;

    double TREAD_LENGTH = 36.25;
	double ROBOT_WIDTH = 15.25;

	public void driveStraight(double distance, double speed)
	{
		double start = leftMotor.getCurrentPosition();

		targetValue = targetValue + start;

		while(leftMotor.getCurrentPosition() && rightMotor.getCurrentPosition() < targetValue)
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

		while(rightMotor.getCurrentPosition() && leftMotor.getCurrentPosition() < targetValue)
		{
			leftMotor.setPower(0.5);
			rightMotor.setPower(-0.5);
		}
	}

	public void turnLeft(double angle)
	{
		double start = rightMotor.getCurrentPosition();
		leftMotor.setPower(0);
		rightMotor.setPower(0);

		while(rightMotor.getCurrentPosition() && leftMotor.getCurrentPosition() < targetValue)
		{
			leftMotor.setPower(-0.5);
			rightMotor.setPower(0.5);
		}
	}
}