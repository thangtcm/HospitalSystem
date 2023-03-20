/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DatabaseAccessObject_DAO;

import Model.Staff;
import java.util.List;

/**
 *
 * @author couni
 */
public interface Staff_Dao {
    
    /*Lấy tất cả nhân viên*/
    public List<Staff> getStaffList(Staff staff);
    
    public boolean AddStaff(Staff staff);
    
    public boolean Delete_Staff(int ID);
    
    public boolean Update_Staff(Staff staff);
    
    public Staff Login_Staff(Staff staff);
    
    public boolean ResignerUser(Staff staff);
    
    String ChangePassword(Staff staff, String Password);
}
