# 5주차 WIL - SOLID 원칙과 스프링 빈

---

## 1. 객체 지향이란?

Java는 **객체 지향** 언어이고, 스프링은 Java 기반 프레임워크다.
스프링은 Java의 가장 큰 특징인 "객체 지향"을 잘 살려내서, **좋은 객체 지향 프로그램을 개발할 수 있도록 도와주는 프레임워크**다.

### 객체 지향 프로그래밍 (OOP)

컴퓨터 프로그램을 여러 독립적인 부품들의 조합, 즉 **객체들의 상호작용**으로 파악하고자 하는 컴퓨터 프로그래밍의 패러다임이다.

- 프로그램을 묶음 단위로 잘게 쪼개서 레고 블럭 조립하듯 전체 프로그램을 완성
- **유연하고 변경이 용이**하기 때문에 현업에서 대규모 소프트웨어 개발에 많이 사용

### 객체 지향의 4가지 특징

| 특징 | 설명 |
|------|------|
| **추상화** | 객체의 공통적인 속성과 기능을 추출하여 정의하는 것 |
| **캡슐화** | 서로 연관있는 속성과 기능들을 하나의 캡슐로 만들어 데이터를 외부로부터 보호하는 것 |
| **상속** | 기존 클래스의 속성과 기능을 새로운 클래스가 물려받아 재사용하는 것 |
| **다형성** | 어떤 객체의 속성이나 기능이 상황에 따라 여러 가지 형태를 가질 수 있는 성질 |

### 다형성이 중요한 이유

다형성 = **어떤 역할에 대해 여러 가지 구현 방식이 존재할 수 있는 것**

객체를 사용하는 쪽(클라이언트)은:
- 대상의 **역할만 알면** 된다
- 실제 구현이 어떻게 동작하는지 알 필요가 없다
- 구현 대상의 내부 구조가 변경되어도 영향을 받지 않는다
- **구현 대상 자체가 변경되어도 영향을 받지 않는다**

→ 다형성은 프로그램을 유연하고, **변경에 용이**하게 해준다!

### Java에서 다형성 적용하기
- **역할** → 인터페이스
- **구현** → 인터페이스를 구현한 클래스

인터페이스: 클래스가 구현해야 하는 메서드의 집합. 클래스의 설계도, 틀.

---

## 2. SOLID 원칙

좋은 객체 지향 설계를 위한 5가지 원칙

### S - SRP (단일 책임 원칙, Single Responsibility Principle)
- 하나의 클래스는 **단 한 개의 책임**을 가져야 함
- 클래스를 변경하는 이유는 단 하나여야 함
- 하나의 클래스에 여러 기능이 있다면, 특정 기능이 변경될 때 다른 기능에도 영향을 미치게 되어 수정해야 할 코드가 많아짐
- 목적: 프로그램의 **유지보수성**을 높이기 위한 것

### O - OCP (개방-폐쇄 원칙, Open/Closed Principle)
- 클래스는 **확장에 열려**있어야 하며, **수정에는 닫혀** 있어야 함
- 기존 코드를 변경하지 않고 기능을 확장할 수 있도록 설계하는 것

```java
// OCP 위반 - 구현체를 바꾸려면 Service 코드를 직접 수정해야 함
private final MemberRepository memberRepository = new JpaMemberRepository();

// OCP 만족 - 생성자 주입으로 외부에서 구현체를 받음
private final MemberRepository memberRepository;

public MemberServiceImpl(MemberRepository memberRepository) {
    this.memberRepository = memberRepository;
}
```

### L - LSP (리스코프 치환 원칙, Liskov Substitution Principle)
- 자식 클래스는 언제나 자신의 부모 클래스를 **대체**할 수 있어야 함
- 부모 클래스가 들어갈 자리에 자식 클래스를 넣어도 프로그램이 동일하게 작동해야 함
- 자식 클래스가 부모 클래스의 기능을 변경하면 안 됨
- 단순 문법적 상속을 넘어서 **행동적 호환성**까지 보장되어야 함

### I - ISP (인터페이스 분리 원칙, Interface Segregation Principle)
- 인터페이스를 각각 사용에 맞게끔 **잘게 분리**해야 함
- 클라이언트가 사용하지 않는 인터페이스에 의존하지 않도록 해야 함
- 하나의 큰 인터페이스보다 여러 개의 작은 인터페이스로 분리하는 것이 좋음
- 인터페이스가 명확해지고, **대체 가능성이 높아짐**

