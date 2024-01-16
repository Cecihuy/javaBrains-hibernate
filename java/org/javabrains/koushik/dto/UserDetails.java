package org.javabrains.koushik.dto;
import java.util.ArrayList;
import java.util.Collection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "USER_DETAILS")
public class UserDetails{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;
    private String userName;
    @OneToMany(mappedBy = "user")
    private Collection<Vehicle> vehicle = new ArrayList<Vehicle>();
    
    public int getUserId() {
        return userId;
    }
    public void setUserId(int userId) {
        this.userId = userId;
    }
    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public Collection<Vehicle> getVehicle() {
        return vehicle;
    }
    public void setVehicle(Collection<Vehicle> vehicle) {
        this.vehicle = vehicle;
    }    
}