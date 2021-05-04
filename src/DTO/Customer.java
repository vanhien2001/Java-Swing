/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

/**
 *
 * @author vanhi
 */
public class Customer {
    private int id;
    private String name,sdt,cmnd,address;

    public Customer() {
    }

    public Customer(String name, String sdt, String cmnd, String address) {
        this.name = name;
        this.sdt = sdt;
        this.cmnd = cmnd;
        this.address = address;
    }

    public Customer(int id, String name, String sdt, String cmnd, String address) {
        this.id = id;
        this.name = name;
        this.sdt = sdt;
        this.cmnd = cmnd;
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getCmnd() {
        return cmnd;
    }

    public void setCmnd(String cmnd) {
        this.cmnd = cmnd;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    
    
}
