package org.firstinspires.ftc.teamcode.SubSystems;


import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class tesat_backet {

    DcMotorEx motorElevatorOne;
    DcMotorEx motorElevatorTwo;



    public void init(HardwareMap hardwareMap) {
        motorElevatorOne = hardwareMap.get(DcMotorEx.class, "motorElevatorRight");
        motorElevatorOne.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        motorElevatorTwo= hardwareMap.get(DcMotorEx.class, "motorElevatorLeft");
        motorElevatorTwo.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
    }
    public void runElevator(boolean a,boolean b){

        if (a) {
            motorElevatorOne.setTargetPosition(100);

            // Switch to RUN_TO_POSITION mode
            motorElevatorOne.setMode(DcMotor.RunMode.RUN_TO_POSITION);

            // Start the motor moving by setting the max velocity to 200 ticks per second
            motorElevatorOne.setVelocity(100);


            motorElevatorTwo.setTargetPosition(100);

            // Switch to RUN_TO_POSITION mode
            motorElevatorTwo.setMode(DcMotor.RunMode.RUN_TO_POSITION);

            // Start the motor moving by setting the max velocity to 200 ticks per second
            motorElevatorTwo.setVelocity(100);
        }
        if (b) {
            motorElevatorOne.setTargetPosition(0);

            // Switch to RUN_TO_POSITION mode
            motorElevatorOne.setMode(DcMotor.RunMode.RUN_TO_POSITION);

            // Start the motor moving by setting the max velocity to 200 ticks per second
            motorElevatorOne.setVelocity(100);

            motorElevatorTwo.setTargetPosition(0);

            // Switch to RUN_TO_POSITION mode
            motorElevatorTwo.setMode(DcMotor.RunMode.RUN_TO_POSITION);

            // Start the motor moving by setting the max velocity to 200 ticks per second
            motorElevatorTwo.setVelocity(100);
        }

    }



}
