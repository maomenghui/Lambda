package com.why.project.entity;


import org.apache.ibatis.annotations.Mapper;

import java.math.BigDecimal;

/**
 * 事业单位收入结余情况月报采集卡对象 income_balance
 *
 * @author maomh
 * @date 2020-07-06
 */
public class IncomeBalance {
    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    private Long id;

    /**
     * 财政补助收入
     */
    private BigDecimal ibCzbzsr;

    /**
     * 离退休人员费用
     */
    private BigDecimal ibLtxfy;

    /**
     * 科研收入
     */
    private BigDecimal ibKysr;

    /**
     * 其他业务收入
     */
    private BigDecimal ibQtywsr;

    /**
     * 其他收入
     */
    private BigDecimal ibQtsr;

    /**
     * 利息收入
     */
    private BigDecimal ibLxsr;

    /**
     * 财政补助支出
     */
    private BigDecimal ibCzbzzc;

    /**
     * 科研成本支出
     */
    private BigDecimal ibKycbzc;

    /**
     * 技术成本支出、税金及附加
     */
    private BigDecimal ibJscbzc;

    /**
     * 其他业务成本支出
     */
    private BigDecimal ibQtywcb;

    /**
     * 其他支出
     */
    private BigDecimal ibQtzc;

    /**
     * 会计期间 表示月份
     */
    private String cfKjq;

    public IncomeBalance(BigDecimal ibCzbzsr, BigDecimal ibLtxfy, BigDecimal ibKysr, BigDecimal ibQtywsr, BigDecimal ibQtsr, BigDecimal ibLxsr, BigDecimal ibCzbzzc, BigDecimal ibKycbzc, BigDecimal ibJscbzc, BigDecimal ibQtywcb, BigDecimal ibQtzc) {
        this.ibCzbzsr = ibCzbzsr;
        this.ibLtxfy = ibLtxfy;
        this.ibKysr = ibKysr;
        this.ibQtywsr = ibQtywsr;
        this.ibQtsr = ibQtsr;
        this.ibLxsr = ibLxsr;
        this.ibCzbzzc = ibCzbzzc;
        this.ibKycbzc = ibKycbzc;
        this.ibJscbzc = ibJscbzc;
        this.ibQtywcb = ibQtywcb;
        this.ibQtzc = ibQtzc;
    }

    /**
     * 会计年度 表示年度
     */
    private String cfKjnd;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getIbCzbzsr() {
        return ibCzbzsr;
    }

    public void setIbCzbzsr(BigDecimal ibCzbzsr) {
        this.ibCzbzsr = ibCzbzsr;
    }

    public BigDecimal getIbLtxfy() {
        return ibLtxfy;
    }

    public void setIbLtxfy(BigDecimal ibLtxfy) {
        this.ibLtxfy = ibLtxfy;
    }

    public BigDecimal getIbKysr() {
        return ibKysr;
    }

    public void setIbKysr(BigDecimal ibKysr) {
        this.ibKysr = ibKysr;
    }

    public BigDecimal getIbQtywsr() {
        return ibQtywsr;
    }

    public void setIbQtywsr(BigDecimal ibQtywsr) {
        this.ibQtywsr = ibQtywsr;
    }

    public BigDecimal getIbQtsr() {
        return ibQtsr;
    }

    public void setIbQtsr(BigDecimal ibQtsr) {
        this.ibQtsr = ibQtsr;
    }

    public BigDecimal getIbLxsr() {
        return ibLxsr;
    }

    public void setIbLxsr(BigDecimal ibLxsr) {
        this.ibLxsr = ibLxsr;
    }

    public BigDecimal getIbCzbzzc() {
        return ibCzbzzc;
    }

    public void setIbCzbzzc(BigDecimal ibCzbzzc) {
        this.ibCzbzzc = ibCzbzzc;
    }

    public BigDecimal getIbKycbzc() {
        return ibKycbzc;
    }

    public void setIbKycbzc(BigDecimal ibKycbzc) {
        this.ibKycbzc = ibKycbzc;
    }

    public BigDecimal getIbJscbzc() {
        return ibJscbzc;
    }

    public void setIbJscbzc(BigDecimal ibJscbzc) {
        this.ibJscbzc = ibJscbzc;
    }

    public BigDecimal getIbQtywcb() {
        return ibQtywcb;
    }

    public void setIbQtywcb(BigDecimal ibQtywcb) {
        this.ibQtywcb = ibQtywcb;
    }

    public BigDecimal getIbQtzc() {
        return ibQtzc;
    }

    public void setIbQtzc(BigDecimal ibQtzc) {
        this.ibQtzc = ibQtzc;
    }

    public String getCfKjq() {
        return cfKjq;
    }

    public void setCfKjq(String cfKjq) {
        this.cfKjq = cfKjq;
    }

    public String getCfKjnd() {
        return cfKjnd;
    }

    public void setCfKjnd(String cfKjnd) {
        this.cfKjnd = cfKjnd;
    }

}
