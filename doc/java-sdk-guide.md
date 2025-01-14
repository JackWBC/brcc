# JAVA SDK 使用手册

## 概述

maven 坐标
普通 SDK使用方式[![brcc sdk](https://maven-badges.herokuapp.com/maven-central/com.baidu.mapp/brcc-sdk/badge.svg)](https://maven-badges.herokuapp.com/maven-central/com.baidu.mapp/brcc-sdk)
```xml
<dependency>
    <groupId>com.baidu.mapp</groupId>
    <artifactId>brcc-sdk</artifactId>
    <version>1.0.0</version>
</dependency>
```

spring boot starter使用方式[![brcc sdk starter](https://maven-badges.herokuapp.com/maven-central/com.baidu.mapp/brcc-sdk-starter/badge.svg)](https://maven-badges.herokuapp.com/maven-central/com.baidu.mapp/brcc-sdk-starter)
```xml
<dependency>
    <groupId>com.baidu.mapp</groupId>
    <artifactId>brcc-sdk-starter</artifactId>
    <version>1.0.0</version>
</dependency>
```
建议引用最新版本

## 启动参数配置

```yaml
rcc:
  cc-server-url: http://ip:port/
  project-name: example
  cc-password: 123456
  env-name: dev
  cc-version-name: 1.0
  log-properties: true
  enable-update-callback: true
```
- rcc.cc-server-url: 配置中心服务地址
- rcc.project-name: 请求的工程名称
- rcc.cc-password: 请求的工程ApiPassword
- rcc.env-name: 请求的环境名称
- rcc.cc-version-name: 请求的版本名称
- rcc.log-properties: 是否打印配置
- rcc.enable-update-callback: 是否启用自动更新

## 自动更新配置

当启动参数中**rcc.enable-update-callback**配置开启的时，自动更新功能打开。
自动更新采用的时观察者模式， 您只需要实现 **com.baidu.brcc.ConfigItemChangedCallable**接口，并将其以Bean的方式注册到Spring容器中，
当系统中有配置方式变更后，并且在管理平台上执行了**推送变更**操作， rcc会主动调用ConfigItemChangedCallable。

例如：
```java
@Configuration
public class ExampleConfiguration {

    @Bean
    public ConfigItemChangedCallable configItemChangedCallable() {
        return new DefaultConfigItemChangedCallable();
    }


}
```
DefaultConfigItemChangedCallable 是rcc提供的默认变更回调实现， 其中仅仅打印变更日志，您可以实现自己的变更业务。
