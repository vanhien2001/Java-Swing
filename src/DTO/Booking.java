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
public class Booking {
    int id;
    Customer customer;
    Room room;
    Staff staff;
    int days;

    public Booking() {
    }

    public Booking(Customer customer, Room room, Staff staff, int days) {
        this.customer = customer;
        this.room = room;
        this.staff = staff;
        this.days = days;
    }

    public Booking(int id, Customer customer, Room room, Staff staff, int days) {
        this.id = id;
        this.customer = customer;
        this.room = room;
        this.staff = staff;
        this.days = days;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public Staff getStaff() {
        return staff;
    }

    public void setStaff(Staff staff) {
        this.staff = staff;
    }

    public int getDays() {
        return days;
    }

    public void setDays(int days) {
        this.days = days;
    }
    
    
}
