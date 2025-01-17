package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;

@TeleOp
public class auto extends LinearOpMode {

    // Declare OpMode members.
    ElapsedTime runtime         = new ElapsedTime();

    // --------- [Motor Variable Name] ---------

    // DcMotor
    DcMotor leftViper           = null;
    DcMotor leftFrontMotor      = null;
    DcMotor leftBackMotor       = null;
    DcMotor leftArm             = null;
    DcMotor rightViper          = null;
    DcMotor rightFrontMotor     = null;
    DcMotor rightBackMotor      = null;
    DcMotor rightArm            = null;

    // ServoMotor
    Servo   leftViperServo      = null;
    Servo   rightViperServo     = null;
    Servo   viperPickUpServo    = null;
    Servo   pickUpRotation      = null;
    Servo   leftSlideRotation   = null;
    Servo   SlidePickServo      = null;
    Servo   rightSlideRotation  = null;
    Servo   leftLinkServo       = null;
    Servo   rightLinkServo      = null;
    // -----------------------------------------

    // ------ [Management Variable Name] -------
    double  maxSpeed        = 1.0;  //Driving base movement max speed
    double  speed           = 0.0;  //Driving base movement speed
    double  reception       = 0.2;  //Controller input sensitivity
    // -----------------------------------------

    // ------- [Motor drive functions] ---------

    // Driving Motor Functions
    public void moveForward(int sleepTime, double power){
        telemetry       .addData("Move", "Forward");
        telemetry       .update();
        leftFrontMotor  .setPower( power);
        leftBackMotor   .setPower( power);
        rightFrontMotor .setPower( power);
        rightBackMotor  .setPower( power);
        if (sleepTime != 0){ sleep(sleepTime); moveStop(0); }
    }

    public void moveBack(int sleepTime, double power){
        telemetry       .addData("Move", "Back");
        telemetry       .update();
        leftFrontMotor  .setPower(-power);
        leftBackMotor   .setPower(-power);
        rightFrontMotor .setPower(-power);
        rightBackMotor  .setPower(-power);
        if (sleepTime != 0){ sleep(sleepTime); moveStop(0); }
    }

    public void moveLeft(int sleepTime, double power){
        telemetry       .addData("Move", "Left");
        telemetry       .update();
        leftFrontMotor  .setPower(-power);
        leftBackMotor   .setPower( power);
        rightFrontMotor .setPower( power);
        rightBackMotor  .setPower(-power);
        if (sleepTime != 0){ sleep(sleepTime); moveStop(0); }
    }

    public void moveRight(int sleepTime, double power){
        telemetry       .addData("Move", "Right");
        telemetry       .update();
        leftFrontMotor  .setPower( power);
        leftBackMotor   .setPower(-power);
        rightFrontMotor .setPower(-power);
        rightBackMotor  .setPower( power);
        if (sleepTime != 0){ sleep(sleepTime); moveStop(0); }
    }

    public void moveLeftForward(int sleepTime, double power){
        telemetry       .addData("Move", "LeftForward");
        telemetry       .update();
        leftFrontMotor  .setPower( 0.0  );
        leftBackMotor   .setPower( power);
        rightFrontMotor .setPower( power);
        rightBackMotor  .setPower( 0.0  );
        if (sleepTime != 0){ sleep(sleepTime); moveStop(0); }
    }

    public void moveLeftBack(int sleepTime, double power){
        telemetry       .addData("Move", "LeftBack");
        telemetry       .update();
        leftFrontMotor  .setPower(-power);
        leftBackMotor   .setPower( 0.0  );
        rightFrontMotor .setPower( 0.0  );
        rightBackMotor  .setPower(-power);
        if (sleepTime != 0){ sleep(sleepTime); moveStop(0); }
    }

    public void moveRightForward(int sleepTime, double power){
        telemetry       .addData("Move", "RightForward");
        telemetry       .update();
        leftFrontMotor  .setPower( power);
        leftBackMotor   .setPower( 0.0  );
        rightFrontMotor .setPower( 0.0  );
        rightBackMotor  .setPower( power);
        if (sleepTime != 0){ sleep(sleepTime); moveStop(0); }
    }

    public void moveRightBack(int sleepTime, double power){
        telemetry       .addData("Move", "RightBack");
        telemetry       .update();
        leftFrontMotor  .setPower( 0.0  );
        leftBackMotor   .setPower(-power);
        rightFrontMotor .setPower(-power);
        rightBackMotor  .setPower( 0.0  );
        if (sleepTime != 0){ sleep(sleepTime); moveStop(0); }
    }

    public void moveLeftTurn(int sleepTime, double power){
        telemetry       .addData("Move", "LeftTurn");
        telemetry       .update();
        leftFrontMotor  .setPower(-power);
        leftBackMotor   .setPower(-power);
        rightFrontMotor .setPower( power);
        rightBackMotor  .setPower( power);
        if (sleepTime != 0){ sleep(sleepTime); moveStop(0); }
    }

