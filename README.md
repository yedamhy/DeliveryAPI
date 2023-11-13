# DeliveryAPI
## user
- 로그인 api
- 로그아웃 api
- 회원가입 api
  
## 음식점 조회
- 카테고리 조회 api - (양식, 한식, 분식, ..)
- 음식점(가게) 목록 조회 api - (엽기떡볶이, 신전떡볶이, 떡참, ...)
  - 음식점 평점 및 리뷰 기반 정렬 기능
- 가게 상세(메뉴 목록) 조회 api - (가게 클릭했을 때 나오는 메뉴 list)
  - 메뉴별 가격 정보
  - 영업 시간, 최소 주문 금액, 배달 비
- 음식 상세 조회 api - (음식 클릭하면 나오는 상세 조회)
  - 음식의 영양 정보나 알레르기 유발 성분
  - 추가 선택 사항
  - 음식 이미
- 리뷰 조회 api

## 주문
- 주문 등록 api
- 주문 수정or취소 api
- 결제 api 와 연동..?

## 주문내역
- 주문내역 조회 api
- 주문 상태 업데이트 조회 -(조리중, 배달 중, 배달 완료)
  
## 찜
  - 찜 조회 api
  - 찜 등록 api
  - 찜 취소 api

## 검색
  - 검색 api

## 이벤트 
  - 진행 중인 이벤트 조회 api

## 쿠폰 
  - 쿠폰 등록 api
  - 쿠폰 사용 api - 결제 api 와 연동
<hr>

# 🎈REST API 설계

## 🥘음식 관련 API

### ✔️단일 음식 등록
- **Endpoint**: `/foods`
- **Method**: `POST`
- **Description**: 새로운 음식을 등록합니다.

### ✔️단일 음식 조회
- **Endpoint**: `/foods/{id}`
- **Method**: `GET`
- **Description**: 특정 ID의 음식 상세 정보를 조회합니다.

### ✔️단일 음식 수정
- **Endpoint**: `/foods/{id}`
- **Method**: `PUT`
- **Description**: 기존 음식의 정보를 수정합니다.

### ✔️단일 음식 삭제
- **Endpoint**: `/foods/{id}`
- **Method**: `DELETE`
- **Description**: 특정 ID의 음식을 삭제합니다.

추후 추가로 더 upload .. 
