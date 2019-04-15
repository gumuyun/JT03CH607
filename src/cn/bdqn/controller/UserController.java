package cn.bdqn.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import sun.rmi.runtime.Log;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping(value = "/user")
public class UserController {

    private Logger logger=Logger.getLogger(UserController.class);

    @RequestMapping(value = "/main.html" )
    public ModelAndView main(){
        //调用业务
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.addObject("message","HelloSpringMVC!!");
        modelAndView.setViewName("index");
        return modelAndView;
    }

    @RequestMapping(value = "/doLogin.html",method = RequestMethod.GET)
    public ModelAndView doLogin(@RequestParam(value = "userCode",required = false,defaultValue = "test") String userCode,
                        @RequestParam(value = "password",required = false,defaultValue = "test") String password){
        //调用业务
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.addObject("message","HelloSpringMVC!!");

        Map<String,Object> map=new HashMap<>();
        map.put("userCode",userCode);
        map.put("password",password);

        modelAndView.addAllObjects(map);
        modelAndView.addObject("hehehe");
        modelAndView.addObject("xixixi");

        modelAndView.setViewName("index");
        logger.debug("doLogin-参数："+userCode);
        logger.debug("doLogin-参数："+password);
        return modelAndView;
    }

    @RequestMapping(value = "/index.html")
    public String execute(Map<String,Object> model){

        //模型数据
        model.put("message","HelloSpringMVC");
        model.put("userCode","userCode");
        model.put("string","password");

        Map<String,Object> map=new HashMap<>();
        map.put("userCode","userCode");
        map.put("password","password");

        model.putAll(map);

        return "index";//视图名

    }

}
