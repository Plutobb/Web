package mopo.pojo.Annotation;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

@Data
public class People {
    @Autowired
    private Dog dog;
    @Autowired
    private Cat cat;
    private String name;
}
