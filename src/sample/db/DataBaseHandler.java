package sample.db;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import sample.login.User;
import sample.mosels.Admin;
import sample.mosels.Book;

import java.sql.*;
import java.util.ArrayList;

public class DataBaseHandler extends Configs {
    Connection dbConnection;
    public ArrayList<Integer> data;

    public Connection getDbConnection() throws ClassNotFoundException, SQLException{
        String connectionString = "jdbc:mysql://" + dbHost + ":"
                + dbPort + "/" + dbName + "?useSSL=false";
        //"?autoReconnect=true&useSSL=false"

        Class.forName("com.mysql.jdbc.Driver");

        dbConnection = DriverManager.getConnection(connectionString, dbUser, dbPass);

        return dbConnection;
    }


    //authorization
    public void signUpUser(User user){
        String insert = "INSERT INTO " + Const.USER_TABLE + "(" +
                Const.USER_FIRSTNAME +"," + Const.USER_LASTNAME + "," +
                Const.USER_USERNAME + "," + Const.USER_PASSWORD + "," +
                Const.USER_STATUS + ")" + "VALUES(?,?,?,?,?)";

        try {
            PreparedStatement prSt  = getDbConnection().prepareStatement(insert);
            prSt.setString(1,user.getFirstName());
            prSt.setString(2,user.getLastName());
            prSt.setString(3,user.getUserName());
            prSt.setString(4,user.getPassword());
            prSt.setString(5,user.getGender());

            prSt.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public ResultSet getUser(User user){
        ResultSet resSet = null;

        String select = "SELECT * FROM "+ Const.USER_TABLE + " WHERE "+
                Const.USER_USERNAME + "=? AND " + Const.USER_PASSWORD + "=?";

        try {
            PreparedStatement prSt  = getDbConnection().prepareStatement(select);
            prSt.setString(1,user.getUserName());
            prSt.setString(2,user.getPassword());

            resSet = prSt.executeQuery();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return resSet;
    }

    public ResultSet getAdmin(Admin admin) {
        ResultSet resultSet = null;

        String select = "SELECT * FROM "+ Const.USER_TABLE + " WHERE "+
                Const.USER_USERNAME + "=? AND " + Const.USER_PASSWORD + "=?";


        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(select);
            prSt.setString(1, admin.getEmail());
            prSt.setString(2, admin.getPassword());

            resultSet = prSt.executeQuery();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return resultSet;
    }


    public String updatebook(Book bookinfo) throws SQLException, ClassNotFoundException {
        Connection conn=getDbConnection();
        Statement statement=conn.createStatement();

        String query = "UPDATE bm_meal_list "
                + "SET title ='"+bookinfo.getTitle()+"',author='"+bookinfo.getAuthor()+"',publisher='"+bookinfo.getPublisher()
                +"',categories='"+bookinfo.getCategories() +"',year='"+bookinfo.getYear()
                +"',rating='"+bookinfo.getRating() + "' WHERE books_id = '"+bookinfo.getIsbn()+"'";
        if(statement.executeUpdate(query)>0){
            return "bookinf updated successfully";
        }else{
            return "failed";
        }
    }

    public ObservableList<Book> getAllbooks() throws SQLException, ClassNotFoundException {

        ObservableList<Book> bookList= FXCollections.observableArrayList();

        Connection conn = getDbConnection();
        Statement statement=conn.createStatement();
        String query="SELECT * FROM "+ Const.BM_MEAL_LIST_TABLE;

        ResultSet rs=statement.executeQuery(query);

        while(rs.next()){

            String title = rs.getString(Const.TITLE);
            int id = rs.getInt(Const.BOOK_ADMIN_ID);
            String author = rs.getString(Const.AUTHOR);
            String publisher = rs.getString(Const.PUBLISHER);
            String categories = rs.getString(Const.CATEGORIES);
            int year = rs.getInt(Const.YEAR);
            int rating = rs.getInt(Const.RATING);

            Book book=new Book(title,id,author,publisher,categories, year, rating);
            bookList.add(book);
        }
        return bookList;

    }

    public String addBook(Book book) throws SQLException, ClassNotFoundException {

        Connection conn=getDbConnection();
        Statement statement=conn.createStatement();

        String insert = "INSERT INTO " + Const.BM_MEAL_LIST_TABLE + "(" +
                Const.TITLE + "," + Const.BOOK_ADMIN_ID +
                "," + Const.PUBLISHER + "," + Const.CATEGORIES +
                "," + Const.AUTHOR + "," + Const.YEAR + "," + Const.RATING +
                ")" + "VALUES(?,?,?,?,?,?,?)";

        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(insert);
            prSt.setString(1, book.getTitle());
            prSt.setInt(2, book.getIsbn());
            prSt.setString(3, book.getPublisher());
            prSt.setString(4, book.getCategories());
            prSt.setString(5, book.getAuthor());
            prSt.setInt(6, book.getYear());
            prSt.setInt(7, book.getRating());


            prSt.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        if(statement.executeUpdate(insert)>0){
            return "Bookinfo added successfully";
        }else{
            return "failed";
        }

    }

}