    public void moveRightTurn(int sleepTime, double power){
        telemetry       .addData("Move", "RightTurn");
        telemetry       .update();
        leftFrontMotor  .setPower( power);
        leftBackMotor   .setPower( power);
        rightFrontMotor .setPower(-power);
        rightBackMotor  .setPower(-power);
        if (sleepTime != 0){ sleep(sleepTime); moveStop(0); }
    }

    public void moveStop(int sleepTime){
        telemetry       .addData("Move", "Stop");
        telemetry       .update();
        leftFrontMotor  .setPower( 0.0  );
        leftBackMotor   .setPower( 0.0  );
        rightFrontMotor .setPower( 0.0  );
        rightBackMotor  .setPower( 0.0  );
        sleep(sleepTime);
    }

    // viperMotor function
    public void viperUp(int sleepTime, double power){
        telemetry       .addData("Viper", "Up");
        telemetry       .update();
        leftViper       .setPower( power);
        rightViper      .setPower( power);
        if (sleepTime != 0){ sleep(sleepTime); viperStop(0);}
    }

    public void viperDown(int sleepTime, double power){
        telemetry       .addData("Viper", "Down");
        telemetry       .update();
        leftViper       .setPower(-power);
        rightViper      .setPower(-power);
        if (sleepTime != 0){ sleep(sleepTime); viperStop(0);}
    }

    public void viperStop(int sleepTime){
        telemetry       .addData("Viper", "Stop");
        telemetry       .update();
        leftViper       .setPower( 0.0  );
        rightViper      .setPower( 0.0  );
        sleep(sleepTime);
    }

    // leftArmMotor function
    public void leftArmForward(int sleepTime, double power) {
        telemetry       .addData("leftArm", "Forward");
        telemetry       .update();
        leftArm         .setPower( power);
        if (sleepTime != 0) { sleep(sleepTime); leftArmStop(0); }
    }
    public void leftArmBack(int sleepTime, double power) {
        telemetry       .addData("leftArm", "Back");
        telemetry       .update();
        leftArm         .setPower(-power);
        if (sleepTime != 0) { sleep(sleepTime); leftArmStop(0); }
    }
    public void leftArmStop(int sleepTime) {
        telemetry       .addData("leftArm", "Stop");
        telemetry       .update();
        leftArm         .setPower( 0.0  );
        if (sleepTime != 0) { sleep(sleepTime); }
    }

    // rightArmMotor function
    public void rightArmForward(int sleepTime, double power) {
        telemetry       .addData("rightArm", "Forward");
        telemetry       .update();
        rightArm        .setPower( power);
        if (sleepTime != 0) { sleep(sleepTime); rightArmStop(0); }
    }
    public void rightArmBack(int sleepTime, double power) {
        telemetry       .addData("rightArm", "Back");
        telemetry       .update();
        rightArm        .setPower(-power);
        if (sleepTime != 0) { sleep(sleepTime); rightArmStop(0); }
    }
    public void rightArmStop(int sleepTime) {
        telemetry       .addData("rightArm", "Stop");
        telemetry       .update();
        rightArm        .setPower( 0.0  );
        if (sleepTime != 0) { sleep(sleepTime); }
    }

    // slideRotationServo function
    public void slideRotationUp(int sleepTime){
        telemetry               .addData("SlideRotation", "Up");
        telemetry               .update();
        leftSlideRotation       .setPosition(0.8);
        rightSlideRotation      .setPosition(0.8);
        sleep(sleepTime);
    }
    public void slideRotationDown(int sleepTime){
        telemetry               .addData("SlideRotation", "Down");
        telemetry               .update();
        leftSlideRotation       .setPosition(0.0);
        rightSlideRotation      .setPosition(0.0);
        sleep(sleepTime);
    }

    // slideRotationServo function
    public void slidePickClose(int sleepTime){
        telemetry               .addData("SlidePick", "Close");
        telemetry               .update();
        SlidePickServo          .setPosition(0.0);
        sleep(sleepTime);
    }
    public void slidePickOpen(int sleepTime){
        telemetry               .addData("SlidePick", "Open");
        telemetry               .update();
        SlidePickServo          .setPosition(0.3);
        sleep(sleepTime);
    }

    // slideRotationServo function
    public void viperPickClose(int sleepTime){
        telemetry               .addData("ViperPick", "Close");
        telemetry               .update();
        SlidePickServo          .setPosition(0.6);
        sleep(sleepTime);
    }
    public void viperPickOpen(int sleepTime){
        telemetry               .addData("ViperPick", "Open");
        telemetry               .update();
        SlidePickServo          .setPosition(0.0);
        sleep(sleepTime);
    }

    // viperServo function
    public void viperServo(int sleepTime, double rotation){ // 0.0 ~ 1.0
        telemetry               .addData("ViperServo", rotation);
        telemetry               .update();
        leftViperServo          .setPosition(rotation);
        rightViperServo         .setPosition(rotation);
        sleep(sleepTime);
    }