### D - DIP (의존관계 역전 원칙, Dependency Inversion Principle)
- **추상화에 의존**해야지, 구체화에 의존하면 안 됨
- 구현 클래스에 의존하지 말고, **인터페이스에 의존**해야 함
- 의존 관계를 맺을 때 변화하기 쉬운 것보다는, 변화하기 어려운 것에 의존

```java
// DIP 위반 - 인터페이스와 구현 클래스 모두에 의존
private final MemberRepository memberRepository = new JpaMemberRepository();

// DIP 만족 - 인터페이스에만 의존, 구현체는 외부에서 주입
private final MemberRepository memberRepository;
```

### 핵심

다형성만으로는 SOLID 원칙을 지킬 수 없다.
스프링은 SOLID 원칙을 지키기 위해 **의존성 주입(Dependency Injection)** 을 지원한다!

---

## 3. Spring Bean, DI, IoC

### IoC (Inversion of Control) - 제어의 역전

객체 생성 및 관리에 대한 제어권을 개발자가 아닌 **프레임워크**가 대신 가져가는 것

- 스프링에서는 객체를 생성하고 관리하는 역할을 **스프링 컨테이너**가 함
- 스프링 컨테이너를 **IoC 컨테이너**라고도 함

### Spring Container

- 스프링 빈 저장소
- Application Context (어플리케이션 컨텍스트)

### Spring Bean

- 어플리케이션 전역에서 사용할 **공용 객체**
- 스프링 컨테이너가 관리하는 객체
- 스프링 컨테이너(공용 창고)에 빈을 저장하고, 필요한 빈을 컨테이너에서 받아 사용

### 싱글톤 컨테이너

- 스프링 컨테이너는 객체를 딱 **1개만 생성**해서 필요할 때마다 재사용 → **싱글톤**
- 매번 필요한 객체를 생성하는 대신, 생성해둔 객체를 사용하므로 **메모리를 효율적으로 사용**

### DI (Dependency Injection) - 의존성 주입

IoC를 구현하는 방법. 내가 의존하는 객체를 직접 생성하지 않고 **밖에서 주입받는 것**

- 스프링 컨테이너에 필요한 객체(Bean)을 미리 생성해두고, 다른 객체에서 이 객체가 필요할 때 주입
- 인터페이스에만 의존하고, 구현 객체는 외부에서 주입받음
- 애플리케이션 실행 시점에 객체 간의 관계를 결정
- **느슨한 결합** → 한 클래스의 변경이 다른 클래스에 미치는 영향을 최소화
- 유연성, 유지보수성 높임

```java
@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository; // 인터페이스에만 의존
}
```

### Spring Bean 등록 방법

#### 1. 수동 등록 - 설정 파일 작성

```java
@Configuration
public class AppConfig {

    @Bean
    public MemberRepository memberRepository() {
        return new JpaMemberRepository();
    }

    @Bean
    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }
}
```

#### 2. 자동 등록 - 컴포넌트 스캔

- `@ComponentScan`: 어떤 클래스들이 Spring Bean인지 찾아서 등록 (`@SpringBootApplication`에 포함)
- `@Component`: 이 클래스가 Spring Bean이라고 표시
- `@Controller`, `@Service`, `@Repository` 등은 모두 `@Component`를 포함함

---

## 4. 이번 주 핵심 정리

```
스프링 = 객체 지향 + IoC/DI 컨테이너

다형성 (인터페이스 + 구현체 분리)
    + SOLID 원칙
    + DI (의존성 주입)
    = 유연하고 확장성 있는 코드
```

- **역할과 구현을 분리**: 인터페이스를 사용해서 어떤 구현체든 교체 가능하게
- **스프링 컨테이너**: 빈(객체)을 싱글톤으로 관리하고 필요한 곳에 주입
- **생성자 주입**: DIP, OCP를 지키면서 의존관계를 외부에서 결정

이번 주를 통해 지난 4주 동안 자연스럽게 써왔던 `@Service`, `@Repository`, `@Autowired` 같은 애노테이션들이 왜 존재하는지, 스프링이 내부적으로 어떻게 동작하는지를 제대로 이해할 수 있었다.
