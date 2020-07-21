package com.why.project.entity;

import java.math.BigDecimal;

/**
 * 现金流量对象 cash_flow
 *
 * @author maomh
 * @date 2020-06-30
 */
public class CashFlow {
    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    private Long id;

    /**
     * 销售商品、提供劳务收到的现金
     */
    private BigDecimal cfSdxj;

    /**
     * 收到的税费返还
     */
    private BigDecimal cfSffh;

    /**
     * 收到其他与经营活动有关的现金
     */
    private BigDecimal cfYgxj;

    /**
     * 经营活动现金流入小计
     */
    private BigDecimal cfJyxjxj;

    /**
     * 收到其他与经营活动有关的现金
     */
    private BigDecimal cfJyhdxj;

    /**
     * 支付给职工以及为职工支付的现金
     */
    private BigDecimal cfZgzfxj;

    /**
     * 支付的各项税费
     */
    private BigDecimal cfGxsf;

    /**
     * 支付其他与经营活动有关的现金
     */
    private BigDecimal cfZfhdxj;

    /**
     * 经营活动现金流出小计
     */
    private BigDecimal cfJylcxj;

    /**
     * 经营活动产生的现金流量净额
     */
    private BigDecimal cfJyxjje;

    /**
     * 收回投资收到的现金
     */
    private BigDecimal cfHstzxj;

    /**
     * 取得投资收益收到的现金
     */
    private BigDecimal cfQdsdxj;

    /**
     * 处置固定资产、无形资产和其他长期资产所收回的现金净
     */
    private BigDecimal cfCqhsxj;

    /**
     * 处置子公司及其他营业单位收回的现金净额
     */
    private BigDecimal cfCzhsxj;

    /**
     * 收到其他与投资活动有关的现金
     */
    private BigDecimal cfSdygxj;

    /**
     * 投资活动现金流入小计
     */
    private BigDecimal cfTzlrxj;

    /**
     * 购建固定资产、无形资产和其他长期资产所支付的现金
     */
    private BigDecimal cfGdzcxj;

    /**
     * 取得投资收益收到的现金
     */
    private BigDecimal cfQdtzsyxj;

    /**
     * 取得子公司及其他营业单位支付的现金净额
     */
    private BigDecimal cfZgszfxj;

    /**
     * 支付其他与投资活动有关的现金
     */
    private BigDecimal cfZftzhdxj;

    /**
     * 投资活动现金流出小计
     */
    private BigDecimal cfTzhdlcxj;

    /**
     * 投资活动产生的现金流量净额
     */
    private BigDecimal cfTzcsxjje;

    /**
     * 吸收投资收到的现金
     */
    private BigDecimal cfXstzxj;

    /**
     * 取得借款收到的现金
     */
    private BigDecimal cfQdjkxj;

    /**
     * 收到其他与筹资活动有关的现金
     */
    private BigDecimal cfSdqtxj;

    /**
     * 筹资活动现金流入小计
     */
    private BigDecimal cfCzxjxj;

    /**
     * 吸收投资收到的现金
     */
    private BigDecimal cfXstzsdxj;

    /**
     * 分配股利、利润或偿付利息支付的现金
     */
    private BigDecimal cfFpglzfxj;

    /**
     * 支付其他与筹资活动有关的现金
     */
    private BigDecimal cfZfqtygxj;

    /**
     * 支付其他与筹资活动有关的现金
     */
    private BigDecimal cfZfqthdxj;

    /**
     * 筹资活动产生的现金流量净额
     */
    private BigDecimal cfCzhdxjje;

    /**
     * 现金及现金等价物净增加额
     */
    private BigDecimal cfXjzje;

    /**
     * 期末现金及现金等价物余额
     */
    private BigDecimal cfXjdjwye;

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

    public BigDecimal getCfSdxj() {
        return cfSdxj;
    }

    public void setCfSdxj(BigDecimal cfSdxj) {
        this.cfSdxj = cfSdxj;
    }

    public BigDecimal getCfSffh() {
        return cfSffh;
    }

    public void setCfSffh(BigDecimal cfSffh) {
        this.cfSffh = cfSffh;
    }

    public BigDecimal getCfYgxj() {
        return cfYgxj;
    }

    public void setCfYgxj(BigDecimal cfYgxj) {
        this.cfYgxj = cfYgxj;
    }

    public BigDecimal getCfJyxjxj() {
        return cfJyxjxj;
    }

    public void setCfJyxjxj(BigDecimal cfJyxjxj) {
        this.cfJyxjxj = cfJyxjxj;
    }

    public BigDecimal getCfJyhdxj() {
        return cfJyhdxj;
    }

    public void setCfJyhdxj(BigDecimal cfJyhdxj) {
        this.cfJyhdxj = cfJyhdxj;
    }

