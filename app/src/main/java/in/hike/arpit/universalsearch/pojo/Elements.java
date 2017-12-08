
package in.hike.arpit.universalsearch.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Elements {

    @SerializedName("list")
    @Expose
    private List<EachListItem> list = null;

    public List<EachListItem> getList() {
        return list;
    }

    public void setList(List<EachListItem> list) {
        this.list = list;
    }

}
