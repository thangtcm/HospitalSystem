/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author couni
 */
public class PrescriptionDetail {
    private int ID;
    private int PrescriptionID;
    private int DrugID;
    private int Quantity;
    private int TotalPrice;

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
     * @return the PrescriptionID
     */
    public int getPrescriptionID() {
        return PrescriptionID;
    }

    /**
     * @param PrescriptionID the PrescriptionID to set
     */
    public void setPrescriptionID(int PrescriptionID) {
        this.PrescriptionID = PrescriptionID;
    }

    /**
     * @return the DrugID
     */
    public int getDrugID() {
        return DrugID;
    }

    /**
     * @param DrugID the DrugID to set
     */
    public void setDrugID(int DrugID) {
        this.DrugID = DrugID;
    }

    /**
     * @return the Quantity
     */
    public int getQuantity() {
        return Quantity;
    }

    /**
     * @param Quantity the Quantity to set
     */
    public void setQuantity(int Quantity) {
        this.Quantity = Quantity;
    }

    /**
     * @return the TotalPrice
     */
    public int getTotalPrice() {
        return TotalPrice;
    }

    /**
     * @param TotalPrice the TotalPrice to set
     */
    public void setTotalPrice(int TotalPrice) {
        this.TotalPrice = TotalPrice;
    }
    
    
}
