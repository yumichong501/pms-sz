package pms.sz.task.pmssz.Service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pms.sz.task.pmssz.Entity.Task;
import pms.sz.task.pmssz.Mapper.ITaskMapper;
import pms.sz.task.pmssz.Service.TaskService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    private ITaskMapper iTaskMapper;

    //任务列表
    @Override
    public List getTaskList(Integer type, Integer module_id) {
        Map where = new HashMap();
        where.put("type",type);
        where.put("module_id",module_id);
        List taskList= iTaskMapper.getTaskList(where);
        return setTaskTree(taskList,0);
    }

    //任务详情
    public Task getTask(Integer id)
    {
        Map where = new HashMap();
        where.put("id",id);
        Task taskDetail = iTaskMapper.getTask(where);
        return taskDetail;
    }


    private List setTaskTree(List<Task> list ,Integer parent_id)
    {
        List<Task> returnList = new ArrayList<>();
        for (Task item:list){
            if (item.getParentId() == parent_id){
                item.setChildren(setTaskTree(list,item.getId()));
                returnList.add(item);
            }
        }

        return returnList;
    }
}
