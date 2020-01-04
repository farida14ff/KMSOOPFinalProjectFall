package sample.user;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import sample.login.Controller;

public class MainPaneUserController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button logoutButton;

    @FXML
    private Button allBooksBtn;

    @FXML
    private Button allMembersBtn;

    @FXML
    private Button personalInfoBtn;

    @FXML
    private VBox mainContent;

    @FXML
    void initialize() {
        try {
            Parent pane= FXMLLoader.load(getClass().getResource("/sample/user/allBooksUser.fxml"));
            mainContent.getChildren().setAll(pane);

        } catch (IOException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }

        allBooksBtn.setOnAction(evetn ->{
            try {
                Parent pane = FXMLLoader.load(getClass().getResource("/sample/user/allBooksUser.fxml"));
                mainContent.getChildren().setAll(pane);

            }catch (IOException ex){
                Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            }
        });

        allMembersBtn.setOnAction(event ->{
            try {
                Parent pane= FXMLLoader.load(getClass().getResource("/sample/user/allMembersUser.fxml"));
                mainContent.getChildren().setAll(pane);

            } catch (IOException ex) {
                Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            }
        });

        personalInfoBtn.setOnAction(event ->{
            try {
                Parent pane= FXMLLoader.load(getClass().getResource("/sample/user/personalInfoUser.fxml"));
                mainContent.getChildren().setAll(pane);

            } catch (IOException ex) {
                Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            }
        });

        logoutButton.setOnAction(actionEvent -> {
            try{
                Parent tableViewParent = FXMLLoader.load(getClass().getResource("/sample/login/sample.fxml"));
                Scene tableViewScene = new Scene(tableViewParent);

                //This line gets the Stage information
                Stage window = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();

                window.setScene(tableViewScene);
                window.show();
            }
            catch (Exception ex){
                ex.printStackTrace();
            }
        });
    }

}
