package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.robotcontroller.EsDing.DrivingMotor;

@TeleOp(name = "main", group = "FTC")
public class main extends OpMode {
    @Override
    public void init() {
        DrivingMotor diving = new DrivingMotor("A", "B", "C", "D",1.0);
    }

    @Override
    public void loop() {

    }
}
