package cn.com.lingnan.pojo;

public class QianshoubillKey {
    private String workorderId;

    private String deliveryunit;

    public String getWorkorderId() {
        return workorderId;
    }

    public QianshoubillKey() {
		super();
		// TODO 自动生成的构造函数存根
	}

	public QianshoubillKey(String workorderId, String deliveryunit) {
		super();
		this.workorderId = workorderId;
		this.deliveryunit = deliveryunit;
	}

	public void setWorkorderId(String workorderId) {
        this.workorderId = workorderId == null ? null : workorderId.trim();
    }

    public String getDeliveryunit() {
        return deliveryunit;
    }

    public void setDeliveryunit(String deliveryunit) {
        this.deliveryunit = deliveryunit == null ? null : deliveryunit.trim();
    }
}