## CloudStorageMaster

云存储工具服务(Cloud Storage Service)，目前仅支持**阿里云OSS**。

### 功能

- [x] 上传文件
- [x] 下载文件
- [x] 删除文件
- [x] 文件断存在

### 使用

```groovy
implementation group: 'com.xiaohaoo', name: 'cloud-storage-master', version: '1.1.0'
```

```xml

<dependency>
    <groupId>com.xiaohaoo</groupId>
    <artifactId>cloud-storage-master</artifactId>
    <version>1.1.0</version>
</dependency>

```

## 使用方法

```java
public class Main {
    public static void main(String[] args) {
        String accessKeyId = "accessKeyId";
        String accessKeySecret = "accessKeySecret";
        String endpoint = "https://endpoint";
        CloudStorageFactory cloudStorageFactory = new AliyunCloudStorageFactory(accessKeyId, accessKeySecret, endpoint);
        CloudStorageService cloudStorageService = new CloudStorageService(cloudStorageFactory);
        cloudStorageService.upload(bucketName, objectName, inputStream);
    }
}
```

## Authors

- [xiaohaoo](https://github.com/xiaohaoo)

## License

[GNU Affero General Public License v3.0](LICENSE)
