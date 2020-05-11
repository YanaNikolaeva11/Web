package Data;

public class Rate {
    private int idProduct;
    private int rating;

    public Rate(int idProduct, int rating) {
        this.idProduct = idProduct;
        this.rating = rating;
    }

    public Rate(int rating) {
        this.rating = rating;
    }


    public int getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}
