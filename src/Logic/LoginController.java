/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

import Data.LoginDA;
import Views.*;



/**
 *
 * @author Nandula
 */
public class LoginController {

    LoginDA data = new LoginDA();
    Login logs;
    Manager view;
    Transaction record;
    
    public boolean log(String uname, String password) {
        String details[];
        String pass;
        String type;
        int id;
        try {
            details = data.getPassword(uname);
            id = Integer.parseInt(details[1]);
            pass = security.symmetricDecrypt(details[0], Employee.getAlgo());
            if (pass.equals(password)) {
               
                type = data.getType(id);
                if(type.equals("Teller")){
                    record = new Transaction(uname, id);
                    record.setVisible(true);
                    record.setLocationRelativeTo(null);
                    return true;
                }
                if(type.equals("Manager")){
                    view = new Manager(uname);
                    view.setVisible(true);
                    view.setLocationRelativeTo(null);
                    return true;
                }
                if(type.equals("Owner")){
                    //owner interface
                    return true;
                }
            } else {
                return false;
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return false;
    }
    
    public void logout(){
        logs= new Login();
        logs.setVisible(true);
        logs.setLocationRelativeTo(null);
        
    }

}
