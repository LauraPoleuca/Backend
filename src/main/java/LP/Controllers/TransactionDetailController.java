package LP.Controllers;

import LP.BusinessLogic.TransactionDetailBusinessLogic;
import LP.Domain.TransactionDetail;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path = "api/transaction_detail")
public class TransactionDetailController {
    private TransactionDetailBusinessLogic transactionDetailBusinessLogic;

    @GetMapping
    public List<TransactionDetail> RetrieveTransactionDetail() {
        List<TransactionDetail> temp=transactionDetailBusinessLogic.RetrieveTransactionDetail();
        return temp;
    }

    public TransactionDetailController(TransactionDetailBusinessLogic transactionDetailBusinessLogic) {
        this.transactionDetailBusinessLogic = transactionDetailBusinessLogic;
    }

    @PostMapping
    public void CreateTransactionDetail(@RequestParam int transaction_id, @RequestParam int instrument_id, @RequestParam int quantity){
        transactionDetailBusinessLogic.CreateTransactionDetail(transaction_id,instrument_id,quantity);
    }

    @DeleteMapping
    public void DeleteTransactionDetail(@RequestParam int transaction_id,@RequestParam int instrument_id) {
        transactionDetailBusinessLogic.DeleteTransactionDetail(transaction_id,instrument_id);
    }

    @GetMapping("/TransactionIDs")
    public List<Integer> RetrieveTrasactionIDs() {
        List<Integer> temp=transactionDetailBusinessLogic.RetrieveTransactionIDs();
        return temp;
    }

    @GetMapping("/InstrumentIDs")
    public List<Integer> RetrieveInstrumentIDs() {
        List<Integer> temp=transactionDetailBusinessLogic.RetrieveInstrumentIDs();
        return temp;
    }
}
