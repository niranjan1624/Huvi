package com.huvi.tracking.model;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

/**
 * Created by Niranjan on 1/7/2016.
 */
@Table(name = "Photos")
public class Photo extends Model {
    @Column(name = "photo_path", index = true)
    public String photoPath;

    @Column(name = "date", index = true)
    public String date;
}
