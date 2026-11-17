package frc.robot.subsystems.carwash;

import frc.robot.Constants.carwashConstants;

import com.ctre.phoenix6.signals.NeutralModeValue;
import com.ctre.phoenix6.controls.VelocityVoltage;
import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.signals.InvertedValue;
import com.ctre.phoenix6.configs.TalonFXConfiguration;
import com.ctre.phoenix6.CANBus;

public class CarwashIOReal implements CarwashIO {
    private TalonFX carwashMotor;

    public CarwashIOReal() {
        configureCarwash();
    }

    private final VelocityVoltage carwashPID = 
        new VelocityVoltage(0).withSlot(0).withEnableFOC(false);
    
    public void configureCarwash() {
        carwashMotor = new TalonFX(carwashConstants.CARWASH_MOTOR_ID, new CANBus("rio"));
        var carwashConfigure = new TalonFXConfiguration();
        carwashConfigure.CurrentLimits.StatorCurrentLimit = carwashConstants.CARWASH_STATOR_CURRENT_LIMIT;
        carwashConfigure.CurrentLimits.StatorCurrentLimitEnable = true;
        carwashConfigure.CurrentLimits.SupplyCurrentLimit = carwashConstants.CARWASH_SUPPLY_CURRENT_LIMIT;
        carwashConfigure.CurrentLimits.SupplyCurrentLimitEnable = true;
        carwashConfigure.MotorOutput.NeutralMode = NeutralModeValue.Coast;
        carwashConfigure.MotorOutput.Inverted = InvertedValue.CounterClockwise_Positive; // Check on the robot if this needs to be inverted or not
        carwashConfigure.Slot0.kS = 0.0;
        carwashConfigure.Slot0.kV = 0.0;
        carwashConfigure.Slot0.kP = 0.0;
        carwashConfigure.Slot0.kI = 0.0;
        carwashConfigure.Slot0.kD = 0.0;
        carwashMotor.getConfigurator().apply(carwashConfigure);
    }

    @Override
    public void setCarwashVelocity(double velocity) {
        carwashMotor.setControl(carwashPID.withVelocity(velocity));
    }

    @Override
    public void stop() {
        carwashMotor.stopMotor();
    }
}
