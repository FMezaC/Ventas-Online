
package Modelo;

import Config.ConecToMySql;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Meza
 */
public class SalesDao {
    Connection con;
    ConecToMySql cn = new ConecToMySql();
    PreparedStatement ps;
    ResultSet rs;
    int rsp;
    
    public String GenerarSerie(){
        String NumeroSerie = "";
        String sql = "SELECT MAX(NumeroSerie) FROM ventas";
        try {
            con = cn.ConecToMySql();
            ps = con.prepareStatement(sql);
            rs= ps.executeQuery();
            while (rs.next()) {                
                NumeroSerie = rs.getString(1);
            }
        } catch (Exception e) {
        }
        return NumeroSerie;
    }
    
    public String IdVenta(){
        String idVentas="";
        String sql = "SELECT MAX(IdVentas) FROM ventas";
        try {
            con = cn.ConecToMySql();
            ps = con.prepareStatement(sql);
            rs= ps.executeQuery();
            while (rs.next()) {                
                idVentas = rs.getString(1);
            }
        } catch (Exception e) {
        }
        return idVentas;
    }
    
    public int GuardarVentas(Sales sls){
        String sql = "INSERT INTO ventas (IdCliente, IdEmpleado, NumeroSerie, "
                + "FechaVentas, Monto, Estado) VALUES(?,?,?,?,?,?)";
        try {
            con = cn.ConecToMySql();
            ps= con.prepareStatement(sql);
            ps.setInt(1, sls.getIdCli());
            ps.setInt(2, sls.getIdEmp());
            ps.setString(3, sls.getNumSerie());
            ps.setString(4, sls.getFecha());
            ps.setDouble(5, sls.getMont());
            ps.setInt(6, sls.getStado());
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return rsp;
    }
    
    public int GuardarDetalle(Sales Det_sls){
    String sql = "INSERT INTO detalle_ventas (IdVentas, IdProducto, "
            + "Cantidad, PrecioVenta) VALUES (?,?,?,?)";
        try {
            con = cn.ConecToMySql();
            ps= con.prepareStatement(sql);
            ps.setInt(1, Det_sls.getId());
            ps.setInt(2, Det_sls.getIdProd());
            ps.setInt(3, Det_sls.getCant());
            ps.setDouble(4, Det_sls.getPrecio());
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return rsp;
    }
}
