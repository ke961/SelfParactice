package keya.selfparactice;

public class Product {
    private String productName;
    private int productId;
    private String productDescription;
    private float productPrice;
    private String stallName;
    private int stallId;
    private String Quantity;
    private String category;
    private String availStatus;

    public Product(String productName, int productId, String productDescription, float productPrice, String stallName, int stallId, String quantity, String category, String availStatus) {
        this.productName = productName;
        this.productId = productId;
        this.productDescription = productDescription;
        this.productPrice = productPrice;
        this.stallName = stallName;
        this.stallId = stallId;
        Quantity = quantity;
        this.category = category;
        this.availStatus = availStatus;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public float getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(float productPrice) {
        this.productPrice = productPrice;
    }

    public String getStallName() {
        return stallName;
    }

    public void setStallName(String stallName) {
        this.stallName = stallName;
    }

    public int getStallId() {
        return stallId;
    }

    public void setStallId(int stallId) {
        this.stallId = stallId;
    }

    public String getQuantity() {
        return Quantity;
    }

    public void setQuantity(String quantity) {
        Quantity = quantity;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getAvailStatus() {
        return availStatus;
    }

    public void setAvailStatus(String availStatus) {
        this.availStatus = availStatus;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productName='" + productName + '\'' +
                ", productId=" + productId +
                ", productDescription='" + productDescription + '\'' +
                ", productPrice=" + productPrice +
                ", stallName='" + stallName + '\'' +
                ", stallId=" + stallId +
                ", Quantity='" + Quantity + '\'' +
                ", category='" + category + '\'' +
                ", availStatus='" + availStatus + '\'' +
                '}';
    }
}

