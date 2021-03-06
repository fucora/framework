/**************************************************************************************** 
 Copyright © 2003-2012 hbasesoft Corporation. All rights reserved. Reproduction or       <br>
 transmission in whole or in part, in any form or by any means, electronic, mechanical <br>
 or otherwise, is prohibited without the prior written consent of the copyright owner. <br>
 ****************************************************************************************/
package com.hbasesoft.framework.tx.core.bean;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * <Description> <br>
 * 
 * @author 王伟<br>
 * @version 1.0<br>
 * @taskId <br>
 * @CreateDate Jan 10, 2020 <br>
 * @since V1.0<br>
 * @see com.hbasesoft.framework.tx.core <br>
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ClientInfo implements Serializable {

    /**
     * serialVersionUID <br>
     */
    private static final long serialVersionUID = -1186576125746340794L;

    private String id;

    private String mark;

    private String context;

    private byte[] args;

    private int maxRetryTimes;

    private String retryConfigs;

    private String clientInfo;

    public ClientInfo(String id, String mark) {
        this.id = id;
        this.mark = mark;
    }

}
