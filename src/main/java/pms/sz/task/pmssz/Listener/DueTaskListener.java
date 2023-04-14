package pms.sz.task.pmssz.Listener;

import jakarta.servlet.ServletContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import pms.sz.task.pmssz.Event.DueTaskEvent;
import pms.sz.task.pmssz.Service.Impl.TaskServiceImpl;

import java.util.List;

@Component
public class DueTaskListener implements ApplicationListener<DueTaskEvent> {

    @Override
    public void onApplicationEvent(DueTaskEvent dueTaskEvent)
    {
        dueTaskEvent.sendMsg(dueTaskEvent.getDueTaskList());
    }
}
