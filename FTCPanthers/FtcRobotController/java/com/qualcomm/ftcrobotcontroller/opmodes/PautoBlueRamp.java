package com.qualcomm.ftcrobotcontroller.opmodes;

public class PautoBlueRamp extends PushBotTelemetry
{
	Mountain mountain = new Mountain(hardwareMap);
	DriveAuto driveAuto = new DriveAuto(hardwareMap);
	PautoBlueRamp(){};

	public void execute()
	{
		driveAuto.driveStraight(52.1, 0.5);
		driveAuto.turnRight(90);
		driveAuto.driveStraight(-32.68, 0.5);
		mountain.backClimb();
	}
}	
