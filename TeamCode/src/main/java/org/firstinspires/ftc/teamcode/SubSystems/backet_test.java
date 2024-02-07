package org.firstinspires.ftc.teamcode.SubSystems;


import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class backet_test {

    DcMotorEx motorBacket;
    public Servo servoBacket;



    public void init(HardwareMap hardwareMap) {
        motorBacket = hardwareMap.get(DcMotorEx.class, "motorBacket");//hardwareMap.dcMotor.get("motorFrontLeft");
        motorBacket.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);





        servoBacket = hardwareMap.get(Servo.class,"servodrone");

    }
    public void runBacket(double speed, boolean a, boolean b){
        motorBacket.setPower(speed);
        servoBacket.setPosition(0);


        if(speed == 0){
            motorBacket.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        }


        if (a) {
            motorBacket.setTargetPosition(100);

            // Switch to RUN_TO_POSITION mode
            motorBacket.setMode(DcMotor.RunMode.RUN_TO_POSITION);

            // Start the motor moving by setting the max velocity to 200 ticks per second
            motorBacket.setVelocity(100);
        }
        if (b) {
            motorBacket.setTargetPosition(100);

            // Switch to RUN_TO_POSITION mode
            motorBacket.setMode(DcMotor.RunMode.RUN_TO_POSITION);

            // Start the motor moving by setting the max velocity to 200 ticks per second
            motorBacket.setVelocity(100);
        }



    }



}
