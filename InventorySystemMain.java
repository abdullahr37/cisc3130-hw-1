public class InventorySystemMain {
    public static void main(String[] args) {
        ProductInventory inventory = new ProductInventory();

        inventory.addProduct(new Product("P001", "Laptop", "Electronics", 999.99, 10, "TechCorp"));
        inventory.addProduct(new Product("P002", "T-Shirt", "Clothing", 19.99, 50, "FashionInc"));
        inventory.addProduct(new Product("P003", "Mouse", "Electronics", 29.99, 5, "TechCorp"));

        inventory.printAllProducts();
        inventory.printCapacityReport();

        OrderManager om = new OrderManager();
        Order o1 = new Order("O001", "Alice", "2024-01-15");
        o1.addItem(new OrderItem("P001", "Laptop", 1, 999.99));
        o1.addItem(new OrderItem("P003", "Mouse", 2, 29.99));
        o1.updateStatus("Delivered");
        om.addOrder(o1);

        om.printAllOrders();
        System.out.println("Revenue: $" + om.getTotalRevenue());
    }
}
