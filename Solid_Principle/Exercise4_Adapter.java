interface PaymentProcessor {
    void processPayment(double amount);
}

class PayPalGateway {
    public void sendPayment(double amountInUSD) {
        System.out.println("PayPal: Sent payment of $" + amountInUSD);
    }
}

class StripeGateway {
    public void makeCharge(int amountInCents) {
        System.out.println("Stripe: Charged " + amountInCents + " cents");
    }
}

class PayPalAdapter implements PaymentProcessor {
    private final PayPalGateway payPalGateway;

    public PayPalAdapter(PayPalGateway payPalGateway) {
        this.payPalGateway = payPalGateway;
    }

    public void processPayment(double amount) {
        payPalGateway.sendPayment(amount);
    }
}

class StripeAdapter implements PaymentProcessor {
    private final StripeGateway stripeGateway;

    public StripeAdapter(StripeGateway stripeGateway) {
        this.stripeGateway = stripeGateway;
    }

    public void processPayment(double amount) {
        int cents = (int) Math.round(amount * 100);
        stripeGateway.makeCharge(cents);
    }
}

public class AdapterPatternDemo {
    public static void main(String[] args) {
        PaymentProcessor payPal = new PayPalAdapter(new PayPalGateway());
        PaymentProcessor stripe = new StripeAdapter(new StripeGateway());

        payPal.processPayment(49.99);
        stripe.processPayment(19.50);
    }
}