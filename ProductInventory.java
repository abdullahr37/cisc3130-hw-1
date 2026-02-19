import java.util.Vector;
import java.util.Enumeration;

public class ProductInventory {
    private Vector<Product> products = new Vector<>();

    public void addProduct(Product product) {
        if (findProduct(product.getProductId()) == null) {
            products.add(product);
        }
    }

    public boolean removeProduct(String productId) {
        Product p = findProduct(productId);
        return p != null && products.remove(p);
    }

    public Product findProduct(String productId) {
        for (Product p : products) {
            if (p.getProductId().equals(productId)) return p;
        }
        return null;
    }

    public Vector<Product> getProductsByCategory(String category) {
        Vector<Product> result = new Vector<>();
        for (Product p : products)
            if (p.getCategory().equalsIgnoreCase(category))
                result.add(p);
        return result;
    }

    public Vector<Product> getLowStockProducts(int threshold) {
        Vector<Product> result = new Vector<>();
        for (Product p : products)
            if (p.getQuantityInStock() < threshold)
                result.add(p);
        return result;
    }

    public double getTotalInventoryValue() {
        double total = 0;
        for (Product p : products)
            total += p.getPrice() * p.getQuantityInStock();
        return total;
    }

    public void updateStock(String productId, int quantityChange) {
        Product p = findProduct(productId);
        if (p != null)
            p.setQuantityInStock(p.getQuantityInStock() + quantityChange);
    }

    public void printAllProducts() {
        System.out.println("ID    Name            Category     Price    Qty   Supplier");
        for (Product p : products) System.out.println(p);
    }

    public int getTotalProducts() {
        return products.size();
    }

    public void printCapacityInfo() {
        System.out.println("Size: " + products.size());
        System.out.println("Capacity: " + products.capacity());
    }

    public void optimizeCapacity() {
        products.trimToSize();
    }

    public void ensureCapacity(int minCapacity) {
        products.ensureCapacity(minCapacity);
    }

    public void printCapacityReport() {
        int size = products.size();
        int cap = products.capacity();
        System.out.println("Size: " + size);
        System.out.println("Capacity: " + cap);
        System.out.println("Utilization: " + (size * 100.0 / cap) + "%");
        System.out.println("Remaining slots: " + (cap - size));
    }

    public void printProductsUsingEnumeration() {
        Enumeration<Product> e = products.elements();
        while (e.hasMoreElements())
            System.out.println(e.nextElement());
    }
}
