/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DatabaseAccessObject_Impl;

import DatabaseAccessObject_DAO.Patient_Dao;
import Model.Patient;
import dao.Convert;
import dao.DBConnect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author couni
 */
public class Patient_DaoImpl implements Patient_Dao{
    
//    Connection connection = null;
    
    @Override
    public List<Patient> getPatientList(){
        List<Patient> list = new ArrayList<>();

        /*
         * Default: displays all student information
         */
        //StringBuilder SQL_GetStaffInformation = new StringBuilder("SELECT * FROM [Patient]");
        String sql = "SELECT * FROM [Patient]";
        
        //ResultSet rs = prst.executeQuery(sql);

        /*------------------------------------------------------------------------
         * getStudent_name() : Get it from the information entered by the user.  |
         * -----------------------------------------------------------------------
         */
//        if (!patient.getFullName().isEmpty())
//        {
//                // If 'getStudent_name()' is null ¡ª¡ª> false (Not execute)
//            SQL_GetStaffInformation.append(" AND FirstName LIKE '%").append(patient.getFirstName()).append("%' ")
//                    .append(" AND MiddleName LIKE '%").append(patient.getMiddleName()).append("%' ")
//                    .append(" AND LastName LIKE '%").append(patient.getLastName()).append("%' ")
//                    .append("AND ID LIKE '%").append(patient.getID()).append("%' ");
//        }

        try(Connection connection = DBConnect.getConnection();
            //PreparedStatement preparedStatement = connection.prepareStatement(SQL_GetStaffInformation.toString().replaceFirst("AND","WHERE"));
            Statement prst = connection.createStatement();
            ResultSet resultSet = prst.executeQuery(sql);
        ){
            
            while (resultSet.next())
            {
                Patient table_Patient = new Patient();
                table_Patient.setID(resultSet.getInt("ID"));
                table_Patient.setFirstName(resultSet.getString("FirstName").trim());
                table_Patient.setMiddleName(resultSet.getString("MiddleName").trim());
                table_Patient.setLastName(resultSet.getString("LastName").trim());
                table_Patient.setBirthDay(resultSet.getDate("Birthday"));
                table_Patient.setGender(resultSet.getString("Gender").trim());
                table_Patient.setAddress(resultSet.getString("Address").trim());
                table_Patient.setEmail(resultSet.getString("Email").trim());
                table_Patient.setNumberPhone(resultSet.getString("NumberPhone").trim());
                list.add(table_Patient);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return list;
     }
    
    @Override
    public boolean AddPatient(Patient patient){
//        PreparedStatement preparedStatement = null;
        String SQL_AddStaff = "INSERT INTO [Patient] VALUES (?,?,?,?,?,?,?,?,?)";
        
        try(Connection connection = DBConnect.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_AddStaff);
            ){
            int index = 1;
            preparedStatement.setInt(index++, patient.getID());
            preparedStatement.setString(index++, patient.getFirstName().trim());
            preparedStatement.setString(index++, patient.getMiddleName().trim());
            preparedStatement.setString(index++, patient.getLastName().trim());
            preparedStatement.setDate(index++, Convert.convertDate(patient.getBirthDay()));
            preparedStatement.setString(index++, patient.getGender().trim());
            preparedStatement.setString(index++, patient.getAddress().trim());
            preparedStatement.setString(index++, patient.getNumberPhone().trim());
            preparedStatement.setString(index++, patient.getEmail().trim());
            return preparedStatement.executeUpdate() > 0;
        }
         catch (SQLException e) {
            System.out.println("Failed to add patient: " + e.getMessage());
        }
        return false;
    }
    
    //public boolean Delete_Staff(int ID); -- 100 year can delete 1 timer
    
     @Override
    public boolean Update_Staff(Patient patient){

        String SQL_Update_ClassInformation = "UPDATE Patient SET FirstName = ?, MiddleName = ?, LastName = ?, Birthday = ?, Gender = ?, Address = ?, NumberPhone = ?, Email = ? WHERE ID = ?";
        try(Connection connection = DBConnect.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_Update_ClassInformation);
        ){
            int index = 1;
            preparedStatement.setInt(index++, patient.getID());
            preparedStatement.setString(index++, patient.getFirstName().trim());
            preparedStatement.setString(index++, patient.getMiddleName().trim());
            preparedStatement.setString(index++, patient.getLastName().trim());
            preparedStatement.setDate(index++, Convert.convertDate(patient.getBirthDay()));
            preparedStatement.setString(index++, patient.getGender().trim());
            preparedStatement.setString(index++, patient.getAddress().trim());
            preparedStatement.setString(index++, patient.getNumberPhone().trim());
            preparedStatement.setString(index++, patient.getEmail().trim());
            
            return preparedStatement.executeUpdate() > 0;
        } catch (SQLException e)
        {
            System.out.println("Failed to add patient: " + e.getMessage());
        }
        return false;
    }
    
     @Override
    public List<Patient> Search(Patient patient){
        return null;
    }
}
