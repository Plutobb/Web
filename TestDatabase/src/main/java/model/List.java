package model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter

public class List {
    private int Listnum;
    private int Billnum;
    private String Cname;
    private String Goodname;
    private int Goodprice;
    private int BuyNum;
    private String PayMethod;
    private int Total;


    @Override
    public String toString() {
        return "List{" +
                "Listnum=" + Listnum +
                ", Billnum=" + Billnum +
                ", Cname='" + Cname + '\'' +
                ", Goodname='" + Goodname + '\'' +
                ", Goodprice=" + Goodprice +
                ", BuyNum=" + BuyNum +
                ", PayMethod='" + PayMethod + '\'' +
                ", Total=" + Total +
                '}';
    }
}
