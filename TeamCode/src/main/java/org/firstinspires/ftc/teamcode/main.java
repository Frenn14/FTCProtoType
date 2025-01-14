package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp(name = "main", group = "FTC")
public class main extends OpMode {

    DcMotor leftFrontMotor  =  hardwareMap.get(DcMotor.class, "A");     //Driving base left front motor
    DcMotor leftBackMotor   =  hardwareMap.get(DcMotor.class, "B");     //Driving base left Back motor
    DcMotor rightFrontMotor =  hardwareMap.get(DcMotor.class, "C");     //Driving base right front motor
    DcMotor rightBackMotor  =  hardwareMap.get(DcMotor.class, "D");     //Driving base right back motor
    double  speed           =  1.0;                                                //Driving base movement max speed

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
    public void init() {
        leftFrontMotor  .setDirection(DcMotor.Direction.FORWARD);
        leftBackMotor   .setDirection(DcMotor.Direction.FORWARD);
        rightFrontMotor .setDirection(DcMotor.Direction.REVERSE);
        rightBackMotor  .setDirection(DcMotor.Direction.REVERSE);
    }

    @Override
    public void loop() {

    }
}