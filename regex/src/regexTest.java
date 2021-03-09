import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class regexTest {

    public static void main(String[] args) throws IOException {
        String str = "12s+";
        Pattern pattern = Pattern.compile("\\d{2}\\w\\W");
        Matcher matcher = pattern.matcher(str);
        System.out.println(matcher.matches());
    }
}
