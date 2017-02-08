package edu.msstudio.pys.controller;

import java.util.List;

import org.springframework.data.domain.Page;

public class Result {
	
	private final static int OK_SINGLE = 100;
	
	private final static int OK_LIST = 200;
	
	private final static int ILLEGAL_PARAM = 102;

	private final static int MISSING_OBJECT =104;
	
	
	private int code;
		
	private Object data;

	public static Result OK(){
		Result result = new Result();
		result.setCode(OK_SINGLE);
		return result;
	}
	
	public static Result OK(Object item){
		Result result = new Result();
		result.setCode(OK_SINGLE);
		result.setData(item);
		return result;
	}
	
	public static Result OK_MUTI(Object list){
		Result result = new Result();
		result.setCode(OK_LIST);
		result.setData(list);
		return result;		
	}
	
	public static Result ILLEGAL_PARAM(){
		Result result = new Result();
		result.setCode(ILLEGAL_PARAM);
		return result;		
	}
	
	public static Result MISSING_OBJECT() {
		Result result = new Result();
		result.setCode(MISSING_OBJECT);
		return result;
	}
	
	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	
	
}
