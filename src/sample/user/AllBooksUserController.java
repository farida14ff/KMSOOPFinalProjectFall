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

public class AllBooksUserController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableView<Book> bookTable;

    @FXML
    private TableColumn<Book, String> isbnColumn;

    @FXML
    private TableColumn<Book, String> titleColumn;

    @FXML
    private TableColumn<Book, String> authorColumn;

    @FXML
    private TableColumn<Book, String> publisherColumn;

    @FXML
    private TableColumn<Book, String> categoriesColumn;

    @FXML
    private TableColumn<Book, Integer> yearColumn;

    @FXML
    private TableColumn<Book, Integer> ratingColumn;


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

    static ObservableList<Book> bookList = FXCollections.observableArrayList();


    @FXML
    void initialize() {
        bookTable.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        DataBaseHandler dbh = new DataBaseHandler();
        try {
            bookList= dbh.getAllbooks();
        } catch (SQLException ex) {
            Logger.getLogger(AllBooksAdminController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        isbnColumn.setCellValueFactory(new PropertyValueFactory<Book,String>(Const.BOOK_ADMIN_ID));
        titleColumn.setCellValueFactory(new PropertyValueFactory<Book, String>(Const.TITLE));
        authorColumn.setCellValueFactory(new PropertyValueFactory<Book,String>(Const.AUTHOR));
        publisherColumn.setCellValueFactory(new PropertyValueFactory<Book,String>(Const.PUBLISHER));
        categoriesColumn.setCellValueFactory(new PropertyValueFactory<Book, String>(Const.CATEGORIES));
        yearColumn.setCellValueFactory(new PropertyValueFactory<Book,Integer>(Const.YEAR));
        ratingColumn.setCellValueFactory(new PropertyValueFactory<Book,Integer>(Const.RATING));
        bookTable.setItems(bookList);

    }
}
