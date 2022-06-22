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

public class Mangak {

    public static void main(String[] args) {
        
        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter Size of array for Maid Service :");
        int maidSize = input.nextInt();

        System.out.print("Enter Size of array for Laundry Service :");
        int laundrySize = input.nextInt();        
        
        MaidService[] test2 = new MaidService[maidSize];
        LaundryService[] laundry = new LaundryService[laundrySize];
        
        for(int i=0; i<maidSize; i++)
        {
        System.out.println("Please enter Customer Name, IC number, and Phone Number");
        String custName = input.next();
        String IC = input.next();
        String phoneNum = input.next();
        
        System.out.println("Please Enter Maid Service Package( A / B )");
        char dailyMaidPackage = input.next().charAt(0);
        
        System.out.println("Please Enter Days");
        int numOfDays = input.nextInt();        
        
        test2[i] = new MaidService(custName, IC, phoneNum, dailyMaidPackage, numOfDays);
        }            

        for(int i=0; i<laundrySize; i++)
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
        
        laundry[i] = new LaundryService(custName, IC, phoneNum, type, clothType, quantity);
        }
        
        for(int i=0; i<maidSize; i++)
        {
            System.out.println(test2[i].toString());
            
        }

        for(int i=0; i<laundrySize; i++)
        {
            System.out.println(laundry[i].toString());
            
        }        
        
        
    }
}
