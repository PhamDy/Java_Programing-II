package Assignment02.entity;

public class Product {
    private String id;
    private String product_name;
    private double price;
    private int quantity;
    private int sold;

    public Product() {
    }

    public Product(String id, String product_name, double price, int quantity, int sold) {
        this.id = id;
        this.product_name = product_name;
        this.price = price;
        this.quantity = quantity;
        this.sold = sold;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getSold() {
        return sold;
    }

    public void setSold(int sold) {
        this.sold = sold;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id='" + id + '\'' +
                ", product_name='" + product_name + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                ", sold=" + sold +
                '}';
    }
}
