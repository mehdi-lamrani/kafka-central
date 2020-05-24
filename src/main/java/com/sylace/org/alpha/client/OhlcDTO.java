package com.sylace.org.alpha.client;

import java.util.Date;
import com.opencsv.bean.CsvBindByName;

public class OhlcDTO {
    @CsvBindByName
    public String timestamp;

    @CsvBindByName
    public String open;

    @CsvBindByName
    public String high;

    @CsvBindByName
    public String low;

    @CsvBindByName
    public String close;

    @CsvBindByName
    public String volume;
}
