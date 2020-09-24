/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Enterprise;

import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author Abhilash Wase
 */
public class HealthcareEnterprise extends Enterprise {

    public HealthcareEnterprise(String name) {
        super(name, Enterprise.EnterpriseType.Healthcare);
    }

    @Override
    public ArrayList<Role> getSupportedRole() {
        return null;
    }
}
