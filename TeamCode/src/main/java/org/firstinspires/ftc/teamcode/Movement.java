package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;

/**
 This is an abstract class that handles 4 drive train motors.
 */
abstract class Movement extends LinearOpMode
{
    protected DcMotor leftFront;
    protected DcMotor rightFront;
    protected DcMotor leftBack;
    protected DcMotor rightBack;
    protected DcMotor intake;
    protected DcMotor outtake;
    protected DcMotor hopper;
    protected Servo claw1;
    protected Servo claw2;

    public void runOpMode() {
        setupDriveMotors();
        runOpModeImpl();
    }

    public abstract void runOpModeImpl();

    protected void setupDriveMotors() {
        // Initialize the motor references for all the wheels
        // Initialize the hardware variables. Note that the strings used here as parameters

        updateTelemetryMessage("Initializing Motors");
        leftFront = hardwareMap.get(DcMotor.class, "leftFront");
        rightFront = hardwareMap.get(DcMotor.class, "rightFront");
        rightBack = hardwareMap.get(DcMotor.class, "rightBack");
        leftBack = hardwareMap.get(DcMotor.class, "leftBack");
        intake = hardwareMap.get(DcMotor.class, "intake");
        outtake = hardwareMap.get(DcMotor.class, "outtake");
        hopper = hardwareMap.get(DcMotor.class, "hopper");
        claw1 = hardwareMap.get(DcMotor.class, "claw1");
        claw2 = hardwareMap.get(DcMotor.class, "claw2");



        // Most robots need the motor on one side to be reve`rsed to drive goBackward
        // Reverse the motor that runs backwards when connected directly to the battery
        leftFront.setDirection(DcMotor.Direction.FORWARD);
        rightFront.setDirection(DcMotor.Direction.REVERSE);
        leftBack.setDirection(DcMotor.Direction.FORWARD);
        rightBack.setDirection(DcMotor.Direction.REVERSE);
        intake.setDirection(DcMotor.Direction.FORWARD);
        hopper.setDirection(DcMotor.Direction.FORWARD);
        outtake.setDirection(DcMotor.Direction.FORWARD);



    /*    */

        updateTelemetryMessage("Initialized Motors");
/*
        arm = hardwareMap.get(DcMotor.class, "Arm");
        arm.setDirection(DcMotor.Direction.FORWARD);


        rightConstruction = hardwareMap.servo.get("rightConstruction");

 */
    }

    public void stop(final String message) {
        leftFront.setPower(0.0);
        rightFront.setPower(0.0);
        rightBack.setPower(0.0);
        leftBack.setPower(0.0);

        updateTelemetryMessage(message);
    }

        public void stopWithSleep(final String message, final long duration) {
            stop(message);
            sleep(duration);
    }

    public void stopWithSleep(final long duration) {
        stop("Stopping");
        sleep(duration);
    }

    public void goBackward(final double power, final int duration) {
        leftFront.setPower(power);
        rightFront.setPower(power);
        rightBack.setPower(power);
        leftBack.setPower(power);
        sleep(duration);

        updateTelemetryMessage("Going Forward");
    }

    // Backward is same as forward with reverse power
    public void goForward(final double power, final int duration) {
        goBackward(-power, duration);
    }

    public void strafeRight(final double power, final int duration) {
        //TODO - clarify how these motor powers are distributed for strafeRight movement
        leftFront.setPower(-power);
        rightBack.setPower(-power);
        leftBack.setPower(power);
        sleep(duration);

        updateTelemetryMessage("Strafing Left");
    }

    public void strafeLeft(final double power, final int duration) {
        leftFront.setPower(power);
        rightFront.setPower(-power);
        rightBack.setPower(power);
        leftBack.setPower(-power);
        sleep(duration);

        updateTelemetryMessage("Strafing Right");
    }

    protected void updateTelemetryMessage(String message) {
        updateTelemetryMessage("Status", message);
    }

    protected void updateTelemetryMessage(String caption, String message) {
        telemetry.addData("Status", message);
        telemetry.update();
    }

    protected void turnRight(final double leftwheelsforwardpower, final double rightwheelsbackwardpower,  final int duration) {
        leftFront.setPower(leftwheelsforwardpower);
        rightFront.setPower(-rightwheelsbackwardpower);
        rightBack.setPower(-rightwheelsbackwardpower);
        leftBack.setPower(leftwheelsforwardpower);
        sleep(duration);

        updateTelemetryMessage("Turning Right");
    }

    protected void turnLeft(final double leftwheelsbackwardpower, final double rightwheelsforwardpower, final int duration) {
        leftFront.setPower(-leftwheelsbackwardpower);
        rightFront.setPower(rightwheelsforwardpower);
        rightBack.setPower(rightwheelsforwardpower);
        leftBack.setPower(-leftwheelsbackwardpower);
        sleep(duration);

        updateTelemetryMessage("Turning Left");
    }

    public void intake(final double intakepower, final int duration){
        intake.setPower(intakepower);
        sleep(duration);
    }

    public void hopper(final double hopperpower, final int duration){
        hopper.setPower(hopperpower);
        sleep(duration);
    }

    public void claw1(final double claw1position, final int duration){
        claw1.setPosition(claw1position);
        sleep(duration);
    }

    public void claw2(final double claw2position, final int duration){
        claw2.setPosition(claw2position);
        sleep(duration);
    }

/*
    public void armUp(final double armpower, final int duration) {
        arm.setPower(armpower);
        sleep(duration);

        updateTelemetryMessage("Arm going up");
    }

    public void armDown(final double armpower, final int duration) {
        armUp(-armpower, duration);
    }






    public void backServosDown() {
        rightConstruction.setPosition(0.43);
        leftConstruction.setPosition(0.35);

        updateTelemetryMessage("Foundation Servos Down");
    }

    public void backServosUp() {
        rightConstruction.setPosition(1);
        leftConstruction.setPosition(1);

        updateTelemetryMessage("Foundation Servos Up");
    }
*/
}