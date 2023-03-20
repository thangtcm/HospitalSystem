/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DatabaseAccessObject_DAO;

import Model.Employee;
import java.util.List;

/**
 *
 * @author couni
 */
public interface Staff_Dao {
    
    /*Lấy tất cả nhân viên*/
    public List<Employee> getStaffList(Employee staff);
    
    public boolean AddStaff(Employee staff);
    
    public boolean Delete_Staff(int ID);
    
    public boolean Update_Staff(Employee staff);
    
    public Employee Login_Staff(Employee staff);
    
    public boolean ResignerUser(Employee staff);
    
    String ChangePassword(Employee staff, String Password);
}
