/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.entities;

import java.lang.invoke.MethodHandles;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import model.exceptions.DomainException;

/**
 *
 * @author User
 */
public class Reservation {
    private Integer roomNumber;
    private LocalDate checkin;
    private LocalDate checkout;
    
   private static DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public Reservation(Integer roomNumber, LocalDate checkin, LocalDate checkout) {
        // declarar a exceção no construtor do metodo programação defensiva
        if(!checkout.isAfter(checkin)){
            throw new DomainException("chek-out date must be aftet check-in date");
        }
                
        
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

    public long duration(){
        return ChronoUnit.DAYS.between(checkin, checkout);
        
    }
    public void updateDates(LocalDate checkin,LocalDate checkout ) {
        LocalDate now = LocalDate.now();
        if(checkin.isBefore(now)|| checkout.isBefore(now)){
            throw  new DomainException("Error in reservation: Reservation dates for updates must be future dates");
        }
        if(!checkout.isAfter(checkin)){
            throw new DomainException("Error in reservation: chek-out date must be after chek-in in date   ");
        }
        this.checkin = checkin;
        this.checkout = checkout;
    }
    @Override
    public  String toString(){
        return "Reservation:" + "Room "+ roomNumber
                + ", chek-in : " + fmt.format(checkin)
                + ", chek-out: " + fmt.format(checkout)  
                + ", " + duration() + " nigths";
               
    }
    
   
    
    
}
