package cn.ziyang.domain;

import java.util.Date;

public class Log {
    private int id;
    private String name;
    private Date time;
    private String url;
    private int cost;

    public Log() {
    }

    public Log(int id, String name, Date time, String url, int cost) {
        this.id = id;
        this.name = name;
        this.time = time;
        this.url = url;
        this.cost = cost;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "Log{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", time=" + time +
                ", url='" + url + '\'' +
                ", cost=" + cost +
                '}';
    }
}
