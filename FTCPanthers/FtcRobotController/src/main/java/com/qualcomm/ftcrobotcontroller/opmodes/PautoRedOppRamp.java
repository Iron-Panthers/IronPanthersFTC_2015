public class PautoRedOppRamp
{
	Mountain mountain = new Mountain();
	DriveAuto driveAuto = new DriveAuto();

	public void execute()
	{
		driveAuto.wait(10);
		driveAuto.driveStraight(52.1, 0.5);
		driveAuto.turnLeft(90);
		driveAuto.driveStraight(-60, 0.5);
		moutain.backClimb();
	}	
}
