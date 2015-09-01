/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Logic;

/**
 *
 * @author Nandula
 */
public class Drug {
    private String name="";
    private int price=0;
    private int MOQ=0;
    private int quantity=0;
    private int drugId=0;
    private int sellingPrice=0;

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the price
     */
    public int getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(int price) {
        this.price = price;
    }

    /**
     * @return the MOQ
     */
    public int getMOQ() {
        return MOQ;
    }

    /**
     * @param MOQ the MOQ to set
     */
    public void setMOQ(int MOQ) {
        this.MOQ = MOQ;
    }

    /**
     * @return the quantity
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * @param quantity the quantity to set
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    /**
     * @return the drugId
     */
    public int getDrugId() {
        return drugId;
    }

    /**
     * @param drugId the drugId to set
     */
    public void setDrugId(int drugId) {
        this.drugId = drugId;
    }

    /**
     * @return the sellingPrice
     */
    public int getSellingPrice() {
        return sellingPrice;
    }

    /**
     * @param sellingPrice the sellingPrice to set
     */
    public void setSellingPrice(int sellingPrice) {
        this.sellingPrice = sellingPrice;
    }
    
    
    
    
}
