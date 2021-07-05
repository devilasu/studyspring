#### 20210705 (월) 작업
- ajax를 이용한 admin boards 부분 갱신 해결.
- 생성 부분에서 정지.
- -------------------
- 페이징, 서칭 먼저 구현 시작.
- jsp에서 page, keyword, searchType를 보내주면? Controller에서 처리 후, 넘겨준다.? 굳이 jsp에 날려줄 이유가 없다.
- AOP를 이용하여 AdminBoardController 내의 함수 끝부분이 List인 것은 전부 SearchVO를 날려준다...?

- 페이징과 서칭관련하여 SearchVO를 보드 관련해서 항상 넘겨줘야 하는가?AOP이용:컨트롤러이용.
- 현재 구조로는 jsp에서 type을 얻어낼 방법이 없다.서칭하고 돌려주면 그대로 데이터가 날아가기 때문.
- 매번 리스트에서 SearchVO를 불러 오는 것이 바람직한가? (고민)
- jsp에서 type, page, keyword, searchType를 넘겨주고 Controller에서는 결과값을넘겨주는 것... ListController들은 최로를 제외하고 searchVO를 넘겨주게 된다.
- 때문에 

- AdminBoardController의 두 함수를 합치는 작업.  type에 insertForm값이 들어오는 불상사 발생. 
- boards CUD 작업.
- insertForm을 호출하는 부분 작성. admin/boards/{type}/insert_form (get)
- 동작: type에 따라서 게시판추가의 type default 값이 달라지도록 만든다.


#### 계획표.
- admin 게시판 관리 CRUD 구현
- admin home메뉴CRUD구현.
- member, product 관련 테이블 구현.
- admin 사용자 관리 CRUD 구현
- admin 상품관리 CRUD 구현
- homeMenu를 다시 살려야 함.(의미 있는가? 이 부분은 신상품, 인기상품, 추천상품, 할인상품등의 품목이 들어갈 예정.)
- 장점: db에 추가하고 Controller에 추가, jsp생성으로 손쉽게 유지보수 가능.
- 인기상품, 추천상품을 표시해주는 테이블을 생성. 유지보수는 쉬워지는데 성능은? 일단 해보자.
- db는 안지워져서 존재, vo는 공용이므로 DAO부터 구현하면 재생 가능.
- ajax를 이용하여 content의 tiles만 변경이 가능한가? javascript로 제어 해볼만 하다.
- 만약 ajax로 tiles만 변경이 안된다면 content로 하나의 타일을 만들어서 내부에서 left, right로 처리, ajax 처리를 해야겠다.

- 메뉴관리: tbl_board_type, 게시판관리: tbl_board, 유저관리: tbl_member(예정), 상품관리: tbl_product(예정)
- left에 CRUD를 넣어주고 content에 insert_form, update_form, list, delete
- nav와 left, content에 어떠한 내용을 넣을지 구상 필요.(꼬여있음)

- admin에서는 noLeft를 사용해도 된다.(CRUD는 한 페이지로 충분히 구현 가능하기 때문에)
- 사용자가 보는 홈에서는?
- 홈의 레이아웃 구상이 필요하다. nav와 left의 용도. (홈 부분은 완전 새로 구상하자.)

#### 다음 작업시 주의사항
- 	기획은 꼼꼼하게 하자.
- 기존의 작업은 공부를 시작으로 하나의 프로젝트를 작업하기까지 지속적으로 DB와 설정, 구조가 변화되어 수정에 많은 시간이 소모되었다.
- 	주석처리의 중요성
- 이후 다시 확인작업을 하면서 수정 및 보완을 할 경우 주석은 많은 시간을 줄일 수 있게 해준다. 주석을 습관화 하자.
- 	데이터이동에 대한 기획서 필요
- 최소한 페이지와 컨트롤러 사이의 데이터 이동에 대한 문서가 필요하다. 이는 데이터 전송 구조를 파악해서 서버의 구조를 설계하는데 도움을 준다.
- 물론 이후 수정으로 인한 시간낭비를 줄일 수 있다는데 더 큰 의의가 있다.
- 페이지를 미리 작성해봄으로서 공통 변수를 확인할 수 있고 가능하다면 이름을 동일하게 주어서 작업량을 줄일 수 있다.
- 확실한 구분을 위해서는 그냥 공용페이지 하나를 더 제작하는 것도 나쁘지 않다. (현 작업의 left는 같은 변수명을 사용하는 것으로 left.jsp 하나로 처리하고 있다.)
- 위 작업은 후에 문제가 생길여지가 다분하니 차라리 분화해서 각자 작업하는 것도 나쁘지 않을 것 같다. (tiles의 구조를 좀 더 세분화, 구체화 할 필요가 있다.)
- DAO, Service 에서의 변수명 설정 시, DAO는 Mapper과 그대로 쓰되, 오버로딩보다 인자가 없는 함수는 selectALLList가 더 직관적일 듯 하다. 이는 Service도 마찮가지.

