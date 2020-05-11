package Data;

public class Specifications {
    private int idProduct;
    private String property;
    private String propertyValue;
    private int idCategory;

    public Specifications(int idProduct, String property, String propertyValue) {
        this.idProduct = idProduct;
        this.property = property;
        this.propertyValue = propertyValue;
    }

    public int getIdProduct() { return idProduct; }
    public String getProperty() { return property; }
    public String getPropertyValue() { return propertyValue; }
    public int getIdCategory() { return idCategory; }

    public void setIdProduct(int id ) { idProduct = id; }
    public void setProperty(String propertyProduct ){ property = propertyProduct; }
    public void setPropertyValue( String propetyVal ){ propertyValue = propetyVal; }
    public void  setIdCategory( int id ){ idCategory = id; }

}
