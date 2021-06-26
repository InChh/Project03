package com.github.inchh.study.view;

import com.github.inchh.study.base.Employee;
import com.github.inchh.study.base.Programmer;
import com.github.inchh.study.service.NameListService;
import com.github.inchh.study.service.TeamException;
import com.github.inchh.study.service.TeamService;

import java.io.*;
import java.util.ArrayList;

/**
 * 软件主类，用于显示菜单及与用户交互
 *
 * @author In_Chh
 */
public class TeamView {
    private static NameListService nameListService;
    private static TeamService teamService;
    private static Employee[] employees;
    private static ArrayList<Programmer> teamMembers;

    /**
     * 初始化程序，读取文件
     */
    public void init() {
        File file = new File("info.dat");
        if (file.exists()) {
            ObjectInputStream ois = null;
            try {
                ois = new ObjectInputStream(new FileInputStream(file));
                nameListService = (NameListService) ois.readObject();
                teamService = (TeamService) ois.readObject();
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            } finally {
                if (ois != null) {
                    try {
                        ois.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        } else {
            nameListService = new NameListService();
            teamService = new TeamService();
        }
        employees = nameListService.getAllEmployees();
        teamMembers = teamService.getTeamMembers();
    }

    public void showNameList() {
        for (var e : employees) {
            System.out.println(e);
        }

    }

    public void showMenu() {
        System.out.println("-------------------------------------开发团队调度软件--------------------------------------");
        System.out.println("ID\t姓名\t年龄\t工资\t职位\t状态\t奖金\t股票\t领用设备");
        showNameList();
        System.out.println("----------------------------------------------------------------------------------------------");
        System.out.println("1-团队列表\t2-添加团队成员\t3-删除团队成员\t4-退出\t请选择(1-4)：");
    }

    public void showTeamMembers() {
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

    public void addTeamMember() {
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
            System.out.println("添加成功^_^");
        } catch (TeamException e) {
            System.out.println("添加失败ε=(´ο｀*))) 原因：" + e.getMessage());
        }
    }

    public void deleteTeamMember() {
        System.out.println("---------------------删除成员---------------------");
        System.out.println("请输入要删除的员工ID：");
        int id = TSUtility.readInt();
        try {
            Employee employee = nameListService.getEmployee(id);
            teamService.removeTeamMember(employee);
            System.out.println("删除成功^_^");
        } catch (TeamException e) {
            System.out.println("删除失败ε=(´ο｀*))) 原因：" + e.getMessage());
        }

    }

    /**
     * 将程序状态保存到文件
     */
    public void save() {
        ObjectOutputStream objectOutputStream = null;
        try {
            objectOutputStream = new ObjectOutputStream(new FileOutputStream("info.dat"));
            objectOutputStream.writeObject(nameListService);
            objectOutputStream.writeObject(teamService);
            objectOutputStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
