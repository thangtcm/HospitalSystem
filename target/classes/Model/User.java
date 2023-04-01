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
public class User {

    private Integer ID;
    private String UserName;
    private String Password;
    private String FirstName;
    private String MiddleName;
    private String LastName;
    private Date Birthday;
    private String Gender;
    private String Address;
    private String NumberPhonne;
    private String email;
    private String RoleName;
    
    public Date getBirthday() {
        return Birthday;
    }

    public void setBirthday(Date Birthday) {
        this.Birthday = Birthday;
    }

    /**
     * @return the IDRole
     */
    public String getRole() {
        return RoleName;
    }

    /**
     * @param RoleName the IDRole to set
     */
    public void setRole(String RoleName) {
        this.RoleName = RoleName;
    }

    /**
     * @return the Sex
     */
    public String getGender() {
        return Gender;
    }

    /**
     * @param Gender the Sex to set
     */
    public void setGender(String Gender) {
        this.Gender = Gender;
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
    public String getNumberPhonne() {
        return NumberPhonne;
    }

    /**
     * @param NumberPhonne the NumberPhonne to set
     */
    public void setNumberPhonne(String NumberPhonne) {
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
     */
    public User()
    {
        
    }
    
    public User(Integer ID)
    {
        this.ID = ID;
    }
    
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
