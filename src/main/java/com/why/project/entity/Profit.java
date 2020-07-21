package com.why.project.entity;

import java.math.BigDecimal;

/**
 * 利润对象 profit
 *
 * @author maomh
 * @date 2020-06-29
 */
public class Profit {
    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    private Long id;

    /**
     * 营业总收入
     */
    private BigDecimal pYyzsr;

    /**
     * 营业收入
     */
    private BigDecimal pYysr;

    /**
     * 营业总成本
     */
    private BigDecimal pYyzcb;

    /**
     * 营业成本
     */
    private BigDecimal pYycb;

    /**
     * 材料费
     */
    private BigDecimal pClf;

    /**
     * 外协费
     */
    private BigDecimal pWxf;

    /**
     * 税金及附加
     */
    private BigDecimal pSjjfj;

    /**
     * 管理费用
     */
    private BigDecimal pGlfy;

    /**
     * 办公费
     */
    private BigDecimal pBgf;

    /**
     * 会议费
     */
    private BigDecimal pHyf;

    /**
     * 业务招待费
     */
    private BigDecimal pYwzdf;

    /**
     * 差旅费
     */
    private BigDecimal pClfy;

    /**
     * 利息费用
     */
    private BigDecimal pLxfy;

    /**
     * 利息收入
     */
    private BigDecimal pLxsr;

    /**
     * 财务费用
     */
    private BigDecimal pCwfy;

    /**
     * 其他收益
     */
    private BigDecimal pQtsy;

    /**
     * 投资收益
     */
    private BigDecimal pTzsy;

    /**
     * 营业利润
     */
    private BigDecimal pYylr;

    /**
     * 营业外收入
     */
    private BigDecimal pYywsr;

    /**
     * 营业外支出
     */
    private BigDecimal pYywzc;

    /**
     * 利润总额
     */
    private BigDecimal pLrze;

    private String pKjq;

    private String pKjnd;

    /**
     * 净利润
     */
    private BigDecimal pJlr;

    public Profit(BigDecimal pYyzsr, BigDecimal pYysr, BigDecimal pYyzcb, BigDecimal pYycb, BigDecimal pClf, BigDecimal pWxf, BigDecimal pSjjfj, BigDecimal pGlfy, BigDecimal pBgf, BigDecimal pHyf, BigDecimal pYwzdf, BigDecimal pClfy, BigDecimal pLxfy, BigDecimal pLxsr, BigDecimal pCwfy, BigDecimal pQtsy, BigDecimal pTzsy, BigDecimal pYylr, BigDecimal pYywsr, BigDecimal pYywzc, BigDecimal pLrze, BigDecimal pJlr) {
        this.pYyzsr = pYyzsr;
        this.pYysr = pYysr;
        this.pYyzcb = pYyzcb;
        this.pYycb = pYycb;
        this.pClf = pClf;
        this.pWxf = pWxf;
        this.pSjjfj = pSjjfj;
        this.pGlfy = pGlfy;
        this.pBgf = pBgf;
        this.pHyf = pHyf;
        this.pYwzdf = pYwzdf;
        this.pClfy = pClfy;
        this.pLxfy = pLxfy;
        this.pLxsr = pLxsr;
        this.pCwfy = pCwfy;
        this.pQtsy = pQtsy;
        this.pTzsy = pTzsy;
        this.pYylr = pYylr;
        this.pYywsr = pYywsr;
        this.pYywzc = pYywzc;
        this.pLrze = pLrze;
        this.pJlr = pJlr;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getpYyzsr() {
        return pYyzsr;
    }

    public void setpYyzsr(BigDecimal pYyzsr) {
        this.pYyzsr = pYyzsr;
    }

    public BigDecimal getpYysr() {
        return pYysr;
    }

    public void setpYysr(BigDecimal pYysr) {
        this.pYysr = pYysr;
    }

    public BigDecimal getpYyzcb() {
        return pYyzcb;
    }

    public void setpYyzcb(BigDecimal pYyzcb) {
        this.pYyzcb = pYyzcb;
    }

    public BigDecimal getpYycb() {
        return pYycb;
    }

    public void setpYycb(BigDecimal pYycb) {
        this.pYycb = pYycb;
    }

    public BigDecimal getpClf() {
        return pClf;
    }

    public void setpClf(BigDecimal pClf) {
        this.pClf = pClf;
    }

    public BigDecimal getpWxf() {
        return pWxf;
    }

    public void setpWxf(BigDecimal pWxf) {
        this.pWxf = pWxf;
    }

    public BigDecimal getpSjjfj() {
        return pSjjfj;
    }

    public void setpSjjfj(BigDecimal pSjjfj) {
        this.pSjjfj = pSjjfj;
    }

    public BigDecimal getpGlfy() {
        return pGlfy;
    }

    public void setpGlfy(BigDecimal pGlfy) {
        this.pGlfy = pGlfy;
    }

    public BigDecimal getpBgf() {
        return pBgf;
    }

    public void setpBgf(BigDecimal pBgf) {
        this.pBgf = pBgf;
    }

    public BigDecimal getpHyf() {
        return pHyf;
    }

    public void setpHyf(BigDecimal pHyf) {
        this.pHyf = pHyf;
    }

    public BigDecimal getpYwzdf() {
        return pYwzdf;
    }

    public void setpYwzdf(BigDecimal pYwzdf) {
        this.pYwzdf = pYwzdf;
    }

    public BigDecimal getpClfy() {
        return pClfy;
    }

    public void setpClfy(BigDecimal pClfy) {
        this.pClfy = pClfy;
    }

    public BigDecimal getpLxfy() {
        return pLxfy;
    }

    public void setpLxfy(BigDecimal pLxfy) {
        this.pLxfy = pLxfy;
    }

    public BigDecimal getpLxsr() {
        return pLxsr;
    }

    public void setpLxsr(BigDecimal pLxsr) {
        this.pLxsr = pLxsr;
    }

    public BigDecimal getpCwfy() {
        return pCwfy;
    }

    public void setpCwfy(BigDecimal pCwfy) {
        this.pCwfy = pCwfy;
    }

    public BigDecimal getpQtsy() {
        return pQtsy;
    }

    public void setpQtsy(BigDecimal pQtsy) {
        this.pQtsy = pQtsy;
    }

    public BigDecimal getpTzsy() {
        return pTzsy;
    }

    public void setpTzsy(BigDecimal pTzsy) {
        this.pTzsy = pTzsy;
    }

    public BigDecimal getpYylr() {
        return pYylr;
    }

    public void setpYylr(BigDecimal pYylr) {
        this.pYylr = pYylr;
    }

    public BigDecimal getpYywsr() {
        return pYywsr;
    }

    public void setpYywsr(BigDecimal pYywsr) {
        this.pYywsr = pYywsr;
    }

    public BigDecimal getpYywzc() {
        return pYywzc;
    }

    public void setpYywzc(BigDecimal pYywzc) {
        this.pYywzc = pYywzc;
    }

    public BigDecimal getpLrze() {
        return pLrze;
    }

    public void setpLrze(BigDecimal pLrze) {
        this.pLrze = pLrze;
    }

    public BigDecimal getpJlr() {
        return pJlr;
    }

    public void setpJlr(BigDecimal pJlr) {
        this.pJlr = pJlr;
    }

    public String getpKjq() {
        return pKjq;
    }

    public void setpKjq(String pKjq) {
        this.pKjq = pKjq;
    }

    public String getpKjnd() {
        return pKjnd;
    }

    public void setpKjnd(String pKjnd) {
        this.pKjnd = pKjnd;
    }
}
