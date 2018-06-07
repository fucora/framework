/**************************************************************************************** 
 Copyright © 2003-2012 hbasesoft Corporation. All rights reserved. Reproduction or       <br>
 transmission in whole or in part, in any form or by any means, electronic, mechanical <br>
 or otherwise, is prohibited without the prior written consent of the copyright owner. <br>
 ****************************************************************************************/
package com.hbasesoft.framework.test.common.io;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import org.junit.Test;

import com.hbasesoft.framework.common.utils.xml.CDATAAdapter;
import com.hbasesoft.framework.common.utils.xml.XmlBeanUtil;

import lombok.Getter;
import lombok.Setter;

/**
 * <Description> <br>
 * 
 * @author 王伟<br>
 * @version 1.0<br>
 * @taskId <br>
 * @CreateDate 2018年6月7日 <br>
 * @since V1.0<br>
 * @see com.hbasesoft.framework.test.common.io <br>
 */
public class XmlTest {

    @Test
    public void bean2xml() {

        Student student = new Student();
        student.setAge(10);
        student.setName("小明");
        student.setRemark("小明是位好同学，<hello>年年三好学生👩‍🎓");

        System.out.println(XmlBeanUtil.object2Xml(student));
    }

    @Test
    public void xml2bean() {
        String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><student><name>小明</name><age>10</age><remark><![CDATA[小明是位好<abcdedf>同学，年年三好学生👩‍🎓]]></remark></student>";
        Student student = XmlBeanUtil.xml2Object(xml, Student.class);
        System.out.println(student.getAge());
        System.out.println(student.getName());
        System.out.println(student.getRemark());
    }

    @Getter
    @Setter
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlRootElement
    public static class Student {

        @XmlElement
        private String name;

        @XmlElement
        private int age;

        @XmlElement
        @XmlJavaTypeAdapter(CDATAAdapter.class)
        private String remark;
    }

}
