
package Modelo;

/**
 *
 * @author Meza
 */
public class Customer {
    int id;
    String dni;
    String Customer;
    String Address;
    int Status;
    
    public Customer(){}

    public Customer(int id, String dni, String Customer, String Address, int Status) {
        this.id = id;
        this.dni = dni;
        this.Customer = Customer;
        this.Address = Address;
        this.Status = Status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getCustomer() {
        return Customer;
    }

    public void setCustomer(String Customer) {
        this.Customer = Customer;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public int getStatus() {
        return Status;
    }

    public void setStatus(int Status) {
        this.Status = Status;
    }

    
    
}
