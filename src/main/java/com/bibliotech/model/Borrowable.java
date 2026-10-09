package main.java.com.bibliotech.model;

public interface Borrowable {
    void borrow(Member member);

    void returnItem();

    boolean isAvailable();
}
