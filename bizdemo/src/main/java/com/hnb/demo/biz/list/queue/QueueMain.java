package com.hnb.demo.biz.list.queue;

import java.util.ArrayDeque;

/**
 * @author xiaolu
 * @date 2018/8/6 下午9:20
 */
public class QueueMain {
    public static void main(String[] args) {
        ArrayDeque<String> stack = new ArrayDeque<String>();
        stack.add("1");
        stack.push("2");
        stack.push("3");
        stack.add("3");
        System.out.println(stack);
        System.out.println(stack.peek());
        System.out.println(stack);
        System.out.println(stack.pop());
        System.out.println(stack);
        int s = 6 ^ 3;
        System.out.println(Integer.toBinaryString(6));
        System.out.println(Integer.toBinaryString(3));
        System.out.println("select t1.id,t1.username,t3.code,t4.Lon as longitude ,t4.Lat latitude from t_user t1 INNER JOIN t_user_role t2 " +
                "on t1.id=t2.userid INNER JOIN t_role t3 on t3.id=t2.roleid INNER JOIN t_vip t4 on t1.id=t4.userId " +
                "where t1.areaCode like #{areaCode} and IF(ISNULL(#{code}),true,t3.code=#{code}) ");
    }
}
