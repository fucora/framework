/**************************************************************************************** 
 Copyright © 2003-2012 hbasesoft Corporation. All rights reserved. Reproduction or       <br>
 transmission in whole or in part, in any form or by any means, electronic, mechanical <br>
 or otherwise, is prohibited without the prior written consent of the copyright owner. <br>
 ****************************************************************************************/
package com.hbasesoft.framework.tx.demo.client2;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.hbasesoft.framework.tx.client.producer.springcloud.client.FallBackProducerFactory;

/**
 * <Description> <br>
 * 
 * @author 王伟<br>
 * @version 1.0<br>
 * @taskId <br>
 * @CreateDate Feb 3, 2020 <br>
 * @since V1.0<br>
 * @see com.hbasesoft.framework.tx.demo.client <br>
 */
@FeignClient(name = "${project.server.client3}", url = "${project.server-url.client3:}",
    fallbackFactory = FallBackProducerFactory.class)
public interface FeginClient3Consumer {

    @GetMapping
    String test(@RequestParam("id") String id);
}
