package org.firstinspires.ftc.teamcode.SubSystems;


import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Backet {

    DcMotor motorElevatorOne;
    DcMotor motorElevatorTwo;
    DcMotor motorElevator;


    public void init(HardwareMap hardwareMap) {
        motorElevatorOne = hardwareMap.dcMotor.get("motorElevatorRight");
        motorElevatorOne.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        motorElevatorTwo = hardwareMap.dcMotor.get("motorElevatorLeft");
        motorElevatorTwo.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        motorElevator = hardwareMap.dcMotor.get("motorElevator");
        motorElevator.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
    }
    public void runElevator(double powerOne,double powerTwo,float Rtriger,float Ltriger){
        double powerThree = (Rtriger*0.6)-(Ltriger*0.6);
        motorElevatorOne.setPower(-powerOne*0.6);//buket
        motorElevatorTwo.setPower(powerTwo*0.4);//arm
        motorElevator.setPower(powerThree);// elevator

        if(powerOne == 0){
            motorElevatorOne.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        }
        if(powerTwo == 0){
            motorElevatorTwo.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        }
        if(powerThree == 0){
            motorElevator.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        }
    }

    public void runElevatorAuto(double powerOne,double powerTwo,float Rtriger,float Ltriger){
        double powerThree = (Rtriger)-(Ltriger);
        motorElevatorOne.setPower(-powerOne);//buket
        motorElevatorTwo.setPower(powerTwo);//arm
        motorElevator.setPower(powerThree);// elevator

        if(powerOne == 0){
            motorElevatorOne.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        }
        if(powerTwo == 0){
            motorElevatorTwo.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        }
        if(powerThree == 0){
            motorElevator.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        }
    }



}
