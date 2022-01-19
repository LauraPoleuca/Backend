package LP.Controllers;

import LP.BusinessLogic.LoginInformationBusinessLogic;
import LP.Domain.LoginInformation;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path = "api/login_information")
public class LoginInformationController {
    private LoginInformationBusinessLogic loginInformationBusinessLogic;

    @GetMapping
    public List<LoginInformation> RetrieveLoginInformation() {
        List<LoginInformation> temp=loginInformationBusinessLogic.RetrieveLoginInformation();
        return temp;
    }

    public LoginInformationController(LoginInformationBusinessLogic loginInformationBusinessLogic) {
        this.loginInformationBusinessLogic = loginInformationBusinessLogic;
    }

    @PostMapping
    public void CreateLoginInformation(@RequestParam int customer_id,@RequestParam String customer_username,@RequestParam String customer_password,@RequestParam String signup_date){
        loginInformationBusinessLogic.CreateLoginInformation(customer_id,customer_username,customer_password,signup_date);
    }

    @DeleteMapping
    public void DeleteLoginInformation(@RequestParam int customer_id) {
        loginInformationBusinessLogic.DeleteLoginInformation(customer_id);
    }
}
