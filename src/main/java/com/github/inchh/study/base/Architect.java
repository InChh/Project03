package com.github.inchh.study.base;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * 架构师类
 *
 * @author In_Chh
 */
@Getter
@Setter
@Accessors(chain = true)
public class Architect extends Designer {
    /**
     * 公司奖励的股票数量
     */
    private int stock;

    public Architect(int id, String name, int age, double salary, Equipment equipment, double bonus, int stock) {
        super(id, name, age, salary, equipment, bonus);
        this.stock = stock;
    }

    @Override
    public String toString() {
        return getDescription() + "\t架构师\t" + getStatus() + "\t" + getBonus() + "\t" + stock + "\t" + getEquipment().getDescription();
    }
}
