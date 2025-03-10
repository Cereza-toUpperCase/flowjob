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

package org.limbo.flowjob.broker.core.repository;

import org.limbo.flowjob.broker.core.domain.task.Task;

import java.util.List;

/**
 * @author Brozen
 * @since 2021-05-19
 */
public interface TaskRepository {

    /**
     * 持久化任务
     * @param task 任务
     */
    String save(Task task);

    /**
     * 持久化任务
     * @param tasks 任务
     */
    void saveAll(List<Task> tasks);

    /**
     * 获取作业执行实例
     */
    Task get(String taskId);

}
