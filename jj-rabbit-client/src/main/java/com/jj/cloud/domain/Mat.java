package com.jj.cloud.domain;

import java.io.Serializable;

public class Mat  implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer id;

    private String barcode;

    private String nationalcode;

    private String name;

    private String spec;

    private String gb;

    private String lx;

    private String manuf;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode == null ? null : barcode.trim();
    }

    public String getNationalcode() {
        return nationalcode;
    }

    public void setNationalcode(String nationalcode) {
        this.nationalcode = nationalcode == null ? null : nationalcode.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getSpec() {
        return spec;
    }

    public void setSpec(String spec) {
        this.spec = spec == null ? null : spec.trim();
    }

    public String getGb() {
        return gb;
    }

    public void setGb(String gb) {
        this.gb = gb == null ? null : gb.trim();
    }

    public String getLx() {
        return lx;
    }

    public void setLx(String lx) {
        this.lx = lx == null ? null : lx.trim();
    }

    public String getManuf() {
        return manuf;
    }

    public void setManuf(String manuf) {
        this.manuf = manuf == null ? null : manuf.trim();
    }

	@Override
	public String toString() {
		return "Mat [id=" + id + ", barcode=" + barcode + ", nationalcode=" + nationalcode + ", name=" + name
				+ ", spec=" + spec + ", gb=" + gb + ", lx=" + lx + ", manuf=" + manuf + "]";
	}
    
    
}