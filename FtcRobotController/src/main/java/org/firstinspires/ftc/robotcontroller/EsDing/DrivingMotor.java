package org.firstinspires.ftc.robotcontroller.EsDing;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

public class DrivingMotor extends OpMode {

    DcMotor leftFrontMotor;     //Driving base left front motor
    DcMotor leftBackMotor;      //Driving base left Back motor
    DcMotor rightFrontMotor;    //Driving base right front motor
    DcMotor rightBackMotor;     //Driving base right back motor
    double  speed;              //Driving base movement max speed

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public DrivingMotor(String leftFrontMotor, String leftBackMotor, String rightFrontMotor, String rightBackMotor, double speed, boolean reverse) {

        // Connect to motor (Position Normal Input Assumption)
        this.leftFrontMotor     = hardwareMap.get(DcMotor.class, leftFrontMotor);
        this.leftBackMotor      = hardwareMap.get(DcMotor.class, leftBackMotor);
        this.rightFrontMotor    = hardwareMap.get(DcMotor.class, rightFrontMotor);
        this.rightBackMotor     = hardwareMap.get(DcMotor.class, rightBackMotor);

        // Maximum Speed Settings (Assume a configurable range
        this.speed              = speed;

        // Motor default orientation setting
        if (reverse) {
            this.leftFrontMotor.setDirection(DcMotor.Direction.FORWARD);
            this.leftBackMotor.setDirection(DcMotor.Direction.FORWARD);
            this.rightFrontMotor.setDirection(DcMotor.Direction.REVERSE);
            this.rightBackMotor.setDirection(DcMotor.Direction.REVERSE);
        }
        else {
            this.leftFrontMotor.setDirection(DcMotor.Direction.REVERSE);
            this.leftBackMotor.setDirection(DcMotor.Direction.REVERSE);
            this.rightFrontMotor.setDirection(DcMotor.Direction.FORWARD);
            this.rightBackMotor.setDirection(DcMotor.Direction.FORWARD);
        }
    }

    public void moveForward(){
        leftFrontMotor  .setPower( speed);
        leftBackMotor   .setPower( speed);
        rightFrontMotor .setPower( speed);
        rightBackMotor  .setPower( speed);
    }

    public void moveBack(){
        leftFrontMotor  .setPower(-speed);
        leftBackMotor   .setPower(-speed);
        rightFrontMotor .setPower(-speed);
        rightBackMotor  .setPower(-speed);
    }

    public void moveLeft(){
        leftFrontMotor  .setPower(-speed);
        leftBackMotor   .setPower( speed);
        rightFrontMotor .setPower( speed);
        rightBackMotor  .setPower(-speed);
    }

    public void moveRight(){
        leftFrontMotor  .setPower( speed);
        leftBackMotor   .setPower(-speed);
        rightFrontMotor .setPower(-speed);
        rightBackMotor  .setPower( speed);
    }

    public void moveLeftForward(){
        leftFrontMotor  .setPower( 0.0);
        leftBackMotor   .setPower( speed);
        rightFrontMotor .setPower( speed);
        rightBackMotor  .setPower( 0.0);
    }

    public void moveLeftBack(){
        leftFrontMotor  .setPower(-speed);
        leftBackMotor   .setPower( 0.0);
        rightFrontMotor .setPower( 0.0);
        rightBackMotor  .setPower(-speed);
    }

    public void moveRightForward(){
        leftFrontMotor  .setPower( speed);
        leftBackMotor   .setPower( 0.0);
        rightFrontMotor .setPower( 0.0);
        rightBackMotor  .setPower( speed);
    }

    public void moveRightBack(){
        leftFrontMotor  .setPower( 0.0);
        leftBackMotor   .setPower(-speed);
        rightFrontMotor .setPower(-speed);
        rightBackMotor  .setPower( 0.0);
    }

    public void moveLeftTurn(){
        leftFrontMotor  .setPower(-speed);
        leftBackMotor   .setPower(-speed);
        rightFrontMotor .setPower( speed);
        rightBackMotor  .setPower( speed);
    }

    public void moveRightTurn(){
        leftFrontMotor  .setPower( speed);
        leftBackMotor   .setPower( speed);
        rightFrontMotor .setPower(-speed);
        rightBackMotor  .setPower(-speed);
    }

    public void moveStop(){
        leftFrontMotor  .setPower( 0.0);
        leftBackMotor   .setPower( 0.0);
        rightFrontMotor .setPower( 0.0);
        rightBackMotor  .setPower( 0.0);
    }

    @Override
    public void init() {}

    @Override
    public void loop() {}
}
