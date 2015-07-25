package com.gdut.dongjun.domain.dao.impl.system;

import org.springframework.stereotype.Repository;

import com.gdut.dongjun.domain.dao.system.UserMapper;
import com.gdut.dongjun.domain.po.system.User;

/**
 * @author Sherlock-lee
 * @version 创建时间：2015年3月20日 上午8:56:12
 * @Tel 15622358381
 * @state 站内消息DaoImpl
 */
@Repository
public class UserDAOImpl extends SinglePrimaryKeyBaseDAOImpl<User>
		implements UserMapper {
}
