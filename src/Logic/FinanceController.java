/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Logic;

import Data.FinanceDA;
import Data.LoginDA;
import Views.EmpDetails;
import Views.RemoveEmp;
import Views.SalaryPayment;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Nandula
 */
public class FinanceController {
    LoginDA add = new LoginDA();
    FinanceDA finance = new FinanceDA();
    EmpDetails addemp;
    RemoveEmp rem;
    SalaryPayment pay;
    private List<Employee> tempEmp = new ArrayList();
    private List<Transaction> temptrans = new ArrayList();
    
    
    public void addEmployee(String uname,String pword,Employee emp){
        String encpword = security.symmetricEncrypt(pword, Employee.getAlgo());
        try{
            int id = add.addUser(uname, encpword);
            add.addEmp(emp, id);
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
    
    public void loadEmp(){
        addemp = new EmpDetails();
        addemp.setVisible(true);
        addemp.setLocationRelativeTo(null);
    }
    
    public void loadrem(){
        getEmployees();
        rem = new RemoveEmp(tempEmp);
        rem.setVisible(true);
        rem.setLocationRelativeTo(null);
    }
    
    public void getEmployees(){
        tempEmp.clear();
        try {
            tempEmp=finance.getDetails();
        } catch (SQLException ex) {
            Logger.getLogger(FinanceController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void removeEmp(int id){
        try {
            finance.removeEmployee(id);
        } catch (SQLException ex) {
            Logger.getLogger(FinanceController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void loadSalary(){
        int[] fig = payments();
        pay = new SalaryPayment(fig);
        pay.setVisible(true);
        pay.setLocationRelativeTo(null);
    }
    
    public int[] payments(){
        int[] values = new int[4];
        int tellers=0;
        int managers=0;
        getEmployees();
        
        for(int i=0;i<tempEmp.size();i++){
            if(tempEmp.get(i).getEmpType().equals("Owner")){
                continue;
            }
            if(tempEmp.get(i).getEmpType().equals("Teller")){
                values[0]++;
                tellers += tempEmp.get(i).getSalary();
            }
            if(tempEmp.get(i).getEmpType().equals("Manager")){
                values[2]++;
                managers += tempEmp.get(i).getSalary();
            }
        }
        values[1]=tellers;
        values[3]=managers;
        return values;
    }
    
    public void recordPayment(int total){
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        Date date = new Date();
        String dte = dateFormat.format(date);
        try {
            finance.addFinanceRecord(total, dte, "salary");
        } catch (SQLException ex) {
            Logger.getLogger(FinanceController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public int[] getFinacialRecords(String date){
        temptrans.clear();
        int purchase=0;
        int sale=0;
        int salary=0;
        int disposal=0;
        
        try {
            temptrans=finance.getRecords(date);
        } catch (SQLException ex) {
            Logger.getLogger(FinanceController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        for(int i=0;i<temptrans.size();i++){
            if(temptrans.get(i).getType().equals("purchase")){
                purchase += temptrans.get(i).getValue();
                continue;
            }
            if(temptrans.get(i).getType().equals("removal of inventory")){
                disposal += temptrans.get(i).getValue();
                continue;
            }
            if(temptrans.get(i).getType().equals("sale")){
                sale += temptrans.get(i).getValue();
                continue;
            }
            if(temptrans.get(i).getType().equals("salary")){
                salary += temptrans.get(i).getValue();
                continue;
            }
        }
        
        int[] values = new int[4];
        values[0]=sale;
        values[1]=purchase;
        values[2]=disposal;
        values[3]=salary;
        
        return values;
    }
    
    
    
}
