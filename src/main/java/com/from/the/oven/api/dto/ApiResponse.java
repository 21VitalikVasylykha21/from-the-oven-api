package com.from.the.oven.api.dto;

import java.util.List;
import org.springframework.http.HttpStatus;

/**
 * @author Vitalii Vasylykha
 * @company UnitedThinkers
 * @since 2023/04/23
 */
public class ApiResponse<T> {

	private HttpStatus status;
	private Integer total;
	private List<T> result;

	public ApiResponse(HttpStatus status) {
		this.status = status;
	}

	public ApiResponse(List<T> result) {
		this.status = result.isEmpty() ? HttpStatus.NOT_FOUND : HttpStatus.OK;
		this.total = result.size();
		this.result = result;
	}

	public ApiResponse(HttpStatus status, Integer total, List<T> result) {
		this.status = status;
		this.total = total;
		this.result = result;
	}

	public HttpStatus getStatus() {
		return status;
	}

	public void setStatus(HttpStatus status) {
		this.status = status;
	}

	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}

	public List<T> getResult() {
		return result;
	}

	public void setResult(List<T> result) {
		this.result = result;
	}
}
