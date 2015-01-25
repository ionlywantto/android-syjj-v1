package com.example.whjt;

import java.util.Date;

public class Message {
	public int SERIALID;         //消息序号
	public int USERID_SEND;	     //发送者
	public String STATUS_SEND;   //发送状态
	public String MSGTITLE;      //标题
	public String MSGCONTENT;    //内容
	public Date MSGSENDDATE;     //发送日期
	public int USERID_RECEIVE;   //接收者
	public String STATUS_RECEIVE; //接收状态
	public Date READDATE;         //读取日期

}
