package cn.com.lingnan.pojo;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Noticebill {
    private String id;

    private String staffId;

    private String userId;

    private String customerName;

    private String delegater;

    private String telephone;

    private String pickaddress;

    private String arrivecity;

    private String product;
    
    private Date pickdate;

    private Double weight;

    private String volume;

    private String remark;

    private String ordertype;
    
    private  String station;
    //分单类型 0自动 1人工
    public  final  static  String ORDERTYPE_AUTO="0";
    public  final  static  String ORDERTYPE_MAN="1";

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getStaffId() {
        return staffId;
    }

    public void setStaffId(String staffId) {
        this.staffId = staffId == null ? null : staffId.trim();
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName == null ? null : customerName.trim();
    }

    public String getDelegater() {
        return delegater;
    }

    public void setDelegater(String delegater) {
        this.delegater = delegater == null ? null : delegater.trim();
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone == null ? null : telephone.trim();
    }

    public String getPickaddress() {
        return pickaddress;
    }

    public void setPickaddress(String pickaddress) {
        this.pickaddress = pickaddress == null ? null : pickaddress.trim();
    }

    public String getArrivecity() {
        return arrivecity;
    }

    public void setArrivecity(String arrivecity) {
        this.arrivecity = arrivecity == null ? null : arrivecity.trim();
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product == null ? null : product.trim();
    }

    public Date getPickdate() {
        return pickdate;
    }

    public void setPickdate(Date pickdate) {
        this.pickdate = pickdate;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public String getVolume() {
        return volume;
    }

    public void setVolume(String volume) {
        this.volume = volume == null ? null : volume.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public String getOrdertype() {
        return ordertype;
    }

    public void setOrdertype(String ordertype) {
        this.ordertype = ordertype == null ? null : ordertype.trim();
    }

	@Override
	public String toString() {
		return "Noticebill [id=" + id + ", staffId=" + staffId + ", userId=" + userId + ", customerName=" + customerName
				+ ", delegater=" + delegater + ", telephone=" + telephone + ", pickaddress=" + pickaddress
				+ ", arrivecity=" + arrivecity + ", product=" + product + ", pickdate=" + pickdate + ", weight="
				+ weight + ", volume=" + volume + ", remark=" + remark + ", ordertype=" + ordertype + "]";
	}

	public String getStation() {
		return station;
	}

	public void setStation(String station) {
		this.station = station;
	}
}