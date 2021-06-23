package com.github.inchh.study.base;

import com.github.inchh.study.service.Status;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * 程序员类
 *
 * @author In_Chh
 */
@Getter
@Setter
@Accessors(chain = true)
public class Programmer extends Employee {
    /**
     * 员工在团队中的ID
     */
    private int memberId = 0;
    /**
     * 员工状态
     */
    private Status status = Status.FREE;
    /**
     * 员工持有的设备
     */
    private Equipment equipment;

    public Programmer(int id, String name, int age, double salary, Equipment equipment) {
        super(id, name, age, salary);
        this.equipment = equipment;
    }


    @Override
    public String toString() {
        return getDescription() + "\t程序员\t" + status + "\t\t\t\t\t" + equipment.getDescription();

    }
}
