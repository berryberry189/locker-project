# locker-project
물품 보관함 api

### 테이블 설계
![물품보관함 테이블](https://user-images.githubusercontent.com/58412521/125407903-4c358280-e3f5-11eb-8e8a-da92f83e5874.PNG)

### 엔티티 설계
<img src = "https://user-images.githubusercontent.com/58412521/125412392-d849a900-e3f9-11eb-8518-880e968389b3.jpg" width="50%" height="50%">

## API 명세

**UserController**
  
| URL           | 실행 작업   | Method Type | Request      | Response     |
|:--------------|:------------|:------------|:-------------|:-------------|
| /user  | 모든 목록 조회 | GET   |      |      |
| /user/{areaId}  | 구역 별 목록 조회 | GET   |      |      |
| /user/{userKey} | 상세 | GET  |      |      |  
| /user   | 등록 | GET   | POST |      |
| /user /{userKey}  | 수정 | PUT   |      |      |
| /user/{userKey} | 삭제 | DELETE  |      |      |  

 <br>
  
 **LockerController**
  
| URL           | 실행 작업   | Method Type | Request      | Response     |
|:--------------|:----------- |:------------|:-------------|:-------------|
| /locker       | 목록        | GET   |      |      |
| /locker       | 등록        | GET   |      |      |
| /locker/{areaId}/{lockerNo} | 수정 | PUT   |      |      |
| /locker/{areaId}/{lockerNo} | 삭제 | DELETE|      |      |  
  
 <br>
  
 **LendrController**
| URL           | 실행 작업   | Method Type | Request      | Response     |
|:--------------|:------------|:------------|:-------------|:-------------|
| /lend   | 전체 조회  | GET  |      |      |
| /lend   | 대여       | GET  |      |      |
| /return/{id} | 반납  | PUT  |      |      |
