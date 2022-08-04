package model;

public class PhongBan {
    private int id;
    private String tenPB;

    public PhongBan(int id, String tenPB) {
        this.id = id;
        this.tenPB = tenPB;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTenPB() {
        return tenPB;
    }

    public void setTenPB(String tenPB) {
        this.tenPB = tenPB;
    }
}
