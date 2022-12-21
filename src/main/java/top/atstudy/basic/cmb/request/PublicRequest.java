package top.atstudy.basic.cmb.request;

import lombok.Data;

import java.io.Serializable;

@Data
public class PublicRequest implements Serializable {

    private RequestHead head;

    private IRequestBody body;

    public PublicRequest() {
    }

    public PublicRequest(RequestHead head) {
        this.head = head;
    }

    public PublicRequest(IRequestBody body) {
        this.body = body;
    }

    public PublicRequest(RequestHead head, IRequestBody body) {
        this.head = head;
        this.body = body;
    }
}
