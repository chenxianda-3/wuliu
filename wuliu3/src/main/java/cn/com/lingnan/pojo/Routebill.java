package cn.com.lingnan.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Routebill implements Cloneable {
    private String id;

    private String name;

    private String flag;

    private String startprovince;

    private String startcity;

    private String startdistrict;

    private String endprovince;

    private String endcity;

    private String enddistrict;

    private String timelimit;

    private String transfernode1;

    private String transfernode2;

    private String transfernode3;

    private String transfernode4;
    
    private List<Routelinebill> routelinebills= new ArrayList<>();

    
    @JsonFormat(pattern="HH:mm:ss",timezone = "GMT+8")
    private Date starttime;

    @JsonFormat(pattern="HH:mm:ss",timezone = "GMT+8")
    private Date endtime;

    private Double mileage=0.0;

    private Double routeprice=0.0;

    private String priority;

    private Double weight=0.0;

    private Double vol=0.0;
    
    private long sumDuration;
    
    private static final long nd = 1000 * 24 * 60 * 60;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag == null ? null : flag.trim();
    }

    public String getStartprovince() {
        return startprovince;
    }

    public void setStartprovince(String startprovince) {
        this.startprovince = startprovince == null ? null : startprovince.trim();
    }

    public String getStartcity() {
        return startcity;
    }

    public void setStartcity(String startcity) {
        this.startcity = startcity == null ? null : startcity.trim();
    }

    public String getStartdistrict() {
        return startdistrict;
    }

    public void setStartdistrict(String startdistrict) {
        this.startdistrict = startdistrict == null ? null : startdistrict.trim();
    }

    public String getEndprovince() {
        return endprovince;
    }

    public void setEndprovince(String endprovince) {
        this.endprovince = endprovince == null ? null : endprovince.trim();
    }

    public String getEndcity() {
        return endcity;
    }

    public void setEndcity(String endcity) {
        this.endcity = endcity == null ? null : endcity.trim();
    }

    public String getEnddistrict() {
        return enddistrict;
    }

    public void setEnddistrict(String enddistrict) {
        this.enddistrict = enddistrict == null ? null : enddistrict.trim();
    }

    public String getTimelimit() {
    	long ms = sumDuration;
    	
    	long tianshu = ms/nd;
    	if (ms%nd!=0) {
			tianshu++;
		}
    	this.timelimit=String.valueOf(tianshu);
        return timelimit;
    }

    public void setTimelimit(String timelimit) {
        this.timelimit = timelimit == null ? null : timelimit.trim();
    }

    public String getTransfernode1() {
        return transfernode1;
    }

    public void setTransfernode1(String transfernode1) {
        this.transfernode1 = transfernode1 == null ? null : transfernode1.trim();
    }

    public String getTransfernode2() {
        return transfernode2;
    }

    public void setTransfernode2(String transfernode2) {
        this.transfernode2 = transfernode2 == null ? null : transfernode2.trim();
    }

    public String getTransfernode3() {
        return transfernode3;
    }

    public void setTransfernode3(String transfernode3) {
        this.transfernode3 = transfernode3 == null ? null : transfernode3.trim();
    }

    public String getTransfernode4() {
        return transfernode4;
    }

    public void setTransfernode4(String transfernode4) {
        this.transfernode4 = transfernode4 == null ? null : transfernode4.trim();
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

    public Double getMileage() {
        return mileage;
    }

    public void setMileage(Double mileage) {
        this.mileage = mileage;
    }

    public Double getRouteprice() {
        return routeprice;
    }

    public void setRouteprice(Double routeprice) {
        this.routeprice = routeprice;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority == null ? null : priority.trim();
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
    
    @Override
	public Routebill clone()  {
		Object object=null;
		try {
			object=super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		Routebill routebill=(Routebill)object;
		if (routebill.getStarttime()!=null) {
			routebill.starttime=(Date) routebill.getStarttime().clone();
		}
		if (routebill.getEndtime()!=null) {
			routebill.endtime=(Date) routebill.getEndtime().clone();
		}
		
		if (routelinebills!=null) {
			routebill.setRoutelinebills(new ArrayList<>(routelinebills));
			
		}
		
		return routebill;
	}




	
	public long getSumDuration() {
		
		return sumDuration;
	}

	public void setSumDuration(long sumDuration) {
		this.sumDuration = sumDuration;
	}

	@Override
	public String toString() {
		return "Routebill [id=" + id + ", name=" + name + ", flag=" + flag + ", startprovince=" + startprovince
				+ ", startcity=" + startcity + ", startdistrict=" + startdistrict + ", endprovince=" + endprovince
				+ ", endcity=" + endcity + ", enddistrict=" + enddistrict + ", timelimit=" + timelimit
				+ ", transfernode1=" + transfernode1 + ", transfernode2=" + transfernode2 + ", transfernode3="
				+ transfernode3 + ", transfernode4=" + transfernode4 + ", routelinebills=" + routelinebills
				+ ", starttime=" + starttime + ", endtime=" + endtime + ", mileage=" + mileage + ", routeprice="
				+ routeprice + ", priority=" + priority + ", weight=" + weight + ", vol=" + vol + ", sumDuration="
				+ sumDuration + "]";
	}

	public List<Routelinebill> getRoutelinebills() {
		return routelinebills;
	}

	public void setRoutelinebills(List<Routelinebill> routelinebills) {
		this.routelinebills = routelinebills;
	}

}