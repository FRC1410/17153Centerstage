package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.SubSystems.Drivetrain;
import org.firstinspires.ftc.teamcode.SubSystems.ClimbingMec;
import org.firstinspires.ftc.teamcode.SubSystems.ServoDrone;
import org.firstinspires.ftc.teamcode.SubSystems.Intake;

@TeleOp
public class Robot extends OpMode {

    Drivetrain drivetrain = new Drivetrain();
    ClimbingMec elevator = new ClimbingMec();
    ServoDrone servodrone = new ServoDrone();

    Intake intake = new Intake();




    @Override
    public void init() {
        drivetrain.init(hardwareMap);
        elevator.init(hardwareMap);
        servodrone.init(hardwareMap);
        intake.init(hardwareMap);
    }


    @Override
    public void loop() {
        drivetrain.drive(gamepad1.left_stick_y, gamepad1.left_stick_x, gamepad1.right_stick_x);
        elevator.runElevator(gamepad2.left_stick_y);
        servodrone.runServo(gamepad2.a,gamepad2.b,gamepad2.x);
        intake.run(gamepad1.left_trigger,gamepad1.right_trigger);

    }
}

