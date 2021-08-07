import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;

@WebServlet(name = "copyreboot", value = {"/copyreboot"})
public class CopyReboot extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        final String pathInfo = request.getPathInfo();
        InputStream is = null;
        OutputStream os = null;
        File source = new File("/home/reboot.sh");
        File dest = new File("/home/zhc/reboot.sh");
        try {
            Files.copy(source.toPath(), dest.toPath());
            request.setAttribute("message3", "<div class=\"okno\"> Происходит остановка служб и перезапуск оборудования. Это займет некоторое время. Обновите страницу через несколько минут.</div>");
        }catch (Exception ex){
            request.setAttribute("message3", "<div class=\"okno\">Оборудование перезагружается. Обновите страницу через несколько минут.</div>");
        }
        request.getRequestDispatcher("/upload.jsp").forward(request, response);
    }
}