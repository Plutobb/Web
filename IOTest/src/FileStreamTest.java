import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileStreamTest {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = null;
        FileOutputStream fos = null;
        fis = new FileInputStream("C:\\Users\\Mopo\\Pictures\\Saved Pictures\\QQ图片20200621191404.jpg");
        fos = new FileOutputStream("E:\\QQ图片20200621191404.jpg");
        byte[] bytes = new byte[1024 * 1024];
        int len = 0;
        while ((len = fis.read(bytes)) != -1){
            fos.write(bytes,0,len);
            fos.flush();
        }

        if (fis != null) {
            fis.close();
        }

        if (fos == null) {
            fos.close();
        }

    }
}
