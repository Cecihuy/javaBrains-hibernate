package org.javabrains.koushik.dto;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedNativeQuery;

@Entity
// @NamedQuery(name = "UserDetails.byId", query = "from UserDetails where userId = ?1")
@NamedNativeQuery(name = "UserDetails.byName", query = "select * from userdetails where userName = ?1", resultClass = UserDetails.class)
public class UserDetails{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;
    private String userName;
    
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