    public BigDecimal getCfZgzfxj() {
        return cfZgzfxj;
    }

    public void setCfZgzfxj(BigDecimal cfZgzfxj) {
        this.cfZgzfxj = cfZgzfxj;
    }

    public BigDecimal getCfGxsf() {
        return cfGxsf;
    }

    public void setCfGxsf(BigDecimal cfGxsf) {
        this.cfGxsf = cfGxsf;
    }

    public BigDecimal getCfZfhdxj() {
        return cfZfhdxj;
    }

    public void setCfZfhdxj(BigDecimal cfZfhdxj) {
        this.cfZfhdxj = cfZfhdxj;
    }

    public BigDecimal getCfJylcxj() {
        return cfJylcxj;
    }

    public void setCfJylcxj(BigDecimal cfJylcxj) {
        this.cfJylcxj = cfJylcxj;
    }

    public BigDecimal getCfJyxjje() {
        return cfJyxjje;
    }

    public void setCfJyxjje(BigDecimal cfJyxjje) {
        this.cfJyxjje = cfJyxjje;
    }

    public BigDecimal getCfHstzxj() {
        return cfHstzxj;
    }

    public void setCfHstzxj(BigDecimal cfHstzxj) {
        this.cfHstzxj = cfHstzxj;
    }

    public BigDecimal getCfQdsdxj() {
        return cfQdsdxj;
    }

    public void setCfQdsdxj(BigDecimal cfQdsdxj) {
        this.cfQdsdxj = cfQdsdxj;
    }

    public BigDecimal getCfCqhsxj() {
        return cfCqhsxj;
    }

    public void setCfCqhsxj(BigDecimal cfCqhsxj) {
        this.cfCqhsxj = cfCqhsxj;
    }

    public BigDecimal getCfCzhsxj() {
        return cfCzhsxj;
    }

    public void setCfCzhsxj(BigDecimal cfCzhsxj) {
        this.cfCzhsxj = cfCzhsxj;
    }

    public BigDecimal getCfSdygxj() {
        return cfSdygxj;
    }

    public void setCfSdygxj(BigDecimal cfSdygxj) {
        this.cfSdygxj = cfSdygxj;
    }

    public BigDecimal getCfTzlrxj() {
        return cfTzlrxj;
    }

    public void setCfTzlrxj(BigDecimal cfTzlrxj) {
        this.cfTzlrxj = cfTzlrxj;
    }

    public BigDecimal getCfGdzcxj() {
        return cfGdzcxj;
    }

    public void setCfGdzcxj(BigDecimal cfGdzcxj) {
        this.cfGdzcxj = cfGdzcxj;
    }

    public BigDecimal getCfQdtzsyxj() {
        return cfQdtzsyxj;
    }

    public void setCfQdtzsyxj(BigDecimal cfQdtzsyxj) {
        this.cfQdtzsyxj = cfQdtzsyxj;
    }

    public BigDecimal getCfZgszfxj() {
        return cfZgszfxj;
    }

    public void setCfZgszfxj(BigDecimal cfZgszfxj) {
        this.cfZgszfxj = cfZgszfxj;
    }

    public BigDecimal getCfZftzhdxj() {
        return cfZftzhdxj;
    }

    public void setCfZftzhdxj(BigDecimal cfZftzhdxj) {
        this.cfZftzhdxj = cfZftzhdxj;
    }

    public BigDecimal getCfTzhdlcxj() {
        return cfTzhdlcxj;
    }

    public void setCfTzhdlcxj(BigDecimal cfTzhdlcxj) {
        this.cfTzhdlcxj = cfTzhdlcxj;
    }

    public BigDecimal getCfTzcsxjje() {
        return cfTzcsxjje;
    }

    public void setCfTzcsxjje(BigDecimal cfTzcsxjje) {
        this.cfTzcsxjje = cfTzcsxjje;
    }

    public BigDecimal getCfXstzxj() {
        return cfXstzxj;
    }

    public void setCfXstzxj(BigDecimal cfXstzxj) {
        this.cfXstzxj = cfXstzxj;
    }

    public BigDecimal getCfQdjkxj() {
        return cfQdjkxj;
    }

    public void setCfQdjkxj(BigDecimal cfQdjkxj) {
        this.cfQdjkxj = cfQdjkxj;
    }

    public BigDecimal getCfSdqtxj() {
        return cfSdqtxj;
    }

    public void setCfSdqtxj(BigDecimal cfSdqtxj) {
        this.cfSdqtxj = cfSdqtxj;
    }

    public BigDecimal getCfCzxjxj() {
        return cfCzxjxj;
    }

    public void setCfCzxjxj(BigDecimal cfCzxjxj) {
        this.cfCzxjxj = cfCzxjxj;
    }

