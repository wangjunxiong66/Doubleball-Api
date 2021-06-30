package com.wjx.sportsplatformapi.dao;

import com.wjx.sportsplatformapi.entity.Poem;
import com.wjx.sportsplatformapi.entity.PoemQueryInfo;
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
    public int getPoemCounts(@Param("content") String content);
//    public List<Poem> getAllPoem(@Param("content") String content, @Param("pageStart") int pageStart, @Param("pageSize") int pageSize);
    public List<Poem> getAllPoem(PoemQueryInfo poemQueryInfo);
    public Poem getupdatepoem(int id);
    public int editPoem(Poem poem) ;
    public int deletePoem(int id) ;

}
