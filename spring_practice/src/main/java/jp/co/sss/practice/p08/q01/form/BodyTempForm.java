package jp.co.sss.practice.p08.q01.form;

import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;

public class BodyTempForm {
	@NotNull
	@DecimalMin(value = "30.0")
	@DecimalMax(value = "45.0")
	private Double bodyTemp;

	@NotNull
	private java.util.Date inputDate;

	public Double getBodyTemp() {
		return bodyTemp;
	}

	public void setBodyTemp(Double bodyTemp) {
		this.bodyTemp = bodyTemp;
	}

	public java.util.Date getInputDate() {
		return inputDate;
	}

	public void setInputDate(java.util.Date inputDate) {
		this.inputDate = inputDate;
	}
}
