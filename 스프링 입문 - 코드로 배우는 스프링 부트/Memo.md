# 💪 스프링 입문 - 코드로 배우는 스프링 부트

build.gradle : 프로젝트 설정 파일

sourceCompatibility : 자바 버전 설정 

```gradle
repositories {
	mavenCentral()
}
```

`mavenCentral` 에서 다운받아라! 라는 의미입니다.

현업에선 log를 남겨서 확인합니다.

ch.qos.logback-classic: 1.2.3 이나 org.slf4j:jul-to-slf4j:1.7.30 을 확인해봐야 합니다.  

test는 junit5 버젼으로 넘어가는 추세입니다.  

spring-test라는 spring에서 통합해서 확인하는 방법이 있습니다.

`@ResponseBody`는 http body 부분에 데이터를 추가해줍니다.

ctrl + P : 함수 설몀 보기

ctrl + shift + Enter : 자동 완성

alt + insert : 생성자, getter, setter 자동완성

getter, setter을 사용하는 방식을 프로포티 방식 

* 자바 Bean 규약을 이행한다.

객체를 http 응답을 할 땐, json 객체로 응답한다.

객체를 json으로 바꾸는 라이브러리는 Jackson, Gson이 있습니다.

클라이언트의 HTTP Accept 해더와 서버의 컨트롤러 반환 타입 정보 둘을 조합해서 HttpMessageConverter 가 선택된다

## 관련 예제

