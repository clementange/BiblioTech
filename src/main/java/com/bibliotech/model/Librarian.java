package main.java.com.bibliotech.model;

public class Librarian extends Person {
    private String employeeId;

    public Librarian(String name, String id, String employeeId){
        super(name, id);
        this.employeeId = employeeId;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    @Override
    public String toString(){
        return String.format("%s, %s",super.toString(),employeeId);
    }

}
