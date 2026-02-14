/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.entities;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Date;

/**
 *
 * @author User
 */
public class Reservation {
    private Integer roomNumber;
    private LocalDate checkin;
    private LocalDate checkout;

    public Reservation(Integer roomNumber, LocalDate checkin, LocalDate checkout) {
        this.roomNumber = roomNumber;
        this.checkin = checkin;
        this.checkout = checkout;
    }

    public Integer getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(Integer roomNumber) {
        this.roomNumber = roomNumber;
    }

    public LocalDate getCheckin() {
        return checkin;
    }

    

    public LocalDate getCheckout() {
        return checkout;
    }

    public String duration(){
    long days = ChronoUnit.DAYS.between(checkin, checkout);
        return days + "" +"nigths";
    }
    public void updateDates(LocalDate checkin,LocalDate checkout ){
        this.checkin = checkin;
        this.checkout = checkout;
    }
    @Override
    public  String toString(){
        return "Reservation:"
                + "Room  " + getRoomNumber() + " "
                + "chek-in: " + getCheckin() + " "
                + "chek-out: " + getCheckout() + " "
                + duration();
    }
    
   
    
    
}
