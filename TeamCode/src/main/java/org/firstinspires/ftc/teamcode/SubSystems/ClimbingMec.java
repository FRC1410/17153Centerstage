package org.firstinspires.ftc.teamcode.SubSystems;


import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class ClimbingMec {

    DcMotor motorElevatorOne;
    DcMotor motorElevatorTwo;



    public void init(HardwareMap hardwareMap) {
        motorElevatorOne = hardwareMap.dcMotor.get("motorElevatorRight");
        motorElevatorOne.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        motorElevatorTwo = hardwareMap.dcMotor.get("motorElevatorLeft");
        motorElevatorTwo.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
    }
    public void runElevator(double powerOne,double powerTwo){
        motorElevatorOne.setPower(powerOne);
        motorElevatorTwo.setPower(powerTwo);

        if(powerOne == 0){
            motorElevatorOne.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
            motorElevatorTwo.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        }

    }



}
