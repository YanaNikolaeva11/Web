package Data;

public class Street {
    private int idStreet;
    private String nameStreet;
    private int idCity;

    public Street(int idStreet, String nameStreet, int idCity) {
        this.idStreet = idStreet;
        this.nameStreet = nameStreet;
        this.idCity = idCity;
    }

    public int getIdStreet() { return idStreet; }
    public void setIdStreet(int idStreet) { this.idStreet = idStreet; }
    public int getIdCity() { return idCity; }
    public void setIdCity(int idCity) { this.idCity = idCity; }
    public String getNameStreet() { return nameStreet; }
    public void setNameStreet(String nameStreet) { this.nameStreet = nameStreet; }

}
