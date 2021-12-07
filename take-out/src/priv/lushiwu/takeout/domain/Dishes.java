package priv.lushiwu.takeout.domain;

import java.time.LocalDate;

/**
 * @Author: lushiwu
 * @Date 2021/12/6 17:51
 */
public class Dishes {
    private String dId;
    private String dName;
    private String dType;
    private LocalDate dTime;
    private double price;
    private int dSales;
    private int dStocks;

    public Dishes() {
    }

    public Dishes(String dId, String dName, String dType, LocalDate dTime, double price, int dSales, int dStocks) {
        this.dId = dId;
        this.dName = dName;
        this.dType = dType;
        this.dTime = dTime;
        this.price = price;
        this.dSales = dSales;
        this.dStocks = dStocks;
    }

    public String getdId() {
        return dId;
    }

    public void setdId(String dId) {
        this.dId = dId;
    }

    public String getdName() {
        return dName;
    }

    public void setdName(String dName) {
        this.dName = dName;
    }

    public String getdType() {
        return dType;
    }

    public void setdType(String dType) {
        this.dType = dType;
    }

    public LocalDate getdTime() {
        return dTime;
    }

    public void setdTime(LocalDate dTime) {
        this.dTime = dTime;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getdSales() {
        return dSales;
    }

    public void setdSales(int dSales) {
        this.dSales = dSales;
    }

    public int getdStocks() {
        return dStocks;
    }

    public void setdStocks(int dStocks) {
        this.dStocks = dStocks;
    }

    @Override
    public String toString() {
        return "Dishes{" +
                "菜品ID='" + dId + '\'' +
                ", 菜品名='" + dName + '\'' +
                ", 菜品类型='" + dType + '\'' +
                ", 上架时间=" + dTime +
                ", 单价=" + price +
                ", 月销量=" + dSales +
                ", 总数量=" + dStocks +
                '}';
    }
}
