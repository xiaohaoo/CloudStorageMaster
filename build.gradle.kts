buildscript {
    repositories {
        mavenLocal()
        mavenCentral()
    }
    dependencies {
        classpath("com.xiaohaoo:maven-publishing-gradle-plugin:1.0.2")
    }
}
plugins {
    java
}

apply(plugin = "com.xiaohaoo.maven-publishing")

repositories {
    mavenLocal()
    mavenCentral()
}

group = "com.xiaohaoo"
version = "1.1.1"


dependencies {
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.7.0")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.7.0")
    implementation("com.aliyun.oss:aliyun-sdk-oss:3.13.0")
    compileOnly("org.projectlombok:lombok:1.18.22")
    annotationProcessor("org.projectlombok:lombok:1.18.22")
    testCompileOnly("org.projectlombok:lombok:1.18.22")
    testAnnotationProcessor("org.projectlombok:lombok:1.18.22")
}

java {
    sourceCompatibility = JavaVersion.VERSION_1_9
    targetCompatibility = JavaVersion.VERSION_1_9
}

tasks.withType<Test> {
    useJUnitPlatform()
}

configure<com.xiaohaoo.gradle.plugin.MavenPublishingPluginExtension> {
    url.set("https://github.com/xiaohaoo/cloud-storage-master")
    description.set("云存储工具服务")
}