#### 20210703 (토) 작업
- 현재 에러부분 해결
- ajax통신에서 리턴값을 jsp로 할 수 있는것 같은데 Controller에서 처리하는 방법은?(해결되면 화면처리가 해결된다. ajax는 html안에 값을 넣는 것으로 처리)
- 기존 컨트롤러처럼 jsp 값을 리턴해보자.
- @Controller+@ResponseController = @RestController 이므로 굳이 RestController를 사용할 필요가 없다.
- - ajax를 사용하면 뷰도 ajax에 데이터값으로 전송된다.
- 위 부분이 확인되어 정상작동하면 화면처리 부분은 모두 해결.
- 코드 복습하며 주석처리.
- @RestController가 좋은 것이 아니라 @PostRequest처럼 그때 필요할 때, 구조상으로 객체만 보내는 컨트롤러를 구성할때 @ResponseBody를 쓰지 않기 위해 선언하는 것.


#### 20210702 (금) 작업
- boards에 CUD와 연결되는 버튼을 만들고 ajax로 갱신해보자
- 문제점 jsp의 내용을 전송하여 갱신하는 방법의 부재.
- 목록의 경우 list만 넘겨도 갱신이 가능하지만, 기왕이면 jsp페이지를 넘겨서 갱신하는 방식으로 만들고 싶다.
- 정 안된다면 데이터를 넘기고 ajax에서 html로 구현하는 방식을 사용.

- 현재 막힌 부분은 공부가 필요한 부분이므로, 넘기는 부분을 제외하고 서버에서 검색과 페이지 기능을 구현하기 위한 기본 준비 시작.
- 검색을 위한 boardMapper부분 수정, 
- 검색은 selectBoard를 오버로딩하여 생성.
- 검색기능구현중 Mapper의 if에서 변수처리 문제 발생. dao에서 map로 전달도 가능하나, pageVO, searchVO를 구현하여 함께 처리.
- pageVO, searchVO 생성. search시에는 항상 pageVO가 있으므로 searchVO안에pageVO 변수 생성.
- 페이지 계산부분 구현중.
- db sql 파일 복구.
- db erd 복구.
- pageVO의 계산식 구현(확인 필요.)
- 데이터간 이동에서 문제 발생.



#### 20210701 (목) 작업
- restAPI에 대한 개념, 이해 부분의 부족 체감. 이를 위해 공부
- ajax를 통해 비동기 업데이트 필요.(서치, 페이지, 게시판 타입 선택)
- url에 호출하는 값 변경. 이제는 boards 이후 호출 type에 따라 컨트롤러 구분.
- input, update는 폼이 따로 필요하므로, 이 부분도 ajax를 통해 부분 구현.
- tiles-define를 onLeft, noLeft로 구분. tiles를 호출하는 부분에 on, no를 붙이는 것으로 각기 다른 jsp를 호출하게 설정
- no,on이후 오는 admin, home 등은 구분을 나타내며 이후 나오는 문자가 content의 jsp를 가리킨다.
- AOP는 메뉴 관련 부분을 지속적으로 전송.


#### (구)해야할 일-일부 해결 및 변경.
- admin부분 먼저 구현해보자.
- admin의 메뉴도 db로 관리. tiles nav, left 수정 필요.
- 1. 게시판 관리.(문의사항, 자유게시판)
-  페이징, 검색, CRUD 등.
- 2. 메뉴 관리(product 관리하기 위한 구분, 메뉴와 product, content부분은 연관된 부분이 있다.)
- AOP설치 및 모든 HomeController부분 /home이 포함되는 부분에 top_menu를 보낸다.(menu부분도 댓글처럼 트리형식으로 만드는 것이 낫지 않을까? 실제로 갯수도 많지 않을텐데..)
- index를 제외한 곳에 middle_menu를 보낸다.
- middle_menu중 하나를 클릭하여 left사이드에 출력해야 하는 bottom_menu내용을 보내준다.

