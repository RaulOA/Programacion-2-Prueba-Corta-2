package pck.productos;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class modificar_Producto_Servlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        PrintWriter out = response.getWriter();

        try {
            int txtId = Integer.parseInt(request.getParameter("txtId"));
            String txtNombre = request.getParameter("txtNombre");
            String txtCategoria = request.getParameter("txtCategoria");
            int txtPrecio = Integer.parseInt(request.getParameter("txtPrecio"));
            String txtFecha = request.getParameter("txtFecha");

            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/WebProducts", "root", "Admin$123");
            Statement statement = connection.createStatement();

            String sql = "update Products set Nombre = '" + txtNombre
                    + "', Categoria = '" + txtCategoria
                    + "', Precio = " + txtPrecio
                    + ", Fecha = '" + txtFecha + "'"
                    + " where id = " + txtId;

            statement.executeUpdate(sql);
            statement.close();

            out.println("<script type='text/javascript'>alert('Producto Actualizado');</script>");
            RequestDispatcher rd = request.getRequestDispatcher("/productos_Servlet");
            rd.include(request, response);
        } catch (NumberFormatException | ClassNotFoundException | SQLException e) {
            out.println(e.getMessage());
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
