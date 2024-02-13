package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.SubSystems.Backet;
import org.firstinspires.ftc.teamcode.SubSystems.Drivetrain;
import org.firstinspires.ftc.teamcode.SubSystems.ServoBucket;
import org.firstinspires.ftc.teamcode.SubSystems.Intake;
import org.firstinspires.ftc.teamcode.SubSystems.Camera;
import org.firstinspires.ftc.teamcode.SubSystems.tesat_backet;

@TeleOp
public class Robot extends OpMode {

    Drivetrain drivetrain = new Drivetrain();
    Backet backet = new Backet();
    ServoBucket servoBucket = new ServoBucket();

    Camera camera = new Camera();

    Intake intake = new Intake();

    tesat_backet  tesat_backet = new tesat_backet();






    @Override
    public void init() {
        drivetrain.init(hardwareMap);
        backet.init(hardwareMap);
        servoBucket.init(hardwareMap);
        intake.init(hardwareMap);
       // tesat_backet.init(hardwareMap);
    }


    @Override
    public void loop() {
        drivetrain.drive(gamepad1.left_stick_y, gamepad1.left_stick_x, gamepad1.right_stick_x);
        backet.runElevator(gamepad2.left_stick_y,gamepad2.right_stick_y,gamepad2.right_trigger,gamepad2.left_trigger);
        //tesat_backet.runElevator(gamepad1.a, gamepad1.b, gamepad1.y,gamepad1.x);

        servoBucket.runServo(gamepad2.a,gamepad2.b);
        intake.run(gamepad1.left_trigger,gamepad1.right_trigger);

    }
}

