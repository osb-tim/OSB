package xyz.xlong99.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import xyz.xlong99.domain.Wiki;

import java.util.List;
@Mapper
@Repository
public interface WikiDao {

    /**
     * 通过文章分类id查询文章
     * @param classifyId 文章分类id
     * @return 文章集合
     */
    @Select("select * from wiki where classifyId = #{classifyId}")
    List<Wiki> findWikiByClassifyId(int classifyId);

    /**
     * 通过文章标签id查询文章
     * @param tag 文章标签id
     * @return 文章集合
     */
    @Select("select * from wiki where tag = #{tag}")
    List<Wiki> findWikiByTagId(int tag);

    /**
     * 通过标签名字查询标签id
     * @param name 标签名字
     * @return 标签id
     */
    @Select("select * from tag where tagname = #{name}")
    int getTagId(String name);

    /**
     * 通过分类名字查询分类id
     * @param name 分类名字
     * @return 分类id
     */
    @Select("select * from classify where classifyName = #{name}")
    int getClassifyId(String name);
}
