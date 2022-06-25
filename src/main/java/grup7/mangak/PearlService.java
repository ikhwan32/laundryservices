/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package grup7.mangak;

/**
 *
 * @author may
 */
public abstract class PearlService {
    protected String custName;
    protected String IC;
    protected String phoneNum;
    private String type;
    
    //default constructor
    public PearlService(String custName, String IC, String phoneNum) {
        this.custName = custName;
        this.IC = IC;
        this.phoneNum = phoneNum;
    }
    
    //mutator
    public void setCustInfo(String custName, String IC, String phoneNum) {
        this.custName = custName;
        this.IC = IC;
        this.phoneNum = phoneNum;        
    }
    
    //accessor
    public String getCustName() {return custName; }
    public String getIC() {return IC; }
    public String getPhoneNum() {return phoneNum; }
    
    //call calculateCharge
    public abstract double calculateCharge();
    
    public String getType() {return type; }
    
    //display
    public String toString(){
        return "Customer Name = " + custName +
             "\nIC Number = " + IC +
             "\nPhone Number = " + phoneNum  ;
    
    }
}
  
