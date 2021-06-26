package com.github.inchh.study;

import com.github.inchh.study.view.TSUtility;
import com.github.inchh.study.view.TeamView;

public class main {
    public static void main(String[] args) {
        TeamView tv = new TeamView();
        tv.init();
        //进入消息循环
        while (true) {
            //显示菜单
            tv.showMenu();
            //读取用户输入
            char selection = TSUtility.readMenuSelection();
            //执行相应方法
            switch (selection) {
                case '1':
                    tv.showTeamMembers();
                    TSUtility.readReturn();
                    break;
                case '2':
                    tv.addTeamMember();
                    TSUtility.readReturn();
                    break;
                case '3':
                    tv.deleteTeamMember();
                    TSUtility.readReturn();
                    break;
                case '4':
                    System.out.println("确认退出？（Y/N）：");
                    if (TSUtility.readConfirmSelection() == 'Y') {
                        System.out.println("拜了个拜┏(＾0＾)┛");
                        tv.save();
                        return;
                    }
                    System.out.println("输错了吧o(*￣︶￣*)o");
                    break;
                default:
            }
        }
    }
}
