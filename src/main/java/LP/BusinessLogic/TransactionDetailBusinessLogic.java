package LP.BusinessLogic;

import LP.DataAccess.TransactionDetailDataAccess;
import LP.Domain.TransactionDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TransactionDetailBusinessLogic {
    private TransactionDetailDataAccess transactionDetailDataAccess;

    @Autowired
    public TransactionDetailBusinessLogic(TransactionDetailDataAccess transactionDetailDataAccess) {
        this.transactionDetailDataAccess = transactionDetailDataAccess;
    }

    public List<TransactionDetail> RetrieveTransactionDetail() {
        List<TransactionDetail> temp=transactionDetailDataAccess.RetrieveTransactionDetail();
        return temp;
    }

    public void CreateTransactionDetail(int transaction_id,int instrument_id, int quantity) {
        transactionDetailDataAccess.CreateTransactionDetail(transaction_id,instrument_id,quantity);
    }

    public void DeleteTransactionDetail(int transaction_id,int instrument_id) {
        transactionDetailDataAccess.DeleteTransactionDetail(transaction_id,instrument_id);
    }

    public List<Integer> RetrieveTransactionIDs() {
        List<Integer> temp=transactionDetailDataAccess.RetrieveTransactionIDs();
        return temp;
    }

    public List<Integer> RetrieveInstrumentIDs() {
        List<Integer> temp=transactionDetailDataAccess.RetrieveInstrumentIDs();
        return temp;
    }
}
