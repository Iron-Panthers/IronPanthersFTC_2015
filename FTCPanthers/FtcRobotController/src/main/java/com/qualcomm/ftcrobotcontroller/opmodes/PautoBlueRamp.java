public class PautoBlueRamp
{
	Mountain mountain = new Mountain();
	DriveAuto driveAuto = new DriveAuto();

	public void execute()
	{
		driveAuto.driveStraight(52.1, 0.5);
		driveAuto.turnRight(90);
		driveAuto.driveStraight(-32.68, 0.5);
		moutain.backClimb();
	}
}	
