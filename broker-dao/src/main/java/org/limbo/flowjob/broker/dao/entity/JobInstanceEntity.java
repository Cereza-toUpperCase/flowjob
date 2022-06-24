package org.limbo.flowjob.broker.dao.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDateTime;

/**
 * job的一次执行 对应于PlanRecord
 *
 * @author Devil
 * @since 2021/9/1
 */
@Setter
@Getter
@Table(name = "flowjob_job_instance")
@Entity
@DynamicInsert
@DynamicUpdate
public class JobInstanceEntity extends BaseEntity {
    private static final long serialVersionUID = -1136312243146520057L;

    private String planInstanceId;

    private String jobInfoId;

    /**
     * 状态
     */
    private Byte state;

    /**
     * 此次执行的参数
     */
    private String attributes;

    /**
     * 开始时间
     */
    private LocalDateTime startAt;

    /**
     * 结束时间
     */
    private LocalDateTime endAt;
}
