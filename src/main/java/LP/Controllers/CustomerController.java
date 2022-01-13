package LP.Controllers;

import LP.BusinessLogic.CustomerBusinessLogic;
import LP.Domain.Customer;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path = "api/customer")
public class CustomerController {
    private CustomerBusinessLogic customerBusinessLogic;

    public CustomerController(CustomerBusinessLogic customerBusinessLogic) {
        this.customerBusinessLogic = customerBusinessLogic;
    }

    @GetMapping
    public List<Customer> RetrieveCustomer() {
        List<Customer> temp = customerBusinessLogic.RetrieveCustomer();
        return temp;
    }

    @PostMapping
    public void CreateCustomer(@RequestParam String customer_firstname, @RequestParam String customer_lastname, @RequestParam String customer_email) {
        customerBusinessLogic.CreateCustomer(customer_firstname, customer_lastname, customer_email);
    }

    @PutMapping
    public void UpdateCustomer(@RequestParam int customer_id, @RequestParam String customer_firstname, String customer_lastname, String customer_email) {
        customerBusinessLogic.UpdateCustomer(customer_id, customer_firstname, customer_lastname, customer_email);
    }

    @DeleteMapping
    public void DeleteCustomer(@RequestParam int customer_id) {
        customerBusinessLogic.DeleteCustomer(customer_id);
    }

}

