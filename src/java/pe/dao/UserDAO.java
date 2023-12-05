/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import pe.entity.Comestic;
import pe.entity.User;
import pe.utils.DBUtils;

/**
 *
 * @author Trần Công Lâm
 */
public class UserDAO {
    private static final String LOGIN = "SELECT status, fullName, roleID from \"User\" where userID = ? and password = ?";
    private static final String LIST = "SELECT * from \"Comestic\"";
    private static final String CHECK_DUPLICATE_COMESTIC = "SELECT name FROM \"Comestic\" WHERE name= ?";
    private static final String CHECK_DUPLICATE_USER = "SELECT userID FROM \"User\" WHERE userID= ?";
    private static final String INSERT_COMESTIC = "INSERT INTO \"Comestic\"\n"
            + "           ([Id]\n"
            + "           ,[name]\n"
            + "           ,[description]\n"
            + "           ,[price]\n"
            + "           ,[status])\n"
            + "     VALUES\n"
            + "           (?\n"
            + "           ,?\n"
            + "           ,?\n"
            + "           ,?\n"
            + "           ,?)";
    
    private static final String INSERT_USER = "INSERT INTO [dbo].[User]\n" +
"           ([userID]\n" +
"           ,[status]\n" +
"           ,[fullName]\n" +
"           ,[roleID]\n" +
"           ,[password])\n" +
"     VALUES\n" +
"           (?\n" +
"           ,?\n" +
"           ,?\n" +
"           ,'US'\n" +
"           ,?)";
    
    public User checkLogin(String userID, String password) throws SQLException {
        User user = null;
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(LOGIN);
                ptm.setString(1, userID);
                ptm.setString(2, password);
//                System.out.println(userID + password);
                rs = ptm.executeQuery();

                if (rs.next()) {
                    String fullName = rs.getString("fullName");
                    String roleID = rs.getString("roleID");
//                    boolean status = Boolean.parseBoolean(rs.getString("status"));
                    boolean status = rs.getBoolean("status");
                    user = new User(userID, status, fullName, roleID, password);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ptm != null) {
                rs.close();
            }
            if (conn != null) {
                rs.close();
            }
        }
        return user;
    }
    
    public List<Comestic> getAll() throws SQLException {
        List<Comestic> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(LIST);
                rs = ptm.executeQuery();
                while (rs.next()) {
                    String Id = rs.getString("Id");
                    String name = rs.getString("name");
                    String description = rs.getString("description");
                    float price = rs.getFloat("price");
                    boolean status = rs.getBoolean("status");
                    list.add(new Comestic(Id, name, description, price, status));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ptm != null) {
                ptm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return list;
    }
    
    public boolean checkDuplicateComestic(String name) throws SQLException {
        boolean check = false;
        Comestic comestic = null;
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(CHECK_DUPLICATE_COMESTIC);
                ptm.setString(1, name);
                rs = ptm.executeQuery();
                if (rs.next()) {
                    check = true;
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ptm != null) {
                ptm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return check;
    }
    
    public boolean checkDuplicateUser(String userID) throws SQLException {
        boolean check = false;
        User user = null;
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(CHECK_DUPLICATE_USER);
                ptm.setString(1, userID);
                rs = ptm.executeQuery();
                if (rs.next()) {
                    check = true;
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ptm != null) {
                ptm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return check;
    }

    public boolean insertV2Comestic(Comestic comestic) throws SQLException, ClassNotFoundException {
        boolean checkInsert = false;
        Connection conn = null;
        PreparedStatement ptm = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(INSERT_COMESTIC);
                ptm.setString(1, comestic.getId());
                ptm.setString(2, comestic.getName());
                ptm.setString(3, comestic.getDescription());
                ptm.setFloat(4, comestic.getPrice());
                ptm.setBoolean(5, comestic.isStatus());
                checkInsert = ptm.executeUpdate() > 0 ? true : false;
            }
        } catch (Exception ex) {
        } finally {
            if (ptm != null) {
                ptm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return checkInsert;
    }
    
    public boolean insertV2User(User user) throws SQLException, ClassNotFoundException {
        boolean checkInsert = false;
        Connection conn = null;
        PreparedStatement ptm = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(INSERT_USER);
                
                ptm.setString(1, user.getUserID());
                ptm.setBoolean(2, user.isStatus());
                ptm.setString(3, user.getFullName());
                      
                
                ptm.setString(4, user.getPassword());
                
                checkInsert = ptm.executeUpdate() > 0 ? true : false;
                System.out.println(INSERT_USER);
            }
        } catch (Exception ex) {
//            System.out.println(ex);
        } finally {
            if (ptm != null) {
                ptm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return checkInsert;
        
    }
    
   
}
