package rvt;

public class Money {
    private final int euros;
    private final int cents;

     // contructor
    public Money(int euros, int cents) {
    this.euros = euros;
    this.cents = cents;
}

    // Constructor overloading // Second class constructor
    public Money(){
        this.euros = 0;
            this.cents = 0;
}

    // Third constructor
    public Money(int euros) {
    this.euros = euros;
    this.cents = 0;
}

    public int euros() {
        return euros;
}

    public int cents() {
        return cents;
}

    public String toString() {
    String zero = "";
    if (cents <= 10) {
        zero = "0";
}

    return euros + "." + zero + cents + "e";
}

    public Money plus(int euroAmount){
    int newEuros = this.euros + euroAmount;

    return new Money(newEuros, 0);
}

    public boolean lessThan(Money compared){

    String toString() {
    String zero = " ";
    if (cents < 10){
        zero = "0";
}
}
    Money newMoney1 = new Money(10, 0);
    Money newMoney2 = new Money(3, 0);
    Money newMoney3 = new Money(5, 0);

    System.out.println(newMoney1.lessThan(newMoney2)); // False
    System.out.println(newMoney2.lessthan(newMoney3)); // True
}

    public Money minus(Money decreaser){
        if (this.euros - decreseaser.euros <= 0);
    Money newMoney1 = new Money(10, 0);
    Money newMoney2 = new Money(3, 50);

    Money newMoney3 = newMoney1.minus(newMoney2);

    System.out.println(newMoney1);
    System.out.println(newMoney2);
    System.out.println(newMoney3);

    newMoney3 = newMoney;
}
}