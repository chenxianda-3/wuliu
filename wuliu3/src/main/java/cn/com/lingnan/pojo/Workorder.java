package cn.com.lingnan.pojo;

import java.util.Date;

public class Workorder {
    private String id;

    private String sendername;

    private String senderphone;

    private String senderaddr;

    private String receivername;

    private String receiverphone;

    private String receiveraddr;

    private String product;

    private String state;

    private Integer num;

    private Double weight;

    private String floadreqr;

    private Double actlweit;

    private String vol;

    private String managercheck;

    private Date updatetime;

    private String station;
    
    public  final static String PEISONG="1";
    public  final static String CANCELQIANSHOU="2";
    public  final static String QIANSHOU="3";

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getSendername() {
        return sendername;
    }

    public void setSendername(String sendername) {
        this.sendername = sendername == null ? null : sendername.trim();
    }

    public String getSenderphone() {
        return senderphone;
    }

    public void setSenderphone(String senderphone) {
        this.senderphone = senderphone == null ? null : senderphone.trim();
    }

    public String getSenderaddr() {
        return senderaddr;
    }

    public void setSenderaddr(String senderaddr) {
        this.senderaddr = senderaddr == null ? null : senderaddr.trim();
    }

    public String getReceivername() {
        return receivername;
    }

    public void setReceivername(String receivername) {
        this.receivername = receivername == null ? null : receivername.trim();
    }

    public String getReceiverphone() {
        return receiverphone;
    }

    public void setReceiverphone(String receiverphone) {
        this.receiverphone = receiverphone == null ? null : receiverphone.trim();
    }

    public String getReceiveraddr() {
        return receiveraddr;
    }

    public void setReceiveraddr(String receiveraddr) {
        this.receiveraddr = receiveraddr == null ? null : receiveraddr.trim();
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product == null ? null : product.trim();
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state == null ? null : state.trim();
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public String getFloadreqr() {
        return floadreqr;
    }

    public void setFloadreqr(String floadreqr) {
        this.floadreqr = floadreqr == null ? null : floadreqr.trim();
    }

    public Double getActlweit() {
        return actlweit;
    }

    public void setActlweit(Double actlweit) {
        this.actlweit = actlweit;
    }

    public String getVol() {
        return vol;
    }

    public void setVol(String vol) {
        this.vol = vol == null ? null : vol.trim();
    }

    public String getManagercheck() {
        return managercheck;
    }

    public void setManagercheck(String managercheck) {
        this.managercheck = managercheck == null ? null : managercheck.trim();
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }

    public String getStation() {
        return station;
    }

    public void setStation(String station) {
        this.station = station == null ? null : station.trim();
    }
}