//package com.chernenkov.marks;
//
//import junit.framework.Assert;
//import org.junit.Ignore;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.support.ClassPathXmlApplicationContext;
//
//import static com.chernenkov.marks.common.AttributeType.*;
//
//public class TestUpdate {
//    @Ignore
//    @org.junit.Test
//    public void test() {
//        ApplicationContext context = new ClassPathXmlApplicationContext("/spring/db.config.xml");
//        ParamServiceImpl paramService = context.getBean(ParamServiceImpl.class);
//        String begin = "19:00";
//
//        paramService.updateParam(BEGIN, LOGIN, "anna", begin);
//
//        Assert.assertEquals(begin, paramService.getParam(BEGIN, LOGIN, "anna").getValue());
//    }
//
//}