- 웹소켓이라는 기능이 있다. 서버와 클라이언트의 양방향 통신이 가능하다.(웹사이트에 실시간 채팅 기능의 구현을 가능하게 한다.) 둘의 동시구현도 괜찮은가?

- admin페이지 제작. 
- 메뉴관리, 게시판관리, 상품관리, 유저관리
- 공부할 내용(오라클의 CRUD 외의 함수.)
- 댓글 만들 때 트리형식으로 무한 대댓글이 가능하게 만들어보자.
- 오라클에 저장할때 트리형식으로 테이블작성.

- index는 예외로서 처리하여 둔다.
- 나머지는 admin과 home로 묶어서 처리.

#### Tiles와 AOP 구성
- 방법1: root 값을 string으로 저장하고 , 구분자를 설정해준 뒤, split으로 나눠 준 후, int로 변환하여 연산한 뒤 다시 저장할때는 string으로 변환하여 저장 방식?
- 방법2: 절대 될 수 없는 수를 정해서 그 이상이면 서브 메뉴 방식. 단순히 빼거나 나머지 값을 구하는 것으로 연산이 가능해진다.
- 방법3: parent를 pk로 지정하면 전부 해결된다. ---! 이 방법 사용
- 트리구조 데이터베이스에 구현하는 법: self join
- 밑으로 가지가 없는 애들 terminal
- page-define layout부분: index페이지(1), admin, home 페이지(2)
- 내부 속성을 호출 이름에 따라 변경이 가능하기 때문에 실제로는 레이아웃만 같고 다른 페이지로 만들 수 있다.
- Controller에서 Request를 받아서 tiles로 호출하는 형식.
- AOP를 이용하여 페이지에 변수를 전달하는데, home부분에는 TopMenu데이터를 항상 출력.
- 변수 하나를 이용하여 처리 하는 것: 설명부분이 많을때
- 호출 자체를 다른 형식으로 하는 것: 설명부분이 적을때
- 구분이 맞는가?
- AOP는 home을 Request할 때, Top_Menu를 항상 전달해준다. 
- 메뉴관리에는 모든 Menu데이터를 출력.
- 게시판관리에는 모든 게시판 데이터.
- 로그인 부분도 만들거면 그 부분도 Tiles로 관리할 필요가 있다.session으로 로그인 여부 등을 받게 된다면 그 값에 따라서 다른 부분을 가져오는 것이 가능한가?
- jsp->Controller->tiles->jsp->Controller
- Controller에서는 @RequestMapping 함수를 하나 만들어서 로그인 여부, 권한 여부를 판단할 필요가 있다.
- 큰 틀은 jsp Tiles Controller인데 Tiles는 layout과 파츠(header,footer)로 나눠지고 define에서 구성을 조합하는 역할을 한다.
- 레이아웃과 파츠는 이름 등에 따라서 유동적으로 바꿀 수 있는데 어떻게 구성해야 효율적인지는 생각할 필요가 있다.
- 현재 레이아웃은 noLeft와 onLeft로 나눠져 있다.
- 파츠는 admin, home으로 나눠져 있으며, 로그인 부분의 추가가 필요하다.
- 공용부분, admin 부분, home 부분으로 나누는 것이 관리하기 편할까?
- 브라우저에서 회원일 경우, 관리자일 경우, 비회원일 경우, 상관 없는 경우로 나눠진다.
- 레이아웃은 틀이 같은 것끼리 묶을 수 있다.
- *, {1}을 통하여 레이아웃에 다른 파츠를 붙이는 것이 가능하다.
- 파츠는 호출이름에따라 구분가능한데, 파츠를 나누기 위한 구분을 무엇으로 하는 것이 좋을지 의문.
- common, admin, home?
- 페이지 종류: index.jsp, admin.jsp, adminmenuCRUD.jsp, adminproductCRUD.jsp, adminmemberCRUD.jsp
- userproduct.jsp(메뉴 구분),결제페이지.jsp, mypage.jsp
- AdminController, HomeController, CommonController
- 컨트롤러에서 check후 return값 결정. 
- 이 경우에는 index는 common으로, (각 페이지의 세부 구성이 우선시 되어야 하겠다. 안 그러면 중반부쯤에 전부 꼬일 듯.)

