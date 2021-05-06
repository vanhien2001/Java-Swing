/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;
import java.util.Date;
import  java.sql.Timestamp;

/**
 *
 * @author vanhi
 */
public class Booking {
    int id;
    Customer customer;
    Room room;
    Staff staff;
    Timestamp timestamp;
    Boolean payed;

    public Booking(Customer customer, Room room, Staff staff, Timestamp timestamp, Boolean payed) {
        this.customer = customer;
        this.room = room;
        this.staff = staff;
        this.timestamp = timestamp;
        this.payed = payed;
    }

    public Booking(Customer customer, Room room, Staff staff, Boolean payed) {
        this.customer = customer;
        this.room = room;
        this.staff = staff;
        this.payed = payed;
    }

    public Booking() {
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

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    public Boolean getPayed() {
        return payed;
    }

    public void setPayed(Boolean payed) {
        this.payed = payed;
    }


}
