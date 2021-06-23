package com.github.inchh.study.base;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * 设计师类
 *
 * @author In_Chh
 */
@Getter
@Setter
@Accessors(chain = true)
public class Designer extends Programmer {
    /**
     * 奖金
     */
    private double bonus;

    public Designer(int id, String name, int age, double salary, Equipment equipment, double bonus) {
        super(id, name, age, salary, equipment);
        this.bonus = bonus;
    }

    @Override
    public String toString() {
        return getDescription() + "\t设计师\t" + getStatus() + "\t" + bonus + "\t\t\t" + getEquipment().getDescription();
    }
}
