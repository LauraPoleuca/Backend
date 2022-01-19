package LP.BusinessLogic;

import LP.DataAccess.LoginInformationDataAccess;
import LP.Domain.LoginInformation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LoginInformationBusinessLogic {
    private LoginInformationDataAccess loginInformationDataAccess;

    @Autowired
    public LoginInformationBusinessLogic(LoginInformationDataAccess loginInformationDataAccess) {
        this.loginInformationDataAccess = loginInformationDataAccess;
    }

    public List<LoginInformation> RetrieveLoginInformation() {
        List<LoginInformation> temp=loginInformationDataAccess.RetrieveLoginInformation();
        return temp;
    }

    public void CreateLoginInformation(int customer_id,String customer_username, String customer_password,String signup_date){
        loginInformationDataAccess.CreateLoginInformation(customer_id,customer_username,customer_password,signup_date);
    }

    public void DeleteLoginInformation(int customer_id) {
        loginInformationDataAccess.DeleteLoginInformation(customer_id);
    }
}
