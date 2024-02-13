package org.firstinspires.ftc.teamcode.SubSystems;

import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class ServoBucket {
    public Servo servo;

    public void runServo(boolean a, boolean b) {

        if (a){
            servo.setPosition(1);
        }
        else if(b){
            servo.setPosition(0.4);
        }

    }

    public void init(HardwareMap hardwareMap) {

        servo = hardwareMap.get(Servo.class,"servo");
    }




}