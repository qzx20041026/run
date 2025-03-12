package com.qzx.Service;

import com.qzx.pojo.User;
import com.qzx.pojo.vxUser;

public interface userService {
    User login(User user);

    User byUserName(String userName);

    int sign(User user);

    int update(User user);

    User loginwx(vxUser code);
}
