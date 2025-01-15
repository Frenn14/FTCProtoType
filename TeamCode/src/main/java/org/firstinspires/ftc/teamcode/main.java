package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;

@TeleOp(name="FTC", group="OpMode")
public class main extends LinearOpMode {

    // Declare OpMode members.
    ElapsedTime runtime     = new ElapsedTime();

    // DcMotor
    DcMotor leftViper       = null;
    DcMotor leftFrontMotor  = null;
    DcMotor leftBackMotor   = null;
    DcMotor leftArm         = null;
    DcMotor rightViper      = null;
    DcMotor rightFrontMotor = null;
    DcMotor rightBackMotor  = null;
    DcMotor rightArm        = null;

    // ServoMotor
    Servo   s1              = null;
    Servo   s2              = null;
    Servo   s3              = null;
    Servo   s4              = null;
    Servo   s5              = null;
    Servo   s6              = null;
    Servo   s7              = null;
    Servo   s8              = null;
    Servo   s9              = null;

    // speed and limit
    double  maxSpeed        = 1.0;  //Driving base movement max speed
    double  speed           = 0.0;
    double  reception       = 0.2; //Controller input sensitivity

    // Driving Motor Functions
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
        leftFrontMotor  .setPower( 0.0  );
        leftBackMotor   .setPower( speed);
        rightFrontMotor .setPower( speed);
        rightBackMotor  .setPower( 0.0  );
    }

    public void moveLeftBack(){
        leftFrontMotor  .setPower(-speed);
        leftBackMotor   .setPower( 0.0  );
        rightFrontMotor .setPower( 0.0  );
        rightBackMotor  .setPower(-speed);
    }

    public void moveRightForward(){
        leftFrontMotor  .setPower( speed);
        leftBackMotor   .setPower( 0.0  );
        rightFrontMotor .setPower( 0.0  );
        rightBackMotor  .setPower( speed);
    }

    public void moveRightBack(){
        leftFrontMotor  .setPower( 0.0  );
        leftBackMotor   .setPower(-speed);
        rightFrontMotor .setPower(-speed);
        rightBackMotor  .setPower( 0.0  );
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
        leftFrontMotor  .setPower( 0.0  );
        leftBackMotor   .setPower( 0.0  );
        rightFrontMotor .setPower( 0.0  );
        rightBackMotor  .setPower( 0.0  );
    }

    // viperMotor function
    public void viperUp(){
        leftViper       .setPower( 1.0  );
        rightViper      .setPower( 1.0  );
    }

    public void viperDown(){
        leftViper       .setPower(-1.0  );
        rightViper      .setPower(-1.0  );
    }

    public void viperStop(){
        leftViper       .setPower( 0.0  );
        rightViper      .setPower( 0.0  );
    }

    // stick checking function
    public boolean checkInput(double input){
        return input >= reception || input <= 0.0-reception;
    }
    public boolean InputDirection(double input){
        return input <= 0.0;
    }

    // driving pad input
    public void driving() {
        if      ( checkInput(gamepad1.right_stick_y) && !checkInput(gamepad1.right_stick_x) &&  InputDirection(gamepad1.right_stick_y))                                            { moveForward();        }
        else if ( checkInput(gamepad1.right_stick_y) && !checkInput(gamepad1.right_stick_x) && !InputDirection(gamepad1.right_stick_y))                                            { moveBack();           }
        else if (!checkInput(gamepad1.right_stick_y) &&  checkInput(gamepad1.right_stick_x) &&  InputDirection(gamepad1.right_stick_x))                                            { moveLeft();           }
        else if (!checkInput(gamepad1.right_stick_y) &&  checkInput(gamepad1.right_stick_x) && !InputDirection(gamepad1.right_stick_x))                                            { moveRight();          }
        else if ( checkInput(gamepad1.right_stick_y) &&  checkInput(gamepad1.right_stick_x) &&  InputDirection(gamepad1.right_stick_y) &&  InputDirection(gamepad1.right_stick_x)) { moveLeftForward();    }
        else if ( checkInput(gamepad1.right_stick_y) &&  checkInput(gamepad1.right_stick_x) && !InputDirection(gamepad1.right_stick_y) &&  InputDirection(gamepad1.right_stick_x)) { moveLeftBack();       }
        else if ( checkInput(gamepad1.right_stick_y) &&  checkInput(gamepad1.right_stick_x) &&  InputDirection(gamepad1.right_stick_y) && !InputDirection(gamepad1.right_stick_x)) { moveRightForward();   }
        else if ( checkInput(gamepad1.right_stick_y) &&  checkInput(gamepad1.right_stick_x) && !InputDirection(gamepad1.right_stick_y) && !InputDirection(gamepad1.right_stick_x)) { moveRightBack();      }
        else if ( checkInput(gamepad1.left_stick_x)  &&  InputDirection(gamepad1.left_stick_x))                                                                                    { moveLeftTurn();       }
        else if ( checkInput(gamepad1.left_stick_x)  && !InputDirection(gamepad1.left_stick_x))                                                                                    { moveRightTurn();      }
        else                                                                                                                                                                       { moveStop(); }
    }

    // viper pad input
    public void viper() {
        if      (gamepad1.dpad_up)                      { viperUp();    }
        else if (gamepad1.dpad_down)                    { viperDown();  }
        else                                            { viperStop();  }
    }

    //arm pad input
    public void arm() {
        if      (gamepad1.left_bumper)                  { leftArm .setPower( 1.0);  }
        else if (gamepad1.left_trigger >= reception)    { leftArm .setPower(-1.0);  }
        else                                            { leftArm .setPower( 0.0);  }
        if      (gamepad1.right_bumper)                 { rightArm.setPower( 1.0);  }
        else if (gamepad1.right_trigger >= reception)   { rightArm.setPower(-1.0);  }
        else                                            { rightArm.setPower( 0.0);  }
    }

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
        s1                  = hardwareMap.get(Servo.class, "a");
        s2                  = hardwareMap.get(Servo.class, "b");
        s3                  = hardwareMap.get(Servo.class, "c");
        s4                  = hardwareMap.get(Servo.class, "d");
        s5                  = hardwareMap.get(Servo.class, "e");
        s6                  = hardwareMap.get(Servo.class, "f");
        s7                  = hardwareMap.get(Servo.class, "g");
        s8                  = hardwareMap.get(Servo.class, "h");
        s9                  = hardwareMap.get(Servo.class, "i");

        // Servo Motor Setting Direction
        s1                  .setDirection(Servo.Direction.REVERSE);
        s2                  .setDirection(Servo.Direction.REVERSE);
        s3                  .setDirection(Servo.Direction.REVERSE);
        s4                  .setDirection(Servo.Direction.FORWARD);
        s5                  .setDirection(Servo.Direction.FORWARD);
        s6                  .setDirection(Servo.Direction.FORWARD);
        s7                  .setDirection(Servo.Direction.FORWARD);
        s8                  .setDirection(Servo.Direction.FORWARD);
        s9                  .setDirection(Servo.Direction.FORWARD);

        // Servo Motor reset position
        s1                  .setPosition(0.0);
        s2                  .setPosition(0.0);
        s3                  .setPosition(0.0);
        s4                  .setPosition(0.0);
        s5                  .setPosition(0.0);
        s6                  .setPosition(0.0);
        s7                  .setPosition(0.0);
        s8                  .setPosition(0.0);
        s9                  .setPosition(0.0);

        // ----------------------------------------------------

        waitForStart();
        runtime.reset();

        // ---------------------- [play] ----------------------
        while (opModeIsActive()) {
            telemetry.addData("Status", "Initialized");

            // speed setting
            speed = ((gamepad1.left_stick_y / -2) + 0.5) * maxSpeed;
            telemetry.addData("Speed", speed);

            // DcMotor
            driving();
            viper();
            arm();

            telemetry.update();
        }
        // ----------------------------------------------------
    }
}