package sample.login;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import sample.db.DataBaseHandler;
import sample.mosels.User;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class SignUpController {

    String newFile = "";

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField signUpFirstName;

    @FXML
    private PasswordField password_field;

    @FXML
    private Button signUpButton;

    @FXML
    private TextField login_field;

    @FXML
    private TextField signUpLastName;

    @FXML
    private RadioButton sgnUpCheckboxAdmin;

    @FXML
    private RadioButton sgnUpCheckboxStudent;

    @FXML
    private Button goBackLoginButton;

    @FXML
    void initialize() {

        signUpButton.setOnAction(event ->{
            signupMewUser();
//            openNewWindow("/sample/user/mainContentUser.fxml");

        });

        goBackLoginButton.setOnAction(event -> {
//            openNewScene("/gui/SignUp.fxml");
            try {
                Parent tableViewParent = FXMLLoader.load(getClass().getResource("/sample/login/sample.fxml"));
                Scene tableViewScene = new Scene(tableViewParent);

                Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

                window.setScene(tableViewScene);
                window.show();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });


    }

    private void signupMewUser() {
        DataBaseHandler dbHandler = new DataBaseHandler();

        String firstName = signUpFirstName.getText();
        String lastName = signUpLastName.getText();
        String userName = login_field.getText();
        String password = password_field.getText();
        String status = "";
        boolean numeric = true;
        boolean numeric1 = true;
        numeric = firstName.matches("-?\\d+(\\.\\d+)?");
        numeric1 = lastName.matches("-?\\d+(\\.\\d+)?");

        if (firstName.isEmpty() || lastName.isEmpty() || userName.isEmpty() || password.isEmpty() ){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information Dialog");
            alert.setHeaderText(null);
            alert.setContentText("Please give all information");
            alert.showAndWait();
        }
        else if(numeric || numeric1) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information Dialog");
            alert.setHeaderText(null);
            alert.setContentText("Firstname and lastename can not be a number");
            alert.showAndWait();
        }

            else{

                User user = new User(firstName, lastName,userName,password,status);

                dbHandler.signUpUser(user);

                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Information Dialog");
                alert.setHeaderText(null);
                alert.setContentText("You have successfully registered!");
                alert.showAndWait();
            }
        }



//        if (sgnUpCheckboxAdmin.isSelected()) {
//            status = "Admin";
//            sgnUpCheckboxStudent.setSelected(false);
//            newFile = "/sample/menu/menu.fxml";
//        }else {
//            status = "Student";
//            sgnUpCheckboxAdmin.setSelected(false);
//            newFile = "/sample/menu/menu.fxml";
//        }



//        Alert alert = new Alert(Alert.AlertType.INFORMATION);
//        alert.setTitle("Information Dialog");
//        alert.setHeaderText(null);
//        alert.setContentText("You have successfully registered!");
//        alert.showAndWait();


    public void openNewWindow(String window){


        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(window));
        Parent root1 = null;
        try {
            root1 = (Parent) fxmlLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.initStyle(StageStyle.UNDECORATED);
        stage.setScene(new Scene(root1));
        stage.show();

        signUpButton.getScene().getWindow().hide();

//        FXMLLoader loader = new FXMLLoader();
//        loader.setLocation(getClass().getResource(window));
//
//        try {
//            loader.load();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        Parent root = loader.getRoot();
//        Stage stage = new Stage();
//        stage.setScene(new Scene(root));
//        stage.showAndWait();

    }
}
