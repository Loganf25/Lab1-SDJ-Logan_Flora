//Register Class that takes a purse and an amount and returns smallest amount of change to purse
import java.util.Scanner;

public class Register {
    //Main for printing out purse instead of using gui (testing)
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter amount to to get change:  ");
        double amount = sc.nextDouble();
        if(amount < 0.01)
            System.out.println("Empty Purse");
        else {
            Purse bank = makeChange(amount);
            bank.toString();
        }
    }
//Main change making function
    public static Purse makeChange(double amt) {
        //Variables
        Purse retPur = new Purse();
        double left = amt;
        //This for loop will go through the created and sorted (biggest to smallest denomination)
        //list of denominations one by one
        for(Denomination curr : Denomination.denominations) {
            int numOfDen = 0;
            //And find the amount of each denomination to add
            while(left >= curr.amt()){
                numOfDen++;
                left -= curr.amt();
                left = Math.round(left * 100.00) / 100.00;
            }
            //And adding that said amount and to the purse
            retPur.add(curr, numOfDen);
        }
        return retPur;
    }
}
