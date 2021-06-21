package com.wjx.sportsplatformapi.dao;

import com.wjx.sportsplatformapi.entity.Poem;
import org.springframework.stereotype.Repository;

/**
 * @author wjx
 * @version 1.0
 * @date 2021/6/21 下午1:58
 */
@Repository
public interface PoemDao {
    public int addPoem(Poem poem) ;

}
