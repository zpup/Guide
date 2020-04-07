# Guide
技术分享、各类信息分享，摘录。


## 前言

此接入文档适用于所有合作方的海外发行安卓游戏。主要内容包括接入方式以及接口调用的方法和参数说明等。

## 前提条件

- minSdkVersion 必须在16及以上
- compileSdkVersion 必须在28以上

## 准备工作

 - 导入SDK步骤

 ### Moudles接入方式（推荐使用）

 ![avatar](https://gitee.com/yanyan90107/overseas_advertising_sdk/blob/master/file_import_moudles.png)


 ![avatar](https://gitee.com/yanyan90107/overseas_advertising_sdk/blob/master/%E5%AF%BC%E5%85%A5-1.png)


 ![avatar](https://gitee.com/yanyan90107/overseas_advertising_sdk/blob/master/%E5%AF%BC%E5%85%A5-3.png)


 ![avatar](https://gitee.com/yanyan90107/overseas_advertising_sdk/blob/master/%E5%AF%BC%E5%85%A5-4.png)


 ![avatar](https://gitee.com/yanyan90107/overseas_advertising_sdk/blob/master/%E5%AF%BC%E5%85%A5-5.png)

 **请在app下的gradle文件内的android节点和dependencies节点中间添加以下内容，解决ERROR:Failed to resolve的问题**

```
repositories {
    flatDir {
        dirs 'libs', '../SinagameOverseasSdk/libs'
    }
}

```

### aar接入方式

请将我方提供的aar文件放入到工程的libs目录下，并且在app下的gradle文件内，进行相关aar配置

## 正式接入


