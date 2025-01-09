package org.firstinspires.ftc.robotcontroller.EsDing;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

public class DrivingMotor extends OpMode {

    DcMotor leftFrontMotor;     //Driving base left front motor
    DcMotor leftBackMotor;      //Driving base left Back motor
    DcMotor rightFrontMotor;    //Driving base right front motor
    DcMotor rightBackMotor;     //Driving base right back motor
    double  MaxSpeed;           //Driving base movement max speed

    public DrivingMotor(String leftFrontMotor, String leftBackMotor, String rightFrontMotor, String rightBackMotor, double MaxSpeed) {

        // Connect to motor (Position Normal Input Assumption)
        this.leftFrontMotor     = hardwareMap.get(DcMotor.class, leftFrontMotor);
        this.leftBackMotor      = hardwareMap.get(DcMotor.class, leftBackMotor);
        this.rightFrontMotor    = hardwareMap.get(DcMotor.class, rightFrontMotor);
        this.rightBackMotor     = hardwareMap.get(DcMotor.class, rightBackMotor);

        // Maximum Speed Settings (Assume a configurable range
        this.MaxSpeed           = MaxSpeed;
    }

    @Override
    public void init() {}

    @Override
    public void loop() {}
}
