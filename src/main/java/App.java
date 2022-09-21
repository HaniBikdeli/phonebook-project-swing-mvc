import com.phonebook.view.*;
import com.phonebook.model.*;
import com.phonebook.controller.*;

    public class App {
        public static void main(String[] args) {
            LoginView loginView = new LoginView();
            LoginModel loginModel = new LoginModel("","");
            LoginController loginController = new LoginController(loginModel,loginView);
            loginController.initLoginController();
        }
    }

