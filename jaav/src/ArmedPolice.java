import java.text.ParseException;

public class ArmedPolice extends Policeman implements Policeman.Employee {
    private String armyBelongs;
    private String rank;

    public ArmedPolice(int police_number, String name, double salary, String time, String armyBelongs, String rank) throws ParseException {
        super(police_number, name, salary, time);
        this.armyBelongs = armyBelongs;
        this.rank = rank;
    }

    @Override
    public void Raise(int n) {
        double endSalary = super.getSalary();
        for (int i = 0; i < n / 2; i++) {
            endSalary = endSalary * 1.3;
        }
        setSalary(endSalary);
    }

    @Override
    public String toString() {
        return "ArmedPolice{"+
                "police_number='" + super.getPolice_number() + '\'' +
                ", name='" + super.getName() + '\'' +
                ", salary='" + super.getSalary() +'\'' +
                ", years of service='" + super.getService_years() + '\'' +
                ", armyBelongs='" + armyBelongs + '\'' +
                ", rank='" + rank + '\'' +
                '}';
    }

    public static void main(String[] args) throws ParseException {
        ArmedPolice ap = new ArmedPolice(10034,"成龙",3000,"2004-04-01","武警第七旅","第三警察主管");
        System.out.println(ap.toString());
        ap.Raise(ap.getService_years());
        System.out.println(ap.toString());
    }
}
