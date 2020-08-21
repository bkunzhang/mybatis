package com.bkunz.mybatis.secondlevel.model;

import java.util.Date;

/**
 * @author bingkun_zhang
 * @date 2020/7/24
 */
public class RequireBillLog {
    private int id;
    private int billId;
    private String reason;
    private Date oldCheckDate;
    private Date newCheckDate;
    private int userId;
    private Date createTime;

    public RequireBillLog() {}

    public RequireBillLog(int billId, String reason, Date oldCheckDate, Date newCheckDate) {
        this.billId = billId;
        this.reason = reason;
        this.oldCheckDate = oldCheckDate;
        this.newCheckDate = newCheckDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBillId() {
        return billId;
    }

    public void setBillId(int billId) {
        this.billId = billId;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public Date getOldCheckDate() {
        return oldCheckDate;
    }

    public void setOldCheckDate(Date oldCheckDate) {
        this.oldCheckDate = oldCheckDate;
    }

    public Date getNewCheckDate() {
        return newCheckDate;
    }

    public void setNewCheckDate(Date newCheckDate) {
        this.newCheckDate = newCheckDate;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
