package LP.DataAccess;

import LP.Domain.LoginInformation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class LoginInformationDataAccess {
    private BaseDataAccess baseDataAccess;

    @Autowired
    public LoginInformationDataAccess(BaseDataAccess baseDataAccess) {
        this.baseDataAccess = baseDataAccess;
    }

    public List<LoginInformation> RetrieveLoginInformation() {
        List<LoginInformation> resultSelectList =new ArrayList<>();
        ResultSet resultSelect = baseDataAccess.ExecuteSelect("select * from login_information");
        try {
            while (resultSelect.next()) {
                int customer_id=resultSelect.getInt(1);
                String customer_username=resultSelect.getNString(2);
                String customer_password=resultSelect.getNString(3);
                String signup_date=resultSelect.getString(4);
                LoginInformation loginInformation=new LoginInformation(customer_id,customer_username,customer_password,signup_date);
                resultSelectList.add(loginInformation);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultSelectList;
    }

    public void CreateLoginInformation(int customer_id,String customer_username,String customer_password,String signup_date)
    {
        String query=String.format("INSERT INTO login_information(customer_id,customer_username,customer_password,signup_date) VALUES ('%d','%s','%s','%s')",customer_id,customer_username,customer_password,signup_date);
        baseDataAccess.ExecuteCUD(query);
    }

    public void UpdateLoginInformation(int customer_id,String customer_username,String customer_password) {
        String query = String.format("UPDATE login_information SET customer_username= '%s',customer_password= '%s' WHERE customer_id = '%d'",
                customer_username,customer_password,customer_id);
        baseDataAccess.ExecuteCUD(query);
    }

    public void DeleteLoginInformation(int customer_id) {
        String query = String.format("DELETE FROM login_information WHERE customer_id = %d", customer_id);
        baseDataAccess.ExecuteCUD(query);
    }
}
