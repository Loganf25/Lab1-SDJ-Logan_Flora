//Holds the Purse Class that has a map with the amount of each domination that the purse holds
import java.util.*;

public class Purse {

    private final Map<Denomination, Integer> cash = new HashMap<>();

    public void add(Denomination type, int num){
        if(cash.containsKey(type)) {
            //Replace used if that denomination does not already occur in the purse
            cash.replace(type, cash.get(type), cash.get(type) + num);
        }
        else{
            cash.put(type, num);
        }
    }

    public double remove(Denomination type, int num){
        //Replaces the amount at the specified denomination with that amount minus that asking to be removed
        //I assumed this the way to go as a denomination and num are passed as parameters rather than having to erase the whole purse, which I thought it could be
        cash.replace(type, cash.get(type), cash.get(type) - num);
        return num * type.amt();
    }

    public double getValue(){
        double total = 0;
        //Loops through every key:value pair in the Map and adds up the weight of the denomination by its quantity(value)
        for(Map.Entry<Denomination, Integer> entry : cash.entrySet()){
            total += entry.getKey().amt() * entry.getValue();
        }
        return total;
    }

    public String toString(){
        for(Denomination curr : Denomination.denominations)
        {
            if (cash.get(curr) > 1)
                System.out.println(cash.get(curr) + " " + curr.name() + "s");
            else if (cash.get(curr) == 1)
                System.out.println(cash.get(curr) + " " + curr.name());
        }
        return " ";
    }
}
