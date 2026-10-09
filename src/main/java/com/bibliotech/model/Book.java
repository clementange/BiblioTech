/*package main.java.com.bibliotech.model;

public class Book {
    private String title;
    private String author;
    private String isbn;
    private boolean available;

    public Book(String title, String author, String isbn, boolean available) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.available = available;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getIsbn() {
        return isbn;
    }

    public boolean isAvailable() {
        return available;
    }

    @Override
    public String toString() {
        return String.format("[%s - %s]", title, author);

    }
}*/

package main.java.com.bibliotech.model;
public class Book extends LibraryItem {
    private String author;

    public Book(String title, String author, String isbn) {
        super(title,isbn);
        this.author = author;

    }

    public String getAuthor() {
        return author;
    }

    public String getIsbn(){
        return getId();
    }

    @Override
    public void borrow(Member member){
        if(!isAvailable()){
            throw new IllegalArgumentException("Livre déjà emprunté");
        }
        else {
            available = false;
        }
    }

    @Override
    public String describe() {
        return title + " - " + author;
    }

    @Override
    public String toString() {

        return describe() + " [" + getId() + "]";
    }
}
