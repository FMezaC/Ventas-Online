/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author Meza
 */
public class Empleado {
    public static int IdLog;
    int Id;
    String numDoc;
    String Empleyees;
    String TelNumb;
    int estado;
    String user;
    
    public Empleado (){}

    public Empleado(int Id, String numDoc, String Empleyees, String TelNumb, int estado, String user) {
        this.Id = Id;
        this.numDoc = numDoc;
        this.Empleyees = Empleyees;
        this.TelNumb = TelNumb;
        this.estado = estado;
        this.user = user;
    }

    public static int getIdLog() {
        return IdLog;
    }

    public static void setIdLog(int IdLog) {
        Empleado.IdLog = IdLog;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getNumDoc() {
        return numDoc;
    }

    public void setNumDoc(String numDoc) {
        this.numDoc = numDoc;
    }

    public String getEmpleyees() {
        return Empleyees;
    }

    public void setEmpleyees(String Empleyees) {
        this.Empleyees = Empleyees;
    }

    public String getTelNumb() {
        return TelNumb;
    }

    public void setTelNumb(String TelNumb) {
        this.TelNumb = TelNumb;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    
    
}
