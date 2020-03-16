package cn.bdqn.mybatisplusdemo.controller;


import cn.bdqn.mybatisplusdemo.entity.Role;
import cn.bdqn.mybatisplusdemo.entity.User;
import cn.bdqn.mybatisplusdemo.service.IRoleService;
import cn.bdqn.mybatisplusdemo.service.IUserService;
import com.alibaba.fastjson.JSONArray;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.sql.Wrapper;
import java.util.Date;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author rumeng
 * @since 2019-12-02
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService iUserService;
    @Autowired
    private IRoleService iRoleService;

    @RequestMapping("/list")
    public String list(Model model, HttpSession session,String role){
       QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("userName","李刚");
        IPage<User> ipage = new Page<>();
        ipage.setCurrent(1);
        ipage.setSize(5);

        // IPage<User> userIPage= iUserService.page(ipage,wrapper);
        // List<User> s = (List<User>) userIPage;
                //iUserService.list();
      //  return JSONArray.toJSONString(list);
       // return JSONArray.toJSONString(userIPage.getRecords());
        /*QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("userName","李刚");
        iUserService.*/
        User u = new User();
        u.setUserName("王刚");

        List<User> list = iUserService.list();

        model.addAttribute("msg","modelMsg");
        model.addAttribute("list",list);
        session.setAttribute("u",u);
        session.setAttribute("msg2","sessionMsg");
        session.setAttribute("date",new Date());

        List<Role> list1 = iRoleService.list();
        model.addAttribute("roleList",list1);
        System.out.println(role);
        return "userList";
    }

    @RequestMapping("addhtml")
    public String addHtml(){
        return "add";
    }

    @RequestMapping("/add")
    public String add(User user){
        boolean b = iUserService.save(user);
        return "b"+b;
    }

    @RequestMapping("/update")
    public String update(User user){

        boolean b = iUserService.updateById(user);
        return "b"+b;
    }

    @RequestMapping("/del")
    public String del(){
        boolean b = iUserService.removeById(27);
        return "b"+b;
    }
}
