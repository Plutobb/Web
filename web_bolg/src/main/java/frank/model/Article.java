package frank.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Setter
@ToString
public class Article {

    private Integer id;
    private String title;
    private String content;
    private Integer userId;
    private Date createTime;
    private String userAccout;

    public void setId(Integer id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public void setUserAccout(String userAccout) {
        this.userAccout = userAccout;
    }

    public Integer getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public Integer getUserId() {
        return userId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public String getUserAccout() {
        return userAccout;
    }
}
