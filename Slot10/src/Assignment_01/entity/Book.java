package Assignment_01.entity;

import java.sql.Date;

public class Book {
    private String id;
    private String name;
    private String author;
    private String publisher;
    private String category;
    private double price;
    private Date dateAdd;
    private boolean status;

    public Book() {
    }

    public Book(String id, String name, String author, String publisher, String category, double price, Date dateAdd, boolean status) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.publisher = publisher;
        this.category = category;
        this.price = price;
        this.dateAdd = dateAdd;
        this.status = status;
    }

    public Book(String id) {
        this.id = id;
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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Date getDateAdd() {
        return dateAdd;
    }

    public void setDateAdd(Date dateAdd) {
        this.dateAdd = dateAdd;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", publisher='" + publisher + '\'' +
                ", category='" + category + '\'' +
                ", price=" + price +
                ", dateAdd=" + dateAdd +
                ", status=" + status +
                '}';
    }
}
