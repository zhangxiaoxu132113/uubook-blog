package com.water.uubook.blog.repository;

import com.water.uubook.blog.model.UserInfo;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by zhangmiaojie on 2017/12/28.
 */
public interface UserInfoRepository extends MongoRepository<UserInfo, Integer> {

}
