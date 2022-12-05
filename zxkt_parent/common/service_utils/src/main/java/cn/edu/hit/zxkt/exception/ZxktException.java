package cn.edu.hit.zxkt.exception;

import cn.edu.hit.zxkt.result.Result;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ZxktException extends RuntimeException{
    private int code;
    private String msg;
}
