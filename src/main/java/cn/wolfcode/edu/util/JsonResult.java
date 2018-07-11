package cn.wolfcode.edu.util;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JsonResult {

	private boolean success = true;
	private String errorMsg;

	public void markMsg(String errorMsg) {
		this.success = false;
		this.errorMsg = errorMsg;
	}
}
