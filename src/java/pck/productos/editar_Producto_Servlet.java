package pck.productos;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class editar_Producto_Servlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        try {
            int Id = Integer.parseInt(request.getParameter("Id"));
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/WebProducts", "root", "Admin$123");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from Products where Id=" + Id);
            resultSet.next();

            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Editar Producto</title>");
            out.println("<script src=\"https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js\" integrity=\"sha384-oBqDVmMz9ATKxIep9tiCxS/Z9fNfEXiDAYTujMAeBAsjFuCZSmKbSSUnQlmh/jp3\" crossorigin=\"anonymous\"></script>");
            out.println("<script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.min.js\" integrity=\"sha384-7VPbUDkoPSGFnVtYi0QogXtr74QeVeeIs99Qfg5YCF+TidwNdjvaKZX19NZ/e6oz\" crossorigin=\"anonymous\"></script>");
            out.println("<link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css\" rel=\"stylesheet\" integrity=\"sha384-iYQeCzEYFbKjA/T2uDLTpkwGzCiq6soy8tYaI1GyVh/UjpbCx/TYkiZhlZB6+fzT\" crossorigin=\"anonymous\">");
            out.println("</head>");
            out.println("<body>");
            out.println("<div class=\"bg-image\" style=\"background-image: url('https://images2.alphacoders.com/774/774122.jpg'); height: 100vh\">");
            
            out.println("<nav class=\"navbar navbar-dark navbar-expand-lg bg-dark\">");
            out.println("<div class=\"container-fluid\">");
            out.println("<a class=\"navbar-brand\" href=\"index.html\">Productos.com</a>");
            out.println("<button class=\"navbar-toggler\" type=\"button\" data-bs-toggle=\"collapse\" data-bs-target=\"#navbarNav\" aria-controls=\"navbarNav\" aria-expanded=\"false\" aria-label=\"Toggle navigation\">");
            out.println("<span class=\"navbar-toggler-icon\"></span>");
            out.println("</button>");
            out.println("<div class=\"collapse navbar-collapse\" id=\"navbarNav\">");
            out.println("<ul class=\"navbar-nav\">");
            out.println("<li class=\"nav-item\">");
            out.println("</li>");
            out.println("</ul>");
            out.println("</div>");
            out.println("</div>");
            out.println("</nav>");
            
            out.println("<div class=\"container\" style=\"margin-top:5%\">");
            out.println("<div class='card text-bg-dark mb-3' style='width: 45rem;'>");
            out.println("    <div class='card-header'>");
            out.println("        <a class=\"btn btn-light\" href=\"productos_Servlet\">Volver</a>");
            out.println("    </div>");
            out.println("    <div class='card-body'>");
            out.println("        <form action='modificar_Producto_Servlet' method='post'>");
            out.println("            <div class='row'>");
            
            out.println("                <div class='col'>");
            out.println("                    <div class='form-floating mb-3'>");
            out.println("                        <input value='" + resultSet.getInt("Id") + "' name='txtId' type='number' class=\"form-control text-bg-dark p-3\" id='txtId' required readonly>");
            out.println("                        <label class=\"text-bg-dark p-3\" for='txtId'>Id</label>");
            out.println("                    </div>");
            out.println("                    <div class='form-floating mb-3'>");
            out.println("                        <input value='" + resultSet.getString("Nombre") + "' name='txtNombre' type='text' class=\"form-control text-bg-dark p-3\" id='txtNombre' required>");
            out.println("                        <label class=\"text-bg-dark p-3\" for='txtNombre'>Nombre</label>");
            out.println("                    </div>        ");
            out.println("                    <div class='form-floating mb-3'>");
            out.println("                        <input value='" + resultSet.getString("Categoria") + "' name='txtCategoria' type='text' class=\"form-control text-bg-dark p-3\" id='txtCategoria' required>");
            out.println("                        <label class=\"text-bg-dark p-3\" for='txtCategoria'>Categoria</label>");
            out.println("                    </div> ");
            out.println("                    <div class='form-floating mb-3'>");
            out.println("                        <input value='" + resultSet.getInt("Precio") + "' name='txtPrecio' type='number' class=\"form-control text-bg-dark p-3\" id='txtPrecio' required>");
            out.println("                        <label class=\"text-bg-dark p-3\" for='txtPrecio'>Precio</label>");
            out.println("                    </div>  ");
            out.println("                    <div class='form-floating mb-3'>");
            out.println("                        <input value='" + resultSet.getString("Fecha") + "' name='txtFecha' type='text' class=\"form-control text-bg-dark p-3\" id='txtFecha' required>");
            out.println("                        <label class=\"text-bg-dark p-3\" for='txtFecha'>Fecha</label>");
            out.println("                    </div>  ");
            out.println("                </div>");
            out.println("            </div>");
            out.println("            <hr>");
            out.println("            <button type='submit' class=\"btn btn-warning\" style='float: right;margin-left:3px'>Actualizar</button>");                        
            out.println("        </form>");                        
            out.println("    </div>");            
            out.println("</div>");
            out.println("</div>");
            out.println("</div>");
            out.println("</body>");
            out.println("</html>");

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
