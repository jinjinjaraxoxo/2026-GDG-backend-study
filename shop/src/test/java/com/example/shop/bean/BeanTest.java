package com.example.shop.bean;

import com.example.shop.member.service.MemberService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Import;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Import(TestConfig.class)
class BeanTest {

    @Autowired
    private ApplicationContext ac;

    @Autowired
    private MemberService memberService;

    @Autowired
    private MyBean myBean;

    @Test
    @DisplayName("스프링 컨테이너에 MyBean이 등록되어 있다")
    void myBeanRegistered() {
        MyBean bean = ac.getBean(MyBean.class);
        assertThat(bean).isNotNull();
        assertThat(bean.hello()).isEqualTo("Hello from MyBean!");
    }

    @Test
    @DisplayName("스프링 빈은 싱글톤으로 관리된다")
    void beanIsSingleton() {
        MyBean bean1 = ac.getBean(MyBean.class);
        MyBean bean2 = ac.getBean(MyBean.class);
        assertThat(bean1).isSameAs(bean2);
    }

    @Test
    @DisplayName("MemberService 빈이 스프링 컨테이너에 등록되어 있다")
    void memberServiceRegistered() {
        MemberService service = ac.getBean(MemberService.class);
        assertThat(service).isNotNull();
    }
}
