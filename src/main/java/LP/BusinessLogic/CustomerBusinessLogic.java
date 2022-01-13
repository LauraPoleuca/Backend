package LP.BusinessLogic;

import LP.DataAccess.CustomerDataAccess;
import LP.Domain.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerBusinessLogic {
    private CustomerDataAccess customerDataAccess;

    @Autowired
    public CustomerBusinessLogic(CustomerDataAccess customerDataAccess) {
        this.customerDataAccess = customerDataAccess;
    }

    public List<Customer> RetrieveCustomer() {
        List<Customer> temp=customerDataAccess.RetrieveCustomer();
        return temp;
    }

    public void CreateCustomer(String customer_firstname,String customer_lastname,String customer_email) {
        customerDataAccess.CreateCustomer(customer_firstname,customer_lastname,customer_email);
    }

    public void UpdateCustomer(int customer_id,String customer_firstname,String customer_lastname,String customer_email) {
        customerDataAccess.UpdateCustomer(customer_id,customer_firstname,customer_lastname,customer_email);
    }

    public void DeleteCustomer(int customer_id) {
        customerDataAccess.DeleteCustomer(customer_id);
    }
}
