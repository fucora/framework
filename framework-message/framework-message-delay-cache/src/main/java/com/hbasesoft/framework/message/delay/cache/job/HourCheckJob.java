/**************************************************************************************** 
 Copyright © 2003-2012 hbasesoft Corporation. All rights reserved. Reproduction or       <br>
 transmission in whole or in part, in any form or by any means, electronic, mechanical <br>
 or otherwise, is prohibited without the prior written consent of the copyright owner. <br>
 ****************************************************************************************/
package com.hbasesoft.framework.message.delay.cache.job;

import com.dangdang.ddframe.job.api.ShardingContext;
import com.dangdang.ddframe.job.api.simple.SimpleJob;
import com.hbasesoft.framework.job.core.annotation.Job;
import com.hbasesoft.framework.message.delay.cache.QueueManager;

/**
 * <Description> <br>
 * 
 * @author 王伟<br>
 * @version 1.0<br>
 * @taskId <br>
 * @CreateDate 2019年4月10日 <br>
 * @since V1.0<br>
 * @see com.hbasesoft.framework.message.delay.cache.job <br>
 */
@Job(cron = "0 0 * * * ?")
public class HourCheckJob implements SimpleJob {

    /**
     * Description: <br>
     * 
     * @author 王伟<br>
     * @taskId <br>
     * @param shardingContext <br>
     */
    @Override
    public void execute(ShardingContext shardingContext) {
        QueueManager.getMap().get(QueueManager.HOUR_QUEUE).check();
    }

}
