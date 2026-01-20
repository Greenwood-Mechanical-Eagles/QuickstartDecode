package org.firstinspires.ftc.teamcode.pedroPathing.constants;

import com.pedropathing.localization.Localizers;
import com.pedropathing.follower.FollowerConstants;
import com.pedropathing.util.CustomFilteredPIDFCoefficients;
import com.pedropathing.util.CustomPIDFCoefficients;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

public class Constants {

  public static FollowerConstants followerConstants = new FollowerConstants()
    .mass(21.4)
    .forwardZeroPowerAcceleration(-41.278)
    .lateralZeroPowerAcceleration(-59.7819)
    .useSecondaryTranslationalPIDF(false)
    .useSecondaryHeadingPIDF(false)
    .useSecondaryDrivePIDF(false)
    .centripetalScaling(0.0005)
    .translationalPIDFCoefficients(new PIDFCoefficients(0.1, 0, 0.01, 0))
    .headingPIDFCoefficients(new PIDFCoefficients(2, 0, 0.1, 0))
    .drivePIDFCoefficients(new FilteredPIDFCoefficients(0.1, 0, 0, 0.6, 0));

  public static MecanumConstants driveConstants = new MecanumConstants()
    .leftFrontMotorName("frontLeft")
    .leftRearMotorName("backLeft")
    .rightFrontMotorName("frontRight")
    .rightRearMotorName("backRight")
    .leftFrontMotorDirection(DcMotorSimple.Direction.FORWARD)
    .leftRearMotorDirection(DcMotorSimple.Direction.FORWARD)
    .rightFrontMotorDirection(DcMotorSimple.Direction.REVERSE)
    .rightRearMotorDirection(DcMotorSimple.Direction.REVERSE)
    .xVelocity(57.8741)
    .yVelocity(52.295);

  public static PinpointConstants localizerConstants = new PinpointConstants()
            .forwardPodY(-2.5)
            .strafePodX(4.5)
            .distanceUnit(DistanceUnit.INCH)
            .hardwareMapName("pinpoint")
            .encoderResolution(GoBildaPinpointDriver.GoBildaOdometryPods.goBILDA_4_BAR_POD)
            .forwardEncoderDirection(GoBildaPinpointDriver.EncoderDirection.FORWARD)
            .strafeEncoderDirection(GoBildaPinpointDriver.EncoderDirection.FORWARD);

   /* public static DriveEncoderConstants localizerConstants = new DriveEncoderConstants()
            .rightFrontMotorName("frontRight")
            .rightRearMotorName("backRight")
            .leftRearMotorName("backLeft")
            .leftFrontMotorName("frontLeft")
            .leftFrontEncoderDirection(Encoder.FORWARD)
            .leftRearEncoderDirection(Encoder.FORWARD)
            .rightFrontEncoderDirection(Encoder.REVERSE)
            .rightRearEncoderDirection(Encoder.REVERSE)
            .robotWidth(10.5)
            .robotLength(12.25) //may be bad; fix later 
            */

  public static PathConstraints pathConstraints = new PathConstraints(
    0.995,
    500,
    1,
    1
  );

  public static Follower createFollower(HardwareMap hardwareMap) {
    return new FollowerBuilder(followerConstants, hardwareMap)
      .mecanumDrivetrain(driveConstants)
      //.driveEncoderLocalizer(localizerConstants)
      .pinpointLocalizer(localizerConstants)
      .pathConstraints(pathConstraints)
      .build();
  }
}
