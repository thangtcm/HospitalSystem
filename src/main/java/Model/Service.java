/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author couni
 */
public class Service {
    private int ID;
    private String ServiceName;
    private String ServiceDescription;
    private double ServicePrice;

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
     * @return the ServiceName
     */
    public String getServiceName() {
        return ServiceName;
    }

    /**
     * @param ServiceName the ServiceName to set
     */
    public void setServiceName(String ServiceName) {
        this.ServiceName = ServiceName;
    }

    /**
     * @return the ServiceDescription
     */
    public String getServiceDescription() {
        return ServiceDescription;
    }

    /**
     * @param ServiceDescription the ServiceDescription to set
     */
    public void setServiceDescription(String ServiceDescription) {
        this.ServiceDescription = ServiceDescription;
    }

    /**
     * @return the ServicePrice
     */
    public double getServicePrice() {
        return ServicePrice;
    }

    /**
     * @param ServicePrice the ServicePrice to set
     */
    public void setServicePrice(double ServicePrice) {
        this.ServicePrice = ServicePrice;
    }
    
    
}
