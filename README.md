## 파일입출력을 통한 게시판 구현하기

 ### 기능
 1. 등록
 2. 삭제
 3. 수정
 4. 빌드
 
 ## 추가로 구현한 기능
 
 ### 등록시 명언에 어울리는 키워드를 입력시 gif파일 이미지 생성
 ![image](https://user-images.githubusercontent.com/72914519/179162549-29b94d73-d263-4025-8a4a-aac0b1bf9caa.png)
  [이미지 링크 URL]: https://lynmp.com](https://media2.giphy.com/media/du4D0b0HWgxGg/giphy.gif?cid=9a22a94e5j3i73wt14op4d31tpuyq0gm0m6jnqjem4iuxqi0&rid=giphy.gif&ct=g
 
###  등록시 등록 일자 추가   ```"createdTime": "2022-07-15"```
 
###  빌드시에  data.json 파일을 업데이트하기엔 번거로운 작업 git add && commit && push 생략하고 자동화(S3에 업로드)
 ![image](https://user-images.githubusercontent.com/72914519/179163084-06888817-9549-4b98-8076-be4b43f72890.png)
[data.json 링크] : [https://ssgproject.s3.ap-northeast-2.amazonaws.com/data.json]

하지만 코드 팬에서 s3링크를 읽지 못한다.


최종 결과물

<img src="https://user-images.githubusercontent.com/72914519/179165986-9c712b46-9778-4060-868e-9e060d853f9a.png" width="50%" height="50%" />

[codepen 링크] : https://codepen.io/jhdl0157/pen/NWYbBXa?editors=0010
<p>
사용한 라이브러리

```giphy4j(1.0.1)``` , ```aws-java-sdk-s3(1.11.901)```
