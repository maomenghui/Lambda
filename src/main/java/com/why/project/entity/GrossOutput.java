package com.why.project.entity;

import java.math.BigDecimal;

/**
 * 总产出月报采集卡对象 gross_output
 *
 * @author maomh
 * @date 2020-07-07
 */
public class GrossOutput{
    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    private Long id;

    /**
     * 总产出
     */
    private BigDecimal goZcc;

    /**
     * 科研成本借方累计发生额
     */
    private BigDecimal goKycbjflj;

    /**
     * 固定资产折旧(本年折旧）
     */
    private BigDecimal goGdzczj;

    /**
     * 营业盈余
     */
    private BigDecimal goYyyy;

    /**
     * 营业利润
     */
    private BigDecimal goTzlr;

    /**
     * 投资收益
     */
    private BigDecimal goTzsy;

    /**
     * 资产处置收益
     */
    private BigDecimal goZcczsy;

    /**
     * 其他收益
     */
    private BigDecimal goQtsy;

    /**
     * 会计期间 表示月份
     */
    private String cfKjq;

    /**
     * 会计年度 表示年度
     */
    private String cfKjnd;

    public GrossOutput(BigDecimal goZcc, BigDecimal goKycbjflj, BigDecimal goGdzczj, BigDecimal goYyyy, BigDecimal goTzlr, BigDecimal goTzsy, BigDecimal goZcczsy, BigDecimal goQtsy) {
        this.goZcc = goZcc;
        this.goKycbjflj = goKycbjflj;
        this.goGdzczj = goGdzczj;
        this.goYyyy = goYyyy;
        this.goTzlr = goTzlr;
        this.goTzsy = goTzsy;
        this.goZcczsy = goZcczsy;
        this.goQtsy = goQtsy;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getGoZcc() {
        return goZcc;
    }

    public void setGoZcc(BigDecimal goZcc) {
        this.goZcc = goZcc;
    }

    public BigDecimal getGoKycbjflj() {
        return goKycbjflj;
    }

    public void setGoKycbjflj(BigDecimal goKycbjflj) {
        this.goKycbjflj = goKycbjflj;
    }

    public BigDecimal getGoGdzczj() {
        return goGdzczj;
    }

    public void setGoGdzczj(BigDecimal goGdzczj) {
        this.goGdzczj = goGdzczj;
    }

    public BigDecimal getGoYyyy() {
        return goYyyy;
    }

    public void setGoYyyy(BigDecimal goYyyy) {
        this.goYyyy = goYyyy;
    }

    public BigDecimal getGoTzlr() {
        return goTzlr;
    }

    public void setGoTzlr(BigDecimal goTzlr) {
        this.goTzlr = goTzlr;
    }

    public BigDecimal getGoTzsy() {
        return goTzsy;
    }

    public void setGoTzsy(BigDecimal goTzsy) {
        this.goTzsy = goTzsy;
    }

    public BigDecimal getGoZcczsy() {
        return goZcczsy;
    }

    public void setGoZcczsy(BigDecimal goZcczsy) {
        this.goZcczsy = goZcczsy;
    }

    public BigDecimal getGoQtsy() {
        return goQtsy;
    }

    public void setGoQtsy(BigDecimal goQtsy) {
        this.goQtsy = goQtsy;
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
