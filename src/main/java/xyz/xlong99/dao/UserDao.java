package xyz.xlong99.dao;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;
import xyz.xlong99.domain.User;

/**
 * @author 胡学良
 * @date 2019-05-24 20:30
 */
@Repository
public interface UserDao {
    /**
     * 查询指定用户所有信息
     * @param id 用户id,查询依据
     * @return User 用户所有信息
     */
    @Select("select * from user where id = #{id}")
    User findAll(int id);

    /**
     * 根据表单信息修改用户信息
     //     * @param id 用户ID
     * @param user 修改值
     * @return User 修改之后的用户信息
     */
    @Update("update user set nickName = #{nickName},sex = #{sex},position = #{position},address = #{address},sign = #{sign},photo = #{photo} where id = #{id}")
    void modifyUser(User user);

    /**
     *修改用户头像
     * @param photo 用户头像
     * @param id 用户ID
     */
    @Update("update user set photo = #{photo} where id = #{id}")
    void modifyPhoto(@Param("photo") String photo, @Param("id") int id);

    /**
     * 修改用户基本信息
     * @param user 用户信息
     */
    @Update("update user set nickName = #{username},sex = #{sex},position = #{position},address = #{address},sign = #{sign} where id = #{id}")
    void modifyMessage(User user);

}
