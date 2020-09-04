package model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Setter
@Getter
public class Bill {
    private int Billnum;
    private String Cname;
    private int ListNum;
    private String PayMethod;
}
