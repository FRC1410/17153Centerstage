package org.firstinspires.ftc.teamcode.Auto.fortest_junk;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.Auto.oder.Constants;
import org.firstinspires.ftc.teamcode.SubSystems.Drivetrain;
import org.firstinspires.ftc.teamcode.SubSystems.DrivetrainForAuto;
import org.firstinspires.ftc.teamcode.SubSystems.Intake;
import static org.firstinspires.ftc.teamcode.Auto.oder.Constants.*;

//This Is DriveTrain Code but with Autonomous

@Autonomous(name="Robot: Auto For DriveTrain l", group="Auto")

public class AutoDrivetrain extends LinearOpMode {

    DrivetrainForAuto drivetrainForAuto = new DrivetrainForAuto();
    Intake intake = new Intake();


    @Override
    public void runOpMode() throws InterruptedException {





        drivetrainForAuto.init(hardwareMap);
        intake.init(hardwareMap);

        waitForStart();

        while(opModeIsActive()){
            //Strafe positive is Right

            drivetrainForAuto.drive( Forward_Speed ,Right_Speed ,0);
            Thread.sleep(800);
            drivetrainForAuto.drive(0,0,0);


            //go foward to put pixle next by object
            drivetrainForAuto.drive( Forward_Speed,0,0);
            Thread.sleep(1500);
            drivetrainForAuto.drive(0,0,0);


            intake.runForAuto(0, OuttakeSpeed);
            Thread.sleep(800);
            intake.runForAuto(0, 0);


            drivetrainForAuto.drive(Back_Speed,0,0);
            Thread.sleep(1200);
            drivetrainForAuto.drive(0,0,0);


            drivetrainForAuto.drive(0,0,Rotation_Right_Speed);
            Thread.sleep(1200);
            drivetrainForAuto.drive(0,0,0);


            terminateOpModeNow();
//            // 90degree rotation heading to bord area
//            drivetrain.drive( 0,0,.4);
//            Thread.sleep(1350);
//            drivetrain.drive(0,0,0);


        }
    }
}



//
//package org.firstinspires.ftc.teamcode;
//
//        import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
//        import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
//
//        import org.firstinspires.ftc.teamcode.SubSystems.Drivetrain;
//        import org.firstinspires.ftc.teamcode.SubSystems.Intake;
//
//
////This Is DriveTrain Code but with Autonomous
//
//@Autonomous(name="Robot: Auto For DriveTrain", group="Auto")
//
//public class AutoDrivetrain extends LinearOpMode {
//
//    Drivetrain drivetrain = new Drivetrain();
//    Intake intake = new Intake();
//
//
//    @Override
//    public void runOpMode() throws InterruptedException {
//        drivetrain.init(hardwareMap);
//        intake.init(hardwareMap);
//
//        waitForStart();
//
//        while(opModeIsActive()){
//            //drivetrain.EncoderDrive(.3, 1000, 1000, 1000, 1000);
//            //drivetrain.EncoderDrive(0, 0, 0, 0, 0);
//            drivetrain.drive(-.4,0,0);
//            Thread.sleep(2000);
//            drivetrain.drive(0,0,0);
//            intake.run(1,0);
//            Thread.sleep(5000);
//            intake.run(0,0);
//            terminateOpModeNow();
//        }
//    }
//}
