public class Mountain
{
	AllianceButton allianceButton = new AllianceButton();
	DriveAuto driveAuto = new driveAuto();

	public void climb()
	{
		while(!(allianceButton.checkDist() < 20 && allianceButton.checkDist() > 18))
		{
			driveAuto.driveStraight(1, 1);
		}
	}
	public void backClimb()
	{
		while(!(allianceButton.checkDist() < 20 && allianceButton.checkDist() > 18))
		{
			driveAuto.driveStraight(-1, 1);
		}
	}
}
