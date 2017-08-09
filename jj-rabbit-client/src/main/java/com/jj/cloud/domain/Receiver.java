package com.jj.cloud.domain;

public class Receiver {
    private Integer id;

    private Integer rsid;

    private String rsname;

    private String rsport;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRsid() {
        return rsid;
    }

    public void setRsid(Integer rsid) {
        this.rsid = rsid;
    }

    public String getRsname() {
        return rsname;
    }

    public void setRsname(String rsname) {
        this.rsname = rsname == null ? null : rsname.trim();
    }

    public String getRsport() {
        return rsport;
    }

    public void setRsport(String rsport) {
        this.rsport = rsport == null ? null : rsport.trim();
    }
}