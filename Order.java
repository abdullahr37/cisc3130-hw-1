import java.util.Vector;

public class Order {
    private String orderId;
    private String customerName;
    private String orderDate;
    private String orderStatus = "Pending";
    private Vector<OrderItem> items = new Vector<>();

    public Order(String orderId, String customerName, String orderDate) {
        this.orderId = orderId;
        this.customerName = customerName;
        this.orderDate = orderDate;
    }

    public void addItem(OrderItem item) {
        items.add(item);
    }

    public boolean removeItem(String productId) {
        for (OrderItem i : items)
            if (i.getProductId().equals(productId))
                return items.remove(i);
        return false;
    }

    public double calculateTotal() {
        double total = 0;
        for (OrderItem i : items)
            total += i.getSubtotal();
        return total;
    }

    public int getTotalItems() {
        int total = 0;
        for (OrderItem i : items)
            total += i.getQuantity();
        return total;
    }

    public void updateStatus(String newStatus) {
        orderStatus = newStatus;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public String getOrderId() {
        return orderId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void printOrder() {
        System.out.println("Order " + orderId + " (" + customerName + ")");
        for (OrderItem i : items) System.out.println(i);
        System.out.println("Total: $" + calculateTotal());
    }

    public Vector<OrderItem> getItems() {
        return new Vector<>(items);
    }
}
