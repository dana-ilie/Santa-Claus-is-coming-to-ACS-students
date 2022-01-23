package entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Gift {
    private String productName;
    private Double price;
    private String category;
    @JsonIgnore
    private Integer quantity;

    public Gift(final String productName, final Double price,
                final String category, final Integer quantity) {
        this.productName = productName;
        this.price = price;
        this.category = category;
        this.quantity = quantity;
    }

    @Override
    public final String toString() {
        return "Gift{"
                + "productName='"
                + productName
                + '\''
                + ", price="
                + price
                + ", category='"
                + category
                + '\''
                + '}';
    }

    public final String getProductName() {
        return productName;
    }

    public final void setProductName(final String productName) {
        this.productName = productName;
    }

    public final Double getPrice() {
        return price;
    }

    public final void setPrice(final Double price) {
        this.price = price;
    }

    public final String getCategory() {
        return category;
    }

    public final void setCategory(final String category) {
        this.category = category;
    }

    public final Integer getQuantity() {
        return quantity;
    }

    public final void setQuantity(final Integer quantity) {
        this.quantity = quantity;
    }
}
