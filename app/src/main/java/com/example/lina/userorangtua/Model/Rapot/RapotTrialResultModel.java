package com.example.lina.userorangtua.Model.Rapot;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class RapotTrialResultModel {
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("siswatrial")
    @Expose
    private ArrayList<RapotTrialSiswaTrialModel> siswatrial = null;
    @SerializedName("rapottrial")
    @Expose
    private ArrayList<RapotTrialModel> rapottrial = null;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public ArrayList<RapotTrialSiswaTrialModel> getSiswatrial() {
        return siswatrial;
    }

    public void setSiswatrial(ArrayList<RapotTrialSiswaTrialModel> siswatrial) {
        this.siswatrial = siswatrial;
    }

    public ArrayList<RapotTrialModel> getRapottrial() {
        return rapottrial;
    }

    public void setRapottrial(ArrayList<RapotTrialModel> rapottrial) {
        this.rapottrial = rapottrial;
    }
}
