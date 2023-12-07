package org.firstinspires.ftc.teamcode.SubSystems;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;


public class Intake {

    DcMotor intake;

    public void init(HardwareMap hardwareMap) {
        intake = hardwareMap.dcMotor.get("Intake");
    }

    public void run(double Intake, double outake) {

        intake.setPower((Intake * 0.5) - outake );


    }

    //public void BasicIntake(double speed ){

    //Intake.setPower(speed);
    //}
}
