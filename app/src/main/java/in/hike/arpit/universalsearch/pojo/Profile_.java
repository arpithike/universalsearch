
package in.hike.arpit.universalsearch.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Profile_ {

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("lts")
    @Expose
    private Long lts;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getLts() {
        return lts;
    }

    public void setLts(Long lts) {
        this.lts = lts;
    }

}
