package LP.Domain;

public class TransactionDetail {
    public int transaction_id;
    public int instrument_id;
    public int quantity;

    public TransactionDetail(int transaction_id, int instrument_id, int quantity) {
        this.transaction_id = transaction_id;
        this.instrument_id = instrument_id;
        this.quantity = quantity;
    }

    public int getTransaction_id() {
        return transaction_id;
    }

    public void setTransaction_id(int transaction_id) {
        this.transaction_id = transaction_id;
    }

    public int getInstrument_id() {
        return instrument_id;
    }

    public void setInstrument_id(int instrument_id) {
        this.instrument_id = instrument_id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "TransactionDetail{" +
                "transaction_id=" + transaction_id +
                ", instrument_id=" + instrument_id +
                ", quantity=" + quantity +
                '}';
    }
}
