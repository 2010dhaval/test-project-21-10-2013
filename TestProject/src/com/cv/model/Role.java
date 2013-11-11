/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cv.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "roles")
public class Role implements Serializable {

  
    @Id
    @Column(name = "id")
    private String roleId;
    @Column(name = "role")
    private String roleName;
    
    
    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
 
}
