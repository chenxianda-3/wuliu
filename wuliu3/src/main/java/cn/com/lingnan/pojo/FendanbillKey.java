package cn.com.lingnan.pojo;

public class FendanbillKey {
    private String workorderId;

    private String transfercenter;

    public FendanbillKey() {
		super();
		// TODO 自动生成的构造函数存根
	}

	public FendanbillKey(String workorderId, String transfercenter) {
		super();
		this.workorderId = workorderId;
		this.transfercenter = transfercenter;
	}

	public String getWorkorderId() {
        return workorderId;
    }

    public void setWorkorderId(String workorderId) {
        this.workorderId = workorderId == null ? null : workorderId.trim();
    }

    public String getTransfercenter() {
        return transfercenter;
    }

    public void setTransfercenter(String transfercenter) {
        this.transfercenter = transfercenter == null ? null : transfercenter.trim();
    }
}