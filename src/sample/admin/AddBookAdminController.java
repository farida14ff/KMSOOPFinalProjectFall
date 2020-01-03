package sample.admin;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import sample.db.DataBaseHandler;
import sample.mosels.Book;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;


public class AddBookAdminController implements Initializable {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField addTitle;

    @FXML
    private TextField addPublisher;

    @FXML
    private TextField addAuthor;

    @FXML
    private TextField addRating;

    @FXML
    private TextField addYear;

    @FXML
    private Button addBookBtn;

    @FXML
    private Label addCategories;

    @FXML
    private TextField addID;

    static ObservableList<Book> bookList = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        DataBaseHandler dbAction=new DataBaseHandler();
        try {
            bookList =dbAction.getAllbooks();
        } catch (SQLException | ClassNotFoundException ex) {
//            Logger.getLogger(FXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }

        addBookBtn.setOnAction(actionEvent -> {
            if(addID.getText().equals("")) return;

            else {

                String title=addTitle.getText();
                int isbn=Integer.parseInt(addID.getText());
                String author=addAuthor.getText();
                String publisher=addPublisher.getText();
                String category=addCategories.getText();
                int year= Integer.parseInt(addYear.getText());
                int rating= Integer.parseInt(addRating.getText());


                Book bookobj=new Book(title,isbn,author,publisher,category,year,rating);


                try {
                    dbAction.addBook(bookobj);
                } catch (SQLException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }

                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Information Dialog");
                alert.setHeaderText(null);
                alert.setContentText("Book added successfully");
                alert.showAndWait();

                addTitle.clear();
                addID.clear();
                addAuthor.clear();
                addPublisher.clear();


            }
        });
    }

}
