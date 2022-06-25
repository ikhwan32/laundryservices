/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package grup7.mangak;

/**
 *
 * @author myPC
 */

import java.util.*;
import java.text.*;
import java.io.IOException;
import java.util.Scanner;

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
		System.out.println("\n\t\t\t1. Store new maid service customer data");
		System.out.println("\t\t\t2. Store new laundry service customer data");
		System.out.println("\t\t\t3. Display total charges for dry cleaning services");
                                    System.out.println("\t\t\t4. Display all customer's data");
		System.out.println("\t\t\t5. Display customer's data with highest and lowest charges");
                                    System.out.println("\t\t\t6. Search customer's data");
		System.out.println("\t\t\t7. Exit");
		System.out.print("\n\t\t\tPlease input your choice >> ");
	}

    public static void main(String[] args) throws Exception {
        
        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter total customer :");
        int customerSize = input.nextInt();

        PearlService[] customers = new PearlService[customerSize];
        
        int custTotal = 0;
        
        for(;;) {
        
            menu();
            int choice = input.nextInt(); 
            input.nextLine();
            
            if(choice == 1) {
                if(custTotal == customers.length)
                {
                   System.out.println("\n\n\n\t\t\tThe storage limit has been reached! Please contact the IT Department.\n\n\n");
                   clrscr(); 
                }
                else
                {
                    
                    System.out.println("\n\n\t\t\tMaid Service Customer");
                    System.out.println("\t\t\t****************************\n");
                    
                    System.out.print("\t\t\tPlease enter Customer Name >>> ");
                    String custName = input.next();
                    
                    System.out.print("\t\t\tPlease enter Customer's IC number >>> ");
                    String IC = input.next();
                    
                    System.out.print("\t\t\tPlease enter Customer's phone number >>> ");
                    String phoneNum = input.next();
        
                    System.out.print("\t\t\tPlease Enter Maid Service Package( A / B ) >>> ");
                    char dailyMaidPackage = input.next().charAt(0);
        
                    System.out.print("\t\t\tPlease Enter Day >>> ");
                    int numOfDays = input.nextInt();        
        
                    customers[custTotal] = new MaidService(custName, IC, phoneNum, dailyMaidPackage, numOfDays);
                    custTotal++;
                    System.out.print("\n\t\t\t<< Data Stored Successfully >> ");
                    clrscr();
                }            
            }
            
            else if(choice == 2) {
                if(custTotal == customers.length)
                {
                   System.out.println("\n\n\n\t\t\tThe storage limit has been reached! Please contact the IT Department.\n\n\n");
                   clrscr(); 
                }
                
                else
                {
                    System.out.print("\t\t\tPlease enter Customer Name >>> ");
                    String custName = input.next();
                    
                    System.out.print("\t\t\tPlease enter Customer's IC number >>> ");
                    String IC = input.next();
                    
                    System.out.print("\t\t\tPlease enter Customer's phone number >>> ");
                    String phoneNum = input.next();
        
                    System.out.print("\t\t\tPlease Enter Laundry Service Package( Normal / Dry ) >>> ");
                    String type = input.next();

                    input.nextLine();
        
                    System.out.print("\t\t\tPlease Enter Cloth Type if neccessary (Baju Kurung/Melayu, Blazer, Jacket/Coat / Enter if not neccessary) >>> ");
                    String clothType = input.nextLine();            
        
                    System.out.print("\t\t\tPlease Enter Quantity >>> ");
                    int quantity = input.nextInt();        
        
                    customers[custTotal] = new LaundryService(custName, IC, phoneNum, type, clothType, quantity);
                    custTotal++;
                    System.out.print("\n\t\t\t<< Data Stored Successfully >> ");
                    clrscr();
                }
            }
                            
            else if(choice == 3) {
                
                double dryTotal = 0.0;
                 for(int i=0; i<custTotal; i++)
                {
                    if (customers[i].getType().equalsIgnoreCase("Dry")) {
                        dryTotal += customers[i].calculateCharge();
                    }
                }
                 
                System.out.print("\t\t\tTotal charges for Dry Cleaning is RM"); 
                System.out.println(dryTotal);
                clrscr();
            }
            
            else if(choice == 4) {
                 for(int i=0; i<custTotal; i++)
                {
                    System.out.println(customers[i].toString());
                    
                }
                clrscr();  
            }
            
            else if(choice == 5) {
                
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
            
            else if(choice == 7) {
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
