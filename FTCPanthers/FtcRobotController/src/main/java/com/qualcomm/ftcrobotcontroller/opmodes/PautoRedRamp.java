package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.robotcore.hardware.HardwareMap;

public class PautoRedRamp extends PushBotTelemetry
{
	DriveAuto driveAuto;
	Mountain mountain;
	PautoRedRamp(){}

	public void execute()
	{
		driveAuto = new DriveAuto(hardwareMap);
		mountain = new Mountain(hardwareMap);

		driveAuto.driveStraight(81.5, 0.5);
		driveAuto.turnRight(90);
		driveAuto.driveStraight(-32.68, 0.5);
		mountain.backClimb();
	}
}
