/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DatabaseAccessObject_DAO;

import Model.Sevices;
import java.util.List;

/**
 *
 * @author couni
 */
public interface Sevices_DAO {
    public List<Sevices> getPatientList();
    
    public boolean AddSevices(Sevices sevices);
    
    //public boolean Delete_Staff(int ID); -- 100 year can delete 1 timer
    
    public boolean Update_Drug(Sevices sevices);
    
    public List<Sevices> Search(Sevices sevices);
}
