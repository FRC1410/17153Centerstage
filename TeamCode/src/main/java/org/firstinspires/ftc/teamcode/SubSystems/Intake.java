package org.firstinspires.ftc.teamcode.SubSystems;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;


public class Intake {

    DcMotor intake;

    public void init(HardwareMap hardwareMap) {
        intake = hardwareMap.dcMotor.get("Intake");
    }

    public void run(double outake, double Intake) {

        intake.setPower((outake *0.3)- (Intake));


    }




}
