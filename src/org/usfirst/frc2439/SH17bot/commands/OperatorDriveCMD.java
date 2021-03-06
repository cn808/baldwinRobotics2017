// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc2439.SH17bot.commands;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc2439.SH17bot.Robot;
import org.usfirst.frc2439.SH17bot.RobotMap;
import org.usfirst.frc2439.SH17bot.OI;
import org.usfirst.frc2439.SH17bot.subsystems.DriveTrain;

/**
 *
 */
public class OperatorDriveCMD extends Command {

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_DECLARATIONS
 
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_DECLARATIONS

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTOR
    public OperatorDriveCMD() {

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTOR
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_SETTING

        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_SETTING
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
        requires(Robot.driveTrain);

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.oi.jS1.setAxisChannel(Joystick.AxisType.kZ, 3);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	double x =		Robot.oi.jS1.getX();
    	double y = 		Robot.oi.jS1.getY();
    	double z =		Robot.oi.jS1.getZ();
    	System.out.println("x="+x+"  y="+y+"   Twist="+z);
       	RobotMap.driveTrainControl.mecanumDrive_Cartesian(x,y,z,0);
       	// debug System.out.println("Enc reading: " + RobotMap.driveTrainLeftENC.get());
}

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
