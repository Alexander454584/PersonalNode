
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
;import java.io.IOException;

@WebServlet(name = "SendPass", value = {"/sendpass"})
public class SendPass extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String pass = request.getParameter("pass");
        String respone = Connection.requsetPost("http://127.0.0.1:7227/", "{\"jsonrpc\": \"1.0\",\"id\": \"apis-core\",\"method\": \"walletpassphrase\",\"params\": [\""+pass+"\", 999999, true]}");
        System.out.println(respone);
        JsonElement root = new JsonParser().parse(respone);
        if (!root.isJsonNull()) {
            String respone1 = Connection.requsetPost("http://127.0.0.1:7227/", "{\"jsonrpc\": \"1.0\",\"id\": \"apis-core\",\"method\": \"getwalletinfo\",\"params\": []}");
            String respone2 = Connection.requsetPost("http://127.0.0.1:7227/", "{\"jsonrpc\": \"1.0\",\"id\": \"apis-core\",\"method\": \"getmininginfo\",\"params\": []}");
            String respone3 = Connection.requsetPost("http://127.0.0.1:7227/", "{\"jsonrpc\": \"1.0\",\"id\": \"apis-core\",\"method\": \"getstakinginfo\",\"params\": []}");
            JsonElement root1 = new JsonParser().parse(respone1);
            JsonElement root2 = new JsonParser().parse(respone2);
            JsonElement root3 = new JsonParser().parse(respone3);
            String l1 = root1.getAsJsonObject().get("result").getAsJsonObject().get("balance").getAsString();
            String l2 = root1.getAsJsonObject().get("result").getAsJsonObject().get("walletversion").getAsString();
            String l3 = root1.getAsJsonObject().get("result").getAsJsonObject().get("stake").getAsString();
            String l4 = root2.getAsJsonObject().get("result").getAsJsonObject().get("blocks").getAsString();
            String l5, l6;
            String l7 = root3.getAsJsonObject().get("result").getAsJsonObject().get("weight").getAsString();
            String l8 = root3.getAsJsonObject().get("result").getAsJsonObject().get("netstakeweight").getAsString();
            if (root3.getAsJsonObject().get("result").getAsJsonObject().get("enabled").getAsString() == "true") {
                request.setAttribute("color1", "#00ff00");
                l5 = "??????????????";
            } else {
                request.setAttribute("color1", "#ff0000");
                l5 = "????????????????";
            }
            if (root3.getAsJsonObject().get("result").getAsJsonObject().get("staking").getAsString() == "true") {
                request.setAttribute("color2", "#00ff00");
                l6 = "????????????????";
            } else {
                request.setAttribute("color2", "#ff0000");
                l6 = "???????? ???????????????????????? ?????????????? ????????????";
            }
            String str1 = "";
            String str2 = "";
            for (int i = 1; i <= l7.length() - 8; i++) {
                str1 += l7.charAt(i - 1);
            }
            for (int i = 1; i <= l8.length() - 8; i++) {
                str2 += l8.charAt(i - 1);
            }
            if (str1 == "")
                str1 = "0";
            if (str2 == "")
                str2 = "0";
            RequestDispatcher view = request.getRequestDispatcher("/index.jsp");
            request.setAttribute("l1", l1);
            request.setAttribute("l2", l2);
            request.setAttribute("l3", l3);
            request.setAttribute("l4", l4);
            request.setAttribute("l5", l5);
            request.setAttribute("l6", l6);
            request.setAttribute("l7", str1);
            request.setAttribute("l8", str2);
            request.setAttribute("l10", "<font color=\"#00ff00\">???????????? ???????????? ??????????, ???????????????????? ???????????????????? ?????????? ???????????? </font><br>");
            view.forward(request, response);
        } else {
            String respone1 = Connection.requsetPost("http://127.0.0.1:7227/", "{\"jsonrpc\": \"1.0\",\"id\": \"apis-core\",\"method\": \"getwalletinfo\",\"params\": []}");
            String respone2 = Connection.requsetPost("http://127.0.0.1:7227/", "{\"jsonrpc\": \"1.0\",\"id\": \"apis-core\",\"method\": \"getmininginfo\",\"params\": []}");
            String respone3 = Connection.requsetPost("http://127.0.0.1:7227/", "{\"jsonrpc\": \"1.0\",\"id\": \"apis-core\",\"method\": \"getstakinginfo\",\"params\": []}");
            JsonElement root1 = new JsonParser().parse(respone1);
            JsonElement root2 = new JsonParser().parse(respone2);
            JsonElement root3 = new JsonParser().parse(respone3);
            String l1 = root1.getAsJsonObject().get("result").getAsJsonObject().get("balance").getAsString();
            String l2 = root1.getAsJsonObject().get("result").getAsJsonObject().get("walletversion").getAsString();
            String l3 = root1.getAsJsonObject().get("result").getAsJsonObject().get("stake").getAsString();
            String l4 = root2.getAsJsonObject().get("result").getAsJsonObject().get("blocks").getAsString();
            String l5, l6;
            String l7 = root3.getAsJsonObject().get("result").getAsJsonObject().get("weight").getAsString();
            String l8 = root3.getAsJsonObject().get("result").getAsJsonObject().get("netstakeweight").getAsString();
            if (root3.getAsJsonObject().get("result").getAsJsonObject().get("enabled").getAsString() == "true") {
                request.setAttribute("color1", "#00ff00");
                l5 = "??????????????";
            } else {
                request.setAttribute("color1", "#ff0000");
                l5 = "????????????????";
            }
            if (root3.getAsJsonObject().get("result").getAsJsonObject().get("staking").getAsString() == "true") {
                request.setAttribute("color2", "#00ff00");
                l6 = "????????????????";
            } else {
                request.setAttribute("color2", "#ff0000");
                l6 = "???????? ???????????????????????? ?????????????? ????????????";
            }
            String str1 = "";
            String str2 = "";
            for (int i = 1; i <= l7.length() - 8; i++) {
                str1 += l7.charAt(i - 1);
            }
            for (int i = 1; i <= l8.length() - 8; i++) {
                str2 += l8.charAt(i - 1);
            }
            if (str1 == "")
                str1 = "0";
            if (str2 == "")
                str2 = "0";
            RequestDispatcher view = request.getRequestDispatcher("/index.jsp");
            request.setAttribute("l1", l1);
            request.setAttribute("l2", l2);
            request.setAttribute("l3", l3);
            request.setAttribute("l4", l4);
            request.setAttribute("l5", l5);
            request.setAttribute("l6", l6);
            request.setAttribute("l7", str1);
            request.setAttribute("l8", str2);
            request.setAttribute("l10", "<form method = \"post\" action = \"sendpass\"> " +
                            "<font style=\"margin-left: 30px\" color=\"#ff0000\">???????????? ???????????? ???? ??????????, ?????????????????? ??????????????</font> <br>" +
                    "<input type=\"password\" name=\"pass\" id=\"pass\" style=\"color: #02021d; margin-left: 30px\">  " +
                    "<button type=\"submit\" style=\"color: #110e0e\">?????????????????? ????????????</button></form>");
            view.forward(request, response);
        }
    }
}