package com.why.project.entity;

import java.math.BigDecimal;

/**
 * 收入支出对象 income_expenditure
 *
 * @author maomh
 * @date 2020-07-02
 */
public class IncomeExpenditure {
    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    private Long id;

    /**
     * 财政补助支出
     */
    private BigDecimal ieCzbzzc;

    /**
     * 财政补助收入
     */
    private BigDecimal ieCzbzsr;

    /**
     * 本期财政补助结转结余
     */
    private BigDecimal ieBqczbz;

    /**
     * 财政补助结转
     */
    private BigDecimal ieCzbzjz;

    /**
     * 财政补助结转结余
     */
    private BigDecimal ieCzbzjy;

    /**
     * 科研收入
     */
    private BigDecimal ieKysr;

    /**
     * 科研成本
     */
    private BigDecimal ieKycb;

    /**
     * 科研结余
     */
    private BigDecimal ieKyjy;

    /**
     * 其他业务收入
     */
    private BigDecimal ieQtywsr;

    /**
     * 其他业务成本
     */
    private BigDecimal ieQtywcb;

    /**
     * 其他业务税金及附加
     */
    private BigDecimal ieQtywsj;

    /**
     * 其他业务结余
     */
    private BigDecimal ieQtywjy;

    /**
     * 其他收入
     */
    private BigDecimal ieQtsr;

    /**
     * 其他支出
     */
    private BigDecimal ieQtzc;

    /**
     * 财政补助结转结余
     */
    private BigDecimal ieCzbzjzjy;

    /**
     * 事业结余
     */
    private BigDecimal ieSyjy;

    /**
     * 非财政补助结余
     */
    private BigDecimal ieFczbzjy;

    /**
     * 可分配非财政补助结余
     */
    private BigDecimal ieKfpfczjy;

    /**
     * 应缴结余
     */
    private BigDecimal ieYjjy;

    /**
     * 提取专用基金
     */
    private BigDecimal ieTqzyjj;

    /**
     * 转入事业基金
     */
    private BigDecimal ieZrsyjj;

    /**
     * 会计期间 表示月份
     */
    private String cfKjq;

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

    public BigDecimal getIeCzbzzc() {
        return ieCzbzzc;
    }

    public void setIeCzbzzc(BigDecimal ieCzbzzc) {
        this.ieCzbzzc = ieCzbzzc;
    }

    public BigDecimal getIeCzbzsr() {
        return ieCzbzsr;
    }

    public void setIeCzbzsr(BigDecimal ieCzbzsr) {
        this.ieCzbzsr = ieCzbzsr;
    }

    public BigDecimal getIeBqczbz() {
        return ieBqczbz;
    }

    public void setIeBqczbz(BigDecimal ieBqczbz) {
        this.ieBqczbz = ieBqczbz;
    }

    public BigDecimal getIeCzbzjz() {
        return ieCzbzjz;
    }

    public void setIeCzbzjz(BigDecimal ieCzbzjz) {
        this.ieCzbzjz = ieCzbzjz;
    }

    public BigDecimal getIeCzbzjy() {
        return ieCzbzjy;
    }

    public void setIeCzbzjy(BigDecimal ieCzbzjy) {
        this.ieCzbzjy = ieCzbzjy;
    }

    public BigDecimal getIeKysr() {
        return ieKysr;
    }

    public void setIeKysr(BigDecimal ieKysr) {
        this.ieKysr = ieKysr;
    }

    public BigDecimal getIeKycb() {
        return ieKycb;
    }

    public void setIeKycb(BigDecimal ieKycb) {
        this.ieKycb = ieKycb;
    }

    public BigDecimal getIeKyjy() {
        return ieKyjy;
    }

    public void setIeKyjy(BigDecimal ieKyjy) {
        this.ieKyjy = ieKyjy;
    }

    public BigDecimal getIeQtywsr() {
        return ieQtywsr;
    }

    public void setIeQtywsr(BigDecimal ieQtywsr) {
        this.ieQtywsr = ieQtywsr;
    }

    public BigDecimal getIeQtywcb() {
        return ieQtywcb;
    }

    public void setIeQtywcb(BigDecimal ieQtywcb) {
        this.ieQtywcb = ieQtywcb;
    }

