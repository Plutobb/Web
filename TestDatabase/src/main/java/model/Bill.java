package model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Setter
@Getter
public class Bill {
    private int Billnum;
    private int Cnum;
    private String Paynum;
    private String PayMethod;
}
