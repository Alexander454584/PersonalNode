
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
;import java.io.*;
import java.nio.charset.StandardCharsets;

@WebServlet(name = "DeleteServlet", value = {"/delete"})
public class Delete extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        FileOutputStream fout;
        try {
            File f = new File("C:/uploads/delete");
            f.createNewFile();
            FileWriter writer = new FileWriter("C:/uploads/delete");
            writer.write("No Goh");
            writer.close();
            request.setAttribute("message", "<div class=\"okno\"> Все ок!</div>");
        } catch (Exception ex) {
            request.setAttribute("message", "<div class=\"okno\"> "+ex+"</div>");
        }
        request.getRequestDispatcher("/upload.jsp").forward(request, response);
    }
}