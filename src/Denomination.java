import java.util.*;
public record Denomination(String name, double amt, String form, String img) {
    //All final instances for Bills used
    public static final Denomination oneHundredDollars = new Denomination("One Hundred Dollar Bill", 100, "Paper Bill", "currency/hundred_note.png");
    public static final Denomination fiftyDollars = new Denomination("Fifty Dollar Bill", 50, "Paper Bill", "currency/fifty_note.png");
    public static final Denomination twentyDollars = new Denomination("Twenty Dollar Bill", 20, "Paper Bill", "currency/twenty_note.png");
    public static final Denomination tenDollars = new Denomination("Ten Dollar Bill", 10, "Paper Bill", "currency/ten_note.png");
    public static final Denomination fiveDollars = new Denomination("Five Dollar Bill", 5, "Paper Bill", "currency/five_note.png");
    public static final Denomination oneDollar = new Denomination("One Dollar Bill", 1, "Paper Bill", "currency/one_note.png");
    //All final instances for Coins used
    public static final Denomination twentyFiveCents = new Denomination( "Quarter", 0.25, "Coin", "currency/quarter.png");
    public static final Denomination tenCents = new Denomination("Dime", 0.10, "Coin", "currency/dime.png");
    public static final Denomination fiveCents = new Denomination("Nickel", 0.05, "Coin", "currency/nickel.png");
    public static final Denomination oneCent = new Denomination("Penny", 0.01, "Coin", "currency/penny.png");

    // Put all into list  to make makeChange much more compact and easy to code
    public static final List<Denomination> denominations = Arrays.asList(
            oneHundredDollars,
            fiftyDollars,
            twentyDollars,
            tenDollars,
            fiveDollars,
            oneDollar,
            twentyFiveCents,
            tenCents,
            fiveCents,
            oneCent
    );
}
