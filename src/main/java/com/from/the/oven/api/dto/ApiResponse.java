package com.from.the.oven.api.dto;

import java.util.List;
import org.springframework.http.HttpStatus;

/**
 * @author Vitalii Vasylykha
 * @company UzhNU
 * @since 2023/04/23
 */
public class ApiResponse<T> {

	private Integer status;
	private Long total;
	private List<T> result;

	public ApiResponse(HttpStatus status) {
		this.status = status.value();
		this.total = null;
		this.result = null;
	}

	public ApiResponse(HttpStatus status, RuntimeException exception) {
		this.status = status.value();
		this.result = List.of((T) exception.getMessage());
		this.total = null;
	}

	public ApiResponse(HttpStatus status, List<T> result) {
		this.status = status.value();
		this.total = (long) result.size();
		this.result = result;
	}

	public ApiResponse(Long total, List<T> result) {
		this.status = HttpStatus.OK.value();
		this.total = total;
		this.result = result;
	}

	public ApiResponse(List<T> result) {
		this.status = HttpStatus.OK.value();
		this.total = (long) result.size();
		this.result = result;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(HttpStatus status) {
		this.status = status.value();
	}

	public Long getTotal() {
		return total;
	}

	public void setTotal(Long total) {
		this.total = total;
	}

	public List<T> getResult() {
		return result;
	}

	public void setResult(List<T> result) {
		this.result = result;
	}
}
