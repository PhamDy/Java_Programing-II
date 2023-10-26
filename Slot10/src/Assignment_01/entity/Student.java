package Assignment_01.entity;

import java.util.ArrayList;
import java.util.List;

public class Student {
    private String id;
    private String name;
    private List<Book> ds = new ArrayList<>();

    public Student() {
    }

    public Student(String id, String name, List<Book> ds) {
        this.id = id;
        this.name = name;
        this.ds = ds;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Book> getDs() {
        return ds;
    }

    public void setDs(List<Book> ds) {
        this.ds = ds;
    }

    public void addBook(Book book) {
        this.ds.add(book);
    }

    @Override
    public String toString() {
        return "Student{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", ds=" + ds.toString() +
                '}';
    }
    public String toStringBook() {
        return ds.toString();
    }
}
