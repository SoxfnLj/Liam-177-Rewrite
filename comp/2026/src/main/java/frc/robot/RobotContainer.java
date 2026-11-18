package frc.robot;

import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import frc.robot.subsystems.drive.Drive;
import frc.robot.subsystems.drive.GyroIOPigeon2;
import frc.robot.subsystems.drive.ModuleIOTalonFX;
import frc.robot.subsystems.vision.Vision;
import frc.robot.subsystems.carwash.Carwash;
import frc.robot.subsystems.carwash.CarwashIO;
import frc.robot.subsystems.carwash.CarwashIOReal;
import frc.robot.subsystems.hotdogs.Hotdogs;
import frc.robot.subsystems.hotdogs.HotdogsIO;
import frc.robot.subsystems.hotdogs.HotdogsIOReal;

import frc.robot.Constants;

import frc.robot.commands.DriveCommands;
import frc.robot.generated.TunerConstants;


public class RobotContainer {
    // The robot's subsystems and commands are defined here
    private final RobotState robotState;
    public final Vision vision;
    public final Drive drive;
    public final Carwash carwash;
    public final Hotdogs hotdogs;

    // Replace with type of controller if needed
    private final CommandXboxController driverController = new CommandXboxController(0);
    private final CommandXboxController operatorController = new CommandXboxController(1);

    public RobotContainer() {
        switch (Constants.currentMode) {
            case REAL:
            robotState = new RobotState();
            carwash = new Carwash(new CarwashIOReal());
            break;

            case SIM:
            break;

            default:
            break;
        }

    }

    private void configureControllerBindings() {
        // Configure your trigger bindings here

        // Drive commands
        drive.setDefaultCommand(DriveCommands.joystickDrive(
            drive,
            () -> -driverController.getLeftY(),
            () -> -driverController.getLeftX(),
            () -> -driverController.getRightX()));
    }
}
