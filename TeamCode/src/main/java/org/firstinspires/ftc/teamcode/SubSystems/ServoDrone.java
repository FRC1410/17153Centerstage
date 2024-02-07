package org.firstinspires.ftc.teamcode.SubSystems;

import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class ServoDrone {
    public CRServo servo;

    public void runServo(boolean a, boolean b, boolean x) {

        if (a){
            servo.setPower(1);
        }
        else if(x) {
            servo.setPower(-1);
        }
        else{
            servo.setPower(0);
        }    }

    public void init(HardwareMap hardwareMap) {

        servo = hardwareMap.get(CRServo.class,"servodrone");
    }




}