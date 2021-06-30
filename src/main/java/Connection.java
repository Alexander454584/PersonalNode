import org.json.simple.JSONObject;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Base64;

public class Connection {
    public static String readInputStream(final HttpURLConnection con) {
        try (final BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()))) {
            String inputLine;
            final StringBuilder content = new StringBuilder();
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }
            return content.toString();
        } catch (final Exception ex) {
            ex.printStackTrace();
            return "";
        }
    }
    public static String requsetPost(String link, String text) throws IOException{
        JSONObject cred   = new JSONObject();
        String respone = "";
        final URL url = new URL(link );
        final HttpURLConnection con = (HttpURLConnection) url.openConnection();
        String userpass = "1" + ":" + "1";
        String basicAuth = "Basic " + new String(Base64.getEncoder().encode(userpass.getBytes()));
        con.setRequestMethod("POST");
        con.setRequestProperty ("Authorization", basicAuth);
        con.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
        con.setDoOutput(true);
        final OutputStreamWriter out = new OutputStreamWriter(con.getOutputStream());
            out.write(text);
            out.flush();
        out.close();
        try {
            respone = readInputStream(con);
        }
         catch (Exception ex){
            System.out.println(ex.getMessage());
        }
        con.disconnect();;
        return respone;
    }

    public static String requsetGet(String link, String text) throws IOException{
        JSONObject cred   = new JSONObject();
        String respone = "";
        final URL url = new URL(link );
        final HttpURLConnection con = (HttpURLConnection) url.openConnection();
        String userpass = "1" + ":" + "1";
        String basicAuth = "Basic " + new String(Base64.getEncoder().encode(userpass.getBytes()));
        con.setRequestMethod("GET");
        con.setRequestProperty ("Authorization", basicAuth);
        con.setRequestProperty("Content-Type", "application/json");
        con.setRequestProperty("Content-Encoding", "UTF-8");
        con.setDoOutput(true);
        final OutputStreamWriter out = new OutputStreamWriter(con.getOutputStream());
        out.write(text);
        out.flush();
        out.close();
        try {
            respone = readInputStream(con);
        }
        catch (Exception ex){
            System.out.println(ex.getMessage());
        }
        con.disconnect();;
        return respone;
    }
}



