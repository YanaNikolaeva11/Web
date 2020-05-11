package Data;

public class Country {
    private int idCountry;
    private String nameCountry;

    public Country(int idCountry, String nameCountry) {
        this.idCountry = idCountry;
        this.nameCountry = nameCountry;
    }

    public Country(String nameCountry) {
        this.nameCountry = nameCountry;
    }

    public int getIdCountry() { return idCountry; }
    public void setIdCountry(int idCountry) { this.idCountry = idCountry; }

    public String getNameCountry() { return nameCountry; }
    public void setNameCountry(String nameCountry) { this.nameCountry = nameCountry; }
}
