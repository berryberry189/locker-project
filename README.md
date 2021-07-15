# locker-project
물품 보관함 api

### 테이블 설계
![물품보관함 테이블](https://user-images.githubusercontent.com/58412521/125407903-4c358280-e3f5-11eb-8e8a-da92f83e5874.PNG)

### 엔티티 설계
<img src = "https://user-images.githubusercontent.com/58412521/125769825-433d5821-fc5a-4c68-9194-53c7556b1f50.jpg" width="50%" height="50%">

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
