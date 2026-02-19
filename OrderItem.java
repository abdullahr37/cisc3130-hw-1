public class OrderItem {
    private String productId;
    private String productName;
    private int quantity;
    private double unitPrice;
    private double subtotal;

    public OrderItem(String productId, String productName, int quantity, double unitPrice) {
        this.productId = productId;
        this.productName = productName;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
        calculateSubtotal();
    }

    public double calculateSubtotal() {
        subtotal = quantity * unitPrice;
        return subtotal;
    }

    public String getProductId() { return productId; }
    public int getQuantity() { return quantity; }
    public double getSubtotal() { return subtotal; }

    @Override
    public String toString() {
        return productName + " x" + quantity + " = $" + subtotal;
    }
}
