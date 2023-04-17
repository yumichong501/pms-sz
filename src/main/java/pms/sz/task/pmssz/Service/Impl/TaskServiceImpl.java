package pms.sz.task.pmssz.Service.Impl;

import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationEvent;
import org.springframework.stereotype.Service;
import pms.sz.task.pmssz.Entity.Task;
import pms.sz.task.pmssz.Mapper.ITaskMapper;
import pms.sz.task.pmssz.Service.TaskService;

import java.text.SimpleDateFormat;
import java.util.*;

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

    public List getPlanList(Integer type, Integer module_id) {
        Map where = new HashMap();
        where.put("type",type);
        where.put("module_id",module_id);
        where.put("parent_id",0);
        List taskList= iTaskMapper.getTaskList(where);
        return taskList;
    }


    //获取临期任务
    public List getDueTaskList(Integer day)
    {
        //计算需要提醒的日期
        Date threeDaysAgo = new Date(new Date().getTime()+day*24*3600*1000);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String threeDays = sdf.format(threeDaysAgo);

        Map where = new HashMap();
        where.put("schedule_end_time",threeDays);
        List threeDueTask = iTaskMapper.getDueTaskList(where);
        return threeDueTask;
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
