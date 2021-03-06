
#### 20210806 (금) 작업 예정
- Tiles와 Ajax의 연동 사용 문제
- Ajax사용시 뒤로가기 문제
- JSON 사용하여 동적 웹페이지 처리
- REST API 방식 구현 URL 작성 문제

#### 20210805 (목) 작업 예정
- Tiles와 Ajax의 혼용 사용 문제.
- 웹 사이트와 API의 차이점.
- html을 만들어서 넘기는 것이 아니라 전부 json 데이터로 만들어서 넘겨보자.(tiles 사용을 할 필요가 없어진다?)
- 이후 jsp에서 처리.
- git 컨벤션 내용 공부.(완료)

- 문제 원인 확인. * Tiles와 Ajax를 동시에 사용하다보니 발생한 문제.
- 동시에 사용하더라도 각각 예외를 두고 별개로 사용했어야하는데 동시에 사용하면서 구조적 문제가 발생했다.
- 현재 공부할 내용은 Tiles와 Ajax를 별개로 사용하는 법, Tiles에서 예외설정이 가능하다고 하는데 이를 사용하는 법.
- 이 문제를 해결할 경우 구조적인 문제는 대부분 해결될 것으로 예상된다.

- 수요일 계획 정리.
- ajax 사용 시 뒤로가기 처리: history.pushState, history.popState를 사용할 수 있다.
- history.pushState({'a':a,'b':b},title, url);
- $(window).on('popstate', function(event) {window.location = document.location.href;}); 이 부분도 필요한가? 없을것 같다. 확인 필요.

- 뷰 접속 url과 리소스에 접근하는 url을 따로 만든다.
- 뷰에서는 js에서 ajax를 이용하여 화면을 갱신한다. -뒤로가기는 history 사용.
- 리소스는 REST방식. 그럼 뷰는? 어떤 url을 사용해야하는가?
- REST API 방식을 사용하기 위한 공부.

- @RequestParam의 required와 defaultValue를 이용하여 쿼리값의 컨트롤이 가능.

#### 20210804 (수) 계획 예정
- 이후 jsp파일은 js를 사용하여 제작.
- 페이지 제작에서 처음 접속부분과 리스트르 불러오는 부분을 구분 가능해진다.(url이 달라진다.)
- 데이터를 불러오는 부분은 rest방식, tiles를 사용한 뷰를 불러오는 곳은 다른 url 사용.
- 여기에 history api 함수를 사용하여 뒤로가기 부분을 처리해주면 ajax를 이용한 홈페이지 구성 됨.
- 뷰를 불러오는 곳은 기본 값 처리, list를 불러오는 곳은 쿼리값으로 처리.
- (update매퍼를 제작 안했나? 했을텐데?)(확인)
- history 부분에 뒤로가기 처리부분에서 배열과 function을 사용하는데 이해가 가지 않는다.
- 현재 결과값까지 확인했는데 어떠한 방식으로 추가되고 구동되는지 이해 못함.
- @RequestParam에서 required=false설정 시 값이 없다면 null입력, defaultValue=을 이용하여 기본값설정도 가능.
- null관련하여 에러를 잡아주지 않는 문제가 있다고 함.(정확한 확인은 못함.)
- 페이지를 이러한 방식으로 처리해도 되지 않았을까?

- url구조에서 뷰board와 boards 데이터불러오는 부분 이름 뭐로 설정할까?
- 뒤로가기를 위한 history 설정은 몇가지 방법이 있는데 뭐가 가장 좋을까?
- 현재 history방식 유력함.
- 뒤로가기는 controller영역이 아닌 front-end영역인가?
- 어찌됐든 방법은 궁금.

#### 20210729 (목) 작업 예정.
- 쿼리스트링: search, filter, sort
- 현재 /{type} 을 쿼리스트링 type로 변환.
- REST API, 
- view의 목록, 수정부분 수정.
- view와 update 폼 제작.
- boardUpdate Mapper 제작.

#### 20210727 (화) 작업.
- history.pushState({"html":data},'',currentMenuUrl)//url히스토리에 경로 추가하는 함수.

#### 20210726 (월) 작업.
- REST API 구조 수정...

#### 20210723 (금) 작업예정
- RESTAPI에 대해 완전 잘못 생각하고 있었다.
- Controller 부분의 전면 수정, JSP 부분의 전면 수정이 필요할듯하다.
- 공부중..

- view와 update 폼 제작.
- boardUpdate Mapper 제작.


