package xyz.xlong99.domain;

/**
 * @author 26901
 * 存取标签信息
 */
public class Tag {
    /**
     * 标签id
     */
    private int tagid;
    /**
     * 标签名字
     */
    private String tagname;

    public int getTagid() {
        return tagid;
    }

    public void setTagid(int tagid) {
        this.tagid = tagid;
    }

    public String getTagname() {
        return tagname;
    }

    public void setTagname(String tagname) {
        this.tagname = tagname;
    }
}
