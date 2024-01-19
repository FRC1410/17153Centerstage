package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.robotcore.external.hardware.camera.BuiltinCameraDirection;
import org.firstinspires.ftc.robotcore.external.hardware.camera.WebcamName;
import org.firstinspires.ftc.robotcore.external.tfod.Recognition;
import org.firstinspires.ftc.teamcode.SubSystems.Drivetrain;
import org.firstinspires.ftc.teamcode.SubSystems.Intake;
import org.firstinspires.ftc.vision.VisionPortal;
import org.firstinspires.ftc.vision.tfod.TfodProcessor;

import java.util.List;


//This Is DriveTrain Code but with Autonomous

@Autonomous(name="Robot: Auto For DriveTrain", group="Auto")

public class NewAuto_with_Tensflow extends LinearOpMode {

    Drivetrain drivetrain = new Drivetrain();
    Intake intake = new Intake();

    private static final boolean USE_WEBCAM = true;  // true for webcam, false for phone camera

    private static final String TFOD_MODEL_ASSET = "red.tflite";

    private static final String TFOD_MODEL_FILE = "/sdcard/FIRST/tflitemodels/CenterStage.tflite";
    private static final String[] LABELS = {
            "BlueObject",
    };

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

        while (opModeIsActive()) {

            firstPosition = telemetryTfod();

            // Push telemetry to the Driver Station.
            telemetry.update();


            // Save CPU resources; can resume streaming when needed.
            if (gamepad1.dpad_down) {
                visionPortal.stopStreaming();
            } else if (gamepad1.dpad_up) {
                visionPortal.resumeStreaming();
            }

            // Share the CPU.
            sleep(20);

            if (firstPosition.equals("Right")) {

                //go foward to put pixle next by object
                drivetrain.drive(-.4, 0, 0);
                Thread.sleep(1650);
                drivetrain.drive(0, 0, 0);

                drivetrain.drive(0, 0, .4);
                Thread.sleep(1350);
                drivetrain.drive(0, 0, 0);

                drivetrain.drive(-.2, 0, 0);
                Thread.sleep(800);
                drivetrain.drive(0, 0, 0);

                drivetrain.drive(.2, 0, 0);
                Thread.sleep(800);
                drivetrain.drive(0, 0, 0);

                //put pixle next by object
                intake.run(0.35, 0);
                Thread.sleep(2000);
                intake.run(0, 0);

                //little bit back
                drivetrain.drive(.4, 0, 0);
                Thread.sleep(800);
                drivetrain.drive(0, 0, 0);

                drivetrain.drive(0, 0, .4);
                Thread.sleep(2700);
                drivetrain.drive(0, 0, 0);

                drivetrain.drive( 0,.4,0);
                Thread.sleep(800);
                drivetrain.drive(0,0,0);
//            // 90degree rotation heading to bord area
//            drivetrain.drive( 0,0,.4);
//            Thread.sleep(1350);
//            drivetrain.drive(0,0,0);
            }


           else if (firstPosition.equals("Center")) {
                drivetrain.drive( -.4,0,0);
                Thread.sleep(1950);
                drivetrain.drive(0,0,0);

                //put pixle next by object
                intake.run(-0.2,0);
                Thread.sleep(500);
                intake.run(0,0);

                //little bit back
                drivetrain.drive( .4,0,0);
                Thread.sleep(1000);
                drivetrain.drive(0,0,0);

                //mvoe side
                drivetrain.drive( 0,.4,0);
                Thread.sleep(1000);
                drivetrain.drive(0,0,0);

                // 90degree rotation heading to bord area
                drivetrain.drive( 0,0,.4);
                Thread.sleep(1350);
                drivetrain.drive(0,0,0);
            }
           else if (firstPosition.equals("Left")) {
                //go foward to put pixle next by object
                drivetrain.drive(-.4, 0, 0);
                Thread.sleep(1650);
                drivetrain.drive(0, 0, 0);

                drivetrain.drive(0, 0, -.4);
                Thread.sleep(1350);
                drivetrain.drive(0, 0, 0);

                drivetrain.drive(-.2, 0, 0);
                Thread.sleep(800);
                drivetrain.drive(0, 0, 0);

                drivetrain.drive(.2, 0, 0);
                Thread.sleep(800);
                drivetrain.drive(0, 0, 0);

                //put pixle next by object
                intake.run(0.35, 0);
                Thread.sleep(2000);
                intake.run(0, 0);

                //little bit back
                drivetrain.drive(.4, 0, 0);
                Thread.sleep(300);
                drivetrain.drive(0, 0, 0);

                drivetrain.drive( 0,.4,0);
                Thread.sleep(800);
                drivetrain.drive(0,0,0);


            }
            visionPortal.close();
        }
    }

    private void initTfod() {

        // Create the TensorFlow processor by using a builder.
        tfod = new TfodProcessor.Builder()
                .setModelAssetName(TFOD_MODEL_ASSET)// set parameters for custom models.
                .setModelLabels(LABELS)
                //.setIsModelTensorFlow2(true)
                //.setIsModelQuantized(true)
                //.setModelInputSize(300)
                //.setModelAspectRatio(16.0 / 9.0)

                .build();

        // Create the vision portal by using a builder.
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

            if (firstchack ==true ){
                if (x <= 150 ) {
                    position = "Left";
                }
                else if (x >= 150 && x <= 400 ) {
                    position = "Center";
                }
                else if (x >= 400 ) {
                    position = "Right";
                }

            }   // end for() loop
        }

        return position;
    }
}