package LP.BusinessLogic;

import LP.DataAccess.TransactionDataAccess;
import LP.Domain.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Service
public class TransactionBusinessLogic {
    private TransactionDataAccess transactionDataAccess;

    @Autowired
    public TransactionBusinessLogic(TransactionDataAccess transactionDataAccess) {
        this.transactionDataAccess = transactionDataAccess;
    }

    public List<Transaction> RetrieveTransaction() {
        List<Transaction> temp=transactionDataAccess.RetrieveTransaction();
        return temp;
    }

    public void CreateTransaction(int customer_id,int total_price,String method_of_payment) {
        transactionDataAccess.CreateTransaction(customer_id,total_price,method_of_payment);
    }

    public void DeleteTransaction(int transaction_id) {
        transactionDataAccess.DeleteTransaction(transaction_id);
    }

    public List<Integer> RetrieveCustomerIDs() {
        List<Integer> temp=transactionDataAccess.RetrieveCustomerIDs();
        return temp;
    }
}
