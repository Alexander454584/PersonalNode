
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
;import java.io.IOException;
import java.nio.charset.StandardCharsets;

@WebServlet(name = "ListAddressServlet", value = {"/list"})
public class listaddress extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String respone4 = Connection.requsetPost("http://127.0.0.1:7227/", "{\"jsonrpc\": \"1.0\",\"id\": \"apis-core\",\"method\": \"listaddressgroupings\",\"params\": []}");
        JsonElement root4 = new JsonParser().parse(respone4);
        JsonArray l9 = root4.getAsJsonObject().get("result").getAsJsonArray();
        String str3 ="" ;
        for (int i = 1; i<=l9.get(0).getAsJsonArray().size(); i++){
            str3+="адрес: "+l9.get(0).getAsJsonArray().get(i-1).getAsJsonArray().get(0).getAsString()+"<br> баланс: "+l9.get(0).getAsJsonArray().get(i-1).getAsJsonArray().get(1)+"<br>";
        }
        request.setAttribute("l9", str3);
        page page = new page();
        page.Page(request, response);
    }
}