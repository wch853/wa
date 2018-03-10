package com.njfu.ia.sys.service;

import com.njfu.ia.sys.domain.Employee;

import java.util.List;

public interface EmployeeService {

    /**
     * 查询员工列表
     *
     * @param employee empId empName
     * @return data
     */
    List<Employee> getEmployees(Employee employee);

    /**
     * 新增员工信息
     *
     * @param employee empId empName empTel empPosition empAge empSex empPs
     */
    void addEmployee(Employee employee);

    /**
     * 修改员工信息
     *
     * @param employee empId empName empTel empPosition empAge empSex empPs
     */
    void modifyEmployee(Employee employee);

    /**
     * 删除员工信息
     *
     * @param employee empId
     */
    void removeEmployee(Employee employee);
}