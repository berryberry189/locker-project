# locker-project
물품 보관함 api

### 테이블 설계
<img width="1039" alt="테이블구조" src="https://user-images.githubusercontent.com/58412521/126139844-29ba164b-83d3-4462-a4d1-12d9f9372d56.png">

### 엔티티 설계
<img width="543" alt="엔티티 설계" src="https://user-images.githubusercontent.com/58412521/126312696-e56768de-b027-4094-854f-f2f129096ef0.png">

## API 명세

**UserController**
  
| URL           | 실행 작업   | Method Type | Request      | Response     |
|:--------------|:------------|:------------|:-------------|:-------------|
| /user           | 모든 목록 조회 | GET    |      |List\<UserResponseDto\>|
| /user/{userKey} | 상세 | GET   | userKey  | userLendResponseDto |  
| /user           | 등록 | POST  | userCreateRequestDto | userKey |
| /user /{userKey}| 수정 | PUT   | userKey, userUpdateRequestDto | userKey |
| /user/{userKey} | 삭제 | DELETE| userKey | userKey |  

 <br>
  
 **LockerController**
  
| URL           | 실행 작업   | Method Type | Request      | Response     |
|:--------------|:----------- |:------------|:-------------|:-------------|
| /locker       | 목록        | GET   |      | List\<LockerResponseDto\> |
| /locker/{areaId}| 구역 별 목록 조회 | GET | areaId | List\<LockerResponseDto\> |
| /locker       | 등록        | GET   | lockerCreateRequestDto | lockerNo |
| /locker/{areaId}/{lockerNo} | 수정 | PUT   | areaId, lockerNo, lockerRequestDto | lockerNo |
| /locker/{areaId}/{lockerNo} | 삭제 | DELETE| areaId, lockerNo | lockerNo |  
  
 <br>
  
 **LendController**
| URL           | 실행 작업   | Method Type | Request      | Response     |
|:--------------|:------------|:------------|:-------------|:-------------|
| /lend   | 전체 조회  | GET  |      | List\<LendResponseDto\> |
| /lend   | 대여       | GET  | lendRequestDto | id |
| /return/{id} | 반납  | PUT  | id   | id |
