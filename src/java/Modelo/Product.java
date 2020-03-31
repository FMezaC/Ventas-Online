
package Modelo;

/**
 *
 * @author Meza
 */
public class Product {
    int Id;
    String Product;
    double Amount;
    int Stock;
    int Status;
    
    public Product(){}

    public Product(int Id, String Product, double Amount, int Stock, int Status) {
        this.Id = Id;
        this.Product = Product;
        this.Amount = Amount;
        this.Stock = Stock;
        this.Status = Status;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getProduct() {
        return Product;
    }

    public void setProduct(String Product) {
        this.Product = Product;
    }

    public double getAmount() {
        return Amount;
    }

    public void setAmount(double Amount) {
        this.Amount = Amount;
    }

    public int getStock() {
        return Stock;
    }

    public void setStock(int Stock) {
        this.Stock = Stock;
    }

    public int getStatus() {
        return Status;
    }

    public void setStatus(int Status) {
        this.Status = Status;
    }
    
    
}
