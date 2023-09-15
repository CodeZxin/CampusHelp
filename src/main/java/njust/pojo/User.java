package njust.pojo;

import lombok.Data;

@Data
public class User {
    private Integer stuId;
    private String stuNumber;
    private String password;
    private String name;
    private Double money;
    private Integer state=0;
}