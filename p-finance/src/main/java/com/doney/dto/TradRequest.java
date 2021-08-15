package com.doney.dto;


import com.doney.entity.TradDetail;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TradRequest{
    private Long tradType;
    private Long tradClassification;
    private List<TradDetail> detailList;
    private Date tradDate;
    private String tag;
    private String remark;
}
