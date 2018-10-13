/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexion_db;

import java.util.HashMap;
import java.util.List;
import tienda.Producto;


/**
 *
 * @author Kevin E. Alemán
 */
public interface acciones_db {
    
    public List<Producto> getTablaProducto();
    public HashMap getProducto(int id);
    public void insertTablaProducto(int id, String Nombre,String Descripcion);
    public void entradaProducto(int id,int cantidad);
    public void salidaProducto(int id,int cantidad);
   
}
