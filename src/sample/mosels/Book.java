package sample.mosels;

public class Book {

    protected String title;
    protected String isbn;
    protected String author;
    protected String publisher;
    private String categories;
    private int year;
    private int rating;


    public Book(String isbn,String title, String author, String publisher, String categories, int year, int rating) {
        this.title = title;
        this.isbn = isbn;
        this.author = author;
        this.publisher = publisher;
        this.categories = categories;
        this.year = year;
        this.rating = rating;
    }


    public Book() {

    }

    public Book(String title, String author, String publisher, String categories, int year, int rating) {
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.categories = categories;
        this.year = year;
        this.rating = rating;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getCategories() {
        return categories;
    }

    public void setCategories(String categories) {
        this.categories = categories;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }


    @Override
    public String toString() {
        return "BookInfo{" +
                "title='" + title + '\'' +
                ", books_id='" + isbn + '\'' +
                ", author='" + author + '\'' +
                ", publisher='" + publisher + '\'' +
                ", categories='" + categories + '\'' +
                ", year=" + year +
                ", rating=" + rating +
                '}';
    }
}
