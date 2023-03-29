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
public class Revisit {
    private int ID;
    private int MedicalExaminationID;
    private Date RevisitDate;
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
     * @return the MedicalExaminationID
     */
    public int getMedicalExaminationID() {
        return MedicalExaminationID;
    }

    /**
     * @param MedicalExaminationID the MedicalExaminationID to set
     */
    public void setMedicalExaminationID(int MedicalExaminationID) {
        this.MedicalExaminationID = MedicalExaminationID;
    }

    /**
     * @return the RevisitDate
     */
    public Date getRevisitDate() {
        return RevisitDate;
    }

    /**
     * @param RevisitDate the RevisitDate to set
     */
    public void setRevisitDate(Date RevisitDate) {
        this.RevisitDate = RevisitDate;
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
