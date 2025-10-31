package Contoller;

import Pojo.emp_info;
import Services.empinfo_service_impl;

import java.util.ArrayList;
import java.util.List;

public class getall {
    public static void main(String[] args) {
        List<emp_info> list= new ArrayList<>();
        empinfo_service_impl ei= new empinfo_service_impl();
        list=ei.getall_emp();
        System.out.println(list);
    }
}
