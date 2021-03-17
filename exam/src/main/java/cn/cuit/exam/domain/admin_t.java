package cn.cuit.exam.domain;

public class admin_t {
    private String username;
    private String password;
    private String school;

    public admin_t(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public admin_t(String username, String password, String school) {
        this(username, password);
        this.school = school;
    }

    public admin_t() {}

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
        }

    /**
     * 判断密码是否合法
     * @param pwd
     * @return
     */
    static public boolean isPwdLegal(String pwd) {
        if (pwd.length() < 6 || pwd.length() > 20) {
            return false;
        } else {
            char ch;
            for (int i = 0; i < pwd.length(); ++i) {
                ch = pwd.charAt(i);
                if (funcLib.isNum(ch) || funcLib.isLetter(ch)) continue;
                if (ch == '!' || ch == '@' || ch == '#') continue;
                return false;
            }
            return true;
        }
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
