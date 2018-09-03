package com.hnb.demo.springboot.conditional.bean;

/**
 * @author xiaolu
 * @date 2018/8/29 上午11:06
 */
public class MacListService implements ListService {
    @Override
    public String showListCmd() {
        return "Mac ls";
    }
}
