package pms.sz.task.pmssz.Controller;

import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pms.sz.task.pmssz.Service.TaskService;

import java.util.List;

@RestController
@Validated
public class TaskController {
    @Autowired
    private TaskService taskService;

    @GetMapping("/task/getTaskList")
    public List getTaskList(@RequestParam @NotNull(message = "关联类型异常") Integer type,
                            @NotNull(message = "关联id不能为空") Integer moduleId)
    {
        List taskList = taskService.getTaskList(type,moduleId);
        return taskList;
    }
}
