## 파일입출력을 통한 게시판 구현하기

### [결과물 보러가기] : https://codepen.io/jhdl0157/full/NWYbBXa


 ### 기능
 1. 등록
 2. 삭제
 3. 수정
 4. 빌드
 5. 조회
 
 ## 추가로 구현한 기능
 
 ### 등록시 명언에 어울리는 키워드를 입력시 gif파일 이미지 생성
 ![image](https://user-images.githubusercontent.com/72914519/179162549-29b94d73-d263-4025-8a4a-aac0b1bf9caa.png)
  [이미지 링크 URL]: https://media2.giphy.com/media/du4D0b0HWgxGg/giphy.gif?cid=9a22a94e5j3i73wt14op4d31tpuyq0gm0m6jnqjem4iuxqi0&rid=giphy.gif&ct=g
 
###  등록시 등록 일자 추가   ```"createdTime": "2022-07-15"```
 
###  빌드시에  data.json 파일을 업데이트하기엔 번거로운 작업 git add && commit && push 생략하고 자동화(S3에 업로드)
 ![image](https://user-images.githubusercontent.com/72914519/179163084-06888817-9549-4b98-8076-be4b43f72890.png)
[data.json 링크] : [https://ssgproject.s3.ap-northeast-2.amazonaws.com/data.json]

하지만 코드 팬에서 s3링크를 읽지 못한다.


최종 결과물

<img src="https://user-images.githubusercontent.com/72914519/179173650-d40addf4-61ab-4742-9b6c-dea16c3eb359.png" width="40%" height="40%" />

<p>
사용한 라이브러리

```giphy4j(1.0.1)``` API_KEY 받기 https://developers.giphy.com/docs/api

```aws-java-sdk-s3(1.11.901)``` AWS IAM KEY 발급받기
