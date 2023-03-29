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
public class MedicalExamination {
    private int ID;
    private int PatientID;
    private int EmployeeID;
    private Date MedicalDate;
    private String Symptom;
    private String Illnesses;
    private String Note;

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
     * @return the PatientID
     */
    public int getPatientID() {
        return PatientID;
    }

    /**
     * @param PatientID the PatientID to set
     */
    public void setPatientID(int PatientID) {
        this.PatientID = PatientID;
    }

    /**
     * @return the EmployeeID
     */
    public int getEmployeeID() {
        return EmployeeID;
    }

    /**
     * @param EmployeeID the EmployeeID to set
     */
    public void setEmployeeID(int EmployeeID) {
        this.EmployeeID = EmployeeID;
    }

    /**
     * @return the MedicalDate
     */
    public Date getMedicalDate() {
        return MedicalDate;
    }

    /**
     * @param MedicalDate the MedicalDate to set
     */
    public void setMedicalDate(Date MedicalDate) {
        this.MedicalDate = MedicalDate;
    }

    /**
     * @return the Symptom
     */
    public String getSymptom() {
        return Symptom;
    }

    /**
     * @param Symptom the Symptom to set
     */
    public void setSymptom(String Symptom) {
        this.Symptom = Symptom;
    }

    /**
     * @return the Illnesses
     */
    public String getIllnesses() {
        return Illnesses;
    }

    /**
     * @param Illnesses the Illnesses to set
     */
    public void setIllnesses(String Illnesses) {
        this.Illnesses = Illnesses;
    }

    /**
     * @return the Note
     */
    public String getNote() {
        return Note;
    }

    /**
     * @param Note the Note to set
     */
    public void setNote(String Note) {
        this.Note = Note;
    }
    
    
}
