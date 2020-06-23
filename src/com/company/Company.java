/* Company
 *
 * Version 1
 *
 * @author Herman Zviertsev, KhPI
 * COMPANY Service implementation
 */

package com.company;

public class Company {

    private String name;
    private Company parent;
    private long employeesCount;

    public void setParent(Company parent) {
        this.parent = parent;
    }

    public void setEmployeesCount(long employeesCount) {
        this.employeesCount = employeesCount;
    }

    public Company getParent() {
        return parent;
    }

    public long getEmployeesCount() {
        return employeesCount;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Company{" +
                "name='" + name + '\'' +
                ", parent=" + parent +
                ", employeesCount=" + employeesCount +
                '}';
    }
}