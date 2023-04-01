/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.Date;
import java.util.List;

/**
 *
 * @author couni
 */
public class BillService {
    private Integer ID;
    private MedicalExamination medicalExamination;
    private Employee employee;
    private Date BillDate;
    private double Price;
    private boolean Paid;
    
    
    //Get all list service
    private List<PatientService> Listservice;

    
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
     * @return the medicalExamination
     */
    public MedicalExamination getMedicalExamination() {
        return medicalExamination;
    }

    /**
     * @param medicalExamination the medicalExamination to set
     */
    public void setMedicalExamination(MedicalExamination medicalExamination) {
        this.medicalExamination = medicalExamination;
    }

    /**
     * @return the employee
     */
    public Employee getEmployee() {
        return employee;
    }

    /**
     * @param employee the employee to set
     */
    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    /**
     * @return the BillDate
     */
    public Date getBillDate() {
        return BillDate;
    }

    /**
     * @param BillDate the BillDate to set
     */
    public void setBillDate(Date BillDate) {
        this.BillDate = BillDate;
    }

    /**
     * @return the Price
     */
    public double getPrice() {
        return Price;
    }

    /**
     * @param Price the Price to set
     */
    public void setPrice(double Price) {
        this.Price = Price;
    }

    /**
     * @return the Paid
     */
    public boolean isPaid() {
        return Paid;
    }

    /**
     * @param Paid the Paid to set
     */
    public void setPaid(boolean Paid) {
        this.Paid = Paid;
    }

    /**
     * @return the Listservice
     */
    public List<PatientService> getListservice() {
        return Listservice;
    }

    /**
     * @param Listservice the Listservice to set
     */
    public void setListservice(List<PatientService> Listservice) {
        this.Listservice = Listservice;
    }
    
    
}
