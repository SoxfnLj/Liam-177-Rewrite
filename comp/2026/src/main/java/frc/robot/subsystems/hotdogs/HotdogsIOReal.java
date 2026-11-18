package frc.robot.subsystems.hotdogs;

import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.signals.NeutralModeValue;
import com.ctre.phoenix6.signals.InvertedValue;
import com.ctre.phoenix6.configs.TalonFXConfiguration;
import com.ctre.phoenix6.controls.VelocityVoltage;

import frc.robot.Constants.hotdogConstants;

public class HotdogsIOReal implements HotdogsIO {
    
    private TalonFX hotdogMotor;

    public HotdogsIOReal() {
        configureHotdogs();  
    }

    private final VelocityVoltage hotdogPID = 
        new VelocityVoltage(0).withSlot(0).withEnableFOC(false);

    public void configureHotdogs() {
        hotdogMotor = new TalonFX(hotdogConstants.HOTDOG_MOTOR_ID);
        var hotdogConfigure = new TalonFXConfiguration();
        hotdogConfigure.CurrentLimits.StatorCurrentLimit = hotdogConstants.HOTDOG_STATOR_LIMIT;
        hotdogConfigure.CurrentLimits.StatorCurrentLimitEnable = true;
        hotdogConfigure.CurrentLimits.SupplyCurrentLimit = hotdogConstants.HOTDOG_SUPPLY_LIMIT;
        hotdogConfigure.CurrentLimits.SupplyCurrentLimitEnable = true;
        hotdogConfigure.MotorOutput.NeutralMode = NeutralModeValue.Coast;
        hotdogConfigure.MotorOutput.Inverted = InvertedValue.CounterClockwise_Positive;
        hotdogConfigure.Slot0.kS = 0.0;
        hotdogConfigure.Slot0.kV = 0.0;
        hotdogConfigure.Slot0.kP = 0.0;
        hotdogConfigure.Slot0.kI = 0.0;
        hotdogConfigure.Slot0.kD = 0.0;
        hotdogMotor.getConfigurator().apply(hotdogConfigure);
    }

    @Override
    public void setHotdogVelocity(double velocity) {
        hotdogMotor.setControl(hotdogPID.withVelocity(velocity));
    }

    @Override
    public void stop() {
        hotdogMotor.stopMotor();
    }
    
}
