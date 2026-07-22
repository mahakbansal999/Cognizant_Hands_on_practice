import java.util.HashMap;

class Product {
    private String productId;
    private String productName;
    private int quantity;
    private double price;

    public Product(String productId, String productName, int quantity, double price) {
        this.productId = productId;
        this.productName = productName;
        this.quantity = quantity;
        this.price = price;
    }

    public String getProductId() { return productId; }
    public String getProductName() { return productName; }
    public int getQuantity() { return quantity; }
    public double getPrice() { return price; }
    public void setQuantity(int quantity) { this.quantity = quantity; }
    public void setPrice(double price) { this.price = price; }

    @Override
    public String toString() {
        return String.format("Product[id=%s, name=%s, qty=%d, price=%.2f]",
                productId, productName, quantity, price);
    }
}

public class Exercise1_Inventory {
    private HashMap<String, Product> products;

    public Exercise1_Inventory() {
        products = new HashMap<>();
    }

    public void addProduct(Product product) {
        products.put(product.getProductId(), product);
    }

    public boolean updateProduct(String productId, int newQuantity, double newPrice) {
        Product p = products.get(productId);
        if (p == null) return false;
        p.setQuantity(newQuantity);
        p.setPrice(newPrice);
        return true;
    }

    public boolean deleteProduct(String productId) {
        return products.remove(productId) != null;
    }

    public Product getProduct(String productId) {
        return products.get(productId);
    }

    public static void main(String[] args) {
        Exercise1_Inventory inventory = new Exercise1_Inventory();
        inventory.addProduct(new Product("P001", "Wireless Mouse", 150, 19.99));
        inventory.addProduct(new Product("P002", "Mechanical Keyboard", 80, 49.99));

        inventory.updateProduct("P001", 140, 17.99);
        System.out.println(inventory.getProduct("P001"));

        inventory.deleteProduct("P002");
        System.out.println(inventory.getProduct("P002"));
    }
}
