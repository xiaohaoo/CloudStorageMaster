package com.xiaohao.oss;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.model.PutObjectRequest;

import java.io.InputStream;

public class OSSUtil {
    private static String ACCESS_KEY_ID = "";
    private static String ACCESS_KEY_SECRET = "";
    private static String END_POINT = "";
    private static String END_POINT_PARSE = "";


    /**
     * 只需初始化一次
     *
     * @param accessKeyId     key
     * @param accessKeySecret secret
     * @param endpoint        地域
     */
    public static void init(String accessKeyId, String accessKeySecret, String endpoint) {
        ACCESS_KEY_ID = accessKeyId;
        ACCESS_KEY_SECRET = accessKeySecret;
        END_POINT = endpoint;
        END_POINT_PARSE = END_POINT.replaceAll("http[s]?://", "");
    }

    /**
     * 上传
     *
     * @param bucketName  存储桶
     * @param key         文件路径
     * @param inputStream 输入流
     * @return 文件Http访问地址
     */
    public static String upload(String bucketName, String key, InputStream inputStream) {
        OSS ossClient = new OSSClientBuilder().build(END_POINT, ACCESS_KEY_ID, ACCESS_KEY_SECRET);
        try {
            PutObjectRequest putObjectRequest = new PutObjectRequest(bucketName, key, inputStream);
            ossClient.putObject(putObjectRequest);
            return String.format("https://%s.%s/%s", bucketName, END_POINT_PARSE, key);
        } finally {
            ossClient.shutdown();
        }
    }


    /**
     * 判断文件是否存在
     *
     * @param bucketName 存储桶
     * @param key        文件路径
     * @return 是否存在
     */
    public static boolean isExist(String bucketName, String key) {
        OSS ossClient = new OSSClientBuilder().build(END_POINT, ACCESS_KEY_ID, ACCESS_KEY_SECRET);
        try {
            return ossClient.doesObjectExist(bucketName, key);
        } finally {
            ossClient.shutdown();
        }
    }
}
