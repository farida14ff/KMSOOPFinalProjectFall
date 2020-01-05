package sample.admin;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.beans.binding.BooleanBinding;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import sample.db.Const;
import sample.db.DataBaseHandler;
import sample.mosels.Book;

public class AllBooksAdminController implements Initializable {


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
    private Label lableListOAB;

    @FXML
    private TableView<Book> bookTable;

    @FXML
    private TextField editId;

    @FXML
    private TextField editTitle;

    @FXML
    private TextField editAuthor;

    @FXML
    private TextField editPublisher;

    @FXML
    private TextField editCategories;

    @FXML
    private TextField editYear;

    @FXML
    private TextField editRating;

    @FXML
    private Button editAdminBtn;

    @FXML
    private Button deleteAdminBtn;

    static ObservableList<Book> bookList= FXCollections.observableArrayList();


    @FXML
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
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

        deleteAdminBtn.setOnAction(actionEvent -> {
            ObservableList<Book> selectedBooks=FXCollections.observableArrayList();
            selectedBooks=bookTable.getSelectionModel().getSelectedItems();
            AddBookAdminController.bookList.removeAll(selectedBooks);
            DataBaseHandler dbAction=new DataBaseHandler();
            try {
                dbAction.deleteBooks(selectedBooks);
            } catch (SQLException | ClassNotFoundException e) {
                e.printStackTrace();
            }

            try{
                Parent tableViewParent = FXMLLoader.load(getClass().getResource("/sample/admin/adminMainPane.fxml"));
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


    @FXML
    void editAdminBtnAct(ActionEvent event) throws SQLException, ClassNotFoundException {
        if(editTitle.getText().equals("") || editId.getText().equals("") || editAuthor.getText().equals("") ||
                editPublisher.getText().equals("") ) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("Please give all info");
            alert.showAndWait();
            return;
        }

        String bookid = editId.getText();
        String newTitle = editTitle.getText();
        String newAuthor = editAuthor.getText();
        String newPublisher = editPublisher.getText();
        String newCategories = editCategories.getText();
        int newYear = Integer.parseInt(editYear.getText());
        int newRating = Integer.parseInt(editRating.getText());

        Book bookinfoObj=new Book(bookid, newTitle, newAuthor, newPublisher,newCategories, newYear, newRating);



        DataBaseHandler dbAction=new DataBaseHandler();
        dbAction.updatebook(bookinfoObj);

        editTitle.clear();
        editId.clear();
        editAuthor.clear();
        editPublisher.clear();
        editCategories.clear();

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText(null);
        alert.setContentText("Book info Updated Successfully");
        alert.showAndWait();

        try{
            Parent tableViewParent = FXMLLoader.load(getClass().getResource("/sample/admin/adminMainPane.fxml"));
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
