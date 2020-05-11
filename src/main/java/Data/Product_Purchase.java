package Data;

public class Product_Purchase {
    private int idRecord; //id записи
    private int idProduct;
    private int idPurchase;

    public Product_Purchase(int idRecord, int idProduct, int idPurchase) {
        this.idRecord = idRecord;
        this.idProduct = idProduct;
        this.idPurchase = idPurchase;
    }

    public Product_Purchase(int idProduct, int idPurchase) {
        this.idProduct = idProduct;
        this.idPurchase = idPurchase;
    }

    public int getIdRecord(){ return idRecord; }
    public int getIdProduct(){ return idProduct; }
    public int getIdPurchase(){ return idPurchase; }

    public void setIdRecord(int idListReservation ){ idRecord = idListReservation; }
    public void setIdPurchase(int idRes){ idPurchase = idRes; }
    public void setIdProduct( int idProductRes ){ idProduct = idProductRes; }

}
