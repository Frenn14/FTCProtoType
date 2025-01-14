package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp(name = "main", group = "FTC")
public class main extends OpMode {


    @Override
    public void init() {
        DrivingMotor a = new DrivingMotor("A","B","C","D", 1.0, true);
    }

    @Override
    public void loop() {

    }
}