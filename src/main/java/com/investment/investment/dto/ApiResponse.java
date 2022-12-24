package com.investment.investment.dto;

public class ApiResponse {

    // class ini dibuat untuk memberikan respon ketika user telah berhasil register maupun login
    // penggunaannya disesuaikan dengan kebutuhan front end

    private Integer status;

    // data dibuat untuk menaruh data user di postman
    private Object data;

    private Object error;

    public ApiResponse(){
        // status 200 menandakan bahwa tidak terjadi error
        this.status = 200;

        this.data = data;

        this.error = error;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Object getError() {
        return error;
    }

    public void setError(Object error) {
        this.error = error;
    }
}
