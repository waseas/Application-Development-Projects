/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Organization.Organization.Type;
import java.util.ArrayList;

/**
 *
 * @author Abhilash Wase
 */
public class OrganizationDirectory {
     private ArrayList<Organization> organizationList;

    public OrganizationDirectory() {
        organizationList = new ArrayList();
    }

    public ArrayList<Organization> getOrganizationList() {
        return organizationList;
    }
    
    public Organization createOrganization(Type type){
        Organization organization = null;
        if (type.getValue().equals(Type.Admin.getValue())){
            organization = new AdminOrganization();
            organizationList.add(organization);
        }
        else if (type.getValue().equals(Type.Lab.getValue())){
            organization = new LabOrganization();
            organizationList.add(organization);
        }
        else if (type.getValue().equals(Type.Sales.getValue())){
            organization = new SalesOrganization();
            organizationList.add(organization);
        }
        else if (type.getValue().equals(Type.Hospital.getValue())){
            organization = new HospitalOrganization();
            organizationList.add(organization);
        }
        else if (type.getValue().equals(Type.WasteManagement.getValue())){
            organization = new WasteManagementOrganization();
            organizationList.add(organization);
        }
        else if (type.getValue().equals(Type.NGO.getValue())){
            organization = new NGOOrganization();
            organizationList.add(organization);
        }
        else if (type.getValue().equals(Type.Manufacturing.getValue())){
            organization = new ManufacturingOrganization();
            organizationList.add(organization);
        }
        return organization;
    }
}
