package njust.mapper;

import njust.pojo.Task;
import java.util.List;

public interface TaskMapper {
    List<Task> selectAllTaskByPage();
    int insertTask(Task task);
}
