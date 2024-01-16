package org.javabrains.koushik.dto;
import java.util.HashSet;
import java.util.Set;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.Table;

@Entity
@Table(name = "USER_DETAILS")
public class UserDetails{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;
    private String userName;
    @ElementCollection
    @JoinTable(name = "USER_ADDRESS", joinColumns = @JoinColumn(name="USER_ID "))
    private Set<Address> listOfAddresses = new HashSet<Address>();
        
    public Set<Address> getListOfAddresses() {
        return listOfAddresses;
    }
    public void setListOfAddresses(Set<Address> listOfAddresses) {
        this.listOfAddresses = listOfAddresses;
    }
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
}