package org.firstinspires.ftc.teamcode.SubSystems;


import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class ClimbingMec {

    DcMotor motorElevatorOne;
    DcMotor motorElevatorTwo;



    public void init(HardwareMap hardwareMap) {
        motorElevatorOne = hardwareMap.dcMotor.get("motorElevatorRight");
        motorElevatorTwo = hardwareMap.dcMotor.get("motorElevatorLeft");
    }
    public void runElevator(double powerOne){
        motorElevatorOne.setPower(powerOne);
        motorElevatorTwo.setPower(-powerOne);

        if(powerOne == 0){
            motorElevatorOne.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
            motorElevatorTwo.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        }

    }



}
