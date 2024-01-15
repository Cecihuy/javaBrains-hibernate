package org.javabrains.koushik.dto;
import java.util.Date;
import jakarta.persistence.Basic;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.persistence.Transient;

@Entity
@Table(name = "USER_DETAILS")
public class UserDetails{    
    @Id
    private int userId;
    @Basic
    private String userName;
    @Temporal(TemporalType.DATE)
    private Date joinedDate;
    @Transient
    private String address;
    @Lob
    private String Description;

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
    
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        address = address;
    }
    public Date getJoinedDate() {
        return joinedDate;
    }
    public void setJoinedDate(Date joinedDate) {
        this.joinedDate = joinedDate;
    }
    public String getDescription() {
        return Description;
    }
    public void setDescription(String description) {
        Description = description;
    }        
}