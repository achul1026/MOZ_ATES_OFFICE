package com.moz.ates.traffic.office.trafficEnforcementMng;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
public class CarVO extends EnfSearchVO{

    private String regDt;
    private String carType;
    private String carDriverName;

}
