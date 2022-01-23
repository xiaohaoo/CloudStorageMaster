/*
 * Copyright (c) 2022 xiaohao
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 *  You should have received a copy of the GNU Affero General Public License
 *  along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */

package com.xiaohao.oss;

import com.xiaohao.oss.providers.AlibabaOssProvider;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @author xiaohao
 */
@Accessors(chain = true)
@Getter
@NoArgsConstructor
public class OssProviderBuilder {
    private String accessKeyId;
    private String accessKeySecret;
    private String endPoint;

    public OssProviderBuilder(String accessKeyId, String accessKeySecret, String endPoint) {
        this.accessKeyId = accessKeyId;
        this.accessKeySecret = accessKeySecret;
        this.endPoint = endPoint.replaceAll("http[s]?://", "");
    }

    public static OssProviderBuilder builder() {
        return new OssProviderBuilder();
    }

    public OssProviderBuilder accessKeyId(String accessKeyId) {
        this.accessKeyId = accessKeyId;
        return this;
    }

    public OssProviderBuilder accessKeySecret(String accessKeySecret) {
        this.accessKeySecret = accessKeySecret;
        return this;
    }

    public OssProviderBuilder endPoint(String endPoint) {
        this.endPoint = endPoint;
        return this;
    }

    public OssProvider build(ProviderOption option) {
        if (ProviderOption.ALIBABA.equals(option)) {
            return new AlibabaOssProvider(this);
        }
        return new AlibabaOssProvider(this);
    }

    public OssProvider build() {
        return build(ProviderOption.ALIBABA);
    }

    public enum ProviderOption {
        ALIBABA,
    }


}