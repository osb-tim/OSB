package xyz.xlong99.controller;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import xyz.xlong99.domain.User;
import xyz.xlong99.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * @author 胡学良
p * @date 2019-05-24 20:32
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;


    /**
     * 通过id查询所有用户信息
     * @param uid 用户ID
     * @return 用户信息
     */
    @RequestMapping("/findAll/{uid}")
    public @ResponseBody User findAll(@PathVariable("uid") int uid){
        System.out.println("=========");
        User user = userService.findUser(uid);
        return user;
    }

    /**
     * 表单提交信息兵提交给数据库
     * @param user 表单提交信息
     * @param response response对象
     * @param request request对象
     * @param upload 获取文件 信息
     * @throws IOException 上传文件时的异常
     */
    @RequestMapping("/save/{uid}")
    public void modifyUser(User user, HttpServletResponse response, HttpServletRequest request, MultipartFile upload) throws IOException {
//        跨服务器上传文件
        String path = "http://localhost:9090/fileupload_war/upload/";
        String filename = upload.getOriginalFilename();
        String uuid = UUID.randomUUID().toString().replace("-","");
        filename = uuid+"_"+filename;
        Client client = Client.create();
        WebResource webResource = client.resource(path+filename);
        webResource.put(upload.getBytes());
        user.setPhoto(filename);
        userService.modifyUser(user);
        response.sendRedirect(request.getContextPath()+"/user/findAll/"+user.getId());
    }

    /**
     * 修改用户头像
     * @param uid 用户ID
     * @param upload 文件上传
     * @param request request对象
     * @param response response对象
     * @throws IOException 文件上传时的异常
     */
    @RequestMapping("/modifyPhoto/{uid}")
    public void modifyPhoto(@PathVariable("uid") int uid,MultipartFile upload,HttpServletRequest request,HttpServletResponse response) throws IOException {
        String path = "D:\\java\\图片";
        String filename = upload.getOriginalFilename();
        String uuid = UUID.randomUUID().toString().replace("-","");
        filename = uuid + "_" +filename;
        upload.transferTo(new File(path,filename));
        userService.modifyPhoto(filename,uid);
        response.sendRedirect(request.getContextPath()+"/user/findAll/"+uid);
    }

    /**
     * 修改用户基本信息
     * @param user 用户信息
     * @param response response对象
     * @param request request对象
     * @throws IOException 文件上传的异常
     */
    @RequestMapping("/modifyMessage/{uid}")
    public void modifyMessage(@PathVariable("uid") int uid,@RequestBody User user, HttpServletResponse response, HttpServletRequest request) throws IOException {
        user.setUid(uid);
        userService.modifyMessage(user);
        response.sendRedirect(request.getContextPath()+"/user/findAll/"+user.getId());
    }
}

