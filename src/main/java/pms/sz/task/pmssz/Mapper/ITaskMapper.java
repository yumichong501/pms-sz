package pms.sz.task.pmssz.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import pms.sz.task.pmssz.Entity.Task;

import java.util.List;
import java.util.Map;

@Mapper
public interface ITaskMapper extends BaseMapper<Task> {

    public List getTaskList(Map query);

    public Task getTask(Map query);

    public List getDueTaskList(Map query);

    public List getMilestoneByPlanId(Map query);
}
