/*
 * Copyright 2020-2024 Limbo Team (https://github.com/limbo-world).
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * 	http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.limbo.flowjob.broker.dao.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.limbo.flowjob.common.constants.ScheduleType;
import org.limbo.flowjob.common.constants.TriggerType;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

/**
 * plan 的信息存档 历史版本
 *
 * @author Brozen
 * @since 2021-07-13
 */
@Setter
@Getter
@Table(name = "flowjob_plan_info")
@Entity
@DynamicInsert
@DynamicUpdate
public class PlanInfoEntity extends BaseEntity {

    private static final long serialVersionUID = -1639602897831847418L;

    /**
     * 数据库自增id
     */
    @Column(updatable = false)
    private Long id;

    @Id
    private String planInfoId;

    /**
     * 属于哪个plan
     */
    private String planId;

    /**
     * 版本
     */
    private Integer planVersion;

    /**
     * 执行计划描述
     */
    private String description;

    /**
     * 计划作业调度方式
     * @see ScheduleType
     */
    private Byte scheduleType;

    /**
     * 计划作业调度方式
     * @see TriggerType
     */
    private Byte triggerType;

    /**
     * 从何时开始调度作业
     */
    private LocalDateTime scheduleStartAt;

    /**
     * 作业调度延迟时间，单位秒
     */
    private Long scheduleDelay;

    /**
     * 作业调度间隔时间，单位秒。
     */
    private Long scheduleInterval;

    /**
     * 作业调度的CRON表达式
     */
    private String scheduleCron;

    /**
     * 作业调度的CRON表达式
     */
    private String scheduleCronType;

    /**
     * 重试次数 超过执行就失败
     * job上的这个版本不设计了，用户本来就需要做幂等处理
     */
    private Integer retry;

    /**
     * 任务 json string
     */
    private String jobs;

    @Override
    public Object getUid() {
        return planInfoId;
    }
}
