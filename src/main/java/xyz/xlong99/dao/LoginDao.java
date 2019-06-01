package xyz.xlong99.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * @author xlong
 */
@Mapper
@Repository
public interface LoginDao {
    /**
     * 用户名校验
     * @param loginname 要校验的用户名
     * @return 用户存在返回true
     */
    @Select("select count(*) from user where loginname=#{loginname}")
    boolean checkLoginname(@Param("loginname") String loginname);
    /**
     *密码校验
     */
    boolean checkpassword();

}
