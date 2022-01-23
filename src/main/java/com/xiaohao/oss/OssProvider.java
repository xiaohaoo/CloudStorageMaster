package com.xiaohao.oss;

import java.io.InputStream;

/**
 * @author xiaohao
 * @version 1.0
 * @date 2022/1/23 1:55 PM
 */
public interface OssProvider {
    /**
     * 上传接口
     *
     * @param bucketName  文件夹
     * @param key         文件名称
     * @param inputStream 上传文件
     * @return 上传后的地址
     */
    String upload(String bucketName, String key, InputStream inputStream);

    /**
     * 判断文件是否存在
     *
     * @param bucketName 文件夹
     * @param key        文件名称
     * @return 是否存在
     */
    boolean isExist(String bucketName, String key);

}
