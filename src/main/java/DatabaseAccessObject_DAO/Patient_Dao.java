/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DatabaseAccessObject_DAO;

import Model.Patient;
import java.util.List;

/**
 *
 * @author couni
 */
public interface Patient_Dao {
    public List<Patient> getPatientList();
    
    public boolean AddPatient(Patient patient);
    
    //public boolean Delete_Staff(int ID); -- 100 year can delete 1 timer
    
    public boolean Update_Staff(Patient patient);
    
    public List<Patient> Search(Patient patient);
}
