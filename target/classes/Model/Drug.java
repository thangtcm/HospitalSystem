/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author couni
 */
public class Drug { //Kho thuốc
    private int ID;
    private String DrugName;
    private String DrugType;
    private int Quantity;
    private int Price;
    private String Decription;

    /**
     * @return the ID
     */
    public int getID() {
        return ID;
    }
    
    /**
     * @return the MedicineName
     */
    public String getDrugType() {
        return DrugType;
    }

    /**
     * @param DrugType the MedicineName to set
     */
    public void setDrugType(String DrugType) {
        this.DrugType = DrugType;
    }

    /**
     * @return the MedicineName
     */
    public String getDrugName() {
        return DrugName;
    }

    /**
     * @param DrugName the MedicineName to set
     */
    public void setDrugName(String DrugName) {
        this.DrugName = DrugName;
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
     * @return the Price
     */
    public int getPrice() {
        return Price;
    }

    /**
     * @param Price the Price to set
     */
    public void setPrice(int Price) {
        this.Price = Price;
    }

    /**
     * @return the decryption
     */
    public String getDecription() {
        return Decription;
    }

    /**
     * @param Decription the decryption to set
     */
    public void setDecription(String Decription) {
        this.Decription = Decription;
    }
    
    
}
