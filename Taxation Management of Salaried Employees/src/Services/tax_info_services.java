package Services;
import Pojo.*;

public interface tax_info_services {
    void get_emp(Integer emp_id);
    boolean calculate_tax(tax_info e);
}
