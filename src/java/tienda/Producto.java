/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tienda;

/**
 *
 * @author Kevin E. Alemán
 */
public class Producto implements acciones_productos{
    private int Id;
    private String Nombre;
    private String Descripcion;
    private int Cantidad;   
    
    @Override
    public void setId(int id) {
        this.Id = id;
    }

    @Override
    public int getId() {
        return this.Id;
    }

    @Override
    public void setNombre(String nombre) {
        this.Nombre = nombre;
    }

    @Override
    public String getNombre() {
        return this.Nombre;
    }

    @Override
    public void setDescripcion(String descripcion) {
        this.Descripcion = descripcion;
    }

    @Override
    public String getDescripcion() {
        return this.Descripcion;
    }

    @Override
    public void setCantidad(int cantidad) {
        this.Cantidad = cantidad;
    }

    @Override
    public int getCantidad() {
        return this.Cantidad;
    }
}
