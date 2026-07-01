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

    public String getProductId() {
        return productId;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product ID: " + productId +
                ", Name: " + productName +
                ", Quantity: " + quantity +
                ", Price: " + price;
    }
}

class InventoryManager {
    private HashMap<String, Product> inventory = new HashMap<>();

    public void addProduct(Product product) {
        inventory.put(product.getProductId(), product);
        System.out.println("Product Added.");
    }

    public void updateProduct(String productId, int quantity, double price) {
        Product product = inventory.get(productId);
        if (product != null) {
            product.setQuantity(quantity);
            product.setPrice(price);
            System.out.println("Product Updated.");
        } else {
            System.out.println("Product Not Found.");
        }
    }

    public void deleteProduct(String productId) {
        if (inventory.remove(productId) != null) {
            System.out.println("Product Deleted.");
        } else {
            System.out.println("Product Not Found.");
        }
    }

    public void displayProducts() {
        for (Product product : inventory.values()) {
            System.out.println(product);
        }
    }
}

public class InventoryManagementSystem {
    public static void main(String[] args) {
        InventoryManager manager = new InventoryManager();

        manager.addProduct(new Product("P101", "Laptop", 10, 55000));
        manager.addProduct(new Product("P102", "Mouse", 50, 700));
        manager.addProduct(new Product("P103", "Keyboard", 30, 1200));

        System.out.println("\nInventory:");
        manager.displayProducts();

        System.out.println("\nUpdating Product...");
        manager.updateProduct("P102", 60, 750);

        System.out.println("\nInventory:");
        manager.displayProducts();

        System.out.println("\nDeleting Product...");
        manager.deleteProduct("P101");

        System.out.println("\nFinal Inventory:");
        manager.displayProducts();
    }
}
