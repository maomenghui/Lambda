package com.why.project.entity;

import java.math.BigDecimal;

/**
 * 资产负债对象 asset_liability_2020
 *
 * @author maomh
 * @date 2020-06-24
 */
public class AssetLiability {
    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    private Long id;
    
        
    /**
     * 应缴国库款
     */
    private BigDecimal alYjgkk;
    
    /**
     * 应缴税费
     */
    private BigDecimal alYjsf;

    /**
     * 应付职工薪酬
     */
    private BigDecimal alYfzgxc;

    /**
     * 短期借款
     */
    private BigDecimal alDqjk;

    /**
     * 应付票据
     */
    private BigDecimal alYfpj;

    /**
     * 应付账款
     */
    private BigDecimal alYfzk;

    /**
     * 预收账款
     */
    private BigDecimal alYszk;

    /**
     * 拨入科研费
     */
    private BigDecimal alBrkyf;

    /**
     * 其他流动负债
     */
    private BigDecimal alQtldfz;

    /**
     * 一年内到期的非流动负债
     */
    private BigDecimal alFldfz;

    /**
     * 其他应付款
     */
    private BigDecimal alQtyfk;

    /**
     * 拨入专款
     */
    private BigDecimal alBrzk;

    /**
     * 非流动资产基金
     */
    private BigDecimal alFldzcjj;

    /**
     * 净资产
     */
    private BigDecimal alJzc;
    
    /**
     * 固定资产
     */
    private BigDecimal alGdzc;

    /**
     * 在建工程
     */
    private BigDecimal alZjgc;

    /**
     * 长期投资
     */
    private BigDecimal alCqtz;

    /**
     * 无形资产
     */
    private BigDecimal alWxzc;
    
    /**
     * 财政补助结转
     */
    private BigDecimal alCzbzjz;

    /**
     * 财政补助结余
     */
    private BigDecimal alCzbzjy;

    /**
     * 专用基金
     */
    private BigDecimal alZyjj;

    /**
     * 事业结余
     */
    private BigDecimal alSyjy;

    /**
     * 经营结余
     */
    private BigDecimal alJyjy;

    /**
     * 负债和净资产总计
     */
    private BigDecimal alFzjzczj;

    /**
     * 会计期间 表示月份
     */
    private String alKjq;

    /**
     * 会计年度 表示年度
     */
    private String alKjnd;

    public AssetLiability() {}

