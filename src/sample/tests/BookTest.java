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
    public void ToStringTest(){
        assertEquals("admin{id=1, email=admin, password=pass}", book.toString());
    }
}
