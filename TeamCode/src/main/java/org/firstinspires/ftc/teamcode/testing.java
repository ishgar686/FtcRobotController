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

                    if (gamepad1.a) {
                        intake.setPower(1);
                    }

                    if (gamepad1.b) {
                        intake.setPower(0);
                    }

                    if (gamepad1.x) {
                        hopper.setPower(1);
                    }

                    if (gamepad1.y) {
                        hopper.setPower(0);
                    }
                    // left bumper - to close claw (front servo)




                    telemetry.addData("Status", "Run Time: " + runtime.toString());
                    telemetry.update();
                }
            }

        }
    }


