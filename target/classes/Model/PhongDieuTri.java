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
public class PhongDieuTri {
    private int PhongID;
    private int BenhNhanID;
    private Date StartDate;
    private Date EndDate;
    private int TotalPrice;

    /**
     * @return the PhongID
     */
    public int getPhongID() {
        return PhongID;
    }

    /**
     * @param PhongID the PhongID to set
     */
    public void setPhongID(int PhongID) {
        this.PhongID = PhongID;
    }

    /**
     * @return the BenhNhanID
     */
    public int getBenhNhanID() {
        return BenhNhanID;
    }

    /**
     * @param BenhNhanID the BenhNhanID to set
     */
    public void setBenhNhanID(int BenhNhanID) {
        this.BenhNhanID = BenhNhanID;
    }

    /**
     * @return the StartDate
     */
    public Date getStartDate() {
        return StartDate;
    }

    /**
     * @param StartDate the StartDate to set
     */
    public void setStartDate(Date StartDate) {
        this.StartDate = StartDate;
    }

    /**
     * @return the EndDate
     */
    public Date getEndDate() {
        return EndDate;
    }

    /**
     * @param EndDate the EndDate to set
     */
    public void setEndDate(Date EndDate) {
        this.EndDate = EndDate;
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
