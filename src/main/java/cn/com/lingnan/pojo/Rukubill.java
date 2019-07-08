package cn.com.lingnan.pojo;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Rukubill {
    private String id;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date jiehuotime;

    private String jiehuopeople;

    private String jiehuostation;

    private String fahuopeople;

    private String fahuostation;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public Date getJiehuotime() {
        return jiehuotime;
    }

    public void setJiehuotime(Date jiehuotime) {
        this.jiehuotime = jiehuotime;
    }

    public String getJiehuopeople() {
        return jiehuopeople;
    }

    public void setJiehuopeople(String jiehuopeople) {
        this.jiehuopeople = jiehuopeople == null ? null : jiehuopeople.trim();
    }

    public String getJiehuostation() {
        return jiehuostation;
    }

    public void setJiehuostation(String jiehuostation) {
        this.jiehuostation = jiehuostation == null ? null : jiehuostation.trim();
    }

    public String getFahuopeople() {
        return fahuopeople;
    }

    public void setFahuopeople(String fahuopeople) {
        this.fahuopeople = fahuopeople == null ? null : fahuopeople.trim();
    }

    public String getFahuostation() {
        return fahuostation;
    }

    public void setFahuostation(String fahuostation) {
        this.fahuostation = fahuostation == null ? null : fahuostation.trim();
    }

	@Override
	public String toString() {
		return "Rukubill [id=" + id + ", jiehuotime=" + jiehuotime + ", jiehuopeople=" + jiehuopeople
				+ ", jiehuostation=" + jiehuostation + ", fahuopeople=" + fahuopeople + ", fahuostation=" + fahuostation
				+ "]";
	}
}