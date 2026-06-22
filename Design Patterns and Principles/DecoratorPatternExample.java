// 1. The Component Interface
interface Coffee {
    String getDescription();
    double getCost();
}

// 2. Concrete Component (The core object)
class PlainCoffee implements Coffee {
    @Override
    public String getDescription() {
        return "Plain Coffee";
    }

    @Override
    public double getCost() {
        return 50.0; // Base price in Rs or $
    }
}

// 3. The Base Decorator
abstract class CoffeeDecorator implements Coffee {
    protected final Coffee decoratedCoffee; // Reference to the wrapped object

    public CoffeeDecorator(Coffee coffee) {
        this.decoratedCoffee = coffee;
    }

    @Override
    public String getDescription() {
        return decoratedCoffee.getDescription();
    }

    @Override
    public double getCost() {
        return decoratedCoffee.getCost();
    }
}

// 4. Concrete Decorator A (Adds Milk behavior)
class MilkDecorator extends CoffeeDecorator {
    public MilkDecorator(Coffee coffee) {
        super(coffee);
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", Milk";
    }

    @Override
    public double getCost() {
        return super.getCost() + 15.0; // Adds cost of milk
    }
}

// 5. Concrete Decorator B (Adds Whip Cream behavior)
class WhipDecorator extends CoffeeDecorator {
    public WhipDecorator(Coffee coffee) {
        super(coffee);
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", Whip Cream";
    }

    @Override
    public double getCost() {
        return super.getCost() + 25.0; // Adds cost of whip cream
    }
}

// 6. Client Code
public class DecoratorPatternExample {
    public static void main(String[] args) {
        // Order a simple plain coffee
        Coffee myCoffee = new PlainCoffee();
        System.out.println(myCoffee.getDescription() + " -> Rs." + myCoffee.getCost());

        // Wrap it with Milk
        myCoffee = new MilkDecorator(myCoffee);
        System.out.println(myCoffee.getDescription() + " -> Rs." + myCoffee.getCost());

        // Wrap it again with Whip Cream dynamically at runtime!
        myCoffee = new WhipDecorator(myCoffee);
        System.out.println(myCoffee.getDescription() + " -> Rs." + myCoffee.getCost());
    }
}