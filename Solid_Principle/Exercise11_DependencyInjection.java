import java.util.HashMap;
import java.util.Map;

interface CustomerRepository {
    String findCustomerById(int id);
}


class CustomerRepositoryImpl implements CustomerRepository {
    private final Map<Integer, String> customers = new HashMap<>();

    public CustomerRepositoryImpl() {
        customers.put(1, "Ravi Kumar");
        customers.put(2, "Priya Singh");
        customers.put(3, "John Mathew");
    }

    public String findCustomerById(int id) {
        return customers.getOrDefault(id, "Customer not found");
    }
}

class CustomerService {
    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public void printCustomerDetails(int id) {
        String customerName = customerRepository.findCustomerById(id);
        System.out.println("Customer #" + id + ": " + customerName);
    }
}

public class DependencyInjectionDemo {
    public static void main(String[] args) {
        CustomerRepository repository = new CustomerRepositoryImpl();
        CustomerService customerService = new CustomerService(repository);

        customerService.printCustomerDetails(1);
        customerService.printCustomerDetails(2);
        customerService.printCustomerDetails(99);
    }
}