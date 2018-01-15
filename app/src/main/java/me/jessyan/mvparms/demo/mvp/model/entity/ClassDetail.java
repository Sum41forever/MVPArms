package me.jessyan.mvparms.demo.mvp.model.entity;

import android.app.Activity;
import android.support.annotation.DrawableRes;

import java.io.Serializable;

/**
 * Description: 类信息实体
 *
 * @author Sum41forever 2018/1/15
 *         <a href="http://www.sum41forever.com/">Contact me</a>
 */
public class ClassDetail implements Serializable {

    private final String title;
    private final String avatarUrl;
    private final Class<? extends Activity> activityClass;

    public ClassDetail(String title, Class<? extends Activity> activityClass, String  avatarUrl) {
        super();
        this.title = title;
        this.activityClass = activityClass;
        this.avatarUrl = avatarUrl;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public String getTitle() {
        return title;
    }

    public Class<? extends Activity> getActivityClass() {
        return activityClass;
    }

    @Override
    public String toString() {
        return title;
    }
}
