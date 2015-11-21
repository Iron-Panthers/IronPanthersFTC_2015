public class PautoBlueOppRamp
{
	Mountain mountain = new Mountain();
	DriveAuto driveAuto = new DriveAuto();

	public void execute()
	{
		driveAuto.wait(10);
		driveAuto.driveStraight(81.5, 0.5);
		driveAuto.turnLeft(90);
		driveAuto.driveStraight(-60. 0.5);
		mountain.backClimb();
	}	
}
