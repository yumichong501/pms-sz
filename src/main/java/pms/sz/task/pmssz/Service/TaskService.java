package pms.sz.task.pmssz.Service;

import pms.sz.task.pmssz.Entity.Task;

import java.util.List;
import java.util.Map;

public interface TaskService {

    public List getTaskList(Integer type, Integer module_id);

    public Task getTask(Integer id);
}
