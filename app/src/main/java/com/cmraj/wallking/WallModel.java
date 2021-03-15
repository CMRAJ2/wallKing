package com.cmraj.wallking;

public class WallModel {
    private int id;
    private String large2x,medium;

    public WallModel() {
    }

    public WallModel(int id, String large2x, String medium) {
        this.id = id;
        this.large2x = large2x;
        this.medium = medium;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLarge2x() {
        return large2x;
    }

    public void setLarge(String large2x) {
        this.large2x = large2x;
    }

    public String getMedium() {
        return medium;
    }

    public void setMedium(String medium) {
        this.medium = medium;
    }
}
