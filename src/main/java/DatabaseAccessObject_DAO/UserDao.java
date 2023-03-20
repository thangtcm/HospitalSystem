/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DatabaseAccessObject_DAO;

import Model.User;
import dao.Convert;
import dao.DBConnect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author couni
 */
public class UserDao {
    public List<User> selectAll(){
        Connection conn = null;
        try {
            conn = DBConnect.getConnection();
            Statement prst = conn.createStatement();
            String sql = "SELECT * FROM [User]";
            List<User> list = new ArrayList<>();
            ResultSet rs = prst.executeQuery(sql);
            while(rs.next())
            {
                User user = new User();
                user.setID(rs.getInt("ID"));
                user.setFirstName(rs.getString("FirstName").trim());
                user.setMiddleName(rs.getString("MiddleName").trim());
                user.setLastName(rs.getString("LastName").trim());
                list.add(user);
            }
            return list;
        } 
        catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }
    
    public List<Integer> getListMaNhanVien() {
        Connection conn = null;
        try {
            conn = DBConnect.getConnection();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("Select ID From [User]");
            List<Integer> ListMaNhanVien = new ArrayList<>();
            while (rs.next()) {
                ListMaNhanVien.add(rs.getInt("ID"));
            }
            return ListMaNhanVien;
        } catch (SQLException ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }
    public boolean insert(User nv) {
        Connection conn = null;
        try {
            conn = DBConnect.getConnection();
            PreparedStatement prst = conn.prepareStatement("INSERT INTO [User] VALUES (?,?,?,?,?,?)");
            prst.setInt(1, nv.getID());
            prst.setString(2, (new Convert()).convertName(nv.getFirstName()));
            prst.setString(3, nv.getMiddleName().trim());
            prst.setString(4, nv.getLastName().trim());
            prst.setString(5, nv.getUserName().trim());
            prst.setString(6, nv.getPassword().trim());
            return prst.execute();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return false;
    }

    public boolean update(User nv) {
        Connection conn = null;
        try {
            conn = DBConnect.getConnection();
            PreparedStatement prst = conn.prepareStatement("UPDATE [User] SET FirstName = ?, MiddleName = ?, LastName = ?, UserName = ?, Password = ? WHERE ID = ?");
            prst.setString(1, (new Convert()).convertName(nv.getFirstName()));
            prst.setString(2, (new Convert()).convertName(nv.getMiddleName()));
            prst.setString(3, (new Convert()).convertName(nv.getLastName()));
            prst.setString(4, (new Convert()).convertName(nv.getUserName()));
            prst.setString(5, (new Convert()).convertName(nv.getPassword()));
            prst.setInt(6, nv.getID());

            return prst.execute();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return false;
    }

    public boolean delete(User nv) {
        Connection conn = null;
        try {
            conn = DBConnect.getConnection();
            PreparedStatement prst = conn.prepareStatement("DELETE FROM [User] WHERE ID = ?");
            prst.setInt(1, nv.getID());
            return prst.execute();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return false;
    }

    public List<User> search(User user) {
        Connection conn = null;
        try {
            conn = DBConnect.getConnection();
            String sql = "SELECT * FROM [User] user";
            if (!user.getFullName().isEmpty()) {
                sql = sql + "AND user.LastName LIKE N'%" + user.getFullName()+ "%'";
            }
            Statement prst = conn.createStatement();
            ResultSet rs = prst.executeQuery(sql);
            List<User> nvList = new ArrayList<>();
            while (rs.next()) {
                User nv = new User();
                nv.setFirstName(rs.getString("FirstName").trim());
                nv.setMiddleName(rs.getString("MiddleName").trim());
                nv.setLastName(rs.getString("LastName").trim());
//                nv.setNgaySinh(rs.getDate("Ngay_Sinh"));
//                nv.setGioiTinh(rs.getString("Gioi_Tinh").trim());
//                nv.setDiaChi(rs.getString("Dia_Chi"));
//                nv.setSdt(rs.getInt("SDT"));
//                nv.setEmail(rs.getString("Email"));
//                nv.setMaVaiTro(rs.getInt("Ma_Vai_Tro"));
//                nv.setTenVaiTro(rs.getString("Ten_Vai_Tro"));
                nv.setUserName(rs.getString("UserName").trim());
                nv.setPassword(rs.getString("Password").trim());
                nvList.add(nv);
            }
            return nvList;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }
}
