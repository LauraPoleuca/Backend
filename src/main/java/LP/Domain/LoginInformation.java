package LP.Domain;

public class LoginInformation {
    public int customer_id;
    public String customer_username;
    public String customer_password;
    public String signup_date;

    public LoginInformation(int customer_id, String customer_username, String customer_password, String signup_date) {
        this.customer_id = customer_id;
        this.customer_username = customer_username;
        this.customer_password = customer_password;
        this.signup_date = signup_date;
    }

    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    public String getCustomer_username() {
        return customer_username;
    }

    public void setCustomer_username(String customer_username) {
        this.customer_username = customer_username;
    }

    public String getCustomer_password() {
        return customer_password;
    }

    public void setCustomer_password(String customer_password) {
        this.customer_password = customer_password;
    }

    public String getSignup_date() {
        return signup_date;
    }

    public void setSignup_date(String signup_date) {
        this.signup_date = signup_date;
    }

    @Override
    public String toString() {
        return "LoginInformation{" +
                "customer_id=" + customer_id +
                ", customer_username='" + customer_username + '\'' +
                ", customer_password='" + customer_password + '\'' +
                ", signup_date='" + signup_date + '\'' +
                '}';
    }
}
