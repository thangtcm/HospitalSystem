/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.Date;

/**
 *
 * @author couni
 */
public class Staff {

    
    private Integer ID;
    private String UserName;
    private String Password;
    private String FirstName;
    private String MiddleName;
    private String LastName;
    private Date Brithday;
    private int RoleID;
    private String Sex;
    private String Address;
    private int NumberPhonne;
    private String email;
    
     public Staff()
    {
        
    }
    
    public Staff(Staff staff)
    {
        this.ID = staff.ID;
        this.UserName = staff.UserName;
        this.Password = staff.Password;
        this.FirstName = staff.FirstName;
        this.MiddleName = staff.MiddleName;
        this.LastName = staff.LastName;
        this.Brithday = staff.Brithday;
        this.RoleID = staff.RoleID;
        this.Sex = staff.Sex;
        this.Address = staff.Address;
        this.NumberPhonne = staff.NumberPhonne;
        this.email = staff.email;
    }
    
    /**
     * @return the RoleID
     */
    public int getRoleID() {
        return RoleID;
    }

    /**
     * @param RoleID the RoleID to set
     */
    public void setRoleID(int RoleID) {
        this.RoleID = RoleID;
    }
    
    public Date getBrithday() {
        return Brithday;
    }

    public void setBrithday(Date Brithday) {
        this.Brithday = Brithday;
    }

    /**
     * @return the Sex
     */
    public String getSex() {
        return Sex;
    }

    /**
     * @param Sex the Sex to set
     */
    public void setSex(String Sex) {
        this.Sex = Sex;
    }

    /**
     * @return the Address
     */
    public String getAddress() {
        return Address;
    }

    /**
     * @param Address the Address to set
     */
    public void setAddress(String Address) {
        this.Address = Address;
    }

    /**
     * @return the NumberPhonne
     */
    public int getNumberPhonne() {
        return NumberPhonne;
    }

    /**
     * @param NumberPhonne the NumberPhonne to set
     */
    public void setNumberPhonne(int NumberPhonne) {
        this.NumberPhonne = NumberPhonne;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }
    
    
    /**
     * @return 
     */
    
    public String getUserName() {
        return UserName;
    }

    /**
     * @param userName the userName to set
     */
    public void setUserName(String userName) {
        this.UserName = userName;
    }

    /**
     * @return the Password
     */
    public String getPassword() {
        return Password;
    }

    /**
     * @param Password the Password to set
     */
    public void setPassword(String Password) {
        this.Password = Password;
    }

    
    /**
     * @return the ID
     */
    public int getID() {
        return ID;
    }

    /**
     * @param ID the ID to set
     */
    public void setID(int ID) {
        this.ID = ID;
    }

    /**
     * @return the FirstName
     */
    public String getFirstName() {
        return FirstName;
    }

    /**
     * @param FirstName the FirstName to set
     */
    public void setFirstName(String FirstName) {
        this.FirstName = FirstName;
    }

    /**
     * @return the MiddleName
     */
    public String getMiddleName() {
        return MiddleName;
    }

    /**
     * @param MiddleName the MiddleName to set
     */
    public void setMiddleName(String MiddleName) {
        this.MiddleName = MiddleName;
    }

    /**
     * @return the LastName
     */
    public String getLastName() {
        return LastName;
    }

    /**
     * @param LastName the LastName to set
     */
    public void setLastName(String LastName) {
        this.LastName = LastName;
    }
    
    public String getFullName()
    {
        return this.FirstName + " " + this.MiddleName + " " + this.LastName;
    }
}
