package org.firstinspires.ftc.teamcode.SubSystems;

import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class ServoDrone {
    public Servo servoDrone;

    public void runServo(boolean r, boolean l) {

        if (l){
            servoDrone.setPosition(0);
        }
        else if(l && r){
            servoDrone.setPosition(0.4);
        }

    }

    public void init(HardwareMap hardwareMap) {

        servoDrone = hardwareMap.get(Servo.class,"servo");
    }




}