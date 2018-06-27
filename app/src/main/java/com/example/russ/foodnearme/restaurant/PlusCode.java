package com.example.russ.foodnearme.restaurant;

import com.google.gson.annotations.SerializedName;

/**
 * Created by russ on 6/27/18.
 */

public class PlusCode {
    @SerializedName("compound_code")
    private String compoundCode;

    @SerializedName("global_code")
    private String globalCode;

    public PlusCode(String compoundCode, String globalCode) {
        this.compoundCode = compoundCode;
        this.globalCode = globalCode;
    }

    public String getCompoundCode() {
        return compoundCode;
    }

    public String getGlobalCode() {
        return globalCode;
    }

    @Override
    public String toString() {
        return "PlusCode{" +
                "compoundCode='" + compoundCode + '\'' +
                ", globalCode='" + globalCode + '\'' +
                '}';
    }
}
