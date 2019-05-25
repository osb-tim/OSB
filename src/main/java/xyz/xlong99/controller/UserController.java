package xyz.xlong99.controller;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import xyz.xlong99.domain.User;
import xyz.xlong99.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.UUID;

/**
 * @author xlong
 * @date 2019-05-24 20:32
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;


    @RequestMapping("/findAll/{id}")
    public String findAll(@PathVariable("id") int id, Model model){
        System.out.println("=========="+id);
        User user = userService.findUser(id);
        model.addAttribute("user",user);
        return "user";
    }
    @RequestMapping("/save/{id}")
    public void modifyUser(User user, HttpServletResponse response, HttpServletRequest request, MultipartFile upload) throws IOException {
        System.out.println("跨服务器上传文件");
        String path = "http://localhost:9090/fileupload_war/upload/";
//        File file = new File(path);
//        if(!file.exists()){
//            file.mkdirs();
//            System.out.println("创建文件夹");
//            System.out.println(file.getPath());
//        }
        System.out.println("1111111111111111");
//        得不到文件名
        String filename = upload.getOriginalFilename();
        System.out.println("222222222222222222222");
        String uuid = UUID.randomUUID().toString().replace("-","");
        filename = uuid+"_"+filename;

//        创建客户端的对象
        Client client = Client.create();
        System.out.println("创建客户端对象");
//      和图片服务器进行连接
//      文件名称中不能含有非法字符
        System.out.println(path+filename);
        WebResource webResource = client.resource(path+filename);
        System.out.println("与图片服务器进行连接");
//        上传文件
        webResource.put(upload.getBytes());
        System.out.println("上传文件");
        System.out.println(user.getPhoto());
        user.setPhoto(filename);
        System.out.println("==========="+user.getPhoto());
        userService.modifyUser(user);
        response.sendRedirect(request.getContextPath()+"/user/findAll/"+user.getId());
    }

    @RequestMapping("/modifyPhoto/{id}")
    public void modifyPhoto(@PathVariable("id") int id,MultipartFile upload,HttpServletRequest request,HttpServletResponse response) throws IOException {
        String path = "http://localhost:9090/fileupload_war/upload/";
        String filename = upload.getOriginalFilename();
        String uuid = UUID.randomUUID().toString().replace("-","");
        filename = uuid+"_"+filename;
        Client client = Client.create();
        WebResource webResource = client.resource(path+filename);
        webResource.put(upload.getBytes());
        userService.modifyPhoto(filename,id);
        response.sendRedirect(request.getContextPath()+"/user/findAll/"+id);
    }

    @RequestMapping("/modifyMessage/{id}")
    public void modifyMessage(User user,HttpServletResponse response,HttpServletRequest request) throws IOException {
        userService.modtfyMessage(user);
        response.sendRedirect(request.getContextPath()+"/user/findAll/"+user.getId());
    }
}
