interface Notifier {
    void send(String message);
}

class EmailNotifier implements Notifier {
    public void send(String message) {
        System.out.println("Sending EMAIL: " + message);
    }
}

abstract class NotifierDecorator implements Notifier {
    protected final Notifier wrappedNotifier;

    public NotifierDecorator(Notifier notifier) {
        this.wrappedNotifier = notifier;
    }

    public void send(String message) {
        wrappedNotifier.send(message);
    }
}

class SMSNotifierDecorator extends NotifierDecorator {
    public SMSNotifierDecorator(Notifier notifier) {
        super(notifier);
    }

    public void send(String message) {
        super.send(message);
        System.out.println("Sending SMS: " + message);
    }
}

class SlackNotifierDecorator extends NotifierDecorator {
    public SlackNotifierDecorator(Notifier notifier) {
        super(notifier);
    }

    public void send(String message) {
        super.send(message);
        System.out.println("Sending SLACK message: " + message);
    }
}

public class Exercise5_Decorator {
    public static void main(String[] args) {
        Notifier basic = new EmailNotifier();

        Notifier fullyDecorated = new SlackNotifierDecorator(
                                        new SMSNotifierDecorator(
                                            new EmailNotifier()));

        System.out.println("-- Basic notifier --");
        basic.send("Server restarted");

        System.out.println("\n-- Fully decorated notifier --");
        fullyDecorated.send("Critical alert: disk usage at 95%");
    }
}
