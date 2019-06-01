package xyz.xlong99.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.xlong99.dao.WikiDao;
import xyz.xlong99.domain.Wiki;
import xyz.xlong99.service.WikiService;

import java.util.List;

@Service("wikiService")
public class WikiServiceImpl implements WikiService {

    @Autowired
    private WikiDao wikiDao;


    @Override
    public List<Wiki> findWikiByClassifyId(int classifyId) {
        return wikiDao.findWikiByClassifyId(classifyId);
    }

    @Override
    public List<Wiki> findWikiByTagId(int tag) {
        return wikiDao.findWikiByTagId(tag);
    }

    @Override
    public int getTagId(String name) {
        return wikiDao.getTagId(name);
    }

    @Override
    public int getClassifyId(String name) {
        return wikiDao.getClassifyId(name);
    }
}
