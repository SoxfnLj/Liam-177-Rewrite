package frc.robot;

import edu.wpi.first.wpilibj.RobotBase;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide
 * numerical or boolean
 * constants. This class should not be used for any other purpose. All constants
 * should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>
 * It is advised to statically import this class (or one of its inner classes)
 * wherever the
 * constants are needed, to reduce verbosity.
 */

public final class Constants {
    public static final Mode simMode = Mode.SIM;
    public static final Mode currentMode = RobotBase.isReal() ? Mode.REAL : simMode;

    public static enum Mode {
        // Running on a real robot
        REAL,

        // Running in simulation
        SIM,

        // Running in replay mode (Replaying from a logging file)
        REPLAY
    }

    public static class shooterConstants {
        
    }

    public static class intakeConstants {

    }

    public static class carwashConstants {
        public static final int CARWASH_MOTOR_ID = 1;
        
        public static final double CARWASH_STATOR_CURRENT_LIMIT = 50.0;
        public static final double CARWASH_SUPPLY_CURRENT_LIMIT = 20.0;

        public static final double CARWASH_FORWARD_VELOCITY = 1000.0; // Example value, adjust as needed
        public static final double CARWASH_REVERSE_VELOCITY = -1000.0; // Example value, adjust as needed
        public static final double CARWASH_OUTTAKE_VELOCITY = 500.0; // Example value, adjust as needed
    }

    public static class hoodConstants {
        
    }

    public static class hotdogConstants {
        public static final int HOTDOG_MOTOR_ID = 2; // Hotdog motor ID

        public static final double HOTDOG_STATOR_LIMIT = 50.0; // Example value, adjust as needed
        public static final double HOTDOG_SUPPLY_LIMIT = 20.0; // Example value, adjust as needed
        public static final double HOTDOG_FORWARD_VELOCITY = 1000.0; // Example value, adjust as needed
        public static final double HOTDOG_BACKWARD_VELOCITY = -1000.0; // Example value, adjust as needed
    }
}