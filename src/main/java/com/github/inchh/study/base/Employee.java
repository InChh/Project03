package com.github.inchh.study.base;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * @author In_Chh
 */
@Getter
@Setter
@Accessors(chain = true)
public class Employee implements java.io.Serializable {
    public static final long serialVersionUID = -124349599434444L;
    private int id;
    private String name;
    private int age;
    private double salary;

    public Employee(int id, String name, int age, double salary) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    public String getDescription() {
        return id + "\t" + name + "\t" + age + "\t\t" + salary;
    }

    @Override
    public String toString() {
        return getDescription();
    }
}
