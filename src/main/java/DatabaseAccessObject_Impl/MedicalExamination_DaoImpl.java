/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DatabaseAccessObject_Impl;

import DatabaseAccessObject_DAO.MedicalExamination_Dao;
import DatabaseAccessObject_DAO.Patient_Dao;
import DatabaseAccessObject_DAO.Staff_Dao;
import Model.MedicalExamination;
import dao.Convert;
import dao.DBConnect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author couni
 */
public class MedicalExamination_DaoImpl implements MedicalExamination_Dao{

    Connection conn = null;
    PreparedStatement prepStatement= null;
    ResultSet resultSet = null;
    
    public MedicalExamination_DaoImpl()
    {
        conn = new DBConnect().getConnection();
    }
    
    @Override
    public List<MedicalExamination> getMedicalList(MedicalExamination medicalExamination) {
        List<MedicalExamination> list = new ArrayList<>();
        
        StringBuilder sql = new StringBuilder("SELECT m.* FROM MedicalExamination m "
                + "INNER JOIN Patient p ON m.PatientID = p.ID "
                + "INNER JOIN Employee e ON m.EmployeeID = e.ID "
                + "WHERE ");
        

        if(medicalExamination != null)
        {
            Integer id = medicalExamination.getID();
            if(id != null)
            {
                sql.append("m.ID = ").append(medicalExamination.getID());  
            }else
                {
                    sql.append("CONCAT(p.FirstName, ' ', p.MiddleName, ' ', p.LastName)  LIKE N'").append(medicalExamination.getPatient().getFullName()).append("'");
                }
            
        }
        try{
            prepStatement = conn.prepareStatement(sql.toString());
            resultSet = prepStatement.executeQuery();
            while (resultSet.next())
            {
                MedicalExamination object = new MedicalExamination();
                object.setID(resultSet.getInt("ID"));
                
                Patient_Dao patient = new Patient_DaoImpl();
                object.setPatient(patient.getPatient(resultSet.getInt("p.ID")));
                
                Staff_Dao employee = new Staff_DaoImpl();
                object.setEmployee(employee.getEmployee(resultSet.getInt("e.ID")));
                
                object.setMedicalDate(resultSet.getDate("MedicalDate"));
                object.setSymptom(resultSet.getString("Symptom"));
                object.setIllnesses(resultSet.getString("Illnesses"));
                object.setNote(resultSet.getString("Note"));
                list.add(object);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }finally {
            try {
                if (prepStatement != null) {
                    prepStatement.close();
                }
                if (resultSet != null) {
                    resultSet.close();
                }
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
        return list;
    }

    @Override
    public boolean AddMedicalExamination(MedicalExamination medicalExamination) {
        String sql = "INSERT INTO [MedicalExamination] (PatientID, EmployeeID, MedicalDate, Symptom, Illnesses, Note) VALUES (?,?,?,?,?,?)";
        
        try{
            prepStatement = conn.prepareStatement(sql);
            int index = 1;
            prepStatement.setInt(index++, medicalExamination.getPatient().getID());
            prepStatement.setInt(index++, medicalExamination.getEmployee().getID());
            prepStatement.setDate(index++, Convert.convertDate(medicalExamination.getMedicalDate()));
            prepStatement.setString(index++, medicalExamination.getSymptom().trim());
            prepStatement.setString(index++, medicalExamination.getIllnesses().trim());
            prepStatement.setString(index++, medicalExamination.getNote().trim());
            return prepStatement.executeUpdate() > 0;
        }
         catch (SQLException e) {
            System.out.println("Failed to add medicalExamination: " + e.getMessage());
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

    @Override
    public boolean Update_MedicalExamination(MedicalExamination medicalExamination) {
        String query = "UPDATE Patient SET PatientID = ?, EmployeeID = ?, MedicalDate = ?, Symptom = ?, Illnesses = ?, Note = ? WHERE ID = ?";
        try{
            prepStatement = conn.prepareStatement(query);
            int index = 1;
            prepStatement.setInt(index++, medicalExamination.getPatient().getID());
            prepStatement.setInt(index++, medicalExamination.getEmployee().getID());
            prepStatement.setDate(index++, Convert.convertDate(medicalExamination.getMedicalDate()));
            prepStatement.setString(index++, medicalExamination.getSymptom().trim());
            prepStatement.setString(index++, medicalExamination.getIllnesses().trim());
            prepStatement.setString(index++, medicalExamination.getNote().trim());
            prepStatement.setInt(index++, medicalExamination.getID());
            return prepStatement.executeUpdate() > 0;
        } catch (SQLException e)
        {
            System.out.println("Failed to add medicalExamination: " + e.getMessage());
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

    @Override
    public MedicalExamination getMedicalExamination(int ID) {
        try {
            String query = "SELECT * FROM [MedicalExamination] Where ID = ?";
            prepStatement = conn.prepareStatement(query);
            prepStatement.setInt(1, ID);
            resultSet = prepStatement.executeQuery();
            while(resultSet.next())
            {
                MedicalExamination object = new MedicalExamination();
                object.setID(resultSet.getInt("ID"));
                
                Patient_Dao patient = new Patient_DaoImpl();
                object.setPatient(patient.getPatient(resultSet.getInt("PatientID")));
                
                Staff_Dao employee = new Staff_DaoImpl();
                object.setEmployee(employee.getEmployee(resultSet.getInt("EmployeeID")));
                
                object.setMedicalDate(resultSet.getDate("MedicalDate"));
                object.setSymptom(resultSet.getString("Symptom"));
                object.setIllnesses(resultSet.getString("Illnesses"));
                object.setNote(resultSet.getString("Note"));
                
                return object;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage()); 
        }finally {
            try {
                if (prepStatement != null) {
                    prepStatement.close();
                }
                if (resultSet != null) {
                    resultSet.close();
                }
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
        return null;
    }
    
}
