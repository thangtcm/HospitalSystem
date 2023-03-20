/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DatabaseAccessObject_Impl;

import DatabaseAccessObject_DAO.Staff_Dao;
import Model.Employee;
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
    
    @Override
    public boolean AddStaff(Employee staff)
    {
        String SQL_AddStaff = "INSERT INTO [Employee] VALUES (?,?,?,?,?,?,?,?,?,?,?)";
        
        try(Connection connection = DBConnect.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_AddStaff);
        ){
            int i = 1;
            preparedStatement.setString(i++, staff.getUserName().trim());
            preparedStatement.setString(i++, staff.getPassword().trim());
            preparedStatement.setString(i++, staff.getFirstName().trim());
            preparedStatement.setString(i++, staff.getMiddleName().trim());
            preparedStatement.setString(i++, staff.getLastName().trim());
            preparedStatement.setDate(i++, Convert.convertDate(staff.getBirthday()));
            preparedStatement.setString(i++, staff.getGender().trim());     
            preparedStatement.setString(i++, staff.getAddress().trim());
            preparedStatement.setString(i++, staff.getNumberPhonne().trim());
            preparedStatement.setString(i++, staff.getEmail().trim());
            preparedStatement.setString(i++, staff.getRoleName().trim());
            return preparedStatement.executeUpdate() > 0;
        }
        catch(SQLException e) {
            System.out.println(e.getMessage()); 
        }
        return false;
    }

    @Override
    public List<Employee> getStaffList(Employee staff) {
        List<Employee> list = new ArrayList<>();
        /*
         * Default: displays all student information
         */
        StringBuilder SQL_GetStaffInformation = new StringBuilder("SELECT * FROM [Employee]");

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

        try(Connection connection = DBConnect.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_GetStaffInformation.toString().replaceFirst("AND","WHERE"));
            ResultSet resultSet = preparedStatement.executeQuery();
        ){      
            while (resultSet.next())
            {
                Employee table_staff = new Employee();
                table_staff.setID(resultSet.getInt("ID"));
                table_staff.setFirstName(resultSet.getString("FirstName").trim());
                table_staff.setMiddleName(resultSet.getString("MiddleName").trim());
                table_staff.setLastName(resultSet.getString("LastName").trim());
                table_staff.setBirthday(resultSet.getDate("BirthDay"));
                table_staff.setGender(resultSet.getString("Gender").trim());
                table_staff.setAddress(resultSet.getString("Address").trim());
                table_staff.setNumberPhonne(resultSet.getString("NumberPhone"));
                table_staff.setEmail(resultSet.getString("Email").trim());
                table_staff.setRoleName(resultSet.getString("RoleName").trim());

                    list.add(table_staff);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return list;
    }

    @Override
    public boolean Delete_Staff(int ID) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean Update_Staff(Employee staff) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Employee Login_Staff(Employee staff) {
        String SQL_ADMINISTRATOR_LOGIN = "SELECT * FROM [Employee] WHERE UserName = ? AND Password = ?";
        /*
         * In order to initialize the main interface though the user's personal information.
         */
        Employee table_Staff_temp = null;
        try(Connection connection = DBConnect.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_ADMINISTRATOR_LOGIN);    
        ){
            preparedStatement.setString(1, staff.getUserName());
            preparedStatement.setString(2, staff.getPassword());
            ResultSet resultSet = preparedStatement.executeQuery();
            //Store the user information
            if (resultSet.next())
            {		
                table_Staff_temp = new Employee();
                table_Staff_temp.setID(resultSet.getInt("ID"));
                table_Staff_temp.setUserName(resultSet.getString("UserName").trim());
                table_Staff_temp.setPassword(resultSet.getString("Password").trim());
                table_Staff_temp.setFirstName(resultSet.getString("FirstName").trim());
                table_Staff_temp.setMiddleName(resultSet.getString("MiddleName").trim());
                table_Staff_temp.setLastName(resultSet.getString("LastName").trim());
                table_Staff_temp.setBirthday(resultSet.getDate("BirthDay"));
                table_Staff_temp.setGender(resultSet.getString("Gender").trim());
                table_Staff_temp.setAddress(resultSet.getString("Address").trim());
                table_Staff_temp.setNumberPhonne(resultSet.getString("NumberPhone"));
                table_Staff_temp.setEmail(resultSet.getString("Email").trim());
                table_Staff_temp.setNumberPhonne(resultSet.getString("RoleName"));
            }
        } catch (Exception e)
        {
            System.out.println(e.getMessage());
        }		
        return table_Staff_temp;	
    }

    @Override
    public String ChangePassword(Employee staff, String Password) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean ResignerUser(Employee staff) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
