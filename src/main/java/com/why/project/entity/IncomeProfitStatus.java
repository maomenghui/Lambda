package com.why.project.entity;

import java.math.BigDecimal;

/**
 * 收入利润情况月报采集卡对象 income_profit_status
 *
 * @author maomh
 * @date 2020-07-07
 */
public class IncomeProfitStatus {
    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    private Long id;

    /**
     * 营业收入
     */
    private BigDecimal ipsYysr;

    /**
     * 其中：宇航产品收入
     */
    private BigDecimal ipsYhcpsr;

    /**
     * 营业成本
     */
    private BigDecimal ipsYycb;

    /**
     * 其中：宇航产品成本
     */
    private BigDecimal ipsYhcpcb;

    /**
     * 税金及附加
     */
    private BigDecimal ipsSjjfj;

    /**
     * 管理费用
     */
    private BigDecimal ipsGlfy;

    /**
     * 业务招待费
     */
    private BigDecimal ipsYwzdf;

    /**
     * 差旅费
     */
    private BigDecimal ipsClfy;

    /**
     * 办公费
     */
    private BigDecimal ipsBgf;

    /**
     * 财务费用
     */
    private BigDecimal ipsCwfy;

    /**
     * 其中：利息支出
     */
    private BigDecimal ipsLxzc;

    /**
     * 利息收入
     */
    private BigDecimal ipsLxsr;

    /**
     * 投资收益
     */
    private BigDecimal ipsTzsy;

    /**
     * 其他收益
     */
    private BigDecimal ipsQtsr;

    /**
     * 营业利润
     */
    private BigDecimal ipsYylr;

    /**
     * 营业外收入
     */
    private BigDecimal ipsYywsr;

    /**
     * 营业外支出
     */
    private BigDecimal ipsYywzc;

    /**
     * 利润总额
     */
    private BigDecimal ipsLrze;

    /**
     * 归属于母公司所有者的净利润
     */
    private BigDecimal ipsGsymgslr;

    /**
     * 会计期间 表示月份
     */
    private String cfKjq;

    /**
     * 会计年度 表示年度
     */
    private String cfKjnd;

