/*
 * Copyright (c) 2023 xiaohao
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

package com.xiaohao.oss.storage.aliyun;

import com.xiaohao.oss.CloudStorage;
import com.xiaohao.oss.CloudStorageFactory;

public class AliyunCloudStorageFactory implements CloudStorageFactory {


    private final String accessKeyId;
    private final String accessKeySecret;
    private final String endpoint;

    public AliyunCloudStorageFactory(String accessKeyId, String accessKeySecret, String endpoint) {
        assert accessKeyId != null;
        assert accessKeySecret != null;
        assert endpoint != null;
        this.accessKeyId = accessKeyId;
        this.accessKeySecret = accessKeySecret;
        this.endpoint = endpoint;
    }

    @Override
    public CloudStorage create() {
        return new AliyunCloudStorage(accessKeyId, accessKeySecret, endpoint);
    }
}