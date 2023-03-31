package pms.sz.task.pmssz.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import pms.sz.task.pmssz.Entity.Task;

@Mapper
public interface ITaskMapper extends BaseMapper<Task> {
}
