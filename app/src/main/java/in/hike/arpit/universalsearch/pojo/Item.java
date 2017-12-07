package in.hike.arpit.universalsearch.pojo;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.JsonNull;
import com.google.gson.JsonObject;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.Map;

/**
 * Created by arpitratan on 16/11/17.
 */

public class Item implements Parcelable {

    @SerializedName("position")
    @Expose
    private int position;
    @SerializedName("deeplink")
    @Expose
    private String deeplink;
    @SerializedName("sub_title")
    @Expose
    private String subTitle;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("metadata")
    @Expose
    private JsonNull metadata;
    @SerializedName("subtitle")
    @Expose
    private String subtitle;

    public Item() {

    }
    protected Item(Parcel in) {
        position = in.readInt();
        deeplink = in.readString();
        subTitle = in.readString();
        title = in.readString();
        id = in.readString();
        url = in.readString();
        subtitle = in.readString();
    }

    public static final Creator<Item> CREATOR = new Creator<Item>() {
        @Override
        public Item createFromParcel(Parcel in) {
            return new Item(in);
        }

        @Override
        public Item[] newArray(int size) {
            return new Item[size];
        }
    };

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public Item withPosition(int position) {
        this.position = position;
        return this;
    }

    public String getDeeplink() {
        return deeplink;
    }

    public void setDeeplink(String deeplink) {
        this.deeplink = deeplink;
    }

    public Item withDeeplink(String deeplink) {
        this.deeplink = deeplink;
        return this;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }

    public Item withSubTitle(String subTitle) {
        this.subTitle = subTitle;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Item withTitle(String title) {
        this.title = title;
        return this;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Item withId(String id) {
        this.id = id;
        return this;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Item withUrl(String url) {
        this.url = url;
        return this;
    }

    public Map<String, String> getMetadata() {
        return null;
    }

    public String getSubtitle() {
        return subtitle;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(position);
        dest.writeString(deeplink);
        dest.writeString(subTitle);
        dest.writeString(title);
        dest.writeString(id);
        dest.writeString(url);
        dest.writeString(subtitle);
    }
}