#### 계획표.
- admin 게시판 관리 CRUD 구현 -R 구현 
- 관리자 페이지 이후 로그인 구현.
- 파일업로드 구현시 VO에 파일이름을 list로 구현해보자.
- admin home메뉴CRUD구현.(부분 완료)
- member, product 관련 테이블 구현.
- admin 사용자 관리 CRUD 구현
- admin 상품관리 CRUD 구현
- 스프링 시큐리티를 사용하여 로그인 및 권한 설정시 url과 시큐리티와의 연동 구조 생각해야함.
- JS의 목록버튼의 history.go()는 수정이 필요하다. page 등의 데이터 전달이 불가능하기 때문에.

- 메뉴관리: tbl_board_type, 게시판관리: tbl_board, 유저관리: tbl_member(예정), 상품관리: tbl_product(예정)
- left에 CRUD를 넣어주고 content에 insert_form, update_form, list, delete


#### 다음 작업시 주의사항
- 	기획은 꼼꼼하게 하자.
- 기존의 작업은 공부를 시작으로 하나의 프로젝트를 작업하기까지 지속적으로 DB와 설정, 구조가 변화되어 수정에 많은 시간이 소모되었다.
- 	주석처리의 중요성
- 이후 다시 확인작업을 하면서 수정 및 보완을 할 경우 주석은 많은 시간을 줄일 수 있게 해준다. 주석을 습관화 하자.
- 	데이터이동에 대한 기획서 필요
- 최소한 페이지와 컨트롤러 사이의 데이터 이동에 대한 문서가 필요하다. 이는 데이터 전송 구조를 파악해서 서버의 구조를 설계하는데 도움을 준다.
- 물론 이후 수정으로 인한 시간낭비를 줄일 수 있다는데 더 큰 의의가 있다.
- 페이지를 미리 작성해봄으로서 공통 변수를 확인할 수 있고 가능하다면 이름을 동일하게 주어서 작업량을 줄일 수 있다.
- mapper부터 dao, service를 제작할때, 무엇을 기준으로 삼을지 명확하게 할 필요가 있다.
- 	RestAPI
- RestAPI도 결국은 url을 제작하는 규약(칙)에 불과하다. 너무 하나만 생각하여 쿼리스트링을 사용하지 않은 것이 문제. 분류(경로)는 RestAPI방식으로, 정렬, 검색, 필터 등은 쿼리스트링으로 사용하는 것이 좋다.(모든 것을 RestAPI로 사용할 수 없다. 진짜 불가능한가?*)
-작업을 함수화 하고, 사용처 등을 확실히 한다면 이후 수정을 덜 할 수 있을것 같다.

- DAO, Service 에서의 변수명 설정 시, DAO는 Mapper과 그대로 쓰되, 오버로딩보다 인자가 없는 함수는 selectALLList가 더 직관적일 듯 하다. 이는 Service도 마찮가지. (무엇을 중심으로 구성하고 기획해야 문제가 덜 생기고 직관적이 되는지 알아볼 필요가 있다)


#### 20210722(목) 작업
- ajax를 사용하여 리스트, 페이지, 서칭을 구현하였는데 url은 깔끔해졌지만 뒤로가기가 불가능한 현상이 발생했다.
- 검색등을 사용할 때 매우 불편한 일이기 때문에 두 가지 방법의 해결책이 있다.
- 1. ajax를 사용하지 않는다. 2. 페이지 정보와 서칭정보를 AOP로 전달한다. 3. 페이지 정보와 서칭정보를 쿼리스트링으로 교환한다.

- admin board write 부분, adminBaordController 부분 수정 체크
- Controller의 마지막에 ajax를 주는 것으로 구분.
- Rest API라고 하기에는 이상해진다.
- RequestMapping의 params 속성을 이용해서 구분하는 것이 좋지 않을까?
- ajax 요청인지 아닌지 구분이 가능해지는데.... Controller의 코딩이 중복으로 된다. 이 문제를 해결할 수 있을까?
- 공통부분의 함수를 제작? 매개변수가 들어가는 것이 많아서 차라리 복붙이 빠르다.(보기는 편할까?.. 애매)
- 일단 ajax요청과 그렇지 않은 요청을 구분하는 것은 찬성.
- Controller에서 같은 함수를 두 개나 만드는 것에 대해서는 고민이 필요하다.
- params를 사용해 보았다. 하지만 적용이 제대로 되지 않는다.
- 순서라고 하더라도 문제가 되기때문에... ajax값이 있고 없고로 판단보다는 ajax의 true, false로 처리.
- 이 방법을 통해 Controller를 수정하고, 뒤로가기를 사용할 수 있도록 편의성도 증가.
- ajax도 변수로 받아서 조건문으로 return값을 결정하면 한개로 끝난다...

