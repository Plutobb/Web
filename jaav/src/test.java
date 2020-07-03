import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class test {
    private Date time;
    public static void main(String[] args) throws ParseException {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String start = "2004-04-01";
        String end = sdf.format(date.getTime());
        Date d1 = sdf.parse(start);
        Date d2 = sdf.parse(end);
        System.out.println(start);
        System.out.println(end);
        System.out.println(d1.getTime());
        System.out.println(d2.getTime());
        System.out.println(d2.getTime()-d1.getTime());
        System.out.println((d2.getTime()-d1.getTime())/(24*60*60*1000)/365);
    }
}
