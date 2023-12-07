package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.teamcode.SubSystems.Drivetrain;
import org.firstinspires.ftc.teamcode.SubSystems.Elevator;
import org.firstinspires.ftc.teamcode.SubSystems.ServoBucket;
import org.firstinspires.ftc.teamcode.SubSystems.Intake;

@TeleOp
public class Robot extends OpMode {

    Drivetrain drivetrain = new Drivetrain();
    Elevator elevator = new Elevator();
    ServoBucket servo = new ServoBucket();

    Intake intake = new Intake();




    @Override
    public void init() {
        drivetrain.init(hardwareMap);
        elevator.init(hardwareMap);
        servo.init(hardwareMap);
        intake.init(hardwareMap);
    }


    @Override
    public void loop() {
        drivetrain.drive(gamepad1.left_stick_y, gamepad1.left_stick_x, gamepad1.right_stick_x);
        elevator.runElevator(gamepad2.left_stick_y);
        servo.runServo(gamepad2.a,gamepad2.b,gamepad2.x);
        intake.run(gamepad1.left_trigger,gamepad1.right_trigger);

    }
}

