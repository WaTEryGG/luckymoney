package com.imooc.luckymoney.controller;

import com.imooc.luckymoney.properties.LimitConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/*
*
* @Controller + @ResponseBody  = @RestController
*
* */
@RestController
@RequestMapping("/say")
//在前面继续加http://localhost:8081/luckymoney/say/Hello
public class Hellocontroller {

    /*@Value("${minMoney}")
    private BigDecimal minMoney;

    @Value("${description}")
    private String description;*/
    @Autowired
    private LimitConfig limitConfig;
    //@PostMapping("/Hello")
     @GetMapping("/Hello")
    //@RequestMapping("/Hello")
    //这种说了和没说一样 get post的机制不同的 只用一个就好
    //GetMapping可以访问数组格式 多个访问同一个{"/Hello","/hi"}
    //@ResponseBody 也可以放这里使用 用于分部使用。一部分使用这个 另外一方法使用类似模板技术等
    public String say(){
        return "跟着学springboot     " +limitConfig.getMinMoney() + "说明：" +limitConfig.getDescription() ;
        //return"index";
         //return "id: " + id ;
    }
    @GetMapping("/Hi/{id}")
public  String say2(@PathVariable("id") Integer id){
    return "id: " + id;
    //http://localhost:8081/luckymoney/say/Hi/250
}
    @GetMapping("/Hii")
    public  String say3(@RequestParam(value = "iq" ,required = false,defaultValue = "0") Integer Myiq){
        return "Myiq: " + Myiq;
        //@RequestParam("iq") 其中iq为url后带的名
        //http://localhost:8081/luckymoney/say/Hii?iq=250
        //defaultValue = "0" 不加后缀默认是0------------
    }
}
