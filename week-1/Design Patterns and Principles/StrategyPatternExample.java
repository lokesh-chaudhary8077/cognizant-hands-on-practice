// The Strategy Interface
interface PaymentStrategy {
    void pay(double amount);
}

// Concrete Strategy A
class CreditCardPayment implements PaymentStrategy {
    private String cardNumber;

    public CreditCardPayment(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    @Override
    public void pay(double amount) {
        System.out.println("Paid $" + amount + " using Credit Card ending in " + cardNumber.substring(cardNumber.length() - 4));
    }
}

// Concrete Strategy B
class PayPalPayment implements PaymentStrategy {
    private String email;

    public PayPalPayment(String email) {
        this.email = email;
    }

    @Override
    public void pay(double amount) {
        System.out.println("Paid $" + amount + " seamlessly using PayPal account: " + email);
    }
}

// The Context (The Shopping Cart itself)
class ShoppingCart {
    private PaymentStrategy paymentStrategy;

    // Allows dynamic swapping of strategies at runtime
    public void setPaymentStrategy(PaymentStrategy strategy) {
        this.paymentStrategy = strategy;
    }

    public void checkout(double amount) {
        if (paymentStrategy == null) {
            System.out.println("Error: Please select a payment method first!");
            return;
        }
        // Delegate the calculation behavioral task to the strategy object
        paymentStrategy.pay(amount);
    }
}

// Client Code
public class StrategyPatternExample {
    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();

        // Customer chooses to pay with Credit Card
        cart.setPaymentStrategy(new CreditCardPayment("1234567890123456"));
        cart.checkout(150.00);

        System.out.println("\n----------------------------------\n");

        // Same customer switches mind and switches strategy to PayPal instantly
        cart.setPaymentStrategy(new PayPalPayment("user@example.com"));
        cart.checkout(45.50);
    }
}