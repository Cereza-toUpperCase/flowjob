/*
 *
 *  * Copyright 2020-2024 Limbo Team (https://github.com/limbo-world).
 *  *
 *  * Licensed under the Apache License, Version 2.0 (the "License");
 *  * you may not use this file except in compliance with the License.
 *  * You may obtain a copy of the License at
 *  *
 *  * 	http://www.apache.org/licenses/LICENSE-2.0
 *  *
 *  * Unless required by applicable law or agreed to in writing, software
 *  * distributed under the License is distributed on an "AS IS" BASIS,
 *  * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  * See the License for the specific language governing permissions and
 *  * limitations under the License.
 *
 */

package org.limbo.flowjob.common.constants;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * 作业执行结果
 *
 * @author Brozen
 * @since 2021-07-07
 */
public enum ExecuteResult {

    UNKNOWN(0, "异常"),

    SUCCEED(1, "执行成功"),

    FAILED(2, "执行异常"),

    TERMINATED(3, "作业被手动终止"),

    ;

    /**
     * 执行结果枚举值
     */
    @JsonValue
    public final byte result;

    /**
     * 枚举描述
     */
    public final String desc;

    ExecuteResult(int result, String desc) {
        this(((byte) result), desc);
    }

    ExecuteResult(byte result, String desc) {
        this.result = result;
        this.desc = desc;
    }


    /**
     * 校验是否当前结果
     * @param result 待校验值
     */
    public boolean is(Number result) {
        return result != null && result.byteValue() == this.result;
    }


    /**
     * 解析作业执行结果
     * @param result 待解析值
     * @return 解析失败返回null
     */
    @JsonCreator
    public static ExecuteResult parse(Number result) {
        for (ExecuteResult _result : values()) {
            if (_result.is(result)) {
                return _result;
            }
        }
        return UNKNOWN;
    }

}
