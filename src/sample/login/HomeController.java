//package sample.login;
//
//
//import javafx.fxml.FXML;
//import javafx.fxml.FXMLLoader;
//import javafx.fxml.Initializable;
//import javafx.scene.Parent;
//import javafx.scene.control.Button;
//import javafx.scene.input.MouseEvent;
//import javafx.scene.layout.VBox;
//
//import java.io.IOException;
//import java.net.URL;
//import java.util.ResourceBundle;
//import java.util.logging.Level;
//import java.util.logging.Logger;
//
//public class HomeController implements Initializable {
//
//    @FXML
//    private ResourceBundle resources;
//
//    @FXML//    private URL location;
//
//    @FXML
//    private Button logoutButton;
//
//    @FXML
//    private Button addBookAdminBtn;
//
//    @FXML
//    private Button listOfBooksadminBtn;
//
//    @FXML
//    private VBox mainContent;
//
////    @FXML
////    void initialize() {
////
////    }
//
//    @FXML
//    private void addbooks(MouseEvent event) throws IOException {
//        Parent pane=FXMLLoader.load(getClass().getResource("/sample/menu/adminAddBook.fxml"));
//        mainContent.getChildren().setAll(pane);
//    }
//
//    @FXML
//    private void showAllbooks(MouseEvent event) throws IOException {
//        Parent pane=FXMLLoader.load(getClass().getResource("/sample/menu/adminAllBooks.fxml"));
//        mainContent.getChildren().setAll(pane);
//    }
//
//    @Override
//    public void initialize(URL url, ResourceBundle resourceBundle) {
//        try {
//            Parent pane= FXMLLoader.load(getClass().getResource("/sample/menu/adminAllBooks.fxml"));
//            mainContent.getChildren().setAll(pane);
//
//        } catch (IOException ex) {
//            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
//}
//
