package cu.cubaconf.model;

/**
 * Created by akiel on 8/21/17.
 */

public class Submission {
    String name;
    String summary;
    String email;
    String avatar;
    String location;
    String bio;
    String twitter;
    String url;
    String organization;
    String title;
    String description;
    String audience_level;
    String[] tag_list;

    public String getName() {
        return name;
    }

    public String getSummary() {
        return summary;
    }

    public String getEmail() {
        return email;
    }

    public String getAvatar() {
        return avatar;
    }

    public String getLocation() {
        return location;
    }

    public String getBio() {
        return bio;
    }

    public String getTwitter() {
        return twitter;
    }

    public String getUrl() {
        return url;
    }

    public String getOrganization() {
        return organization;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getAudience_level() {
        return audience_level;
    }

    public String[] getTag_list() {
        return tag_list;
    }
}
