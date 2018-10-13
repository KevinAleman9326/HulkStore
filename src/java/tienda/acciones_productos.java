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
public interface acciones_productos {
    
    public void setId(int id);
    public int getId();
    public void setNombre(String nombre);
    public String getNombre();
    public void setDescripcion(String descripcion);
    public String getDescripcion();
    public void setCantidad(int cantidad);
    public int getCantidad();
    
}
