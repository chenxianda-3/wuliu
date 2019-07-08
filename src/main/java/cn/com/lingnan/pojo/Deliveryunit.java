package cn.com.lingnan.pojo;

public class Deliveryunit {
    private String id;

    private String name;

    private String address;

    private String fuzepeople;

    private String transfercenter;

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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getFuzepeople() {
        return fuzepeople;
    }

    public void setFuzepeople(String fuzepeople) {
        this.fuzepeople = fuzepeople == null ? null : fuzepeople.trim();
    }

    public String getTransfercenter() {
        return transfercenter;
    }

    public void setTransfercenter(String transfercenter) {
        this.transfercenter = transfercenter == null ? null : transfercenter.trim();
    }
}