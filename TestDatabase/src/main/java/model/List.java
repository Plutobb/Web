package model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class List {
    private int Listnum;
    private int Billnum;
    private int Goodnum;
    private int Cnum;
    private String PayMethod;
    private String Cname;
    private String Goodname;
    private String BugGoodNum;
}
