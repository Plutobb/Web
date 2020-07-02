import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Policeman {
    private int police_number;
    private String name;
    private double salary;
    private String time;
    private int service_years;
    public Policeman(int police_number, String name, double salary, String time) throws ParseException {
        this.police_number = police_number;
        this.name = name;
        this.salary = salary;
        this.time = time;
        //计算出服务日期;
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date d1 = sdf.parse(time);
        this.service_years = (int) ((date.getTime() - d1.getTime())/(24*60*60*1000)/365);
    }
//访问方法;
    public int getPolice_number() {
        return police_number;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public String getTime() {
        return time;
    }

    public int getService_years() {
        return service_years;
    }

    //修改方法;
    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void setTime(String time) {
        this.time = time;
    }
//重写toString;
    @Override
    public String toString() {
        return "Policeman{" +
                "police_number=" + police_number +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                ", service=" + service_years +
                '}';
    }
    interface Employee{
         public void Raise (int n);
    }

}

