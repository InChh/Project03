package com.github.inchh.study.view;

import com.github.inchh.study.base.Employee;
import com.github.inchh.study.base.Programmer;
import com.github.inchh.study.service.NameListService;
import com.github.inchh.study.service.TeamException;
import com.github.inchh.study.service.TeamService;

import java.util.ArrayList;

/**
 * 软件主类，用于显示菜单及与用户交互
 *
 * @author In_Chh
 */
public class TeamView {
    private static final NameListService nameListService = new NameListService();
    private static final TeamService teamService = new TeamService();
    private static final Employee[] employees = nameListService.getAllEmployees();
    private static final ArrayList<Programmer> teamMembers = teamService.getTeamMembers();

    public static void showNameList() {
        for (var e : employees) {
            System.out.println(e);
        }

    }

    public static void showMenu() {
        System.out.println("-------------------------------------开发团队调度软件--------------------------------------");
        System.out.println("ID\t姓名\t年龄\t工资\t职位\t状态\t奖金\t股票\t领用设备");
        showNameList();
        System.out.println("----------------------------------------------------------------------------------------------");
        System.out.println("1-团队列表\t2-添加团队成员\t3-删除团队成员\t4-退出\t请选择(1-4)：");
    }

    public static void showTeamMembers() {
        System.out.println("--------------------团队成员列表---------------------");
        if (!teamMembers.isEmpty()) {
            System.out.println("TID/ID\t姓名\t年龄\t工资\t职位\t状态\t奖金\t股票\t领用设备");
            for (var e : teamMembers) {
                System.out.println(e.getMemberId() + "/" + e);
            }
            System.out.println("-----------------------------------------------------");
        } else {
            System.out.println("团队中暂无成员");
        }
    }

    public static void addTeamMember() {
        System.out.println("---------------------添加成员---------------------");
        System.out.println("请输入要添加的员工ID：");
        int id = TSUtility.readInt();
        try {
            //获取相应id的职员对象
            Employee employee = nameListService.getEmployee(id);
            //判断该职员是否在团队中
            if (teamMembers.contains(employee)) {
                throw new TeamException("该员工已在本开发团队中");
            }
            //将该职员添加到团队中
            teamService.addTeamMember(employee);
            System.out.println("添加成功");
        } catch (TeamException e) {
            System.out.println("添加失败，原因：" + e.getMessage());
        }
    }

    public static void main(String[] args) {
        //进入消息循环
        while (true) {
            //显示菜单
            showMenu();
            //读取用户输入
            char selection = TSUtility.readMenuSelection();
            //执行相应方法
            switch (selection) {
                case '1':
                    showTeamMembers();
                    TSUtility.readReturn();
                    break;
                case '2':
                    addTeamMember();
                    TSUtility.readReturn();
                    break;
                case '3':
                    TSUtility.readReturn();
                    break;
                case '4':
                    System.out.println("确认退出？（Y/N）：");
                    if (TSUtility.readConfirmSelection() == 'Y') {
                        System.out.println("拜了个拜┏(＾0＾)┛");
                        return;
                    }
                    System.out.println("输错了吧o(*￣︶￣*)o");
                    break;
                default:
            }
        }
    }
}
