package com.imooc.luckymoney.controller;

import com.imooc.luckymoney.domain.Luckymoney;
import com.imooc.luckymoney.repository.LuckymoneyRepository;
import com.imooc.luckymoney.service.LuckymoneyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class LuckymoneyController {


    @Autowired
    private LuckymoneyRepository repository;

    @Autowired
    private LuckymoneyService service;
    /*
    * 获取红包列表
    * */
    @GetMapping("/luckymoneys")
    public List<Luckymoney> list(){
        return repository.findAll();
    }
    /*
    *
    * 创建红包
    * */

    @PostMapping("/luckymoneys")
    public Luckymoney create(Luckymoney luckymoney){//@RequestParam("producer") String producer, @RequestParam("money")BigDecimal money
        //用的对象可以直接引用实体类代替
        //Luckymoney luckymoney = new Luckymoney();
        luckymoney.setProducer(luckymoney.getProducer());
        luckymoney.setMoney(luckymoney.getMoney());
        return repository.save(luckymoney);
    }
    /*
     *
     * 通过id查询红包
     * */
    @GetMapping("/luckymoneys/{id}")
    public Luckymoney findById(@PathVariable("id") Integer id){

       return repository.findById(id).orElse(null);
    }

    /*
     *
     * 更新红包(领红包)
     * */
    @PutMapping("/luckymoneys/{id}")
    public Luckymoney update(@PathVariable("id") Integer id, @RequestParam("consumer") String consumer){
        Optional<Luckymoney> optional= repository.findById(id);
        if(optional.isPresent()){
            Luckymoney luckymoney = optional.get();
            luckymoney.setId(id);
            luckymoney.setConsumer(consumer);
            return repository.save(luckymoney);
        }
        return null;

    }
    @PostMapping("/luckymoneys/two")
    public void createTwo(){
        service.createTwo();
    }

}
