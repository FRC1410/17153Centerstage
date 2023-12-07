package org.firstinspires.ftc.teamcode.SubSystems;


import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Elevator {

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
