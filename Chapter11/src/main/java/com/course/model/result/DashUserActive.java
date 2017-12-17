package com.course.model.result;

import lombok.Data;

/**
 * Created by zjy on 17/5/16.
 */

@Data
public class DashUserActive {
    private int register_quantity;
    private int active_quantity;
    private int deposit_quantity;
    private int invest_quantity;
    private int withdraw_quantity;

    private String date;
    private String hour;
    private String minute;
    private String time;
}
