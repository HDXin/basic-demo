package top.atstudy.basic.cmb.response;

import lombok.Data;

import java.io.Serializable;

@Data
public class ResponseHead implements Serializable {

    private String funcode;

    private String reqid;

    private String userid;

    private String bizcode;

    private String resultcode;

    private String resultmsg;

    private String rspid;

}
