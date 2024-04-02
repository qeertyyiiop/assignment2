package classes;

import Interfaces.Item;

public class Magazine implements Item {
    private String title;
    private int issueNo;

    public Magazine(String title, int issueNo) {
        this.title = title;
        this.issueNo = issueNo;
    }

    @Override
    public String getTitle() {
        return title;
    }

    public int getIssueNo() {
        return issueNo;
    }
}
