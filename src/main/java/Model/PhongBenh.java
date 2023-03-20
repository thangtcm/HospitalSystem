/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author couni
 */
public class PhongBenh {

    /**
     * @return the ID
     */
    public int getID() {
        return ID;
    }

    /**
     * @return the TenPhong
     */
    public String getTenPhong() {
        return TenPhong;
    }

    /**
     * @param TenPhong the TenPhong to set
     */
    public void setTenPhong(String TenPhong) {
        this.TenPhong = TenPhong;
    }

    /**
     * @return the Mota
     */
    public String getMota() {
        return Mota;
    }

    /**
     * @param Mota the Mota to set
     */
    public void setMota(String Mota) {
        this.Mota = Mota;
    }

    /**
     * @return the LoaiPhong
     */
    public String getLoaiPhong() {
        return LoaiPhong;
    }

    /**
     * @param LoaiPhong the LoaiPhong to set
     */
    public void setLoaiPhong(String LoaiPhong) {
        this.LoaiPhong = LoaiPhong;
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
    private int ID;
    private String TenPhong;
    private String Mota;
    private String LoaiPhong;
    private int Price;
}
