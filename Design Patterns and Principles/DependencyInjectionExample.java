// This abstraction detaches our service logic from concrete data sources.
interface CustomerRepository {
    String findCustomerById(String customerId);
}

// handles the actual data retrieval logic (simulating a database query).
class CustomerRepositoryImpl implements CustomerRepository {
    @Override
    public String findCustomerById(String customerId) {
        // Simulating a database lookup
        if ("CUST-101".equals(customerId)) {
            return "Vivek Kumar (Premium Tier)";
        } else if ("CUST-102".equals(customerId)) {
            return "Yash (Standard Tier)";
        }
        return "Customer Not Found";
    }
}

// The service class contains business rules. It does NOT instantiate the
// repository itself; instead, it demands it via the constructor.
class CustomerService {
    private final CustomerRepository customerRepository; // Program to an interface

    // The dependency is supplied entirely from the outside
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public void renderCustomerProfile(String id) {
        System.out.println("[Business Logic] Processing profile request for ID: " + id);
        String customerData = customerRepository.findCustomerById(id);
        System.out.println("[Display Layer] Result: " + customerData);
    }
}

public class DependencyInjectionExample {
    public static void main(String[] args) {
        System.out.println("=== Customer Management System Initialization ===\n");

        // Manually create the low-level data dependency
        CustomerRepository repositoryInstance = new CustomerRepositoryImpl();

        // Inject the repository into the high-level service via its constructor
        CustomerService customerService = new CustomerService(repositoryInstance);

        // Test execution with a valid customer ID
        customerService.renderCustomerProfile("CUST-101");

        System.out.println("\n-------------------------------------------------\n");

        // Test execution with another customer ID
        customerService.renderCustomerProfile("CUST-102");
    }
}