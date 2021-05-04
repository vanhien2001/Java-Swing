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
public class Staff {
    private int id;
    private String username,password,name,sdt,cmnd,address,position;
    private boolean manager;

    public Staff() {
    }

    public Staff(String username, String password, String name, String sdt, String cmnd, String address, String position, boolean manager) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.sdt = sdt;
        this.cmnd = cmnd;
        this.address = address;
        this.position = position;
        this.manager = manager;
    }

    public Staff(int id, String username, String password, String name, String sdt, String cmnd, String address, String position, boolean manager) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.name = name;
        this.sdt = sdt;
        this.cmnd = cmnd;
        this.address = address;
        this.position = position;
        this.manager = manager;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public boolean isManager() {
        return manager;
    }

    public void setManager(boolean manager) {
        this.manager = manager;
    }
    
    
}
