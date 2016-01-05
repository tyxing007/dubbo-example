package com.fansz.fandom.repository;

import com.fansz.fandom.entity.FandomEntity;
import com.fansz.fandom.model.fandom.DelFandomParam;
import com.fansz.fandom.model.fandom.FandomInfoResult;
import com.fansz.fandom.model.fandom.ModifyFandomParam;
import com.fansz.fandom.model.fandom.SearchFandomResult;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import org.apache.ibatis.annotations.Param;
import org.mybatis.spring.annotation.MapperScan;

import java.util.List;

@MapperScan
public interface FandomMapper {

    int insert(FandomEntity record);

    int insertSelective(FandomEntity record);

    List<FandomInfoResult> listByCondition(FandomEntity param);

    PageList<FandomInfoResult> getRecommendFandom(@Param("memberSn") String memberSn, PageBounds pageBounds);

    FandomInfoResult getFandomDetail(@Param("fandomId") Long fandomId, @Param("memberSn") String memberSn);

    List<FandomInfoResult> getFandomCategory(Long id);

    PageList<SearchFandomResult> searchFandoms(@Param("memberSn") String memberSn, @Param("searchVal") String searchVal, PageBounds pageBounds);

    int getCountByFandomName(String fandomName);

    int delFandom(DelFandomParam delFandomParam);

    int modifyFandom(ModifyFandomParam modifyFandomParam);

    FandomInfoResult getFandomInfo(@Param("fandomId") Long fandomId, @Param("fandomName") String fandomName);
}