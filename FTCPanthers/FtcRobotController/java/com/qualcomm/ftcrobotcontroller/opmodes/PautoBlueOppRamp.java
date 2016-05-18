package com.qualcomm.ftcrobotcontroller.opmodes;

public class PautoBlueOppRamp extends PushBotTelemetry
{
	Mountain mountain = new Mountain(hardwareMap);
	DriveAuto driveAuto = new DriveAuto(hardwareMap);
	PautoBlueOppRamp(){};

	public void execute()
	{
		driveAuto.wait(10.0);
		driveAuto.driveStraight(81.5, 0.5);
		driveAuto.turnLeft(90);
		driveAuto.driveStraight(-60, 0.5);
		mountain.backClimb();
	}	
}