#### 20210630 (수) 작업
- homeMenuDAO,Service 복구 :homeMenu는 인기상품, 추천상품, 할인상품의 품목이 들어갈 예정이며, 설정은 관리자단이 아니라, 이후 유지보수를 위함.(완료)

- *폐기
- RestController를 이용하면 변수값으로 받을 수 있는데, 그렇다면 하나의 메서드에서 조건문으로 처리가 가능해진다. 이러한 방법이 좋은걸까? 굳이 할 필요가 없을지도... 코드가 더러워질지도 모르겠다
- 전송 방식으로 CRUD처리를 하는데 굳이 이럴 필요가 없을 것 같다.



#### 20210629 (화) 작업
- 게시판 nav의 left 구현 완료.
- left 클릭 시, content부분 수정을 ajax로 못함, tiles가 문제.
- homeMenu부분 삭제: home의 nav 부분에는 게시판타입(메뉴타입이 될듯)을 출력할 것이기 때문에.
- 상품정보도 결국은 게시판과 크게 다르지 않기 때문에, board_type대신 home_menu가 되는 것이 낫지 않을까?
- tbl_board_type는 tbl_home_menu가 더 나을 것 같다.(tbl_board_type에 tbl_board와 tbl_product_type)를 함께 붙이자.
- 게시판 구현. list는 a태그를 이용하여 간편하게 구현.
- CUD는 AJAX를 통하여 구현하기.


```
<script src="/resources/js/jquery-3.6.0.min.js"></script>
<script>
	$(document).ready(function(){
		$("#btn_left_menu").click(function(){
			$.ajax({
				
			});
		});
	});
</script>
```

#### 20210629 (월) 작업
- admin index 페이지 구현.
- admin menu db관리로 구현.
- AOP로 admin에 nav 메뉴 전송 부분 추가.
- DB 변수 이름 정리.
- 게시판 DB 생성.

#### 20210627(일) 작업
- AOP 구현에서 문제 발생.
- @Component를 사용하면 값의 전달이 제대로 일어나지 않는다. 이 문제의 해결이 필요하다.
- RestAPI전송을 어떻게 할지 생각해봐야겠다.

- @ControllerAdvice는 @ExceptionHandler와 함께 예외 처리 설정하는 클래스에 쓰인다? 메소드이름이 에러명이어야 하는 듯 하다.(확인 필요)
- AOP는 pom.xml에 의존성추가, root-config에서 aop패키지 추가, servlet에 프록시 설정을 추가하는 것으로 설치및 설정가능.
- @EnableAspectJAutoProxy(proxyTargetClass = true)
- 프록시 개념에 대한 이해 필요.
- myBatis의 mapper도 자바로 설정이 가능하다. 이 부분의 설정을 추가하는 것이 @Mapper, @MapperScan인 것 같다. 경로또한 java class 경로 형식으로 바꿔줘야 한다.(실험 완료.)
- mapper 기능은 @로도 가능하고, xml을 불러오는 형태도 가능하다. 하지만 java설정형식이면 @형태가 직관성 있을 것 같다.
- 참고 https://arcsit.tistory.com/entry/Spring-40-Mybatis-java-config%EB%A1%9C-%EC%84%A4%EC%A0%95%ED%95%98%EA%B8%B0

#### 20210626(토) 작업
- RestAPI(=Restfull API): 기존의 쿼리스트링 ?key=value방식에서 보안성이 떨어지는 점을 보안하기 위해 value1/value2/value3 의 형태로 전송하는 것.
- Ajax는 부분 변환. 로그인에서 로그인 부분만 변환하는 방식을 말함.
- success: 와 error: 로 나눠져서 처리. datatype이 text, html, json이 있기 때문에 json을 이용해서 자료를 보낼 수 있다?

#### 20210625 (금) 작업
- tiles 설정 완료.
- 에러 확인 완료.
- tiles-define.xml 사용 가능.(미완)
- jsp 나누기, controller와의 연관 관계 확인 완료.

