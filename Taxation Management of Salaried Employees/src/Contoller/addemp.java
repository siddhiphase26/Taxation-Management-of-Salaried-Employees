package Contoller;


import Pojo.*;
import Services.empinfo_service_impl;

public class addemp {
    public static void main(String[] args) {


        emp_info emp = new emp_info(7, "Isha", "9599501089", 9500000l, "Khandala");
        empinfo_service_impl ei = new empinfo_service_impl();
        boolean a = ei.add_emp(emp);
    }
}