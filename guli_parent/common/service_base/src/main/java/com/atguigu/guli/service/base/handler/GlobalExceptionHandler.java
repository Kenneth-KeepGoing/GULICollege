package com.atguigu.guli.service.base.handler;

import com.atguigu.guli.common.base.result.ResultCodeEnum;
import com.atguigu.guli.common.base.result.ResultData;
import com.atguigu.guli.common.base.util.ExceptionUtils;
import com.atguigu.guli.service.base.exception.GuliException;

import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.BadSqlGrammarException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @ClassName GlobalExceptionHandler
 * @Author zengyihang
 * @Date: 2021-01-13 14:07
 */
@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ResultData error(Exception e){
        /**
         * 输出异常信息
         **/
        log.error(ExceptionUtils.getMessage(e));
        return ResultData.error();
    }

    @ExceptionHandler(BadSqlGrammarException.class)
    @ResponseBody
    public ResultData error(BadSqlGrammarException e){
        log.error(ExceptionUtils.getMessage(e));
        return ResultData.setResult(ResultCodeEnum.BAD_SQL_GRAMMAR);
    }

    @ExceptionHandler(GuliException.class)
    @ResponseBody
    public ResultData error(GuliException e){
        log.error(ExceptionUtils.getMessage(e));
        return ResultData.error().message(e.getMessage()).code(e.getCode());
    }
}