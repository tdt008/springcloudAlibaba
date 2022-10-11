package com.tdt.platform.servicea.api;

import com.tdt.platform.servicea.entity.User;

/**
 * @author tudoutiao
 * @version v1.0.0
 * @description: UserServiceManager
 * @since 2020/06/23 00:40
 */
public interface UserService {
    /**
     * @description 根据id查询
     * @param uid
     * @return com.tdt.platform.servicea.entity.User
     * @author tudoutiao
     * @date 0:43 2020/6/23
     **/
    User getById(Long uid);
}
