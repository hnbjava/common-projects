package com.hnb.demo.biz.list;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * @author xiaolu
 * @date 2018/8/6 下午9:26
 */
public class LinkListMain {
    public static void main(String[] args)

    {

        //创建一个字符串数组

        String[] tst1 = new String[900000];

        //动态初始化数组元素

        for (int i = 0; i < 900000; i++)

        {

            tst1[i] = String.valueOf(i);

        }


        ArrayList al = new ArrayList();

        //将所有数组元素加入ArrayList集合中

        long start = System.currentTimeMillis();

        for (int i = 0; i < 900000; i++)

        {

            al.add(tst1[i]);

        }

        System.out.println("ArrayList集合添加元素的时间:" + (System.currentTimeMillis() - start));

        LinkedList ll = new LinkedList();

        //将所有数组元素加入LinkedList集合中

        start = System.currentTimeMillis();

        for (int i = 0; i < 900000; i++)

        {

            ll.add(tst1[i]);

        }

        System.out.println("LinkedList集合添加元素的时间:" + (System.currentTimeMillis() - start));

        //迭代访问ArrayList集合的所有元素，并输出迭代时间

        start = System.currentTimeMillis();

        for (Iterator it = al.iterator(); it.hasNext(); )

        {

            it.next();

        }

        System.out.println("迭代ArrayList集合元素的时间:" + (System.currentTimeMillis() - start));

        //迭代访问LinkedList集合的所有元素，并输出迭代时间

        start = System.currentTimeMillis();

        for (Iterator it = ll.iterator(); it.hasNext(); )

        {

            it.next();

        }

        System.out.println("迭代LinkedList集合元素的时间:" + (System.currentTimeMillis() - start));


    }
}
