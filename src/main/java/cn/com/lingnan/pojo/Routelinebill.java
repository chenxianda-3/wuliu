package cn.com.lingnan.pojo;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Routelinebill implements Cloneable {
    private String id;

    private String routebillId;

    private String startstation;

    private String endstation;

    @JsonFormat(pattern="HH:mm:ss",timezone = "GMT+8")
    private Date starttime;

    @JsonFormat(pattern="HH:mm:ss",timezone = "GMT+8")
    private Date endtime;

    private String pici;

    private String linename;

    private Double lineprice;

    private Double mileage;

    private String tianshu;
    
    private long  duration=0;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getRoutebillId() {
        return routebillId;
    }

    public void setRoutebillId(String routebillId) {
        this.routebillId = routebillId == null ? null : routebillId.trim();
    }

    public String getStartstation() {
        return startstation;
    }

    public void setStartstation(String startstation) {
        this.startstation = startstation == null ? null : startstation.trim();
    }

    public String getEndstation() {
        return endstation;
    }

    public void setEndstation(String endstation) {
        this.endstation = endstation == null ? null : endstation.trim();
    }

    public Date getStarttime() {
        return starttime;
    }

    public void setStarttime(Date starttime) {
        this.starttime = starttime;
    }

    public Date getEndtime() {
        return endtime;
    }

    public void setEndtime(Date endtime) {
        this.endtime = endtime;
    }

    public String getPici() {
        return pici;
    }

    public void setPici(String pici) {
        this.pici = pici == null ? null : pici.trim();
    }

    public String getLinename() {
        return linename;
    }

    public void setLinename(String linename) {
        this.linename = linename == null ? null : linename.trim();
    }

    public Double getLineprice() {
        return lineprice;
    }

    public void setLineprice(Double lineprice) {
        this.lineprice = lineprice;
    }

    public Double getMileage() {
        return mileage;
    }

    public void setMileage(Double mileage) {
        this.mileage = mileage;
    }

    public String getTianshu() {
        return tianshu;
    }

    public void setTianshu(String tianshu) {
        this.tianshu = tianshu == null ? null : tianshu.trim();
    }
    
    
	public long getDuration() {
		long time3=86400000;
		long time1= getEndtime().getTime();
		long time2 = getStarttime().getTime();
		long diff= (time1>time2?time1-time2:time1-time2+time3)+(Integer.parseInt(getTianshu())-1)*time3;
		return diff;
	}

	public void setDuration(long duration) {
		this.duration = duration;
	}

	@Override
	public String toString() {
		return "Routelinebill [id=" + id + ", linename=" + linename + "]";
	}
	
	

	@Override
	protected Routelinebill clone()  {
		Routelinebill routelinebill=null;
		try {
			routelinebill = (Routelinebill) super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		if (routelinebill.getStarttime()!=null) {
			routelinebill.starttime=(Date) routelinebill.getStarttime().clone();
		}
		if (routelinebill.getEndtime()!=null) {
			routelinebill.endtime=(Date) routelinebill.getEndtime().clone();
		}
		return routelinebill;
	}
}