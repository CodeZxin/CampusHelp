package njust.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import njust.mapper.TaskMapper;
import njust.pojo.Task;
import njust.utils.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class TaskService {
    @Autowired
    private TaskMapper taskMapper;
    public PageBean<Task> getAllTaskByPage(int pageSize, int currentPage){
        PageHelper.startPage(currentPage,pageSize);
        List<Task> list = taskMapper.selectAllTaskByPage();
        PageInfo<Task> pageInfo = new PageInfo<>(list);
        PageBean<Task> pageBean = new PageBean<>(pageInfo.getPageNum(), pageInfo.getPageSize(), pageInfo.getTotal(), pageInfo.getList());
        return pageBean;
    }

    public void newTask(Task task){
        taskMapper.insertTask(task);
    }
}
