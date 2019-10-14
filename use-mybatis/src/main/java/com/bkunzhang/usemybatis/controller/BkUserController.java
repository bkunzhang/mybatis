package com.bkunzhang.usemybatis.controller;

import com.bkunzhang.usemybatis.model.BkUser;
import com.bkunzhang.usemybatis.service.BkUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author bkunzhang
 * @date 2019/10/15
 */
@RestController
@RequestMapping("/bkUser")
public class BkUserController {
    @Autowired
    private BkUserService bkUserService;

    @RequestMapping("/showUser")
    public BkUser showUser(@RequestParam Integer id){
        BkUser user = bkUserService.getUserById(id);
        return user;
    }
}
