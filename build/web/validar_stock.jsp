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
          <h1><b>Hulk Store</b></h1>
          <hr>
        </div>
      </div>

      <div class="grid-x grid-padding-x">
        <div class="large-12  cell">
          <h3>Ups!</h3>
        </div>
        <div class="large-12  cell">
            <p>Actualmente no tenemos en stock la cantidad solicitada.</p>
            <p>Te recomiendo revisar el catalogo de producto para revisar disponiblidad.</p>
            <br>
            <h3><a href="index.jsp">Regresar a pagina principal</a></h3>
        </div>
      </div>  

    </div>

    <script src="js/vendor/jquery.js"></script>
    <script src="js/vendor/what-input.js"></script>
    <script src="js/vendor/foundation.js"></script>
    <script src="js/app.js"></script>
  </body>
</html>
