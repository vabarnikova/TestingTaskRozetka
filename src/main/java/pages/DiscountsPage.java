package pages;

import core.WebDriverSettings;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import parse.ProductData;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class DiscountsPage extends BasePage {

    public DiscountsPage() {
        PageFactory.initElements(WebDriverSettings.getDriver(), this);
    }

    private final By title = By.cssSelector(".goods-tile__title");
    private final By oldPrice = By.cssSelector(".goods-tile__price_type_old");
    private final By newPrice = By.cssSelector(".goods-tile__price-value");
    private final By link = By.cssSelector(".goods-tile__picture");

    @FindBy(how = How.CSS, using = ".goods-tile")
    private List<WebElement> listOfProducts;


    public int convertToInteger(String price) {
        return Integer.parseInt(price);
    }

    public List<ProductData> getProductDetails() {
        String productName;
        String productLink;
        Integer productNewPrice;
        Integer productOldPrice;
        Integer productDiscountPercent;
        List<ProductData> data = new ArrayList<>();
        for (WebElement product : listOfProducts) {
            productName = product.findElement(title).getText();
            productNewPrice = convertToInteger(product.findElement(newPrice).getText().replaceAll("[^0-9]", ""));
            productOldPrice = convertToInteger(product.findElement(oldPrice).getText().replaceAll("[^0-9]", ""));
            productLink = product.findElement(link).getAttribute("href");
            productDiscountPercent = getDiscountPercent(productNewPrice, productOldPrice);
            data.add(new ProductData(productName, productDiscountPercent, productOldPrice, productNewPrice, productLink));
        }
        return data;
    }

    public List<ProductData> sortByPercent(List<ProductData> data) {
        return data.stream()
                .sorted(Comparator.comparingInt(ProductData::getPercent).reversed())
                .collect(Collectors.toList());
    }

    public Integer getDiscountPercent(Integer newPrice, Integer oldPrice) {
        return (100 - (newPrice * 100 / oldPrice));
    }

    public void printElement(List<ProductData> data, int countOfProducts, String removeProduct) {
        data.stream()
                .filter(productData -> !StringUtils.containsIgnoreCase(productData.getProductName(), removeProduct))
                .limit(countOfProducts)
                .forEach(System.out::println);
    }


}
