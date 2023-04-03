package pms.sz.task.pmssz.Entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.validator.internal.engine.groups.Group;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Data
public class Task {

    public interface updateGroup {}

    public interface insertGroup{}

    @NotNull(message = "任务id不能为空",groups = updateGroup.class)
    @Min(value = 1,message = "参数异常", groups = updateGroup.class)
    private Integer id;

    @NotNull(message = "任务名称不能为空",groups = insertGroup.class)
    private String taskName;

    @NotNull(message = "模块类型不能为空",groups = insertGroup.class)
    private Integer type;

    @NotNull(message = "模块id不能为空",groups = insertGroup.class)
    @Min(value = 1,message = "模块参数异常",groups = insertGroup.class)
    private Integer moduleId;

    private Integer isMilestone;

    private String taskType;

    private Integer topParentId;

    private Integer parentId;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date scheduleStartTime;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date scheduleEndTime;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date actualStartTime;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date actualEndTime;

    private Integer planTime;

    private Integer status;

    private Integer riskStatus;

    private Integer frontTaskId;

    private BigDecimal amountMoney;

    private BigDecimal actualMoney;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date deletedAt;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime;

    private Integer createBy;

    private String createUser;

    private Integer updateBy;

    private  String updateUser;

    private transient String moduleName;

    private transient String moduleCode;

    private transient String statusText;

    private transient  String statusColor;

    private transient List<Task> children;


}
