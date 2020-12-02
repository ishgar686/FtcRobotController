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

                    // left bumper - to close claw (front servo)


                    if(gamepad1.a){
                        intaketrue = !intaketrue;
                    }
                    if(intaketrue){
                        intake.setPower(1);
                    }
                    else if(!intaketrue){
                        intake.setPower(0);
                    }

                    if(gamepad1.b){
                        shootertrue = !shootertrue;
                    }
                    if(shootertrue){
                        shooter.setPower(1);
                    }
                    if(!shootertrue){
                        shooter.setPower(0);
                    }

                    if(gamepad1.x){
                        hoppertrue = !hoppertrue;
                    }
                    if(hoppertrue){
                        hopper.setPower(1);
                    }
                    else if(!hoppertrue){
                        hopper.setPower(0);
                    }

                    telemetry.addData("Status", "Run Time: " + runtime.toString());
                    telemetry.update();
                }
            }

        }
    }


