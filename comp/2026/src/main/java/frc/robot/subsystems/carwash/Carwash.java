package frc.robot.subsystems.carwash;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.carwashConstants;

public class Carwash extends SubsystemBase {
    private final CarwashIO io;

    public enum carwashStates {
        Idle,
        Forward, // into shooter
        Reverse, // into hopper
        Outtake
    }
    
    private carwashStates currentState = carwashStates.Idle;

    public void setCarwashState(carwashStates state) {
        currentState = state;
    }

    public Carwash(CarwashIO io) {
        this.io = io;
    }

    @Override
    public void periodic() {
        switch (currentState) {
            case Idle:
                io.stop();
                break;
            case Forward:
                io.setCarwashVelocity(carwashConstants.CARWASH_FORWARD_VELOCITY);
                break;
            case Reverse:
                io.setCarwashVelocity(carwashConstants.CARWASH_REVERSE_VELOCITY);
                break;
            case Outtake:
                io.setCarwashVelocity(carwashConstants.CARWASH_OUTTAKE_VELOCITY);
                break;
        }
    }
}
