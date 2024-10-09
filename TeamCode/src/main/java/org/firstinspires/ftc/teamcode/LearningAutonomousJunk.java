package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;


    @Autonomous(name = "LinearAuto")
    public class LearningAutonomousJunk extends LinearOpMode{
        // call all motors
        private DcMotor frontLeft;
        private DcMotor frontRight;
        private DcMotor backLeft;
        private DcMotor backRight;
        private DcMotor armBase;
        // functions for movement
        void forwardField() {
            frontLeft.setPower(0.5);
            frontRight.setPower(0.5);
            backLeft.setPower(0.5);
            backRight.setPower(0.5);
        }
        void turnRight() {
            frontLeft.setPower(0.5);
            frontRight.setPower(0);
            backLeft.setPower(0);
            backRight.setPower(0.5);
        }
        void turnLeft() {
            frontLeft.setPower(0);
            frontRight.setPower(0.5);
            backLeft.setPower(0.5);
            backRight.setPower(0);
        }
        void stopAllMotors() {
            frontLeft.setPower(0);
            frontRight.setPower(0);
            backLeft.setPower(0);
            backRight.setPower(0);
        }
        // the opmode code itself
        public void runOpMode() throws InterruptedException {
            frontLeft = hardwareMap.get(DcMotor.class, "frontLeft");
            frontRight = hardwareMap.get(DcMotor.class, "frontRight");
            backLeft = hardwareMap.get(DcMotor.class, "backLeft");
            backRight = hardwareMap.get(DcMotor.class, "backRight");
            armBase = hardwareMap.get(DcMotor.class, "armBase");
            waitForStart();
            frontLeft.setDirection(DcMotor.Direction.REVERSE);
            forwardField();
            sleep(1500);
            turnRight();
            sleep(250);
            forwardField();
            sleep(1500);
            turnRight();
            sleep(250);
            forwardField();
            sleep(1500);
            turnRight();
            sleep(250);
            forwardField();
            sleep(1500);
            turnRight();
            sleep(250);
            stopAllMotors();

        }
}
