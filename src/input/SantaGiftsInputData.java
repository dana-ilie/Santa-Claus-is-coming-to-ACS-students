package input;

public class SantaGiftsInputData {
    private String productName;
    private Double price;
    private String category;

    public SantaGiftsInputData(final String productName,
                               final Double price,
                               final String category) {
        this.productName = productName;
        this.price = price;
        this.category = category;
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

    @Override
    public final String toString() {
        return "SantaGiftsInputData{"
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
}
