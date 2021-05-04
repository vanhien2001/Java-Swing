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
public class Room {
    private int id;
    private String name;
    private int bed,price;
    private boolean vip,booked;

    public Room() {
    }

    public Room(String name, int bed, int price, boolean vip, boolean booked) {
        this.name = name;
        this.bed = bed;
        this.price = price;
        this.vip = vip;
        this.booked = booked;
    }

    public Room(int id, String name, int bed, int price, boolean vip, boolean booked) {
        this.id = id;
        this.name = name;
        this.bed = bed;
        this.price = price;
        this.vip = vip;
        this.booked = booked;
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

    public int getBed() {
        return bed;
    }

    public void setBed(int bed) {
        this.bed = bed;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public boolean isVip() {
        return vip;
    }

    public void setVip(boolean vip) {
        this.vip = vip;
    }

    public boolean isBooked() {
        return booked;
    }

    public void setBooked(boolean booked) {
        this.booked = booked;
    }
    
    
}
