import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class URLTest {
    public static void main(String[] args) throws Exception {
        URL url = new java.net.URL("https://m10.music.126.net/20201119211044/c9c2cb3b7337ea28d2195306755ae783/yyaac/obj/wonDkMOGw6XDiTHCmMOi/4110449541/a8fb/f595/6168/15da44f1938939ee86835ecc4cfb4f5b.m4a");
        HttpURLConnection content =(HttpURLConnection) url.openConnection();
        InputStream is = content.getInputStream();
        FileOutputStream fos = new FileOutputStream("会不会.m4a");
        byte[] buffer = new byte[1024];
        int len;
        while ((len = is.read(buffer)) != -1) {
            fos.write(buffer,0,len);
        }
        fos.close();
        is.close();
        content.disconnect();
    }
}
