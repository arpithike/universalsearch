
package in.hike.arpit.universalsearch.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Mention {

    @SerializedName("p")
    @Expose
    private Integer p;
    @SerializedName("u")
    @Expose
    private String u;
    @SerializedName("profile")
    @Expose
    private Profile_ profile;

    public Integer getP() {
        return p;
    }

    public void setP(Integer p) {
        this.p = p;
    }

    public String getU() {
        return u;
    }

    public void setU(String u) {
        this.u = u;
    }

    public Profile_ getProfile() {
        return profile;
    }

    public void setProfile(Profile_ profile) {
        this.profile = profile;
    }

}
