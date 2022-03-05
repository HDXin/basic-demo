package top.atstudy.basic.message;

public class QywxRobotMarkdownMessage extends AbstractQywxRobotMessage {

    public QywxRobotMarkdownMessage(String key) {
        super(key, QywxMsgTypeEnum.MARKDOWN);
    }

    public static QywxRobotMarkdownMessage create() {
        return new QywxRobotMarkdownMessage(null);
    }

    public static QywxRobotMarkdownMessage create(String key) {
        return new QywxRobotMarkdownMessage(key);
    }

    @Override
    public String toBodyText() {
        return null;
    }
}
