/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;
import model.entities.Reservation;

/**
 *
 * @author User
 */
public class Program {
    public static void main(String[] args)  {
        
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        
        DateTimeFormatter dtf =  DateTimeFormatter.ofPattern("dd/MM/yyyy");
        
        System.out.print("room Number: ");
        Integer roomNumber = sc.nextInt();
        sc.nextLine();
        
        System.out.print("check-in date(dd/MM/yyy):");
        LocalDate chekin = LocalDate.parse(sc.nextLine(),dtf);
        
        System.out.print("check-out date(dd/MM/yyy):");
        LocalDate chekout = LocalDate.parse(sc.nextLine(),dtf);
        
        if(!chekout.isAfter(chekin)){
            System.out.println("Error in reservation: chek-out date must be after chek-in in date   ");
        }
        else{
            Reservation reservation = new Reservation(roomNumber, chekin, chekout);
            System.out.print(reservation);
        
            System.out.println("");
            System.out.println("Enter data to update the reservation:");
            System.out.print("check-in date(dd/MM/yyy):");
            chekin = LocalDate.parse(sc.nextLine(),dtf);
        
            System.out.print("check-out date(dd/MM/yyy):");
            chekout = LocalDate.parse(sc.nextLine(),dtf);
            
            LocalDate now = LocalDate.now();
            
            if(chekin.isBefore(now) || chekout.isBefore(now)){
                System.out.println("Error in reservation: Reservation dates for updates must be future dates");
            }
            else if (!chekout.isAfter(chekin)){
                System.out.println("Error in reservation: chek-out date must be after chek-in in date   ");
            }
            else{
                reservation.updateDates(chekin, chekout);
                System.out.println(reservation);
                  sc.close(); 
                }
        }
    
     
            
            
        
              
        
}  
        
}
