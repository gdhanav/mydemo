package com.arq.hub.es.exception.handler;

public class ErroMsg {

    public String errorDescription;
    public int statuscode;
    public String msg;

    public ErroMsg(String errorDescription,int statuscode,String msg ) {
        this.errorDescription=errorDescription;
        this.statuscode=statuscode;
        this.msg=msg;
    }

    @Override
    public String toString() {
        return "ErroMsg [errorDescription=" + errorDescription + ", statuscode=" + statuscode + ", msg=" + msg + "]";
    }
}
