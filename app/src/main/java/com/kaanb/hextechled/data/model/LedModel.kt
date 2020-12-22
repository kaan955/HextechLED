package com.kaanb.hextechled.data.model

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LedModel {

    @SerializedName("p1")
    @Expose
    var p1: Boolean? = null

    @SerializedName("p2")
    @Expose
    var p2: Boolean? = null

    @SerializedName("p3")
    @Expose
    var p3: Boolean? = null

    @SerializedName("p4")
    @Expose
    var p4: Boolean? = null
}