- 규칙
- Controller
- ajax 호출인 경우 params = "ajax=true" 추가.(모든 컨트롤러에 이 부분을 추가 할까? 아니면 ajax의 경우에만 추가할까...)
- Ajax 호출이 있는 함수끼리, 나머지는 같은 URL 끼리.

#### 20210721 (수) 작업
- egov 이클립스에서 sts 이클립스로 변경.
- java 최신 버전과 연동 시도(실패)(1.8jdk 설치 후 동작)
- tomcat 10.0 사용 시도(충돌 문제를 해결하였으나 9.0이 더 안정성 있어서 9.0으로 변경)
- e전자정부 프레임워크와 spring 프레임워크는 틀이 다르다.
- Controller를 제작할때는 ajax를 이용하여 부분갱신과 전체갱신을 미리 구분해야 한다.(각각 별개로 제작도..)
- ajax로 호출할 부분갱신 메소드와 REST API를 이용한 전체갱신 메소드를 따로 구분하여 개발한다면 해결되지 않을까?

#### 20210720 (화) 작업
- admin/boards에서 write이후 게시글을 작성한 {type}으로 돌아가는 작업
- 쿼리스트링을 사용할 필요.
- ajax를 이용한 부분갱신에 의하여 실제로 url이 변화하지 않음.
- 뒤로가기 키가 먹히지 않는다.(불편)
- ajax 사용에 대한 고민.


#### 20210718 (일) 작업
- 현재 write이후 index.jsp로 돌아가는 행위를 /{type}으로 돌아가게 할 방법 연구.
- admin/boards					전체 갱신
- admin/boards/{type}			부분 갱신(ajax)
- admin/boards/{type}/write		Get은 폼 Post는 db연결
- admin/boards/{type}/{idx}		idx값에 따른 뷰폼(수정가능한 뷰) RUD 처리



- admin/boards/{type}/{idx}를 사용하여 update, delete 구현.
- 댓글 구현
- 파일 업로드 구현
- 스프링 시큐리티를 사용하여 로그인 구현.

#### 20210717 (토) 작업
- admin/boards/{type}/write 의 get,post로 write폼과 C 구현.
- post구현 도중 Request method 'POST' not supported 에러 발생. -jsp에서 action값 설정부분의 오류. (해결)
- 게시판 컨트롤러 중 게시판 종류가 입력된 부분에서 굳이 page값과 search값을 받지 않더라도 기본값으로 처리할 수 있도록 만드는 방법 고민.
- 이유는 게시판 추가 후 목록으로 돌아갈 때, 쓸데 없는 쿼리스트링을 사용하고 싶지 않기 때문.
- 방법1. 동일 작업 반복(write부분에 추가)
- 방법2. /admin/boards/{type}부분에 매개변수들이 필수 값이 아니게 처리가 가능할까?

#### 학원수업으로 인한 일정 연기. 20210713~20210716

#### 20210712 (월) 작업
- 페이징 오류 수정
- tiles의 구조 개선
- Controller의 tiles 호출 수정.
- searching 엔터 기능 추가.
- tiles는 *갯수에 따른 필터가 불가능.(on.*.*과 on.*.*.*이 구분이 안된다.)
- 해결: 폴더 구조를 변경하여 세부적인 것 한개로 처리.

#### 20210710 (토) 작업
- 서칭 keyword 값의 한글 인코딩 문제 해결. encodeURI 사용
- html부분에서 (jstl의 url을 사용하여)처리 후 ajax처리...? (부분갱신을 위해서)
- tiles 설정부분 수정.(.jsp 파일 분류. board는 board끼리, tiles-define 부분도 수정 필요. 파일명 정리)
- boards CUD 작업.
- RestAPI에 맞는 Controller구조 기획
- 현재: boards/{type}/{idx}/replies/attaches 방식

#### 20210708 (목) 작업.
- 서칭 keyword 값의 한글 인코딩 문제 해결.-jstl의 c:url

#### 20210706 (화) 작업
- 생성 부분에서 정지.
- 서칭 구현 시작.


- 페이징, 서칭 Controller 제작중 문제 발생.

- 계산식 문제 없음 확인.
- 각 jsp내부에 있는 값 확인.

