
package cu.cubaconf.model;

import com.google.gson.annotations.SerializedName;

public class Event {

    @SerializedName("author")
    private String mAuthor;
    @SerializedName("time")
    private String mTime;
    @SerializedName("title")
    private String mTitle;

    public String getAuthor() {
        return mAuthor;
    }

    public void setAuthor(String author) {
        mAuthor = author;
    }

    public String getTime() {
        return mTime;
    }

    public void setTime(String time) {
        mTime = time;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

}
