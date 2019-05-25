package xyz.xlong99.domain;
import java.io.Serializable;
/**
 * @author 胡学良
 *
 * 存取用户基本信息
 */
public class User implements Serializable {
    /**
     *用户ID
     */
    private int id;
    /**
     * 用户名
     */
    private String username;
    /**
     * 用户性别
     */
    private String sex;
    /**
     * 用户职业
     */
    private String position;
    /**
     * 用户所在地址
     */
    private String location;
    /**
     * 用户签名
     */
    private String sign;
    /**
     * 用户头像
     */
    private String photo;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", sex='" + sex + '\'' +
                ", position='" + position + '\'' +
                ", location='" + location + '\'' +
                ", sign='" + sign + '\'' +
                ", photo='" + photo + '\'' +
                '}';
    }
}