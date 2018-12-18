package com.oulam.bean;

import java.util.Date;

public class FMForm {
    private Long fId;

    private String fMessgae;

    private String fMaterial;

    private String fInnoMaterial;

    private String fTemp;

    private String fMedia;

    private Integer fNum;

    private String fAddress;

    private String fExplain;

    private String fFile;

    private String fAskWay;

    private String fAskForm;

    private Date fDate;

    private String fPayWay;

    private String fYourname;

    private String fYourphone;

    public Long getfId() {
        return fId;
    }

    public void setfId(Long fId) {
        this.fId = fId;
    }

    public String getfMessgae() {
        return fMessgae;
    }

    public void setfMessgae(String fMessgae) {
        this.fMessgae = fMessgae == null ? null : fMessgae.trim();
    }

    public String getfMaterial() {
        return fMaterial;
    }

    public void setfMaterial(String fMaterial) {
        this.fMaterial = fMaterial == null ? null : fMaterial.trim();
    }

    public String getfInnoMaterial() {
        return fInnoMaterial;
    }

    public void setfInnoMaterial(String fInnoMaterial) {
        this.fInnoMaterial = fInnoMaterial == null ? null : fInnoMaterial.trim();
    }

    public String getfTemp() {
        return fTemp;
    }

    public void setfTemp(String fTemp) {
        this.fTemp = fTemp == null ? null : fTemp.trim();
    }

    public String getfMedia() {
        return fMedia;
    }

    public void setfMedia(String fMedia) {
        this.fMedia = fMedia == null ? null : fMedia.trim();
    }

    public Integer getfNum() {
        return fNum;
    }

    public void setfNum(Integer fNum) {
        this.fNum = fNum;
    }

    public String getfAddress() {
        return fAddress;
    }

    public void setfAddress(String fAddress) {
        this.fAddress = fAddress == null ? null : fAddress.trim();
    }

    public String getfExplain() {
        return fExplain;
    }

    public void setfExplain(String fExplain) {
        this.fExplain = fExplain == null ? null : fExplain.trim();
    }

    public String getfFile() {
        return fFile;
    }

    public void setfFile(String fFile) {
        this.fFile = fFile == null ? null : fFile.trim();
    }

    public String getfAskWay() {
        return fAskWay;
    }

    public void setfAskWay(String fAskWay) {
        this.fAskWay = fAskWay == null ? null : fAskWay.trim();
    }

    public String getfAskForm() {
        return fAskForm;
    }

    public void setfAskForm(String fAskForm) {
        this.fAskForm = fAskForm == null ? null : fAskForm.trim();
    }

    public Date getfDate() {
        return fDate;
    }

    public void setfDate(Date fDate) {
        this.fDate = fDate;
    }

    public String getfPayWay() {
        return fPayWay;
    }

    public void setfPayWay(String fPayWay) {
        this.fPayWay = fPayWay == null ? null : fPayWay.trim();
    }

    public String getfYourname() {
        return fYourname;
    }

    public void setfYourname(String fYourname) {
        this.fYourname = fYourname == null ? null : fYourname.trim();
    }

    public String getfYourphone() {
        return fYourphone;
    }

    public void setfYourphone(String fYourphone) {
        this.fYourphone = fYourphone == null ? null : fYourphone.trim();
    }
}