    public BigDecimal getIeQtywsj() {
        return ieQtywsj;
    }

    public void setIeQtywsj(BigDecimal ieQtywsj) {
        this.ieQtywsj = ieQtywsj;
    }

    public BigDecimal getIeQtywjy() {
        return ieQtywjy;
    }

    public void setIeQtywjy(BigDecimal ieQtywjy) {
        this.ieQtywjy = ieQtywjy;
    }

    public BigDecimal getIeQtsr() {
        return ieQtsr;
    }

    public void setIeQtsr(BigDecimal ieQtsr) {
        this.ieQtsr = ieQtsr;
    }

    public BigDecimal getIeQtzc() {
        return ieQtzc;
    }

    public void setIeQtzc(BigDecimal ieQtzc) {
        this.ieQtzc = ieQtzc;
    }

    public BigDecimal getIeCzbzjzjy() {
        return ieCzbzjzjy;
    }

    public void setIeCzbzjzjy(BigDecimal ieCzbzjzjy) {
        this.ieCzbzjzjy = ieCzbzjzjy;
    }

    public BigDecimal getIeSyjy() {
        return ieSyjy;
    }

    public void setIeSyjy(BigDecimal ieSyjy) {
        this.ieSyjy = ieSyjy;
    }

    public BigDecimal getIeFczbzjy() {
        return ieFczbzjy;
    }

    public void setIeFczbzjy(BigDecimal ieFczbzjy) {
        this.ieFczbzjy = ieFczbzjy;
    }

    public BigDecimal getIeKfpfczjy() {
        return ieKfpfczjy;
    }

    public void setIeKfpfczjy(BigDecimal ieKfpfczjy) {
        this.ieKfpfczjy = ieKfpfczjy;
    }

    public BigDecimal getIeYjjy() {
        return ieYjjy;
    }

    public void setIeYjjy(BigDecimal ieYjjy) {
        this.ieYjjy = ieYjjy;
    }

    public BigDecimal getIeTqzyjj() {
        return ieTqzyjj;
    }

    public void setIeTqzyjj(BigDecimal ieTqzyjj) {
        this.ieTqzyjj = ieTqzyjj;
    }

    public BigDecimal getIeZrsyjj() {
        return ieZrsyjj;
    }

    public void setIeZrsyjj(BigDecimal ieZrsyjj) {
        this.ieZrsyjj = ieZrsyjj;
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

    public IncomeExpenditure(BigDecimal ieCzbzzc, BigDecimal ieCzbzsr, BigDecimal ieBqczbz, BigDecimal ieCzbzjz, BigDecimal ieCzbzjy, BigDecimal ieKysr, BigDecimal ieKycb, BigDecimal ieKyjy, BigDecimal ieQtywsr, BigDecimal ieQtywcb, BigDecimal ieQtywsj, BigDecimal ieQtywjy, BigDecimal ieQtsr, BigDecimal ieQtzc, BigDecimal ieCzbzjzjy, BigDecimal ieSyjy, BigDecimal ieFczbzjy, BigDecimal ieKfpfczjy, BigDecimal ieYjjy, BigDecimal ieTqzyjj, BigDecimal ieZrsyjj) {
        this.ieCzbzzc = ieCzbzzc;
        this.ieCzbzsr = ieCzbzsr;
        this.ieBqczbz = ieBqczbz;
        this.ieCzbzjz = ieCzbzjz;
        this.ieCzbzjy = ieCzbzjy;
        this.ieKysr = ieKysr;
        this.ieKycb = ieKycb;
        this.ieKyjy = ieKyjy;
        this.ieQtywsr = ieQtywsr;
        this.ieQtywcb = ieQtywcb;
        this.ieQtywsj = ieQtywsj;
        this.ieQtywjy = ieQtywjy;
        this.ieQtsr = ieQtsr;
        this.ieQtzc = ieQtzc;
        this.ieCzbzjzjy = ieCzbzjzjy;
        this.ieSyjy = ieSyjy;
        this.ieFczbzjy = ieFczbzjy;
        this.ieKfpfczjy = ieKfpfczjy;
        this.ieYjjy = ieYjjy;
        this.ieTqzyjj = ieTqzyjj;
        this.ieZrsyjj = ieZrsyjj;
    }
}
