package com.qzx.utils;

public class CurrentHolder {
    // 使用ThreadLocal来存储用户ID
    private static final ThreadLocal<Integer> userIdThreadLocal = new ThreadLocal<>();

    // 设置当前线程的用户ID
    public static void setCurrentId(Integer Id) {
        userIdThreadLocal.set(Id);
    }

    // 获取当前线程的用户ID
    public static Integer getCurrentId() {
        return userIdThreadLocal.get();
    }

    // 清除当前线程的用户ID，防止内存泄漏
    public static void remove() {
        userIdThreadLocal.remove();
    }
}
