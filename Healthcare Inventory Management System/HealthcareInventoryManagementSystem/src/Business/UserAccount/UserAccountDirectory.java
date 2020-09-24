/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.UserAccount;

import Business.Employee.Employee;
import Business.PasswordUtils;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author Ajith
 */
public class UserAccountDirectory {
     private ArrayList<UserAccount> userAccountList;

    public UserAccountDirectory() {
        userAccountList = new ArrayList();
    }

    public ArrayList<UserAccount> getUserAccountList() {
        return userAccountList;
    }
    
    public UserAccount authenticateUser(String username, String password){
        for (UserAccount ua : userAccountList){
         boolean passwordMatch = PasswordUtils.verifyUserPassword(password, ua.getPassword(), ua.getSalt());
         if(ua.getUsername().equals(username)&&passwordMatch==true){
             return ua;
         }
        }
        return null;
    }
    
    public UserAccount createUserAccount(String username, String password, Employee employee, Role role, String salt){
        UserAccount userAccount = new UserAccount();
        userAccount.setUsername(username);
        userAccount.setPassword(password);
        userAccount.setEmployee(employee);
        userAccount.setRole(role);
        userAccount.setSalt(salt);
        userAccountList.add(userAccount);
        return userAccount;
    }
    
    public boolean checkIfUsernameIsUnique(String username){
        for (UserAccount ua : userAccountList){
            if (ua.getUsername().equals(username))
                return false;
        }
        return true;
    }
}
