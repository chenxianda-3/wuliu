package cn.com.lingnan.pojo;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Fendanbill extends FendanbillKey {
    private String deliveryunitId;

    private Integer timelimit;

    private String inpici;

    private String address;

    private String status;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date fendantime;

    private String fendanpeople;
    
   

	public Fendanbill(String workorderId, String transfercenter, String deliveryunitId, Integer timelimit,
			String inpici, String address, String status, Date fendantime, String fendanpeople) {
		super(workorderId, transfercenter);
		this.deliveryunitId = deliveryunitId;
		this.timelimit = timelimit;
		this.inpici = inpici;
		this.address = address;
		this.status = status;
		this.fendantime = fendantime;
		this.fendanpeople = fendanpeople;
	}

	public Fendanbill() {
		super();
		// TODO 自动生成的构造函数存根
	}

	public Fendanbill(String workorderId, String transfercenter) {
		super(workorderId, transfercenter);
		// TODO 自动生成的构造函数存根
	}

	public String getDeliveryunitId() {
        return deliveryunitId;
    }

    public void setDeliveryunitId(String deliveryunitId) {
        this.deliveryunitId = deliveryunitId == null ? null : deliveryunitId.trim();
    }

    public Integer getTimelimit() {
        return timelimit;
    }

    public void setTimelimit(Integer timelimit) {
        this.timelimit = timelimit;
    }

    public String getInpici() {
        return inpici;
    }

    public void setInpici(String inpici) {
        this.inpici = inpici == null ? null : inpici.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public Date getFendantime() {
        return fendantime;
    }

    public void setFendantime(Date fendantime) {
        this.fendantime = fendantime;
    }

    public String getFendanpeople() {
        return fendanpeople;
    }

    public void setFendanpeople(String fendanpeople) {
        this.fendanpeople = fendanpeople == null ? null : fendanpeople.trim();
    }
}