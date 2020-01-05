package sample.user;

import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import sample.admin.AddBookAdminController;
import sample.admin.AllBooksAdminController;
import sample.db.Configs;
import sample.db.Const;
import sample.db.DataBaseHandler;
import sample.login.User;
import sample.mosels.Book;

public class AllBooksUserController extends Configs {

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
    private RadioButton selectYearRB;

    @FXML
    private Button searchButn;

    @FXML
    private Button issueButton;

    @FXML
    private Button discardBtn;


    @FXML
    private TextField takeByIsbnTF;

    static ObservableList<Book> bookList = FXCollections.observableArrayList();
    static ObservableList<Book> bookList2=FXCollections.observableArrayList();


    @FXML
    void initialize() {
        bookTable.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        DataBaseHandler dbh = new DataBaseHandler();
        try {
            bookList = dbh.getAllbooks();
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

        bookTable.setItems(bookList);


        searchButn.setOnAction(actionEvent -> {
                    DataBaseHandler db = new DataBaseHandler();
                    if (selectAuthorRB.isSelected()) {
                        bookList.clear();
                        Logger.getLogger(AllBooksAdminController.class.getName()).log(Level.SEVERE, searchTextField.getText(), "selected");

                        try {
                            bookList = db.getBookByAuthor(searchTextField.getText());
                        } catch (SQLException | ClassNotFoundException e) {
                            e.printStackTrace();
                        }
                        isbnColumn.setCellValueFactory(new PropertyValueFactory<Book, String>(Const.BOOK_ADMIN_ID));
                        titleColumn.setCellValueFactory(new PropertyValueFactory<Book, String>(Const.TITLE));
                        authorColumn.setCellValueFactory(new PropertyValueFactory<Book, String>(Const.AUTHOR));
                        publisherColumn.setCellValueFactory(new PropertyValueFactory<Book, String>(Const.PUBLISHER));
                        categoriesColumn.setCellValueFactory(new PropertyValueFactory<Book, String>(Const.CATEGORIES));
                        yearColumn.setCellValueFactory(new PropertyValueFactory<Book, Integer>(Const.YEAR));
                        ratingColumn.setCellValueFactory(new PropertyValueFactory<Book, Integer>(Const.RATING));
                        bookTable.setItems(bookList);
                    }

                    if (selectTitleRB.isSelected()) {
                        bookList.clear();
                        Logger.getLogger(AllBooksAdminController.class.getName()).log(Level.SEVERE, searchTextField.getText(), "selected");

                        try {
                            bookList = db.getBookByTitle(searchTextField.getText());
                        } catch (SQLException | ClassNotFoundException e) {
                            e.printStackTrace();
                        }
                        isbnColumn.setCellValueFactory(new PropertyValueFactory<Book, String>(Const.BOOK_ADMIN_ID));
                        titleColumn.setCellValueFactory(new PropertyValueFactory<Book, String>(Const.TITLE));
                        authorColumn.setCellValueFactory(new PropertyValueFactory<Book, String>(Const.AUTHOR));
                        publisherColumn.setCellValueFactory(new PropertyValueFactory<Book, String>(Const.PUBLISHER));
                        categoriesColumn.setCellValueFactory(new PropertyValueFactory<Book, String>(Const.CATEGORIES));
                        yearColumn.setCellValueFactory(new PropertyValueFactory<Book, Integer>(Const.YEAR));
                        ratingColumn.setCellValueFactory(new PropertyValueFactory<Book, Integer>(Const.RATING));
                        bookTable.setItems(bookList);
                    }

                    if (selectYearRB.isSelected()) {
                        bookList.clear();
                        Logger.getLogger(AllBooksAdminController.class.getName()).log(Level.SEVERE, searchTextField.getText(), "selected");

                        try {
                            bookList = db.getBookByYear(searchTextField.getText());
                        } catch (SQLException | ClassNotFoundException e) {
                            e.printStackTrace();
                        }
                        isbnColumn.setCellValueFactory(new PropertyValueFactory<Book, String>(Const.BOOK_ADMIN_ID));
                        titleColumn.setCellValueFactory(new PropertyValueFactory<Book, String>(Const.TITLE));
                        authorColumn.setCellValueFactory(new PropertyValueFactory<Book, String>(Const.AUTHOR));
                        publisherColumn.setCellValueFactory(new PropertyValueFactory<Book, String>(Const.PUBLISHER));
                        categoriesColumn.setCellValueFactory(new PropertyValueFactory<Book, String>(Const.CATEGORIES));
                        yearColumn.setCellValueFactory(new PropertyValueFactory<Book, Integer>(Const.YEAR));
                        ratingColumn.setCellValueFactory(new PropertyValueFactory<Book, Integer>(Const.RATING));
                        bookTable.setItems(bookList);
                    }
                });

        discardBtn.setOnAction(actionEvent -> {
            bookTable.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
            searchTextField.clear();
            try {
                bookList = dbh.getAllbooks();
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
            bookTable.setItems(bookList);

        });

        issueButton.setOnAction(actionEvent -> {

            //database action
            DataBaseHandler dbAction = new DataBaseHandler();
            try {
                dbAction.issueBook(takeByIsbnTF.getText());
                takeByIsbnTF.clear();
            } catch (SQLException | ClassNotFoundException ex) {
                ex.printStackTrace();
            }

        });
    }
}
