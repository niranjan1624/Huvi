package com.huvi.tracking.model;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;
import com.tuenti.smsradar.Sms;
import com.tuenti.smsradar.SmsType;

/**
 * Created by Niranjan on 1/7/2016.
 */
@Table(name = "Messages")
public class SMS extends Model {

    private Sms sms;

    @Column(name = "address", index = true)
    public String address;
    @Column(name = "date", index = true)
    public String date;
    @Column(name = "message")
    public String msg;
    @Column(name = "type", index = true)
    public SmsType type;


    public SMS(Sms sms) {
        this.address = sms.getAddress();
        this.date = sms.getDate();
        this.msg = sms.getMsg();
        this.type = sms.getType();
        this.sms = sms;
    }

}
