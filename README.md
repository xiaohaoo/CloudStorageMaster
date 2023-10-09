## CloudStorageMaster

云存储工具服务(Cloud Storage Service)，目前仅支持**阿里云OSS**。

### 功能

- [x] 上传文件
- [x] 下载文件
- [x] 删除文件
- [x] 文件断存在

### 使用方法

- groovy

```groovy
implementation platform("com.xiaohaoo:xiaohao-dependencies:1.0.1")
implementation "com.xiaohaoo:cloud-storage-master"
```

- kotlin

```kotlin
implementation(platform("com.xiaohaoo.dependencies:xiaohao-dependencies:1.0.1"))
implementation("com.xiaohaoo:cloud-storage-master")
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
