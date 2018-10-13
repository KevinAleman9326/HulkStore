<%-- 
    Document   : index
    Created on : 10/04/2018, 08:48:52 AM
    Author     : Kevin E. Alemán
--%>

<%@page import="tienda.Producto"%>
<%@page import="java.util.List"%>
<%@page import="conexion_db.Acciones"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html class="no-js" lang="en" dir="ltr">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="x-ua-compatible" content="ie=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Hulk Store</title>
    <link rel="stylesheet" href="css/foundation.css">
    <link rel="stylesheet" href="css/app.css">
  </head>
  <body>
    <div class="grid-container">
      <div class="grid-x grid-padding-x">
        <div class="large-12 cell">
            <div class="card-divider">
                <h1><b>Hulk Store</b></h1>
            </div>
          <hr>
        </div>
      </div>

      <div class="grid-x grid-padding-x">
        <div class="large-12  cell">
          <h3>Productos</h3>
        </div>
        <div class="large-12  cell">
        <div class="card-section">

          <table>
              <th>Código</th><th>Nombre</th><th>Descripción</th><th>Cantidad Disponible</th>
              <tbody style="text-align:center;" id="productos">
                  <% 
                    Acciones producto = new Acciones();
                    List<Producto> tabla = producto.getTablaProducto();
                    for(int i=0;i<tabla.size();i++)
                    {
                  %>
                  <tr>
                      <td><%=tabla.get(i).getId()%></td>
                      <td><%=tabla.get(i).getNombre()%></td>
                      <td><%=tabla.get(i).getDescripcion()%></td>
                      <td><%=tabla.get(i).getCantidad()%></td>
                  </tr>
                  <%
                    }
                  %>
              </tbody>
          </table>
        </div>
        </div>
        <div class="large-12 cell">
            <h3>Opciones</h3>
        </div>
        <div class="large-4  midium-4 cell">
          <div class="callout">
             <h5>Nuevo producto al catalogo</h5>
             <form action="NuevoProducto" method="POST">
                <input type="text" id="id_prod" name="id_prod" placeholder="Codigo">
                <input type="text" id="nombre_prod" name="nombre_prod" placeholder="Nombre">
                <input type="text" id="descripcion_prod" name="descripcion_prod" placeholder="Descripcion">
                <input type="submit" id="add_submit" name="add_submit" class="button" value="Agregar">
             </form>
          </div>
        </div>
        <div class="large-4 midium-4 cell">
          <div class="callout">
                <h5>Agregar</h5>
                <form action="EntradaProducto" method="POST">
                  <select id="id_produ" name="id_produ">
                      
                      <%
                          for(int i=0;i<tabla.size();i++)
                          {
                      %>
                          <option value="<%=tabla.get(i).getId()%>"><%=tabla.get(i).getNombre()%></option>
                      <%
                          }
                      %>
                  </select>
                  <input type="text" id="cantidad_produ" name="cantidad_produ" placeholder="Cantidad entrante">
                  <input type="submit" class="button" id="in_submit" name="in_submit" value="Entrada">
                </form>
          </div>
        </div>
        <div class="large-4 midium-4 cell">
          <div class="callout">
              <h5>Retirar</h5>
              <form action="SalidaProducto" method="POST">
                <select id="id_prd" name="id_prd">
                    
                    <%
                        for(int i=0;i<tabla.size();i++)
                        {
                    %>
                        <option value="<%=tabla.get(i).getId()%>"><%=tabla.get(i).getNombre()%></option>
                    <%
                        }
                    %>
                </select>
                <input type="text" id="cantidad_prd" name="cantidad_prd" placeholder="Cantidad de Salida">
                <input type="submit"  class="button" id="out_submit" name="out_submit" value="Salida">
              </form>
          </div>
        </div>
      </div>  

    </div>

    <script src="js/vendor/jquery.js"></script>
    <script src="js/vendor/what-input.js"></script>
    <script src="js/vendor/foundation.js"></script>
    <script src="js/app.js"></script>
  </body>
</html>
