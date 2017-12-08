
package in.hike.arpit.universalsearch.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class EachListItem {

    @SerializedName("c")
    @Expose
    private Long c;
    @SerializedName("t")
    @Expose
    private String t;
    @SerializedName("d")
    @Expose
    private D d;
    @SerializedName("f")
    @Expose
    private String f;
    @SerializedName("ts")
    @Expose
    private Integer ts;

    public Long getC() {
        return c;
    }

    public void setC(Long c) {
        this.c = c;
    }

    public String getT() {
        return t;
    }

    public void setT(String t) {
        this.t = t;
    }

    public D getD() {
        return d;
    }

    public void setD(D d) {
        this.d = d;
    }

    public String getF() {
        return f;
    }

    public void setF(String f) {
        this.f = f;
    }

    public Integer getTs() {
        return ts;
    }

    public void setTs(Integer ts) {
        this.ts = ts;
    }

}
