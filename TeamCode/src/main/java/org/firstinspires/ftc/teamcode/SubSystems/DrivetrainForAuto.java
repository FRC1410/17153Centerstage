package org.firstinspires.ftc.teamcode.SubSystems;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;


public class DrivetrainForAuto {

    DcMotorEx motorFrontLeft;


    DcMotorEx motorFrontRight;
    DcMotorEx motorBackRight;
    DcMotorEx motorBackLeft;



    public void init(HardwareMap hardwareMap) {





        motorFrontLeft = hardwareMap.get(DcMotorEx.class, "motorFrontLeft");//hardwareMap.dcMotor.get("motorFrontLeft");
        motorFrontLeft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);


        motorFrontRight = hardwareMap.get(DcMotorEx.class, "motorFrontRight");
        motorFrontRight.setMode(DcMotor.RunMode.RUN_USING_ENCODER);


        motorBackRight = hardwareMap.get(DcMotorEx.class, "motorBackRight");
        motorBackRight.setMode(DcMotor.RunMode.RUN_USING_ENCODER);


        motorBackLeft = hardwareMap.get(DcMotorEx.class, "motorBackLeft");
        motorBackLeft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);



    }

//    public void Autoinit(HardwareMap hardwareMap) {
//        motorFrontLeft = hardwareMap.dcMotor.get("motorFrontLeft");
//        motorFrontRight = hardwareMap.dcMotor.get("motorFrontRight");
//        motorBackRight = hardwareMap.dcMotor.get("motorBackRight");
//        motorBackLeft = hardwareMap.dcMotor.get("motorBackLeft");
//        Intake = hardwareMap.dcMotor.get("Intake");
//
//
//
//        motorFrontLeft.setDirection(DcMotorSimple.Direction.REVERSE);
//        motorBackRight.setDirection(DcMotorSimple.Direction.REVERSE);
//        motorBackLeft.setDirection(DcMotorSimple.Direction.REVERSE);
//
//        motorFrontLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
//        motorFrontRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
//        motorBackRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
//        motorBackLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
//
//        motorFrontLeft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
//        motorFrontRight.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
//        motorBackRight.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
//        motorBackLeft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
//
//
//    }


    public void drive(double forwardBackwardMovement, double strafe, double rotation) {


        double motorVelocity = 10;



        motorFrontLeft.setVelocity(motorVelocity);

        motorFrontRight.setVelocity(motorVelocity);

        motorBackRight.setVelocity(motorVelocity);

        motorBackLeft.setVelocity(motorVelocity);

        //First motor - Front Left
        motorFrontLeft.setPower(forwardBackwardMovement - strafe - rotation);

        //Second Motor - Front Right
        motorFrontRight.setPower(-forwardBackwardMovement - strafe - rotation);

        //Third Motor - Back Left
        motorBackLeft.setPower(forwardBackwardMovement + strafe - rotation);

        //Fourth Motor - Back Right
        motorBackRight.setPower(forwardBackwardMovement - strafe + rotation);

        if (forwardBackwardMovement < .05 && strafe < 0.05 && rotation < .05) {
            motorFrontLeft.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
            motorFrontRight.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
            motorBackLeft.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
            motorBackRight.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        }
    }
}

//   public void BasicDrive(double speed ){
//        motorFrontLeft.setPower(speed);
//        motorFrontRight.setPower(speed);
//        motorBackLeft.setPower(speed);
//        motorBackRight.setPower(speed);
//
//    }


//    public void EncoderDrive(double speed, int leftFrontEncoder, int rightFrontEncoder, int leftBackEncoder, int rightBackEncoder) throws InterruptedException {
//
//
//        int newFrontLeftEncoder = motorFrontLeft.getCurrentPosition() + leftFrontEncoder;
//        int newFrontRightEncoder = motorFrontRight.getCurrentPosition() + rightFrontEncoder;
//        int newBackLeftEncoder = motorBackLeft.getCurrentPosition() + leftBackEncoder;
//        int newBackRightEncoder = motorBackRight.getCurrentPosition() + rightBackEncoder;
//
//        motorFrontLeft.setTargetPosition(newFrontLeftEncoder);
//        motorFrontRight.setTargetPosition(newFrontRightEncoder);
//        motorBackLeft.setTargetPosition(newBackLeftEncoder);
//        motorBackRight.setTargetPosition(newBackRightEncoder);
//
//        motorFrontLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
//        motorFrontRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);
//        motorBackRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);
//        motorBackLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
//
//        BasicDrive(speed);
//        while (motorFrontLeft.isBusy() && motorFrontRight.isBusy() && motorBackLeft.isBusy() && motorBackRight.isBusy()) {}
//
//
//
//
//
//
//        motorFrontLeft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
//        motorFrontRight.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
//        motorBackRight.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
//        motorBackLeft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
//    }