    public BigDecimal getCfXstzsdxj() {
        return cfXstzsdxj;
    }

    public void setCfXstzsdxj(BigDecimal cfXstzsdxj) {
        this.cfXstzsdxj = cfXstzsdxj;
    }

    public BigDecimal getCfFpglzfxj() {
        return cfFpglzfxj;
    }

    public void setCfFpglzfxj(BigDecimal cfFpglzfxj) {
        this.cfFpglzfxj = cfFpglzfxj;
    }

    public BigDecimal getCfZfqtygxj() {
        return cfZfqtygxj;
    }

    public void setCfZfqtygxj(BigDecimal cfZfqtygxj) {
        this.cfZfqtygxj = cfZfqtygxj;
    }

    public BigDecimal getCfZfqthdxj() {
        return cfZfqthdxj;
    }

    public void setCfZfqthdxj(BigDecimal cfZfqthdxj) {
        this.cfZfqthdxj = cfZfqthdxj;
    }

    public BigDecimal getCfCzhdxjje() {
        return cfCzhdxjje;
    }

    public void setCfCzhdxjje(BigDecimal cfCzhdxjje) {
        this.cfCzhdxjje = cfCzhdxjje;
    }

    public BigDecimal getCfXjzje() {
        return cfXjzje;
    }

    public void setCfXjzje(BigDecimal cfXjzje) {
        this.cfXjzje = cfXjzje;
    }

    public BigDecimal getCfXjdjwye() {
        return cfXjdjwye;
    }

    public void setCfXjdjwye(BigDecimal cfXjdjwye) {
        this.cfXjdjwye = cfXjdjwye;
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

    public CashFlow(BigDecimal cfSdxj, BigDecimal cfSffh, BigDecimal cfYgxj, BigDecimal cfJyxjxj, BigDecimal cfJyhdxj, BigDecimal cfZgzfxj, BigDecimal cfGxsf, BigDecimal cfZfhdxj, BigDecimal cfJylcxj, BigDecimal cfJyxjje, BigDecimal cfHstzxj, BigDecimal cfQdsdxj, BigDecimal cfCqhsxj, BigDecimal cfCzhsxj, BigDecimal cfSdygxj, BigDecimal cfTzlrxj, BigDecimal cfGdzcxj, BigDecimal cfQdtzsyxj, BigDecimal cfZgszfxj, BigDecimal cfZftzhdxj, BigDecimal cfTzhdlcxj, BigDecimal cfTzcsxjje, BigDecimal cfXstzxj, BigDecimal cfQdjkxj, BigDecimal cfSdqtxj, BigDecimal cfCzxjxj, BigDecimal cfXstzsdxj, BigDecimal cfFpglzfxj, BigDecimal cfZfqtygxj, BigDecimal cfZfqthdxj, BigDecimal cfCzhdxjje, BigDecimal cfXjzje, BigDecimal cfXjdjwye) {
        this.cfSdxj = cfSdxj;
        this.cfSffh = cfSffh;
        this.cfYgxj = cfYgxj;
        this.cfJyxjxj = cfJyxjxj;
        this.cfJyhdxj = cfJyhdxj;
        this.cfZgzfxj = cfZgzfxj;
        this.cfGxsf = cfGxsf;
        this.cfZfhdxj = cfZfhdxj;
        this.cfJylcxj = cfJylcxj;
        this.cfJyxjje = cfJyxjje;
        this.cfHstzxj = cfHstzxj;
        this.cfQdsdxj = cfQdsdxj;
        this.cfCqhsxj = cfCqhsxj;
        this.cfCzhsxj = cfCzhsxj;
        this.cfSdygxj = cfSdygxj;
        this.cfTzlrxj = cfTzlrxj;
        this.cfGdzcxj = cfGdzcxj;
        this.cfQdtzsyxj = cfQdtzsyxj;
        this.cfZgszfxj = cfZgszfxj;
        this.cfZftzhdxj = cfZftzhdxj;
        this.cfTzhdlcxj = cfTzhdlcxj;
        this.cfTzcsxjje = cfTzcsxjje;
        this.cfXstzxj = cfXstzxj;
        this.cfQdjkxj = cfQdjkxj;
        this.cfSdqtxj = cfSdqtxj;
        this.cfCzxjxj = cfCzxjxj;
        this.cfXstzsdxj = cfXstzsdxj;
        this.cfFpglzfxj = cfFpglzfxj;
        this.cfZfqtygxj = cfZfqtygxj;
        this.cfZfqthdxj = cfZfqthdxj;
        this.cfCzhdxjje = cfCzhdxjje;
        this.cfXjzje = cfXjzje;
        this.cfXjdjwye = cfXjdjwye;
    }
}
