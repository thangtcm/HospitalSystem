/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DatabaseAccessObject_Impl;

import DatabaseAccessObject_DAO.BillService_Dao;
import Model.BillService;
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
public class BillService_DaoImpl implements BillService_Dao{

    Connection conn = null;
    PreparedStatement prepStatement= null;
    ResultSet resultSet = null;
    
    public BillService_DaoImpl()
    {
        conn = new DBConnect().getConnection();
    }
    
    @Override
    public List<BillService> getBillServiceList(BillService billService) {
        List<BillService> list = new ArrayList<>();
        
        StringBuilder sql = new StringBuilder("SELECT * FROM [BillService] WHERE ");

        if(billService != null)
        {
            if(billService.getID() != null)
            {
                sql.append("ID = '").append(billService.getID()).append("' ");  
            }else
                {
                    if(billService.getMedicalExamination().getID() != null)
                        sql.append("MedicalExaminationID = ").append(billService.getMedicalExamination().getID()).append("' ");
                    sql.append("Paid = ").append(billService.isPaid()).append("' ");
                }
            
        }
        try{
            prepStatement = conn.prepareStatement(sql.toString());
            resultSet = prepStatement.executeQuery();
            while (resultSet.next())
            {
                BillService object = new BillService();
                object.setID(resultSet.getInt("ID"));

                
                object.setBillDate(resultSet.getDate("BillDate"));
                object.setPrice(0);
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
    public boolean AddBillService(BillService billService) {
        String sql = "INSERT INTO [BillService] (MedicalExaminationID, EmployeeID, BillDate, Price, Paid) VALUES (?, ?,?,?,?,?,?,?,?)";
        
        try{
            prepStatement = conn.prepareStatement(sql);
            int index = 1;
            prepStatement.setDate(index++, Convert.convertDate(billService.getBillDate()));
            prepStatement.setDouble(index++, billService.getPrice());
            prepStatement.setBoolean(index++, billService.isPaid());
            return prepStatement.executeUpdate() > 0;
        }
         catch (SQLException e) {
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

    @Override
    public void Delete_BillService(int ID) {
        try {
            String query = "DELETE FROM [MedicalExaminationID] WHERE ID=?";
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

    @Override
    public boolean Update_BillService(BillService billService) {
        String query = "UPDATE BillService SET MedicalExaminationID =?, EmployeeID =?, BillDate =?, Price =?, Paid =? WHERE ID = ?";
        try{
            prepStatement = conn.prepareStatement(query);
            int index = 1;
            
            
            prepStatement.setDate(index++, Convert.convertDate(billService.getBillDate()));
            prepStatement.setDouble(index++, billService.getPrice());
            prepStatement.setBoolean(index++, billService.isPaid());
            prepStatement.setInt(index++, billService.getID());
            
            return prepStatement.executeUpdate() > 0;
        } catch (SQLException e)
        {
            System.out.println("Failed to add billService: " + e.getMessage());
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
