package org.firstinspires.ftc.robotcontroller.EsDing;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

public class DrivingMotor extends OpMode {

    DcMotor leftFrontMotor;     //Driving base left front motor
    DcMotor leftBackMotor;      //Driving base left Back motor
    DcMotor rightFrontMotor;    //Driving base right front motor
    DcMotor rightBackMotor;     //Driving base right back motor
    double  Speed;              //Driving base movement max speed

    public DrivingMotor(String leftFrontMotor, String leftBackMotor, String rightFrontMotor, String rightBackMotor, double Speed) {

        // Connect to motor (Position Normal Input Assumption)
        this.leftFrontMotor     = hardwareMap.get(DcMotor.class, leftFrontMotor);
        this.leftBackMotor      = hardwareMap.get(DcMotor.class, leftBackMotor);
        this.rightFrontMotor    = hardwareMap.get(DcMotor.class, rightFrontMotor);
        this.rightBackMotor     = hardwareMap.get(DcMotor.class, rightBackMotor);

        // Maximum Speed Settings (Assume a configurable range
        this.Speed              = Speed;
    }

    public void moveForward(){
        leftFrontMotor  .setPower(1.0);
        leftBackMotor   .setPower(1.0);
        rightFrontMotor .setPower(1.0);
        rightBackMotor  .setPower(1.0);
    }

    public void moveBack(){
        leftFrontMotor  .setPower(-1.0);
        leftBackMotor   .setPower(-1.0);
        rightFrontMotor .setPower(-1.0);
        rightBackMotor  .setPower(-1.0);
    }

    public void moveLeft(){
        leftFrontMotor  .setPower(-1.0);
        leftBackMotor   .setPower(1.0);
        rightFrontMotor .setPower(1.0);
        rightBackMotor  .setPower(-1.0);
    }

    public void moveRight(){
        leftFrontMotor  .setPower(1.0);
        leftBackMotor   .setPower(-1.0);
        rightFrontMotor .setPower(-1.0);
        rightBackMotor  .setPower(1.0);
    }

    public void moveLeftForward(){
        leftFrontMotor  .setPower(0.0);
        leftBackMotor   .setPower(1.0);
        rightFrontMotor .setPower(1.0);
        rightBackMotor  .setPower(0.0);
    }

    public void moveLeftBack(){
        leftFrontMotor  .setPower(-1.0);
        leftBackMotor   .setPower(0.0);
        rightFrontMotor .setPower(0.0);
        rightBackMotor  .setPower(-1.0);
    }

    public void moveRightForward(){
        leftFrontMotor  .setPower(1.0);
        leftBackMotor   .setPower(0.0);
        rightFrontMotor .setPower(0.0);
        rightBackMotor  .setPower(1.0);
    }

    public void moveRightBack(){
        leftFrontMotor  .setPower(0.0);
        leftBackMotor   .setPower(-1.0);
        rightFrontMotor .setPower(-1.0);
        rightBackMotor  .setPower(0.0);
    }

    public void moveLeftTurn(){
        leftFrontMotor  .setPower(-1.0);
        leftBackMotor   .setPower(-1.0);
        rightFrontMotor .setPower(1.0);
        rightBackMotor  .setPower(1.0);
    }

    public void moveRightTurn(){
        leftFrontMotor  .setPower(1.0);
        leftBackMotor   .setPower(1.0);
        rightFrontMotor .setPower(-1.0);
        rightBackMotor  .setPower(-1.0);
    }

    public void moveStop(){
        leftFrontMotor  .setPower(0.0);
        leftBackMotor   .setPower(0.0);
        rightFrontMotor .setPower(0.0);
        rightBackMotor  .setPower(0.0);
    }

    @Override
    public void init() {}

    @Override
    public void loop() {}
}
