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

package org.limbo.flowjob.broker.core.plan.job;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;
import org.limbo.flowjob.broker.api.constants.enums.LoadBalanceType;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 作业分发配置，值对象
 *
 * @author Brozen
 * @since 2021-06-01
 */
@Data
@Setter(AccessLevel.NONE)
public class DispatchOption implements Serializable {

    private static final long serialVersionUID = 7742829408764721529L;
    /**
     * 作业分发方式
     */
    private LoadBalanceType loadBalanceType;

    /**
     * 作业重试次数
     */
    private final Integer retry;

    /**
     * 所需的CPU核心数，小于等于0表示此作业未定义CPU需求。在分发作业时，会根据此方法返回的CPU核心需求数量来检测一个worker是否有能力执行此作业。
     */
    private BigDecimal cpuRequirement;

    /**
     * 所需的内存GB数，小于等于0表示此作业未定义内存需求。在分发作业时，会根据此方法返回的内存需求数量来检测一个worker是否有能力执行此作业。
     */
    private BigDecimal ramRequirement;

    @JsonCreator // @JsonProperty("scheduleType") 不去掉mapstruct会用set方式，比较奇怪
    public DispatchOption(LoadBalanceType loadBalanceType,
                          BigDecimal cpuRequirement,
                          BigDecimal ramRequirement,
                          Integer retry) {
        this.loadBalanceType = loadBalanceType;
        this.cpuRequirement = cpuRequirement == null ? BigDecimal.ZERO : cpuRequirement;
        this.ramRequirement = ramRequirement == null ? BigDecimal.ZERO : ramRequirement;
        this.retry = retry == null ? 0 : retry;
    }

    /**
     * 设置分发方式
     */
    public DispatchOption setLoadBalanceType(LoadBalanceType loadBalanceType) {
        return new DispatchOption(loadBalanceType, cpuRequirement, ramRequirement, retry);
    }


    /**
     * 设置所需cpu核心数
     */
    public DispatchOption setCpuRequirement(BigDecimal cpuRequirement) {
        return new DispatchOption(loadBalanceType, cpuRequirement, ramRequirement, retry);
    }


    /**
     * 设置所需的内存GB数
     */
    public DispatchOption setRamRequirement(BigDecimal ramRequirement) {
        return new DispatchOption(loadBalanceType, cpuRequirement, ramRequirement, retry);
    }

}
