package Data;

public class Basket {
    private int id;
    private String productName;
    private int price;
    private int finPrice;

    public Basket(int id, String productName, int price, int finPrice) {
        this.id = id;
        this.productName = productName;
        this.price = price;
        this.finPrice = finPrice;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getFinPrice() {
        return finPrice;
    }

    public void setFinPrice(int finPrice) {
        this.finPrice = finPrice;
    }
}
