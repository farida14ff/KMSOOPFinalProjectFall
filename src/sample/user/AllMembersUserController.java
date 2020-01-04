package sample.user;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import sample.admin.AllBooksAdminController;
import sample.db.Const;
import sample.db.DataBaseHandler;
import sample.login.User;
import sample.mosels.Book;

public class AllMembersUserController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableView<User> bookTable;

    @FXML
    private TableColumn<User, String> firstnameColumn;

    @FXML
    private TableColumn<User, String> lastnameColumn;

    @FXML
    private TableColumn<User, String> emailColumn;

    @FXML
    private Label lableListOAB;

    @FXML
    private TextField searchTextField;

    @FXML
    private RadioButton selectTitleRB;

    @FXML
    private RadioButton selectAuthorRB;

    @FXML
    private Button searchButn;

    @FXML
    private Button discardBtn;

    static ObservableList<User> membersList = FXCollections.observableArrayList();


    @FXML
    void initialize() {
        bookTable.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        DataBaseHandler dbh = new DataBaseHandler();
        try {
            membersList = dbh.getAllUsers();
        } catch (SQLException ex) {
            Logger.getLogger(AllBooksAdminController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        firstnameColumn.setCellValueFactory(new PropertyValueFactory<User,String>(Const.USER_FIRSTNAME));
        lastnameColumn.setCellValueFactory(new PropertyValueFactory<User, String>(Const.USER_LASTNAME));
//        emailColumn.setCellValueFactory(new PropertyValueFactory<User,String>(Const.AUTHOR));

        bookTable.setItems(membersList);

    }
}
