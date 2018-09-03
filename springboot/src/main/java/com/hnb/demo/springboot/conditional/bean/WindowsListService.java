package com.hnb.demo.springboot.conditional.bean;

/**
 * @author xiaolu
 * @date 2018/8/29 上午11:05
 */
public class WindowsListService implements ListService {
    @Override
    public String showListCmd() {
        return "Windows ls";
    }
}
