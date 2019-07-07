package cn.com.lingnan.pojo;

public class Combinedetails {
    private String workorderId;

    private String combineorderId;

    private String productname;

    private String destination;

    private Integer jianshu;

    public Combinedetails(String workorderId, String combineorderId, String productname, String destination,
			Integer jianshu, Double weight, String peizai) {
		super();
		this.workorderId = workorderId;
		this.combineorderId = combineorderId;
		this.productname = productname;
		this.destination = destination;
		this.jianshu = jianshu;
		this.weight = weight;
		this.peizai = peizai;
	}
    
    

	public Combinedetails() {
		super();
		// TODO 自动生成的构造函数存根
	}



	private Double vol;

    private Double weight;

    private Integer timelimit;

    private String peizai;

    public String getWorkorderId() {
        return workorderId;
    }

    public void setWorkorderId(String workorderId) {
        this.workorderId = workorderId == null ? null : workorderId.trim();
    }

    public String getCombineorderId() {
        return combineorderId;
    }

    public void setCombineorderId(String combineorderId) {
        this.combineorderId = combineorderId == null ? null : combineorderId.trim();
    }

    public String getProductname() {
        return productname;
    }

    public void setProductname(String productname) {
        this.productname = productname == null ? null : productname.trim();
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination == null ? null : destination.trim();
    }

    public Integer getJianshu() {
        return jianshu;
    }

    public void setJianshu(Integer jianshu) {
        this.jianshu = jianshu;
    }

    public Double getVol() {
        return vol;
    }

    public void setVol(Double vol) {
        this.vol = vol;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public Integer getTimelimit() {
        return timelimit;
    }

    public void setTimelimit(Integer timelimit) {
        this.timelimit = timelimit;
    }

    public String getPeizai() {
        return peizai;
    }

    public void setPeizai(String peizai) {
        this.peizai = peizai == null ? null : peizai.trim();
    }
}