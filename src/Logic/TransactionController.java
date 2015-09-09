/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

import Data.TransactionDA;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Nandula
 */
public class TransactionController {

    private TransactionDA records = TransactionDA.getInstance();
    private List<Drug> drugs;

    public List<Drug> loadDrugs() {
        try {
            drugs = records.getDrugs();
        } catch (Exception e) {
            System.out.println(e);
        }

        return drugs;
    }

    public boolean processOrder(int empid, String transaction, int total, List<Drug> update) {
        try {
            DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
            Date date = new Date();
            String dte = dateFormat.format(date);
            
            records.addFinanceRecord(total, dte, "sale");
            records.addTransaction(empid, transaction, dte, total);
            records.updateInventory(update);
            return true;

        } catch (Exception e) {
            System.out.println(e);
        }
        return false;
    }

}
