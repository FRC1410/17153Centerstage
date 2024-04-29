package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.CRServo;

import org.firstinspires.ftc.teamcode.SubSystems.Backet;
import org.firstinspires.ftc.teamcode.SubSystems.Drivetrain;
import org.firstinspires.ftc.teamcode.SubSystems.ServoBucket;
import org.firstinspires.ftc.teamcode.SubSystems.Intake;
import org.firstinspires.ftc.teamcode.SubSystems.ServoDrone;
import org.firstinspires.ftc.teamcode.SubSystems.TurretServo;

@TeleOp
public class Robot extends OpMode {
    // IMPLEMENTS DIFFERENT MECHANISM
    Drivetrain drivetrain = new Drivetrain();
    Backet backet = new Backet();
    ServoBucket servoBucket = new ServoBucket();


    Intake intake = new Intake();
    ServoDrone drone = new ServoDrone();

    TurretServo turretServo = new TurretServo();







    @Override
    public void init() {
        // INITIALIZE THE MECHANISMS
        drivetrain.init(hardwareMap);
        backet.init(hardwareMap);
        servoBucket.init(hardwareMap);
        intake.init(hardwareMap);
        drone.init(hardwareMap);
        turretServo.init(hardwareMap);

    }


    @Override
    public void loop() {
        //SETS DRIVETRAIN TO GAME PAD 1 ANALOG STICKS
        drivetrain.drive(gamepad1.left_stick_y, gamepad1.left_stick_x, gamepad1.right_stick_x);

        //SETS ELEVATOR TO ANALOG STICKS ON GAMEPAD 2
        backet.runElevator(gamepad2.left_stick_y,gamepad2.right_stick_y,gamepad2.right_trigger,gamepad2.left_trigger);

        //SETS THE BUCKET OF THE ELEVATOR TO GAMEPAD 2
        servoBucket.runServoBucket(gamepad2.a,gamepad2.b);

        //SETS THE INTAKE TO THE TRIGGERS
        intake.run(gamepad1.left_trigger,gamepad1.right_trigger);

        //SETS THE RIGHT STICK TO RUN INTAKE
        intake.run(gamepad2.right_stick_y,0);

        //SETS THE PLANE TO GAMEPAD 2 (A/B) BUTTONS
        drone.runServo(gamepad2.a,gamepad2.b);

        turretServo.runServoTurret(gamepad2.left_trigger,gamepad2.right_trigger);

    }
}