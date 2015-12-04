package com.fansz.members.api.repository;

import com.fansz.members.api.entity.FandomEntity;
import com.fansz.members.model.fandom.FandomCategorys;
import com.fansz.members.model.fandom.FandomInfoResult;
import com.fansz.members.model.fandom.FandomQueryParam;
import com.fansz.members.model.profile.ContactInfoResult;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import org.mybatis.spring.annotation.MapperScan;

import java.util.List;

@MapperScan
public interface FandomMapper {

    int deleteByPrimaryKey(Long id);

    int insert(FandomEntity record);

    int insertSelective(FandomEntity record);

    FandomEntity selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(FandomEntity record);

    int updateByPrimaryKey(FandomEntity record);

    List<FandomEntity> selectByParentId(Long id);

    List<FandomInfoResult> findFandomByIds(List<String> snList);

    List<FandomInfoResult> listByCondition(FandomEntity param);

    List<FandomInfoResult> getRecommendFandom(PageBounds pageBounds);

    List<FandomInfoResult> getFandomCategory(Long id);

    List<ContactInfoResult> getFandomMembers(FandomQueryParam fandomQueryParam);
//    List<ContactInfoResult> getFandomMembers(FandomQueryParam fandomQueryParam, PageBounds pageBounds);
}