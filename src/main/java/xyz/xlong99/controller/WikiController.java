package xyz.xlong99.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import xyz.xlong99.domain.Classify;
import xyz.xlong99.domain.Tag;
import xyz.xlong99.domain.Wiki;
import xyz.xlong99.service.WikiService;

import java.util.List;


@Controller
@RequestMapping("/wiki")
public class WikiController {
    @Autowired
    private WikiService wikiService;

    /**
     * 直接通过分类id查询文章
     * @param wiki 接受请求id
     * @return
     */
    @RequestMapping("/classifyId")
    @ResponseBody
    public List<Wiki> findWikiByClassifyId(@RequestBody Wiki wiki){
        return wikiService.findWikiByClassifyId(wiki.getClassifyId());
    }

    /**
     * 直接通过标签id查询文章
     * @param wiki 接受请求id
     * @return 文章list集合
     */
    @RequestMapping("/tagId")
    @ResponseBody
    public List<Wiki> fingWikiByTagId(@RequestBody Wiki wiki){
        return wikiService.findWikiByTagId(wiki.getTag());
    }

    /**
     * 通过标签名字查询文章
     * @param tag 接受请求名字
     * @return 文章list集合
     */
    @RequestMapping("/tagName")
    @ResponseBody
    public List<Wiki> findWikiByTagName(@RequestBody Tag tag){
        return wikiService.findWikiByTagId(wikiService.getTagId(tag.getTagname()));
    }

    /**
     * 通过分类名字查询文章
     * @param classify 接受请求名字
     * @return 文章list集合
     */
    @RequestMapping("/classifyName")
    @ResponseBody
    public List<Wiki> findWikiByClassifyName(@RequestBody Classify classify){
        return wikiService.findWikiByClassifyId(wikiService.getClassifyId(classify.getClassifyName()));
    }

}
