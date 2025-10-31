package Pojo;

public class emp_info {
    private Integer emp_id;
    private String name;
    private String mobile;
    private Long salary;
    private String add;

    public emp_info(Integer emp_id, String name, String mobile, Long salary, String add){
        this.emp_id=emp_id;
        this.name=name;
        this.mobile=mobile;
        this.salary=salary;
        this.add=add;
    }

    public emp_info() {

    }

    public Integer getEmp_id() {
        return emp_id;
    }

    public String getName() {
        return name;
    }

    public String getMobile() {
        return mobile;
    }

    public Long getSalary() {
        return salary;
    }

    public String getAdd() {
        return add;
    }

    public void setEmp_id(Integer emp_id) {
        this.emp_id = emp_id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public void setSalary(Long salary) {
        this.salary = salary;
    }

    public void setAdd(String add) {
        this.add = add;
    }

    public String toString() {
        return "emp_info{" +
                "emp_id=" + emp_id +
                ", name='" + name + '\'' +
                ", mobile='" + mobile + '\'' +
                ", salary='" + salary + '\'' +
                ", addr='" + add + '\''+
        '}';
    }
}
