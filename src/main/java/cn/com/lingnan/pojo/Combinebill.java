package cn.com.lingnan.pojo;

public class Combinebill {
    private String id;

    private String combinepeople;

    private String sealId;

    private String destination;

    private String countDestination;

    private Integer timelimit;

    private Integer piaoshu;

    private Integer jiangshu;

    private Double weight;

    private Double vol;

    private String status;

    private String peizai;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getCombinepeople() {
        return combinepeople;
    }

    public void setCombinepeople(String combinepeople) {
        this.combinepeople = combinepeople == null ? null : combinepeople.trim();
    }

    public String getSealId() {
        return sealId;
    }

    public void setSealId(String sealId) {
        this.sealId = sealId == null ? null : sealId.trim();
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination == null ? null : destination.trim();
    }

    public String getCountDestination() {
        return countDestination;
    }

    public void setCountDestination(String countDestination) {
        this.countDestination = countDestination == null ? null : countDestination.trim();
    }

    public Integer getTimelimit() {
        return timelimit;
    }

    public void setTimelimit(Integer timelimit) {
        this.timelimit = timelimit;
    }

    public Integer getPiaoshu() {
        return piaoshu;
    }

    public void setPiaoshu(Integer piaoshu) {
        this.piaoshu = piaoshu;
    }

    public Integer getJiangshu() {
        return jiangshu;
    }

    public void setJiangshu(Integer jiangshu) {
        this.jiangshu = jiangshu;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getPeizai() {
        return peizai;
    }

    public void setPeizai(String peizai) {
        this.peizai = peizai == null ? null : peizai.trim();
    }
}