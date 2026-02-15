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
        
        DateTimeFormatter fmt =  DateTimeFormatter.ofPattern("dd/MM/yyyy");
        try{
        System.out.print("room Number: ");
        Integer roomNumber = sc.nextInt();
        sc.nextLine();
        
        System.out.print("check-in date(dd/MM/yyy):");
        LocalDate chekin = LocalDate.parse(sc.nextLine(),fmt);
        
        System.out.print("check-out date(dd/MM/yyy):");
        LocalDate chekout = LocalDate.parse(sc.nextLine(),fmt);
        
       
            Reservation reservation = new Reservation(roomNumber, chekin, chekout);
            System.out.print(reservation);
        
            System.out.println("");
            System.out.println("Enter data to update the reservation:");
            System.out.print("check-in date(dd/MM/yyy):");
            chekin = LocalDate.parse(sc.nextLine(),fmt);
        
            System.out.print("check-out date(dd/MM/yyy):");
            chekout = LocalDate.parse(sc.nextLine(),fmt);
            
           reservation.updateDates(chekin, chekout);
            System.out.println(reservation);
        }
        catch(DateTimeParseException e){
            System.err.println("Error in reservation: " + e.getMessage());
        }
        catch(RuntimeException e){
            System.err.println("Unexpected error" + e.getMessage());
        }
        finally{
                  sc.close(); 
            
            
                
                }
        }
    
     
            
            
        
              
        
}  
        
}
