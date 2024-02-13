package org.firstinspires.ftc.teamcode.Auto;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.SubSystems.Backet;
import org.firstinspires.ftc.teamcode.SubSystems.ServoBucket;
import org.firstinspires.ftc.teamcode.SubSystems.DrivetrainForAuto;
import org.firstinspires.ftc.teamcode.SubSystems.Intake;
import static org.firstinspires.ftc.teamcode.Auto.oder.Constants.*;



@Autonomous(name="Robot: Auto For backet", group="Auto")

public class Auto_bsck_bord_test extends LinearOpMode {

    DrivetrainForAuto drivetrainForAuto = new DrivetrainForAuto();
    Intake intake = new Intake();

    Backet backet = new Backet();

    ServoBucket servoBucket = new ServoBucket();
    @Override
    public void runOpMode() throws InterruptedException {





        drivetrainForAuto.init(hardwareMap);
        intake.init(hardwareMap);
        backet.init(hardwareMap);
        servoBucket.init(hardwareMap);

        waitForStart();

        while(opModeIsActive()){
            //Strafe positive is Right
            backet.runElevator(0,-0.4,0,0);
            Thread.sleep(1500);
            Thread.sleep(1500);
            backet.runElevator(0,0,0,0);

            backet.runElevator(-1,0,0,0);
            Thread.sleep(1000);
            backet.runElevator(0,0,0,0);

            drivetrainForAuto.drive(Back_Speed, 0, 0);
            Thread.sleep(1550);
            drivetrainForAuto.drive(0, 0, 0);

            backet.runElevator(0,0,1,0);
            Thread.sleep(500);
            backet.runElevator(0,0,0,0);

            servoBucket.runServo(true,false);
            Thread.sleep(1200);
            servoBucket.runServo(false,false);
            backet.runElevator(0,0,0,1);
            Thread.sleep(200);
            backet.runElevator(0,0,0,0);
            backet.runElevator(0,0,0,1);
            Thread.sleep(300);
            backet.runElevator(0,0,0,0);
            terminateOpModeNow();
//            // 90degree rotation heading to bord area
//            drivetrain.drive( 0,0,.4);
//            Thread.sleep(1350);
//            drivetrain.drive(0,0,0);


        }
    }
}