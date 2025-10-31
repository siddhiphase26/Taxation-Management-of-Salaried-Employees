package Contoller;

import Services.empinfo_service_impl;

public class get_emp {
    public static void main(String[] args) {
        empinfo_service_impl e = new empinfo_service_impl();
        e.get_emp(1);
    }
}
