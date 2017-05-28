package kim.deok.ju.domain;

public class AuthVO {

    private String id;
    private String password;
    private String userName;
    private String profile;

    public AuthVO() {
        super();
    }

    public AuthVO(String id, String password, String userName, String profile) {
        this.id = id;
        this.password = password;
        this.userName = userName;
        this.profile  = profile;
    }

    public String getId() {
        return id;
    }

    public AuthVO setId(String id) {
        this.id = id;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public AuthVO setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getUserName() {
        return userName;
    }

    public AuthVO setUserName(String userName) {
        this.userName = userName;
        return this;
    }

    public String getProfile() {
        return profile;
    }

    public AuthVO setProfile(String profile) {
        this.profile = profile;
        return this;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("AuthVO{");
        sb.append("id='").append(id).append('\'');
        sb.append(", password='").append(password).append('\'');
        sb.append(", userName='").append(userName).append('\'');
        sb.append(", profile='").append(profile).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
