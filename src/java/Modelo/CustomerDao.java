
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
public class CustomerDao {
    ConecToMySql cn = new ConecToMySql();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int rsp;
    
    public Customer Search(String Dni){
        Customer cus = new Customer();
        String sql = "Select * from cliente where Dni="+Dni;
        try {
            con = cn.ConecToMySql();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                cus.setId(rs.getInt(1));
                cus.setDni(rs.getString(2));
                cus.setCustomer(rs.getString(3));
                cus.setAddress(rs.getString(4));
                cus.setStatus(rs.getInt(5));
            }
        } catch (Exception e) {
        }
        return cus;
    }
    /******** OPERACIONES CRUD *****/
    public List ListCustomer(){
        String sql = "Select * from cliente";
        List myList = new ArrayList<>();
        try {
            con = cn.ConecToMySql();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {                
                Customer cust = new Customer();
                cust.setId(rs.getInt(1));
                cust.setDni(rs.getString(2));
                cust.setCustomer(rs.getString(3));
                cust.setAddress(rs.getString(4));
                cust.setStatus(rs.getInt(5));
                myList.add(cust);
            }
        } catch (Exception e) {
        }
        return myList;
    }
    
    public int Insert(Customer cust){
        String sql="Insert Into cliente(Dni,Nombres,Direccion,Estado) values(?,?,?,?)";
        try {
            con = cn.ConecToMySql();
            ps = con.prepareStatement(sql);
            ps.setString(1, cust.getDni());
            ps.setString(2, cust.getCustomer());
            ps.setString(3, cust.getAddress());
            ps.setInt(4, cust.getStatus());
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return rsp;
    }
    
    public Customer ListId(int id){
        Customer cust = new Customer();
        String sql = "Select * from cliente where IdCliente="+id;
        try {
            con = cn.ConecToMySql();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                cust.setId(rs.getInt(1));
                cust.setDni(rs.getString(2));
                cust.setCustomer(rs.getString(3));
                cust.setAddress(rs.getString(4));
                cust.setStatus(rs.getInt(5));
            }
        } catch (Exception e) {
        }
        return cust;
    }
    
    public int Update(Customer cust){
        String sql = "Update cliente set Dni=?, Nombres=?, Direccion=?, Estado=? Where IdCliente=?";
        try {
            con = cn.ConecToMySql();
            ps = con.prepareStatement(sql);
            ps.setString(1, cust.getDni());
            ps.setString(2, cust.getCustomer());
            ps.setString(3, cust.getAddress());
            ps.setInt(4, cust.getStatus());
            ps.setInt(5, cust.getId());
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return rsp;
    }
    
    public void Delete(int id){
        String sql = "Delete From cliente Where IdCliente="+id;
        try {
            con = cn.ConecToMySql();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }
}
