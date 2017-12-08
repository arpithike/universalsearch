
package in.hike.arpit.universalsearch.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class D {

    @SerializedName("msg")
    @Expose
    private String msg;
    @SerializedName("timeofday")
    @Expose
    private Integer timeofday;
    @SerializedName("metadata")
    @Expose
    private Metadata metadata;
    @SerializedName("mood")
    @Expose
    private String mood;
    @SerializedName("statusid")
    @Expose
    private String statusid;
    @SerializedName("full_url")
    @Expose
    private String fullUrl;
    @SerializedName("tn_url")
    @Expose
    private String tnUrl;
    @SerializedName("label")
    @Expose
    private String label;
    @SerializedName("push")
    @Expose
    private Boolean push;
    @SerializedName("ts")
    @Expose
    private Integer ts;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Integer getTimeofday() {
        return timeofday;
    }

    public void setTimeofday(Integer timeofday) {
        this.timeofday = timeofday;
    }

    public Metadata getMetadata() {
        return metadata;
    }

    public void setMetadata(Metadata metadata) {
        this.metadata = metadata;
    }

    public String getMood() {
        return mood;
    }

    public void setMood(String mood) {
        this.mood = mood;
    }

    public String getStatusid() {
        return statusid;
    }

    public void setStatusid(String statusid) {
        this.statusid = statusid;
    }

    public String getFullUrl() {
        return fullUrl;
    }

    public void setFullUrl(String fullUrl) {
        this.fullUrl = fullUrl;
    }

    public String getTnUrl() {
        return tnUrl;
    }

    public void setTnUrl(String tnUrl) {
        this.tnUrl = tnUrl;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public Boolean getPush() {
        return push;
    }

    public void setPush(Boolean push) {
        this.push = push;
    }

    public Integer getTs() {
        return ts;
    }

    public void setTs(Integer ts) {
        this.ts = ts;
    }

}
