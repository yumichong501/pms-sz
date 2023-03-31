package pms.sz.task.pmssz.Service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pms.sz.task.pmssz.Mapper.ITaskMapper;
import pms.sz.task.pmssz.Service.TaskService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    private ITaskMapper iTaskMapper;

    @Override
    public List getTaskList(Integer type, Integer module_id) {
        Map where = new HashMap();
        where.put("type",type);
        where.put("module_id",module_id);
        return iTaskMapper.selectByMap(where);
    }
}
