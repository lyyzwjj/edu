package cn.wolfcode.edu.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
@Setter
@Getter
public class Sign {
    public static final Integer SIGN_IN_NORMAL = 0;
    public static final Integer SIGN_IN_Error = 1;
    public static final Integer SIGN_OUT_NORMAL = 0;
    public static final Integer SIGN_OUT_Error = 1;
    private Long id;

    private Employee employee;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date signIn;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date signOut;

    private Integer signInState ;

    private Integer signOutState ;

}