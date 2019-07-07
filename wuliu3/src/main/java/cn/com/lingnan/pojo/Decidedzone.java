package cn.com.lingnan.pojo;

public class Decidedzone {
    private String id;

    private String staffId;

    private String regionId;

    private String name;
    
    private  Region region;
    
    private  Staff staff;

    public Decidedzone(String id, String staffId, String regionId, String name) {
		super();
		this.id = id;
		this.staffId = staffId;
		this.regionId = regionId;
		this.name = name;
	}

	public Decidedzone() {
		super();
		// TODO 自动生成的构造函数存根
	}

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

    public String getRegionId() {
        return regionId;
    }

    public void setRegionId(String regionId) {
        this.regionId = regionId == null ? null : regionId.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

	public Region getRegion() {
		return region;
	}

	public void setRegion(Region region) {
		this.region = region;
	}

	@Override
	public String toString() {
		return "Decidedzone [id=" + id + ", staffId=" + staffId + ", regionId=" + regionId + ", name=" + name
				+ ", region=" + region + ", staff=" + staff + "]";
	}

	public Staff getStaff() {
		return staff;
	}

	public void setStaff(Staff staff) {
		this.staff = staff;
	}
}