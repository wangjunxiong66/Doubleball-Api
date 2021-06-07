package com.wjx.sportsplatformapi.dao;

import com.wjx.sportsplatformapi.entity.MainMenu;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author wjx
 * @version 1.0
 * @date 2020/10/27 下午4:07
 */
@Repository
public interface MenuDao {

    public List<MainMenu> getMenus();


}
