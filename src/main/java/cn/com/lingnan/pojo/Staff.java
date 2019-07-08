package cn.com.lingnan.pojo;

public class Staff {
    private String id;

    private String name;

    private String telephone;

    private String haspda;

    private String deltag;

    private String password;

    private String station;
    
    
    

    public Staff(String id, String name, String telephone, String haspda, String deltag, String password,
			String station) {
		super();
		this.id = id;
		this.name = name;
		this.telephone = telephone;
		this.haspda = haspda;
		this.deltag = deltag;
		this.password = password;
		this.station = station;
	}
    
    

	public Staff() {
		super();
	}



	public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone == null ? null : telephone.trim();
    }

    public String getHaspda() {
        return haspda;
    }

    public void setHaspda(String haspda) {
        this.haspda = haspda == null ? null : haspda.trim();
    }

    public String getDeltag() {
        return deltag;
    }

    public void setDeltag(String deltag) {
        this.deltag = deltag == null ? null : deltag.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getStation() {
        return station;
    }

    public void setStation(String station) {
        this.station = station == null ? null : station.trim();
    }

	@Override
	public String toString() {
		return "Staff [id=" + id + ", name=" + name + ", telephone=" + telephone + ", haspda=" + haspda + ", deltag="
				+ deltag + ", password=" + password + ", station=" + station + "]";
	}
    
    
    
}