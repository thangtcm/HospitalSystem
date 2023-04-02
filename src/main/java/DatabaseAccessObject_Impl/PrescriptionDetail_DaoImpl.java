package DatabaseAccessObject_Impl;

public class PrescriptionDetail_DaoImpl implements PrescriptionDetail_Dao{

    Connection conn = null;
    PreparedStatement prepStatement= null;
    ResultSet resultSet = null;
    
    public PrescriptionDetail_DaoImpl()
    {
        conn = new DBConnect().getConnection();
    }

    public ArrayList<PrescriptionDetail> getPrescriptionList(int ID);
    
    public boolean AddPrescriptionDetail(PrescriptionDetail prescription){
        String sql = "INSERT INTO [PrescriptionDetail] (PrescriptionID, DrugID, Quantity, TotalPrice) VALUES (?,?,?,?)";
        
        try{
            prepStatement = conn.prepareStatement(sql);
            int index = 1;
            prepStatement.setInt(index++, prescription.getEmployee().getID());
            prepStatement.setInt(index++, prescription.MedicalExamination().getID());
            prepStatement.setDate(index++, Convert.convertDate(prescription.getCreateTime()));
            prepStatement.setDate(index++, Convert.convertDate(prescription.getReceivedTime()));
            prepStatement.setDouble(index++, prescription.Price());
            prepStatement.setString(index++, prescription.getNote().trim());
            return prepStatement.executeUpdate() > 0;
        }
         catch (SQLException e) {
            System.out.println("Failed to add PrescriptionDetail: " + e.getMessage());
        }finally {
            try {
                if (prepStatement != null) {
                    prepStatement.close();
                }
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
        return false;
    }
    
    public boolean Delete_PrescriptionDetail(int ID){
        try {
            String query = "DELETE FROM [PrescriptionDetail] WHERE ID=?";
            prepStatement = (PreparedStatement) conn.prepareStatement(query);
            prepStatement.setInt(1, ID);
            prepStatement.executeUpdate();
        } catch (SQLException throwables) {
            System.out.println(throwables.getMessage());
        }finally {
            try {
                if (prepStatement != null) {
                    prepStatement.close();
                }
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public Patient getPrescriptionDetail(int ID);
    
    public boolean Update_PrescriptionDetail(PrescriptionDetail prescription){
        String query = "UPDATE [PrescriptionDetail] SET EmployeeID =?, MedicalExaminationID =?, CreateDate =?, ReceivedDate =?, TotalPrice =?, Note =? WHERE ID = ?";
        try{
            prepStatement = conn.prepareStatement(query);
            int index = 1;
            prepStatement.setInt(index++, prescription.getEmployee().getID());
            prepStatement.setInt(index++, prescription.MedicalExamination().getID());
            prepStatement.setDate(index++, Convert.convertDate(prescription.getCreateTime()));
            prepStatement.setDate(index++, Convert.convertDate(prescription.getReceivedTime()));
            prepStatement.setDouble(index++, prescription.Price());
            prepStatement.setString(index++, prescription.getNote().trim());
            prepStatement.setInt(index++, patient.getID());
            return prepStatement.executeUpdate() > 0;
        } catch (SQLException e)
        {
            System.out.println("Failed to add patient: " + e.getMessage());
        }finally {
            try {
                if (prepStatement != null) {
                    prepStatement.close();
                }
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
        return false;
    }
}