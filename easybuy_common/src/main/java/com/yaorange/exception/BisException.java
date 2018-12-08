package com.yaorange.exception;

import com.yaorange.consts.ConstUtils;
import com.yaorange.consts.ICodes;
import com.yaorange.util.Ret;

public class BisException extends RuntimeException{
	private static final long serialVersionUID = -4640391473282791792L;
	
	private int code = ICodes.FAILED;
	private String message = "";
	private String info = "";
	private Object data = null;
	private Ret ret = null;
	
	public static BisException me(){
		return new BisException();
	}
	
	public BisException() {
		this.ret = Ret.me().setSuccess(false);
	}

	public BisException setCode(int code){
		this.code = code;
		this.ret.setSuccess(false).setCode(code);
		return this;
	}
	
	public int getCode() {
		return code;
	}

	public String getMessage() {
		String _msg = ConstUtils.getMsgConstName(this.code);
		if(null==_msg) _msg = "";
		message = _msg;
		return message;
	}
	
	public String getInfo(){
		return this.info;
	}
	
	public BisException setInfo(String info){
		this.info = info;
		this.ret.setInfo(info);
		return this;
	}
	
	public BisException setData(Object data){
		this.data = data;
		this.ret.setData(data);
		return this;
	}
	
	public Object getData(){
		return this.data;
	}
	
	public Ret getRet(){
		return this.ret;
	}
	
	public String toString(){
		return this.ret.toString();
	}
}