    public IncomeProfitStatus(BigDecimal ipsYysr, BigDecimal ipsYhcpsr, BigDecimal ipsYycb, BigDecimal ipsYhcpcb, BigDecimal ipsSjjfj, BigDecimal ipsGlfy, BigDecimal ipsYwzdf, BigDecimal ipsClfy, BigDecimal ipsBgf, BigDecimal ipsCwfy, BigDecimal ipsLxzc, BigDecimal ipsLxsr, BigDecimal ipsTzsy, BigDecimal ipsQtsr, BigDecimal ipsYylr, BigDecimal ipsYywsr, BigDecimal ipsYywzc, BigDecimal ipsLrze, BigDecimal ipsGsymgslr) {
        this.ipsYysr = ipsYysr;
        this.ipsYhcpsr = ipsYhcpsr;
        this.ipsYycb = ipsYycb;
        this.ipsYhcpcb = ipsYhcpcb;
        this.ipsSjjfj = ipsSjjfj;
        this.ipsGlfy = ipsGlfy;
        this.ipsYwzdf = ipsYwzdf;
        this.ipsClfy = ipsClfy;
        this.ipsBgf = ipsBgf;
        this.ipsCwfy = ipsCwfy;
        this.ipsLxzc = ipsLxzc;
        this.ipsLxsr = ipsLxsr;
        this.ipsTzsy = ipsTzsy;
        this.ipsQtsr = ipsQtsr;
        this.ipsYylr = ipsYylr;
        this.ipsYywsr = ipsYywsr;
        this.ipsYywzc = ipsYywzc;
        this.ipsLrze = ipsLrze;
        this.ipsGsymgslr = ipsGsymgslr;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getIpsYysr() {
        return ipsYysr;
    }

    public void setIpsYysr(BigDecimal ipsYysr) {
        this.ipsYysr = ipsYysr;
    }

    public BigDecimal getIpsYhcpsr() {
        return ipsYhcpsr;
    }

    public void setIpsYhcpsr(BigDecimal ipsYhcpsr) {
        this.ipsYhcpsr = ipsYhcpsr;
    }

    public BigDecimal getIpsYycb() {
        return ipsYycb;
    }

    public void setIpsYycb(BigDecimal ipsYycb) {
        this.ipsYycb = ipsYycb;
    }

    public BigDecimal getIpsYhcpcb() {
        return ipsYhcpcb;
    }

    public void setIpsYhcpcb(BigDecimal ipsYhcpcb) {
        this.ipsYhcpcb = ipsYhcpcb;
    }

    public BigDecimal getIpsSjjfj() {
        return ipsSjjfj;
    }

    public void setIpsSjjfj(BigDecimal ipsSjjfj) {
        this.ipsSjjfj = ipsSjjfj;
    }

    public BigDecimal getIpsGlfy() {
        return ipsGlfy;
    }

    public void setIpsGlfy(BigDecimal ipsGlfy) {
        this.ipsGlfy = ipsGlfy;
    }

    public BigDecimal getIpsYwzdf() {
        return ipsYwzdf;
    }

    public void setIpsYwzdf(BigDecimal ipsYwzdf) {
        this.ipsYwzdf = ipsYwzdf;
    }

    public BigDecimal getIpsClfy() {
        return ipsClfy;
    }

    public void setIpsClfy(BigDecimal ipsClfy) {
        this.ipsClfy = ipsClfy;
    }

    public BigDecimal getIpsBgf() {
        return ipsBgf;
    }

    public void setIpsBgf(BigDecimal ipsBgf) {
        this.ipsBgf = ipsBgf;
    }

    public BigDecimal getIpsCwfy() {
        return ipsCwfy;
    }

    public void setIpsCwfy(BigDecimal ipsCwfy) {
        this.ipsCwfy = ipsCwfy;
    }

    public BigDecimal getIpsLxzc() {
        return ipsLxzc;
    }

    public void setIpsLxzc(BigDecimal ipsLxzc) {
        this.ipsLxzc = ipsLxzc;
    }

    public BigDecimal getIpsLxsr() {
        return ipsLxsr;
    }

    public void setIpsLxsr(BigDecimal ipsLxsr) {
        this.ipsLxsr = ipsLxsr;
    }

    public BigDecimal getIpsTzsy() {
        return ipsTzsy;
    }

    public void setIpsTzsy(BigDecimal ipsTzsy) {
        this.ipsTzsy = ipsTzsy;
    }

    public BigDecimal getIpsQtsr() {
        return ipsQtsr;
    }

    public void setIpsQtsr(BigDecimal ipsQtsr) {
        this.ipsQtsr = ipsQtsr;
    }

    public BigDecimal getIpsYylr() {
        return ipsYylr;
    }

    public void setIpsYylr(BigDecimal ipsYylr) {
        this.ipsYylr = ipsYylr;
    }

    public BigDecimal getIpsYywsr() {
        return ipsYywsr;
    }

    public void setIpsYywsr(BigDecimal ipsYywsr) {
        this.ipsYywsr = ipsYywsr;
    }

    public BigDecimal getIpsYywzc() {
        return ipsYywzc;
    }

    public void setIpsYywzc(BigDecimal ipsYywzc) {
        this.ipsYywzc = ipsYywzc;
    }

    public BigDecimal getIpsLrze() {
        return ipsLrze;
    }

    public void setIpsLrze(BigDecimal ipsLrze) {
        this.ipsLrze = ipsLrze;
    }

    public BigDecimal getIpsGsymgslr() {
        return ipsGsymgslr;
    }

    public void setIpsGsymgslr(BigDecimal ipsGsymgslr) {
        this.ipsGsymgslr = ipsGsymgslr;
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
