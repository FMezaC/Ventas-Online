/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
public class EmpleadoDao {
    ConecToMySql cn = new ConecToMySql();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int Rsp;
    public Empleado Validar(String user, String Dni){
        Empleado em = new Empleado();
        String sql = "select * from empleado where User=? AND Dni=?";
        try {
            con = cn.ConecToMySql();
            ps= con.prepareStatement(sql);
            ps.setString(1, user);
            ps.setString(2, Dni);
            rs = ps.executeQuery();
            while (rs.next()) {
                Empleado.setIdLog(rs.getInt("IdEmpleado"));
                em.setUser(rs.getString("User"));
                em.setNumDoc(rs.getString("Dni"));
                em.setEmpleyees(rs.getString("Nombres"));
           }
        } catch (Exception e) {
        }
        return em;
    }
    
    public List ListEmpleado(){
        String sql = "Select * from Empleado";
        List myList = new ArrayList<>();
        try {
            con = cn.ConecToMySql();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Empleado emp = new Empleado();
                emp.setId(rs.getInt(1));
                emp.setNumDoc(rs.getString(2));
                emp.setEmpleyees(rs.getString(3));
                emp.setTelNumb(rs.getString(4));
                emp.setEstado(rs.getInt(5));
                emp.setUser(rs.getString(6));
                myList.add(emp);
            }
        } catch (Exception e) {
        }
            return myList;
    }
    
    public int Agregar( Empleado emp){
        String sql = "Insert Into Empleado(Dni, Nombres, Telefono, Estado, User) Values(?,?,?,?,?)";
        try {
            con = cn.ConecToMySql();
            ps = con.prepareStatement(sql);
            ps.setString(1, emp.getNumDoc());
            ps.setString(2, emp.getEmpleyees());
            ps.setString(3, emp.getTelNumb());
            ps.setInt(4, emp.getEstado());
            ps.setString(5, emp.getUser());
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return Rsp;
    }
    
    public Empleado ListId(int id){
        Empleado emp = new Empleado();
        String sql= "Select * from empleado where IdEmpleado="+id;
        try {
            con = cn.ConecToMySql();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                emp.setId(rs.getInt(1));
                emp.setNumDoc(rs.getString(2));
                emp.setEmpleyees(rs.getString(3));
                emp.setTelNumb(rs.getString(4));
                emp.setEstado(rs.getInt(5));
                emp.setUser(rs.getString(6));
            }
        } catch (Exception e) {
        }
        return emp;
    }
    
    public int Actualizar(Empleado emp){
        String sql = "Update Empleado set Dni=?, Nombres=?, "
                + "Telefono=?, Estado=?, User=? WHERE IdEmpleado=?";
        try {
            con = cn.ConecToMySql();
            ps = con.prepareStatement(sql);
            ps.setString(1, emp.getNumDoc());
            ps.setString(2, emp.getEmpleyees());
            ps.setString(3, emp.getTelNumb());
            ps.setInt(4, emp.getEstado());
            ps.setString(5, emp.getUser());
            ps.setInt(6, emp.getId());
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return Rsp;
    }
    
    public void Eliminar(int id){
        String sql = "Delete from Empleado where IdEmpleado="+id;
        try {
            con =cn.ConecToMySql();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }
}
