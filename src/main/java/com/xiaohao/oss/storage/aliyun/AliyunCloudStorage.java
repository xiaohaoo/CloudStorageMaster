/*
 * Copyright (c) 2022-2023 xiaohao
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

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.model.PutObjectRequest;
import com.aliyuncs.utils.IOUtils;
import com.xiaohao.oss.CloudStorage;

import java.io.InputStream;

/**
 * @author xiaohao
 * @version 1.0
 * @date 2022-01-23  1:44 AM
 */
public class AliyunCloudStorage implements CloudStorage {

    private final String endpoint;

    private final OSS ossClient;

    protected AliyunCloudStorage(String accessKeyId, String accessKeySecret, String endpoint) {
        assert accessKeyId != null;
        assert accessKeySecret != null;
        assert endpoint != null;
        this.endpoint = endpoint.replaceAll("http[s]?://", "");
        this.ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);
    }

    /**
     * 上传文件
     *
     * @param bucketName  存储桶
     * @param objectName  文件路径
     * @param inputStream 输入流
     * @return 文件Http访问地址
     */
    @Override
    public String upload(String bucketName, String objectName, InputStream inputStream) {
        try {
            PutObjectRequest putObjectRequest = new PutObjectRequest(bucketName, objectName, inputStream);
            ossClient.putObject(putObjectRequest);
            return String.format("https://%s.%s/%s", bucketName, endpoint, objectName);
        } finally {
            IOUtils.closeQuietly(inputStream);
        }
    }

    /**
     * 判断文件是否存在
     *
     * @param bucketName 存储桶
     * @param objectName 文件路径
     * @return 是否存在
     */
    @Override
    public boolean isExist(String bucketName, String objectName) {
        return ossClient.doesObjectExist(bucketName, objectName);
    }
}
