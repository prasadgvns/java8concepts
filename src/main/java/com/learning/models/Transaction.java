package com.learning.models;

import java.util.Arrays;
import java.util.Currency;
import java.util.List;

public class Transaction {

    private final Trader trader;
    private final int year;
    private final int value;

    private final Currency currency;


    public Transaction(Trader trader, int year, int value, Currency currency){
        this.trader = trader;
        this.year = year;
        this.value = value;
        this.currency = currency;
    }
    public Trader getTrader(){
        return this.trader;
    }
    public int getYear(){
        return this.year;
    }
    public int getValue(){
        return this.value;
    }

    public Currency getCurrency() {
        return currency;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "trader=" + trader +
                ", year=" + year +
                ", value=" + value +
                ", currency=" + currency +
                '}';
    }

    public static List<Transaction> getTransactionsList(){
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario","Milan");
        Trader alan = new Trader("Alan","Cambridge");
        Trader brian = new Trader("Brian","Cambridge");

        return Arrays.asList(
                new Transaction(brian, 2011, 300, Currency.getInstance("USD")),
                new Transaction(raoul, 2012, 1000, Currency.getInstance("USD")),
                new Transaction(raoul, 2011, 400,Currency.getInstance("USD")),
                new Transaction(mario, 2012, 710,Currency.getInstance("JPY")),
                new Transaction(mario, 2012, 700,Currency.getInstance("JPY")),
                new Transaction(alan, 2012, 950,Currency.getInstance("AUD"))
        );
    }
}
