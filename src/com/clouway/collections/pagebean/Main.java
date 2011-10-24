package com.clouway.collections.pagebean;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Created by IntelliJ IDEA.
 * User: clouway
 * Date: 10/21/11
 * Time: 9:31 AM
 * To change this template use File | Settings | File Templates.
 */
public class Main {


    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String option;
        String[] elements = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
        List<String> list = new ArrayList<String>(Arrays.asList(elements));


        PageBean pageBean = new PageBean(list);

        System.out.println(pageBean.next());
        while (!(option = input.next()).equals("quit")) {
            if (option.equals("next"))
                System.out.println(pageBean.next());
            if (option.equals("previous"))
                System.out.println(pageBean.previous());
            if (!option.equals("next") && !option.equals("previous"))
                System.out.println("Use next/previous commands to see more pages or quit command to exit the program!");

        }


    }

}
