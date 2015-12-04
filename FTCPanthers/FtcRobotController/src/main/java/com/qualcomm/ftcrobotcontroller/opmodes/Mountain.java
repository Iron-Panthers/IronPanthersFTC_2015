package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.*;

public class Mountain
{

	public DriveAuto driveAuto;

	public static final String ULTRASONIC_SENSOR = "ultrasonic";

	public UltrasonicSensor ultrasonic;

	public Mountain(HardwareMap hardwareMap)
	{
		driveAuto = new DriveAuto(hardwareMap);
		ultrasonic = hardwareMap.ultrasonicSensor.get(ULTRASONIC_SENSOR);
	}

	public void climb()
	{
		while((ultrasonic.getUltrasonicLevel() < 10))
		{
			driveAuto.moveFowards(1.0);
		}
		driveAuto.moveFowards(0.0);
	}
	public void backClimb()
	{
		while((ultrasonic.getUltrasonicLevel() < 10))
		{
			driveAuto.moveFowards(-1.0);
		}
		driveAuto.moveFowards(0.0);
	}
}