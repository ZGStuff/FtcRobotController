package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.ColorRangeSensor;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.Range;
import com.qualcomm.robotcore.hardware.Servo;

public class TeleOpStuff {


    @TeleOp(name = "TeleOpBeginnings")
    public class TeleOpBeginnings extends LinearOpMode {

        private DcMotor frontLeft;
        private DcMotor frontRight;
        private DcMotor backLeft;
        private DcMotor backRight;
        private DcMotor armBase;
        private ColorSensor colSense;
        private Servo theServo;

        // Init gamepad, motors + servo
        public void runOpMode() {
            frontLeft = hardwareMap.get(DcMotor.class, "frontLeft");
            frontRight = hardwareMap.get(DcMotor.class, "frontRight");
            backLeft = hardwareMap.get(DcMotor.class, "backLeft");
            backRight = hardwareMap.get(DcMotor.class, "backRight");
            armBase = hardwareMap.get(DcMotor.class, "armBase");
            colSense = hardwareMap.get(ColorSensor.class, "colSense");
            theServo = hardwareMap.get(Servo.class, "theServo");

            // Put initialization blocks here.
            frontLeft.setDirection(DcMotor.Direction.REVERSE);
            backLeft.setDirection(DcMotor.Direction.REVERSE);
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

                // Gamepad servo movement code
//                if (gamepad2.left_bumper) {
//                    theServo.setPosition(1);
//                } else {
//                    theServo.setPosition(0);
//                }



                // Old code below
                // double max;

                // double axial = -gamepad1.left_stick_y;
                // double lateral = gamepad1.left_stick_x;
                // double yaw = gamepad1.right_stick_x;

                // double frontLeftPwr = axial + lateral + yaw;
                // double frontRightPwr = axial - lateral - yaw;
                // double backLeftPwr = axial - lateral + yaw;
                // double backRightPwr = axial + lateral - yaw;

                // max = Math.max(Math.abs(frontLeftPwr), Math.abs(frontRightPwr));
                // max = Math.max(max, Math.abs(backLeftPwr));
                // max = Math.max(max, Math.abs(backRightPwr));

                // if (max > 1.0) {
                //   frontLeftPwr /= max;
                //   frontRightPwr /= max;
                //   backLeftPwr /= max;
                //   backRightPwr /= max;
                // }

                // frontLeft.setPower(frontLeftPwr * 0.75);
                // frontRight.setPower(frontRightPwr * 0.75);
                // backLeft.setPower(backLeftPwr * 0.75);
                // backRight.setPower(backRightPwr * 0.75);
//      if (gamepad1.left_stick_y == -1) {
//        frontLeft.setPower(0.5);
//        frontRight.setPower(0.5);
//        backLeft.setPower(-0.5);
//        backRight.setPower(-0.5);
//      } else if (gamepad1.left_stick_y == 1) {
//        frontLeft.setPower(-0.5);
//        frontRight.setPower(-0.5);
//        backLeft.setPower(0.5);
//        backRight.setPower(-0.5);
//      } else if (gamepad1.left_stick_x == -1){
//        frontLeft.setPower(-0.5);
//        frontRight.setPower(0.5);
//        backLeft.setPower(0.5);
//        backRight.setPower(0.5);
//      } else if (gamepad1.left_stick_x == 1) {
//        frontLeft.setPower(0.5);
//        frontRight.setPower(-0.5);
//        backLeft.setPower(-0.5);
//        backRight.setPower(-0.5);
//      } else {
//        frontLeft.setPower(0);
//        frontRight.setPower(0);
//        backLeft.setPower(0);
//        backRight.setPower(0);
//      }
            }
        }
    }

}
