# 1주차 WIL

## 1. 1주차에 학습한 내용

### 웹(Web)과 인터넷(Internet)
- 인터넷은 전 세계 컴퓨터와 기기를 연결하는 거대한 글로벌 네트워크이다.
- 웹은 인터넷 위에서 동작하는 서비스 중 하나이며, 인터넷에 연결된 사용자들이 정보를 공유할 수 있는 공간이다. 

### 클라이언트(Client) - 서버(Server) 모델
- 웹은 클라이언트와 서버가 요청(Request)과 응답(Response)을 주고받는 방식으로 동작한다.
- 클라이언트는 요청을 보내고, 서버는 요청을 처리한 뒤 응답을 반환한다. 

### URL
- URL(Uniform Resource Locator)은 웹 상에서 특정 자원의 위치를 나타내는 주소이다.
- URL은 Scheme(Protocol), Host, Port, Path, Query 등으로 구성될 수 있다. 

### HTTP
- HTTP(HyperText Transfer Protocol)는 웹에서 데이터를 주고받는 서버-클라이언트 모델의 프로토콜이다.
- HTTP는 클라이언트의 요청(Request)과 서버의 응답(Response)을 통해 동작한다.
- HTTP의 특징으로는 무상태성(Stateless)과 비연결성(Connectionless)이 있다. 

### HTTP 주요 메서드
- GET: 리소스를 조회한다.
- POST: 리소스를 추가하거나 등록한다.
- PUT: 리소스를 교체하고, 없으면 새로 생성한다.
- PATCH: 리소스의 일부를 수정한다.
- DELETE: 리소스를 삭제한다. 

### HTTP 상태 코드
- 200 OK: 요청이 성공적으로 처리되었음을 의미한다.
- 201 Created: 요청이 성공적으로 처리되어 새로운 리소스가 생성되었음을 의미한다.
- 400 Bad Request: 잘못된 요청이다.
- 404 Not Found: 요청한 리소스를 찾을 수 없다.
- 500 Internal Server Error: 서버 내부 오류이다. 

### 프론트엔드(Front-end)와 백엔드(Back-end)
- 프론트엔드는 사용자가 직접 보는 화면과 UI를 담당한다.
- 백엔드는 사용자의 요청을 처리하고, 데이터를 저장하고 관리하는 역할을 한다.
- 서버가 다루는 데이터는 데이터베이스(Database, DB)에 저장되며, 대표적인 DBMS로 MySQL, PostgreSQL, MongoDB 등이 있다. 

### API와 REST API
- API(Application Programming Interface)는 프로그램 간의 기능과 데이터를 주고받기 위한 규칙이자 소통 창구이다.
- REST는 HTTP의 장점을 최대한 활용하기 위한 아키텍처 스타일이다.
- REST API는 자원(Resource)을 URI로 식별하고, HTTP Method를 사용하여 행위(Verb)를 정의하며, JSON 등의 형식으로 데이터를 표현하는 방식이다. 

### Spring과 Spring Boot
- Spring은 Java 엔터프라이즈 애플리케이션 개발에 사용되는 오픈소스 프레임워크이다.
- Spring Boot는 복잡한 초기 설정 없이도 Spring을 빠르고 쉽게 사용할 수 있게 해주는 도구이다. 

---

## 2. Spring Boot 실행 화면

### Whitelabel Error Page 스크린샷
<img width="805" height="641" alt="스크린샷 2026-03-28 오후 11 01 02" src="https://github.com/user-attachments/assets/5852be81-7c25-49fc-aef2-456d58841c04" />

---

## 3. 온라인 쇼핑몰 프로젝트 API 명세서

### 상품(Product) 기능

#### 1) 상품 정보 등록
- HTTP Method: POST
- URI: /products

#### 2) 상품 목록 조회
- HTTP Method: GET
- URI: /products

#### 3) 개별 상품 정보 상세 조회
- HTTP Method: GET
- URI: /products/{productId}

#### 4) 상품 정보 수정
- HTTP Method: PATCH
- URI: /products/{productId}

#### 5) 상품 삭제
- HTTP Method: DELETE
- URI: /products/{productId}

### 주문(Order) 기능

#### 1) 주문 정보 생성
- HTTP Method: POST
- URI: /orders

#### 2) 주문 목록 조회
- HTTP Method: GET
- URI: /orders

#### 3) 개별 주문 정보 상세 조회
- HTTP Method: GET
- URI: /orders/{orderId}

#### 4) 주문 취소
- HTTP Method: PATCH
- URI: /orders/{orderId}/cancel

---

## 4. 느낀 점
- 이번 1주차를 통해 웹이 클라이언트와 서버의 요청/응답 구조로 동작한다는 점을 다시 정리할 수 있었다.
- 또한 HTTP Method와 URI를 어떻게 설계하느냐에 따라 API가 훨씬 직관적이고 일관성 있게 구성될 수 있다는 점을 배웠다.
- REST API는 단순히 URL을 만드는 것이 아니라, 자원과 행위를 명확하게 구분하여 설계하는 방식이라는 점이 인상적이었다.
