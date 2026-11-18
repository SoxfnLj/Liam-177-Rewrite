package frc.robot.subsystems.hotdogs;

import org.littletonrobotics.junction.AutoLog;


public interface HotdogsIO {
    @AutoLog
    public class HotdogsIOInputs {

    }
    void setHotdogVelocity(double in);
    
    void stop();

}
