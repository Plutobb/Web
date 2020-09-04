package model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class Customer {
    private int Cnum;
    private String Cname;
    private String Ctel;
    private String Caddr;
    private String Ccom;
}
