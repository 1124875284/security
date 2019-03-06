package com.hzq.dto;

import com.fasterxml.jackson.annotation.JsonView;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Past;
import java.util.Date;

public class User {

    public interface UserSimpleView {};
    public interface UserDetailView extends UserSimpleView {}

    private String username;

    @NotBlank(message = "密码不能为空")
    private String password;

    @Past(message = "生日不能为将来的时间")
    private Date birthday;

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    @JsonView(UserSimpleView.class)
    public String getUsername() {
        return username;
    }
    @JsonView(UserDetailView.class)
    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
