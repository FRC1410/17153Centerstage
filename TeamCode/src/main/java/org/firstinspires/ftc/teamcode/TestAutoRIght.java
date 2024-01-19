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
            //go foward to put pixle next by object
            drivetrain.drive( -.4,0,0);
            Thread.sleep(1650);
            drivetrain.drive(0,0,0);

            drivetrain.drive( 0,0,-.4);
            Thread.sleep(1350);
            drivetrain.drive(0,0,0);
            drivetrain.drive( -.2,0,0);
            Thread.sleep(800);
            drivetrain.drive( .2,0,0);
            Thread.sleep(800);
            drivetrain.drive(0,0,0);

            //put pixle next by object
            intake.run(0.35,0);
            Thread.sleep(2000);
            intake.run(0,0);

            //little bit back
            drivetrain.drive( .4,0,0);
            Thread.sleep(1000);
            drivetrain.drive(0,0,0);

            drivetrain.drive( 0,0,.4);
            Thread.sleep(2700);
            drivetrain.drive(0,0,0);

//            // 90degree rotation heading to bord area
//            drivetrain.drive( 0,0,.4);
//            Thread.sleep(1350);
//            drivetrain.drive(0,0,0);
            terminateOpModeNow();
        }
    }
}
