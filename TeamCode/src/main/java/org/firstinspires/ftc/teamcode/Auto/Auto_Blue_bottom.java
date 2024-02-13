package org.firstinspires.ftc.teamcode.Auto;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.robotcore.external.hardware.camera.BuiltinCameraDirection;
import org.firstinspires.ftc.robotcore.external.hardware.camera.WebcamName;
import org.firstinspires.ftc.robotcore.external.tfod.Recognition;
import org.firstinspires.ftc.teamcode.Auto.oder.Constants;
import org.firstinspires.ftc.teamcode.SubSystems.DrivetrainForAuto;
import org.firstinspires.ftc.teamcode.SubSystems.Intake;
import org.firstinspires.ftc.vision.VisionPortal;
import org.firstinspires.ftc.vision.tfod.TfodProcessor;
import static org.firstinspires.ftc.teamcode.Auto.oder.Constants.*;
import java.util.List;


//This Is DriveTrain Code but with Autonomous

@Autonomous(name="Robot: Auto Blue_Botom", group="Auto")

public class Auto_Blue_bottom extends LinearOpMode {

    DrivetrainForAuto drivetrain = new DrivetrainForAuto();
    Intake intake = new Intake();
    private static final boolean USE_WEBCAM = true;  // true for webcam, false for phone camera

    private static final String TFOD_MODEL_ASSET = "blue.tflite";

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

            // Share the CPU.
            sleep(20);

            if (firstPosition.equals("Right")) {

                //go foward to put pixle next by object
                //go foward to put pixle next by object
                drivetrain.drive(Forward_Speed, 0, 0);
                Thread.sleep(1550);
                drivetrain.drive(0, 0, 0);

                drivetrain.drive(0, 0, Rotation_Right_Speed);
                Thread.sleep(1450);
                drivetrain.drive(0, 0, 0);

                drivetrain.drive(Forward_Speed_slow, 0, 0);
                Thread.sleep(900);
                drivetrain.drive(0, 0, 0);

                drivetrain.drive(Back_Speed_slow, 0, 0);
                Thread.sleep(900);
                drivetrain.drive(0, 0, 0);

                //put pixle next by object
                intake.run(OuttakeSpeed, 0);
                Thread.sleep(800);
                intake.run(0, 0);







                drivetrain.drive(Back_Speed, 0, 0);
                Thread.sleep(100);
                drivetrain.drive(0, 0, 0);



                terminateOpModeNow();
            // 90degree rotation heading to bord area
            drivetrain.drive( 0,0,Rotation_Right_Speed);
            Thread.sleep(1350);
            drivetrain.drive(0,0,0);
            }


            else if (firstPosition.equals("Center")) {
                drivetrain.drive( Forward_Speed,0,0);
                Thread.sleep(1800);
                drivetrain.drive(0,0,0);

                //put pixle next by object
                intake.run(OuttakeSpeed,0);
                Thread.sleep(800);
                intake.run(0,0);






                //little bit back
                drivetrain.drive( Back_Speed,0,0);
                Thread.sleep(1800);
                drivetrain.drive(0,0,0);



                // 90degree rotation heading to bord area
                drivetrain.drive( 0,0,Rotation_Left_Speed);
                Thread.sleep(1470);
                drivetrain.drive(0,0,0);

                drivetrain.drive(Forward_Speed, 0, 0);
                Thread.sleep(1950);
                drivetrain.drive(0, 0, 0);

                intake.run(OuttakeSpeed, 0);
                Thread.sleep(2000);
                intake.run(0, 0);

                terminateOpModeNow();



            }
            else if (firstPosition.equals("Left")) {
                //go foward to put pixle next by object
                drivetrain.drive(Forward_Speed, 0, 0);
                Thread.sleep(1550);
                drivetrain.drive(0, 0, 0);

                drivetrain.drive(0, 0, Rotation_Left_Speed);
                Thread.sleep(1450);
                drivetrain.drive(0, 0, 0);

                drivetrain.drive(Forward_Speed_slow, 0, 0);
                Thread.sleep(900);
                drivetrain.drive(0, 0, 0);

                drivetrain.drive(Back_Speed_slow, 0, 0);
                Thread.sleep(900);
                drivetrain.drive(0, 0, 0);

                //put pixle next by object
                intake.run(OuttakeSpeed, 0);
                Thread.sleep(800);
                intake.run(0, 0);



                drivetrain.drive(Back_Speed, 0, 0);
                Thread.sleep(200);
                drivetrain.drive(0, 0, 0);



                terminateOpModeNow();
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

            if (firstchack ){
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