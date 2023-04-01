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
public class MedicalExamination {
    private Integer ID;
    private Patient Patient;
    private Employee Employee;
    private Date MedicalDate;
    private String Symptom;
    private String Illnesses;
    private String Note;

    /**
     * @return the ID
     */
    public Integer getID() {
        return ID;
    }

    /**
     * @param ID the ID to set
     */
    public void setID(Integer ID) {
        this.ID = ID;
    }

    /**
     * @return the Patient
     */
    public Patient getPatient() {
        return Patient;
    }

    /**
     * @param Patient the Patient to set
     */
    public void setPatient(Patient Patient) {
        this.Patient = Patient;
    }

    /**
     * @return the Employee
     */
    public Employee getEmployee() {
        return Employee;
    }

    /**
     * @param Employee the Employee to set
     */
    public void setEmployee(Employee Employee) {
        this.Employee = Employee;
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
