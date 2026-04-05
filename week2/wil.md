# 2주차 WIL

## 1. 2주차에 배운 내용

### 계층형 아키텍처 (Layered Architecture)

* Spring은 역할에 따라 계층을 나누는 구조를 사용한다.

* Controller, Service, Repository로 구성되며 각 계층은 독립적인 책임을 가진다.

* 요청 흐름은 다음과 같다.
  Client → Controller → Service → Repository → DB

* Controller는 요청과 응답을 처리한다.

* Service는 비즈니스 로직을 수행한다.

* Repository는 데이터 저장 및 조회를 담당한다.

---

### DTO와 Entity

* DTO(Data Transfer Object)는 필요한 데이터만 전달하기 위한 객체이다.

* Entity는 데이터베이스와 직접 매핑되는 객체이다.

* DTO는 외부와의 데이터 교환에 사용되고,

* Entity는 내부 데이터 관리에 사용된다.

---

### Spring Bean과 DI (Dependency Injection)

* Spring은 객체를 Bean으로 관리한다.
* DI를 통해 필요한 객체를 외부에서 주입받는다.
* 객체를 직접 생성하지 않고 관리하기 때문에 유지보수성과 재사용성이 향상된다.

---

### Service 계층의 역할

* Service는 비즈니스 로직을 처리하는 핵심 계층이다.
* 여러 작업을 하나의 흐름으로 묶어 처리한다.
* 데이터 처리의 중심 역할을 수행한다.

---

### REST API 구현

* HTTP Method와 URI를 활용하여 API를 설계하였다.

* POST: 데이터 생성

* GET: 데이터 조회

* PATCH: 데이터 수정

* DELETE: 데이터 삭제

---


## 2. 구현 내용

### Member 도메인 구현

* MemberController를 통해 HTTP 요청을 처리하였다.
* MemberService에서 회원 생성, 조회, 수정, 삭제 로직을 구현하였다.
* 데이터는 메모리 기반으로 저장하여 관리하였다.

---

## 3. 느낀 점

* 계층형 아키텍처를 통해 코드의 역할이 명확히 분리된다는 것을 이해할 수 있었다.
* Service 계층이 실제 비즈니스 로직을 담당한다는 점이 중요하다고 느꼈다.
* DTO를 통해 데이터 전달 구조를 분리하는 이유를 이해할 수 있었다.
* DI를 통해 객체를 관리하는 방식이 코드의 유연성을 높인다는 것을 느꼈다.
* Postman을 활용하여 API를 직접 테스트하면서 백엔드 개발 흐름을 경험할 수 있었다.
