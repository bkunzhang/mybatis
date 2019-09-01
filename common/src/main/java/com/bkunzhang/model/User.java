package com.bkunzhang.model;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Created by bkunzhang on 2019/9/1.
 */
@Data
@AllArgsConstructor
public class User {
    private Integer id;
    private String name;
    private int age;
    private String password;
}
