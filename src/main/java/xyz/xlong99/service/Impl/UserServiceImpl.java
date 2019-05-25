package xyz.xlong99.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.xlong99.dao.UserDao;
import xyz.xlong99.domain.User;
import xyz.xlong99.service.UserService;

/**
 * @author xlong
 * @date 2019-05-24 20:34
 */
@Service("userService")
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public User findUser(int id) {
        System.out.println("findUser()。。。。");
        return userDao.findAll(id);
    }

    @Override
    public void modifyUser(User user) {
        userDao.modifyUser(user);
        System.out.println("modifyUser()。。。。");
    }

    @Override
    public void modifyPhoto(String photo, int id) {
        userDao.modifyPhoto(photo,id);
    }

    @Override
    public void modtfyMessage(User user) {
        userDao.modifyMessage(user);
    }
}
