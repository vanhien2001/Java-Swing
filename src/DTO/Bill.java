/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import java.sql.Timestamp;

/**
 *
 * @author vanhi
 */
public class Bill {
    int id;
    Booking booking;
    Use_service use_service;
    Staff staff;
    int price;
    Timestamp timestamp;

    public Bill() {
    }

    public Bill(int id, Booking booking, Use_service use_service, Staff staff, int price) {
        this.id = id;
        this.booking = booking;
        this.use_service = use_service;
        this.staff = staff;
        this.price = price;
    }

    public Bill(Booking booking, Use_service use_service, Staff staff, int price) {
        this.booking = booking;
        this.use_service = use_service;
        this.staff = staff;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Booking getBooking() {
        return booking;
    }

    public void setBooking(Booking booking) {
        this.booking = booking;
    }

    public Use_service getUse_service() {
        return use_service;
    }

    public void setUse_service(Use_service use_service) {
        this.use_service = use_service;
    }

    public Staff getStaff() {
        return staff;
    }

    public void setStaff(Staff staff) {
        this.staff = staff;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    
    
    
}
