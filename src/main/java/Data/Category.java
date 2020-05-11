package Data;

public class Category {
    private int idCategory;
    private String nameCategory;

    public Category(int idCategory, String nameCategory) {
        this.idCategory = idCategory;
        this.nameCategory = nameCategory;
    }

    public int getIdCategory(){ return idCategory; }
    public String getNameCategory(){ return nameCategory; }

    public void setNameCategory( int idCategoryProduct ){ idCategory = idCategoryProduct; }
    public void setNameCategory( String nameCategoryProduct){ nameCategory = nameCategoryProduct; }


}
