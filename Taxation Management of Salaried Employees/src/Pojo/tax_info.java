package Pojo;

public class tax_info {
    private Integer emp_id;
    private String name;
    private Long salary;
    private  Integer year;
    private  Long on_profit;
    private  Long t_expenses;
    private Long tax_amt;
    public tax_info(Integer emp_id, String name,Long salary,Integer year,Long on_profit,Long t_expenses,Long tax_amt) {
        this.emp_id = emp_id;
        this.name=name;
        this.salary= salary;
        this.year=year;
        this.on_profit=on_profit;
        this.t_expenses=t_expenses;
         this .tax_amt=tax_amt;
    }

    public Integer getEmp_id() {
        return emp_id;
    }

    public String getName() {
        return name;
    }

    public Long getSalary() {
        return salary;
    }

    public Integer getYear() {
        return year;
    }

    public Long getOn_profit() {
        return on_profit;
    }

    public Long getT_expenses() {
        return t_expenses;
    }

    public Long getTax_amt() {
        return tax_amt;
    }
}
