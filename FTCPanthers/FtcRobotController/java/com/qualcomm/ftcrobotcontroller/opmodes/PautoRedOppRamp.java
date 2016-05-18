package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.robotcore.hardware.HardwareMap;

public class PautoRedOppRamp extends PushBotTelemetry
{
	Mountain mountain = new Mountain(hardwareMap);
	DriveAuto driveAuto = new DriveAuto(hardwareMap);
	PautoRedOppRamp(){};

	public void execute()
	{
		driveAuto.wait(10.0);
		driveAuto.driveStraight(52.1, 0.5);
		driveAuto.turnLeft(90);
		driveAuto.driveStraight(-60, 0.5);
		mountain.backClimb();
	}	
}
