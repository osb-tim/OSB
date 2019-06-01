package xyz.xlong99.service;

import org.springframework.stereotype.Service;
import xyz.xlong99.domain.Wiki;

import java.util.List;

/**
 * @author 胡学良
 * @date 2019-05-26 11:05
 */
public interface WikiService {
    /**
     * 通过分类id查询文章
     * @param classifyId 文章分类id
     * @return 文章集合
     */
    List<Wiki> findWikiByClassifyId(int classifyId);

    /**
     * 通过标签id查询文章
     * @param tag 文章标签id
     * @return 文章集合
     */
    List<Wiki> findWikiByTagId(int tag);

    /**
     * 通过标签名字查询id
     * @param name 标签名字
     * @return 标签id
     */
    int getTagId(String name);

    /**
     * 通过分类名字查询id
     * @param name 分类名字
     * @return 分类id
     */
    int getClassifyId(String name);
}
