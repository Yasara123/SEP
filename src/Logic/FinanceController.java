/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

import Data.FinanceDA;
import Data.LoginDA;
import Views.Charts;
import Views.EmpDetails;
import Views.RemoveEmp;
import Views.SalaryPayment;
import java.awt.Color;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

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
    Charts chrt;
    private List<Employee> tempEmp = new ArrayList();
    private List<TransactionFinance> temptrans = new ArrayList();
    private List<String> tempyr = new ArrayList();

    public boolean addEmployee(String uname, String pword, Employee emp) {
        String encpword = security.symmetricEncrypt(pword, Employee.getAlgo());
        try {
            int id = add.addUser(uname, encpword);
            add.addEmp(emp, id);
            return true;
        } catch (Exception e) {
            System.out.println(e);
        }
        return false;
    }

    public void loadEmp() {
        addemp = new EmpDetails();
        addemp.setVisible(true);
        addemp.setLocationRelativeTo(null);
    }

    public void loadrem() {
        getEmployees();
        rem = new RemoveEmp(tempEmp);
        rem.setVisible(true);
        rem.setLocationRelativeTo(null);
    }

    public void getEmployees() {
        tempEmp.clear();
        try {
            tempEmp = finance.getDetails();
        } catch (SQLException ex) {
            Logger.getLogger(FinanceController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public boolean removeEmp(int id) {
        try {
            finance.removeEmployee(id);
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(FinanceController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public void loadSalary() {
        int[] fig = payments();
        pay = new SalaryPayment(fig);
        pay.setVisible(true);
        pay.setLocationRelativeTo(null);
    }
    
    public void loadChartwindow(){
        yearList();
        chrt = new Charts(tempyr);
        chrt.setVisible(true);
        chrt.setLocationRelativeTo(null);
    }

    public int[] payments() {
        int[] values = new int[4];
        int tellers = 0;
        int managers = 0;
        getEmployees();

        for (int i = 0; i < tempEmp.size(); i++) {
            if (tempEmp.get(i).getEmpType().equals("Owner")) {
                continue;
            }
            if (tempEmp.get(i).getEmpType().equals("Teller")) {
                values[0]++;
                tellers += tempEmp.get(i).getSalary();
            }
            if (tempEmp.get(i).getEmpType().equals("Manager")) {
                values[2]++;
                managers += tempEmp.get(i).getSalary();
            }
        }
        values[1] = tellers;
        values[3] = managers;
        return values;
    }

    public boolean recordPayment(int total) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        Date date = new Date();
        String dte = dateFormat.format(date);
        try {
            finance.addFinanceRecord(total, dte, "salary");
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(FinanceController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public int[] getFinacialRecords(String date) {
        temptrans.clear();
        int purchase = 0;
        int sale = 0;
        int salary = 0;
        int disposal = 0;

        try {
            temptrans = finance.getRecords(date);
        } catch (SQLException ex) {
            Logger.getLogger(FinanceController.class.getName()).log(Level.SEVERE, null, ex);
        }

        for (int i = 0; i < temptrans.size(); i++) {
            if (temptrans.get(i).getType().equals("purchase")) {
                purchase += temptrans.get(i).getValue();
                continue;
            }
            if (temptrans.get(i).getType().equals("removal of inventory")) {
                disposal += temptrans.get(i).getValue();
                continue;
            }
            if (temptrans.get(i).getType().equals("sale")) {
                sale += temptrans.get(i).getValue();
                continue;
            }
            if (temptrans.get(i).getType().equals("salary")) {
                salary += temptrans.get(i).getValue();
                continue;
            }
        }

        int[] values = new int[4];
        values[0] = sale;
        values[1] = purchase;
        values[2] = disposal;
        values[3] = salary;

        return values;
    }

    public void drawCostPieChart(String date) {
        int[] values;
        values = getFinacialRecords(date);
        double purcahse = new Double(-(values[1]));
        double disposal = new Double(-(values[2]));
        double salary = new Double(-(values[3]));
        
        DefaultPieDataset dataset = new DefaultPieDataset();
        dataset.setValue("Purcahses", purcahse);
        dataset.setValue("Disposal of Inventory", disposal);
        dataset.setValue("Salaries", salary);

        JFreeChart chart = ChartFactory.createPieChart3D("Cost Breakdown", dataset, true, true, true);
        PiePlot3D p = (PiePlot3D)chart.getPlot();
        ChartFrame frame = new ChartFrame("Costs", chart);
        frame.setVisible(true);
        frame.setLocation(0, 0);
        frame.setSize(400, 400);
    }
    
    public void drawProfitChart(String date){
        int[] values;
        values = getFinacialRecords(date);
        int cost = -(values[1]+values[2]+values[3]);
        int profit = values[0]-cost;
        
        DefaultCategoryDataset data = new DefaultCategoryDataset();
        data.setValue(values[0], "Value", "Sales");
        data.setValue(cost, "Value", "Cost");
        data.setValue(profit, "Value", "Profit");
        
        JFreeChart chart = ChartFactory.createBarChart3D("Profit For the Year", "Components", "Values in Rupees", data, PlotOrientation.VERTICAL, false, true, false);
        
        CategoryPlot p = chart.getCategoryPlot();
        p.setRangeGridlinePaint(Color.MAGENTA);
        ChartFrame frame = new ChartFrame("Testing", chart);
        frame.setVisible(true);
        frame.setLocation(500,0);
        frame.setSize(400, 400);
    }
    
    public void drawYearlyChart(String olddate,String newdate){
        int[] valuesOld;
        int[] valuesnew;
        valuesOld = getFinacialRecords(olddate);
        valuesnew = getFinacialRecords(newdate);
        int oldcost = -(valuesOld[1]+valuesOld[2]+valuesOld[3]);
        int oldprofit = valuesOld[0]-oldcost;
        
        int newcost = -(valuesnew[1]+valuesnew[2]+valuesnew[3]);
        int newprofit = valuesnew[0]-newcost;
        
        DefaultCategoryDataset data = new DefaultCategoryDataset();
        data.setValue(valuesOld[0], olddate, "Sales");
        data.setValue(oldcost, olddate, "Cost");
        data.setValue(oldprofit, olddate, "Profit");
        
        data.setValue(valuesnew[0], newdate, "Sales");
        data.setValue(newcost, newdate, "Cost");
        data.setValue(newprofit, newdate, "Profit");
        
        JFreeChart chart = ChartFactory.createBarChart3D("Profit Analysis", "Years", "Values in Rupees", data, PlotOrientation.VERTICAL, true, true, false);
        
        CategoryPlot p = chart.getCategoryPlot();
        p.setRangeGridlinePaint(Color.MAGENTA);
        ChartFrame frame = new ChartFrame("Testing", chart);
        frame.setVisible(true);
        frame.setLocation(910,0);
        frame.setSize(400, 400);
    }
    
    public void yearList(){
        try{
            tempyr.clear();
            tempyr = finance.getYears();
        }catch(Exception e){
            System.out.println(e);
        }
        
    }

}
