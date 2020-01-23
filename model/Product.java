package model;

/**
 *
 * @author lucas
 */
public class Product {
    private String name;
    private Float stock;
    private Float price;
    private Long barCode;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Float getStock() {
        return stock;
    }

    public void setStock(Float stock) {
        this.stock = stock;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Long getBarCode() {
        return barCode;
    }

    public void setBarCode(Long barCode) {
        this.barCode = barCode;
    }
}
