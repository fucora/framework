/**************************************************************************************** 
 Copyright © 2003-2012 hbasesoft Corporation. All rights reserved. Reproduction or       <br>
 transmission in whole or in part, in any form or by any means, electronic, mechanical <br>
 or otherwise, is prohibited without the prior written consent of the copyright owner. <br>
 ****************************************************************************************/
package com.hbasesoft.framework.common.config;

import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.hbasesoft.framework.common.annotation.NoTransLog;

/**
 * <Description> <br>
 * 
 * @author 王伟<br>
 * @version 1.0<br>
 * @taskId <br>
 * @CreateDate 2017年10月2日 <br>
 * @since V1.0<br>
 * @see com.hbasesoft.framework.common.config <br>
 */
@Configuration
@NoTransLog
public class MessageConfig {

    // Spring MVC 项目请实现 org.springframework.web.servlet.config.annotation.WebMvcConfigurer
    @Bean
    public HttpMessageConverters fastJsonHttpMessageConverters() {
        // 1、需要先定义一个 convert 转换消息对象；
        FastJsonHttpMessageConverter fastConverter = new FastJsonHttpMessageConverter();

        // 2、添加 fastJson 的配置信息，比如: 是否要格式化返回的Json数据；
        fastConverter.setFeatures(SerializerFeature.WriteDateUseDateFormat);

        // 4、
        HttpMessageConverter<?> converter = fastConverter;
        return new HttpMessageConverters(new StringHttpMessageConverter(), converter);
    }

    @Bean
    public ObjectMapper serializingObjectMapper() {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        objectMapper.registerModule(new JavaTimeModule());
        return objectMapper;
    }

}
