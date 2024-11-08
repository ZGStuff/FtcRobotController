package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.ColorRangeSensor;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.Range;
import com.qualcomm.robotcore.hardware.Servo;




    @TeleOp(name = "TeleOpStuff")
    public class TeleOpStuff extends LinearOpMode {

        private DcMotor frontLeft;
        private DcMotor frontRight;
        private DcMotor backLeft;
        private DcMotor backRight;
        private DcMotor armBase;
        private DcMotor intakeSliderBase;
        // private ColorSensor colSense;
        private CRServo theServo;
        private CRServo theUpAndDownServo;
        private CRServo rotaenoWha;
        private DcMotor varmClaw;

        // Init gamepad, motors + servo

        @Override
        public void runOpMode() {
            // Define all motors and servos
            frontLeft = hardwareMap.get(DcMotor.class, "frontLeft");
            frontRight = hardwareMap.get(DcMotor.class, "frontRight");
            backLeft = hardwareMap.get(DcMotor.class, "backLeft");
            backRight = hardwareMap.get(DcMotor.class, "backRight");
            armBase = hardwareMap.get(DcMotor.class, "armBase");
            intakeSliderBase = hardwareMap.get(DcMotor.class, "intakeSliderBase");
//            colSense = hardwareMap.get(ColorSensor.class, "colSense");
            theServo = hardwareMap.get(CRServo.class, "theServo");
            theUpAndDownServo = hardwareMap.get(CRServo.class, "theUpAndDownServo");
            rotaenoWha = hardwareMap.get(CRServo.class, "rotaenoWha");
            //varmClaw = hardwareMap.get(DcMotor.class, "varmClaw");
            intakeSliderBase.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
            intakeSliderBase.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
            // Variables
            int currentPos = armBase.getCurrentPosition();
            int otherPos = intakeSliderBase.getCurrentPosition();
            // Put initialization blocks here.
            frontLeft.setDirection(DcMotor.Direction.REVERSE);
            backLeft.setDirection(DcMotor.Direction.REVERSE);
            armBase.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
            // Main loop for the motors
            waitForStart();
            while (opModeIsActive()) {
                double leftFrontPower;
                double rightFrontPower;
                double leftBackPower;
                double rightBackPower;

                // Gamepad movement code
                double drive = -gamepad1.left_stick_y;
                double strafe = gamepad1.left_stick_x;
                double turn = gamepad1.right_stick_x;
                leftFrontPower = Range.clip(drive + turn + strafe, -1, 1);
                rightFrontPower = Range.clip(drive - turn - strafe, -1, 1);
                leftBackPower = Range.clip(drive + turn - strafe, -1, 1);
                rightBackPower = Range.clip(drive - turn + strafe, -1, 1);
                if (gamepad1.left_bumper) {
                    leftFrontPower /= 4;
                    leftBackPower /= 4;
                    rightFrontPower /= 4;
                    rightBackPower /= 4;
                }

                if (gamepad1.right_bumper) {
                    leftFrontPower /= 2;
                    leftBackPower /= 2;
                    rightFrontPower /= 2;
                    rightBackPower /= 2;
                }

                frontLeft.setPower(leftFrontPower);
                frontRight.setPower(rightFrontPower);
                backLeft.setPower(leftBackPower);
                backRight.setPower(rightBackPower);

               //  Gamepad servo movement code
                if (gamepad2.left_bumper) {
                    while (gamepad2.left_bumper) {
                        theServo.setPower(1);
                    }
                } else {
                    theServo.setPower(0);
                }
                if (gamepad2.right_bumper) {
                    while (gamepad2.right_bumper) {
                        theServo.setPower(-0.5);
                    }
                } else {
                    theServo.setPower(0);
                }
               // Gamepad 2 v-arm slider movement code
                if (gamepad2.dpad_up) {
                    if (currentPos < 1) {
                        armBase.setPower(1);
                    } else {
                        armBase.setPower(0);
                    }
                } else if (gamepad2.dpad_down) {
                    if (currentPos > 0) {
                        armBase.setPower(-1);
                    } else {
                        armBase.setPower(0);
                    }
                }
               // GP2 intake servo code part 2
               if (gamepad2.x) {
                   theUpAndDownServo.setPower(1);
               } else if (gamepad2.y) {
                   theUpAndDownServo.setPower(-1);
               } else {
                   theUpAndDownServo.setPower(0);
               }

               // Gamepad 2 intake slider movement code

                if (gamepad2.dpad_left) {
                    if (otherPos < 1) {
                        intakeSliderBase.setPower(0.25);
                    } else {
                        intakeSliderBase.setPower(0);
                    }
                } else if (gamepad2.dpad_right) {
                    if (otherPos >= 0.1) {
                        intakeSliderBase.setPower(-0.25);
                    } else {
                        intakeSliderBase.setPower(0);
                    }
                }
                if (gamepad2.left_trigger > 0.1){
                    rotaenoWha.setPower(1);
                } else if (gamepad2.right_trigger > 0.1){
                    rotaenoWha.setPower(-1);
                } else {
                    rotaenoWha.setPower(0);
                }
               // Gamepad 2 v-arm claw code
//                if (gamepad2.a) {
//                    varmClaw.setPower(1);
//
//                } else if (gamepad2.b) {
//                    varmClaw.setPower(-1);
//                } else {
//                    varmClaw.setPower(0);
//                }
                telemetry.addData("encoderPos", intakeSliderBase.getCurrentPosition());
                
/*
 change above code to elif?

                // Old code below
                // double max;


 Old code below
 double max;
 double axial = -gamepad1.left_stick_y;
 double lateral = gamepad1.left_stick_x;
 double yaw = gamepad1.right_stick_x;
 double frontLeftPwr = axial + lateral + yaw;
 double frontRightPwr = axial - lateral - yaw;
 double backLeftPwr = axial - lateral + yaw;
 double backRightPwr = axial + lateral - yaw;
 max = Math.max(Math.abs(frontLeftPwr), Math.abs(frontRightPwr));
 max = Math.max(max, Math.abs(backLeftPwr));
 max = Math.max(max, Math.abs(backRightPwr));
 if (max > 1.0) {
   frontLeftPwr /= max;
   frontRightPwr /= max;
   backLeftPwr /= max;
   backRightPwr /= max;
 }
 frontLeft.setPower(frontLeftPwr * 0.75);
 frontRight.setPower(frontRightPwr * 0.75);
 backLeft.setPower(backLeftPwr * 0.75);
 backRight.setPower(backRightPwr * 0.75);
      if (gamepad1.left_stick_y == -1) {
        frontLeft.setPower(0.5);
        frontRight.setPower(0.5);
        backLeft.setPower(-0.5);
        backRight.setPower(-0.5);
      } else if (gamepad1.left_stick_y == 1) {
        frontLeft.setPower(-0.5);
        frontRight.setPower(-0.5);
        backLeft.setPower(0.5);
        backRight.setPower(-0.5);
      } else if (gamepad1.left_stick_x == -1){
        frontLeft.setPower(-0.5);
        frontRight.setPower(0.5);
        backLeft.setPower(0.5);
        backRight.setPower(0.5);
      } else if (gamepad1.left_stick_x == 1) {
        frontLeft.setPower(0.5);
        frontRight.setPower(-0.5);
        backLeft.setPower(-0.5);
        backRight.setPower(-0.5);
      } else {
        frontLeft.setPower(0);
        frontRight.setPower(0);
        backLeft.setPower(0);
        backRight.setPower(0);
      }
*/


            }
        }
    }
