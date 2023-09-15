package njust.controller;

import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import njust.pojo.Task;
import njust.pojo.User;
import njust.service.TaskService;
import njust.utils.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping
@Slf4j
public class TaskController {
    @Autowired
    private TaskService taskService;

    @RequestMapping("allTask/{pageSize}/{currentPage}")
    public String allTask(@PathVariable(name = "pageSize") int pageSize,
                          @PathVariable(name = "currentPage") int currentPage,
                          HttpSession session){
        PageBean<Task> pageBean = taskService.getAllTaskByPage(pageSize,currentPage);
        session.setAttribute("pageBean",pageBean);
        return "allTask";
    }

    @RequestMapping("newTask")
    public String newTask(Task task, HttpSession session){
        User user = (User)session.getAttribute("nowuser");
        taskService.newTask(task.addInfo(user));
        return "redirect:/allTask/5/1";
    }
}
