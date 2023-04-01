/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.sql.Date;

/**
 *
 * @author couni
 */
public class Patient {
    private Integer ID;
    private String FirstName;
    private String MiddleName;
    private String LastName;
    private Date BirthDay;
    private String Address;
    private String Gender;
    private String NumberPhone;
    private String Email;

    /**
     * @return the ID
     */
    public Integer getID() {
        return ID;
    }
    
    public void setID(Integer ID){
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

    /**
     * @return the BirthDay
     */
    public Date getBirthDay() {
        return BirthDay;
    }

    /**
     * @param BirthDay the BirthDay to set
     */
    public void setBirthDay(Date BirthDay) {
        this.BirthDay = BirthDay;
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
     * @return the NumberPhone
     */
    public String getNumberPhone() {
        return NumberPhone;
    }

    /**
     * @param NumberPhone the NumberPhone to set
     */
    public void setNumberPhone(String NumberPhone) {
        this.NumberPhone = NumberPhone;
    }

    /**
     * @return the Email
     */
    public String getEmail() {
        return Email;
    }

    /**
     * @param Email the Email to set
     */
    public void setEmail(String Email) {
        this.Email = Email;
    }
     
    public String getFullName()
    {
        return this.FirstName + " " + this.MiddleName + " " + this.LastName;
    }
    
    public Patient(){
        
    }
    
    public Patient(Integer Id, String FirstName, String MiddleName, String LastName)
    {
        this.ID = Id;
        this.FirstName = FirstName;
        this.MiddleName = MiddleName;
        this.LastName = LastName;
    }
    
}
