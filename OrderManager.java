import java.util.Vector;

public class OrderManager {
    private Vector<Order> orders = new Vector<>();

    public void addOrder(Order order) {
        orders.add(order);
    }

    public Order findOrder(String orderId) {
        for (Order o : orders)
            if (o.getOrderId().equals(orderId))
                return o;
        return null;
    }

    public Vector<Order> getOrdersByStatus(String status) {
        Vector<Order> result = new Vector<>();
        for (Order o : orders)
            if (o.getOrderStatus().equalsIgnoreCase(status))
                result.add(o);
        return result;
    }

    public Vector<Order> getOrdersByCustomer(String customerName) {
        Vector<Order> result = new Vector<>();
        for (Order o : orders)
            if (o.getCustomerName().equalsIgnoreCase(customerName))
                result.add(o);
        return result;
    }

    public double getTotalRevenue() {
        double total = 0;
        for (Order o : orders)
            if (o.getOrderStatus().equals("Delivered"))
                total += o.calculateTotal();
        return total;
    }

    public void cancelOrder(String orderId) {
        Order o = findOrder(orderId);
        if (o != null) o.updateStatus("Cancelled");
    }

    public void printAllOrders() {
        for (Order o : orders) o.printOrder();
    }

    public Vector<Order> getPendingOrders() {
        return getOrdersByStatus("Pending");
    }

    public int getOrderCount() {
        return orders.size();
    }
}
