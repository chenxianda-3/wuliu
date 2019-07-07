package cn.com.lingnan.pojo;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Chukubill {
    private String id;

    private String type;

    private String lineresource;

    private String linedirection;

    private String transportway;

    private String jiehuopeople;

    private String jiaohuopeople;


    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date jiaohuotime;

    private String jiaohuostation;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public String getLineresource() {
        return lineresource;
    }

    public void setLineresource(String lineresource) {
        this.lineresource = lineresource == null ? null : lineresource.trim();
    }

    public String getLinedirection() {
        return linedirection;
    }

    public void setLinedirection(String linedirection) {
        this.linedirection = linedirection == null ? null : linedirection.trim();
    }

    public String getTransportway() {
        return transportway;
    }

    public void setTransportway(String transportway) {
        this.transportway = transportway == null ? null : transportway.trim();
    }

    public String getJiehuopeople() {
        return jiehuopeople;
    }

    public void setJiehuopeople(String jiehuopeople) {
        this.jiehuopeople = jiehuopeople == null ? null : jiehuopeople.trim();
    }

    public String getJiaohuopeople() {
        return jiaohuopeople;
    }

    public void setJiaohuopeople(String jiaohuopeople) {
        this.jiaohuopeople = jiaohuopeople == null ? null : jiaohuopeople.trim();
    }

    public Date getJiaohuotime() {
        return jiaohuotime;
    }

    public void setJiaohuotime(Date jiaohuotime) {
        this.jiaohuotime = jiaohuotime;
    }

    public String getJiaohuostation() {
        return jiaohuostation;
    }

    public void setJiaohuostation(String jiaohuostation) {
        this.jiaohuostation = jiaohuostation == null ? null : jiaohuostation.trim();
    }
}