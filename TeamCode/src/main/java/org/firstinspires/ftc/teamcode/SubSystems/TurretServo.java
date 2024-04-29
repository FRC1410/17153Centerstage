package org.firstinspires.ftc.teamcode.SubSystems;

import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class TurretServo {
    public CRServo turretServo;

    public void runServoTurret(double clockwise, double counter) {
        turretServo.setPower((clockwise * 0.3) - (counter));
    }

    public void init (HardwareMap hardwareMap) {
        turretServo = hardwareMap.get(CRServo.class, "turretServo");
    }
}
