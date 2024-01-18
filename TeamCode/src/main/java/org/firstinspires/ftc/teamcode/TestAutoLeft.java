package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.SubSystems.Drivetrain;
import org.firstinspires.ftc.teamcode.SubSystems.Intake;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import org.firstinspires.ftc.robotcore.external.hardware.camera.BuiltinCameraDirection;
import org.firstinspires.ftc.robotcore.external.hardware.camera.WebcamName;
import org.firstinspires.ftc.robotcore.external.tfod.Recognition;
import org.firstinspires.ftc.vision.VisionPortal;
import org.firstinspires.ftc.vision.tfod.TfodProcessor;

import java.util.List;

//This Is DriveTrain Code but with Autonomous

// @Autonomous(name="Robot: Auto For DriveTrain", group="Auto")

public class TestAutoLeft extends LinearOpMode {

// webcam
    private static final boolean USE_WEBCAM = true;
    private static final String TFOD_MODEL_ASSET = "blue.tflite";
    Drivetrain drivetrain = new Drivetrain();
    Intake intake = new Intake();

    private static final String[] LABELS = {
            "BlueObject",

    };
//
    private TfodProcessor tfod;

    private String position = "none";
    private Boolean firstchack = true;

    private VisionPortal visionPortal;

    private String firstPosition = "";

    @Override
    public void runOpMode() throws InterruptedException {
        initTfod();

        // Wait for the DS start button to be touched.
        telemetry.addData("DS preview on/off", "3 dots, Camera Stream");
        telemetry.addData(">", "Touch Play to start OpMode");
        telemetry.update();
        waitForStart();





        drivetrain.init(hardwareMap);
        intake.init(hardwareMap);

        waitForStart();

        while(opModeIsActive()) {

            firstPosition = telemetryTfod();

            telemetry.update();

            if (position == "Center") {
                //go foward to put pixle next by object
                drivetrain.drive(-.4, 0, 0);
                Thread.sleep(3000);
                drivetrain.drive(0, 0, 0);

                //put pixle next by object
                intake.run(-0.3, 0);
                Thread.sleep(500);
                intake.run(0, 0);

                //little bit back
                drivetrain.drive(-.4, 0, 0);
                Thread.sleep(1000);
                drivetrain.drive(0, 0, 0);

                //mvoe side
                drivetrain.drive(0, .4, 0);
                Thread.sleep(1000);
                drivetrain.drive(0, 0, 0);

                // 90degree rotation heading to bord area
                drivetrain.drive(0, 0, .4);
                Thread.sleep(1000);
                drivetrain.drive(0, 0, 0);

                // go forward
                drivetrain.drive(.4, 0, 0);
                Thread.sleep(3000);
                drivetrain.drive(0, 0, 0);
            }
        }
    }



    private void initTfod() {

        tfod = new TfodProcessor.Builder()

                .setModelAssetName(TFOD_MODEL_ASSET)
                .setModelLabels(LABELS)
                .build();

        VisionPortal.Builder builder = new VisionPortal.Builder();

        // Set the camera (webcam vs. built-in RC phone camera).
        if (USE_WEBCAM) {
            builder.setCamera(hardwareMap.get(WebcamName.class, "Webcam 1"));
        } else {
            builder.setCamera(BuiltinCameraDirection.BACK);
        }


        builder.addProcessor(tfod);

        // Build the Vision Portal, using the above settings.
        visionPortal = builder.build();

    }



    private String telemetryTfod() {

        List<Recognition> currentRecognitions = tfod.getRecognitions();
        telemetry.addData("# Objects Detected", currentRecognitions.size());

        // Step through the list of recognitions and display info for each one.
        for (Recognition recognition : currentRecognitions) {
            double x = (recognition.getLeft() + recognition.getRight()) / 2 ;
            double y = (recognition.getTop()  + recognition.getBottom()) / 2 ;

            telemetry.addData(""," ");
            telemetry.addData("Image", "%s (%.0f %% Conf.)", recognition.getLabel(), recognition.getConfidence() * 100);
            telemetry.addData("- Position", "%.0f / %.0f", x, y);

            telemetry.addData("- Size", "%.0f x %.0f", recognition.getWidth(), recognition.getHeight());

            if (firstchack == true ){
                if (x <= -3000 ) {
                    position = "Left";
                }
                else if (x >= 3000 && x <=3000 ) {
                    position = "Center";
                }
                else if (x >= 3000 ) {
                    position = "Right";
                }

            }   // end for() loop
        }

    return position;
    }

}
