/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author couni
 */
public class Role {

    /**
     * @return the ID
     */
    public int getID() {
        return ID;
    }

    /**
     * @return the RoleName
     */
    public String getRoleName() {
        return RoleName;
    }

    /**
     * @param RoleName the RoleName to set
     */
    public void setRoleName(String RoleName) {
        this.RoleName = RoleName;
    }

    /**
     * @return the RoleRank
     */
    public int getRoleRank() {
        return RoleRank;
    }

    /**
     * @param RoleRank the RoleRank to set
     */
    public void setRoleRank(int RoleRank) {
        this.RoleRank = RoleRank;
    }
    private int ID;
    private String RoleName;
    private int RoleRank;
}
