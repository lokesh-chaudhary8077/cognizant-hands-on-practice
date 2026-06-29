import java.util.Arrays;
import java.util.Comparator;


class Product {
    private final String productId;
    private final String productName;
    private final String category;

    public Product(String productId, String productName, String category) {
        this.productId = productId;
        this.productName = productName;
        this.category = category;
    }

    public String getProductId() { return productId; }
    public String getProductName() { return productName; }
    public String getCategory() { return category; }

    @Override
    public String toString() {
        return String.format("[%s] %s (%s)", productId, productName, category);
    }
}


class SearchEngine {

    /**
     * Linear Search Algorithm
     * Scans every element sequentially from start to end.
     */
    public static int linearSearch(Product[] products, String targetId) {
        for (int i = 0; i < products.length; i++) {
            if (products[i].getProductId().equals(targetId)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Binary Search Algorithm
     * Divide-and-conquer approach. Requires a pre-sorted array.
     */
    public static int binarySearch(Product[] products, String targetId) {
        int left = 0;
        int right = products.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int comparison = products[mid].getProductId().compareTo(targetId);

            if (comparison == 0) {
                return mid;
            } else if (comparison < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
}


public class E_commercePlatformSearchFunction {
    public static void main(String[] args) {
        Product[] inventory = {
            new Product("P-902", "Mechanical Keyboard", "Electronics"),
            new Product("P-104", "Wireless Mouse", "Electronics"),
            new Product("P-551", "Ergonomic Office Chair", "Furniture"),
            new Product("P-310", "Noise Cancelling Headphones", "Electronics"),
            new Product("P-012", "USB-C Hub Multiport", "Accessories")
        };

        String searchTarget = "P-310";

        System.out.println("--- Executing Linear Search ---");
        int linearResultIndex = SearchEngine.linearSearch(inventory, searchTarget);
        printResult(linearResultIndex, inventory, searchTarget);

        System.out.println("\n-------------------------------------------------\n");

        System.out.println("--- Preparing Inventory for Binary Search ---");
        // Sort inventory array by Product ID string ordering
        Arrays.sort(inventory, Comparator.comparing(Product::getProductId));
        
        System.out.println("Sorted Inventory Layout:");
        for (Product p : inventory) System.out.println("  " + p);

        System.out.println("\n--- Executing Binary Search ---");
        int binaryResultIndex = SearchEngine.binarySearch(inventory, searchTarget);
        printResult(binaryResultIndex, inventory, searchTarget);
    }

    private static void printResult(int index, Product[] inventory, String target) {
        if (index != -1) {
            System.out.println("Success! Found target ID '" + target + "' at index location: " + index);
            System.out.println("Product Details: " + inventory[index]);
        } else {
            System.out.println("Result: Product with ID '" + target + "' was not found in catalog.");
        }
    }
}