
package in.hike.arpit.universalsearch.pojo;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Metadata {

    @SerializedName("profile")
    @Expose
    private Profile profile;
    @SerializedName("location")
    @Expose
    private Location location;
    @SerializedName("lts")
    @Expose
    private Integer lts;
    @SerializedName("asset")
    @Expose
    private Asset asset;
    @SerializedName("mention")
    @Expose
    private List<Mention> mention = null;
    @SerializedName("hashtag")
    @Expose
    private Hashtag hashtag;

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Integer getLts() {
        return lts;
    }

    public void setLts(Integer lts) {
        this.lts = lts;
    }

    public Asset getAsset() {
        return asset;
    }

    public void setAsset(Asset asset) {
        this.asset = asset;
    }

    public List<Mention> getMention() {
        return mention;
    }

    public void setMention(List<Mention> mention) {
        this.mention = mention;
    }

    public Hashtag getHashtag() {
        return hashtag;
    }

    public void setHashtag(Hashtag hashtag) {
        this.hashtag = hashtag;
    }

}
