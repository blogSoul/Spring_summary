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

repository는 저장소를 의미합니다.  

Optional은 Java 8 버전에 있는 기능으로 Null 처리하는데 사용됩니다.

Optional을 쓰는 단축키는 ctrl+alt+v 입니다.

동시성 문제 때문에 공유되는 변수는 컨커럿 변수를 사용해야 합니다.

Ex) 실무에서는 ConcurrentHashMap, AtomicLong 사용 고려  

null이 있을 가능성이 있으면 `Optional.ofNullable()` 을 사용합니다.

실무에선 List를 많이 사용합니다. 

alt + Enter로 해당 함수의 상태 및 필요 기능을 불 수 있다.

shift + F6로 해당 변수를 사용하는 모든 이름을 전체 지정할 수 있습니다.

테스트를 먼저 만들고 다음 구현을 하는 방법을 테스트 주도 개발(TDD)이라고 부릅니다.

나중에 십만 라인 넘어가면 테스트 없이 개발이 불가능하니 테스트를 꼭 공부하세요!

ctrl+alt+v 는 해당 클래스를 Optional로 바꿔주는 단축키입니다.

ctrl + alt + shift + T 는 해당 클래스를 리팩토링할 때 사용하는 단축키입니다.

service에 해당되는 메소드는 비지니스 기능과 최대한 비슷하게 만들 수 있도록 해야 합니다.

ctrl + shift + T는 해당 클래스를 테스트하는 코드를 만들어줍니다.

테스트 코드는 한글로 쳐도 됩니다.(김영한님 의견)

테스크 코드는 `// given // when // then`으로 하는게 좋습니다.

shift + F10 은 이전에 실행했던 코드를 다시 실행한다.

블럭 단위 주석하는 단축키는 ctrl + shift + /  

```
public void beforeEach() {
    memberRepository = new MemoryMemberRepository();
    memberService = new MemberService(memberRepository);
}
```

memberService 안에 memberRepository를 넣었으므로 DI(Dependency Injection)이라고 부릅니다.

## IntelliJ에서 단축키를 확실하게 검색하는 방법

1. File -> Settings에 들어간다.

2. 다음 화면 왼쪽에 보이는 것 처럼 keymap을 선택한다.

3. 다음 화면 오른쪽에 있는 검색창에 단축키 이름을 입력한다. 단축키 이름은 위 그림 처럼 영상 하단에 나온다.

4. 다음 그림을 보면 Refactor This의 윈도우 단축키는 Ctrl + Alt + Shift + T 인 것을 알 수 있다.

controller가 MemberService를 의존하고 있게 만들어줘야 합니다.

@Autowired 는 spring Container에 등록되는 Controller에 해당되는 Service를 넣어줍니다.

스프링 빈을 등록하는 2가지 방법

1. 컴포넌트 스캔과 자동 의존관계 설정 (Component Scan)

2. 자바 코드로 직접 스프링 빈 등록하기

Bean을 등록하는 기준은 `@SpringBootApplication` 을 실행하는 package를 기준으로 합니다.

스프링은 스프링 컨테이너에 스프링 빈을 등록할 때, 기본적으로 싱글톤으로 등록합니다.(유일하게 하나만 등록해서 공유합나다.)

DI에서 필드 주입을 하면 변경할 때, 바꾸기 힘듭니다. 

DI에서 setter 주입하면 public으로 노출이 되서 호출하지 않아도 되는 setter를 계속 호출해야 합니다.

XML로 설정하는 방식도 있지만 최근에는 잘 사용하지 않으므로 생략한다.

DI에는 필드 주입, setter 주입, 생성자 주입 이렇게 3가지 방법이 있다. 의존관계가 실행중에
동적으로 변하는 경우는 거의 없으므로 생성자 주입을 권장한다.

실무에서는 주로 정형화된 컨트롤러, 서비스, 리포지토리 같은 코드는 컴포넌트 스캔을 사용한다.
그리고 정형화 되지 않거나, <strong>상황에 따라 구현 클래스를 변경해야 하면 설정을 통해 스프링 빈으로
등록한다.</strong>

@Autowired 를 통한 DI는 helloConroller , memberService 등과 같이 스프링이 관리하는
객체에서만 동작한다. 스프링 빈으로 등록하지 않고 내가 직접 생성한 객체에서는 동작하지 않는다.

컨트롤러가 정적 파일보다 우선순위가 높다.

Ex) home.html > index.html

파일 형식 인식이 되지 않는 경우, File > File Properties > Associate with File Type... 선택

POST는 데이터를 전달할 때 많이 사용하고, GET은 데이터를 조회할 때 많이 사용합니다.

`<input name="~~">`을 통해 값을 넣어주게 됩니다.

이전 파일을 보고 싶으면 ctrl + E을 사용하면 됩니다.

## DB 연결

` by default as identity` 은 null일 때, 자동으로 해당 값을 채워줍니다.

insert문 예시 : `insert into member(name) values('spring2')`

