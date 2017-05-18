package Data;

import android.support.annotation.NonNull;

/**
 * Created by anton on 15.05.2017.
 */

public class Userdata implements Comparable<Userdata>{
    private String username = null;
    private String password = null;
    private String flag = null;

    public Userdata(String username, String password, String flag)
    {
        setUsername(username);
        setPassword(password);
        setFlag(flag);
    }

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

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    @Override
    public int compareTo(@NonNull Userdata o) {
        return this.getUsername().compareTo(o.getUsername());
    }
}
