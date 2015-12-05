package com.qualcomm.ftcrobotcontroller.opmodes;


import com.qualcomm.ftccommon.DbgLog;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.*;



public class PushBotAuto extends PushBotTelemetry
{
    public DcMotor aMotor;

    @Override public void start () {
        aMotor = hardwareMap.dcMotor.get("frontRight");
    }

    @Override public void loop ()
    {
        aMotor.setPower(1);
        Integer instance2 = new Integer(aMotor.getCurrentPosition());
        DbgLog.msg("ENCO RIGHT:" + String.valueOf(instance2));
    }
 } //

// PushBotAuto
