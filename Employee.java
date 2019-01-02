
package paytime;
import java.util.Arrays;

public class Employee {
    private int[] empNumbers= { 101, 103, 106, 109, 110, 113, 116, 118, 120};
    private String firstname;
    private String lastname;
    private double totalhoursworked;
    private double hourlywage;
    private double regularhours;
    private double overtimehours;
    private double regularpay;
    private double regulartax;
    private double overtimepay;
    private double overtimetax;
    
    
    public boolean checkfordigit(int digit){
        Arrays.sort(empNumbers);
        return Arrays.binarySearch(empNumbers,digit)>=0;
        
    }
    
    public void processinfo(String firstname,String lastname,
            double hours,double hourlywage){
        this.firstname=firstname;
        this.lastname=lastname;
        this.totalhoursworked=hours;
        this.hourlywage=hourlywage;
    }
    
    
    
    
    private void calculateregularpay(){
        this.regularpay=this.regularhours *this.hourlywage;
    }
    
      private void calculateregulartax(){
        if(this.regularpay>0 && this.regularpay<=300){
            this.regulartax=this.regularpay *10/100;
        }else if(regularpay<=400){
            this.regulartax=this.regularpay *12/100;
        }else if(regularpay<=500){
            this.regulartax=this.regularpay *15/100;
        }else{
            this.regulartax=this.regularpay *20/100;
        }
    }
      private void calculateoverhour(){
          if(this.totalhoursworked>40){
              this.overtimehours=this.totalhoursworked-40;
              this.regularhours=40;
          }else{
              this.regularhours=this.totalhoursworked;
              this.overtimehours=0;
          }
      }
    
   
    
    
    private void calculateovertimepay(){
        this.overtimepay=this.overtimehours *1.5 *this.hourlywage;
    }
    
    private void calculateovertimetax(){
        this.overtimetax=this.overtimepay *25 /100;
    }
    
    public double getREgularpay(){
        return this.regularpay;
    }
    
    public double getREgulartax(){
        return this.regulartax;
    }
    
    public double getOVertimepay(){
        return this.overtimepay;
    }
    
    public double getOVertimetax(){
        return this.overtimetax;
    }
    
   
     public void processcalculations(){
       calculateoverhour();
   calculateregularpay();
   calculateregulartax();
   calculateovertimepay();
   calculateovertimetax();
     }
    
    public String getEmployeename(){
        return this.firstname +" " + this.lastname;
    }
    
    
    



}
