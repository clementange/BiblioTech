package main.java.com.bibliotech.model;

public class Dvd extends LibraryItem {

    private  String director;
    private int durationMinutes;


    public Dvd(String title,String code,  String director, int durationMinutes) {
        super(title,code);
        this.director = director;
        this.durationMinutes = durationMinutes;
    }

    public String getDirector() {
        return director;
    }

    public int getDurationMinutes() {
        return durationMinutes;
    }

    @Override
    public void borrow(Member member){
        if(!isAvailable()){
            throw new IllegalArgumentException("dvd déjà emprunté");
        }
        else {
            available = false;
        }
    }

    @Override
    public String describe() {
        return title + " - " + director + " (" + durationMinutes + " min)";
    }
    @Override
    public String toString() {
        return describe();
    }
}
