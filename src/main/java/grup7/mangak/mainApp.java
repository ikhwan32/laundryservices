/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package grup7.mangak;

/**
 *
 * @author myPC
 * only god know how this work so please don't ask us
 */

import java.util.*;
import java.text.*;
import java.io.IOException;
import java.util.Scanner;
import java.io.PrintWriter;


public class mainApp {
    
    public static void clrscr() throws Exception
	{
		Scanner sc = new Scanner(System.in);

		System.out.print("\n\n\n\t\t\t<< Press ENTER to continue >> ");
		sc.nextLine();
		new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
	}

    public static void menu()
	{
		System.out.println("\t\t\tPEARL SERVICE CUSTOMER MANAGEMENT SYSTEM");
		System.out.println("\t\t\t~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println("\n\t\t\t1. Store new customer data");
		System.out.println("\t\t\t2. Display total charges for dry cleaning services");
                                    System.out.println("\t\t\t3. Display all customer's data");
		System.out.println("\t\t\t4. Display customer's data with highest and lowest charges");
                                    System.out.println("\t\t\t5. Search customer's data");
		System.out.println("\t\t\t6. Exit");
		System.out.print("\n\t\t\tPlease input your choice >> ");
	}

    public static void main(String[] args) throws Exception {
        
        Scanner input = new Scanner(System.in);
        
        //System.out.print("Enter total customer :"); //temp variable
        int customerSize = 100;              //temp variable

        PearlService[] customers = new PearlService[customerSize];
        
        int custTotal = 0;
        double totalDryCharges = 0;
        
        for(;;) {
        
            menu();
            int choice = input.nextInt(); 
            input.nextLine();
            
            if( choice == 1) {
                if(custTotal == customers.length)
                {
                   System.out.println("\n\n\n\t\t\tThe storage limit has been reached! Please contact the IT Department.\n\n\n");
                   clrscr(); 
                }
                else
                {
                    
                    System.out.print("\n\t\t\tPlease enter Customer Name >>> ");
                    String custName = input.next();
                    
                    System.out.print("\t\t\tPlease enter Customer's IC number >>> ");
                    String IC = input.next();
                    
                    System.out.print("\t\t\tPlease enter Customer's phone number >>> ");
                    String phoneNum = input.next();
        
                    System.out.print("\t\t\tPlease enter Customer's desired service (Maid / Laundry )>>> ");
                    String serviceDesired = input.next();
                    
                    if(serviceDesired.equalsIgnoreCase("Maid")) {
                        
                        System.out.print("\t\t\tPlease Enter Maid Service Package( A / B ) >>> ");
                        char dailyMaidPackage = input.next().charAt(0);
        
                        System.out.print("\t\t\tPlease Enter Day >>> ");
                        int numOfDays = input.nextInt();        
        
                        customers[custTotal] = new MaidService(custName, IC, phoneNum, dailyMaidPackage, numOfDays);
                        custTotal++;
                        System.out.print("\n\t\t\t<< Data Stored Successfully >> ");
                        clrscr();
                        
                    }
                        else if(serviceDesired.equalsIgnoreCase("Laundry")) {
                        
                            System.out.print("\t\t\tPlease Enter Laundry Service Package( Normal / Dry ) >>> ");
                            String type = input.next();

                            input.nextLine();
                            
                            if(type.equalsIgnoreCase("Normal")) {
                                System.out.print("\t\t\tPlease Enter Quantity >>> ");
                                int quantity = input.nextInt();   
                                
                                customers[custTotal] = new LaundryService(custName, IC, phoneNum, type, "None", quantity);
                                custTotal++;
                                System.out.print("\n\t\t\t<< Data Stored Successfully >> ");
                                clrscr();
                            }
                            
                            else if(type.equalsIgnoreCase("Dry")) {
                                System.out.print("\t\t\tPlease Enter Cloth Type if neccessary (Baju Kurung/Melayu, Blazer, Jacket/Coat ) >>> ");
                                 String clothType = input.nextLine();            
        
                                System.out.print("\t\t\tPlease Enter Quantity >>> ");
                                int quantity = input.nextInt();        
        
                                customers[custTotal] = new LaundryService(custName, IC, phoneNum, type, clothType, quantity);
                                
                                totalDryCharges += customers[custTotal].calculateCharge();
                                
                                custTotal++;
                                System.out.print("\n\t\t\t<< Data Stored Successfully >> ");
                                clrscr();
                            }
                    }
                    
                        else {
                            System.out.print("\n\t\t\t<< WRONG INPUT! PLEASE REPEAT >> ");
                            clrscr();
                        }
                    
                }            
            }
                            
            else if(choice == 2) {

                 
                System.out.print("\t\t\tTotal charges for Dry Cleaning is RM"); 
                System.out.println(totalDryCharges);
                clrscr();
            }
            
            else if(choice == 3) {
                 for(int i=0; i<custTotal; i++)
                {
                    System.out.println(customers[i].toString());
                    
                }
                clrscr();  
            }
            
            else if(choice == 4) {
                
                double highestCharge = 0;
                double lowestCharge = 999999;
                int custLowest = 999999;
                int custHighest = 0;
                
                
                for(int i=0; i<custTotal; i++)
                {                      
                   if(customers[i].calculateCharge() > highestCharge) {                       
                       highestCharge = customers[i].calculateCharge();        
                       custHighest = i;
                   }
                   
                   if(customers[i].calculateCharge() < lowestCharge) {                       
                       lowestCharge = customers[i].calculateCharge();      
                       custLowest = i;
                   }                    
                }
                
                System.out.println("\t\t\tCustomer with Highest Charge info");
                System.out.println("\t\t\t******************************************");
                System.out.println(customers[custHighest].toString());
                System.out.println("\t\t\t******************************************");
                System.out.println("\t\t\tCustomer with Lowest Charge info");
                System.out.println("\t\t\t******************************************");
                System.out.println(customers[custLowest].toString());
                System.out.println("\t\t\t******************************************\n");
                
                clrscr();  
            }            
            
            else if(choice == 5) {
                
                int totalSearch = 0;
                
                System.out.println("\n\t\t\tCustomer Database");
                System.out.println("\t\t\tPress Enter if Not Related ");
                System.out.println("\t\t\t******************************************");
                
                System.out.print("\t\t\tPlease enter Customer Name >>> ");
                String custName = input.nextLine();

                System.out.print("\t\t\tPlease enter Customer's IC number >>> ");
                String IC = input.nextLine();
                    
                System.out.print("\t\t\tPlease enter Customer's phone number >>> ");
                String phoneNum = input.nextLine();                
                
                System.out.println("\n\t\t\t******************************************");
                System.out.println("\t\t\tResult");
                System.out.println("\t\t\t******************************************\n");
                for(int i=0; i<custTotal; i++)
                {     
                    if(customers[i].getCustName().equalsIgnoreCase(custName) || customers[i].getIC().equalsIgnoreCase(IC) || customers[i].getPhoneNum().equalsIgnoreCase(phoneNum)  ) {
                        System.out.println(customers[i].toString());
                        totalSearch++;
                     }

                }
                
                if(totalSearch == 0) {
                    System.out.println("\t\t\tNo Data found!");
                    System.out.println("\t\t\t******************************************\n");
                }
                
                else 
                    System.out.println("\t\t\t******************************************\n");
                
                clrscr();
                
            }
            
            else if(choice == 6) {
                 	System.out.println("\n\n\n\t\t\t~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
	System.out.print("\t\t\tExiting.... ");
	break;
            }
                        
            else {
                  input.nextLine();
	System.out.println("\n\n\n\t\t\tWrong input! Please re-enter your choice!\n\n\n");
	clrscr();
            }
            
        }
    }
}