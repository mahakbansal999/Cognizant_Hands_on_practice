import java.util.Arrays;
import java.util.Comparator;

class Product2 {
    private String productId;
    private String productName;
    private String category;

    public Product2(String productId, String productName, String category) {
        this.productId = productId;
        this.productName = productName;
        this.category = category;
    }

    public String getProductId() { return productId; }
    public String getProductName() { return productName; }
    public String getCategory() { return category; }

    @Override
    public String toString() {
        return String.format("Product[id=%s, name=%s, category=%s]", productId, productName, category);
    }
}

public class Exercise2_Search {

    public static Product2 linearSearch(Product2[] products, String targetName) {
        for (Product2 p : products) {
            if (p.getProductName().equalsIgnoreCase(targetName)) {
                return p;
            }
        }
        return null;
    }

    public static Product2 binarySearch(Product2[] sortedProducts, String targetName) {
        int low = 0, high = sortedProducts.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            int cmp = sortedProducts[mid].getProductName().compareToIgnoreCase(targetName);

            if (cmp == 0) {
                return sortedProducts[mid];
            } else if (cmp < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Product2[] products = {
            new Product2("P003", "Yoga Mat", "Fitness"),
            new Product2("P001", "Bluetooth Speaker", "Electronics"),
            new Product2("P002", "Desk Lamp", "Home")
        };

        System.out.println(linearSearch(products, "Desk Lamp"));

        Product2[] sorted = products.clone();
        Arrays.sort(sorted, Comparator.comparing(Product2::getProductName));
        System.out.println(binarySearch(sorted, "Desk Lamp"));
    }
}
