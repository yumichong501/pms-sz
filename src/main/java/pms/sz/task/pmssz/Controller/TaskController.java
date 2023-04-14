package pms.sz.task.pmssz.Controller;

import jakarta.annotation.Resource;
import jakarta.servlet.*;
import jakarta.servlet.descriptor.JspConfigDescriptor;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pms.sz.task.pmssz.Entity.Task;
import pms.sz.task.pmssz.Event.DueTaskEvent;
import pms.sz.task.pmssz.Exception.JsonResponseInfo;
import pms.sz.task.pmssz.Service.TaskService;
import pms.sz.task.pmssz.Utils.ResponseUtils;

import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;

@RestController
@Validated
public class TaskController {
    @Autowired
    private TaskService taskService;

    @Resource
    private ApplicationContext applicationContext;

    @GetMapping("/task/getTaskList")
    public JsonResponseInfo getTaskList(@RequestParam @NotNull(message = "关联类型异常") Integer type,
                                        @NotNull(message = "关联id不能为空") Integer moduleId)
    {
        List taskList = taskService.getTaskList(type,moduleId);
        return ResponseUtils.success(taskList);
    }

    @GetMapping("/task/getTask")
    public JsonResponseInfo getTask(@RequestParam @NotNull(message = "参数异常") Integer id)
    {
        Task taskDetail = taskService.getTask(id);
        return ResponseUtils.success(taskDetail);
    }

    @GetMapping("/task/noticeTaskDue")
    public void noticeTaskDue(HttpServletRequest request){
        //取出3天到期的任务列表
        List taskDueList = taskService.getDueTaskList(3);

        applicationContext.publishEvent(new DueTaskEvent(this,taskDueList));
    }
}
