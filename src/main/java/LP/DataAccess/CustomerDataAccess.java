package LP.DataAccess;

import LP.Domain.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class CustomerDataAccess {
    private BaseDataAccess baseDataAccess;

    @Autowired
    public CustomerDataAccess(BaseDataAccess baseDataAccess) {
        this.baseDataAccess = baseDataAccess;
    }

    public List<Customer> RetrieveCustomer() {
        List<Customer> resultSelectList =new ArrayList<>();
        ResultSet resultSelect = baseDataAccess.ExecuteSelect("select * from customer");
        try {
            while (resultSelect.next()) {
                int customer_id=resultSelect.getInt(1);
                String customer_firstname=resultSelect.getNString(2);
                String customer_lastname=resultSelect.getNString(3);
                String customer_email=resultSelect.getNString(4);
                Customer customer=new Customer(customer_id,customer_firstname,customer_lastname,customer_email);
                resultSelectList.add(customer);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultSelectList;
    }

    public void CreateCustomer(String customer_firstname,String customer_lastname,String customer_email)
    {
        String query=String.format("INSERT INTO customer(customer_firstname,customer_lastname,customer_email) VALUES ('%s','%s','%s')",customer_firstname,customer_lastname,customer_email);
        baseDataAccess.ExecuteCUD(query);
    }

    public void UpdateCustomer(int customer_id,String customer_firstname,String customer_lastname,String customer_email) {
        String query = String.format("UPDATE customer SET customer_firstname= '%s', customer_lastname='%s', customer_email='%s' WHERE customer_id = '%d'",customer_firstname,customer_lastname,customer_email,customer_id);
        baseDataAccess.ExecuteCUD(query);
    }

    public void DeleteCustomer(int customer_id) {
        String query = String.format("DELETE FROM customer WHERE customer_id = %d", customer_id);
        baseDataAccess.ExecuteCUD(query);
    }


}
