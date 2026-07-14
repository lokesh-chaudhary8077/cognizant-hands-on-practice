class Order {
    private String orderId;
    private String customerName;
    private double totalPrice;
    //

    public Order(String orderId, String customerName, double totalPrice) {
        this.orderId = orderId;
        this.customerName = customerName;
        this.totalPrice = totalPrice;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    @Override
    public String toString() {
        return orderId + " " + customerName + " " + totalPrice;
    }
}

public class OrderSorting {

    public static void bubbleSort(Order[] orders) {
        int n = orders.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (orders[j].getTotalPrice() > orders[j + 1].getTotalPrice()) {
                    Order temp = orders[j];
                    orders[j] = orders[j + 1];
                    orders[j + 1] = temp;
                }
            }
        }
    }

    public static void quickSort(Order[] orders, int low, int high) {
        if (low < high) {
            int pi = partition(orders, low, high);
            quickSort(orders, low, pi - 1);
            quickSort(orders, pi + 1, high);
        }
    }

    public static int partition(Order[] orders, int low, int high) {
        double pivot = orders[high].getTotalPrice();
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (orders[j].getTotalPrice() <= pivot) {
                i++;
                Order temp = orders[i];
                orders[i] = orders[j];
                orders[j] = temp;
            }
        }

        Order temp = orders[i + 1];
        orders[i + 1] = orders[high];
        orders[high] = temp;

        return i + 1;
    }

    public static void display(Order[] orders) {
        for (Order order : orders) {
            System.out.println(order);
        }
    }

    public static void main(String[] args) {

        Order[] orders1 = {
            new Order("O101", "Rahul", 2500),
            new Order("O102", "Amit", 1500),
            new Order("O103", "Neha", 4500),
            new Order("O104", "Priya", 3000)
        };

        System.out.println("Bubble Sort:");
        bubbleSort(orders1);
        display(orders1);

        Order[] orders2 = {
            new Order("O101", "Rahul", 2500),
            new Order("O102", "Amit", 1500),
            new Order("O103", "Neha", 4500),
            new Order("O104", "Priya", 3000)
        };

        System.out.println("\nQuick Sort:");
        quickSort(orders2, 0, orders2.length - 1);
        display(orders2);
    }
}