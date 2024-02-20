package org.firstinspires.ftc.teamcode.SubSystems;

import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class ServoDrone {
    public Servo servoDrone;

    public void runServo(boolean reset_position, boolean release_position){

        if (reset_position){
            servoDrone.setPosition(-.2);
        }
        else if(release_position){
            servoDrone.setPosition(1);
        }

    }

    public void init(HardwareMap hardwareMap) {
        //Changed name to servoDrone instead of the same name in initialize
        servoDrone = hardwareMap.get(Servo.class,"servoDrone");
    }




}