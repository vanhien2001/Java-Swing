/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import java.util.ArrayList;

/**
 *
 * @author vanhi
 */
public class Use_service {
    int id;
    Customer customer;
    Booking booking;
    ArrayList<Service> list_service;
    ArrayList<Integer> days;

    public Use_service() {
    }

    public Use_service(int id, Customer customer, Booking booking, ArrayList<Service> list_service, ArrayList<Integer> days) {
        this.id = id;
        this.customer = customer;
        this.booking = booking;
        this.list_service = list_service;
        this.days = days;
    }

    public Use_service(Customer customer, Booking booking, ArrayList<Service> list_service, ArrayList<Integer> days) {
        this.customer = customer;
        this.booking = booking;
        this.list_service = list_service;
        this.days = days;
    }

    public Booking getBooking() {
        return booking;
    }

    public void setBooking(Booking booking) {
        this.booking = booking;
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

    public ArrayList<Service> getList_service() {
        return list_service;
    }

    public void setList_service(ArrayList<Service> list_service) {
        this.list_service = list_service;
    }

    public ArrayList<Integer> getDays() {
        return days;
    }

    public void setDays(ArrayList<Integer> days) {
        this.days = days;
    }

    

    
    
}
