package top.atstudy.basic.cmb.request;

import lombok.Data;

import java.io.Serializable;

@Data
public class RequestHead implements Serializable {

    private String funcode;

    private String reqid;

    private String userid;

}
