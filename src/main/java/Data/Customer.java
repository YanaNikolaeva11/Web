package Data;

public class Customer {
    private int idCustomer;
    private int idCountry;
    private String password;
    private String name;
    private String surname;
    private String patronymic;
    private String gender;
    private String role;

    public Customer(int idCustomer, int idCountry, String password, String name, String surname, String patronymic, String gender, String role) {
        this.idCustomer = idCustomer;
        this.idCountry = idCountry;
        this.password = password;
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
        this.gender = gender;
        this.role = role;
    }

    public Customer(int idCountry, String password, String name, String surname, String patronymic, String gender, String role) {
        this.idCountry = idCountry;
        this.password = password;
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
        this.gender = gender;
        this.role = role;
    }

    public Customer(String password, String name) {
        this.password = password;
        this.name = name;
    }

    public int getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(int idCustomer) {
        this.idCustomer = idCustomer;
    }

    public int getIdCountry() {
        return idCountry;
    }

    public void setIdCountry(int idCountry) {
        this.idCountry = idCountry;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
