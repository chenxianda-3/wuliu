package cn.com.lingnan.pojo;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Railwayline {
    private String id;

    private String trainnum;

    private String status;

    private String transferpri;

    private String directpri;

    private String startcity;

    private String startstation;

    private String outcenter;

    private String outpici;

    private String checi;

    @JsonFormat(pattern="HH:mm:ss",timezone = "GMT+8")
    private Date starttime;

    @JsonFormat(pattern="HH:mm:ss",timezone = "GMT+8")
    private Date endtime;

    private String tianshu;

    private String inpici;

    private String intcenter;

    private String endcity;

    private String endstation;

    private String transfepici;

    private String transfercenter;

    private Double unitprice;

    private Double mileage;

    private String inputperson;

    private Date inputtime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getTrainnum() {
        return trainnum;
    }

    public void setTrainnum(String trainnum) {
        this.trainnum = trainnum == null ? null : trainnum.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getTransferpri() {
        return transferpri;
    }

    public void setTransferpri(String transferpri) {
        this.transferpri = transferpri == null ? null : transferpri.trim();
    }

    public String getDirectpri() {
        return directpri;
    }

    public void setDirectpri(String directpri) {
        this.directpri = directpri == null ? null : directpri.trim();
    }

    public String getStartcity() {
        return startcity;
    }

    public void setStartcity(String startcity) {
        this.startcity = startcity == null ? null : startcity.trim();
    }

    public String getStartstation() {
        return startstation;
    }

    public void setStartstation(String startstation) {
        this.startstation = startstation == null ? null : startstation.trim();
    }

    public String getOutcenter() {
        return outcenter;
    }

    public void setOutcenter(String outcenter) {
        this.outcenter = outcenter == null ? null : outcenter.trim();
    }

    public String getOutpici() {
        return outpici;
    }

    public void setOutpici(String outpici) {
        this.outpici = outpici == null ? null : outpici.trim();
    }

    public String getCheci() {
        return checi;
    }

    public void setCheci(String checi) {
        this.checi = checi == null ? null : checi.trim();
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

    public String getTianshu() {
        return tianshu;
    }

    public void setTianshu(String tianshu) {
        this.tianshu = tianshu == null ? null : tianshu.trim();
    }

    public String getInpici() {
        return inpici;
    }

    public void setInpici(String inpici) {
        this.inpici = inpici == null ? null : inpici.trim();
    }

    public String getIntcenter() {
        return intcenter;
    }

    public void setIntcenter(String intcenter) {
        this.intcenter = intcenter == null ? null : intcenter.trim();
    }

    public String getEndcity() {
        return endcity;
    }

    public void setEndcity(String endcity) {
        this.endcity = endcity == null ? null : endcity.trim();
    }

    public String getEndstation() {
        return endstation;
    }

    public void setEndstation(String endstation) {
        this.endstation = endstation == null ? null : endstation.trim();
    }

    public String getTransfepici() {
        return transfepici;
    }

    public void setTransfepici(String transfepici) {
        this.transfepici = transfepici == null ? null : transfepici.trim();
    }

    public String getTransfercenter() {
        return transfercenter;
    }

    public void setTransfercenter(String transfercenter) {
        this.transfercenter = transfercenter == null ? null : transfercenter.trim();
    }

    public Double getUnitprice() {
        return unitprice;
    }

    public void setUnitprice(Double unitprice) {
        this.unitprice = unitprice;
    }

    public Double getMileage() {
        return mileage;
    }

    public void setMileage(Double mileage) {
        this.mileage = mileage;
    }

    public String getInputperson() {
        return inputperson;
    }

    public void setInputperson(String inputperson) {
        this.inputperson = inputperson == null ? null : inputperson.trim();
    }

    public Date getInputtime() {
        return inputtime;
    }

    public void setInputtime(Date inputtime) {
        this.inputtime = inputtime;
    }
}