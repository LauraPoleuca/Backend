package LP.Domain;

public class Transaction {
    public int transaction_id;
    public int customer_id;
    public int total_price;
    public String method_of_payment;

    public Transaction(int transaction_id, int customer_id, int total_price, String method_of_payment) {
        this.transaction_id = transaction_id;
        this.customer_id = customer_id;
        this.total_price = total_price;
        this.method_of_payment = method_of_payment;
    }

    public int getTransaction_id() {
        return transaction_id;
    }

    public void setTransaction_id(int transaction_id) {
        this.transaction_id = transaction_id;
    }

    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    public int getTotal_price() {
        return total_price;
    }

    public void setTotal_price(int total_price) {
        this.total_price = total_price;
    }

    public String getMethod_of_payment() {
        return method_of_payment;
    }

    public void setMethod_of_payment(String method_of_payment) {
        this.method_of_payment = method_of_payment;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "transaction_id=" + transaction_id +
                ", customer_id=" + customer_id +
                ", total_price=" + total_price +
                ", method_of_payment='" + method_of_payment + '\'' +
                '}';
    }
}
