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
        
        System.out.print("Enter Size of array for fuck :");
        int size2 = input.nextInt();

        MaidService[] test2 = new MaidService[size2];
        
        for(int i=0; i<size2; i++)
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
        
        for(int i=0; i<size2; i++)
        {
            System.out.println(test2[i].toString());
            
        }

        
    }
}
