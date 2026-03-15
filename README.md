# Android BroadcastReceiver 广播接收器演示

## 简介

本 Demo 演示 Android 中 BroadcastReceiver 的使用，包括系统广播和自定义广播。

## 基本原理

### 什么是 BroadcastReceiver？

BroadcastReceiver 是 Android 的四大组件之一，用于接收来自系统或其他应用发送的广播。

### 广播类型

1. **系统广播**: 如网络变化、电池电量变化
2. **自定义广播**: 开发者自定义的广播
3. **本地广播**: 仅在同一应用内发送

## 启动和使用

### 环境要求
- Android Studio

### 安装运行
使用 Android Studio 打开项目并运行

## 教程

### 1. 静态注册广播接收器

在 AndroidManifest.xml 中注册：
```xml
<receiver android:name=".MyBroadcastReceiver">
    <intent-filter>
        <action android:name="demos.CUSTOM_ACTION" />
    </intent-filter>
</receiver>
```

### 2. 动态注册广播接收器

在 Activity 中注册：
```kotlin
val filter = IntentFilter("demos.ACTION")
registerReceiver(receiver, filter)
```

### 3. 发送广播

```kotlin
val intent = Intent("demos.CUSTOM_ACTION")
intent.putExtra("message", "Hello")
sendBroadcast(intent)
```

### 4. 本地广播

使用 LocalBroadcastManager 更安全：
```kotlin
LocalBroadcastManager.getInstance(this).sendBroadcast(intent)
```

## 注意事项

1. 广播接收器运行在主线程，不要执行耗时操作
2. 本地广播更安全，推荐使用
3. 动态注册的广播需要手动注销
