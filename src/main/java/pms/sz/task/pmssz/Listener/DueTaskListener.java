package pms.sz.task.pmssz.Listener;

import jakarta.servlet.ServletContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import pms.sz.task.pmssz.Service.Impl.TaskServiceImpl;

import java.util.List;

public class DueTaskListener implements ApplicationListener<ContextRefreshedEvent> {

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent)
    {
        //上下文
        ApplicationContext applicationContext = contextRefreshedEvent.getApplicationContext();
        TaskServiceImpl taskService = applicationContext.getBean(TaskServiceImpl.class);

        //取出3天到期的任务列表
        List taskDueList = taskService.getDueTaskList(3);

        ServletContext servletContext = applicationContext.getBean(ServletContext.class);
        servletContext.setAttribute("taskDueList",taskDueList);
    }
}
