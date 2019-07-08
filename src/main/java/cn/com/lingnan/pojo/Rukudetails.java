package cn.com.lingnan.pojo;

public class Rukudetails {
    private String workorderId;

    private String rukubillId;

    private String combinebillId;

    private Double weight;

    private String chukubillId;

    private String status;
    
    
    private  Workorder workorder;

    
    
    
    public String getWorkorderId() {
        return workorderId;
    }

    public void setWorkorderId(String workorderId) {
        this.workorderId = workorderId == null ? null : workorderId.trim();
    }

    public String getRukubillId() {
        return rukubillId;
    }

    public void setRukubillId(String rukubillId) {
        this.rukubillId = rukubillId == null ? null : rukubillId.trim();
    }


    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public String getChukubillId() {
        return chukubillId;
    }

    public void setChukubillId(String chukubillId) {
        this.chukubillId = chukubillId == null ? null : chukubillId.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }



	public Workorder getWorkorder() {
		return workorder;
	}

	public void setWorkorder(Workorder workorder) {
		this.workorder = workorder;
	}

	public String getCombinebillId() {
		return combinebillId;
	}

	public void setCombinebillId(String combinebillId) {
		this.combinebillId = combinebillId;
	}

	@Override
	public String toString() {
		return "Rukudetails [workorderId=" + workorderId + ", rukubillId=" + rukubillId + ", combinebillId="
				+ combinebillId + ", weight=" + weight + ", chukubillId=" + chukubillId + ", status=" + status
				+ ", workorder=" + workorder + "]";
	}

	
}