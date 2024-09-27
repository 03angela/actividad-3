/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.util.Date;
import javax.swing.JOptionPane;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author aguin
 */
public class Docente extends Persona {
    Conexion cn;
    private String codigo;
    private double salario;
    private Date fechalaborar;
    private Date fechaIngresoRegistro;
    private int genero;


    public Docente() {}

    public Docente(Conexion cn, String codigo, double salario, Date fechalaborar, Date fechaIngresoRegistro, int genero) {
        this.cn = cn;
        this.codigo = codigo;
        this.salario = salario;
        this.fechalaborar = fechalaborar;
        this.fechaIngresoRegistro = fechaIngresoRegistro;
        this.genero = genero;
    }


    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public Date getFechalaborar() {
        return fechalaborar;
    }

    public void setFechalaborar(Date fechalaborar) {
        this.fechalaborar = fechalaborar;
    }

    public Date getFechaIngresoRegistro() {
        return fechaIngresoRegistro;
    }

    public void setFechaIngresoRegistro(Date fechaIngresoRegistro) {
        this.fechaIngresoRegistro = fechaIngresoRegistro;
    }
    
    public int getGenero() {
        return genero;
    }

    public void setGenero(int genero) {
        this.genero = genero;
    }
    
    

    @Override 
    protected void agregar() {
    try {
        PreparedStatement parametro;
        String query="INSERT INTO docente(nit, nombres, apellidos, direccion, telefono, fecha_nacimiento, salario, fecha_ingreso_laborar, fecha_ingreso_registro, genero) VALUES (?,?,?,?,?,?,?,?,?,?);";
    cn=new Conexion ();
    cn.abrir_conexion();
    parametro= (PreparedStatement) cn.conexionBD.prepareStatement(query);
    parametro.setString(1, this.getCodigo());
    parametro.setString(2, this.getNit());
    parametro.setString(3, this.getNombres());
    parametro.setString(4, this.getApellidos());
    parametro.setString(5, this.getDireccion());
    parametro.setString(6, this.getTelefono());
    parametro.setString(7, this.getFn());
    parametro.setDouble(8, this.getSalario ());
    parametro.setDate(9, (java.sql.Date) this.getFechalaborar());
    parametro.setDate(10,(java.sql.Date) this.getFechaIngresoRegistro());
    parametro.setInt(11, this.getGenero());
    
    int executar = parametro.executeUpdate();
    
    cn.cerrar_conexion();
    JOptionPane.showMessageDialog (null, Integer.toString(executar) + "Registro Ingresado","Agregar", JOptionPane.INFORMATION_MESSAGE);
    
    }
    catch (SQLException ex) {
        System.out.println("Error..." + ex.getMessage ());
    }
    } 


}
