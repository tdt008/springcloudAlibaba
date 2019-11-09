package com.tdt.platform.refund.domain.domain;

import java.io.Serializable;

public class TestAreaDO implements Serializable {

    /**
     * id
     */
    private Long id;
    /**
     * pid
     */
    private Long pid;
    /**
     * 行政区划编码code
     */
    private String postCode;
    /**
     * area name
     */
    private String name;

    /**
     * 区号
     */
    private String areaCode;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPid() {
        return pid;
    }

    public void setPid(Long pid) {
        this.pid = pid;
    }

    public String getPostCode() {
        return postCode;
    }

    public TestAreaDO setPostCode(String postCode) {
        this.postCode = postCode;
        return this;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("TestAreaDO{");
        sb.append("id=").append(id);
        sb.append(", pid=").append(pid);
        sb.append(", postCode='").append(postCode).append('\'');
        sb.append(", name='").append(name).append('\'');
        sb.append(", areaCode='").append(areaCode).append('\'');
        sb.append('}');
        return sb.toString();
    }
}