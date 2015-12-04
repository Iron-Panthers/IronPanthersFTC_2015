package com.qualcomm.ftcrobotcontroller.opmodes;


import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.*;



public class PushBotAuto extends PushBotTelemetry
{
    public Move move;

    @Override public void start () {
        move = new Move(60.0, 1.0, hardwareMap);
    }

    @Override public void loop ()
    {
        move.update();
    }
 } //

// PushBotAuto
