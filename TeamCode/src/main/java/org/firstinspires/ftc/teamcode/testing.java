package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;

@TeleOp(name="testing", group="Linear Opmode")
public class testing extends IntakeClass {
    private ElapsedTime runtime = new ElapsedTime();

        @Override
        public void runOpModeImpl() {
            // TODO Set up frontServo in movement

            waitForStart();
            runtime.reset();


            while(opModeIsActive()) {
                while(true) {

                    if (gamepad2.a) {
                        intake.setPower(1);
                    }

                    if (gamepad2.b) {
                        intake.setPower(0);
                    }

                    if (gamepad2.x) {
                        hopper.setPower(1);
                    }

                    if (gamepad2.y) {
                        hopper.setPower(0);
                    }

                    if (gamepad1.dpad_up) {
                        outtake.setPower(1);
                    }

                    if (gamepad1.dpad_down) {
                        outtake.setPower(0);
                    }



                    // left bumper - to close claw (front servo)




                    telemetry.addData("Status", "Run Time: " + runtime.toString());
                    telemetry.update();
                }
            }

        }
    }


