package parse;

import org.testng.annotations.DataProvider;

public class DataProviderClass {

    @DataProvider
    public Object[][] menuCategoriesAndSubcategories(){
        return new Object[][]{
                {"Ноутбуки и компьютеры", "Asus"},
                {"Смартфоны, ТВ и электроника", "Смартфоны"},
                {"Сантехника и ремонт","Ванны"},
                {"Детские товары", "Игрушки"}
        };
    }
}
