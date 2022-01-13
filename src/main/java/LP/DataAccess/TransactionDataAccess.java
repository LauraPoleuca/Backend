package LP.DataAccess;

import LP.Domain.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class TransactionDataAccess {
    private BaseDataAccess baseDataAccess;

    @Autowired
    public TransactionDataAccess(BaseDataAccess baseDataAccess) {
        this.baseDataAccess = baseDataAccess;
    }

    public List<Transaction> RetrieveTransaction() {
        List<Transaction> resultSelectList =new ArrayList<>();
        ResultSet resultSelect = baseDataAccess.ExecuteSelect("select * from transaction");
        try {
            while (resultSelect.next()) {
                int transaction_id=resultSelect.getInt(1);
                int customer_id=resultSelect.getInt(2);
                int total_price=resultSelect.getInt(3);
                String method_of_payment=resultSelect.getNString(4);
                Transaction transaction=new Transaction(transaction_id,customer_id,total_price,method_of_payment);
                resultSelectList.add(transaction);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultSelectList;
    }

    public void CreateTransaction(int customer_id,int total_price,String method_of_payment)
    {
        String query=String.format("INSERT INTO transaction(customer_id,total_price,method_of_payment) VALUES ('%d','%d','%s')",customer_id,total_price,method_of_payment);
        baseDataAccess.ExecuteCUD(query);
    }

    public void UpdateTransaction(int transaction_id,int customer_id,int total_price,String method_of_payment) {
        String query = String.format("UPDATE transaction SET customer_id= '%d', total_price='%d',method_of_payment='%s' WHERE transaction_id = '%d'",
                customer_id,total_price,method_of_payment);
        baseDataAccess.ExecuteCUD(query);
    }

    public void DeleteTransaction(int transaction_id) {
        String query = String.format("DELETE FROM transaction WHERE transaction_id = %d", transaction_id);
        baseDataAccess.ExecuteCUD(query);
    }

    public List<Integer> RetrieveCustomerIDs()
    {
        List<Integer> resultSelectList =new ArrayList<>();
        ResultSet resultSelect = baseDataAccess.ExecuteSelect("select customer_id from customer");
        try {
            while (resultSelect.next()) {
                resultSelectList.add(resultSelect.getInt(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultSelectList;
    }

    

}
