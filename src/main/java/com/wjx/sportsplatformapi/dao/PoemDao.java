package com.wjx.sportsplatformapi.dao;

import com.wjx.sportsplatformapi.entity.Poem;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author wjx
 * @version 1.0
 * @date 2021/6/21 下午1:58
 */
@Repository
public interface PoemDao {
    public int addPoem(Poem poem) ;
    public int getPoemCounts(@Param("title") String title);
    public List<Poem> getAllPoem(@Param("title") String title, @Param("pageStart") int pageStart, @Param("pageSize") int pageSize);

}
