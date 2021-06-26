package com.github.inchh.study.service;

import com.github.inchh.study.base.*;

public class NameListService implements java.io.Serializable {
    public static final long serialVersionUID = 53434558833332L;
    private final Employee[] employees;

    public NameListService() {
        var data = Data.EMPLOYEES;
        employees = new Employee[data.length];
        for (int i = 0; i < data.length; i++) {
            int id = Integer.parseInt(data[i][1]);
            String name = data[i][2];
            int age = Integer.parseInt(data[i][3]);
            double salary = Double.parseDouble(data[i][4]);
            Equipment equipment;
            double bonus;
            int stock;
            switch (Integer.parseInt(data[i][0])) {
                case Data.EMPLOYEE -> {
                    var employee = new Employee(id, name, age, salary);
                    employees[i] = employee;
                    break;
                }
                case Data.PROGRAMMER -> {
                    equipment = createEquipment(i);
                    employees[i] = new Programmer(id, name, age, salary, equipment);
                    break;
                }
                case Data.DESIGNER -> {
                    equipment = createEquipment(i);
                    bonus = Double.parseDouble(data[i][5]);
                    employees[i] = new Designer(id, name, age, salary, equipment, bonus);
                    break;
                }
                case Data.ARCHITECT -> {
                    equipment = createEquipment(i);
                    bonus = Double.parseDouble(data[i][5]);
                    stock = Integer.parseInt(data[i][6]);
                    employees[i] = new Architect(id, name, age, salary, equipment, bonus, stock);
                    break;
                }
                default -> {
                }
            }
        }
    }

    /**
     * 获取员工对象数组
     *
     * @return 员工对象数组
     */
    public Employee[] getAllEmployees() {
        return employees;
    }

    /**
     * 获取指定ID的员工对象
     *
     * @param id
     * @return 员工对象
     */
    public Employee getEmployee(int id) throws TeamException {
        for (var elem :
                employees) {
            if (elem.getId() == id) {
                return elem;
            }
        }
        throw new TeamException("员工不存在");
    }

    /**
     * 获取指定索引对应data上的员工设备
     *
     * @param i 索引值
     * @return 设备对象
     */
    private Equipment createEquipment(int i) {
        var data = Data.EQUIPMENTS;
        if (data[i].length != 0) {
            Equipment equipment = null;
            switch (Integer.parseInt(data[i][0])) {
                case Data.PC -> {
                    equipment = new Pc(data[i][1], data[i][2]);
                    break;
                }
                case Data.NOTEBOOK -> {
                    equipment = new NoteBook(data[i][1], Double.parseDouble(data[i][2]));
                    break;
                }
                case Data.PRINTER -> {
                    equipment = new Printer(data[i][1], data[i][2]);
                    break;
                }
                default -> {
                }
            }
            return equipment;
        }
        return null;
    }
}