import core.WebDriverSettings;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.DiscountsPage;
import parse.ProductData;

import java.util.List;

public class DiscountTest extends WebDriverSettings {
    private DiscountsPage discountPage;
    private List<ProductData> dataList;

    @BeforeClass
    public void init() {
        discountPage = new DiscountsPage();
    }


    @Test
    public void discountProductsTest() {
        dataList = discountPage.getProductDetails();
        discountPage.printElement(discountPage.sortByPercent(dataList), 10, "Рюкзак");
    }


}
