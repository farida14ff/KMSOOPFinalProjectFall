package sample.user;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import sample.admin.AllBooksAdminController;
import sample.db.Const;
import sample.db.DataBaseHandler;
import sample.mosels.Book;

public class PersonalInfoUserController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

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
    private TableView<Book> bookTable;

    @FXML
    private Label lableListOAB;

    @FXML
    private TextField takeByIsbnTF;

    @FXML
    private Button returnButn;

    @FXML
    private Button exitButn;

    static ObservableList<Book> bookList = FXCollections.observableArrayList();


    @FXML
    void initialize() {

        initListOfBooks();

        bookTable.setItems(bookList);

        exitButn.setOnAction(actionEvent -> {
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

        returnButn.setOnAction(actionEvent -> {
            DataBaseHandler dbAction = new DataBaseHandler();
            try {
                dbAction.returnBook(takeByIsbnTF.getText());
                takeByIsbnTF.clear();
                initListOfBooks();
            } catch (SQLException | ClassNotFoundException ex) {
                ex.printStackTrace();
            }
            try{
                Parent tableViewParent = FXMLLoader.load(getClass().getResource("/sample/user/mainContentUser.fxml"));
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

    private void initListOfBooks(){
        bookTable.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        DataBaseHandler dbh = new DataBaseHandler();
        try {
            bookList = dbh.getAllIssuedbooks();
        } catch (SQLException ex) {
            Logger.getLogger(AllBooksAdminController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        isbnColumn.setCellValueFactory(new PropertyValueFactory<Book, String>(Const.BOOK_ADMIN_ID));
        titleColumn.setCellValueFactory(new PropertyValueFactory<Book, String>(Const.TITLE));
        authorColumn.setCellValueFactory(new PropertyValueFactory<Book, String>(Const.AUTHOR));
        publisherColumn.setCellValueFactory(new PropertyValueFactory<Book, String>(Const.PUBLISHER));
        categoriesColumn.setCellValueFactory(new PropertyValueFactory<Book, String>(Const.CATEGORIES));
        yearColumn.setCellValueFactory(new PropertyValueFactory<Book, Integer>(Const.YEAR));
        ratingColumn.setCellValueFactory(new PropertyValueFactory<Book, Integer>(Const.RATING));
    }
}

