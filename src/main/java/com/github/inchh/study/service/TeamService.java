package com.github.inchh.study.service;

import com.github.inchh.study.base.Employee;
import com.github.inchh.study.base.Programmer;

import java.util.ArrayList;

/**
 * 团队类
 * 实现团队成员的添加，删除及团队对象的获取功能
 *
 * @author In_Chh
 */
public class TeamService {
    /**
     * 最大员工数量
     */
    public static final int MAX_MEMBER_COUNT = 5;
    /**
     * 用于生成团队ID
     */
    public static int memberIdGener = 1;
    /**
     * 存储员工对象
     */
    public ArrayList<Programmer> teamMembers = new ArrayList<>(MAX_MEMBER_COUNT);

    /**
     * 获取员工对象容器
     *
     * @return ArrayList<Programmer>
     */
    public ArrayList<Programmer> getTeamMembers() {
        return teamMembers;
    }

    /**
     * 向团队中添加员工
     *
     * @param employee 加入团队的员工对象
     * @throws TeamException
     */
    public void addTeamMember(Employee employee) throws TeamException {
        if (teamMembers.size() == MAX_MEMBER_COUNT) {
            throw new TeamException("团队已满，无法添加新成员");
        }
        if (employee instanceof Programmer p) {
            if (p.getStatus() == Status.BUSY) {
                throw new TeamException("该员工已是某团队成员");
            }
            if (p.getStatus() == Status.VOCATION) {
                throw new TeamException("该员工正在休假，无法添加");
            }
            p.setMemberId(memberIdGener++);
            p.setStatus(Status.BUSY);
            teamMembers.add(p);
        } else {
            throw new TeamException("该成员不是开发人员，无法添加");
        }
    }

    /**
     * 从队伍中删除指定员工
     *
     * @param employee 离开团队的员工对象
     * @throws TeamException
     */
    public void removeTeamMember(Employee employee) throws TeamException {
        if (employee instanceof Programmer p) {
            if (!teamMembers.remove(p)) {
                throw new TeamException("删除失败！团队中无此员工");
            }
        }
    }

}
