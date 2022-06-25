/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package grup7.mangak;

/**
 *
 * @author myPC
 */
public class MaidService extends PearlService {
    private char dailyMaidPackage;
    private int numOfDays;
    
    //normal constructor
    public MaidService(String custName, String IC, String phoneNum, char dmp, int nod) {
        super(custName,IC,phoneNum);
        dailyMaidPackage = dmp;
        numOfDays = nod;
    }
   
    //mutator
    public void setMaidService(char dmp, int nod) {
        dailyMaidPackage = dmp;
        numOfDays = nod;
    }
    
    //accessor
    public char getDailyMaidPackage(){return dailyMaidPackage; }
    public int getNumOfDays(){return numOfDays; }
    
    //processor    
    public double calculateCharge(){
        double charge = 0.00;
        if(dailyMaidPackage == 'A' || dailyMaidPackage == 'a')
            charge = 60 * numOfDays;
        else if(dailyMaidPackage == 'B' || dailyMaidPackage == 'b')
            charge = 110 * numOfDays;
        
        return charge;
        
    }
    
    public void getHighest() {
        
        calculateCharge();
        
    }
    
    public String toString(){
        return ("\n\t\t\tCustomer Name = " + custName +
             "\n\t\t\tIC Number = " + IC +
             "\n\t\t\tPhone Number = " + phoneNum +
             "\n\t\t\tDaily Maid Package = " + dailyMaidPackage +
             "\n\t\t\tNum of Days = " + numOfDays +
             "\n\t\t\tFee = RM " + calculateCharge()    );
    
    }    
}