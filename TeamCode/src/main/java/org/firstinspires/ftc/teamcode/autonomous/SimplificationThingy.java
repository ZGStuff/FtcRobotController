package org.firstinspires.ftc.teamcode.autonomous;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;


@Autonomous(name = "StrafeToLine")
public class SimplificationThingy extends LinearOpMode {
    private DcMotor frontLeft;
    private DcMotor frontRight;
    private DcMotor backLeft;
    private DcMotor backRight;
    private DcMotor armBase;
    private DcMotor intakeSliderBase;
    private Servo bucket;
    @Override
    public void runOpMode() {
        frontLeft = hardwareMap.get(DcMotor.class, "frontLeft");
        frontRight = hardwareMap.get(DcMotor.class, "frontRight");
        backLeft = hardwareMap.get(DcMotor.class, "backLeft");
        backRight = hardwareMap.get(DcMotor.class, "backRight");
        armBase = hardwareMap.get(DcMotor.class, "armBase");
        intakeSliderBase = hardwareMap.get(DcMotor.class, "intakeSliderBase");
        bucket = hardwareMap.get(Servo.class, "bucket");
        frontLeft.setDirection(DcMotor.Direction.REVERSE);
        backLeft.setDirection(DcMotor.Direction.REVERSE);
        armBase.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        waitForStart();

        frontLeft.setPower(0.5);
        frontRight.setPower(-0.5);
        backRight.setPower(0.5);
        backLeft.setPower(-0.5);
        sleep(1100);
        frontLeft.setPower(0);
        frontRight.setPower(0);
        backLeft.setPower(0);
        backRight.setPower(0);
        sleep(500);
        frontLeft.setPower(-0.5);
        frontRight.setPower(0.5);
        backLeft.setPower(-0.5);
        backRight.setPower(0.5);
        sleep(500);
        frontLeft.setPower(0);
        frontRight.setPower(0);
        backLeft.setPower(0);
        backRight.setPower(0);
        sleep(100);
        frontLeft.setPower(0.5);
        frontRight.setPower(-0.5);
        backRight.setPower(0.5);
        backLeft.setPower(-0.5);
        sleep(2200);
        frontLeft.setPower(0.5);
        frontRight.setPower(0.5);
        backLeft.setPower(0.5);
        backRight.setPower(0.5);
        sleep(500);
        frontLeft.setPower(-0.5);
        frontRight.setPower(0.5);
        backRight.setPower(-0.5);
        backLeft.setPower(0.5);
        sleep(2500);
        frontLeft.setPower(0.5);
        frontRight.setPower(-0.5);
        backRight.setPower(0.5);
        backLeft.setPower(-0.5);
        sleep(2500);
        frontLeft.setPower(0.5);
        frontRight.setPower(0.5);
        backLeft.setPower(0.5);
        backRight.setPower(0.5);
        sleep(500);
        frontLeft.setPower(0.5);
        frontRight.setPower(-0.5);
        backRight.setPower(0.5);
        backLeft.setPower(-0.5);
        sleep(2500);
        frontLeft.setPower(0.5);
        frontRight.setPower(-0.5);
        backRight.setPower(0.5);
        backLeft.setPower(-0.5);
        sleep(2500);
        frontLeft.setPower(0.5);
        frontRight.setPower(0.5);
        backLeft.setPower(0.5);
        backRight.setPower(0.5);
        sleep(500);
        frontLeft.setPower(-0.5);
        frontRight.setPower(0.5);
        backRight.setPower(-0.5);
        backLeft.setPower(0.5);
        sleep(2500);
        frontLeft.setPower(-0.5);
        frontRight.setPower(-0.5);
        backLeft.setPower(-0.5);
        backRight.setPower(-0.5);
        sleep(5000);
        frontLeft.setPower(-0.5);
        frontRight.setPower(0.5);
        backRight.setPower(-0.5);
        backLeft.setPower(0.5);
        sleep(500);
    }
}
