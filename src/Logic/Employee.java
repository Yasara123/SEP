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
public class Employee {

    private int EmpID = 0;
    private String EmpType = "";
    private String Name = "";
    private String Address = "";
    private int Age = 0;
    private int salary = 0;
    private static String algo = "XMzDdG4D03CKm2IxIWQw7g==";

    public static String getAlgo() {
        return algo;
    }

    /**
     * @return the EmpID
     */
    public int getEmpID() {
        return EmpID;
    }

    /**
     * @param EmpID the EmpID to set
     */
    public void setEmpID(int EmpID) {
        this.EmpID = EmpID;
    }

    /**
     * @return the EmpType
     */
    public String getEmpType() {
        return EmpType;
    }

    /**
     * @param EmpType the EmpType to set
     */
    public void setEmpType(String EmpType) {
        this.EmpType = EmpType;
    }

    /**
     * @return the Name
     */
    public String getName() {
        return Name;
    }

    /**
     * @param Name the Name to set
     */
    public void setName(String Name) {
        this.Name = Name;
    }

    /**
     * @return the Address
     */
    public String getAddress() {
        return Address;
    }

    /**
     * @param Address the Address to set
     */
    public void setAddress(String Address) {
        this.Address = Address;
    }

    /**
     * @return the Age
     */
    public int getAge() {
        return Age;
    }

    /**
     * @param Age the Age to set
     */
    public void setAge(int Age) {
        this.Age = Age;
    }

    /**
     * @return the salary
     */
    public int getSalary() {
        return salary;
    }

    /**
     * @param salary the salary to set
     */
    public void setSalary(int salary) {
        this.salary = salary;
    }

}
