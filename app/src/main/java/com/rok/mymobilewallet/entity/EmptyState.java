package com.rok.mymobilewallet.entity;

import android.support.annotation.DrawableRes;
import android.support.annotation.StringRes;

/**
 * Created by Rok on 27. 08. 2017.
 */

public class EmptyState {

    @DrawableRes
    private int icon;
    @StringRes
    private int title;
    @StringRes
    private int description;

    @DrawableRes
    public int getIcon() {
        return icon;
    }

    public void setIcon(@DrawableRes int icon) {
        this.icon = icon;
    }

    @StringRes
    public int getTitle() {
        return title;
    }

    public void setTitle(@StringRes int title) {
        this.title = title;
    }

    @StringRes
    public int getDescription() {
        return description;
    }

    public void setDescription(@StringRes int description) {
        this.description = description;
    }
}
