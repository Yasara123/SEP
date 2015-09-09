/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

import Data.InventoryDA;
import Views.AddDrug;
import Views.Inventory;
import Views.Manager;
import Views.RemoveDrug;
import Views.Reorder;
import Views.UpdateDrug;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.smslib.SMSLibException;

/**
 *
 * @author Nandula
 */
public class InventoryController {

    private Inventory list;
    public static Manager temp;
    private AddDrug drug;
    private UpdateDrug update;
    private RemoveDrug remove;
    private InventoryDA data = InventoryDA.getInstance();
    private List<Drug> invtempDrug;
    private List<Drug> tempDrug;
    private List<supplier> tempsup;
    private supplier aSup;

    public InventoryController(Manager view) {
        temp = view;
    }

    public InventoryController() {

    }

    public void loadInventory() {
        try {
            invtempDrug = data.getDrugs();
            list = new Inventory(invtempDrug);
            list.setVisible(true);
            list.setLocationRelativeTo(null);
            invtempDrug.clear();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void openHome() {
        temp.setVisible(true);
        temp.setLocationRelativeTo(null);
    }

    public void purchaseOrder(int id, String name) {

        try {
            aSup = data.getSuppDetails(id);
        } catch (Exception e) {
            System.out.println(e);
        }
        String drugName = name;
        Reorder order = new Reorder(aSup, drugName);
        order.setVisible(true);
        order.setLocationRelativeTo(null);
    }

    public boolean Message(String tel, String mess, String date, int id) {
        boolean sent = false;
        try {
            SMS.sendMessage(tel, mess);
            sent = true;
        } catch (SMSLibException ex) {
            Logger.getLogger(InventoryController.class.getName()).log(Level.SEVERE, null, ex);
            //JOptionPane.showMessageDialog(order,ex, "Message Details", JOptionPane.INFORMATION_MESSAGE);
            System.out.println(ex);
        } catch (IOException ex) {
           Logger.getLogger(InventoryController.class.getName()).log(Level.SEVERE, null, ex);
            //JOptionPane.showMessageDialog(order,ex, "Message Details", JOptionPane.INFORMATION_MESSAGE);
            System.out.println("ex");
        } catch (InterruptedException ex) {
            Logger.getLogger(InventoryController.class.getName()).log(Level.SEVERE, null, ex);
            //JOptionPane.showMessageDialog(order,ex, "Message Details", JOptionPane.INFORMATION_MESSAGE);
            System.out.println(ex);
        }

        try {
            data.addMessage(id, mess, date);
        } catch (Exception e) {
            System.out.println(e);
        }
        return sent;
    }

    public void LoadAddDrug() {
        try {
            tempsup = data.getallDetails();
        } catch (Exception e) {
            System.out.println(e);
        }
        drug = new AddDrug(tempsup);
        drug.setVisible(true);
        drug.setLocationRelativeTo(null);

    }

    public boolean addDrugDetails(Drug adrug, supplier asup) {
        if (asup.getId() == 0) {
            //new supplier
            try {
                data.addDrugSupp(adrug, asup);
                
            } catch (Exception e) {
                System.out.println(e);
            }
        } else {
            //existing supplier
            try {
                data.addDrug(adrug, asup.getId());
                
            } catch (Exception e) {
                System.out.println(e);
            }
        }

        int cost = -(adrug.getPrice() * adrug.getQuantity());

        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        Date date = new Date();
        String dte = dateFormat.format(date);

        try {
            data.addFinanceRecord(cost, dte,"purchase");
            return true;
        } catch (Exception e) {
            System.out.println(e);
        }
        return false;
    }

    public void LoadUpdate() {
        try {
            tempDrug = data.getDrugs();
        } catch (Exception e) {
            System.out.println(e);
        }
        update = new UpdateDrug(tempDrug);
        update.setVisible(true);
        update.setLocationRelativeTo(null);
    }

    public boolean updateDetails(Drug drug, int cost) {
        try {
            data.updateDrug(drug);
            DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
            Date date = new Date();
            String dte = dateFormat.format(date);
            data.addFinanceRecord(cost, dte,"purchase");
            return true;
        } catch (Exception e) {
            System.out.println(e);
        }
        return false;
    }

    public void LoadRemove() {
        try {
            tempDrug = data.getDrugs();
        } catch (Exception e) {
            System.out.println(e);
        }
        remove = new RemoveDrug(tempDrug);
        remove.setVisible(true);
        remove.setLocationRelativeTo(null);
    }

    public boolean remove(Drug drug) {
        try {
            data.removeDrug(drug.getDrugId());
            int cost = -(drug.getPrice() * drug.getQuantity());
            DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
            Date date = new Date();
            String dte = dateFormat.format(date);
            data.addFinanceRecord(cost, dte,"removal of inventory");
            return true;
        } catch (Exception e) {
            System.out.println(e);
        }
        return false;
    }
}
