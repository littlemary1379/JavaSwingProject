# 2020.05.21 웹크롤링을 이용한 자바 프레임워크 개발(5회차) 1조 자바 스윙 프로젝트

- 로그인
- 회원가입
- 아이디, 비밀번호 찾기(메일로 발송)
- 카테고리별 책 제공
- 책 검색
- 책 상세정보 제공
- 서평 시스템(추가, 삭제)
- 회원정보수정 
- 장바구니 시스템
- 주변 서점 검색 맵 제공
- 관리자 책 등록
- 관리자 책 검색, 수정

```sql
  CREATE TABLE "NO24"."BOOKINFO" 
   (	"BOOKID" NUMBER, 
	"BOOKNAME" VARCHAR2(1000 BYTE), 
	"AUTHOR" VARCHAR2(1000 BYTE), 
	"PRICE" NUMBER(38,0), 
	"PUBLICATIONDATE" VARCHAR2(20 BYTE), 
	"ISBN" NUMBER(38,0), 
	"PUBLISHER" VARCHAR2(1000 BYTE), 
	"CATEGORY" VARCHAR2(1000 BYTE), 
	"SUMMARY" VARCHAR2(4000 BYTE)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
REM INSERTING into NO24.BOOKINFO
SET DEFINE OFF;
Insert into NO24.BOOKINFO (BOOKID,BOOKNAME,AUTHOR,PRICE,PUBLICATIONDATE,ISBN,PUBLISHER,CATEGORY,SUMMARY) values (1,'시절과 기분 (김봉곤 소설집)','김봉곤',14000,'2020-05-01',9788936438128,'창비','소설/시','“김봉곤의 소설은 왜 이렇게나 아름다울까”
2020년대 가장 주목해야 할 젊은 작가 김봉곤의 신작!
빛나는 문장으로 쓰인 섬세하고도 세련된 마음의 서사
한국문학이 기다려온 새로운 사랑의 기분

2016년 동아일보 신춘문예로 등단한 이래 2018년 출간한 첫 소설집 『여름, 스피드』로 많은 독자들의 사랑을 받은 작가 김봉곤이 2년 만에 두번째 소설집 『시절과 기분』을 선보인다. 2019년과 2020년 젊은작가상을 수상한 「데이 포 나이트」 「그런 생활」을 비롯하여, 단행본으로 묶이기 전에도 여러차례 평단의 호명을 받아온 「시절과 기분」까지 총 6편의 작품을 묶어냈다. 김봉곤 특유의 리드미컬하고도 섬세한 문장은 “사랑의 환희와 희열을 이어가는 내밀한 몸짓”(해설 강지희)을 아름답게 그려낸다. 이 소설집을 읽다보면 “나는 고개를 젓다 손뼉을 치다 주먹을 쥐다 음울하게 감동하기를 반복했다”라는 소설가 권여선의 심사평(2020년 젊은작가상)이 과히 과장이 아님을 확인할 수 있을 것이다.');
Insert into NO24.BOOKINFO (BOOKID,BOOKNAME,AUTHOR,PRICE,PUBLICATIONDATE,ISBN,PUBLISHER,CATEGORY,SUMMARY) values (3,'끝까지 남겨두는 그 마음 (나태주 필사시집)','나태주',13800,'2019-09-19',9791190224154,'북로그컴퍼니','소설/시','풀꽃 시인 나태주의 첫 필사시집!
대표 시 [풀꽃]부터 미공개 시 30여 편 포함 총 100편 수록!

대한민국이 지금 가장 사랑하는 시인 나태주. 초등학교 선생님으로 오랜 시간 아이들 곁에 머물며 천진난만한 감성을 지녔다. 남들과 다르지 않은 일상에서도 뛰어난 관찰력으로 시를 쓰는, 작고 여린 존재에게 따뜻한 손길을 건네는 그의 이야기를 이제 필사시집으로 만난다. 『끝까지 남겨두는 그 마음』은 2020년 등단 50주년을 맞이하는 그의 작품 중 필사하기 좋은 시를 뽑아 만든 나태주 첫 필사시집이다. 누구나 한 번쯤 가슴에 새겨본 [풀꽃]부터 신작 시 [오직 사무치는 마음 하나로]까지 미공개 시 30여 편을 포함해 총 100편의 시를 담았다.

사람, 자연, 세상… 특별하지 않은, 보통의 하루에서 영감을 받아 쓴 그의 시는 우리에게 웃음과 위안을 준다. 시를 손으로 한 자 한 자 써 내려가다 보면 ‘나만 이런 건 아니구나. 너도 그렇구나.’ 어제를 추억하고 오늘을 살아갈 힘을 얻는다. 누구나 느낄 수 있는 감정이기에, 누구나 품었던 마음이기에, 인생을 사는 동안 지니고 싶은 시선이기에, 나태주 시는 우리의 마음을 움직이고 필사하기에도 참 좋다.');
Insert into NO24.BOOKINFO (BOOKID,BOOKNAME,AUTHOR,PRICE,PUBLICATIONDATE,ISBN,PUBLISHER,CATEGORY,SUMMARY) values (9,'세종대왕 (고정욱 선생님이 들려 주는)','고정욱',9000,'2015-05-08',9788976504616,'산하','어린이','한글 창제 외에, 세종대왕의 인간적인 면, 음악, 농업, 대마도 개척 등 기존의 책에서 덜 다룬 내용을 보강하여 어린이들에게 세종대왕이 한글만이 아니라 우리나라의 문화와 농업, 군사와 영토 확장에도 많은 일을 했다는 것을 알려주고 있다.

그림에 있어서도 편경, 종묘제례악, 대마도 정벌 등으로 세종대왕을 새로운 관점에서 보고자 노력하였다. 차분한 세종대왕의 이미지를 표현함과 동시에 대마도 정벌, 종묘제례악 모습을 통해 힘차고, 화려한 조선과 세종의 모습도 표현하였다. 이런 점은 다른 책에서는 볼 수 없는 이 책이 가지는 장점이다. 더불어 책 뒤에는 세종대왕의 연보와 한글로 씌어진 최초의 책인 <용비어천가>에 대한 설명과 한글을 배우고 정보를 얻을 수 있는 누리집도 함께 수록하여 어린이들에게 세종대왕과 한글의 이해를 돕고 있다.');
Insert into NO24.BOOKINFO (BOOKID,BOOKNAME,AUTHOR,PRICE,PUBLICATIONDATE,ISBN,PUBLISHER,CATEGORY,SUMMARY) values (2,'꽃잎처럼 (1980. 5. 27 그 새벽의 이야기)','정도상',12600,'2020-05-08',9791130629582,'다산책방','소설/시','“내가 지금 도청에 있는 이유는 단 한 사람,
희순을 사랑하기 때문이다”
작가 정도상이 40년 만에 이야기하는 5·18 그날의 이야기

5·18 광주민주화운동으로부터 40년. 이웃의 생명과 민주주의를 지키기 위해 총을 든 시민군이 계엄군의 압도적 화력에 스러져간 1980년 5월 27일 새벽을 그린 장편소설이 나왔다. 1987년 전남대에서 주최한 오월문학상을 받으며 작가의 길에 나선 정도상의 신작이다. 작가 정도상이 40년 만에 이야기하는 5·18 그날의 이야기, 신작 장편소설 『꽃잎처럼』은 5·18 민주화운동 최후의 결사항전이 있던 5월 27일 새벽, 전남도청을 배경으로 한다. 소설의 챕터는 26일 저녁 7시부터 27일 새벽 5시 이후까지 한 시간 단위로 디테일하게 구성돼 사실감과 현장감을 더한다.

『꽃잎처럼』은 1980년 5월 18일부터 열흘간 이뤄진 광주민주화 운동의 마지막 날의 밤과 새벽, 전남도청에서 결사항전의 순간을 기다리던 오백여 명의 시민군들에 관한 이야기다. 당시 스물한 살 청년이었던 작가 정도상이 40년 만에 재구성한 현장 소설이자 기록 소설이다. ‘작가의 말’을 통해 작가가 고백한 바, 주인공 스물한 살 명수를 제외한 나머지 등장인물들은 모두 실재했거나 실재하고 있는 사람들이다. 작가는 『꽃잎처럼』을 통해 5·18의 현장으로 다시금 투신해 직접 주인공 명수의 귀와 눈과 입이 되어 당시의 뼈를 깎는 핍진한 순간들을 40년 후 지금을 살아가는 우리에게 생생히 전한다.');
Insert into NO24.BOOKINFO (BOOKID,BOOKNAME,AUTHOR,PRICE,PUBLICATIONDATE,ISBN,PUBLISHER,CATEGORY,SUMMARY) values (4,'사람은 왜 만질 수 없는 날씨를 살게 되나요 (최현우 시집)','최현우',10000,'2020-03-10',9788954670739,'문학동네','소설/시','최현우 첫 시집
정직한 슬픔과 깨끗한 애정을 담은 비망록
그리하여, “아름다운 마음들이 여기 있겠습니다”

문학동네 시인선 132번째 시집으로 최현우 시인의 『사람은 왜 만질 수 없는 날씨를 살게 되나요』를 펴낸다. 2014년 조선일보 신춘문예로 등단한 시인의 데뷔 6년 만의 첫 시집이다. 그의 첫 시집 『사람은 왜 만질 수 없는 날씨를 살게 되나요』는 2010년대를 20대로 살아온 시인의 진솔한 마음의 보고서이자 청춘을 가로지른 어제의 세계를 담은 비망록이기도 하다. 만질 수는 없지만 가까스로 붙잡을 수는 있었던 나날을 기록한 63편의 시편. 슬픔은 절제하되 그 무게를 견디고자 하는 책임은 무한하고자 하는 마음을 지켜보노라면, 우리는 이 시인을 ‘초과-신뢰’ 할 수밖에 없으리라. “발롱!”(「발레리나」) 하고 더 높은 곳을 꿈꾸던 시인은 어느덧 믿음직한 ‘조타수’가 되어 이제는 더 먼 곳으로, 적소(適所)로, 독자의 마음으로 나아가려 한다. 이 의연한 시인의 잊지 않으려는[備忘] 기록은 “망가지지 않은 것을 주고 싶”(「시인의 말」)은 희망의 기록이 될 것이다.');
Insert into NO24.BOOKINFO (BOOKID,BOOKNAME,AUTHOR,PRICE,PUBLICATIONDATE,ISBN,PUBLISHER,CATEGORY,SUMMARY) values (15,'생각의 탄생 (다빈치에서 파인먼까지 창조성을 빛낸 사람들의 13가지 생각도구)','미셸 루트번스타',27000,'2007-05-02',9788995688991,'에코의서재','인문','천재들이 활용한 창조적 사고의 13가지 도구들

『생각의 탄생』은 분야를 넘나들며 창조성을 빛낸 사람들의 13가지 생각도구를 전해주는 책이다. 레오나르도 다빈치, 아인슈타인, 파블로 피카소, 마르셀 뒤샹, 리처드 파인먼, 버지니아 울프, 나보코프, 제인 구달, 스트라빈스키, 마사 그레이엄 등 역사 속에서 가장 창조적이었던 사람들이 사용한 13가지 발상법을 생각의 단계별로 정리하였다.

이 책은 역사상 가장 위대했던 천재들이 자신의 창작 경험을 통해 ''생각''에 대해 어떻게 생각했으며, 생각하는 법을 어떻게 배웠는지를 구체적으로 설명하고 있다. 그들의 발상법을 관찰, 형상화, 추상, 패턴인식, 유추, 몸으로 생각하기, 감정이입 등 13단계로 나누어 논리정연하게 제시할 뿐만 아니라, 직관과 상상력을 갈고 닦아 창조성을 발휘하는 방법까지 구체적으로 제시하였다.

저자는 창조성이 소수 천재들만의 전유물이 아니라고 말한다. 이들이 활용한 창조적 사고의 13가지 도구들을 보여주며, 상상력을 학습하고 자기 안의 천재성을 일깨울 수 있도록 도와주는 책이다. [양장본]');
Insert into NO24.BOOKINFO (BOOKID,BOOKNAME,AUTHOR,PRICE,PUBLICATIONDATE,ISBN,PUBLISHER,CATEGORY,SUMMARY) values (26,'열국지 사상 열전 (열국지로 배우는 열두 가지 지혜)','신동준',15000,'2015-01-25',9788932472812,'을유문화사','역사','춘추전국시대를 살아온 열두 명의 인물들!

춘추전국시대는 현세대에게 까마득히 먼 시대의 역사일지도 모르나, 오늘날 삶의 바로 곁에서 이런저런 영향을 주고 있는 현대시의 역사이기도 하다. 『열국지 사상 열전』은 550년에 달하는 춘추전국시대를 다룬 풍몽룡의 역사소설《열국지》를 해독한 책이다. 춘추전국시대에도 역사의 흐름을 바꾼 것으로 평가받는 열두 명의 인물을 중심으로 그 시기의 역사와 문화, 사회상 등을 살펴보고 아울러 그들이 추종했던 여러 제자백가의 사상을 흥미롭고 재미있게 풀어냈다.

저자는 순자의 ‘4민론’은 서구의 사상 ‘국부론’에 제기된 분업론과 취지가 같았으며, 왕도를 철저히 부인하면서 정치 세계에는 오직 패도만이 존재한다고 역설한 한비자는 마키아벨리의 ‘군주론’을 연상시킴을 강조한다. 이는 열두 명의 인물을 살핌과 동시에 기존의 편견을 깨트리는 이야기들을 가득 담아냄 으로써 동양은 서양보다 훨씬 오래전부터 다양한 사상적 논의가 활발히 이뤄지고 있음을 보여준다.');
Insert into NO24.BOOKINFO (BOOKID,BOOKNAME,AUTHOR,PRICE,PUBLICATIONDATE,ISBN,PUBLISHER,CATEGORY,SUMMARY) values (30,'고도를 기다리며','사무엘 베케트',7000,'2012-02-20',9788937460432,'민음사','예술','전통적인 사실주의극에 반기를 든 전후 부조리극의 고전!

현대극의 흐름을 바꾸어놓은 작가 사뮈엘 베케트의 작품『고도를 기다리며』. 노벨 문학상 수상작인 이 작품은 전통적인 사실주의극에 반기를 든 전후 부조리극의 고전으로 칭송받고 있다. 시골 길가의 마른 나무 옆에서 ‘고도’를 기다리는 부랑자 두 사람과 난폭하고 거만한 폭군과 노예, 그리고 막이 끝날 때마다 나타나서 이 연극의 중심 테마인 ‘고도가 오지 않으리라는 것’을 알려주는 귀여운 소년의 이야기가 담겨있다.

아일랜드 출신인 베케트는 1939년 2차 세계대전이 발발하자 중립국 국민이라는 안전한 신분을 이용해 프랑스 친구들의 레지스탕스 운동을 도왔다. 그러던 중 그가 가담하고 있던 단체가 나치에 발각되어 당시 독일의 비점령 지역이었던 프랑스 남단 보클루즈에 숨어살게 되었는데, 거기서 할 수 있는 일은 전쟁이 끝나기를 기다리는 일뿐이었다. 전쟁이 언제 끝날지는 아무도 예측할 수 없는 상황이었기 때문에 그는 다른 피난민들과 함께 이야기를 나누며 시간을 보냈다. 얘깃거리 하나가 동이 나면 또 다른 화제를 찾아내야만 했는데 바로 이것이 ''고도''에 나오는 대화의 양식이다.

이렇게 베케트는 자신의 체험에서 얻은 사실적인 요소들에서부터 시작하여 구성을 극도로 단순화함으로써 작품을 창조해냈다.');
Insert into NO24.BOOKINFO (BOOKID,BOOKNAME,AUTHOR,PRICE,PUBLICATIONDATE,ISBN,PUBLISHER,CATEGORY,SUMMARY) values (31,'사진에 관하여','수잔 손택',16500,'2005-02-14',9788995619704,'이후','예술','전미도서비평가협회상 비평부문 수상에 빛나는 손택의 최고작
“인류는 여지껏 별다른 반성 없이 플라톤의 동굴에서 꾸물거리고 있다. 그것도 순수한 진리의 이미지를 골똘히 생각하면서”라는 문장으로 시작되는 <사진에 관하여>는 명실상부한 수전 손택의 최고작이다. 손택이 약 4년에 걸쳐 <뉴욕타임스 서평>에 기고한 여섯 편의 에세이 - <사진>(1973년 10월 18일자), <프릭쇼>(1973년 11월 15일자), <미국을 찍기/쏘기>(1974년 4월 18일자), <사진: 아름다움을 다루는 방법>(1974년 11월 28일자), <자신을 찾아 나선 사진>(1977년 1월 20일자), <무한한 사진>(1977년 6월 23일자) - 를 새롭게 가다듬어 발표한 <사진에 관하여>는 1977년 출판되자마자 각계각층의 찬사를 받으며 3개월 동안 6만 4천부가 팔리는 대성공을 거뒀을 뿐만 아니라, 이듬해인 1978년에는 <전미도서비평가협회상> 비평부문을 수상하기까지 했다.
그러나 <사진에 관하여>가 이런 외형적인 성공 때문에 손택의 최고작이 된 것은 아니다. 오히려 손택이 평생 동안 전개한 ‘거짓 이미지’와의 싸움이 이 책의 출간과 더불어 본격적으로 시작됐기 때문에 <사진에 관하여>가 손택의 최고작으로 손꼽히는 것이다(독일출판협회는 손택에게 “거짓 이미지와 뒤틀린 진실로 둘러싸인 세계에서 사상의 자유를 굳건히 수호해 왔다”는 헌사를 바친 바 있다).
게다가 이 책은 20세기의 주요 기록매체인 사진의 본성에 관하여 그동안 제기된 바 없는(혹은 조심스럽게만 제기되어 왔던) 질문들을 직접적으로 던져 ‘언젠가는 해야만 할’ 논쟁을 촉발시키기까지 했다. [바라보는 방법 Ways of Seeing]의 지은이로 유명한 영국 예술평론가 존 버거가 “이 책은 대단히 중요하고 독창적이다. 앞으로 사진이 이 풍요로운 대중매체 사회에서 맡은 역할을 논하고 분석하려면 손택의 이 책에서 시작할 수밖에 없을 것이다”라는 찬사를 보내게 된 것도 바로 이 때문이다.');
Insert into NO24.BOOKINFO (BOOKID,BOOKNAME,AUTHOR,PRICE,PUBLICATIONDATE,ISBN,PUBLISHER,CATEGORY,SUMMARY) values (7,'여, 행하라 (윤영미 에세이)','윤영미',15000,'2019-09-25',9791196803001,'키이츠','에세이','타고난 호기심으로 국내 방방곡곡을 누비며 발견한,

대중에게 알려지지 않은 명소 68곳을 소개한다.

35년 경력의 베테랑 아나운서인 윤영미의 국내 여행 에세이.

그녀는 본 에세이에서, 추억이 깃든 국내 숨은 명소들을 아름다운 사진과 함께 소개한다. 또한, 여행지를 좋아하게 된 스토리를 그녀만의 섬세한 감성으로 감각적인 비유와 묘사를 통해 친근하게 풀어낸다.

저자는 ‘여,행하라’는 메시지를 넘어 ‘그대여, 행동하라’는 의미를 담아 독자에게 말을 건넨다.

저자의 적극적인 리드에 이끌려 책장을 넘기다 보면 어느새 단순한 에세이가 아닌, 함께 여행을 하며 삶에 대한 사유를 나눈 것 같은 느낌이 든다.');
Insert into NO24.BOOKINFO (BOOKID,BOOKNAME,AUTHOR,PRICE,PUBLICATIONDATE,ISBN,PUBLISHER,CATEGORY,SUMMARY) values (5,'보통의 존재 (이석원 산문집)','이석원',12000,'2009-11-04',9788993928037,'달','에세이','2009년 출간, 10년간 베스트셀러
‘보통의 존재’ 10주년 기념 특별판 출간

2009년 출간 이후부터 현재까지 독자들에게 꾸준한 사랑을 받아온 이석원 작가의 산문집 『보통의 존재』가 출간 10주년을 맞아 특별판을 선보인다. 이번 『보통의 존재』 10주년 기념 특별판은 오랜 세월이 지나도 곁에 두고 펼쳐 보기 좋은 페이퍼백 디자인으로 만들어졌다. 또한 출간 10년의 소회를 담은 ‘작가의 말’을 덧붙였으며, 작가가 시대의 흐름을 담아 지난 10년간 수정해온 모든 내용이 망라된 완결판이기도 하다. 본문에는 작가가 일상에서 포착하고 직접 촬영한 사진들을 새롭게 수록하였다.

마치 현미경을 통해 들여다보듯 정밀하게 잡아낸 보통 사람의 내면과 일상의 풍경이 가득한 『보통의 존재』. 이번 특별판은 지난 10년간 이 책을 사랑해온 독자들에게 뜻깊은 선물이 되는 동시에 작가 자신의 내밀한 이야기를 담은 에세이의 진한 여운을 다시 한 번 느낄 수 있는 기회가 될 것이다.');
Insert into NO24.BOOKINFO (BOOKID,BOOKNAME,AUTHOR,PRICE,PUBLICATIONDATE,ISBN,PUBLISHER,CATEGORY,SUMMARY) values (10,'붉은 오월, 그곳에 푸른 동물원','최종욱',12000,'2020-05-15',9788993179811,'아롬주니어','어린이','나라가 지운 빚 말없이 떠안은 오월 광주

5·18 민주화 운동을 마주한 소년이 동물원을 배경 삼아

살아남은 자의 아픔과 희생된 영령을 위로하는 노래를 부르다

1980년 5월 광주는 군홧발과 총칼, 몽둥이에 신음하며 처절히 저항하다 스러졌다. 그날 광주는 주검이자 슬픔이었고, 뜨거움이자, 자유였다. 그러나 세상은 권력욕에 불타는 일부 군사 반란 무리가 광주를 희생양으로 삼았음을 알지 못했다. 오히려 거짓 선동에 속아 무지와 외면, 편견으로 광주를 조롱했다. 하지만 광주는 모든 것을 묵묵히 받아들이며 감내했다. 그렇게 광주는 자신의 순결을 소중하게 지켜나갔다. 차곡차곡 쌓이는 슬픔 속에서.

40년이라는 세월이 흘렀다. 그동안 광주가 겪은 그 날을 세상이 민주화 운동으로 인정했지만, 여전히 아프고 쓰리다. 그토록 광주를 고통의 나락으로 떨어트렸던 무리와 추종하는 세력은 여전히 건재하니까. “친 사람은 다리를 오그리고 자고 맞은 사람은 다리를 뻗고 잔다.”라는 우리 속담은 거짓이다. 오히려 권력의 정점에서 누릴 것 다 누리고 세상 편하게 잘산다. 여전히 광주만 희생된 이들에 대한 살아남은 자의 빚이 고통으로 짓누를 뿐이다.

광주 도심 한가운데에 있는 나지막한 언덕에는 중세 유럽의 성채 같은 동물원이 있다. 하지만 동물원이라고 해서 5·18 민주화 운동의 소용돌이를 피할 수는 없었다. 사람이 떠난 동물원에 부자만 남게 된다. 아무리 위급한 상황이어도 동물에게는 사람 손길이 필요하기에. 하지만 동물원에 군인과 시민군이 번갈아 드나들게 되면서, 부자는 그들이 가슴에 품고 있는 진실들과 마주한다. 명령을 따라야만 하는 군인의 방황과 자신을 희생해서라도 역사에 산 증인이 되고자 하는 학생, 그리고 어린 광훈의 시선을 통해, 우리는 5·18 민주화 운동 당시 현장에서 고통스럽게 살아 숨 쉬던 이들의 속살과 얼굴을 드러내지 않는 학살자의 모습을 볼 수 있다.');

CREATE TABLE ORDERS 
(
  ORDERID NUMBER NOT NULL 
, USERID VARCHAR2(20 BYTE) NOT NULL 
, BOOKID NUMBER NOT NULL 
, BOOKNAME VARCHAR2(1000 BYTE) NOT NULL 
, PUBLISHER VARCHAR2(1000 BYTE) 
, PRICE NUMBER NOT NULL 
, COUNT NUMBER NOT NULL 
, TOTALCOUNT NUMBER NOT NULL 
, CONSTRAINT ORDERS_PK PRIMARY KEY 
  (
    ORDERID 
  )
  USING INDEX 
  (
      CREATE UNIQUE INDEX ORDERS_PK ON ORDERS (ORDERID ASC) 
      LOGGING 
      TABLESPACE USERS 
      PCTFREE 10 
      INITRANS 2 
      STORAGE 
      ( 
        INITIAL 65536 
        NEXT 1048576 
        MINEXTENTS 1 
        MAXEXTENTS UNLIMITED 
        BUFFER_POOL DEFAULT 
      ) 
      NOPARALLEL 
  )
  ENABLE 
) 
LOGGING 
TABLESPACE USERS 
PCTFREE 10 
INITRANS 1 
STORAGE 
( 
  INITIAL 65536 
  NEXT 1048576 
  MINEXTENTS 1 
  MAXEXTENTS UNLIMITED 
  BUFFER_POOL DEFAULT 
) 
NOCOMPRESS 
NO INMEMORY 
NOPARALLEL;

ALTER TABLE ORDERS
ADD CONSTRAINT ORDERS_FK1 FOREIGN KEY
(
  BOOKID 
)
REFERENCES BOOKINFO
(
  BOOKID 
)
ENABLE;

ALTER TABLE ORDERS
ADD CONSTRAINT ORDERS_FK2 FOREIGN KEY
(
  USERID 
)
REFERENCES USERINFO
(
  USERID 
)
ENABLE;

CREATE TABLE REVIEW 
(
  USERID VARCHAR2(50 BYTE) NOT NULL 
, BOOKNAME VARCHAR2(1000 BYTE) NOT NULL 
, GRADE NUMBER NOT NULL 
, MENT VARCHAR2(4000 BYTE) NOT NULL 
, REVIEWNUM NUMBER NOT NULL 
, CONSTRAINT REVIEW_PK PRIMARY KEY 
  (
    REVIEWNUM 
  )
  USING INDEX 
  (
      CREATE UNIQUE INDEX REVIEW_PK ON REVIEW (REVIEWNUM ASC) 
      LOGGING 
      TABLESPACE USERS 
      PCTFREE 10 
      INITRANS 2 
      STORAGE 
      ( 
        INITIAL 65536 
        NEXT 1048576 
        MINEXTENTS 1 
        MAXEXTENTS UNLIMITED 
        BUFFER_POOL DEFAULT 
      ) 
      NOPARALLEL 
  )
  ENABLE 
) 
LOGGING 
TABLESPACE USERS 
PCTFREE 10 
INITRANS 1 
STORAGE 
( 
  INITIAL 65536 
  NEXT 1048576 
  MINEXTENTS 1 
  MAXEXTENTS UNLIMITED 
  BUFFER_POOL DEFAULT 
) 
NOCOMPRESS 
NO INMEMORY 
NOPARALLEL;

ALTER TABLE REVIEW
ADD CONSTRAINT REVIEW_FK1 FOREIGN KEY
(
  USERID 
)
REFERENCES USERINFO
(
  USERID 
)
ENABLE;
CREATE TABLE USERINFO 
(
  USERNUM NUMBER NOT NULL 
, USERID VARCHAR2(20 BYTE) NOT NULL 
, PWD VARCHAR2(20 BYTE) NOT NULL 
, AGE NUMBER NOT NULL 
, NAME VARCHAR2(20 BYTE) NOT NULL 
, EMAIL VARCHAR2(50 BYTE) NOT NULL 
, TEL VARCHAR2(20 BYTE) NOT NULL 
, CLASS VARCHAR2(20 BYTE) NOT NULL 
, CONSTRAINT USERINFO_PK PRIMARY KEY 
  (
    USERID 
  )
  USING INDEX 
  (
      CREATE UNIQUE INDEX USERINFO_PK ON USERINFO (USERID ASC) 
      LOGGING 
      TABLESPACE USERS 
      PCTFREE 10 
      INITRANS 2 
      STORAGE 
      ( 
        INITIAL 65536 
        NEXT 1048576 
        MINEXTENTS 1 
        MAXEXTENTS UNLIMITED 
        BUFFER_POOL DEFAULT 
      ) 
      NOPARALLEL 
  )
  ENABLE 
) 
LOGGING 
TABLESPACE USERS 
PCTFREE 10 
INITRANS 1 
STORAGE 
( 
  INITIAL 65536 
  NEXT 1048576 
  MINEXTENTS 1 
  MAXEXTENTS UNLIMITED 
  BUFFER_POOL DEFAULT 
) 
NOCOMPRESS 
NO INMEMORY 
NOPARALLEL;

Insert into NO24.USERINFO (USERNUM,USERID,PWD,AGE,NAME,EMAIL,TEL,CLASS) values (1,'admin','admin',30,'홍길동','admin@gmail.com','010-2222-3333','관리자');

'''
