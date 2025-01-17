package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;

@TeleOp
public class main extends LinearOpMode {

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
        telemetry.addData("Move", "Forward");
        leftFrontMotor  .setPower( power);
        leftBackMotor   .setPower( power);
        rightFrontMotor .setPower( power);
        rightBackMotor  .setPower( power);
        if (sleepTime != 0){ sleep(sleepTime); moveStop(0); }
    }

    public void moveBack(int sleepTime, double power){
        telemetry.addData("Move", "Back");
        leftFrontMotor  .setPower(-power);
        leftBackMotor   .setPower(-power);
        rightFrontMotor .setPower(-power);
        rightBackMotor  .setPower(-power);
        if (sleepTime != 0){ sleep(sleepTime); moveStop(0); }
    }

    public void moveLeft(int sleepTime, double power){
        telemetry.addData("Move", "Left");
        leftFrontMotor  .setPower(-power);
        leftBackMotor   .setPower( power);
        rightFrontMotor .setPower( power);
        rightBackMotor  .setPower(-power);
        if (sleepTime != 0){ sleep(sleepTime); moveStop(0); }
    }

    public void moveRight(int sleepTime, double power){
        telemetry.addData("Move", "Right");
        leftFrontMotor  .setPower( power);
        leftBackMotor   .setPower(-power);
        rightFrontMotor .setPower(-power);
        rightBackMotor  .setPower( power);
        if (sleepTime != 0){ sleep(sleepTime); moveStop(0); }
    }

    public void moveLeftForward(int sleepTime, double power){
        telemetry       .addData("Move", "LeftForward");
        leftFrontMotor  .setPower( 0.0  );
        leftBackMotor   .setPower( power);
        rightFrontMotor .setPower( power);
        rightBackMotor  .setPower( 0.0  );
        if (sleepTime != 0){ sleep(sleepTime); moveStop(0); }
    }

    public void moveLeftBack(int sleepTime, double power){
        telemetry       .addData("Move", "LeftBack");
        leftFrontMotor  .setPower(-power);
        leftBackMotor   .setPower( 0.0  );
        rightFrontMotor .setPower( 0.0  );
        rightBackMotor  .setPower(-power);
        if (sleepTime != 0){ sleep(sleepTime); moveStop(0); }
    }

    public void moveRightForward(int sleepTime, double power){
        telemetry       .addData("Move", "RightForward");
        leftFrontMotor  .setPower( power);
        leftBackMotor   .setPower( 0.0  );
        rightFrontMotor .setPower( 0.0  );
        rightBackMotor  .setPower( power);
        if (sleepTime != 0){ sleep(sleepTime); moveStop(0); }
    }

    public void moveRightBack(int sleepTime, double power){
        telemetry       .addData("Move", "RightBack");
        leftFrontMotor  .setPower( 0.0  );
        leftBackMotor   .setPower(-power);
        rightFrontMotor .setPower(-power);
        rightBackMotor  .setPower( 0.0  );
        if (sleepTime != 0){ sleep(sleepTime); moveStop(0); }
    }

    public void moveLeftTurn(int sleepTime, double power){
        telemetry       .addData("Move", "LeftTurn");
        leftFrontMotor  .setPower(-power);
        leftBackMotor   .setPower(-power);
        rightFrontMotor .setPower( power);
        rightBackMotor  .setPower( power);
        if (sleepTime != 0){ sleep(sleepTime); moveStop(0); }
    }

    public void moveRightTurn(int sleepTime, double power){
        telemetry       .addData("Move", "RightTurn");
        leftFrontMotor  .setPower( power);
        leftBackMotor   .setPower( power);
        rightFrontMotor .setPower(-power);
        rightBackMotor  .setPower(-power);
        if (sleepTime != 0){ sleep(sleepTime); moveStop(0); }
    }

    public void moveStop(int sleepTime){
        telemetry       .addData("Move", "Stop");
        leftFrontMotor  .setPower( 0.0  );
        leftBackMotor   .setPower( 0.0  );
        rightFrontMotor .setPower( 0.0  );
        rightBackMotor  .setPower( 0.0  );
        sleep(sleepTime);
    }

    // viperMotor function
    public void viperUp(int sleepTime, double power){
        telemetry       .addData("Viper", "Up");
        leftViper       .setPower( power);
        rightViper      .setPower( power);
        if (sleepTime != 0){ sleep(sleepTime); viperStop(0);}
    }

    public void viperDown(int sleepTime, double power){
        telemetry       .addData("Viper", "Down");
        leftViper       .setPower(-power);
        rightViper      .setPower(-power);
        if (sleepTime != 0){ sleep(sleepTime); viperStop(0);}
    }

    public void viperStop(int sleepTime){
        telemetry       .addData("Viper", "Stop");
        leftViper       .setPower( 0.0  );
        rightViper      .setPower( 0.0  );
        sleep(sleepTime);
    }

    // leftArmMotor function
    public void leftArmForward(int sleepTime, double power) {
        telemetry       .addData("leftArm", "Forward");
        leftArm         .setPower( power);
        if (sleepTime != 0) { sleep(sleepTime); leftArmStop(0); }
    }
    public void leftArmBack(int sleepTime, double power) {
        telemetry       .addData("leftArm", "Back");
        leftArm         .setPower(-power);
        if (sleepTime != 0) { sleep(sleepTime); leftArmStop(0); }
    }
    public void leftArmStop(int sleepTime) {
        telemetry       .addData("leftArm", "Stop");
        leftArm         .setPower( 0.0  );
        if (sleepTime != 0) { sleep(sleepTime); }
    }

    // rightArmMotor function
    public void rightArmForward(int sleepTime, double power) {
        telemetry       .addData("rightArm", "Forward");
        rightArm        .setPower( power);
        if (sleepTime != 0) { sleep(sleepTime); rightArmStop(0); }
    }
    public void rightArmBack(int sleepTime, double power) {
        telemetry       .addData("rightArm", "Back");
        rightArm        .setPower(-power);
        if (sleepTime != 0) { sleep(sleepTime); rightArmStop(0); }
    }
    public void rightArmStop(int sleepTime) {
        telemetry       .addData("rightArm", "Stop");
        rightArm        .setPower( 0.0  );
        if (sleepTime != 0) { sleep(sleepTime); }
    }

    // slideRotationServo function
    public void slideRotationUp(int sleepTime){
        telemetry               .addData("SlideRotation", "Up");
        leftSlideRotation       .setPosition(0.8);
        rightSlideRotation      .setPosition(0.8);
        sleep(sleepTime);
    }
    public void slideRotationDown(int sleepTime){
        telemetry               .addData("SlideRotation", "Down");
        leftSlideRotation       .setPosition(0.0);
        rightSlideRotation      .setPosition(0.0);
        sleep(sleepTime);
    }

    // slideRotationServo function
    public void slidePickClose(int sleepTime){
        telemetry               .addData("SlidePick", "Close");
        SlidePickServo          .setPosition(0.0);
        sleep(sleepTime);
    }
    public void slidePickOpen(int sleepTime){
        telemetry               .addData("SlidePick", "Open");
        SlidePickServo          .setPosition(0.3);
        sleep(sleepTime);
    }

    // slideRotationServo function
    public void viperPickClose(int sleepTime){
        telemetry               .addData("ViperPick", "Close");
        viperPickUpServo        .setPosition(0.6);
        sleep(sleepTime);
    }
    public void viperPickOpen(int sleepTime){
        telemetry               .addData("ViperPick", "Open");
        viperPickUpServo        .setPosition(0.0);
        sleep(sleepTime);
    }

    // viperServo function
    public void viperServo(int sleepTime, double rotation){ // 0.0 ~ 1.0
        telemetry               .addData("ViperServo", rotation);
        leftViperServo          .setPosition(rotation);
        rightViperServo         .setPosition(rotation);
        sleep(sleepTime);
    }

    // linkServo function
    public void linkServo(int sleepTime, double rotation){ // 0.0 ~ 1.0
        telemetry               .addData("LinkServo", rotation);
        leftLinkServo           .setPosition(rotation/2);
        rightLinkServo          .setPosition(rotation/2);
        sleep(sleepTime);
    }

    // pickUpRotation function
    public void pickUpRotationServo(int sleepTime, double rotation){ // -1.0 ~ 1.0
        double _position = ((rotation / 2) + 0.5);
        telemetry               .addData("pickUpRotation", rotation );
        pickUpRotation          .setPosition(_position);
        sleep(sleepTime);
    }
    // -----------------------------------------

    // ------- [stick check functions] ---------
    public boolean checkInput(double input){
        return input >= reception || input <= 0.0-reception;
    }
    public boolean InputDirection(double input){ // StickY = Up:True, Down:False - StickX = Left:True, Right:False
        return input <= 0.0;
    }
    public boolean stickOnlyUp   (double Y, double X){ return  checkInput(Y) && !checkInput(X) &&  InputDirection(Y); }
    public boolean stickOnlyDown (double Y, double X){ return  checkInput(Y) && !checkInput(X) && !InputDirection(Y); }
    public boolean stickOnlyLeft (double Y, double X){ return !checkInput(Y) &&  checkInput(X) &&  InputDirection(X); }
    public boolean stickOnlyRight(double Y, double X){ return !checkInput(Y) &&  checkInput(X) && !InputDirection(X); }
    public boolean stickLeftUp   (double Y, double X){ return  checkInput(Y) &&  checkInput(X) &&  InputDirection(X) &&  InputDirection(Y); }
    public boolean stickLeftDown (double Y, double X){ return  checkInput(Y) &&  checkInput(X) &&  InputDirection(X) && !InputDirection(Y); }
    public boolean stickRightUp  (double Y, double X){ return  checkInput(Y) &&  checkInput(X) && !InputDirection(X) &&  InputDirection(Y); }
    public boolean stickRightDown(double Y, double X){ return  checkInput(Y) &&  checkInput(X) && !InputDirection(X) && !InputDirection(Y); }
    // -----------------------------------------

    // -------- [pad input functions] ----------

    // driving pad input
    public void padDriving() {
        double inputY  = gamepad1.right_stick_y;
        double inputX1 = gamepad1.right_stick_x;
        double inputX2 = gamepad1.left_stick_x;

        if      (stickOnlyUp    (inputY,inputX1))                   { moveForward      (0, speed);}
        else if (stickOnlyDown  (inputY,inputX1))                   { moveBack         (0, speed);}
        else if (stickOnlyLeft  (inputY,inputX1))                   { moveLeft         (0, speed);}
        else if (stickOnlyRight (inputY,inputX1))                   { moveRight        (0, speed);}
        else if (stickLeftUp    (inputY,inputX1))                   { moveLeftForward  (0, speed);}
        else if (stickLeftDown  (inputY,inputX1))                   { moveLeftBack     (0, speed);}
        else if (stickRightUp   (inputY,inputX1))                   { moveRightForward (0, speed);}
        else if (stickRightDown (inputY,inputX1))                   { moveRightBack    (0, speed);}
        else if (checkInput(inputX2)  &&  InputDirection(inputX2))  { moveLeftTurn     (0, speed);}
        else if (checkInput(inputX2)  && !InputDirection(inputX2))  { moveRightTurn    (0, speed);}
        else                                                        { moveStop         (0       );}
    }

    // viper pad input
    public void padViper() {
        if      (gamepad1.dpad_up)                                  { viperUp          (0, 1.0);}
        else if (gamepad1.dpad_down)                                { viperDown        (0, 1.0);}
        else                                                        { viperStop        (0            );}
    }

    // arm pad input
    public void padArm() {
        if      (gamepad1.left_bumper)                              { leftArmForward    (0,1.0);}
        else if (gamepad1.left_trigger >= reception)                { leftArmBack       (0,1.0);}
        else                                                        { leftArmStop       (0           );}
        if      (gamepad1.right_bumper)                             { rightArmForward   (0,1.0);}
        else if (gamepad1.right_trigger >= reception)               { rightArmBack      (0,1.0);}
        else                                                        { rightArmStop      (0           );}
    }

    // slide rotation pad input
    public void padSlideRotation(){
        if      (gamepad2.right_bumper)                             { slideRotationDown (0);}
        else if (gamepad2.right_trigger >= reception)               { slideRotationUp   (0);}
    }

    // slide pick pad input
    public void padSlidePick(){
        if      (gamepad2.x)                                        { slidePickClose    (0);}
        else if (gamepad2.y)                                        { slidePickOpen     (0);}
    }

    // viper pick pad input
    public void padViperPick(){
        if      (gamepad2.a)                                        { viperPickClose    (0);}
        else if (gamepad2.b)                                        { viperPickOpen     (0);}
    }

    //viper servo pad input
    public void padViperServo(){
        if      (gamepad2.dpad_up)                                  { viperServo        (0,0.5);}
        else if (gamepad2.dpad_left)                                { viperServo        (0,1.0);}
        else if (gamepad2.dpad_right)                               { viperServo        (0,0.05);}
    }

    //link servo pad input
    public void padLinkServo(){
        if      (gamepad2.left_stick_y <= 0.0)                      { linkServo        (0,-gamepad2.left_stick_y);}
        else                                                        { linkServo        (0,0.0);}
    }

    //pickUpRotation pad input
    public void padPickUpRotation()                                 { pickUpRotationServo(0,-gamepad2.left_stick_x);}
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
        viperServo              (0,0.05); // driving : 0.05 ~ 1, auto setting : 0.1
        pickUpRotationServo     (0,0.0);  // mid : 0.5, up : clockRotation
        slideRotationUp         (0);              // down : 0.0, up : 0.8
        slidePickClose          (0);              // close : 0.0, open : 0.3
        linkServo               (0,0.0);  // in 0.0 ~ out 0.5
        viperPickOpen           (0);              // pick : 0.6, open : 0.0
        sleep(1000);
        viperPickClose          (0);              // pick : 0.6, open : 0.0

        // ----------------------------------------------------

        waitForStart();
        runtime.reset();
        //autoStart();

        // ---------------------- [play] ----------------------
        while (opModeIsActive()) {
            telemetry.addData("Status", "Initialized");

            // speed setting
            speed = ((gamepad1.left_stick_y / -2) + 0.5) * maxSpeed;
            telemetry.addData("Speed", speed);

            // DcMotor (GamePad1)
            padDriving();
            padViper();
            padArm();

            // Servo   (GamePad2)
            padSlideRotation();
            padSlidePick();
            padViperServo();
            padLinkServo();
            padPickUpRotation();
            padViperPick();

            telemetry.update();
        }
        // ----------------------------------------------------
    }

    //Not used by the main program
    //public void autoStart() {}
}