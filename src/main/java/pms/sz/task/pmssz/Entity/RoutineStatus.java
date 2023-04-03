package pms.sz.task.pmssz.Entity;

import lombok.Data;

@Data
public class RoutineStatus {

    private Integer id;

    private String routineStatusName;

    private Integer parentId;

    private String statusType;

    private String remark;

    private Integer isAttribution;

    private Integer attributionId;

    private String color;

    private Integer module;

    private Integer moduleTaskType;

    private Integer deletable;

}
