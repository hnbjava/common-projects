package com.hnb.demo.springboot.conditional.bean;

/**
 * @author xiaolu
 * @date 2018/8/29 上午11:05
 */
public class LinuxListService implements ListService {
    @Override
    public String showListCmd() {
        return "Linux ls";
    }
}
