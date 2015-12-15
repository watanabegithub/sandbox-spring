package sample.springbootweb.app.product;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/** 画面の値を保持するForm */
public class ProductForm {
    @NotNull
    private Integer productCode;

    @NotBlank
    @Length(min=1, max=10)
//    @TelNumber
    private String productName;

    @NotNull
    @Max(value=1000)
    private Integer price;

    public Integer getProductCode() {
        return productCode;
    }

    public void setProductCode(Integer productCode) {
        this.productCode = productCode;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }
}
