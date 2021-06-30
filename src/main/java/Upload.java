import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "Upload", value = {"/upload"})
public class Upload extends HttpServlet {
    private final String UPLOAD_DIRECTORY_Wallet = "/root/.zerohour/";
    private final String UPLOAD_DIRECTORY_zerohourd = "/home/zhc/";
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher view = request.getRequestDispatcher("/upload.jsp");
        view.forward(request, response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        if(ServletFileUpload.isMultipartContent(request)){
            try {
                List<FileItem> multiparts = new ServletFileUpload(
                        new DiskFileItemFactory()).parseRequest(request);
                FileItem item = multiparts.get(0);
                    if(!item.isFormField()){
                        String name = new File(item.getName()).getName();
                        if (name.intern().equals("wallet.dat")) {
                            item.write(new File(UPLOAD_DIRECTORY_Wallet + File.separator + name));
                            request.setAttribute("message", "<div class=\"okno\"> Файл "+name+" успешно загружен.</div>");
                        }
                        else{
                            FileItem item1 = multiparts.get(1);
                            String name1 = new File(item1.getName()).getName();
                            if (name1.intern().equals("zerohourd")||name1.intern().equals("zerohour-cli")||name1.intern().equals("zerohour-tx")||
                                    name1.intern().equals("zerohour-wallet")||name1.intern().equals("test_zerohour")) {
                                item1.write(new File(UPLOAD_DIRECTORY_zerohourd + File.separator + name1));
                                request.setAttribute("message", "<div class=\"okno\"> Файл " + name1 + " успешно загружен.</div>");
                            }else
                            request.setAttribute("message", "<div class=\"okno\"> Не правильно выбран файл.</div>");
                        }
                    }
            } catch (Exception ex) {
                request.setAttribute("message", "<div class=\"okno\">Не предвиденная ошибка:"+ex+"</div>");
            }
        }else{
            request.setAttribute("message",
                    "Sorry this Servlet only handles file upload request");
        }
        request.getRequestDispatcher("/upload.jsp").forward(request, response);
    }

    }