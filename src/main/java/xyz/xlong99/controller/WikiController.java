package xyz.xlong99.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import xyz.xlong99.domain.Classify;
import xyz.xlong99.domain.Tag;
import xyz.xlong99.domain.Wiki;
import xyz.xlong99.service.UserService;
import xyz.xlong99.service.WikiService;

import java.util.List;


@Controller
@RequestMapping("/wiki")
public class WikiController {
    @Autowired
    private WikiService wikiService;

    @Autowired
    private UserService userService;
    /**
     * 直接通过分类id查询文章
     * @param wiki 接受请求id
     * @return
     */
    @RequestMapping("/classifyId")
    @ResponseBody
    public List<Wiki> findWikiByClassifyId(@RequestBody Wiki wiki){
        List<Wiki> list = wikiService.findWikiByClassifyId(wiki.getClassifyId());
        list = test(list);
        return list;
    }

    /**
     * 直接通过标签id查询文章
     * @param wiki 接受请求id
     * @return 文章list集合
     */
    @RequestMapping("/tagId")
    @ResponseBody
    public List<Wiki> fingWikiByTagId(@RequestBody Wiki wiki){
        List<Wiki> list = wikiService.findWikiByTagId(wiki.getTag());
        list = test(list);
        return list;
    }

    /**
     * 通过标签名字查询文章
     * @param tag 接受请求名字
     * @return 文章list集合
     */
    @RequestMapping("/tagName")
    @ResponseBody
    public List<Wiki> findWikiByTagName(@RequestBody Tag tag){
        List<Wiki> list = wikiService.findWikiByTagId(wikiService.getTagId(tag.getTagname()));
        list = test(list);
        return list;
    }

    /**
     * 通过分类名字查询文章
     * @param classify 接受请求名字
     * @return 文章list集合
     */
    @RequestMapping("/classifyName")
    @ResponseBody
    public List<Wiki> findWikiByClassifyName(@RequestBody Classify classify){
        List<Wiki> list =  wikiService.findWikiByClassifyId(wikiService.getClassifyId(classify.getClassifyName()));
        list = test(list);
        return list;
    }

    /**
     * 给user属性赋值
     * @param list 文章的集合
     */
    public List<Wiki> test(List<Wiki> list){
        for(Wiki wiki : list){
            wiki.setUser(userService.findUser(wiki.getAuthorId()));
        }
        return list;
    }
}
