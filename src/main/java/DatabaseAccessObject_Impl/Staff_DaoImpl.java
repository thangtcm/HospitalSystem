/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DatabaseAccessObject_Impl;

import DatabaseAccessObject_DAO.Staff_Dao;
import Model.Staff;
import dao.Convert;
import dao.DBConnect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author couni
 */
public class Staff_DaoImpl implements Staff_Dao{
    
    Connection connection = null;
    @Override
    public boolean AddStaff(Staff staff)
    {
        PreparedStatement preparedStatement = null;
        String SQL_AddStaff = "INSERT INTO [Staff] VALUES (?,?,?,?,?,?,?,?,?,?,?)";
        
        try{
            connection = DBConnect.getConnection();
            preparedStatement = connection.prepareStatement(SQL_AddStaff);
            preparedStatement.setString(1, staff.getUserName().trim());
            preparedStatement.setString(2, staff.getPassword().trim());
            preparedStatement.setString(3, staff.getFirstName().trim());
            preparedStatement.setString(4, staff.getMiddleName().trim());
            preparedStatement.setString(5, staff.getLastName().trim());
            preparedStatement.setDate(6, Convert.convertDate(staff.getBrithday()));
            preparedStatement.setInt(7, staff.getRoleID());
            preparedStatement.setString(8, staff.getSex().trim());
            preparedStatement.setString(9, staff.getAddress().trim());
            preparedStatement.setInt(10, staff.getNumberPhonne());
            preparedStatement.setString(11, staff.getEmail().trim());
            
        }
        catch(SQLException e) {
            System.out.println(e.getMessage()); 
        }finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(Staff_DaoImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return false;
    }

    @Override
    public List<Staff> getStaffList(Staff staff) {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        List<Staff> list = new ArrayList<Staff>();

        /*
         * Default: displays all student information
         */
        StringBuilder SQL_GetStaffInformation = new StringBuilder("SELECT * FROM [Staff]");

        /*------------------------------------------------------------------------
         * getStudent_name() : Get it from the information entered by the user.  |
         * -----------------------------------------------------------------------
         */
        if (!staff.getFullName().isEmpty())
        {
                // If 'getStudent_name()' is null ¡ª¡ª> false (Not execute)
            SQL_GetStaffInformation.append(" AND FirstName LIKE '%").append(staff.getFirstName()).append("%' ")
                    .append(" AND MiddleName LIKE '%").append(staff.getMiddleName()).append("%' ")
                    .append(" AND LastName LIKE '%").append(staff.getLastName()).append("%' ");
        }

        try
        {
            connection = DBConnect.getConnection();
            preparedStatement = connection.prepareStatement(SQL_GetStaffInformation.toString().replaceFirst("AND","WHERE"));

            resultSet = preparedStatement.executeQuery();
            while (resultSet.next())
            {
                    Staff table_staff = new Staff();
                    table_staff.setID(resultSet.getInt("ID"));
                    table_staff.setFirstName(resultSet.getString("FirstName").trim());
                    table_staff.setMiddleName(resultSet.getString("MiddleName").trim());
                    table_staff.setLastName(resultSet.getString("LastName").trim());
                    table_staff.setBrithday(resultSet.getDate("BrithDay"));
                    table_staff.setSex(resultSet.getString("Sex").trim());
                    table_staff.setAddress(resultSet.getString("Address").trim());
                    table_staff.setEmail(resultSet.getString("Email").trim());
                    table_staff.setNumberPhonne(resultSet.getInt("NumberPhone"));

                    list.add(table_staff);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(Staff_DaoImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return list;
    }

    @Override
    public boolean Delete_Staff(int ID) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean Update_Staff(Staff staff) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Staff Login_Staff(Staff staff) {
        String SQL_ADMINISTRATOR_LOGIN = "SELECT * FROM [Staff] WHERE UserName = ? AND Password = ?";
        /*
         * In order to initialize the main interface though the user's personal information.
         */
        Staff table_Staff_temp = null;

        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try
        {
            /*
             * ------------------------------------------------------------------------------
             * 'connection' : Pass SQL statements to objects that manipulate the database	|
             *  From Connection com.YUbuntu.dao.BasicDao.connection 						|
             * ------------------------------------------------------------------------------
             */
            connection = DBConnect.getConnection();
            preparedStatement = connection.prepareStatement(SQL_ADMINISTRATOR_LOGIN);

            preparedStatement.setString(1, staff.getUserName());
            preparedStatement.setString(2, staff.getPassword());
            resultSet = preparedStatement.executeQuery();

            //Store the user information
            if (resultSet.next())
            {		
                    /*---------------------------------------------------------------------------------------------------------------------------------
                     * Stores the data of Student_ID and .. so that in order to initialize the main interface though the user's personal information. |
                     *---------------------------------------------------------------------------------------------------------------------------------
                     *///Such as it's be used when change user's password !
                    table_Staff_temp = new Staff();
                    table_Staff_temp.setID(resultSet.getInt("ID"));
                    table_Staff_temp.setUserName(resultSet.getString("UserName").trim());
                    table_Staff_temp.setPassword(resultSet.getString("Password").trim());
                    table_Staff_temp.setFirstName(resultSet.getString("FirstName").trim());
                    table_Staff_temp.setMiddleName(resultSet.getString("MiddleName").trim());
                    table_Staff_temp.setLastName(resultSet.getString("LastName").trim());
                    table_Staff_temp.setBrithday(resultSet.getDate("BrithDay"));
                    table_Staff_temp.setSex(resultSet.getString("Sex").trim());
                    table_Staff_temp.setAddress(resultSet.getString("Address").trim());
                    table_Staff_temp.setEmail(resultSet.getString("Email").trim());
                    table_Staff_temp.setNumberPhonne(resultSet.getInt("NumberPhone"));
                    //...
            }
        } catch (Exception e)
        {
                System.err.println("ERROR : Fail to check specified information of student from the SQL database !\n");
                e.printStackTrace();
        }		
        return table_Staff_temp;	
    }

    @Override
    public String ChangePassword(Staff staff, String Password) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean ResignerUser(Staff staff) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
