package Services;
import Pojo.emp_info;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class empinfo_service_impl implements emp_info_sevices {
    int a;

    @Override
    public boolean add_emp(emp_info e) {
        Connection con;
        Integer emp_id= e.getEmp_id();
        String name=e.getName();
        String mobile=e.getMobile();
        Long salary= e.getSalary();
        String add=e.getAdd();
        String query = "insert into emp_info values("+emp_id+",'"+name+"','"+mobile+"','"+salary+"','"+add+"')";
        try{
            con = DB_Connection.get_DBconnect();
            if(con== null){
                System.out.println(" Connection is null. Insert failed!");
                return false;
            }
            Statement st = con .createStatement();
            a=st.executeUpdate(query);
            System.out.println("'"+a+"' rows inserted");
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
        return true;
    }

    @Override
    public void get_emp(Integer emp_id) {
           Integer emp_id1= emp_id;
           String query= "select * from emp_info where emp_id='"+emp_id1+"'";

           emp_info emp = null;
           Connection con = null;
           Statement st = null;
           ResultSet rs= null;

           try {
               con=DB_Connection.get_DBconnect();
               st=con.createStatement();
               rs=st.executeQuery(query);
               if(rs.next()){
                   System.out.println(rs.getInt("emp_id"));
                   System.out.println(rs.getString("name"));
                   System.out.println(rs.getString("mobile"));
                   System.out.println(rs.getLong("salary"));
                   System.out.println(rs.getString("addr"));
               }else {
                   System.out.println(" No Match Data Found");
               }

           } catch (SQLException e) {
               throw new RuntimeException(e);
           } catch (Exception e) {
               throw new RuntimeException(e);
           }
    }

    @Override
    public List<emp_info> getall_emp() {
        List<emp_info>list= new ArrayList<>();
        try{
            Connection con = DB_Connection.get_DBconnect();
            Statement st = con.createStatement();
            ResultSet rs= st.executeQuery("select * from emp_info");

            while (rs.next()){
                emp_info ef= new emp_info();
                ef.setEmp_id(rs.getInt("emp_id"));
                ef.setName(rs.getString("name"));
                ef.setMobile(rs.getString("mobile"));
                ef.setSalary(rs.getLong("salary"));
                ef.setAdd(rs.getString("addr"));
                list.add(ef);

            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return list;
    }
}
