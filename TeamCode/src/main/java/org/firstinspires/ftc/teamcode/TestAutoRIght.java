package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.SubSystems.Drivetrain;
import org.firstinspires.ftc.teamcode.SubSystems.Intake;


//This Is DriveTrain Code but with Autonomous

//@Autonomous(name="Robot: DriveTrain", group="Auto")

public class TestAutoRIght extends LinearOpMode {

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

            //go foward to put pixle next by object
            drivetrain.drive( -.4,0,0);
            Thread.sleep(500);
            drivetrain.drive(0,0,0);
            //put pixle next by object
            intake.run(1,0);
            Thread.sleep(2000);
            intake.run(0,0);

            //little bit back
            drivetrain.drive( .4,0,0);
            Thread.sleep(250);
            drivetrain.drive(0,0,0);

            //mvoe side
            drivetrain.drive( 0,.4,0);
            Thread.sleep(1000);
            drivetrain.drive(0,0,0);

            // 90degree rotation heading to bord area
            drivetrain.drive( 0,0,.4);
            Thread.sleep(1200);
            drivetrain.drive(0,0,0);

            drivetrain.drive( -.4,0,0);
            Thread.sleep(1200);
            drivetrain.drive(0,0,0);

            // go forward

//
//            intake.run(1,0);
//            Thread.sleep(5000);
//            intake.run(0,0);
            terminateOpModeNow();
        }
    }
}
