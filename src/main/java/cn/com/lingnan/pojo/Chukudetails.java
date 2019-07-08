package cn.com.lingnan.pojo;

import java.util.Date;

public class Chukudetails {
    private String workorderId;

    private String chukubillId;

    private String combinebillId;

    private Double weight;

    private Double vol;

    private Date scantime;

    private String productname;

    private String shouhuopeople;

    private String shouhuoaddress;

    private Integer timelimit;

    private String destination;

    public Chukudetails(String workorderId, String chukubillId, String combinebillId, Double weight,
			String productname, String shouhuopeople, String shouhuoaddress, Integer timelimit, String destination) {
		super();
		this.workorderId = workorderId;
		this.chukubillId = chukubillId;
		this.combinebillId = combinebillId;
		this.weight = weight;
		this.productname = productname;
		this.shouhuopeople = shouhuopeople;
		this.shouhuoaddress = shouhuoaddress;
		this.timelimit = timelimit;
		this.destination = destination;
	}

    
	public Chukudetails() {
		super();
		// TODO 自动生成的构造函数存根
	}


	public String getWorkorderId() {
        return workorderId;
    }

    public void setWorkorderId(String workorderId) {
        this.workorderId = workorderId == null ? null : workorderId.trim();
    }

    public String getChukubillId() {
        return chukubillId;
    }

    public void setChukubillId(String chukubillId) {
        this.chukubillId = chukubillId == null ? null : chukubillId.trim();
    }

    public String getCombinebillId() {
        return combinebillId;
    }

    public void setCombinebillId(String combinebillId) {
        this.combinebillId = combinebillId == null ? null : combinebillId.trim();
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public Double getVol() {
        return vol;
    }

    public void setVol(Double vol) {
        this.vol = vol;
    }

    public Date getScantime() {
        return scantime;
    }

    public void setScantime(Date scantime) {
        this.scantime = scantime;
    }

    public String getProductname() {
        return productname;
    }

    public void setProductname(String productname) {
        this.productname = productname == null ? null : productname.trim();
    }

    public String getShouhuopeople() {
        return shouhuopeople;
    }

    public void setShouhuopeople(String shouhuopeople) {
        this.shouhuopeople = shouhuopeople == null ? null : shouhuopeople.trim();
    }

    public String getShouhuoaddress() {
        return shouhuoaddress;
    }

    public void setShouhuoaddress(String shouhuoaddress) {
        this.shouhuoaddress = shouhuoaddress == null ? null : shouhuoaddress.trim();
    }

    public Integer getTimelimit() {
        return timelimit;
    }

    public void setTimelimit(Integer timelimit) {
        this.timelimit = timelimit;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination == null ? null : destination.trim();
    }
}