package org.firstinspires.ftc.teamcode.SubSystems;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;


public class DrivetrainForAuto {

    DcMotorEx motorFrontLeft;

    DcMotorEx motorFrontRight;
    DcMotorEx motorBackRight;
    DcMotorEx motorBackLeft;



    public void init(HardwareMap hardwareMap) {





        motorFrontLeft = hardwareMap.get(DcMotorEx.class, "motorFrontLeft");
        motorFrontLeft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);


        motorFrontRight = hardwareMap.get(DcMotorEx.class, "motorFrontRight");
        motorFrontRight.setMode(DcMotor.RunMode.RUN_USING_ENCODER);


        motorBackRight = hardwareMap.get(DcMotorEx.class, "motorBackRight");
        motorBackRight.setMode(DcMotor.RunMode.RUN_USING_ENCODER);


        motorBackLeft = hardwareMap.get(DcMotorEx.class, "motorBackLeft");
        motorBackLeft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        motorBackRight.setDirection(DcMotorSimple.Direction.REVERSE);



    }




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

