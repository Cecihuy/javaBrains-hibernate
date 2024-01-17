package org.javabrains.koushik.dto;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("Bike")
public class TwoWheeler extends Vehicle {
    private String SteeringHandle;

    public String getSteeringHandle() {
        return SteeringHandle;
    }
    public void setSteeringHandle(String steeringHandle) {
        SteeringHandle = steeringHandle;
    }
}
