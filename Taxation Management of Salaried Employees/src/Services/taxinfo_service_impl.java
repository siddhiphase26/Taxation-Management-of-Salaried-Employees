package Services;
import Pojo.emp_info;
import Pojo.tax_info;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class taxinfo_service_impl implements  tax_info_services{
    @Override
    public void get_emp(Integer emp_id) {
      Integer imp_id=emp_id;
      String query="select * from tax_info where imp_id='"+imp_id+"'";
        Connection con= null;
        Statement st= null;
        ResultSet rs= null;

        try{
            con=DB_Connection.get_DBconnect();
            rs= st.executeQuery(query);
            if(rs.next()){
                System.out.println(rs.getInt("emp_id"));
                System.out.println(rs.getString("name"));
                System.out.println(rs.getLong("salary"));
                System.out.println(rs.getInt("year"));
                System.out.println(rs.getLong("on_profit"));
                System.out.println(rs.getLong("t_expenses"));

            }else {
                System.out.println("No Match Data Found");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean calculate_tax(tax_info e) {
        Integer emp_idd=e.getEmp_id();
        String namee= e.getName();
        Long salaryy= e.getSalary();
        Long expensess= e.getT_expenses();
        Long on_profit;
        Long taxamt;
        int count;

        Connection con= null;
        Statement st=null;
        ResultSet rs= null;

        String query= "select * from tax_info";


     try{
         con=DB_Connection.get_DBconnect();
         st= con.createStatement();
         rs=st.executeQuery(query);
         if(rs.next()){
             System.out.println("Employee Already Exist");
         }
         else{
             if(salaryy<1200000){
                 System.out.println("No Tax Applied");

                 taxamt=null;
                 on_profit=salaryy-expensess;
                 String query1="insert into tax_info values ("+emp_idd+",'"+namee+"','"+salaryy+"','"+expensess+"','"+taxamt+"','"+on_profit+"')";
                 count = st.executeUpdate(query1);
                 System.out.println("'"+count+"' rows updated");
                 get_emp(emp_idd);
             }

             else {
                 System.out.println("Tax Applied 15%");
                 taxamt=(salaryy-expensess)*15/100;
                 on_profit=salaryy-taxamt;
                 String query1="insert into tax_info values("+emp_idd+",'"+namee+"','"+salaryy+"','"+expensess+"','"+taxamt+"','"+on_profit+"')";
                 count= st.executeUpdate(query1);
                 get_emp(emp_idd);
             }
         }
     } catch (SQLException ex) {
         throw new RuntimeException(ex);
     } catch (Exception ex) {
         throw new RuntimeException(ex);
     }

        return true;
    }
}
