import java.util.ArrayList;
import java.util.List;

interface Observer {
    void update(String stockSymbol, double price);
}

interface Stock {
    void registerObserver(Observer observer);
    void deregisterObserver(Observer observer);
    void notifyObservers();
}


class StockMarket implements Stock {
    private final List<Observer> observers = new ArrayList<>();
    private String stockSymbol;
    private double price;

    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    public void deregisterObserver(Observer observer) {
        observers.remove(observer);
    }

    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(stockSymbol, price);
        }
    }

    public void setStockPrice(String stockSymbol, double price) {
        this.stockSymbol = stockSymbol;
        this.price = price;
        notifyObservers();
    }
}

class MobileApp implements Observer {
    public void update(String stockSymbol, double price) {
        System.out.println("[Mobile App] " + stockSymbol + " is now $" + price);
    }
}

class WebApp implements Observer {
    public void update(String stockSymbol, double price) {
        System.out.println("[Web App] " + stockSymbol + " is now $" + price);
    }
}

public class ObserverPatternDemo {
    public static void main(String[] args) {
        StockMarket stockMarket = new StockMarket();

        Observer mobileApp = new MobileApp();
        Observer webApp = new WebApp();

        stockMarket.registerObserver(mobileApp);
        stockMarket.registerObserver(webApp);

        stockMarket.setStockPrice("AAPL", 189.50);

        stockMarket.deregisterObserver(webApp);
        System.out.println("-- WebApp unsubscribed --");

        stockMarket.setStockPrice("AAPL", 191.20);
    }
}