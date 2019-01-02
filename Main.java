/**
 * Ayodeji Esoimeme
 * 991520751
 * Assignment 3
 * 11/21/2018
 */
package paytime;

import java.util.Scanner;
import java.text.DecimalFormat;

public class Main {

    public static void main(String[] args) {
        Employee one = new Employee();

        Scanner k = new Scanner(System.in);
        System.out.print("Enter  Upper case Y to proceed calculations:   ");
        String Y = k.nextLine();

        int employeesnumber = 0;

        while ("Y".equals(Y)) {
            System.out.print("Enter an employyes number:    ");
            int number = k.nextInt();

            while (one.checkfordigit(number) == false) {
                System.out.print("Invalid,Enter proper employee number:    ");
                number = k.nextInt();
            }
            k.nextLine();

            System.out.print("Enter first name:       ");
            String firstname = k.nextLine();

            System.out.print("Enter last name:        ");
            String lastname = k.next();

            System.out.print("Enter hours worked:     ");
            double hours = k.nextDouble();

            while (hours <= 0 || hours > 160) {
                System.out.print("enter valid hour:    ");
                hours = k.nextDouble();
            }

            System.out.print("Enter hourly wage:       ");
            double hourlywage = k.nextDouble();

            while (hourlywage <= 0) {
                System.out.println("Enter a valid hourwage:    ");
                hourlywage = k.nextDouble();
            }
            one.processinfo(firstname, lastname, hours, hourlywage);

            DecimalFormat currencyFormat = new DecimalFormat("$#,###.00");

            one.processcalculations();
            System.out.println("Worker" + number + "paycheck information :");
            System.out.println("name is:  " + one.getEmployeename());
            System.out.println("the weekly pay is: " + 
                    currencyFormat.format(one.getREgularpay()));
            System.out.println("Income tax is:  " + 
                    currencyFormat.format(one.getREgulartax()));

            System.out.println("Netpay is:  " + 
                    currencyFormat.format(one.getREgularpay() 
                            - one.getREgulartax()));

            if (one.getOVertimepay() > 0) {
            System.out.println("Worker" + number + "overtime's calculation :");
                System.out.println("overtime pay: " +
                        currencyFormat.format(one.getOVertimepay()));
                System.out.println("overtime tax is:   " + 
                        currencyFormat.format(one.getOVertimetax()));
                System.out.println("overtime netpay is:   " + 
                        currencyFormat.format(one.getOVertimepay()
                                - one.getOVertimetax()));
                System.out.println("Total netpay is:  " + 
                        currencyFormat.format(one.getREgularpay()
                        - one.getREgulartax()
                        + (one.getOVertimepay() - one.getOVertimetax())));
            }
            employeesnumber++;

            System.out.print
        ("Enter  Upper case Y to proceed another calculations:   ");
            Y = k.next();

        }
        System.out.println
        ("Total number of employees processed:   " + employeesnumber);

    }

}
