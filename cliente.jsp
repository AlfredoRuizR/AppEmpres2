<%-- 
    Document   : cliente
    Created on : 10-nov-2018, 16:27:30
    Author     : Alfredo Ruíz
--%>

<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="controlador.Conectar"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cliente</title>
         <%@include file="principal\componentes\head.html" %>
    </head>
    <body>
        <%@include file="principal\componentes\preloader.html" %>
         <%@include file="principal\componentes\navegacion_inicio.html" %>
         <br>
         <br>
         <br>
         <br>
        <div class="card-body">
            <div class="table-responsive">
            <table id="datatable" class="table table-striped table-bordered p-0">
              <thead>
                  <tr>
                      <th>Id Producto</th>
                      <th>Descripcion Producto</th>
                      <th>Unidad Producto</th>
                      <th>Cantidad</th>
                      <th>Ubicacion en Almacen</th>
                  </tr>
              </thead>
              <tbody>
                   <%  
                        Connection conectame;

                        Conectar objCon = new Conectar();
                        conectame = objCon.getConnection();
                        Statement st = conectame.createStatement();
                        ResultSet rs = st.executeQuery("select * from productos");
                        while(rs.next()){
                    %>
                  <tr>
                      <td><%=rs.getObject("id_producto")%></td>
                      <td><%=rs.getObject("descripcion_producto")%></td>
                      <td><%=rs.getObject("unidad_producto")%></td>
                      <td><%=rs.getObject("cantidad_producto")%></td>
                      <td><%=rs.getObject("ubicacion_almacen")%></td>
                  </tr>
                  <%}%>
              </tfoot>
              
           </table>
          </div>
          </div>

         <%@include file="principal\componentes\footer.html" %>
        <%@include file="principal\componentes\mis_scripts.html" %>
    </body>
</html>
