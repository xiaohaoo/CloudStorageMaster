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

import java.io.InputStream;

/**
 * @author xiaohao
 * @version 1.0
 * @date 2022/1/23 1:55 PM
 */
public interface CloudStorage {
    /**
     * 上传接口
     *
     * @param bucketName  bucket名字
     * @param objectName  文件路径+文件名
     * @param inputStream 文件输入流
     * @return 存储地址
     */
    default String upload(String bucketName, String objectName, InputStream inputStream) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * 判断文件是否存在
     *
     * @param bucketName bucket名字
     * @param objectName 文件路径+文件名
     * @return 是否存在
     */
    default boolean isExist(String bucketName, String objectName) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    default boolean delete(String bucketName, String objectName) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
