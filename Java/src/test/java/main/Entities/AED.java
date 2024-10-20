package main.Entities;

public class AED {
    private Long id;
    private String name;
    private String description;
    private double latitude; //经度
    private double longitude; //纬度

    public AED(Long id) {
        this.id = id;
    }

    public AED(Long id, String name, String description, double latitude, double longitude) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }
    // 构造函数、Getter和Setter
}
