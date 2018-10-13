/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexion_db;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import tienda.Producto;

/**
 *
 * @author Kevin E. Alemán
 */
public class Acciones extends Conexion implements acciones_db{

    private int stock;
    
    public int getStock(){
        return this.stock;
    }
            
    @Override
    public void insertTablaProducto(int Id, String Nombre, String Descripcion) {
        
        try {
            System.out.println("Insertar nuevo producto.");
             // the mysql insert statement
            String query = " insert into producto (id, Nombre, Descripcion,Cantidad) values (?, ?, ?, 0)";

            // create the mysql insert preparedstatement
            PreparedStatement sentencia = con.prepareStatement(query);
            sentencia.setInt(1, Id);
            sentencia.setString (2, Nombre);
            sentencia.setString (3, Descripcion);
            
            // execute the preparedstatement
            sentencia.execute();
            System.out.println("EXITOS - Insertar nuevo producto --> "+Id+" || "+Nombre+" || "+Descripcion);
        } catch (com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException ex) {
            System.out.println("El producto ya existe en la base de datos. Revisa el catalogo de productos.");
        }  catch (java.lang.NullPointerException ex) {
            System.out.println("No Se tiene acceso a BD.");
        } catch (SQLException ex) {
            Logger.getLogger(Acciones.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }

    @Override
    public void entradaProducto(int Id, int Cantidad) {
        try {
            System.out.println("Nueva entrada de producto.");
             // the mysql insert statement
            HashMap producto = getProducto(Id);
            int cantidad = Integer.parseInt(producto.get("cantidad").toString())+Cantidad;
            
            String query = " update producto set cantidad = ? where  id = ?";

            // create the mysql insert preparedstatement
            PreparedStatement sentencia = con.prepareStatement(query);
            sentencia.setInt(1, cantidad);
            sentencia.setInt(2, Id);
           
            // execute the preparedstatement
            sentencia.execute();
            
            System.out.println("EXITO - Nueva entrada de producto --> "+Id+" || "+Cantidad);
        } catch (com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException ex) {
            System.out.println("El producto ya existe en la base de datos. Revisa el catalogo de productos.");
        }  catch (java.lang.NullPointerException ex) {
            System.out.println("No Se tiene acceso a BD.");
        } catch (SQLException ex) {
            Logger.getLogger(Acciones.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }

    @Override
    public void salidaProducto(int Id, int Cantidad) {
        try {
            System.out.println("Nueva salida de producto.");
             // the mysql insert statement
            HashMap producto = getProducto(Id);
            this.stock = Integer.parseInt(producto.get("cantidad").toString());
            int cantidad;
            
            if(this.stock >= Cantidad){
                cantidad = this.stock - Cantidad;
                System.out.println("Producto seleccionado tiene disponible: "+stock+". Salida de stock: "+cantidad);
            } else {
                System.out.println("Stock:"+this.stock+", cantidad:"+Cantidad);
                cantidad = 1/0;
            }
                
            String query = " update producto set cantidad = ? where  id = ?";

            // create the mysql insert preparedstatement
            PreparedStatement sentencia = con.prepareStatement(query);
            sentencia.setInt(1, cantidad);
            sentencia.setInt(2, Id);
           
            // execute the preparedstatement
            sentencia.execute();
            
            System.out.println("EXITO - Nueva salida de producto --> "+Id+" || "+Cantidad);
        } catch (com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException ex) {
            System.out.println("El producto ya existe en la base de datos. Revisa el catalogo de productos.");
        }  catch (java.lang.NullPointerException ex) {
            System.out.println("No Se tiene acceso a BD.");
        }  catch (java.lang.ArithmeticException ex) {
            System.out.println("Producto seleccionado no tiene disponible en el stock. Por favor revisar el catalogo de producto para revisar disponibilidad. ");
        }  catch (SQLException ex) {
            Logger.getLogger(Acciones.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
   
    @Override
    public List<Producto> getTablaProducto() {
        System.out.println("INICIO - Consultar catalogo");
        List productos = new ArrayList();
        try {
            Statement accion = con.createStatement();
            ResultSet resultado;
            String consulta = "select * from producto";
            resultado = accion.executeQuery(consulta);
            while(resultado.next()){
                Producto producto = new Producto();
                producto.setId(Integer.parseInt(resultado.getString("id")));
                producto.setNombre(resultado.getString("nombre"));
                producto.setDescripcion(resultado.getString("descripcion"));
                producto.setCantidad(Integer.parseInt(resultado.getString("cantidad")));
                productos.add(producto);
            }
            cerrar_conexion();
            System.out.println("FIN - Consultar catalogo");
        
        }  catch (java.lang.NullPointerException ex) {
            System.out.println("No se pudo conseguir información de la fuente");
        }  catch (SQLException ex) {
            Logger.getLogger(Acciones.class.getName()).log(Level.SEVERE, null, ex);
        } 

        return productos;
        
    }
    
    @Override
    public HashMap getProducto(int id) {
        
        System.out.println("INICIO - Consulta de producto");
        HashMap producto = new HashMap();
        try {
            
            Statement accion = con.createStatement();
            ResultSet resultado;
            String consulta = "select * from producto where id = "+id;
            resultado = accion.executeQuery(consulta);
            resultado.next();
            producto.put("id",resultado.getString("id"));
            producto.put("nombre",resultado.getString("nombre"));
            producto.put("descripcion",resultado.getString("descripcion"));
            producto.put("cantidad",resultado.getString("cantidad"));
            
            System.out.println("Consulta - Consulta de producto --> Id:"+resultado.getString("id")+" || Nombre:"+resultado.getString("nombre")+" || Descripcion:"+resultado.getString("nombre")+" || cantidad: "+resultado.getString("cantidad"));
            
        }  catch (java.lang.NullPointerException ex) {
            System.out.println("No se pudo conseguir información de la fuente");
        }  catch (SQLException ex) {
            Logger.getLogger(Acciones.class.getName()).log(Level.SEVERE, null, ex);
        } 
        
        System.out.println("FIN - Consulta de producto");
        
         return producto;
    }
    
    public void cerrar_conexion() {
        try {
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(Acciones.class.getName()).log(Level.SEVERE, null, ex);
        } catch (java.lang.NullPointerException ex) {
            System.out.println("Conexion nunca fue abierta.");
        } 
    }
}
