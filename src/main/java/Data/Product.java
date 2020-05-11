package Data;

public class Product {
    private int idProduct;
    private int idCategory;
    private String name;
    private int price;
    private double rating;


    public Product(int idProduct, int idCategory, String name, int price, double rating) {
        this.idProduct = idProduct;
        this.idCategory = idCategory;
        this.name = name;
        this.price = price;
        this.rating = rating;
    }

    public Product(int idProduct, String name, int price) {
        this.idProduct = idProduct;
        this.name = name;
        this.price = price;
    }

    public Product(int idCategory, String name, int price, double rating) {
        this.idCategory = idCategory;
        this.name = name;
        this.price = price;
        this.rating = rating;
    }

    public int getIdProduct() { return idProduct; }
    public int getIdCategory() { return idCategory; }
    public double getRating() { return rating; }
    public int getPrice() { return price; }
    public String getName() { return name; }

    public void setIdProduct( int id) { idProduct = id; }
    public void setIdCategory( int idCategoryProduct ){ idCategory = idCategoryProduct; }
    public void setRating( double ratingProduct ){ rating = ratingProduct; }
    public void setPrice( int priceProduct ){ price = priceProduct; }
    public void setName( String nameProduct ){ name = nameProduct; }

}
