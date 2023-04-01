/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DatabaseAccessObject_DAO;

import Model.Service;
import java.util.List;

/**
 *
 * @author couni
 */
public interface Service_Dao {
    public List<Service> getServiceList(Service service);
    
    public boolean AddService(Service service);
    
    public void Delete_Service(int ID);
    
    public boolean Update_Service(Service service);
}
