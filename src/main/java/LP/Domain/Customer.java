package LP.Domain;

public class Customer {
    public int customer_id;
    public String customer_firstname;
    public String customer_lastname;
    public String customer_email;

    public Customer(int customer_id, String customer_firstname, String customer_lastname, String customer_email) {
        this.customer_id = customer_id;
        this.customer_firstname = customer_firstname;
        this.customer_lastname = customer_lastname;
        this.customer_email = customer_email;
    }

    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    public String getCustomer_firstname() {
        return customer_firstname;
    }

    public void setCustomer_firstname(String customer_firstname) {
        this.customer_firstname = customer_firstname;
    }

    public String getCustomer_lastname() {
        return customer_lastname;
    }

    public void setCustomer_lastname(String customer_lastname) {
        this.customer_lastname = customer_lastname;
    }

    public String getCustomer_email() {
        return customer_email;
    }

    public void setCustomer_email(String customer_email) {
        this.customer_email = customer_email;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customer_id=" + customer_id +
                ", customer_firstname='" + customer_firstname + '\'' +
                ", customer_lastname='" + customer_lastname + '\'' +
                ", customer_email='" + customer_email + '\'' +
                '}';
    }
}
