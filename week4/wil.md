# Week 4 - WIL (What I Learned)

## 학습 내용 정리

### 1. ERD (Entity-Relationship Diagram)

ERD는 데이터베이스 설계를 위한 데이터 청사진이다.

- **Entity(개체)**: 관리해야 할 데이터의 주체 (ex. Member, Product, Order)
- **Attribute(속성)**: 각 엔티티가 가지는 구체적인 정보. 속성 = 필드(Field) = 컬럼(Column)
- **Relation(관계)**: 개체 사이의 연관성, 업무 규칙

#### 관계의 종류
- **일대다 (1:N)**: 1명의 회원은 여러 개의 주문을 가진다 → Order 테이블이 member_id (FK)를 가짐
- **다대다 (N:M)**: 중간 테이블(연결 엔티티)로 해결. ex. 학생-강의 → 수강신청 테이블 도입

#### 핵심 용어
| 용어 | 설명 |
|------|------|
| PK (Primary Key) | 각 행을 고유하게 식별하는 컬럼 |
| FK (Foreign Key) | 다른 테이블의 PK를 참조하는 컬럼. 테이블 간 연결고리 |
| 식별 관계 | 관계 대상의 PK를 자신의 PK로도 사용 (강한 연관) |
| 비식별 관계 | 관계 대상의 PK를 자신의 FK로만 사용 (느슨한 연관, 보통 선택) |

---

### 2. JPA & ORM

#### ORM (Object-Relational Mapping)
- 객체와 관계형 데이터베이스의 데이터를 자동으로 매핑해주는 기술
- 객체-데이터베이스 간 패러다임 차이 해결
- 반복적인 CRUD SQL을 자동으로 처리

#### JPA (Java Persistence API)
- 자바 진영의 ORM 기술 표준
- 자바에서 객체를 데이터베이스에 저장하고 관리하기 위한 인터페이스와 기능을 제공하는 API
- 대표적인 JPA 구현체: **Hibernate**
- ORM과 JPA를 통해 엔티티를 스캔 → DB 테이블 생성

#### H2 데이터베이스
- 자바로 작성된 인메모리 관계형 데이터베이스
- 가볍고, 빠르고, 별도 설치 불필요
- 개발/테스트 환경에서 유용

---

### 3. 엔티티(Entity) 구현

엔티티 = 자바와 DB가 소통하는 단위

#### 주요 어노테이션

| 어노테이션 | 설명 |
|------------|------|
| `@Entity` | 해당 클래스가 JPA 엔티티임을 선언 |
| `@Table(name = "...")` | 매핑할 DB 테이블명 지정 |
| `@Id` | PK 필드 지정 |
| `@GeneratedValue(strategy = GenerationType.IDENTITY)` | PK 자동 생성, DB에게 키 값 결정 위임 |
| `@Column(name = "...")` | 컬럼명, 길이 등 지정 |
| `@NoArgsConstructor(access = AccessLevel.PROTECTED)` | JPA 사용을 위한 인자 없는 생성자 (외부 사용 차단) |
| `@Getter` | 모든 필드에 getter 생성 |

#### 외래 키(FK) 매핑

```java
// 외래 키 매핑 예시 (Order -> Member, N:1)
@ManyToOne(fetch = FetchType.LAZY)
@JoinColumn(name = "member_id")
private Member member;
```

- `@JoinColumn`: FK 컬럼 정보를 명시 (name 등)
- `@ManyToOne`: 해당 외래키로 생기는 연관관계 종류 (다대일)
- `fetch = FetchType.LAZY`: 지연 로딩. Order 조회 시 Member 정보는 필요할 때만 가져옴

#### EAGER vs LAZY
- **EAGER (즉시 로딩)**: Order 조회 시 연결된 Member 정보를 한번에 전부 가져옴
- **LAZY (지연 로딩)**: Order 조회 시 Member 정보는 실제로 접근할 때 가져옴 → 성능상 권장

---

### 4. API 테스트 with Postman

- 어드민 프로젝트는 별도 프론트엔드(HTML/React)가 없으므로 API 직접 테스트 필요
- Postman을 통해 CRUD API 테스트 가능
- 성공/실패 케이스 모두 테스트하는 것이 중요

---

## 이번 주 느낀 점

엔티티 설계가 백엔드 개발의 핵심이라는 걸 느꼈다. 특히 N:M 관계를 중간 테이블로 풀어야 한다는 것, `@ManyToOne`에 LAZY 로딩을 써야 성능에 유리하다는 것이 인상 깊었다. JPA 덕분에 SQL을 직접 작성하지 않아도 테이블이 자동 생성되는 게 신기했다.

---

## 이미지 첨부

- `shop_erd.img` - ERD Cloud로 설계한 DB ERD 스크린샷
- `h2_connection.img` - 스프링 실행 후 H2 콘솔에서 생성된 테이블 스크린샷
- `api_succeed.img` - Postman API 성공 케이스 스크린샷
- `api_failure.img` - Postman API 실패 케이스 스크린샷
