package cn.com.lingnan.pojo;

public class Peizaiinfo {
    private String workorderId;

    private String combineId;

    private String operateunit;

    private String peizaiway;

    private String lineId;

    private String product;

    private Integer jiangshu;

    private Double weight;

    private String endcity;

    public Peizaiinfo(String workorderId, String combineId, String operateunit, String lineId, String endcity,
			Integer timelimit, String peizai, String shouhuopeople, String shouhuoaddress,String peizaiway) {
		super();
		this.workorderId = workorderId;
		this.combineId = combineId;
		this.operateunit = operateunit;
		this.lineId = lineId;
		this.endcity = endcity;
		this.timelimit = timelimit;
		this.peizai = peizai;
		this.shouhuopeople = shouhuopeople;
		this.shouhuoaddress = shouhuoaddress;
		this.peizaiway=peizaiway;
	}

    
	public Peizaiinfo() {
		super();
		// TODO 自动生成的构造函数存根
	}


	private Integer timelimit;

    private String peizai;

    private String shouhuopeople;

    private String shouhuoaddress;

    public String getWorkorderId() {
        return workorderId;
    }

    public void setWorkorderId(String workorderId) {
        this.workorderId = workorderId == null ? null : workorderId.trim();
    }

    public String getCombineId() {
        return combineId;
    }

    public void setCombineId(String combineId) {
        this.combineId = combineId == null ? null : combineId.trim();
    }

    public String getOperateunit() {
        return operateunit;
    }

    public void setOperateunit(String operateunit) {
        this.operateunit = operateunit == null ? null : operateunit.trim();
    }

    public String getPeizaiway() {
        return peizaiway;
    }

    public void setPeizaiway(String peizaiway) {
        this.peizaiway = peizaiway == null ? null : peizaiway.trim();
    }

    public String getLineId() {
        return lineId;
    }

    public void setLineId(String lineId) {
        this.lineId = lineId == null ? null : lineId.trim();
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product == null ? null : product.trim();
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

    public String getEndcity() {
        return endcity;
    }

    public void setEndcity(String endcity) {
        this.endcity = endcity == null ? null : endcity.trim();
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

    public String getShouhuopeople() {
        return shouhuopeople;
    }

    public void setShouhuopeople(String shouhuopeople) {
        this.shouhuopeople = shouhuopeople == null ? null : shouhuopeople.trim();
    }

    public String getShouhuoaddress() {
        return shouhuoaddress;
    }

    public void setShouhuoaddress(String shouhuoaddress) {
        this.shouhuoaddress = shouhuoaddress == null ? null : shouhuoaddress.trim();
    }
}