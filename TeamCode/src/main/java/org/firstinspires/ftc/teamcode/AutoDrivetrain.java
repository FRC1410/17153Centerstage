package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.SubSystems.Drivetrain;
import org.firstinspires.ftc.teamcode.SubSystems.Intake;


//This Is DriveTrain Code but with Autonomous

@Autonomous(name="Robot: Auto For DriveTrain", group="Auto")

public class AutoDrivetrain extends LinearOpMode {

    Drivetrain drivetrain = new Drivetrain();
    Intake intake = new Intake();


    @Override
    public void runOpMode() throws InterruptedException {
        drivetrain.init(hardwareMap);
        intake.init(hardwareMap);

        waitForStart();

        while(opModeIsActive()){
            //drivetrain.EncoderDrive(.3, 1000, 1000, 1000, 1000);
            //drivetrain.EncoderDrive(0, 0, 0, 0, 0);
            drivetrain.drive(-.4,0,0);
            Thread.sleep(2000);
            drivetrain.drive(0,0,0);
            intake.run(1,0);
            Thread.sleep(5000);
            intake.run(0,0);
            terminateOpModeNow();
        }
    }
}
