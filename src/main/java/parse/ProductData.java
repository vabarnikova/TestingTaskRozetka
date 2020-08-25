package parse;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class ProductData {

    private String productName;
    private int percent;
    private int oldPrice;
    private int newPrice;
    private String link;

    public ProductData(String productName, int percent, int oldPrice, int newPrice, String link) {
        this.productName = productName;
        this.percent = percent;
        this.oldPrice = oldPrice;
        this.newPrice = newPrice;
        this.link = link;
    }

    @Override
    public String toString() {
        return "\nProductData{" +
                "\nproductName = '" + productName + '\'' +
                "\npercent = " + percent + "%"+
                "\noldPrice = " + oldPrice +
                "\nnewPrice = " + newPrice +
                "\nlink='" + link + '\'' +
                '}' +
                "\n---------------------------------------------------------";
    }
}
