package org.firstinspires.ftc.teamcode.SubSystems;

import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class ServoDrone {
    public Servo servo;

    public void runServo(boolean a, boolean b, boolean x) {

        if (a){
            servo.setPosition(.2);
        }
        else if(b){
            servo.setPosition(0.4);
        }
        else if(x) {
            servo.setPosition(.5);
        }
    }

    public void init(HardwareMap hardwareMap) {

        servo = hardwareMap.get(Servo.class,"servodrone");
    }




}