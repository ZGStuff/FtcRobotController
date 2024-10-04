package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

public class LearningAutonomousJunk {
    @Autonomous(name = "LinearAuto")
    public class LinearAuto extends LinearOpMode{
        private DcMotor frontLeft;
        private DcMotor frontRight;
        private DcMotor backLeft;
        private DcMotor backRight;
        public void runOpMode() throws InterruptedException {
            frontLeft = hardwareMap.get(DcMotor.class, "frontLeft");
            frontRight = hardwareMap.get(DcMotor.class, "frontRight");
            backLeft = hardwareMap.get(DcMotor.class, "backLeft");
            backRight = hardwareMap.get(DcMotor.class, "backRight");
            waitForStart();
            frontLeft.setDirection(DcMotor.Direction.REVERSE);
            frontLeft.setPower(0.5);
            frontRight.setPower(0.5);
            backLeft.setPower(0.5);
            backRight.setPower(0.5);
            sleep(1000);
            frontLeft.setPower(0.5);
            frontRight.setPower(0);
            backLeft.setPower(0);
            backRight.setPower(0.5);
            sleep(250);
            frontLeft.setPower(0.5);
            frontRight.setPower(0.5);
            backLeft.setPower(0.5);
            backRight.setPower(0.5);
            sleep(1000);
            frontLeft.setPower(0.5);
            frontRight.setPower(0);
            backLeft.setPower(0);
            backRight.setPower(0.5);
            sleep(250);
            frontLeft.setPower(0.5);
            frontRight.setPower(0.5);
            backLeft.setPower(0.5);
            backRight.setPower(0.5);
            sleep(1000);
            frontLeft.setPower(0.5);
            frontRight.setPower(0);
            backLeft.setPower(0);
            backRight.setPower(0.5);
            sleep(250);
            frontLeft.setPower(0.5);
            frontRight.setPower(0.5);
            backLeft.setPower(0.5);
            backRight.setPower(0.5);
            sleep(1000);
            frontLeft.setPower(0.5);
            frontRight.setPower(0);
            backLeft.setPower(0);
            backRight.setPower(0.5);
            sleep(250);
            frontLeft.setPower(0);
            frontRight.setPower(0);
            backLeft.setPower(0);
            backRight.setPower(0);
        }
}}
