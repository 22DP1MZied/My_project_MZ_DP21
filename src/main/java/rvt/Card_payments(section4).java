public class SimpleDate {
    private int day;
    private int month;
    private int year;

    public SimpleDate(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public int getDay() {
        return this.day;
    }

    public int getMonth() {
        return this.month;
    }

    public int getYear() {
        return this.year;
    }

    @Override
    public String toString() {
        return this.day + "." + this.month + "." + this.year;
    }
}

public class Person {
    private String name;
    private SimpleDate birthday;
    private int weight = 0;
    private int length = 0;

    public Person(String name, SimpleDate date) {
        this.name = name;
        this.birthday = date;
    }

    public Person(String name, int day, int month, int year) {
        this.name = name;
        this.birthday = new SimpleDate(day, month, year);
    }

    public String toString() {
        return this.name + ", born on " + this.birthday;
    }
}

public class PaymentCard {
    private double balance;

    public PaymentCard(double balance) {
        this.balance = balance;
    }

    public double balance() {
        return this.balance;
    }

    public void addMoney(double increase) {
        this.balance = this.balance + increase;
    }

    public boolean takeMoney(double amount) {
        if (this.balance >= amount) {
            this.balance -= amount;
            return true;
        }
        return false;
    }
}

public class PaymentTerminal {
    private double money;
    private int affordableMeals;
    private int heartyMeals;

    public PaymentTerminal() {
        this.money = 1000.0;
    }

    public double eatAffordably(double payment) {
        double affordableMealPrice = 2.50;
        if (payment >= affordableMealPrice) {
            this.money += affordableMealPrice;
            this.affordableMeals++;
            return payment - affordableMealPrice;
        }
        return payment;
    }

    public double eatHeartily(double payment) {
        double heartyMealPrice = 4.30;
        if (payment >= heartyMealPrice) {
            this.money += heartyMealPrice;
            this.heartyMeals++;
            return payment - heartyMealPrice;
        }
        return payment;
    }

    public String toString() {
        return "money: " + money + ", number of sold affordable meals: " + affordableMeals
                + ", number of sold hearty meals: " + heartyMeals;
    }

    public boolean eatAffordably(PaymentCard card) {
        double affordableMealPrice = 2.50;
        if (card.takeMoney(affordableMealPrice)) {
            this.affordableMeals++;
            return true;
        }
        return false;
    }

    public boolean eatHeartily(PaymentCard card) {
        double heartyMealPrice = 4.30;
        if (card.takeMoney(heartyMealPrice)) {
            this.heartyMeals++;
            return true;
        }
        return false;
    }

    public void addMoneyToCard(PaymentCard card, double sum) {
        if (sum > 0) {
            card.addMoney(sum);
            this.money += sum;
        }
    }
}

public class MainProgram {
    public static void main(String[] args) {
        PaymentCard petesCard = new PaymentCard(10);

        System.out.println("money " + petesCard.balance());
        boolean wasSuccessful = petesCard.takeMoney(8);
        System.out.println("successfully took: " + wasSuccessful);
        System.out.println("money " + petesCard.balance());

        wasSuccessful = petesCard.takeMoney(4);
        System.out.println("successfully took: " + wasSuccessful);
        System.out.println("money " + petesCard.balance());

        PaymentTerminal unicafeExactum = new PaymentTerminal();

        double change = unicafeExactum.eatAffordably(10);
        System.out.println("remaining change: " + change);

        change = unicafeExactum.eatAffordably(5);
        System.out.println("remaining change: " + change);

        change = unicafeExactum.eatHeartily(4.3);
        System.out.println("remaining change: " + change);

        System.out.println(unicafeExactum);

        PaymentCard annesCard = new PaymentCard(7);

        boolean cardWasSuccessful = unicafeExactum.eatHeartily(annesCard);
        System.out.println("there was enough money: " + cardWasSuccessful);
        cardWasSuccessful = unicafeExactum.eatHeartily(annesCard);
        System.out.println("there was enough money: " + cardWasSuccessful);
        cardWasSuccessful = unicafeExactum.eatAffordably(annesCard);
        System.out.println("there was enough money: " + cardWasSuccessful);

        System.out.println(unicafeExactum);

        unicafeExactum.addMoneyToCard(annesCard, 100);

        cardWasSuccessful = unicafeExactum.eatHeartily(annesCard);
        System.out.println("there was enough money: " + cardWasSuccessful);

        System.out.println("amount of money on the card is " + annesCard.balance() + " euros");

        System.out.println(unicafeExactum);
    }
}
