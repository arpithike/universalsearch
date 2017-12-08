
package in.hike.arpit.universalsearch.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Asset {

    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("tn_size")
    @Expose
    private TnSize tnSize;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public TnSize getTnSize() {
        return tnSize;
    }

    public void setTnSize(TnSize tnSize) {
        this.tnSize = tnSize;
    }

}
