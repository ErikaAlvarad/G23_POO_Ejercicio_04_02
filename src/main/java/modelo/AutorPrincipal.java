/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author erika
 */
public class AutorPrincipal implements java.io.Serializable {
    private String nombre;
    private String origen;
    private int yearNacimiento;
    private double salario;
    private int codigo;

    public AutorPrincipal(int codigo, String nombre, String origen, int yearNacimiento, double salario ) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.origen = origen;
        this.yearNacimiento = yearNacimiento;
        this.salario = salario;
        
    }

    public int calcularEdad (int yearActual){
        var retorno = yearActual - this.getYearNacimiento();
        return retorno;
    }
    
    public String obtenerPaisOrigen(){
       return this.getOrigen();
    }
    
    
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public int getYearNacimiento() {
        return yearNacimiento;
    }

    public void setYearNacimiento(int yearNacimiento) {
        this.yearNacimiento = yearNacimiento;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    @Override
    public String toString() {
        return "AutorPrincipal{" + "nombre=" + nombre + ", origen=" + origen + ", yearNacimiento=" + yearNacimiento + ", salario=" + salario + ", codigo=" + codigo + '}';
    }

   
    
}