- tiles
- layout	:파츠를 모으는 부분. insert를 사용하여 배치 각 큰 태그도 tiles에 포함 시키면 편함.
- header	:각종 import 부분. js, css, script부분이 위치.
- nav		:상단 메뉴 부분
- sidebar	:좌측 메뉴 부분
- content	:본문 내용
- footer	:하단 부분.

-tiles-define.xml
<!-- extends를 사용하여 위의 설정을 상속받을 수 있다.-->
    <definition name="home.index.tiles" extends="noMenu.tiles"><!-- 여기의 name는 Controller에서 return하는 값을 나타낸다. -->
    	<put-attribute name="content" value="" /><!-- 여기서의 {숫자}는 위에서 *을 나타낸다. -->
    </definition>
    <!-- 폴더의 이름과 설정을 하기에 따라서 간결한 코딩이 가능해진다. 예를 들어 폴더와 jsp의 이름을 tiles의 구조에 맞춰서 나눈다면 몇몇 상속을 제외하고는 *을 통하여 설정 및 세팅이 가능하다. --> 




#### 20210624 (목) 작업
- 추가할 기능: AOP
- tiles 설치
- tiles 오류 확인 필요.
- tiles-define.xml의 연구 필요.
- tiles를 사용하여 controller와 jsp파일의 수정 필요.

#### 20210624 (수) 작업
- 추가할 기능: Tiles, AOP
- DB에서 Controller까지 데이터 이동 확인.
- jsp에서 jstl의 forEach를 사용하여 메뉴 출력 확인.

#### 20210622 (화) 작업
- 추가할 기능: Tiles, AOP
- 페이지 구성도 제작
- 구성도 제작
- 홈쇼핑 홈페이지 제작을 위한 테이블 레이아웃 제작

#### 20210621 (월) 작업
- 모듈의 설정을 추가할 때는, id는 매서드의 이름, class는 리턴 값으로, 설정은 set매서드를 이용하여 설정할 수 있다.
- java환경 config에서는 클래스에 @ComponentScan(basePackages={"com.home.controller"},includeFilters=@ComponentScan.Filter(value= {Controller.class}),useDefaultFilters=false)를 추가하는 방식으로 컴포넌트를 추가할 수 있다.
- sqlSession 유닛 테스트 확인
- mybatis 설치
- JUnit 설치

#### 20210620 (일) 작업
- 새로운 config는 Servlet이나 root Config에서 @Import를 통하여 추가한다.
- log4jdbc.log4j2.properties는 꼭 필요하다.
- 오라클은 dataSource 설정시 DriverManagerDataSource를 리턴.
- mysql은 dataSource 설정시 BasicDataSource를 리턴
- mybatis 연동: pom.xml에 추가 -> log4jdbc.log4j2.properties 추가 -> DataSource, SqlSession Config.java 추가
- JUnit: pom.xml 추가. 예제파일에 @RunWith, @ContextConfiguration, @WebAppConfiguratio 추가.

#### 20210609 (수) 작업

SPRING

JAVA Config

```
web.xml->WebInitializer.java
public class WebInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	// Root WebApplicationContext
	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class[] { RootConfig.class };
	}

	// Servlet WebApplicationContext
	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class[] { ServletConfig.class };
	}
	
    // DispatcherServlet Mapping
	@Override
	protected String[] getServletMappings() {
		return new String[] { "/" };
	}

	// filter
	@Override
    protected Filter[] getServletFilters() {
        CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
        characterEncodingFilter.setEncoding("UTF-8");
        characterEncodingFilter.setForceEncoding(true);

        return new Filter[] { characterEncodingFilter };
    }
}
```
```
servlet-context -> ServletConfig
 package com.home.javaconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration
@EnableWebMvc
@ComponentScan("com.home.controller")
public class ServletConfiguration implements WebMvcConfigurer {

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
	}

	@Bean
	public InternalResourceViewResolver resolver() {
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setViewClass(JstlView.class);
		resolver.setPrefix("/WEB-INF/views/");
		resolver.setSuffix(".jsp");
		return resolver;
	}
}
```
```
root-context -> RootConfig
 package com.home.javaconfig;

import org.springframework.context.annotation.Configuration;

@Configuration
public class RootConfiguration {

}
```
