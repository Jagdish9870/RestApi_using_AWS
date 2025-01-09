package com.jack.exception;

import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
//@Builder
//public class ResponseMsg {
//    private String msg;
//    private HttpStatus status;
//    private Boolean success;
//    
//}


public class ResponseMsg {
    private String msg;
    private HttpStatus status;
    private boolean success;

    // Getters and Setters

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private String msg;
        private HttpStatus status;
        private boolean success;

        public Builder msg(String msg) {
            this.msg = msg;
            return this;
        }

        public Builder status(HttpStatus status) {
            this.status = status;
            return this;
        }

        public Builder success(boolean success) {
            this.success = success;
            return this;
        }

        public ResponseMsg build() {
            ResponseMsg responseMsg = new ResponseMsg();
            responseMsg.msg = this.msg;
            responseMsg.status = this.status;
            responseMsg.success = this.success;
            return responseMsg;
        }
    }
}
