package com.moz.ates.traffic.office.trafficEnforcementMng;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
public class DriverVO extends EnfSearchVO{

    private String birth;
    private String sex;
    private String driverLicense;
    private String email;
    private String address;

}
