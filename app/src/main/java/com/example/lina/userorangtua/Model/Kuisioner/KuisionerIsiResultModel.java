package com.example.lina.userorangtua.Model.Kuisioner;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class KuisionerIsiResultModel {

    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("result")
    @Expose
    private KuisionerIsiModel result;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public KuisionerIsiModel getResult() {
        return result;
    }

    public void setResult(KuisionerIsiModel result) {
        this.result = result;
    }
}
