package LP.Controllers;

import LP.BusinessLogic.TransactionBusinessLogic;
import LP.Domain.Transaction;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path = "api/transaction")
public class TransactionController {
    private TransactionBusinessLogic transactionBusinessLogic;

    @GetMapping
    public List<Transaction> RetrieveTransaction() {
        List<Transaction> temp=transactionBusinessLogic.RetrieveTransaction();
        return temp;
    }

    public TransactionController(TransactionBusinessLogic transactionBusinessLogic) {
        this.transactionBusinessLogic= transactionBusinessLogic;
    }

    @PostMapping
    public void CreateTransaction(@RequestParam int customer_id, @RequestParam int total_price,@RequestParam String method_of_payment,@RequestParam String transaction_date){
        transactionBusinessLogic.CreateTransaction(customer_id,total_price,method_of_payment,transaction_date);
    }

    @DeleteMapping
    public void DeleteTransaction(@RequestParam int transaction_id) {
        transactionBusinessLogic.DeleteTransaction(transaction_id);
    }

    @GetMapping("/CustomerIDs")
    public List<Integer> RetrieveCustomerIDs() {
        List<Integer> temp=transactionBusinessLogic.RetrieveCustomerIDs();
        return temp;
    }

}
