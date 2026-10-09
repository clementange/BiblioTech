package main.java.com.bibliotech.model;
import java.util.Objects;

public abstract class LibraryItem implements Borrowable{
    protected String title;
    protected boolean available;
    protected String id;

    public LibraryItem(String title, String id) {
        this.title = title;
        this.available = true;
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public String getId() {
        return id;
    }

    @Override
    public void returnItem() {
        available = true;
    }

    @Override
    public boolean isAvailable() {
        return available;
    }

    public abstract String describe();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LibraryItem that = (LibraryItem) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
