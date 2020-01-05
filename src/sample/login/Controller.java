package sample.login;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sample.db.DataBaseHandler;
import sample.login.animations.Shake;
import sample.mosels.Admin;
import sample.mosels.User;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class Controller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private TextField login_field;

    @FXML
    private PasswordField password_field;

    @FXML
    private Button authSigninButton;

    @FXML
    private Button loginSignUpButon;

    @FXML
    void initialize() {

        authSigninButton.setOnAction(event -> {
            String loginText = login_field.getText().trim();
            String loginPassword = password_field.getText().trim();


            if (!loginText.equals("") && !loginPassword.equals("")) {
                loginUser(loginText, loginPassword);
            } else {
                animation();
            }

        });

        loginSignUpButon.setOnAction(event -> {
//            openNewScene("/gui/SignUp.fxml");
            try {
                Parent tableViewParent = FXMLLoader.load(getClass().getResource("/sample/login/signUp.fxml"));
                Scene tableViewScene = new Scene(tableViewParent);

                Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

                window.setScene(tableViewScene);
                window.show();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });

//        btnExit.setOnAction(event -> {
//            System.exit(0);
//        });
    }

    private void loginUser(String usernameText, String passwordText) {

        DataBaseHandler dbHandler = new DataBaseHandler();
        User user = new User();
        Admin admin = new Admin();

        if (!(usernameText.equals("admin") && passwordText.equals("admin"))) {
            user.setUserName(usernameText);
            user.setPassword(passwordText);
        }
        else {
            admin.setEmail(usernameText);
            admin.setPassword(passwordText);
        }




//        dbHandler.getUser(user);

        ResultSet userResultSet = dbHandler.getUser(user);
        ResultSet adminResultSet = dbHandler.getAdmin(admin);

        int userCounter = 0;

        while (true) {
            try {
                if (!userResultSet.next()) break;
            } catch (SQLException e) {
                e.printStackTrace();
            }
            userCounter++;
        }

        if (userCounter >= 1) {
            openNewWindow("/sample/user/mainContentUser.fxml");
        } else {
            animation();
        }

        int adminCounter = 0;

        while (true) {
            try {
                if (!adminResultSet.next()) break;
            } catch (SQLException e) {
                e.printStackTrace();
            }
            adminCounter++;
        }

        if (adminCounter >= 1) {
//            openNewWindow("/sample/login/home.fxml");
            openNewWindow("/sample/admin/adminMainPane.fxml");
        } else {
            animation();
        }
    }

    public void openNewWindow(String window) {

        loginSignUpButon.getScene().getWindow().hide();

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource(window));

        try {
            loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Parent root = loader.getRoot();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.showAndWait();



    }

    public void animation() {
        Shake userLoginAnim = new Shake(login_field);
        Shake userPassAnim = new Shake(password_field);
        userLoginAnim.playAnim();
        userPassAnim.playAnim();
    }
}