- AdminBoardController의 두 함수를 합치는 작업.  type에 insertForm값이 들어오는 불상사 발생. (해결)
- insertForm을 호출하는 부분 작성. admin/boards/{type}/insert_form (get)
- 동작: type에 따라서 게시판추가의 type default 값이 달라지도록 만든다.
- 해결: admin/boards/list(insert, update 등)/{type}/.../..

- 페이징을 ajax로 처리하는 과정에서 2번의 클릭 이후 변환이 안되는 문제 발생.
- 문제 원인 예상: jsp를 컴파일하는 과정에서 버튼을 인식못할 가능성이 있다고 예상.(가정)
- 문제 원인 발견: jquery로 노드를 검색하여 추가하는 과정에서 section이 중복되면서 경로가 꼬인 것이 원인.
- 해결방법: div를 이용하여 상위 노드를 제작하고, parent()를 이용하여 갱신한다.(레이아웃이 깨지는 문제가 발생한다.)

- (restAPI에 대한 고민)(완료)
- restAPI로 구현하는 경우 중간 null값 입력이 안된다. boards/list/{type} 과 boards/list/{type}/{page}/... 등등을 함수 하나로 연동이 가능할까? 각 값들이 0 혹은 -1일경우 없는 수로 처리하기에도 애매하다...
- 어떻게 해결해야 하는가? 각 데이터에 대한 임시null값 지정하는 것은 에러발생의 소지가 많아 문제가 된다.
- 그렇다고 각각 상황에 따라 모든 매핑함수를 만드는 것은 비슷한 역할의 코드가 너무 많아져 생산성이 떨어진다.
- 내가 만든 구조가 잘못되었는가?(고민해볼 여지가 있다. RestAPI에 최적화된 구조가 있을 것이다.)
- 위에서는 list까지만 구현하고, 실제 값들은 json으로 전달하면 문제가 해결되지 않을까?
- 해결: RestAPI에 대한 오해로 인한 구조의 문제. RestAPI는 경로에 대한 것이며, 정렬, 검색, 필터링은 쿼리스트링을 사용하면 된다.
- 두 가지를 적절히 사용하여야 할 것을 하나로만 하려고 해서 생긴 문제.
- jsp에서 type, page, keyword, searchType를 넘겨주고 Controller에서는 결과값을넘겨주는 것... 이전페이지는 javascript(history)로 처리가 가능한가? 처리할 경우(ajax를 이용한 검색 값도 남는지 확인이 필요.)(완료)


#### 20210705 (월) 작업
- Mapper, DAO, Service 쿼리 및 함수 이름 통일 및 수정 작업.
- list로 끝나는 함수에 AOP를 이용하여 left_menu 값을 항상 전달한다.
- ajax를 이용한 admin boards 부분 갱신 해결.
- 홈의 레이아웃 구상이 필요하다. nav와 left의 용도. (홈 부분은 완전 새로 구상하자.)(완료)
- admin에서는 noLeft를 사용해도 된다.(CRUD는 한 페이지로 충분히 구현 가능하기 때문에)(완료)
- 사용자가 보는 홈에서는?(완료)
- nav와 left, content에 어떠한 내용을 넣을지 구상 필요.(완료)
- 확실한 구분을 위해서는 그냥 공용페이지 하나를 더 제작하는 것도 나쁘지 않다. (현 작업의 left는 같은 변수명을 사용하는 것으로 left.jsp 하나로 처리하고 있다.)(완료)
- 위 작업은 후에 문제가 생길여지가 다분하니 차라리 분화해서 각자 작업하는 것도 나쁘지 않을 것 같다. (tiles의 구조를 좀 더 세분화, 구체화 할 필요가 있다.)(완료)


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
- homeMenu를 다시 살려야 함.(의미 있는가? 이 부분은 신상품, 인기상품, 추천상품, 할인상품등의 품목이 들어갈 예정.)
- 장점: db에 추가하고 Controller에 추가, jsp생성으로 손쉽게 유지보수 가능.
- 인기상품, 추천상품을 표시해주는 테이블을 생성. 유지보수는 쉬워지는데 성능은? 일단 해보자.
- db는 안지워져서 존재, vo는 공용이므로 DAO부터 구현하면 재생 가능.
- ajax를 이용하여 content의 tiles만 변경이 가능한가? javascript로 제어 해볼만 하다.
- 만약 ajax로 tiles만 변경이 안된다면 content로 하나의 타일을 만들어서 내부에서 left, right로 처리, ajax 처리를 해야겠다.

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
