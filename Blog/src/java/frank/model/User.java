package frank.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class User {
    private String userName;
    private String passWord;

    public User(String userName,String passWord) {
        this.userName = userName;
        this.passWord = passWord;
    }
}
