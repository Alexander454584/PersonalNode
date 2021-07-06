import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.nio.file.Files;
import java.util.List;

@WebServlet(name = "Copy", value = {"/copy"})
public class Copy extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        final String pathInfo = request.getPathInfo();
        InputStream is = null;
        OutputStream os = null;
        File source = new File("/home/delete");
        File dest = new File("/home/zhc/delete");
        try {
            Files.copy(source.toPath(), dest.toPath());
            request.setAttribute("message2", "<div class=\"okno\"> Для продолжения перезагрузите оборудование.</div>");
        }catch (Exception ex){
            request.setAttribute("message2", "<div class=\"okno\">Не предвиденная ошибка:"+ex+"</div>");
        }
        request.getRequestDispatcher("/upload.jsp").forward(request, response);
    }
}