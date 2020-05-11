package Data;

public class Purchase {
    private int idPurchase;
    private int idCustomer;

    public Purchase(int idPurchase, int idCustomer) {
        this.idPurchase = idPurchase;
        this.idCustomer = idCustomer;
    }

    public Purchase(int idCustomer) {
        this.idCustomer = idCustomer;
    }

    public int getIdPurchase() { return idPurchase; }
    public int getIdCustomer() { return idCustomer; }

    public void setIdPurchase(int id ) { idPurchase = id; }
    public void setIdCustomer(int id ) { idCustomer = id; }
}
