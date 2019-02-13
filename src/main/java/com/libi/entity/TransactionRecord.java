package com.libi.entity;

import com.libi.base.BaseEntity;

/**
 * @author libi
 * 交易记录
 */
public class TransactionRecord extends BaseEntity {
    private Long spend;
    private Long save;
    private Long operationUser;
    private Long acceptUser;
    private Double amount;
    private String recordType;
    private String note;

    public Long getSpend() {
        return spend;
    }

    public void setSpend(Long spend) {
        this.spend = spend;
    }

    public Long getSave() {
        return save;
    }

    public void setSave(Long save) {
        this.save = save;
    }

    public Long getOperationUser() {
        return operationUser;
    }

    public void setOperationUser(Long operationUser) {
        this.operationUser = operationUser;
    }

    public Long getAcceptUser() {
        return acceptUser;
    }

    public void setAcceptUser(Long acceptUser) {
        this.acceptUser = acceptUser;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getRecordType() {
        return recordType;
    }

    public void setRecordType(String recordType) {
        this.recordType = recordType;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
