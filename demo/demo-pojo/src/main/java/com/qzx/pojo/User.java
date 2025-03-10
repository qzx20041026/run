package com.qzx.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * 用户实体类，包含用户的基本信息。
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    /**
     * 用户ID
     */
    private int userId;

    /**
     * 用户名
     */
    private String userName;

    /**
     * 用户头像图片路径
     */
    private String image;

    /**
     * 用户密码
     */
    private String password;

    /**
     * 用户手机号码
     */
    private String phone;

    /**
     * 用户角色，0表示普通用户，1表示管理员
     */
    private int role;

    /**
     * 用户所在宿舍楼
     */
    private String dormitoryBuilding;

    /**
     * 用户所在宿舍房间号
     */
    private int dormitoryRoom;

    /**
     * 用户创建时间
     */
    private LocalDateTime createdTime;
    /**
     * 用户更新时间
     */
    private LocalDateTime updatedTime;
    /**
     * 用户登录令牌
     */
    private String token;
    /**
     * 默认构造函数
     */
}
