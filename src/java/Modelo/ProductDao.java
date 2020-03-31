package Modelo;

import Config.ConecToMySql;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Meza
 */
public class ProductDao {

    ConecToMySql cn = new ConecToMySql();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int Rsp;

    public Product Buscar(int id){
        Product prod = new Product();
    String sql = "Select * from producto where IdProducto="+id;
        try {
            con = cn.ConecToMySql();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {                
                prod.setId(rs.getInt(1));
                prod.setProduct(rs.getString(2));
                prod.setAmount(rs.getDouble(3));
                prod.setStock(rs.getInt(4));
                prod.setStatus(rs.getInt(5));
            }
        } catch (Exception e) {
        }
        return prod;
    }
    
    public int ActualizaStok(int Id, int Stock){
    String sql= "UPDATE producto Set Stock=? Where IdProducto=?";
        try {
            con = cn.ConecToMySql();
            ps = con.prepareStatement(sql);
            ps.setInt(1, Stock);
            ps.setInt(2, Id);
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return Rsp;
    }
    
    /******+ OPERACIONES CRUD ******/
    public List ListProduct() {
        String sql = "Select * from producto";
        List myList = new ArrayList<>();
        try {
            con = cn.ConecToMySql();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Product prod = new Product();
                prod.setId(rs.getInt(1));
                prod.setProduct(rs.getString(2));
                prod.setAmount(rs.getDouble(3));
                prod.setStock(rs.getInt(4));
                prod.setStatus(rs.getInt(5));
                myList.add(prod);
            }
        } catch (Exception e) {
        }
        return myList;
    }

    public int Insert(Product prod) {
        String sql = "Insert Into producto(Nombres, Precio, Stock, Estado) Values(?,?,?,?)";
        try {
            con = cn.ConecToMySql();
            ps = con.prepareStatement(sql);
            ps.setString(1, prod.getProduct());
            ps.setDouble(2, prod.getAmount());
            ps.setInt(3, prod.getStock());
            ps.setInt(4, prod.getStatus());
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return Rsp;
    }

    public Product ListId(int id) {
        Product prod = new Product();
        String sql = "Select * from producto where IdProducto=" + id;
        try {
            con = cn.ConecToMySql();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                prod.setId(rs.getInt(1));
                prod.setProduct(rs.getString(2));
                prod.setAmount(rs.getDouble(3));
                prod.setStock(rs.getInt(4));
                prod.setStatus(rs.getInt(5));
            }
        } catch (Exception e) {
        }
        return prod;
    }

    public int Update(Product prod) {
        String sql = "Update producto set Nombres=?, Precio=?, Stock=?, Estado=? Where IdProducto=?";
        try {
            con = cn.ConecToMySql();
            ps = con.prepareStatement(sql);
            ps.setString(1, prod.getProduct());
            ps.setDouble(2, prod.getAmount());
            ps.setInt(3, prod.getStock());
            ps.setInt(4, prod.getStatus());
            ps.setInt(5, prod.getId());
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return Rsp;
    }

    public void Delete(int id) {
        String sql = "Delete from producto where IdProducto=" + id;
        try {
            con = cn.ConecToMySql();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }
}
