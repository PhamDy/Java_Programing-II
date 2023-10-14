package Model;

public class customer {
    private int id;
    private String name;

    public customer() {
    }

    public customer(int id) {
        this.id = id;
    }

    public customer(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
