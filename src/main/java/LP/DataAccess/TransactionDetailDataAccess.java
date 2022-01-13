package LP.DataAccess;

import LP.Domain.TransactionDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class TransactionDetailDataAccess {
    private BaseDataAccess baseDataAccess;

    @Autowired
    public TransactionDetailDataAccess(BaseDataAccess baseDataAccess) {
        this.baseDataAccess = baseDataAccess;
    }

    public List<TransactionDetail> RetrieveTransactionDetail() {
        List<TransactionDetail> resultSelectList = new ArrayList<>();
        ResultSet resultSelect = baseDataAccess.ExecuteSelect("select * from transaction_detail");
        try {
            while (resultSelect.next()) {
                int transaction_id = resultSelect.getInt(1);
                int instrument_id = resultSelect.getInt(2);
                int quantity = resultSelect.getInt(3);
                TransactionDetail transactionDetail = new TransactionDetail(transaction_id, instrument_id, quantity);
                resultSelectList.add(transactionDetail);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultSelectList;
    }

    public void CreateTransactionDetail(int transaction_id, int instrument_id, int quantity) {
        String query = String.format("INSERT INTO transaction_detail(transaction_id,instrument_id,quantity) VALUES ('%d','%d','%d')", transaction_id, instrument_id, quantity);
        baseDataAccess.ExecuteCUD(query);
    }

    public void UpdateTransactionDetail(int transaction_id, int instrument_id, int quantity) {
        String query = String.format("UPDATE transaction_detail SET quantity= '%d' WHERE transaction_id='%d' AND instrument_id = '%d'",
                quantity, transaction_id, instrument_id);
        baseDataAccess.ExecuteCUD(query);
    }

    public void DeleteTransactionDetail(int transaction_id, int instrument_id) {
        String query = String.format("DELETE FROM transaction_detail WHERE transaction_id = %d AND instrument_id =%d", transaction_id, instrument_id);
        baseDataAccess.ExecuteCUD(query);
    }

    public List<Integer> RetrieveTransactionIDs()
    {
        List<Integer> resultSelectList =new ArrayList<>();
        ResultSet resultSelect = baseDataAccess.ExecuteSelect("select transaction_id from transaction");
        try {
            while (resultSelect.next()) {
                resultSelectList.add(resultSelect.getInt(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultSelectList;
    }

    public List<Integer> RetrieveInstrumentIDs()
    {
        List<Integer> resultSelectList =new ArrayList<>();
        ResultSet resultSelect = baseDataAccess.ExecuteSelect("select instrument_id from instrument");
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
