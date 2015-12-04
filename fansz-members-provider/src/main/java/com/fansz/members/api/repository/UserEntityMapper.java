package com.fansz.members.api.repository;

import com.fansz.members.api.entity.UserEntity;
import com.fansz.members.model.profile.UserInfoResult;
import com.fansz.members.model.search.SearchParam;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import org.apache.ibatis.annotations.Param;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.stereotype.Service;

import java.util.List;

@MapperScan
@Service
public interface UserEntityMapper {

    int deleteByPrimaryKey(Long id);

    int insert(UserEntity record);

    int insertSelective(UserEntity record);

    UserEntity selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(UserEntity record);

    int updateByUidSelective(UserEntity record);

    int updateByUid(UserEntity record);

    int updateByPrimaryKey(UserEntity record);

    int isExists(String mobile);

    UserEntity findByMoblie(@Param("mobile") String mobile);

    UserEntity selectByUid(String uid);

    UserEntity findByAccount(String loginAccount);

    List<UserInfoResult> findByMobiles(List<String> mobiles);

    List<UserEntity> getFandomFollowers(Integer id);

    List<UserEntity> getProfileByNickname(String nickName);

    PageList<UserInfoResult> searchMembers(SearchParam searchParam, PageBounds pageBounds);


}