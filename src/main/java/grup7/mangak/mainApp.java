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
                    System.out.println("Please enter Customer Name, IC number, and Phone Number");
                    String custName = input.next();
                    String IC = input.next();
                    String phoneNum = input.next();
        
                    System.out.println("Please Enter Maid Service Package( A / B )");
                    char dailyMaidPackage = input.next().charAt(0);
        
                    System.out.println("Please Enter Days");
                    int numOfDays = input.nextInt();        
        
                    customers[custTotal] = new MaidService(custName, IC, phoneNum, dailyMaidPackage, numOfDays);
                    custTotal++;
                }            
            }
            
            if(choice == 2) {
                if(custTotal == customers.length)
                {
                   System.out.println("\n\n\n\t\t\tThe storage limit has been reached! Please contact the IT Department.\n\n\n");
                   clrscr(); 
                }
                
                else
                {
                    System.out.println("Please enter Customer Name, IC number, and Phone Number");
                    String custName = input.next();
                    String IC = input.next();
                    String phoneNum = input.next();
        
                    System.out.println("Please Enter Laundry Service Package( Normal / Dry )");
                    String type = input.next();

                    input.nextLine();
        
                    System.out.println("Please Enter Cloth Type (Baju Kurung/Melayu, Blazer, Jacket/Coat)");
                    String clothType = input.nextLine();            
        
                    System.out.println("Please Enter Quantity");
                    int quantity = input.nextInt();        
        
                    customers[custTotal] = new LaundryService(custName, IC, phoneNum, type, clothType, quantity);
                    custTotal++;
                }
            }
            
            if(choice == 3) {
                for(int i=0; i<customers.length; i++)
                {
                    System.out.println(customers[i].toString());
            
                }
            }
            
            if(choice == 4) {
                for(int i=0; i<customers.length; i++)
                {
                    System.out.println(customers[i].toString());
            
                }        
            }
        }
    }
}
