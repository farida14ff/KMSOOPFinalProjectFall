package sample.tests;

import org.junit.Test;
import sample.mosels.Book;

import static org.junit.Assert.assertEquals;

public class BookTest {

    Book book = new Book("11-12-13","title","author","publisher","categories",2020,5);

    @Test
    public void getIdTest() {
        assertEquals("11-12-13", book.getIsbn());
    }

    @Test
    public void setIdTest() {
        book.setIsbn("11-12-13");
        assertEquals("11-12-13", book.getIsbn());
    }

    @Test
    public void getTitleTest() {
        assertEquals("title", book.getTitle());
    }

    @Test
    public void setTitleTest() {
        book.setTitle("title");
        assertEquals("title", book.getTitle());
    }

    @Test
    public void getAuthorTest() {
        assertEquals("author", book.getAuthor());
    }

    @Test
    public void setAuthorTest() {
        book.setAuthor("author");
        assertEquals("author", book.getAuthor());
    }

    @Test
    public void getPublisherTest(){
        assertEquals("publisher",book.getPublisher());
    }

    @Test
    public void setPublisherTest(){
        book.setPublisher("publisher");
        assertEquals("publisher",book.getPublisher());
    }

    @Test
    public void getCategoriesTest(){
        assertEquals("categories",book.getCategories());
    }

    @Test
    public void setCategoriesTest(){
        book.setCategories("categories");
        assertEquals("categories",book.getCategories());
    }

    @Test
    public void getYearTest(){
        assertEquals(2020,book.getYear());
    }

    @Test
    public void setYearTest(){
        book.setYear(2020);
        assertEquals(2020,book.getYear());
    }

    @Test
    public void getRating(){
        assertEquals(5,book.getRating());
    }

    @Test
    public void setRatingTest(){
        book.setRating(5);
        assertEquals(5,book.getRating());
    }

    @Test
    public void toStringTest(){
        assertEquals("BookInfo{" +
                "title='title', books_id='11-12-13', author='author'," +
                " publisher='publisher'" +
                ", categories='categories'"+
                ", year=2020" +
                ", rating=5"+
                '}', book.toString());
    }
}
