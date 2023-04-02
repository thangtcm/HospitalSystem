package DatabaseAccessObject_DAO;
import java.util.ArrayList;
import Model.PrescriptionDetail;

public interface PatientService_Dao {
    public ArrayList<PatientService> getServiceList(int ID);
    
    public boolean AddServiceDetail(PatientService service);
    
    public boolean Delete_ServiceDetail(int ID);

    public Patient getServiceDetail(int ID);

    public boolean Update_ServiceDetail(PatientService service);
}
