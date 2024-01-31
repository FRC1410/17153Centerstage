package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.SubSystems.Drivetrain;
import org.firstinspires.ftc.teamcode.SubSystems.ClimbingMec;
import org.firstinspires.ftc.teamcode.SubSystems.ServoDrone;
import org.firstinspires.ftc.teamcode.SubSystems.Intake;
import org.firstinspires.ftc.teamcode.SubSystems.Camera;
import org.firstinspires.ftc.teamcode.SubSystems.tesat_backet;
import org.firstinspires.ftc.robotcore.external.hardware.camera.controls.ExposureControl;
@TeleOp
public class Robot extends OpMode {

    Drivetrain drivetrain = new Drivetrain();
    ClimbingMec elevator = new ClimbingMec();
    ServoDrone servodrone = new ServoDrone();

    Camera camera = new Camera();

    Intake intake = new Intake();

    tesat_backet tesat_backet= new tesat_backet();




    @Override
    public void init() {
        drivetrain.init(hardwareMap);
        elevator.init(hardwareMap);
        servodrone.init(hardwareMap);
        intake.init(hardwareMap);
        //tesat_backet.init(hardwareMap);
    }


    @Override
    public void loop() {
        drivetrain.drive(gamepad1.left_stick_y, gamepad1.left_stick_x, gamepad1.right_stick_x);
        elevator.runElevator(gamepad2.left_stick_y,gamepad2.right_stick_y);
        //tesat_backet.runElevator(gamepad1.a, gamepad1.b);

        servodrone.runServo(gamepad2.a,gamepad2.b,gamepad2.x);
        intake.run(gamepad1.left_trigger,gamepad1.right_trigger);

    }
}

