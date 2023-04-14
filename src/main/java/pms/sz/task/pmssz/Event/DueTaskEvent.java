package pms.sz.task.pmssz.Event;

import org.springframework.context.ApplicationEvent;

import java.util.List;

public class DueTaskEvent extends ApplicationEvent {

    private List dueTaskList;
    public DueTaskEvent(Object source,List taskList){
        super(source);
        this.dueTaskList = taskList;
    }

    public void sendMsg(List taskList)
    {
        System.out.println("即将到期的任务发送信息,列表为"+taskList);
    }

    public List getDueTaskList()
    {
        return dueTaskList;
    }

    public void setDueTaskList(List taskList)
    {
        this.dueTaskList = taskList;
    }

}
