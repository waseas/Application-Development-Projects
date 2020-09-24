/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Role.NGOEmployeeRole;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author Abhilash Wase
 */
public class NGOOrganization extends Organization{
    public NGOOrganization() {
        super(Organization.Type.NGO.getValue());
    }
    
    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList();
        roles.add(new NGOEmployeeRole());
        return roles;
    } 
    
}
