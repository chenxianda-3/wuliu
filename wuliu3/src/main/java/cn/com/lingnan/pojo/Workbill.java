package cn.com.lingnan.pojo;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Workbill {
    private String id;

    private String noticebillId;

    private String type;

    private String pickstate;


    @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
    private Date buildtime;

    private Integer attachbilltimes;

    private String remark;

    private String staffId;

    private String pickaddress;

    @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
    private Date picktime;

    private String station;
    
   private  Staff staff;
    
    private  Noticebill noticebill;

    public Workbill() {
		super();
		// TODO 自动生成的构造函数存根
	}

	public Workbill(String id, String noticebillId, String type, String pickstate, Date buildtime,
			Integer attachbilltimes, String remark, String staffId, String pickaddress, Date picktime, String station) {
		super();
		this.id = id;
		this.noticebillId = noticebillId;
		this.type = type;
		this.pickstate = pickstate;
		this.buildtime = buildtime;
		this.attachbilltimes = attachbilltimes;
		this.remark = remark;
		this.staffId = staffId;
		this.pickaddress = pickaddress;
		this.picktime = picktime;
		this.station = station;
	}

	
	public static final String  NEW_BILL = "1";
	public static final String  ATTACH_BILL = "2";
	public static final String  EDIT_BILL = "3";
	public static final String  DELETE_BILL = "4";
	
	 /*未发送短信:没有确认货物状态的,pickstate=1
    已通知:自动下单下发短信,pickstate=2
    已确认:接到短信,回复收信确认信息,pickstate=3
    已取件:已经取件成功,发回确认信息,生成工作单,pickstate=4
    已取消:销单,pickstate=5*/
	
	public static final String  PICKSTATE_NEW = "1";
	public static final String  PICKSTATE_TONGZHI = "2";
	public static final String  PICKSTATE_QUEREN = "3";
	public static final String  PICKSTATE_QUJIAN = "4";
	public static final String  PICKSTATE_QUXIAO = "5";
	
	
	
	public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getNoticebillId() {
        return noticebillId;
    }

    public void setNoticebillId(String noticebillId) {
        this.noticebillId = noticebillId == null ? null : noticebillId.trim();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public String getPickstate() {
        return pickstate;
    }

    public void setPickstate(String pickstate) {
        this.pickstate = pickstate == null ? null : pickstate.trim();
    }

    public Date getBuildtime() {
        return buildtime;
    }

    public void setBuildtime(Date buildtime) {
        this.buildtime = buildtime;
    }

    public Integer getAttachbilltimes() {
        return attachbilltimes;
    }

    public void setAttachbilltimes(Integer attachbilltimes) {
        this.attachbilltimes = attachbilltimes;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public String getStaffId() {
        return staffId;
    }

    public void setStaffId(String staffId) {
        this.staffId = staffId == null ? null : staffId.trim();
    }

    public String getPickaddress() {
        return pickaddress;
    }

    public void setPickaddress(String pickaddress) {
        this.pickaddress = pickaddress == null ? null : pickaddress.trim();
    }

    public Date getPicktime() {
        return picktime;
    }

    public void setPicktime(Date picktime) {
        this.picktime = picktime;
    }

    public String getStation() {
        return station;
    }

    public void setStation(String station) {
        this.station = station == null ? null : station.trim();
    }

	@Override
	public String toString() {
		return "Workbill [id=" + id + ", noticebillId=" + noticebillId + ", type=" + type + ", pickstate=" + pickstate
				+ ", buildtime=" + buildtime + ", attachbilltimes=" + attachbilltimes + ", remark=" + remark
				+ ", staffId=" + staffId + ", pickaddress=" + pickaddress + ", picktime=" + picktime + ", station="
				+ station + "]";
	}

	public Staff getStaff() {
		return staff;
	}

	public void setStaff(Staff staff) {
		this.staff = staff;
	}

	public Noticebill getNoticebill() {
		return noticebill;
	}

	public void setNoticebill(Noticebill noticebill) {
		this.noticebill = noticebill;
	}
}