package Services;
import Pojo.*;

import java.util.List;

public interface emp_info_sevices {

boolean add_emp(emp_info e);
void get_emp(Integer emp_id);
List<emp_info>getall_emp();
}
