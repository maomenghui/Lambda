package com.why.project.entity;

import java.math.BigDecimal;

/**
 * 人事、劳资月报采集卡对象 personnel_labour
 *
 * @author maomh
 * @date 2020-07-08
 */
public class PersonnelLabour {
    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    private Long id;

    /**
     * 从业人员劳动报酬
     */
    private BigDecimal plCyrybc;

    /**
     * 其中：在岗职工工资总额
     */
    private BigDecimal plZgzggzze;

    /**
     * 劳务派遣人员劳动报酬
     */
    private BigDecimal plLwpqrybc;

    /**
     * 其他从业人员劳动报酬
     */
    private BigDecimal plQtryldbc;

    /**
     * 社会保险费用
     */
    private BigDecimal plShbxfy;

    /**
     * 职工福利费
     */
    private BigDecimal plZgflf;

    /**
     * 教育经费
     */
    private BigDecimal plJyjf;

    /**
     * 住房费用
     */
    private BigDecimal plZffy;

    /**
     * 公积金
     */
    private BigDecimal plGjj;

    /**
     * 工会经费
     */
    private BigDecimal plGhjf;

    /**
     * 会计期间 表示月份
     */
    private String cfKjq;

    public PersonnelLabour(BigDecimal plCyrybc, BigDecimal plZgzggzze, BigDecimal plLwpqrybc, BigDecimal plQtryldbc, BigDecimal plShbxfy, BigDecimal plZgflf, BigDecimal plJyjf, BigDecimal plZffy, BigDecimal plGjj, BigDecimal plGhjf) {
        this.plCyrybc = plCyrybc;
        this.plZgzggzze = plZgzggzze;
        this.plLwpqrybc = plLwpqrybc;
        this.plQtryldbc = plQtryldbc;
        this.plShbxfy = plShbxfy;
        this.plZgflf = plZgflf;
        this.plJyjf = plJyjf;
        this.plZffy = plZffy;
        this.plGjj = plGjj;
        this.plGhjf = plGhjf;
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

    public BigDecimal getPlCyrybc() {
        return plCyrybc;
    }

    public void setPlCyrybc(BigDecimal plCyrybc) {
        this.plCyrybc = plCyrybc;
    }

    public BigDecimal getPlZgzggzze() {
        return plZgzggzze;
    }

    public void setPlZgzggzze(BigDecimal plZgzggzze) {
        this.plZgzggzze = plZgzggzze;
    }

    public BigDecimal getPlLwpqrybc() {
        return plLwpqrybc;
    }

    public void setPlLwpqrybc(BigDecimal plLwpqrybc) {
        this.plLwpqrybc = plLwpqrybc;
    }

    public BigDecimal getPlQtryldbc() {
        return plQtryldbc;
    }

    public void setPlQtryldbc(BigDecimal plQtryldbc) {
        this.plQtryldbc = plQtryldbc;
    }

    public BigDecimal getPlShbxfy() {
        return plShbxfy;
    }

    public void setPlShbxfy(BigDecimal plShbxfy) {
        this.plShbxfy = plShbxfy;
    }

    public BigDecimal getPlZgflf() {
        return plZgflf;
    }

    public void setPlZgflf(BigDecimal plZgflf) {
        this.plZgflf = plZgflf;
    }

    public BigDecimal getPlJyjf() {
        return plJyjf;
    }

    public void setPlJyjf(BigDecimal plJyjf) {
        this.plJyjf = plJyjf;
    }

    public BigDecimal getPlZffy() {
        return plZffy;
    }

    public void setPlZffy(BigDecimal plZffy) {
        this.plZffy = plZffy;
    }

    public BigDecimal getPlGjj() {
        return plGjj;
    }

    public void setPlGjj(BigDecimal plGjj) {
        this.plGjj = plGjj;
    }

    public BigDecimal getPlGhjf() {
        return plGhjf;
    }

    public void setPlGhjf(BigDecimal plGhjf) {
        this.plGhjf = plGhjf;
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
