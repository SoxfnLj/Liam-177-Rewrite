package frc.robot.subsystems.carwash;

import org.littletonrobotics.junction.AutoLog;

public interface CarwashIO {

    @AutoLog
    class CarwashIOInputs {
    }

    void setCarwashVelocity(double velocity);
    
    void stop();
    
}
