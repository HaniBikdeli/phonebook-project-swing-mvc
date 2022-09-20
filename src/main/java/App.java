
import com.phonebook.view.*;
import com.phonebook.model.*;
import com.phonebook.controller.*;

    public class App {
        public static void main(String[] args) {
            LoginModel loginModel = new LoginModel();
            LoginView loginView = new LoginView();
            LoginController loginController = new loginController(loginModel,loginView);
            LoginController.initController();
        }
    }

