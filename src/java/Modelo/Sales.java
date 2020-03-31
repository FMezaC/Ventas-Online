/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.Date;

/**
 *
 * @author Meza
 */
public class Sales {
    Integer id;
    Integer item;
    Integer idCli;
    Integer idEmp;
    Integer idProd;
    String NumSerie;
    String Descrip;
    String fecha;
    Double Precio;
    Integer Cant;
    Double SubTot;
    Double Mont;
    Integer Stado;

    public Sales() {
    }

    public Sales(Integer id, Integer item, Integer idCli, Integer idEmp, Integer idProd, String NumSerie, String Descrip, String fecha, Double Precio, Integer Cant, Double SubTot, Double Mont, Integer Stado) {
        this.id = id;
        this.item = item;
        this.idCli = idCli;
        this.idEmp = idEmp;
        this.idProd = idProd;
        this.NumSerie = NumSerie;
        this.Descrip = Descrip;
        this.fecha = fecha;
        this.Precio = Precio;
        this.Cant = Cant;
        this.SubTot = SubTot;
        this.Mont = Mont;
        this.Stado = Stado;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getItem() {
        return item;
    }

    public void setItem(Integer item) {
        this.item = item;
    }

    public Integer getIdCli() {
        return idCli;
    }

    public void setIdCli(Integer idCli) {
        this.idCli = idCli;
    }

    public Integer getIdEmp() {
        return idEmp;
    }

    public void setIdEmp(Integer idEmp) {
        this.idEmp = idEmp;
    }

    public Integer getIdProd() {
        return idProd;
    }

    public void setIdProd(Integer idProd) {
        this.idProd = idProd;
    }

    public String getNumSerie() {
        return NumSerie;
    }

    public void setNumSerie(String NumSerie) {
        this.NumSerie = NumSerie;
    }

    public String getDescrip() {
        return Descrip;
    }

    public void setDescrip(String Descrip) {
        this.Descrip = Descrip;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public Double getPrecio() {
        return Precio;
    }

    public void setPrecio(Double Precio) {
        this.Precio = Precio;
    }

    public Integer getCant() {
        return Cant;
    }

    public void setCant(Integer Cant) {
        this.Cant = Cant;
    }

    public Double getSubTot() {
        return SubTot;
    }

    public void setSubTot(Double SubTot) {
        this.SubTot = SubTot;
    }

    public Double getMont() {
        return Mont;
    }

    public void setMont(Double Mont) {
        this.Mont = Mont;
    }

    public Integer getStado() {
        return Stado;
    }

    public void setStado(Integer Stado) {
        this.Stado = Stado;
    }
    
}
