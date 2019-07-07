package cn.com.lingnan.pojo;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Qianshoubill extends QianshoubillKey {
    private String qianshoupeople;

    private String staffId;

    private String staffname;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date qianshoutime;

    public Qianshoubill(String workorderId, String deliveryunit, String qianshoupeople, String staffId,
			String staffname, Date qianshoutime, String type) {
		super(workorderId, deliveryunit);
		this.qianshoupeople = qianshoupeople;
		this.staffId = staffId;
		this.staffname = staffname;
		this.qianshoutime = qianshoutime;
		this.type = type;
	}

	public Qianshoubill() {
		super();
		// TODO 自动生成的构造函数存根
	}

	public Qianshoubill(String workorderId, String deliveryunit) {
		super(workorderId, deliveryunit);
		// TODO 自动生成的构造函数存根
	}

	private String type;

    public String getQianshoupeople() {
        return qianshoupeople;
    }

    public void setQianshoupeople(String qianshoupeople) {
        this.qianshoupeople = qianshoupeople == null ? null : qianshoupeople.trim();
    }

    public String getStaffId() {
        return staffId;
    }

    public void setStaffId(String staffId) {
        this.staffId = staffId == null ? null : staffId.trim();
    }

    public String getStaffname() {
        return staffname;
    }

    public void setStaffname(String staffname) {
        this.staffname = staffname == null ? null : staffname.trim();
    }

    public Date getQianshoutime() {
        return qianshoutime;
    }

    public void setQianshoutime(Date qianshoutime) {
        this.qianshoutime = qianshoutime;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }
}