    // linkServo function
    public void linkServo(int sleepTime, double rotation){ // 0.0 ~ 1.0
        telemetry               .addData("LinkServo", rotation);
        telemetry               .update();
        leftLinkServo           .setPosition(rotation/2);
        rightLinkServo          .setPosition(rotation/2);
        sleep(sleepTime);
    }

    // pickUpRotation function
    public void pickUpRotationServo(int sleepTime, double rotation){ // -1.0 ~ 1.0
        double _position = ((rotation / 2) + 0.5);
        telemetry               .addData("pickUpRotation", rotation );
        telemetry               .update();
        pickUpRotation          .setPosition(_position);
        sleep(sleepTime);
    }
    // -----------------------------------------

    // run program
    @Override
    public void runOpMode() {
        // ---------------------- [init] ----------------------

        telemetry.addData("Status", "Initialized");
        telemetry.update();

        // DcMotor Mapping
        leftViper           = hardwareMap.get(DcMotor.class, "1");
        leftFrontMotor      = hardwareMap.get(DcMotor.class, "2");
        leftBackMotor       = hardwareMap.get(DcMotor.class, "3");
        leftArm             = hardwareMap.get(DcMotor.class, "4");
        rightViper          = hardwareMap.get(DcMotor.class, "5");
        rightFrontMotor     = hardwareMap.get(DcMotor.class, "6");
        rightBackMotor      = hardwareMap.get(DcMotor.class, "7");
        rightArm            = hardwareMap.get(DcMotor.class, "8");

        // DcMotor Setting Direction
        leftViper           .setDirection(DcMotor.Direction.FORWARD);
        leftFrontMotor      .setDirection(DcMotor.Direction.REVERSE);
        leftBackMotor       .setDirection(DcMotor.Direction.REVERSE);
        leftArm             .setDirection(DcMotor.Direction.REVERSE);
        rightViper          .setDirection(DcMotor.Direction.REVERSE);
        rightFrontMotor     .setDirection(DcMotor.Direction.FORWARD);
        rightBackMotor      .setDirection(DcMotor.Direction.FORWARD);
        rightArm            .setDirection(DcMotor.Direction.FORWARD);

        // Servo Motor Mapping
        leftLinkServo       = hardwareMap.get(Servo.class, "a");
        leftViperServo      = hardwareMap.get(Servo.class, "d");
        leftSlideRotation   = hardwareMap.get(Servo.class, "e");
        pickUpRotation      = hardwareMap.get(Servo.class, "f");
        rightLinkServo      = hardwareMap.get(Servo.class, "g");
        rightViperServo     = hardwareMap.get(Servo.class, "h");
        viperPickUpServo    = hardwareMap.get(Servo.class, "i");
        rightSlideRotation  = hardwareMap.get(Servo.class, "k");
        SlidePickServo      = hardwareMap.get(Servo.class, "l");

        // Servo Motor Setting Direction
        leftViperServo      .setDirection(Servo.Direction.FORWARD);
        rightViperServo     .setDirection(Servo.Direction.REVERSE);
        viperPickUpServo    .setDirection(Servo.Direction.FORWARD);
        pickUpRotation      .setDirection(Servo.Direction.FORWARD);
        leftSlideRotation   .setDirection(Servo.Direction.REVERSE);
        rightSlideRotation  .setDirection(Servo.Direction.FORWARD);
        SlidePickServo      .setDirection(Servo.Direction.FORWARD);
        leftLinkServo       .setDirection(Servo.Direction.REVERSE);
        rightLinkServo      .setDirection(Servo.Direction.FORWARD);

        // Servo Motor reset position
        viperServo              (0,0.1); // driving : 0.05 ~ 1, auto setting : 0.1
        pickUpRotationServo     (0,0.0);  // mid : 0.5, up : clockRotation
        slideRotationUp         (0);              // down : 0.0, up : 0.8
        slidePickClose          (0);              // close : 0.0, open : 0.3
        linkServo               (0,0.0);  // in 0.0 ~ out 0.5
        viperPickOpen           (0);              // pick : 0.6, open : 0.0
        sleep(1000);
        viperPickClose          (0);              // pick : 0.6, open : 0.0

        // ----------------------------------------------------

        waitForStart();
        telemetry.clearAll();
        runtime.reset();
        //autoStart();

        telemetry.addData("Status", "Initialized");
        telemetry.update();

        //allStop
        moveStop(0);
        viperStop(0);
        leftArmStop(0);
        rightArmStop(0);
        viperServo              (0,0.1);
        pickUpRotationServo     (0,0.0);
        slideRotationUp         (0);
        slidePickClose          (0);
        linkServo               (0,0.0);
        viperPickClose          (0);

        autoStart();
    }

    //------------------------------------------
    public void autoStart() {
        //여기 코드 작성 해야함
        //예시 (1000 = 1초)
        moveForward(1000, 1.0);
        moveRight(1000,1.0);
        moveBack(1000,1.0);
        moveLeft(1000,1.0);
    }
    //------------------------------------------
}