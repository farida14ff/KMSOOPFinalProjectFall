package sample.admin;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import sample.login.Controller;

public class MainPaneAdminController implements Initializable {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button logoutButton;

    @FXML
    private Button addBookAdminBtn;

    @FXML
    private Button listOfBooksadminBtn;

    @FXML
    private VBox mainContent;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            Parent pane= FXMLLoader.load(getClass().getResource("/sample/admin/adminAllBooks.fxml"));
            mainContent.getChildren().setAll(pane);

        } catch (IOException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }

        addBookAdminBtn.setOnAction(evetn ->{
            try {
                Parent pane = FXMLLoader.load(getClass().getResource("/sample/admin/adminAddBook.fxml"));
                mainContent.getChildren().setAll(pane);

            }catch (IOException ex){
                Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            }
        });

        listOfBooksadminBtn.setOnAction(event ->{
            try {
                Parent pane= FXMLLoader.load(getClass().getResource("/sample/admin/adminAllBooks.fxml"));
                mainContent.getChildren().setAll(pane);

            } catch (IOException ex) {
                Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }


    @FXML
    void handleClose(MouseEvent event) {
        if (event.getSource() == logoutButton) {
            try{
                Parent tableViewParent = FXMLLoader.load(getClass().getResource("/sample/login/sample.fxml"));
                Scene tableViewScene = new Scene(tableViewParent);

                //This line gets the Stage information
                Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

                window.setScene(tableViewScene);
                window.show();
            }
            catch (Exception ex){
                ex.printStackTrace();
            }
        }
    }
}
