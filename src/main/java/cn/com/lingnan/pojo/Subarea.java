package cn.com.lingnan.pojo;

public class Subarea {
    private String id;

    private String decidedzoneId;

    private String regionId;

    private String addresskey;

    private String position;

    private String startnum;

    private String endnum;

    private String single;
    
    private  Region region;
    
    private  Decidedzone decidedzone;
    
    

    public Subarea(String id, String decidedzoneId, String regionId, String addresskey, String position,
			String startnum, String endnum, String single) {
		super();
		this.id = id;
		this.decidedzoneId = decidedzoneId;
		this.regionId = regionId;
		this.addresskey = addresskey;
		this.position = position;
		this.startnum = startnum;
		this.endnum = endnum;
		this.single = single;
	}
    
    
    

	public Subarea() {
		super();
	}




	public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getDecidedzoneId() {
        return decidedzoneId;
    }

    public void setDecidedzoneId(String decidedzoneId) {
        this.decidedzoneId = decidedzoneId == null ? null : decidedzoneId.trim();
    }

    public String getRegionId() {
        return regionId;
    }

    public void setRegionId(String regionId) {
        this.regionId = regionId == null ? null : regionId.trim();
    }

    public String getAddresskey() {
        return addresskey;
    }

    public void setAddresskey(String addresskey) {
        this.addresskey = addresskey == null ? null : addresskey.trim();
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position == null ? null : position.trim();
    }

    public String getStartnum() {
        return startnum;
    }

    public void setStartnum(String startnum) {
        this.startnum = startnum == null ? null : startnum.trim();
    }

    public String getEndnum() {
        return endnum;
    }

    public void setEndnum(String endnum) {
        this.endnum = endnum == null ? null : endnum.trim();
    }

    public String getSingle() {
        return single;
    }

    public void setSingle(String single) {
        this.single = single == null ? null : single.trim();
    }

	public Region getRegion() {
		return region;
	}

	public void setRegion(Region region) {
		this.region = region;
	}




	@Override
	public String toString() {
		return "Subarea [id=" + id + ", decidedzoneId=" + decidedzoneId + ", regionId=" + regionId + ", addresskey="
				+ addresskey + ", position=" + position + ", startnum=" + startnum + ", endnum=" + endnum + ", single="
				+ single + ", region=" + region + ", decidedzone=" + decidedzone + "]";
	}




	public Decidedzone getDecidedzone() {
		return decidedzone;
	}




	public void setDecidedzone(Decidedzone decidedzone) {
		this.decidedzone = decidedzone;
	}





	
	
}