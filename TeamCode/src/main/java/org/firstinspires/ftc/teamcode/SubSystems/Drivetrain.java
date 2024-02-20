package org.firstinspires.ftc.teamcode.SubSystems;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;


public class Drivetrain {

    DcMotor motorFrontLeft;

    DcMotor motorFrontRight;
    DcMotor motorBackRight;
    DcMotor motorBackLeft;


    public void init(HardwareMap hardwareMap) {


        motorFrontLeft = hardwareMap.dcMotor.get("motorFrontLeft");
        motorFrontLeft.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        motorFrontRight = hardwareMap.dcMotor.get("motorFrontRight");
        motorFrontLeft.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        motorBackRight = hardwareMap.dcMotor.get("motorBackRight");
        motorFrontLeft.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        motorBackLeft = hardwareMap.dcMotor.get("motorBackLeft");
        motorFrontLeft.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        motorBackRight.setDirection(DcMotorSimple.Direction.REVERSE);

    }


    public void drive(double forwardBackwardMovement, double strafe, double rotation) {


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