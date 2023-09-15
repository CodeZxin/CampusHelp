package njust.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Task {
    private Integer taskId;
    private String taskName;
    private String taskContext;
    private Double reward;
    private String publishId;
    private String publishName;
    private Integer acceptId;
    private Date addTime;
    private Date endTime;
    private Integer state;

    public Task addInfo(User user){
        this.publishId=user.getStuId().toString();
        this.publishName= user.getName();
        this.addTime=new Date();
        return this;
    }
}
