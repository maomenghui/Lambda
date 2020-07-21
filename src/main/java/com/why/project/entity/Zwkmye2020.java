package com.why.project.entity;


import java.math.BigDecimal;

/**
 * 利润对象 zwkmye_2020
 *
 * @author maomh
 * @date 2020-06-23
 */
public class Zwkmye2020 {
    private static final long serialVersionUID = 1L;

    /**
     * 单位编号
     */
    private String zwkmyeDwbh;

    /**
     * 科目编号
     */
    private String zwkmyeKmbh;

    /**
     * 借方发生
     */
    private BigDecimal zwkmyeJffs;

    /**
     * 贷方发生
     */
    private BigDecimal zwkmyeDffs;

    /**
     * 借方累计
     */
    private String zwkmyeJflj;

    /**
     * 贷方累计
     */
    private String zwkmyeDflj;

    /**
     * 当期余额
     */
    private BigDecimal zwkmyeDqye;

    /**
     * 会计期间 表示月份
     */
    private String zwkmyeKjq;

    /**
     * 会计年度 表示年度
     */
    private String zwkmyeKjnd;

    /**
     * 年初余额
     */
    private Double zwkmyeNcye;

    public String getZwkmyeDwbh() {
        return zwkmyeDwbh;
    }

    public void setZwkmyeDwbh(String zwkmyeDwbh) {
        this.zwkmyeDwbh = zwkmyeDwbh;
    }

    public String getZwkmyeKmbh() {
        return zwkmyeKmbh;
    }

    public void setZwkmyeKmbh(String zwkmyeKmbh) {
        this.zwkmyeKmbh = zwkmyeKmbh;
    }

    public BigDecimal getZwkmyeJffs() {
        return zwkmyeJffs;
    }

    public void setZwkmyeJffs(BigDecimal zwkmyeJffs) {
        this.zwkmyeJffs = zwkmyeJffs;
    }

    public BigDecimal getZwkmyeDffs() {
        return zwkmyeDffs;
    }

    public void setZwkmyeDffs(BigDecimal zwkmyeDffs) {
        this.zwkmyeDffs = zwkmyeDffs;
    }

    public String getZwkmyeJflj() {
        return zwkmyeJflj;
    }

    public void setZwkmyeJflj(String zwkmyeJflj) {
        this.zwkmyeJflj = zwkmyeJflj;
    }

    public String getZwkmyeDflj() {
        return zwkmyeDflj;
    }

    public void setZwkmyeDflj(String zwkmyeDflj) {
        this.zwkmyeDflj = zwkmyeDflj;
    }

    public BigDecimal getZwkmyeDqye() {
        return zwkmyeDqye;
    }

    public void setZwkmyeDqye(BigDecimal zwkmyeDqye) {
        this.zwkmyeDqye = zwkmyeDqye;
    }

    public String getZwkmyeKjq() {
        return zwkmyeKjq;
    }

    public void setZwkmyeKjq(String zwkmyeKjq) {
        this.zwkmyeKjq = zwkmyeKjq;
    }

    public String getZwkmyeKjnd() {
        return zwkmyeKjnd;
    }

    public void setZwkmyeKjnd(String zwkmyeKjnd) {
        this.zwkmyeKjnd = zwkmyeKjnd;
    }

    public Double getZwkmyeNcye() {
        return zwkmyeNcye;
    }

    public void setZwkmyeNcye(Double zwkmyeNcye) {
        this.zwkmyeNcye = zwkmyeNcye;
    }

    @Override
    public String toString() {
        return "Zwkmye2020{" +
                "zwkmyeDwbh='" + zwkmyeDwbh + '\'' +
                ", zwkmyeKmbh='" + zwkmyeKmbh + '\'' +
                ", zwkmyeJffs=" + zwkmyeJffs +
                ", zwkmyeDffs=" + zwkmyeDffs +
                ", zwkmyeJflj='" + zwkmyeJflj + '\'' +
                ", zwkmyeDflj='" + zwkmyeDflj + '\'' +
                ", zwkmyeDqye=" + zwkmyeDqye +
                ", zwkmyeKjq='" + zwkmyeKjq + '\'' +
                ", zwkmyeKjnd='" + zwkmyeKjnd + '\'' +
                ", zwkmyeNcye=" + zwkmyeNcye +
                '}';
    }
}
