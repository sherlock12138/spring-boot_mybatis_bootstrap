package com.gdut.dongjun.domain.dao.impl;

import org.springframework.stereotype.Repository;

import com.gdut.dongjun.domain.dao.UserMapper;
import com.gdut.dongjun.domain.dao.base.impl.SinglePrimaryKeyBaseDAOImpl;
import com.gdut.dongjun.domain.po.User;

/**
 * 
 * @author Sherlock-lee
 * @date 2015年11月14日 下午4:56:29
 * @see TODO
 * @since 1.0
 */
@Repository
public class UserDAOImpl extends SinglePrimaryKeyBaseDAOImpl<User> implements
		UserMapper {
}
