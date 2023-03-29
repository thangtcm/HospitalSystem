/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DatabaseAccessObject_DAO;

import Model.Drug;
import java.util.List;

/**
 *
 * @author couni
 */
public interface Drug_DAO {
    public List<Drug> getPatientList();
    
    public boolean AddDrug(Drug drug);
    
    //public boolean Delete_Staff(int ID); -- 100 year can delete 1 timer
    
    public boolean Update_Drug(Drug drug);
    
    public List<Drug> Search(Drug drug);
}
