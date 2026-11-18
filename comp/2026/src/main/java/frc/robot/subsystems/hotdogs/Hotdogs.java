package frc.robot.subsystems.hotdogs;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.hotdogConstants;

public class Hotdogs extends SubsystemBase {
    private final HotdogsIO hotdogsIO;

    public Hotdogs(HotdogsIO hotdogsIO) {
        this.hotdogsIO = hotdogsIO;
    }

    public enum HotdogState {
        IDLE,
        FORWARD, // towards carwash
        BACKWARD // towards intake
    }

    private HotdogState currentState = HotdogState.IDLE;

    public void setHotdogState(HotdogState state) {
        currentState = state;
    }

    @Override
    public void periodic() {
        switch (currentState) {
            case IDLE:
                hotdogsIO.stop();
                break;
            case FORWARD:
                hotdogsIO.setHotdogVelocity(hotdogConstants.HOTDOG_FORWARD_VELOCITY);
                break;
            case BACKWARD:
                hotdogsIO.setHotdogVelocity(hotdogConstants.HOTDOG_BACKWARD_VELOCITY);
                break;
        }
    }
}
