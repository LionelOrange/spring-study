package org.yamikaze.spring.study.senior;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;
import org.yamikaze.spring.study.senior.impl.UserServiceImpl;

/**
 * 扩展至BeanPostProcessor,在填充bean完成后执行
 * @author qinluo
 * @date 2017/12/20
 */
@Component
public class StudyBeanPostProcessor implements BeanPostProcessor{

    /**
     * 在populateBean方法后调用
     */
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println(beanName + ":" + bean.getClass().getSimpleName());
        if(bean instanceof UserServiceImpl) {
            System.out.println(((UserServiceImpl) bean) .getText());
        }
        return bean;
    }


    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println(beanName + " :" + bean.getClass().getSimpleName());
        if(bean instanceof UserServiceImpl) {
            System.out.println(((UserServiceImpl) bean) .getText());
        }
        return bean;
    }
}
