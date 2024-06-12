package com.model;

public class MsgList {
	private int MsgId;
	private String FromUser, ToUser, MsgDetail;
	public int getMsgId() {
		return MsgId;
	}
	public void setMsgId(int msgId) {
		MsgId = msgId;
	}
	public String getFromUser() {
		return FromUser;
	}
	public void setFromUser(String fromUser) {
		FromUser = fromUser;
	}
	public String getToUser() {
		return ToUser;
	}
	public void setToUser(String toUser) {
		ToUser = toUser;
	}
	public String getMsgDetail() {
		return MsgDetail;
	}
	public void setMsgDetail(String msgDetail) {
		MsgDetail = msgDetail;
	}

}