    public AssetLiability(BigDecimal alYjgkk, BigDecimal alYjsf, BigDecimal alYfzgxc, BigDecimal alDqjk, BigDecimal alYfpj,
                          BigDecimal alYfzk, BigDecimal alYszk, BigDecimal alBrkyf, BigDecimal alQtldfz, BigDecimal alFldfz,
                          BigDecimal alQtyfk, BigDecimal alBrzk, BigDecimal alFldzcjj, BigDecimal alJzc, BigDecimal alGdzc,
                          BigDecimal alZjgc, BigDecimal alCqtz, BigDecimal alWxzc, BigDecimal alCzbzjz, BigDecimal alCzbzjy,
                          BigDecimal alZyjj, BigDecimal alSyjy, BigDecimal alJyjy, BigDecimal alFzjzczj) {
        this.alYjgkk = alYjgkk;
        this.alYjsf = alYjsf;
        this.alYfzgxc = alYfzgxc;
        this.alDqjk = alDqjk;
        this.alYfpj = alYfpj;
        this.alYfzk = alYfzk;
        this.alYszk = alYszk;
        this.alBrkyf = alBrkyf;
        this.alQtldfz = alQtldfz;
        this.alFldfz = alFldfz;
        this.alQtyfk = alQtyfk;
        this.alBrzk = alBrzk;
        this.alFldzcjj = alFldzcjj;
        this.alJzc = alJzc;
        this.alGdzc = alGdzc;
        this.alZjgc = alZjgc;
        this.alCqtz = alCqtz;
        this.alWxzc = alWxzc;
        this.alCzbzjz = alCzbzjz;
        this.alCzbzjy = alCzbzjy;
        this.alZyjj = alZyjj;
        this.alSyjy = alSyjy;
        this.alJyjy = alJyjy;
        this.alFzjzczj = alFzjzczj;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getAlYjsf() {
        return alYjsf;
    }

    public void setAlYjsf(BigDecimal alYjsf) {
        this.alYjsf = alYjsf;
    }

    public BigDecimal getAlDqjk() {
        return alDqjk;
    }

    public void setAlDqjk(BigDecimal alDqjk) {
        this.alDqjk = alDqjk;
    }

    public BigDecimal getAlCzbzjz() {
        return alCzbzjz;
    }

    public void setAlCzbzjz(BigDecimal alCzbzjz) {
        this.alCzbzjz = alCzbzjz;
    }

    public BigDecimal getAlWxzc() {
        return alWxzc;
    }

    public void setAlWxzc(BigDecimal alWxzc) {
        this.alWxzc = alWxzc;
    }

    public BigDecimal getAlYjgkk() {
        return alYjgkk;
    }

    public void setAlYjgkk(BigDecimal alYjgkk) {
        this.alYjgkk = alYjgkk;
    }

    public BigDecimal getAlBrkyf() {
        return alBrkyf;
    }

    public void setAlBrkyf(BigDecimal alBrkyf) {
        this.alBrkyf = alBrkyf;
    }

    public BigDecimal getAlFldfz() {
        return alFldfz;
    }

    public void setAlFldfz(BigDecimal alFldfz) {
        this.alFldfz = alFldfz;
    }

    public BigDecimal getAlJzc() {
        return alJzc;
    }

    public void setAlJzc(BigDecimal alJzc) {
        this.alJzc = alJzc;
    }

    public BigDecimal getAlQtldfz() {
        return alQtldfz;
    }

    public void setAlQtldfz(BigDecimal alQtldfz) {
        this.alQtldfz = alQtldfz;
    }

    public BigDecimal getAlYfzk() {
        return alYfzk;
    }

    public void setAlYfzk(BigDecimal alYfzk) {
        this.alYfzk = alYfzk;
    }

    public BigDecimal getAlYszk() {
        return alYszk;
    }

    public void setAlYszk(BigDecimal alYszk) {
        this.alYszk = alYszk;
    }

    public BigDecimal getAlQtyfk() {
        return alQtyfk;
    }

    public void setAlQtyfk(BigDecimal alQtyfk) {
        this.alQtyfk = alQtyfk;
    }

    public BigDecimal getAlFldzcjj() {
        return alFldzcjj;
    }

    public void setAlFldzcjj(BigDecimal alFldzcjj) {
        this.alFldzcjj = alFldzcjj;
    }

    public BigDecimal getAlCqtz() {
        return alCqtz;
    }

    public void setAlCqtz(BigDecimal alCqtz) {
        this.alCqtz = alCqtz;
    }

    public BigDecimal getAlZyjj() {
        return alZyjj;
    }

    public void setAlZyjj(BigDecimal alZyjj) {
        this.alZyjj = alZyjj;
    }

    public BigDecimal getAlGdzc() {
        return alGdzc;
    }

    public void setAlGdzc(BigDecimal alGdzc) {
        this.alGdzc = alGdzc;
    }

    public BigDecimal getAlZjgc() {
        return alZjgc;
    }

    public void setAlZjgc(BigDecimal alZjgc) {
        this.alZjgc = alZjgc;
    }

    public BigDecimal getAlYfzgxc() {
        return alYfzgxc;
    }

    public void setAlYfzgxc(BigDecimal alYfzgxc) {
        this.alYfzgxc = alYfzgxc;
    }

    public BigDecimal getAlJyjy() {
        return alJyjy;
    }

    public void setAlJyjy(BigDecimal alJyjy) {
        this.alJyjy = alJyjy;
    }

    public BigDecimal getAlBrzk() {
        return alBrzk;
    }

    public void setAlBrzk(BigDecimal alBrzk) {
        this.alBrzk = alBrzk;
    }

    public BigDecimal getAlSyjy() {
        return alSyjy;
    }

    public void setAlSyjy(BigDecimal alSyjy) {
        this.alSyjy = alSyjy;
    }

    public BigDecimal getAlYfpj() {
        return alYfpj;
    }

    public void setAlYfpj(BigDecimal alYfpj) {
        this.alYfpj = alYfpj;
    }

    public BigDecimal getAlCzbzjy() {
        return alCzbzjy;
    }

    public void setAlCzbzjy(BigDecimal alCzbzjy) {
        this.alCzbzjy = alCzbzjy;
    }

    public BigDecimal getAlFzjzczj() {
        return alFzjzczj;
    }

    public void setAlFzjzczj(BigDecimal alFzjzczj) {
        this.alFzjzczj = alFzjzczj;
    }

    public String getAlKjq() {
        return alKjq;
    }

    public void setAlKjq(String alKjq) {
        this.alKjq = alKjq;
    }

    public String getAlKjnd() {
        return alKjnd;
    }

    public void setAlKjnd(String alKjnd) {
        this.alKjnd = alKjnd;
    }
}
