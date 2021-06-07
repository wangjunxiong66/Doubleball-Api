package com.wjx.sportsplatformapi.dao;

import com.wjx.sportsplatformapi.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author wjx
 * @version 1.0
 * @date 2020/10/21 下午1:43
 */
 //  @Repository用于将数据访问层 (DAO 层 ) 的类标识为 Spring Bean，对应存储层Bean
@Repository
public interface UserDao {

    //  在下面语句中，不能省略 "@Param..."，否则会提示类似"nested exception is org.apache.ibatis.binding.BindingException: Parameter 'roleIds' not found. Available parameters are [0, 1, param1, param2]"的异常
    public User getUserByMessage(@Param("username") String username,@Param("password") String password);
    public List<User> getAllUser(@Param("username") String username, @Param("pageStart") int pageStart, @Param("pageSize") int pageSize);
    public int getUserCounts(@Param("username") String username);
    public int updateState(@Param("id") Integer id,@Param("state") Boolean state);
    public int addUser(User user);
    public int deleteUser(int id);
    public User getupdateuser(int id);
    public int editUser(User user);

}
