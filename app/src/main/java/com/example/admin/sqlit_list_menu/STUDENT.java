package com.example.admin.sqlit_list_menu;

/**
 * Created by Admin on 08-09-2016.
 */
public class STUDENT
{
    int rn;
    String name,cpi;

    public STUDENT() {
    }

    public STUDENT(String cpi, String name, int rn) {
        this.cpi = cpi;
        this.name = name;
        this.rn = rn;
    }

    public String getCpi()
    {
        return cpi;
    }

    public void setCpi(String cpi) {
        this.cpi = cpi;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRn() {
        return rn;
    }

    public void setRn(int rn) {
        this.rn = rn;
    }
}
