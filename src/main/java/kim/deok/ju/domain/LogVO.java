package kim.deok.ju.domain;

public class LogVO {

    String      content;
    String      regDate;

    public LogVO() {
        super();
    }

    public String getContent() {
        return content;
    }

    public LogVO setContent(String content) {
        this.content = content;
        return this;
    }

    public String getRegDate() {
        return regDate;
    }

    public LogVO setRegDate(String regDate) {
        this.regDate = regDate;
        return this;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("LogVO{");
        sb.append("content='").append(content).append('\'');
        sb.append(", regDate='").append(regDate).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
