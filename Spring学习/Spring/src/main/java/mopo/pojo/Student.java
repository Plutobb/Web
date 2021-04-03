package mopo.pojo;

import lombok.Data;

import java.util.List;
import java.util.Map;
import java.util.Properties;

@Data
public class Student {
    private String name;
    private String[] books;
    private Address address;
    private List<String> list;
    private Map<String,String> map;
    private String wifi;
    private Properties properties;
}
