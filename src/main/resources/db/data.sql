-- 테이블: user
-- 칼럼: 이메일, 비밀번호, 전화번호, 프로바이더, 생성날짜, 생년월일

INSERT INTO user_tb (email, password, phone, provider, created_at, birth, status)
VALUES ('ssar@nate.com', '1234', '010-1234-5678', 'Email', '2023-02-15', '1990-01-15', '블랙'),
       ('john@nate.com', '1234', '010-2345-6789', 'Email', '2023-04-25', '1985-03-22', '휴면'),
       ('jane@naver.com', '1234', '010-3456-7890', 'Naver', '2023-06-20', '1992-07-30', '활성'),
       ('sam@gmail.com', '1234', '010-4567-8901', 'Kakao', '2023-08-05', '1988-12-05', '활성'),
       ('lisa@naver.com', '1234', '010-5678-9012', 'Naver', '2023-10-12', '1995-05-25', '활성'),
       ('tom@nate.com', '1234', '010-6789-0123', 'Email', '2023-11-20', '1991-11-10', '활성'),
       ('emily@naver.com', '1234', '010-7890-1234', 'Kakao', '2023-12-15', '1987-04-05', '활성'),
       ('chris@nate.com', '1234', '010-8901-2345', 'Email', '2024-01-05', '1993-02-17', '활성'),
       ('julia@naver.com', '1234', '010-9012-3456', 'Naver', '2024-02-12', '1994-09-09', '활성'),
       ('mark@gmail.com', '1234', '010-0123-4567', 'Kakao', '2024-03-18', '1986-06-30', '활성');

-- 테이블: artist
-- 칼럼: 가수이름, 아티스트타입, 아티스트사진, 생성날짜

INSERT INTO artist_tb (name, artist_type, artist_img, created_at)
VALUES ('노을', 'Solo', 'upload/artist/노을.jpg', '2002-12-24'),
       ('aespa', 'Group', 'upload/artist/에스파.jpg', '2023-02-15'),
       ('NewJeans', 'Group', 'upload/artist/뉴진스.jpg', '2023-03-20'),
       ('IVE (아이브)', 'Group', 'upload/artist/아이브.jpg', '2023-05-05'),
       ('TWS (투어스)', 'Group', 'upload/artist/투어스.jpg', '2023-06-10'),
       ('QWER', 'Group', 'upload/artist/qwer.jpg', '2023-07-15'),
       ('임영웅', 'Solo', 'upload/artist/임영웅.jpg', '2023-08-20'),
       ('지코 (ZICO)', 'Solo', 'upload/artist/지코.jpg', '2023-09-25'),
       ('(여자)아이들', 'Group', 'upload/artist/여자아이들.jpg', '2023-10-30'),
       ('아일릿(ILLIT)', 'Group', 'upload/artist/아일릿.jpg', '2023-11-15'),
       ('이클립스 (ECLIPSE)', 'Solo', 'upload/artist/이클립스.jpg', '2023-12-01'),
       ('BTS', 'Group', 'upload/artist/bts.jpg', '2013-06-13'),
       ('Blackpink', 'Group', 'upload/artist/블랙핑크.jpg', '2016-08-08'),
       ('아이유', 'Solo', 'upload/aritst/아이유.jpg', '2008-09-18'),
       ('Twice', 'Group', 'upload/aritst/트와이스.jpg', '2015-10-20'),
       ('EXO', 'Group', 'upload/artist/엑소.jpg', '2012-04-08'),
       ('Red Velvet', 'Group', 'upload/artist/레드벨벳.jpg', '2014-08-01'),
       ('Zico', 'Solo', 'upload/artist/지코.jpg', '2011-04-15'),
       ('선미', 'Solo', 'upload/artist/선미.jpg', '2007-02-13'),
       ('Seventeen', 'Group', 'upload/artist/세븐틴.jpg', '2015-05-26'),
       ('NCT', 'Group', 'upload/artist/nct.jpg', '2016-04-09');


--  샘플용 더미

-- 테이블: album

INSERT INTO album_tb (title, distributor, agency, nationality, category, album_img, artist_id, created_at, intro)
VALUES ('전부 너였다', 'Dreamus', '제이와이피엔터테인먼트', '국내', '발라드', 'upload/album/전부너였다.jpg', 1, NOW(),
        '- 섬세한 사랑의 감정을 노래한 "전부 너였다" 붙잡고도, 인연, 아파도 아파도, 청혼 등 2장의 앨범을 통해서 색깔있는 가창력을 선보였던 그룹 ''노을''이 기나긴 작업 기간을 보내고 섬세한 사랑의 감정을 담은 세번째 앨범 "전부 너였다"로 돌아왔다. 데뷔앨범인 "붙잡고도"와 2집 앨범 "아파도 아파도"를 통해 뛰어난 가창력과 멤버 각각의 독특한 보이스 칼라로 최고의 R&B그룹으로 평가 받아왔던 노을이 또 한번의 음악적 변신을 시도한다. 기나긴 작업기간 동안 4명의 멤버가 가장 신경쓴 부분은 각각의 보이스 컬러의 조화와 모든 이들이 공감할 수 있는 편안한 모습으로 팬들에게 다가가는 것이었다. 이번 앨범에서는 그 동안 노을이 보여주었던 슬픔의 극대화가 아닌 슬픈 감정의 절제를 노래하는 노을을 만나볼 수 있을 것이다. 타이틀 곡인 ''전부 너였다''는 제목이 주는 이미지 그대로 누구나 공감할 수 있는 가사가 돋보이는 곡으로 노을의 ''청혼''과 god의 ''보통날''을 작곡했던 권태은의 서정적인 멜로디에 양재선의 감성적인 노랫말과 노을의 Voice가 잘 조화된 곡으로 이별의 슬픈 감정을 절제하면서 덤덤하게 노래하여 이번 앨범의 컨셉을 가장 잘 표현하였다. - "노을스럽다"를 보여주는 곡 "나무" 사랑의 감정을 한 곳에 뿌리박은 나무에 비유한 "나무"는 노을 Voice와 웅장한 오케스트레이션의 조화가 돋보이며 최고의 프로듀서 방시혁의 노랫말이 귀에 쏙쏙 들어오며 가장 ''노을스럽다''라는 말이 어울리는 곡이다. 또한 이외에도 일본의 여가수 아무로 나미에의 최근작인 히트 발라드 "All for you"를 노을 만의 감성으로 새롭게 재해석한 "All for you"와 드라마 궁의 OST "perhaps love"를 작곡한 박근철의 "A better tomorrow", MC몽의 ''180도'', M(이민우)의 "Last first kiss"등을 작곡한 장준호의 멜로디와 "10 Minetes"의 작사가 Maybee의 가사의 조화가 돋보이는 댄스넘버 "남자라서", 조성모, BMK 및 여러 가수들의 앨범을 프로듀서한 mAd sOuL cHiLd가 선사하는 트랜디한 사운드와 감성의 조화가 돋보이는 ''A nice day'', 천상의 목소리 이소은과 노을의 리더 이상곤이 듀엣으로 노래한 러브 발라드 "여행" 등을 통해 또 한번 새로운 노을만의 색깔을 선보일 예정이다. 이번 노을의 세번째 앨범 ''전부 너였다''는 노을의 음악세계에 새로운 변화를 제시하며 동시에 가장 ''노을스럽다''라는 말이 어울리는 듣는이로 하여금 편안한 감동을 선사할 수 있는 최고의 앨범이 될 것이다.'),
       ('Armageddon - The 1st Album', '카카오엔터테인먼트', 'SM ENTERTAINMENT', '국내', 'Dance', 'upload/album/슈퍼노바.jpg', 2,
        '2024-05-27',
        'aespa, 첫 정규 앨범 ‘Armageddon’ 발매! 힙한 무드 ‘Supernova’→힙합 댄스곡 ‘Armageddon’으로 강렬한 질주! 세계관 시즌 2 서사 담은 역대급 스케일 음악+비주얼! ‘글로벌 히트메이커’ aespa가 첫 정규 앨범 ‘Armageddon’을 발매했다. aespa의 첫 정규 앨범 ‘Armageddon’은 미니멀한 트랙사운드와 캐치한 탑라인이 매력적인 선공개곡 ‘Supernova’와 트렌디한 트랙과 거칠고 절제된 음색이 돋보이는 타이틀 곡 ‘Armageddon’을 포함하여 에너제틱한 힙합부터 밝고 경쾌한 댄스곡, 리드미컬한 모던 팝, 발라드까지 다채로운 장르로 구성되어 aespa만의 독보적인 음악 색깔을 만끽하기에 충분하다. 특히 이번 앨범은 리얼 월드와 디지털 세계를 넘어 다중 우주로 확장되는 aespa 세계관 시즌 2의 서사를 담아, aespa가 평행 세계에 존재하는 각기 다른 ‘나’를 만나 무한한 가능성을 마주하고 완전한 ‘나’로 거듭나는 과정들을 파워풀하고 유니크한 음악과 비주얼을 통해 보여줄 예정이어서 기대가 모인다.'),
       ('How Sweet', 'YG PLUS', 'ADOR', '국내', 'Dance', 'upload/album/sweet.jpg', 3, '2024-05-24',
        '뉴진스가 2024년 또다시 새로운 모습으로 돌아왔다. 타이틀 곡 ‘How Sweet’은 신선한 느낌을 선사하는 장르적 접근이 돋보이는 새롭고 독특한 매력의 Dance Pop 곡으로 Sparkle한 일렉트로닉 사운드가 중독성있는 곡이다. 또 함께 수록된 ‘Bubble Gum’은 트랙의 진행에 따른 다양한 무드 체인지를 통해 다채로운 매력을 느낄 수 있는 곡이다. 과장되지 않은 자연스러움으로 오히려 신선한 느낌을 선사하는 뉴진스 멤버들의 보컬과 개성있고 매력 넘치는 트랙들로 구성된 싱글 앨범 ‘How Sweet’은 한 번만 들어도 모든 이의 귀를 사로잡을 만큼 뉴진스의 매력을 잘 담아내고 있다. 그간 뉴진스를 기다려 온 전세계 팬들에게 화답이 되는 앨범이 되길 바란다.'),
       ('IVE SWITCH', '카카오엔터테인먼트', '스타쉽 엔터테인먼트', '국내', 'Dance', 'upload/album/해야.jpg', 4, '2024-04-29',
        '뚜렷한 컬러로 K팝 최고의 순간을 물들인 아이브가 극적인 반전을 선사한다. 아이브의 정체성은 주체적인 자신감과 당당함. 여기에 색다른 매력을 더해 또 다른 변주를 시도했다. 최적의 타이밍에서 맞이한 확신의 변화다. 언제나 자신감 넘치는 애티튜드로 자아 성취를 보여준 아이브가 세련되면서도 감각적인 시도로 새로운 시작을 알린다.'),
       ('TWS 1st Mini Album ‘Sparkling Blue’', 'YG PLUS', '플레디스엔터테인먼트', '국내', 'Dance', 'upload/album/첫만남.jpg', 5,
        '2024-01-22',
        '‘2024년 최고 기대주’ TWS, 데뷔 앨범 ‘Sparkling Blue’ 공개 "언제나 TWS와 함께"…반짝이는 음률의 향연 ‘Sparkling Blue’ 설렘 가득한 데뷔 타이틀곡 ‘첫 만남은 계획대로 되지 않아’'),
       ('1st Mini Album ''MANITO''', '카카오엔터테인먼트', '타마고 프로덕션', '국내', 'Rock/Metal', 'upload/album/고민중독.jpg', 6,
        '2023-08-15',
        '1st Mini Album ''MANITO'' ‘불협화음에서 만들어낸 하모니’라는 그들만의 독특한 스토리를 써 내려갔던 밴드 QWER이 미니 앨범 ''MANITO''로 돌아왔다. 첫 싱글에서는 각기 다른 출신의 배경을 가진 멤버 쵸단, 마젠타, 히나, 시연 넷의 결성까지의 과정과 팀의 아이덴티티를 이야기했다면, ''MANITO''에서는 운명과도 같은 만남을 경험한 QWER의 속마음을 한 편의 드라마로 풀어나갈 예정이다.'),
       ('신사와 아가씨 OST Part.2', 'NHN벅스', '모스트콘텐츠', '국내', 'Ballad', 'upload/album/도망가.jpg', 7, '2021-10-11',
        '''임영웅 - 사랑은 늘 도망가'' KBS 2TV 주말드라마 ''신사와 아가씨''는 우연인 듯 인연인 듯 계속된 만남을 가지게 된 박단단(이세희 분)과 이영국(지현우 분)이 한집살이를 시작하며 흥미진진한 서사와 디테일한 연출로 시청자들을 사로잡고 있다.'),
       ('SPOT!', '	YG PLUS', 'KOZ 엔터테인먼트', '국내', 'HipHop', 'upload/album/스팟.jpg', 8, '2024-04-26',
        '지코의 첫 번째 정규앨범 "SPOT!"는 독창적인 음악성과 심오한 가사를 담은 작품입니다. 타이틀 곡 "Thinking"은 지코 특유의 스타일과 제니의 감각적인 보컬이 어우러진 곡입니다.'),
       ('2', '카카오엔터테인먼트', '큐브 엔터테인먼트', '국내', 'K-POP', 'upload/album/질색.jpg', 9, '2024-01-29',
        '''Super Lady''의 아름다움과 그 힘에 대한 찬가 콘셉트 장인 (여자)아이들의 화려한 귀환'),
       ('SUPER REAL ME', '지니뮤직, Stone Music Entertainment', '빌리프랩', '국내', 'Dance', 'upload/album/마그넷.jpg', 10,
        '2024-03-25',
        '‘하이브 막내딸’ 아일릿, 3월 25일 첫 번째 미니 앨범 ‘SUPER REAL ME’로 데뷔! 엉뚱•발랄•자유로움 아일릿…무엇이든 될 수 있는 무한 가능성의 소녀들 ‘눈 앞에 최선을, 나머지는 되는 대로’, 진짜 ‘나’의 이야기로 전속력으로 달려가는 아일릿 ‘리얼 10대 감성’ 아일릿 시작부터 다르다! 방시혁 프로듀서x10대 프로듀서 만남'),
       ('선재 업고 튀어 OST Part 1', 'Stone Music Entertainment', 'BON FACTORY, Stone Music Entertainment', '국내', 'OST',
        'upload/album/소나기.jpg', 11, '2024-01-10',
        '드라마 속 밴드 ''이클립스''가 선보이는 첫 번째 OST! tvN 월화드라마 ‘선재 업고 튀어’가 드라마의 몰입도를 높일 OST들을 선공개한다');

-- album_tb에 더미 데이터 삽입
INSERT INTO album_tb (title, distributor, agency, nationality, category, album_img, artist_id, created_at, intro)
VALUES ('Map of the Soul: 7', 'YG PLUS', 'BIGHIT MUSIC', '국내', '정규', 'upload/album/MAP OF THE SOUL 7.jpg', 12,
        '2020-02-21', '방탄소년단, 정규 4집 ‘MAP OF THE SOUL : 7’ 발매!
‘온전한 나’의 모습을 찾기 위한 방탄소년단의 솔직한 이야기

방탄소년단이 2월 21일 네 번째 정규 앨범 ‘MAP OF THE SOUL : 7’을 발매한다.
지난해 막을 연 MAP OF THE SOUL 시리즈는 자신의 진짜 모습을 찾기 위해 여정을 시작한 방탄소년단의 솔직한 이야기를 담고 있다. 그 첫 작품인 MAP OF THE SOUL : PERSONA에서 세상에 대한 관심과 사랑의 즐거움을 노래하며 세상에 보여지는 자신의 모습을 발견했다면, ‘MAP OF THE SOUL : 7’에서는 그동안 숨겨왔던 내면의 그림자를 마주하고 이 또한 자신의 일부로 인정하고자 한다.
‘MAP OF THE SOUL : 7’은 7명 멤버이자 한 팀으로 모인 방탄소년단의 데뷔 후 7년을 돌아보게 한다. 지금의 자리에 오기까지 걸어온 길은 결코 순탄치 않았고, 글로벌 슈퍼스타로서 오롯이 견뎌내야 하는 부담감과 두려움이라는 특별한 시련도 있었다. 하지만 그 시련의 상처마저 자신의 진짜 모습 중 하나임을 알게 된 방탄소년단은 이제 ‘보여주고 싶은 나’와 ‘외면하고 싶은 나’를 모두 받아들이고 마침내 ‘온전한 나’를 찾은 자신들의 이야기를 전하려 한다.

‘MAP OF THE SOUL : 7’으로 선보일 방탄소년단의 아티스트적 면모
지난 1월, 선공개 곡 ‘Black Swan’ 음원과 함께 선보인 아트 필름(Art Film performed by MN Dance Company)은 슬로베니아 현대무용팀인 엠엔 댄스 컴퍼니(MN Dance Company)와의 협업으로 만들어진 작품이다. 곡의 정서를 현대무용으로 재해석해, 고난과 역경을 딛고 탄생한 흑조(Black Swan)를 연상시키는 독창적인 안무가 전 세계를 사로잡았다.
미국 CBS ‘더 레이트 레이트 쇼 위드 제임스 코든(The Late Late Show with James Corden)’에서 처음 공개한 ‘Black Swan’ 무대는 본 아트 필름을 연상케하는, 서정적이면서도 예술적 감성을 한층 끌어올린 퍼포먼스로 화제를 모았다.
뿐만 아니라, 방탄소년단은 영국 런던, 독일 베를린, 아르헨티나 부에노스아이레스, 미국 뉴욕, 대한민국 서울 등 전 세계 5개국 예술 작가들과 협업한 글로벌 현대미술 프로젝트 CONNECT, BTS를 통해 다양성의 긍정, 소통, 연결 등 자신들이 추구하는 철학을 현대미술로 확장시켰다. 현대미술, 현대무용 등 새로운 영역과 조우하며 순수예술과 대중예술을 이어온 방탄소년단은 이번 ‘MAP OF THE SOUL : 7’으로 한 단계 성장한 아티스트의 면모를 보여줄 예정이다.

타이틀곡 ‘ON’, 글로벌 아티스트로서 드러낸 소명의식
방탄소년단은 타이틀곡 ‘ON’을 통해 자신들이 생각해온 그 이상의, 아티스트로서 삶의 무게를 짊어진 채 정신없이 달려온 지난날을 돌이켜본다. 때로는 허공에 뜬 것 같이 무게중심을 잃고 휘청거리기도 했고, 한 발자국 떼면 한 발자국 커지는 그림자에 두려운 마음도 들었다. 하지만 이젠 어디서든 무게중심을 찾는 방법을 알고 있기에, 성공에 뒤따르는 내면의 고통을 정면으로 마주 보겠다고 말한다.
‘ON’은 이번 앨범을 관통하는 메시지를 담은 곡으로 주어진 길을 ‘제 발로 들어온 아름다운 감옥’으로 표현하며 운명을 받아들이고 계속해서 전진하겠다는 방탄소년단의 소명의식을 담았다.
같은 날 선보이는 ‘ON’의 키네틱 매니페스토 필름(Kinetic Manifesto Film : Come Prima performed by BTS for Lead Single)은 30여 명의 댄서와 마칭 밴드(marching band)가 함께 하는 대규모 퍼포먼스를 구현, 글로벌 아티스트로서 방탄소년단의 독보적 존재감을 다시 한번 보여준다.

유기적으로 연결된 19개 트랙의 완성도 높은 앨범
‘MAP OF THE SOUL : 7’에는 MAP OF THE SOUL : PERSONA 앨범의 수록곡 일부와 14개의 신곡을 포함해 총 19개의 트랙이 수록되어 있다.
방탄소년단은 ‘Interlude : Shadow’, ‘Louder than bombs’ 등에서 글로벌 슈퍼스타로 성장한 이들이 느끼는 의무감과 책임감을, ‘Black Swan’을 통해 예술가로서 겪는 두려움을 고백하며 숨기고 싶었던 자신의 내면을 드러낸다. 반면 ‘Filter’, ‘시차’, ‘Inner Child’, ‘Moon’을 비롯해 ‘We are Bulletproof : the Eternal’, ‘Outro : Ego’ 등의 트랙에서는 나의 본 모습과 지금의 나를 있게 한, ‘나를 나이게 하는 것들’에 대한 이야기를 풀어낸다. 그리고 이 두 가지를 모두 녹여낸 타이틀곡 ‘ON’은 자신의 페르소나와 그림자를 모두 받아들인 온전한 내가 되기까지의 여정을 그리고 있다.
이로써 Persona-Shadow-Ego의 서사를 담은 19개 트랙이 한 음반 안에 유기적으로 연결되어 있어 높은 앨범 완성도를 느낄 수 있다.
이 서사는 자신의 자아를 찾아가는 일곱 멤버의 7년간의 삶을 의미하는 앨범 커버에서도 찾아볼 수 있다. 네 가지 버전의 커버는 완벽하고자 하는 열망 혹은 채워지지 않는 갈증의 Shadow, 사명감과 의지 혹은 방탄소년단 본연의 모습을 보여주는 Ego를 표현하고자 했다.

한층 확장된 방탄소년단의 음악적 스펙트럼
이번 앨범은 리부트(Reboot) 콘셉트를 적용해 방탄소년단의 데뷔 초 ‘학교 3부작’ 앨범을 차용 및 재해석함으로써 이들의 음악적 스펙트럼을 한층 확장시켰다. 지난 MAP OF THE SOUL : PERSONA의 타이틀곡 ‘작은 것들을 위한 시 (Boy With Luv) (Feat. Halsey)’가 두 번째 미니 앨범 ‘Skool Luv Affair’의 타이틀곡 ‘상남자 (Boy In Luv)’와 맞닿아 있다면, 이번 타이틀곡 ‘ON’과 첫 번째 미니 앨범 ‘O!RUL8,2?’의 타이틀곡 ‘N.O’가 대응을 이룬다. 또, 이번 앨범의 수록곡 ‘We are Bulletproof : the Eternal’은 데뷔 앨범 ‘2 COOL 4 SKOOL’의 수록곡 ‘We are Bulletproof Pt.2’를 잇는 노래이다.
이외에도, 보컬 라인과 래퍼 라인의 유닛 곡은 물론 ‘친구’, ‘Respect’ 등 이전에 선보이지 않은 새로운 조합의 유닛 곡과 일곱 멤버의 개성을 살린 솔로곡까지 다채로운 구성을 만나볼 수 있어 듣는 재미를 배가시킨다.
음악으로 전 세계 사람들과 경계 없는 소통을 해오며 글로벌 아티스트의 반열에 선 방탄소년단은 이번 앨범을 통해 자기 자신을 들여다보고자 했다. 데뷔 후 7년, 이 자리에 오기까지의 삶은 험난했고 성공에 가리어진 그늘 또한 버겁게 느껴질 때가 있었다. 하지만 방탄소년단은 앞으로 나아가야 할 내일에 보다 주목하고자 한다. 지금의 자신들을 있게 한 근원이자 주변부에 있던 자신들을 전 세계적인 슈퍼스타로 만들어낸 팬클럽 아미(ARMY)와 함께 주어진 길을 계속해서 걸어가고자 한다.
');
INSERT INTO album_tb (title, distributor, agency, nationality, category, album_img, artist_id, created_at, intro)
VALUES ('The Album', 'YG PLUS', 'YG Entertainment', '국내', '정규', 'upload/album/The Album.jpg', 13,
        '2020-10-02', 'How You Like That, Ice Cream (with Selena Gomez)은 싱글로 발매된 [How You Like That]과 [Ice Cream (with Selena Gomez)]에서 감상하실 수 있습니다.

2016년 ’SQUARE ONE’으로 데뷔하여 글로벌 아티스트로 성장한 블랙핑크의 첫 정규 앨범 ‘The Album’이 10월 2일 발매된다.

블랙핑크의 첫 정규앨범 ‘THE ALBUM’의 타이틀곡인 ‘Lovesick Girls’는 컨트리풍의 기타 사운드 위에 세련된 멜로디로 곡의 전체적인 분위기를 이끌어가며 이어지는 레트로한 사운드 위에 블랙핑크의 파워풀한 보컬이 더해져 노래를 고조 시킨다. 인간은 왜 사랑에 상처받고 아파하면서도 또 다른 사랑을 찾아가는지에 대한 궁극적인 질문을 던지는 가사가 돋보이는 곡으로, 블랙핑크 노래 최초로 멤버 지수와 제니가 작사 작곡에 각각 참여하여 팬들의 기대감을 더욱 배가시킨다.

‘Lovesick Girls’ 외에도 전 세계적 파급력을 증명한 카리스마 넘치는 힙합 사운드의 ‘How You Like That’부터 팝스타 셀레나 고메즈와 콜라보 한 톡톡 튀는 경쾌한 멜로디의 ‘Ice Cream’까지- 블랙핑크만의 개성과 매력 넘치는 다양한 사운드를 담았다. 블랙핑크의 무궁한 음악적 스펙트럼을 ‘THE ALBUM’을 통해 확인할 수 있을 것이다.
');
INSERT INTO album_tb (title, distributor, agency, nationality, category, album_img, artist_id, created_at, intro)
VALUES ('Palette', '카카오엔터테인먼트', '카카오엔터테인먼트', '국내', '정규', 'upload/album/Palette.jpg', 14,
        '2017-04-21', '작은 순간순간을 예쁜 물감으로 만들어, 아이유의 ‘이 지금’을 빼곡히 채워내다.
‘아이유(IU)’ 정규4집 [Palette] 전격 발매!

아이유(IU)의 네 번째 정규앨범 [Palette]가 드디어 공개됐다.

아이유는 지난달 24일 발표한 첫 선공개곡 ‘밤편지’를 시작으로 동갑내기 뮤지션 오혁과 함께 한 두 번째 선공개곡 ‘사랑이 잘’까지, 연달아 ‘퍼펙트 올킬’ 기록을 세우며 그 이름값을 톡톡히 지켜 냈다.

아이유가 1년 반 만에 꺼내 놓은 신보이자 정규앨범으로는 3년 여만인 정규 4집 앨범 [Palette]는, 미리 발표된 두 선공개곡을 통해 짐작할 수 있듯이 특정 장르나 스타일에 제한하지 않고 다채로운 음악색과 이야기를 한데 담아낸, 앨범명 의미 그대로의 ‘팔레트’와 같은 앨범이다.

아이유의 정규4집 [Palette]는 아이유 본인이 직접 프로듀싱을 맡아 긴 호흡으로 공들여 작업한 만큼 가수 아이유의 또 다른 변신과 프로듀서 아이유의 음악적 성장을 새롭게 발견할 수 있게 한다. 또한, 그는 이번 앨범에서 이병우, 손성제, G-DRAGON, 선우정아, 오혁, 샘 김 등 세대와 장르를 아우르는 최고의 뮤지션들과 만나 음악적 스펙트럼을 넓히는 동시에, 특유의 섬세한 음색과 노랫말로 모든 넘버를 ‘아이유’ 만의 감성으로 색칠하며, 도무지 그 음악적 한계와 컬러를 단정지을 수 없게 한다.


“ 내가 머릿속으로 그렸던 꿈이 현실이 되어 눈 앞에 펼쳐지는 순간
저의 팔레트는 또 한 칸 새로운 물감으로 채워집니다…
지금 이 순간도 언젠가 내가 정성스럽게 그렸었던 꿈이죠
오늘 이 순간을 예쁜 물감으로 만들어 나는 또 꿈을 그릴 겁니다”
- 2016 아이유 콘서트 ‘하나 둘 셋 넷’-


데뷔 10년차 아티스트 혹은 스물다섯 살 ''이지은''의 작은 순간순간이 예쁜 물감이 되어 차곡히 채워진 ‘아이유’의 ‘이 지금’, 새하얀 ‘팔레트’에 그녀가 새롭게 배합해 낸 이 음악, 이 물감으로 어떤 그림을 완성할지는 오랜 시간 그녀의 새 앨범을 기다려온 청중의 몫으로 남겨두고자 한다.
');

INSERT INTO album_tb (title, distributor, agency, nationality, category, album_img, artist_id, created_at, intro)
VALUES ('Eyes Wide Open', 'Dreamus', 'JYP Entertainment', '국내', '정규', 'upload/album/eyeswideopen.jpg', 15,
        '2020-10-26', '트와이스, 10월 26일 두 번째 정규 앨범 ''Eyes wide open'' 및 타이틀곡 ''I CAN’T STOP ME'' 발표!

트와이스가 10월 26일 정규 2집 ''Eyes wide open''(아이즈 와이드 오픈)을 발매한다.

2017년 10월 30일 정규 1집 ''Twicetagram''(트와이스타그램) 발표 이후 약 3년 만에 선보이는 두 번째 정규 앨범으로 한층 더 과감해진 트와이스만의 매력을 녹여냈다.

''Eyes wide open''을 통해 그루브 넘치는 댄스 팝부터 시티 팝, 알앤비, 라틴 팝 등 다양한 장르의 음악에 도전했다.

전작 ''MORE & MORE''(모어 앤드 모어)에서 사랑에 빠질수록 더욱더 사랑을 갈망하게 되는 마음을 노래했다면, 이번에는 여기서 더 나아가 새롭게 눈 뜨게 된 감정을 음악에 담아냈다.

타이틀곡 ''I CAN’T STOP ME''(아이 캔트 스톱 미)는 선과 악의 기로에서 갈등하며 본인조차 스스로를 제어하기 어려워지는 마음을 담은 노래다. 유럽 일렉트로닉 사운드와 미국 80년대 신스 사운드를 합친 신스웨이브 장르로 중독성 있는 멜로디가 특징이다.

JYP엔터테인먼트 수장 박진영은 트와이스의 히트곡 ''SIGNAL''(시그널), ''What is Love?''(왓 이즈 러브?), ''Feel Special''(필 스페셜), ''MORE & MORE''(모어 앤드 모어)에 이어 또 한 번 타이틀곡 작사를 담당했다.

수많은 히트곡을 만들어낸 심은지 작사가도 합세, 가요계 흥행 보증 수표인 이들이 힘을 합쳐 ''14연속 히트''를 정조준한다.

또 방탄소년단, 할시(Halsey) 등 최고의 아티스트와 함께 작업한 글로벌 히트곡 메이커 멜라니 조이 폰타나(Melanie Joy Fontana)와 유명 프로듀서 미셸 린드그렌 슐츠(Michel ‘Lindgren’ Schulz)가 작곡했다.

트와이스는 신곡 ''I CAN''T STOP ME''에서 더욱 파워풀하고 화려해진 퍼포먼스를 선보인다. ''MORE & MORE''에서 협업한 키엘 투틴(Kiel Tutin)과 비욘세의 안무가 존테 모닝(Jonte Moaning) 등이 힘을 합쳐 안무를 완성했다.

뮤직비디오는 전작 ‘MORE & MORE’와 이어지는 스토리로 협곡, 기차역 등 환상적인 배경들로 풍성한 볼거리를 자랑한다. 꽃 속에서 등장하는 아홉 멤버들을 비롯해 감각적이고 화려한 그래픽 효과 역시 관전 포인트다.

새 앨범 ''Eyes wide open''에는 타이틀곡을 포함해 ''HELL IN HEAVEN''(헬 인 헤븐), ''UP NO MORE''(업 노 모어), ''DO WHAT WE LIKE''(두 왓 위 라이크), ''BRING IT BACK''(브링 잇 백), ''BELIEVER''(빌리버), ''QUEEN''(퀸), ''GO HARD''(고 하드), ''SHOT CLOCK''(샷 클락), ''HANDLE IT''(핸들 잇), ''DEPEND ON YOU''(디팬드 온 유), ''SAY SOMETHING''(세이 썸띵), ''BEHIND THE MASK''(비하인드 더 마스크)''까지 총 13곡이 수록됐다.

박진영, 심은지, 두아 리파(Dua Lipa), 켄지 등 초호화 작가진의 참여로 큰 화제를 모으고 있다. K팝 팬들 사이에서 ''띵곡 제조기''라 불리는 켄지, 영국 출신 프로듀싱팀 런던노이즈(LDN Noise), 세계적인 팬덤을 갖춘 영국 출신 유명 아티스트 두아 리파, 전작 ''MORE & MORE''를 함께 만든 엠엔이케이(MNEK), 트와이스 ''KNOCK KNOCK''(낙 낙), DAY6(데이식스) ''예뻤어''에 참여한 이우민(collapsedone), GOT7(갓세븐), ITZY(있지) 등 유수의 K팝 아티스트와 함께 작업한 이어어택(earattack), 독보적인 감성을 자랑하는 싱어송라이터 헤이즈 등 화려한 작가진이 트와이스의 정규 앨범을 위해 총출동했다.

미니 2집 ‘PAGE TWO’(페이지 투)부터 꾸준히 곡 작업을 해온 트와이스 멤버들 역시 신보 수록곡 크레디트에 이름을 올리며 더욱 성장한 작사 실력을 뽐낸다. 지효 ''UP NO MORE'', 나연 ''DEPEND ON YOU'', 사나 ''DO WHAT WE LIKE'', 다현 ''BRING IT BACK'', ''QUEEN'', 채영 ''HANDLE IT''까지 각각 수록곡 단독 작사를 맡았다.

트와이스는 매 컴백마다 각양각색의 시도를 하는 등 새로운 모습을 선사하기 위한 노력을 아끼지 않고 있다. 새 앨범 ''Eyes wide open''에서도 눈을 뗄 수 없는 매력 퍼레이드를 펼칠 예정이다.
');
INSERT INTO album_tb (title, distributor, agency, nationality, category, album_img, artist_id, created_at, intro)
VALUES ('Don`t Mess Up My Tempo', '카카오엔터테인먼트', 'SM Entertainment', '국내', '정규',
        'upload/ablum/dontmessupmytempo.png', 16, '2018-11-02', '‘K-POP 킹’ 엑소의 귀환!
정규 5집 ‘DON’T MESS UP MY TEMPO’ 공개!
타이틀 곡 ‘Tempo’ 포함 다채로운 장르의 총 11곡 수록!

‘K-POP 킹’ EXO가 정규 5집 ‘DON’T MESS UP MY TEMPO’로 컴백한다.

이번 앨범은 타이틀 곡 ‘Tempo’의 한국어 및 중국어 버전을 비롯해 불, 공간이동, 힘, 빛, 빙결, 바람, 번개, 치유, 물 등 멤버 각각의 초능력을 모티브로 가사에 녹여낸 수록곡 9곡까지 다채로운 장르의 총 11곡이 수록되어 있어, 엑소만의 음악 세계를 만끽하기에 충분하다.

또한 이번 앨범에는 영국 프로듀싱팀 런던노이즈 (LDN Noise), 세계적인 프로듀싱팀 더 언더독스 (The Underdogs), 미국 출신 프로덕션팀 마즈뮤직 (MARZ Music), 켄지 (Kenzie), DEEZ 등 등 히트메이커들이 참여해 완성도를 높였으며, 멤버 찬열이 작사, 작곡에 참여한 곡도 만날 수 있어 글로벌 팬들의 뜨거운 관심이 기대된다.

특히, 엑소는 정규 앨범 4장 연속 음반판매량 100만장을 돌파해 ‘쿼드러플 밀리언셀러’에 등극함은 물론, 가요 시상식 5년 연속 ‘대상’ 수상, 한국 최초 세계적인 명성의 두바이 분수쇼 음악 선정, 2018 평창 동계 올림픽 폐막식 무대 장식 등 글로벌 활약을 이어가며 변함없는 파워를 입증한 만큼, 이번 앨범을 통해 보여줄 새로운 모습이 더욱 기대를 모은다.

엑소의 매력적인 경고! 타이틀 곡 ‘Tempo’

타이틀 곡 ‘Tempo’는 에너제틱한 베이스 라인과 리드미컬한 드럼, 엑소의 신선한 아카펠라 구성이 돋보이는 힙합 댄스 장르의 곡으로, 사랑하는 그녀를 ‘멜로디’에 비유해 그녀와의 템포를 방해하지 말라는 남자의 마음을 표현한 가사가 매력적이며, 한국어 버전과 중국어 버전이 함께 수록되어 있다.

더불어 ‘Sign’은 사랑하는 그녀의 거짓말 때문에 점점 커지는 의심과 돌이킬 수 없는 마음을 번지는 불에 빗대어 표현한 가사가 인상적인 일렉트로 팝 장르의 곡이며, ‘닿은 순간 (Ooh La La La)’은 우연히 눈이 마주친 순간 시작된 상상 속 사랑이 공간이동처럼 현실이 되는 드라마틱한 이야기를 녹여낸 가사의 라틴 팝 곡이다.

또한 일렉트로 팝 장르의 ‘Gravity’는 찬열이 작사에 참여, 자신의 곁을 떠나려는 그녀를 붙잡고 싶은 마음을 중력에 빗대어 표현했으며, ‘가끔 (With You)’은 상대방으로 인해 자신이 더 빛난다는 달콤한 가사가 돋보이는 팝 R&B 장르의 곡으로, 찬열이 작사, 작곡에 참여해 눈길을 끈다.

게다가 사랑하는 사람에게 얼음처럼 차가운 말을 던지고 돌아온 밤에 느끼는 복잡한 감정을 표현한 미디엄 템포 곡 ‘24/7’, 헤어진 연인에 대한 생각이 폭풍처럼 밀려오는 밤에 홀로 느끼는 감정을 섬세하게 표현한 ‘후폭풍 (Bad Dream)’도 귀를 매료시킨다.

이 밖에도 사랑하는 사람의 거짓말 때문에 입은 상처를 번개처럼 한순간에 되돌려주겠다는 냉소적인 다짐을 담은 ‘Damage’, 이별의 상처를 스스로 치유하고 웃으며 사랑하는 사람을 떠나보낸다는 가사가 부드러운 멜로디와 어우러진 R&B 발라드 곡 ‘여기 있을게 (Smile On My Face)’, 삶에 대한 해답을 찾아 떠나는 여정을 오아시스에 빗대어 표현한 얼반 팝 곡 ‘오아시스 (Oasis)’ 등 총 11곡이 수록되어 다양한 매력을 느낄 수 있다.
');
INSERT INTO album_tb (title, distributor, agency, nationality, category, album_img, artist_id, created_at, intro)
VALUES ('The ReVe Festival: Finale', '카카오엔터테인먼트', 'SM Entertainment', '국내', '정규',
        'album/album/therevefestivalfinale.jpg', 17, '2019-12-23', 'Album Introduce
레드벨벳, 2019년 음악 축제 화려한 피날레!
리패키지 앨범 ‘‘The ReVe Festival’ Finale’ 발매!
쿨&스윗 러브송 ‘Psycho’로 독보적인 음악 세계 ‘레벨 업’ 한다!

레드벨벳이 새 앨범 ‘‘The ReVe Festival’ Finale’로 2019년 선보인 음악 축제의 대미를 장식한다.

레드벨벳이 올 한 해 ‘The ReVe Festival’이라는 타이틀 아래 펼친 음악 활동을 총망라하는 리패키지 앨범 ‘‘The ReVe Festival’ Finale’를 발매했다. 이번 앨범은 지난 6월과 8월 발표한 미니앨범 ‘Day 1’, ‘Day 2’ 수록곡 12곡에 타이틀 곡 ‘Psycho’와 신곡 ‘In & Out’, ‘Remember Forever’, 스페셜 트랙 ‘La Rouge’ 등 4곡을 추가한 총 16개 트랙으로 구성되어 있다.

특히, 레드벨벳은 중독성 강한 소원성취송 ‘짐살라빔 (Zimzalabim)’, 스파클링 서머송 ‘음파음파 (Umpah Umpah)’를 발표, 폭넓은 음악 스펙트럼과 다양한 변신으로 음원 및 음반 차트 1위, 음악 방송 1위 등을 섭렵한 만큼, 2019년을 화려하게 마무리할 레드벨벳의 새로운 음악에도 이목이 집중될 전망이다.

‘짐살라빔 (Zimzalabim)’ - ‘음파음파 (Umpah Umpah)’ 잇는 중독성!
타이틀 곡 ‘Psycho’로 트리플 히트 예고!

타이틀 곡 ‘Psycho’는 레드벨벳의 능수능란하면서도 익살스러운 보컬이 어우러진 업 템포 어반 팝 곡으로, 변화무쌍한 멜로디 위로 중독성 있게 펼쳐지는 훅이 돋보이며, 가사에는 남들이 보기에는 ‘Psycho’처럼 별나 보여도 결국 서로뿐임을 인정하는 연인의 쿨한 메시지를 담고 있다.

더불어 거부 못할 만큼 매혹적인 상대에게 빠져드는 짜릿한 심리를 재치 있게 표현한 미디엄 팝 댄스 장르의 ‘In & Out’, 꿈 같았던 지난 여름의 ‘The ReVe Festival’을 추억하는 팝 발라드 장르의 ‘Remember Forever’, 세 번째 단독 콘서트에서 선보인 스페셜 트랙 ‘La Rouge’까지 수록되어 있어 레드벨벳의 다양한 음악 색깔을 만나기에 충분하다.

또한 추가된 신곡 외에 기존에 발매된 미니앨범 ‘Day 1’, ‘Day 2’ 수록곡 트랙을 역순으로 배치, 마치 ‘The ReVe Festival’을 즐기던 지난 여름으로 돌아가는 듯한 느낌을 선사하며, 앨범의 제목과 같이 페스티벌의 피날레를 화려하게 장식하길 바라는 의미를 담아 특별함을 더했다.
');

INSERT INTO album_tb (title, distributor, agency, nationality, category, album_img, artist_id, created_at, intro)
VALUES ('THINKING Part.1', '카카오엔터테인먼트', 'KOZ Entertainment', '국내', '미니', 'upload/album/thinking.jpg', 18,
        '2019-09-30', 'THINKING of what,
THINKING of who,
What is ZICO THINKING?

언더그라운드 힙합 루키에서 아이돌로, 아이돌에서 아티스트로,
아티스트에서 프로듀서, 더 나아가 엔터테인먼트 대표로,
지코는 이제 어느 곳을 바라보고 어떤 것을 생각하고 있는 걸까.

지코의 첫 정규앨범 THINKING Part.1은 자신의 생각으로 바라본 청춘의 자화상을 녹여냈다. 과거 강렬한 작품들이 걸려있는 갤러리, 또 화려한 텔레비전 속 모습과 그 뒤에 감춰진 치열함을 담은 앨범들을 발표했었다면, 지코의 첫 정규 앨범은 그동안 느끼고 경험한 것, 자신을 마주 보는 솔직한 이야기들을 엮어낸 하나의 책과 같은 앨범이다.

그간 뛰어난 퍼포머, 히트 프로듀서로서의 모습으로 기억하는 사람들에게 이번 앨범을 통해서 뮤직비디오 각본에도 직접 참여하는 등 스토리텔러로서의 모습도 볼 수 있을 것이다.
THINKING Part.2 COMING VERY SOON.

');
INSERT INTO album_tb (title, distributor, agency, nationality, category, album_img, artist_id, created_at, intro)
VALUES ('Warning', '카카오엔터테인먼트', '㈜메이크어스엔터테인먼트', '국내', '미니', 'upload/album/warning.jpg', 19, '2018-09-04',
        '‘가시나’, ‘주인공’ 에 이어지는 3부작 프로젝트의 완성, ‘WARNING’(워닝)
네 환상에 아름다운 나는 없어, 사이렌 (Siren)

고혹적이며 때로는 파격적으로 음악과 무대를 해석해내며 가장 주목받는 독보적인 여성 솔로 아티스트로 확고한 위치에 오른 선미가 미니앨범 ‘WARNING(워닝)’을 발표한다.

선미의 미니앨범 ‘WARNING(워닝)’은 지난 해 8월 발표한 스페셜 에디션 ‘가시나(GASHINA)’와 ‘가시나’의 프리퀄(prequel)로서 올해 1월에 발표한 ‘주인공(HEROINE)’을 잇는 3부작 프로젝트의 마무리이자 그 완성인 앨범으로, 이로써 3부작 프로젝트는 ‘WARNING’, 즉 ‘경고’ 가 전체 테마였음을 알려주는 앨범이다.

또한 미니 앨범 ‘WARNING(워닝)’은 선미가 모든 트랙의 크레딧에 이름을 올리게 된 첫 앨범으로도 의미가 깊다. 16세의 나이로 그룹 ‘원더걸스’로 데뷔하여 10여년간 솔로 활동을 병행해 오면서 작사는 물론 작곡, 편곡 등 음악 작업에 참여하며 자신의 음악적 재능을 꾸준히 선보여온 선미는 이번 미니앨범 ‘WARNING(워닝)’의 전곡 작사 및 주요 수록곡의 작곡, 편곡 작업을 함께 하며 그녀가 가진 음악을 펼쳐냈다.

선미의 미니 앨범 ‘WARNING(워닝)’의 타이틀곡은 ‘사이렌(Siren)’으로, 선미가 작사하고, 작곡가 Frants(프란츠)와 함께 공동 작곡했다. 이 곡은 3년 전에 선미와 Frants(프란츠)가 의기투합하여 만들었던 곡으로 당시 준비 중이었던 원더걸스의 앨범의 타이틀곡 후보로도 거론되었던 비하인드 스토리가 알려지며 정식 발표 전부터 화제를 모았다. 2018년의 ‘사이렌(Siren)’은 선미의 미니 앨범 ‘WARNING(워닝)’의 타이틀곡으로 낙점된 후, 곡 컨셉을 발전시켜 새롭게 재탄생되었다.

싱글 ‘가시나’와 마찬가지로 ‘사이렌(Siren)’ 또한 제목에 중의적 의미를 내포하고 있는데, 신화에 등장하는 선원을 유혹하는 아름다운 인어를 상상하게 하는 동시에 직관적으로는 비상 시 위험을 알리는 경고음을 연상시킨다. 이러한 시각적 청각적 심상들은 타이틀곡 ‘사이렌(Siren)’ 곳곳에 유려하게 포진되어 있다. 그 동안 음악, 퍼포먼스, 스타일링 등에서 자신만의 예민하고 섬세하면서 몽환적인 독특한 감수성을 선보여 온 ‘선미’다운 감각적인 표현의 집합체라고 할 수 있다.

선미의 미니앨범 ‘WARNING(워닝)’에는 타이틀곡 ‘사이렌(Siren)’ 을 포함해 ‘ADDICT’, ‘Black Pearl’, ‘비밀테이프’ 등 선미와 Frants(프란츠)가 함께 작업한 곡들과 해외 프로듀서와 협업한 ‘곡선’, 그리고 싱글로 발표했던 ‘가시나’와 ‘주인공’까지 수록되면서 총 7개의 트랙이 수록되었다. 특히 이번 앨범의 음악은 각각의 곡 자체로도 완성도가 뛰어나며, 유니크한 보이스를 가진 선미의 감성이 다양하게 묻어나온다. 미니 앨범 전체가 그녀의 매력을 다양하게 표현해내면서도 하나로 어우러지게 해 저절로 선미의 보컬에 집중하게 만든다.

선미의 3부작 프로젝트를 모두 담아낸 미니앨범 ‘WARNING(워닝)’과 타이틀곡 ‘사이렌(Siren)’은 여성 솔로 아이콘에서 뮤지션으로 더욱 성숙해지고 있는 독보적인 여성 솔로 아티스트 선미의 또 다른 시작점이다.
');
INSERT INTO album_tb (title, distributor, agency, nationality, category, album_img, artist_id, created_at, intro)
VALUES ('An Ode', 'YG PLUS', '플레디스엔터테인먼트', '국내', '정규', 'upload/album/anode.jpg', 20,
        '2019-09-16', '세븐틴, 탄탄하고 성숙해진 완성형 음악 선사...정규 3집 [An Ode] 발매!
세븐틴, 정규 3집 [An Ode] 발매…‘세븐틴이 보내는 선율’!
세븐틴, 9월 16일 정규 3집 [An Ode] 발매! 타이틀 곡 치명적 매력의 ‘독:Fear’!
세븐틴, 1년 10개월만의 정규 앨범 발매 [An Ode]! 세븐틴 작사•작곡 참여!

그룹 세븐틴이 선공개 곡 디지털 싱글 ‘HIT’ 이후 9월 16일, 드디어 약 1년 10개월만에 정규 3집 앨범 [An Ode]를 발매한다.

세븐틴의 정규 3집 [An Ode]는 새로운 세계로의 확장을 꿈꾸며 도전을 예고했던 디지털 싱글 ‘HIT’과 연장선 상에 있는 앨범이다. 이에 ‘Ode(시)’를 통해 화자가 메시지를 은유적으로 표현하듯 세븐틴 또한 그들이 전하고 싶은 메시지를 다양한 방식으로 녹여내 ‘세븐틴이 보내는 선율’이라는 특별한 의미를 담아냈다.

또한 삶 속에서 누구나 한번쯤 느낄 수 있는 ‘두려움’이라는 감정을 세븐틴은 창작하는 과정을 통해 느끼는 감정 중 하나로 마주해 이에 대해 스스로 내면 깊숙이 통찰, 고뇌에 빠진 세븐틴을 한 단계 더 성장하게 했으며 [An Ode]를 통해 한층 더 성숙해진 완성형 음악을 선사한다.

이처럼 더 탄탄해진 정규 3집 [An Ode]의 타이틀곡 ‘독:Fear’은 묵직한 베이스 사운드 기반의 R&B 장르로 누구나 느낄 수 있는 두려움의 감정을 ‘독’으로 표현했으며 완벽한 완급 조절의 퍼포먼스가 더해져 세븐틴만의 치명적이고 절제된 섹시함이 돋보인다.

뿐만 아니라 구속과 통제로부터 해방을 외치며 저돌적으로 돌파구를 찾았던 ‘HIT’ 이후 세븐틴은 ‘독:Fear’을 통해 한없이 고독하고 깊은 함정에 빠진 모습을 보여준다. 특히 그동안 대중에게 선보이지 않았던 가장 어두운 면을 드러내 180도 달라진 분위기의 ‘세븐틴 표 짙은 어두움’을 처음으로 선사할 예정으로 더욱 대중의 이목을 집중시킨다.

이외에도 정규 3집 [An Ode]에는 선공개 된 ‘HIT’과 URBAN POP 스타일의 곡 ‘거짓말을 해’, 위로가 되어준 상대에게 고마운 감정을 표현한 세레나데 ‘Let me hear you say’, 청량함 가득 담긴 세븐틴의 청춘찬가 ‘Lucky’, 행복한 감정의 순간을 담아낸 ‘Snap Shoot’, 일본 싱글 앨범 타이틀 번안곡 ‘Happy Ending’ 등 단체곡과 더불어 퍼포먼스 유닛의 ‘247’, 보컬 유닛의 ‘Second Life’, 힙합 유닛의 ‘Back it up’부터 버논, 조슈아, 준, 디에잇으로 구성된 새로운 믹스 유닛의 ‘Network Love’까지 멤버들이 전곡 작사•작곡에 전반적으로 참여해 세븐틴만의 감성으로 표현해내며 11개의 트랙을 꽉 채워냈다.

이처럼 다양한 상황 속 느껴지는 감정과 보내고 싶은 메시지를 곡으로 형상화하여 써내려간 세븐틴의 선율은 하나의 [An Ode]로 완성, ‘두려움’을 마주한 이들의 성장통이 또 어떤 결과를 이뤄나갈지 세븐틴이 추구할 앞으로의 방향성에 귀추를 주목하게 만든다.
');
INSERT INTO album_tb (title, distributor, agency, nationality, category, album_img, artist_id, created_at, intro)
VALUES ('Moonlight', '카카오엔터테인먼트', 'SM Entertainment', '해외', '싱글', 'upload/album/Moonlight.jpg',
        21, '2024-06-05', 'NCT DREAM, 日 두 번째 싱글 ‘Moonlight’ 공개!
타이틀 곡 ‘Moonlight’ & 수록곡 ‘Stupid Cupid’ 2곡 수록!

NCT DREAM이 돔투어의 열기를 이어 일본 두 번째 싱글 ‘Moonlight’를 발표했다.

이번 앨범에는 경쾌한 멜로디와 기타 사운드, 드럼이 어우러진 팝 댄스 곡 타이틀 곡 ‘Moonlight’, 리드미컬한 트랙과 중독성 있는 후렴구가 특징인 힙합 장르의 ‘Stupid Cupid’등 일본 오리지널 신곡 총 2곡이 수록되어 있다.
');


-- 테이블: song

INSERT INTO song_tb (title, song_writer, lyricist, music_video, genre, is_title, music_file, created_at, album_id,
                     lyrics)
VALUES ('전부 너였다', '런치송 프로젝트', '양재선', 'upload/song/전부너였다.mp4', 'Ballad', true, 'upload/song/전부너였다.mp3', now(), 1, '가슴을 떼어 놓은
채 살 순 없나요
아무런 느낌도 없는 채로
눈물을 닦을 힘도
숨 쉴 힘도 이제는 나 없죠
그대는 숨죽여 속으로 울겠죠
나보다 더 힘들겠죠
다음이 또 있다면
그 땐 늦지않게
마음껏 더 사랑할텐데
내가 살아온 모든 행복을 더해도
우리의 짧은 날만 못하죠
어떻게 잊을까요
어떻게 견뎌낼까요
나는 기도해요 사랑이
우스운 나이까지
단숨에 흘러가길
수많은 사람 중 한명일 뿐인데
하나 잃었을 뿐인데
세상이 비틀대고 아무일도
아무 생각도 할 수가 없죠
내가 살아온 모든 행복을 더해도
우리의 짧은 날만 못하죠
어떻게 잊을까요 어떻게
견뎌낼까요
나는 기도해요 사랑이
우스운 나이까지
단숨에 흘러가길
바라만 봐도 좋았던 나였는데
욕심이 자라나
이렇게 벌을 받나요
보낸다는 건 내가 가졌던 거겠죠
한동안 내 것이던 그대죠
그렇게 잊을게요 그
렇게 견뎌낼게요
보내고 보내도 헤어지고
다시 헤어져도
나는 또 그대겠죠
'),

       ('Supernova', 'Kenzie, Paris Alexa, Dwayne “Dem Jointz” Abernathy Jr.', 'Kenzie', 'upload/슈퍼노바.mp4', 'Dance',
        true, 'upload/슈퍼노바.mp3', '2024-05-13', 2, 'I’m like some kind of Supernova
Watch out
Look at me go
재미 좀 볼
빛의 Core
So hot hot
문이 열려
서로의 존재를 느껴
마치 Discord
날 닮은 너 너 누구야
(Drop)

사건은 다가와 Ah Oh Ay
거세게 커져가 Ah Oh Ay
That tick that tick tick bomb
That tick that tick tick bomb
감히 건드리지 못할 걸
(누구도 말이야)
지금 내 안에선
Su su su Supernova

Nova
Can’t stop hyperstellar
원초 그걸 찾아
Bring the light of a dying star
불러낸 내 우주를 봐 봐
Supernova

Ah Body bang
Make it feel too right

휩쓸린 에너지 It’s so special
잔인한 Queen 이며 Scene 이자 종결
이토록 거대한 내 안의 Explosion
내 모든 세포 별로부터 만들어져
(Under my control Ah)

질문은 계속돼 Ah Oh Ay
우린 어디서 왔나 Oh Ay
느껴 내 안에선
Su su su Supernova

Nova
Can’t stop hyperstellar
원초 그걸 찾아
Bring the light of a dying star
불러낸 내 우주를 봐 봐
Supernova

보이지 않는 힘으로
네게 손 내밀어 볼까
가능한 모든 가능성
무한 속의 너를 만나
It’s about to bang bang
Don’t forget my name
Su su su Supernova

사건은 다가와 Ah Oh Ay
거세게 커져가 Ah Oh Ay
질문은 계속돼 Ah Oh Ay
우린 어디서 왔나 Oh Ay

사건은 다가와 Ah Oh Ay
거세게 커져가 Ah Oh Ay
Tell me, tell me, tell me Oh Ay
우린 어디서 왔나 Oh Ay
우린 어디서 왔나 Oh Ay

Nova
Can’t stop hyperstellar
원초 그걸 찾아
Bring the light of a dying star
불러낸 내 우주를 봐 봐
Supernova

사건은 다가와 Ah Oh Ay
(Nu star)
거세게 커져가 Ah Oh Ay
질문은 계속돼 Ah Oh Ay
(Nova)
우린 어디서 왔나 Oh Ay

사건은 다가와 Ah Oh Ay
거세게 커져가 Ah Oh Ay
질문은 계속돼 Ah Oh Ay
(Nova)
Bring the light of a dying star
Supernova'),

       ('Armageddon', 'EJAE, SUMIN (수민), Waker (153/Joombas), 노 아이덴티티 (No Identity)', '방혜현 (Jam Factory)',
        'upload/Armageddon.mp4', 'Dance', true, 'upload/Armageddon.mp3', '2024-05-27', 2, 'Armageddon
Shoot
Imma get ’em
Shoot

Watch Uh
Imma bite back Uh
짙은 어둠이
막아설 땐 Uh
한 걸음 앞으로
날아든 It’s bad
사라진 Feedback
시작된 Code black Uh

깊어가
혼란스러운 밤
악몽은 또 짙게 번져가
뭔갈 숨기려고 해
I got it, I got it
혼돈을 타고
덮쳐 Killing like

Bang chitty bang
Bang chitty bang bang
’Cause I wanna see
I wanna see truly
Bang chitty bang
Bang chitty bang bang
내게 다가와 다가와
Imma get it

Done
(Aw wayo wayo)
널 향해 겨눠 Get it, gone
(Aw wayo wayo)
이젠 널 끝내 Better run
(끝을 모르는 너와 나
You gonna, gonna)
깨트려 거침없이 Done
(Go way up, way up)
Full shot pull it up Armageddon

Imma get ’em
Shoot
Imma get ’em

Hey Ya
또 다른 나
우릴 막지 마
We never play nice
Shoot

완벽한 Pair
넌 똑같은 Soul
Three to get ready
우린 Shoot and go
겁 없이 누벼
날 이끄는 Way

Bang chitty bang
Bang chitty bang bang
Yes I’m gonna see
I’m gonna see, want it
Bang chitty bang
Bang chitty bang bang
답이 들려와 들려와
Imma get it

Done
(Aw wayo wayo)
널 향해 겨눠 Get it, gone
(Aw wayo wayo)
이젠 널 끝내 Better run
(끝을 모르는 너와 나
You gonna, gonna)
깨트려 거침없이 Done
(Go way up, way up)
Full shot pull it up Armageddon

Imma get ’em

또 어둠을 몰아내고
시작을 꽃피운 너와 나의 Story
더 완벽해진 우리
(Armageddon)
정의해 이젠
나만의 Complete
내 모든 걸 이끌어
Do it all myself
완전한 나를 이뤄내

(Drop)
Throw it back,
throw it back,
throw it back
Born like a queen
Born like a king Ya
Throw it back,
throw it back,
throw it back
불러
Imma get ’em

Done
(Aw wayo wayo)
널 향해 겨눠 Get it, gone
(Aw wayo wayo)
이젠 널 끝내 Better run
(끝을 모르는 너와 나
You gonna, gonna)
깨트려 거침없이 Done
(Go way up, way up)
Full shot pull it up Armageddon

Armageddon
(Aw wayo wayo wayo
Warning all night long)
Armageddon
(Aw wayo wayo)
끝과 시작의
Armageddon'),

       ('Set The Tone', 'Ludwig Lindell, Daniel Caesar, Ylva Dimberg', '조윤경', null, 'Dance', false, 'upload/tone.mp3',
        '2024-05-27', 2, 'We Set The Tone
Music on where we go
미친 Beat drum
같은 소리로
We Set The Tone
몰려와 Where we go
끌려오잖아 이미 넌
We Set The

Beat drop,
beat drop,
kill it
심장 소리 Feel it
Ah 벌써 두근대 네 맘이
Watch out,
watch out,
watch out
지루했던
맘을 노려
어지러운 Desk now
뒤로 해 넌
재미없는 세상
전부 깨워
Love that song
빠져 더
맘은 이미 Number one

Take your time
느껴봐 Now
느껴봐 Now, more
Hear the sound
눈 뜨면 또다시
매료시켜 널
Time and time
Fallin’ down, down
Fallin’ down, down
No
현실감을 놓아버려
We ’bout to

We Set The Tone
Music on where we go
미친 Beat drum
같은 소리로
We Set The Tone
몰려와 Where we go
끌려오잖아 이미 넌
We Set The Tone
따라와 Where we go
네가 찾던
Rhythm groove 위로
We Set The Tone
Get up, get up
더 소리쳐 봐 넌

Turn on your vibes
You got it?
I got it

Mean, mean, mean
On the beat
Speed, speed, speed
가뿐히
Heat, heat, heat
On the stage
들뜬 맘 위로
휙 올려 Pitch
멈춰 섰던
널 흔들어
Stress out 던져 버려
Put on blast now
자유로워
Hear this song
당겨 널
발견해 또 다른 널

Dream on fire
너를 향한
너를 향한 Voice
Repeat of sound
리듬은 여전히
감동시켜 널
Loud and loud
Breakin’ down down
Breakin’ down down No
압도하는 분위기로
We ’bout to

We Set The Tone
Music on where we go
미친 Beat drum
같은 소리로
We Set The Tone
몰려와 Where we go
끌려오잖아 이미 넌
We Set The Tone
따라와 Where we go
네가 찾던
Rhythm groove 위로
We Set The Tone
Get up, get up
더 소리쳐 봐 넌

거친 사막 같았던
네 맘에 난
물들여 눈부신 Sound
네 맘 더 깊이 들려와
사로잡지
We gon’ turn it,
turn it up

We Set The Tone
Number one where we go
거센 Beat drum
Rhythm 그 위로
We Set The Tone
보다 큰 세계로
달리고 있어
너와 난
We Set The Tone
달려봐 Where we go
네가 찾던
Rhythm groove 위로
We Set The Tone
Get up, get up
난 네게 퍼져 가

We Set The Tone
Reset the tone
We Set The Tone

We Set The Tone
We take it home
We Set The Tone'),

       ('Mine', 'Mike Daley, Mitchell Owens, Nicole “Kole” Cohen, Adrian McKinnon', '이은화 (153/Joombas)', null, 'Dance',
        false, 'upload/Mine.mp3', '2024-05-27', 2, '예고 없이
지는 그림자
Mine
두려움을
먹고 자라나
Mine
깨진 거울처럼
Fake 뿐인 초상화
점점 날
삼켜버릴 듯해
Mine

몰려온 Panic
(Show me your face)
숨죽여 난
(다가와 더)
밀려온 전율
(I’m on to you)
도망칠까
Who’s there?
(Don’t hate me)
무너지는 세계
그 안에 갇힌 채
다른 나를 마주해

나를 뒤흔드는
공포심
눈을 감아봐도
선명히
점점 커져만 가
내게 드리운
어두운 Line

이 악몽 같은 밤
미로 속에 갇혀
지옥 속에 서 있는 난
(깊은 미로 Uh Uh)
깊이 빠져드는 잠
다시 깨어나도
금세 펼쳐질 덫
나를 덮치고

예고 없이
지는 그림자
Mine
두려움을
먹고 자라나
Mine
깨진 거울처럼
Fake 뿐인 초상화
점점 날 삼켜버릴 듯해
Mine

뻔한 거짓과 비밀
Don’t be wasting my time
날 짓눌러 온
텅 빈 어둠은
허상일 뿐
진짜를 찾아봐
깨워내
Emotion on the real
어느새
흐려지는 View

더 이상
Won''t bow my head
(No I won’t)
제대로 마주할래 Yeah
(Stay outta my way)
두 눈을 떠
부딪힐 때
검은 그림자는
안개가 돼

저물어가는 달
부서지는 악몽
무너지는 장면 Yeah
깊은숨을 뱉어 봐
하얀 연기처럼
사라지는 공포
별거 아닌 걸

예고 없이
지는 그림자
Mine
두려움을
잊고 마주할
Mine
깨진 거울처럼
Fake 뿐인 초상화
벗어나
오직 나를 위해
Mine

It’s all Mine
know you want it like
It’s all Mine
know you want it like
Mine
It’s all Mine
know you want it like
나로 자라나

홀로 (둘로)
갇혀 (나눠)
긴긴
터널 속을 헤맨 듯해
Find (Can’t find)
My all (Your soul)
I need
내 안의 날
다시 마주해
Feel me
악몽을 벗어나
깨어날 기회야
Do what I want and I get
what I like
’Cause it’s Mine

소리 없이
지던 그림자
Mine
어둠마저
삼킬 나니까
Mine
깨진 거울처럼
Fake 뿐인 초상화
이제야
나를 찾은 듯해
Mine

It’s all Mine
know you want it like
It’s all Mine
know you want it like
Mine
It’s all Mine
know you want it like
It’s all Mine
Mine'),

       ('Licorice', 'Daniel Davidsen, Peter Wallevik, Moa “Cazzi Opeia” Carlebecker, Karen Poole', '강은정',
        'upload/Licorice.mp4', 'Dance', false, 'upload/Licorice.mp3', '2024-05-27', 2, '넌 정말
Licorice
Licorice
Licorice
계속 맴돌아
Like Licorice

Really not like that
Really,
really not like that
이건 뭐랄까
정말 낯선 느낌 Yah
널 보고 있어
또 Silly
생각이 나
No kidding
대체 What?
괜히 그냥 짜증 나

전혀 다른 Type
전에 없던 Stuff
예상도 못 한
사고처럼 Crush
(Like Like Like)
뒤를 돌아선
그 순간부터
홀린 것처럼
다시 돌아서

It tastes so
sweet but sour
Oh Sugar and spice
처음이야 이런
내 감정의 폭
넌 정말
Licorice
Licorice
Licorice
(Ah Ah Ah Ah)

I wanna
scream and shout
좀 이상한 맘
싫다가도 좋아
널 못 놓겠어
넌 정말
Licorice
Licorice
Licorice
자꾸 손이 가
Like Licorice

It’s the bomb like that
It’s the,
it’s the bomb like that
한 번 터지면
Sticky Sticky
Oh my god
방심한 틈 난
Hooked
덫에 걸려들어
All shook
내 머릿속엔 No
But say let’s go,
let’s go go

소름 돋는 Thrill
뭔가 색달라
다른 건 재미없어
시시해
(Like Like Like)
마비된 듯해
모든 감각도
어떤 자극도
오지 않는 걸

It tastes so
sweet but sour
Oh Sugar and spice
처음이야 이런
내 감정의 폭
넌 정말
Licorice
Licorice
Licorice
(Ah Ah Ah Ah)

이런 내 모습
이런 내 맘이
나도 이해가 안 되지
피할 수 없어
이건 Gravity
아찔한
Dynamite
알지만
못 참아
어딘가 어딘가
고장 났어
더 크게 더 크게
번져가

I wanna
scream and shout
왜인진 몰라
미묘한 듯 좋아
딱 붙어있어
넌 정말
Licorice
Licorice
Licorice
자꾸 떠올라
Like Licorice

Scream and shout
훅 끌리는 맘
위험해도 좋아
널 못 놓겠어
넌 정말
Licorice
Licorice
Licorice
자꾸 손이 가
Like Licorice'),

       ('BAHAMA', 'Kenzie, Jonatan Gusmark, Ludvig Evers, Moa “Cazzi Opeia” Carlebecker, Ellen Berg', 'Kenzie', null,
        'Dance', false, 'upload/BAHAMA.mp3', '2024-05-27', 2, 'Bahama,
ba ba
Bahama, hama
(Bahama)
Bahama,
ba ba
Bahama, hama
(Bahama)

지금 어디야?
아무것도 묻지도
말고 빨리 와
누구도
널 찾지 못하게
전화도 다 꺼놔

태평양을 넘어
꿈에서 본 섬
이제 거의 다 왔어 Uh
이거야 꿈같아

이 느낌 알지
찰랑찰랑
부서지는 그 파도
뛰어들 거야
피나 쿨라다
Cheers 훌쩍 떠나
We young,
young,
young
Bahama

Take me, take me
Take me on an
ocean blue
Bahama,
ba ba
Bahama, hama
Surfin’, surfin’
Surfin’ on a wave
with you
Bahama,
ba ba
Bahama, hama

Here we go!

까맣게 탄 너와
(Ok)
모래성을 쌓아
(Like that)
So cute
like you
더우면 깨물자 Ice
파랑을 끼얹은 Punch
So smooth
like you

쉼 없이 달려온
널 안고
춤출 거야
Oh La La La
웃는 네 얼굴이 좋아
너의 고민들을 알아
자, 손 한번
흔들어 주고
푸른 저 바다에 던져

벌써 노을이
붉어질 시간이야
너의 손잡은 채
걷고 싶어
행복이 뭐야
봐 Now we’re escaping
to, to, to
Bahama

Take me, take me
Take me on an
ocean blue
Bahama,
ba ba
Bahama, hama
Surfin’, surfin’
Surfin’ on a
wave with you
Bahama,
ba ba
Bahama, hama

I love this place
These summer days
오래오래
Bahama
Bahama
별이 빛나네
도시는 우릴 질투해
더 크게
소리 질러대
So so so crazy
So crazy
Let’s go to Bahama

We can have it all
That''s what we do
Yeah We can get it on
Yeah Me and you
Bahama
한순간이라도
멈추지 마

즐길수록 더 완벽해져
좀 더 천천히 흘러가자
Like it?
Huh Yeah
Baby We way too cool
Bahama!

Take me, take me
Take me on an
ocean blue
Bahama,
ba ba
Bahama, hama
(Oh I can take you there)
Surfin’, surfin’
Surfin’ on a
wave with you
Bahama,
ba ba
Bahama, hama

We should go
To the beach
Take it slow
Bahama'),

       ('Long Chat (#♥)', 'Stian Nyhammer Olsen, Live Rabo Lund-Roland, Nora Grefstad, Julia Finnseter', '문설리',
        'upload/Long Chat.mp4', 'Dance', false, 'upload/Long Chat.mp3', '2024-05-27', 2, 'Ha I’ll be the
girl who likes a Long Chat
Woo Ah

네모난 화면 속
창을 켜 Tap message
Dynamite
터질 것 같은 Battery
금세 말풍선은
쌓여만 가지
Really?
한눈을 팔면 놓치지
(Tell me, tell me)
들려줘
너의 그 사건 사고들
(Tell me, tell me)
골치가 아픈 일들까지 Dizzy
Twisted
마음속 깊숙이
혼자만 담아두지 말고
어서 Text it

Sweet night
금지 단어는 Tired
밤새 소란해
우린 Fire
끊임없는 Wow
빠져드는 How
분위기는 점점 더
Boom Boom Boom
Ah-Woo

할 말이 넘쳐나는
Long Chat
Black heart
Emoji도 같이
Hashtag Oh
말을 고르지 말고
Talk that
Who cares
우리끼리 뭐가 어때?
이 순간을 우리로 더
채워가자
몇 마디에 공감대는
쌓여만 가
자꾸만 재밌어져
Long Chat
So fun!
We are such TMT

Hold up
(What)
다 티가 나니까
너 숨기려고
들지 말고
표현해
Bla bla bla blah
So shake it off
고민은 전부 Talk
사소해도
상관없어 뭐든
Won’t be enough
밤을 새울 이유는
충분한 지금
설레는 이 기분
’Cause we’re cool

Sweet night
금지 단어는 Tired
밤새 소란해 우린 Fire
들을수록 Wow
흥미로워 How
분위기는 점점 더
Boom Boom Boom
Ah-Woo

할 말이 넘쳐나는
Long Chat
Black heart
Emoji도 같이
Hashtag Oh
말을 고르지 말고
Talk that
Who cares
우리끼리 뭐가 어때?
이 순간을 우리로 더
채워가자
몇 마디에 공감대는
쌓여만 가
자꾸만 재밌어져
Long Chat
So fun!
We are such TMT

Long Chat
어떤 말이라도
좋아 다
어서 털어놔 봐
Bestie
Hashtag
너의 속마음을 듣고파

So fun!
We are such TMT

잠들 시간이지만
멈출 수 없는 Typing
아쉬움은 커져가
No we keep
going on it
오늘 밤은
이쯤에서 Bye bye
다시 만나
언제라도 좋아
함께라면
Like a chatty girl
Oh Send me

할 말이 넘쳐나는
Long Chat
Black heart
Emoji도 같이
Hashtag Oh
말을 고르지 말고
Talk that
Who cares
우리끼리 뭐가 어때?
이 순간을 우리로 더
채워가자
몇 마디에 공감대는
쌓여만 가
자꾸만 재밌어져
Long Chat
So fun!
We are such TMT

Long Chat
어떤 말이라도
좋아 다
어서 털어놔 봐
Bestie
Hashtag
너의 속마음을 듣고파

I’ll be the girl who likes a
Long Chat'),

       ('Prologue', 'Gil Lewis, Micky Blue', 'Mola (PNP), 미아 (153/Joombas)', null, 'R&B', false, 'upload/Prologue.mp3',
        '2024-05-27', 2, 'Woo Woo Woo
La-la
Woo Woo Woo
La-la

난 내가 참 어려워
늘 모든 게
다 불안해
아직 어린 내 맘이
자라지 못한 채
나를 보곤 해

Hey Hey
어른이란
이름의 Tag
변해버린
Everything
갈필 잃은 맘이
날 밀어내 매일

Maybe
I’m a weirdo
I know
나만 이런 걸까
어린아이처럼
Oh No
왠지 난 서투른 걸
Oh And I don''t know
what to do
And I don''t know how
달려가는 시간 뒤로
나만 멈춰있어

It goes like

Woo Woo Woo
La-la
Woo Woo Woo
La-la

늘 기대완 다르게
흘러가는 Way
이젠 익숙해

그대로 걸어가
이 비 바람 다
때가 되면 다시
그칠 테니까
Oh

Hey Hey
의미 없어
정해진 Map
한 걸음씩
Every day
선명해진 맘이
날 이끌어 매일

Maybe
I’m a weirdo
I know
나만 이런 걸까
어린아이처럼
Oh No
왠지 난 서투른 걸
Oh And I don''t know
what to do
And I don''t know how
달려가는 시간 뒤로
나만 멈춰있어

Baby
다른 누구와 내 삶을
비교할 필요 없어
하루씩
나의 것들로 날
채워나가

삶이란 미로
때론 헤매도
이 자체로 소중한 걸
그 끝이 어디든
정해진 결말은 없어

누가 뭐라 해도
Oh No
나답게 가고 싶어

오직 나만의 속도로
흐름대로 가
셀 수 없는 날들 위로
나의 이야길 써
지금 난

Woo Woo Woo
La-la
Woo Woo Woo
La-la
'),

       ('Live My Life', 'Sophia Brenan, Nick Hahn, Edvard Forre Erfjord', 'Leslie', 'upload/Live My Life.mp4',
        'Rock/Metal', false, 'upload/Live My Life.mp3', '2024-05-27', 2, 'Bye 따분한
고지식한
그런 사고방식
Say 솔직한 마음만
너를 속이진 마

You and me
다른 꿈을
그릴 뿐이지
But you and me
Keep believing

I Live My Life
이제 난
틀에 맞춰진
규칙 깨버려
뻔한 네 사고방식
I Live My Life
이제부터가
시작이야
내가 선택한
삶의 주인공은 나

기대해
Live My Life
새롭게
Live My Life
Oh 힘차게
Live My Life
외쳐봐
Live My Life

Keep
빛나는 Eyes
Better idea
자신 있는 표정
Lightly
움직이는 변화
Make it a new thing
그래 또 다른
시작이야

You and me
다른 꿈을
꾸는 듯했지
But you and me
Keep believing

I Live My Life
이제 난
틀에 맞춰진
규칙 깨버려
뻔한 네 사고방식
I Live My Life
이제부터가
시작이야
내가 선택한
삶의 주인공은 나

기대해
Live My Life
(때론 힘들어도)
새롭게
Live My Life
(나에게 찾아오는 소중한 Light)
Oh 힘차게
Live My Life
(Don’t give up 자신을 믿어)
외쳐봐
Live My Life
(소중한 Your life)

시간은 멈출 수 없잖아
Life’s too short
No more,
I don’t care
구속하지 말아줘
인생에 정답이란 없어
You know best
You just live your life
나답게 난 살 거야

I Live My Life
이제 난
두렵지 않아
주저하지 마
Life is like a miracle
I Live My Life
이제부터가
진짜야
내가 행복할
삶의 주인공은 나

기대해
Live My Life
새롭게
Live My Life
Oh 힘차게
Live My Life
외쳐봐
Live My Life

Life'),

       ('목소리 (Melody)', '밍지션 (minGtion), Sophia Pae', '이오늘', null, 'Ballad', false, 'upload/목소리 (Melody).mp3',
        '2024-05-27', 2, 'Every night
지친 하루 끝에
커져가는 빈자리
그럴 땐
난 자연스레
떠오르는
너를 생각해

유난히
예쁜 장면 속엔
언제나
함께했던 너
You make me
feel so lucky
같은 맘이길

네 시선이 닿는
그 자리에
머물러 있을게
수없이 많은 밤
날 비춰주던
너의 맘처럼
Oh You’re the one
내 안에
유일한 Melody
너를 부르는 목소리

희미하게 뱉은
숨소리도
잠길 듯한 밤이면
널 기억할게
더 깊이
‘Cause you’re MY
whole world

허전하던
내 세상 속에
(세상 속에)
가득히 채워주었던
(너로)
You making me
feel like I’m lucky
같은 맘이길

네 시선이 닿는
그 자리에
머물러 있을게
수없이 많은 밤
날 비춰주던
너의 맘처럼
Oh You’re the one
내 안에
유일한 Melody
너를 부르는
목소리

너의 목소리
그저 하염없이
흘러가는 세상에
내 영원한 안식처
알 수 없이 이끌린
내 모든 걸음마다
For you
For you

내 시선이 닿는
그 자리에
머물러 있어 줘
수없이 많은 밤
날 비춰주던
(그 사랑으로)
너의 맘처럼
(나를 안아줘)
Oh You’re the one
날 위해
널 담은 Melody
나를 부르는
목소리
우릴 이어준
목소리'),

       ('How Sweet', '250, Sarah Aarons, Elvira Anderfjard, Oscar Scheller, Stella Bennett, Tove Burman',
        'Gigi, Sarah Aarons, Elvira Anderfjard, Oscar Scheller, Stella Bennett, Tove Burman, 다니엘(DANIELLE)',
        'upload/How Sweet.mp4', 'Dance', true, 'upload/How Sweet.mp3', '2024-05-24', 3, 'All I know is now
알게 됐어 나 (I know)
그동안 맨날
Always up and down (No more)
생각 또 생각
Spinnin’ ‘round and ‘round
Changing my mind

수상해서 그렇지
이런 헛소리 (No more)
How it’s supposed to be
그만해 cus it’s clear (It’s simple)
It’s like biting an apple

Toxic lover
You’re no better, 거기 숨지 말고 얼른 나와
You little demon in my storyline
Don’t knock on my door, I’ll see you out

And don’t you know how sweet it tastes
(How sweet it tastes)
Ya don’t you know how sweet it tastes
(How sweet it tastes)
Ya don’t you know how sweet it tastes
Now that I’m without you

나 더는 묻지 않을래
(How sweet it tastes)
알려주지 않아도 돼
(How sweet it tastes)
Wow don’t you know how sweet it tastes
Now that I’m without you

모든 게 typical
So I’ve been praying so hard for a miracle
부르고 있어 나의 이름을
더는 안 봐 drama it’s good karma
Done scrolling thousand times
다 알고 있어 뻔한 수작일 뿐이야
완전 쉬운 공식이야
It’s like biting an apple

And don’t you know how sweet it tastes
(How sweet it tastes)
Ya don’t you know how sweet it tastes
(How sweet it tastes)
Ya don’t you know how sweet it tastes
Now that I’m without you

나 더는 묻지 않을래
(How sweet it tastes)
알려주지 않아도 돼
(How sweet it tastes)
Wow don’t you know how sweet it tastes
Now that I’m without you

I won’t wait, I’m feeling
My own way, I’m in it
Cause me and you are diﬀerent
So I won’t stay, I’m leaving
I won’t wait, I’m feeling
My own way, I’m in it
Cause me and you are diﬀerent
So I won’t stay, I’m leaving

And don’t you know how sweet it tastes
(How sweet it tastes)
Ya don’t you know how sweet it tastes
(How sweet it tastes)
Ya don’t you know how sweet it tastes
Now that I’m without you

나 더는 묻지 않을래
(How sweet it tastes)
알려주지 않아도 돼
(How sweet it tastes)
Wow don’t you know how sweet it tastes
Now that I’m without you

Toxic lover
You’re no better, 거기 숨지 말고 빨리 나와
You little demon in my storyline
Don’t knock on my door 너 얼른 나가버려

Toxic lover
You’re no better, 거기 숨지 말고 얼른 나와
You little demon in my storyline
Don’t knock on my door, I’ll see you out'),

       ('해야 (HEYA)', 'Ryan S. Jhun, Dwayne Abernathy Jr., Ido Nadjar, Kloe Latimer, Jack Brady, Jordan Roman',
        '이스란, 엑시 (우주소녀), 솔희 (SOHLHEE)', 'upload/해야 (HEYA).mp4', 'Dance', true, 'upload/해야 (HEYA).mp3', '2024-04-29', 4,
        'Let’s get it
    Look at it
    Pay attention

    얼어붙은 맘 어디 깨볼까?
    놀라버렸던 네 심장 말이야
    맘에 들었어 넌 그냥 Say yes
    내가 널 부르면 “얼음 땡”

    (Da da da dun dun)
    널 노리는 내 두 눈
    숨을 죽인 그다음
    한 발 낮춘 attitude
    때를 기다리는 pose

    어둠 속 빛난 tiger eyes
    날 감춘 채로 다가가
    새빨간 말로 홀려 놔
    방심한 순간 claw

    우린 더 높이
    하늘에 닿을 것처럼 외쳐 너를 깨워
    올려 봐 노려봐 넌 내 거니까 다
    자꾸 널 보면 탐이 탐이 나

    해야 해야 해야
    한입에 널 삼킬 때야
    (탐이 탐이 나)
    해야 해야 해야
    이미 내가 이긴 패야
    (널 보면 탐이 탐이 나)

    해야 해야 해야
    뜨겁게 떠오르는 해야
    별안간 홀린 그 순간 Bite
    단 한 번에 난 널 휘리휘리 Catch ya

    더 높이 Keep it up
    Uh huh
    Happily ever after? Nope!
    (Da da da dun dun)

    못 기다린대 못 돼버린 내 맘이
    겁 따윈 없는 척하지 마 너 감히
    멀어져 넌 가니
    어차피 한 입 거리 (Hey)
    옳지 착하지 더 이리이리 오렴

    네 맘 나 주면 안 잡아먹지 Right now
    내 발톱 아래 뭘 숨겼을지 Watch out

    우린 더 높이
    하늘에 닿을 것처럼 외쳐 너를 깨워
    올려 봐 노려봐 넌 내 거니까 다
    자꾸 널 보면 탐이 탐이 나

    해야 해야 해야
    한입에 널 삼킬 때야
    (탐이 탐이 나)
    해야 해야 해야
    이미 내가 이긴 패야
    (널 보면 탐이 탐이 나)

    해야 해야 해야
    뜨겁게 떠오르는 해야
    별안간 홀린 그 순간 Bite
    단 한 번에 난 널 휘리휘리 Catch ya

    휘리휘리 휘리휘리
    휘리휘리 휘리휘리

    더 붉게 더 밝게
    타올라 뜨거워도 좋으니
    더 높게 더 높게
    숨어도 넌 내 손바닥 안이니

    깊은 어둠이 짙은 구름이
    또 긴 밤 아래 널 감출 테니
    Chew and swallow
    Get ready for it, baby
    (Listen when I say)

    자꾸 널 보면 탐이 탐이 나

    해야 해야 해야
    한입에 널 삼킬 때야
    (탐이 탐이 나)
    해야 해야 해야
    이미 내가 이긴 패야
    (널 보면 탐이 탐이 나)

    해야 해야 해야
    뜨겁게 떠오르는 해야
    별안간 홀린 그 순간 Bite
    Da da da dun dun dun'),

       ('첫 만남은 계획대로 되지 않아',
        'WASURENAI, 전진, Ohway!, Nmore, Heon Seo (헌서), BuildingOwner, Glenn, T-SK (Chizaki Taisuke), YouthK',
        'WASURENAI, 브라더수, 전진, BuildingOwner, Glenn', 'upload/첫 만남은 계획대로 되지 않아.mp4', 'Dance', true,
        'upload/첫 만남은 계획대로 되지 않아.mp3', '2024-01-22', 5, 'Ay ay ay ay ay
거울 속에 내 표정 봐 봐
느낌 So good 기다려온 D-day
연습했던 손든 인사도 그대로 하면 돼
Hairstyle check하고 한 번 Turn around

발걸음은 매일 걷던 그 길로
계획은 완벽
빨리 말 걸어보고 싶어, Hey

Woo 문 앞에서 셋을 세어본다, Yeh

(셋, 둘, 하나)

첫 만남은 너무 어려워
계획대로 되는 게 없어서
첫 만남은 너무 어려워
내 이름은 말야

Hey,
안녕, 첫 마디를 건넬 때
주변 소린 Canceled
네 말소리는 Playlist

Yeh,
질문은 나의 용기, 알려줘 너의
“이름이 뭐야?”

너와 내 거리는 세 걸음 남았어, Yeh

(셋, 둘, 하나)

첫 만남은 너무 어려워
계획대로 되는 게 없어서
첫 만남은 너무 어려워
내 이름은 말야

이 순간, Feels so wonderful
조금은 뚝딱거려도
어색한 인사까지도
너와 나의 첫 만남

우리의 사이 Beautiful
내일도 내일모레도
기억해, 영원히 반짝일 순간

Wait wait!

Na na na-

이렇게 만나서 반가워
내일 또 봐 안녕
'),

       ('고민중독', '이동혁, 홍훈기 (PRISMFILTER), Elum, Gesture (PRISMFILTER), 한아영',
        '이동혁, Gesture (PRISMFILTER), 김혜정, Elum, 마젠타', 'upload/고민중독.mp4', 'Rock/Metal', true, 'upload/고민중독.mp3',
        '2024-04-01', 6, 'One! Two! Q! W! E! R!
어떤 인사가 괜찮을까 천 번쯤 상상해 봤어
근데 오늘도 천 번 하고 한 번 더 고민 중

막상 네 앞에 서니 꽁꽁 얼어버렸다
숨겨왔던 나의 맘 절반의 반도 주지를 못했어

아, 아, 아직은
준비가 안됐다구요
소용돌이쳐 어지럽다구

쏟아지는 맘을 멈출 수가 없을까?
너의 작은 인사 한마디에 요란해져서
네 맘의 비밀번호 눌러 열고 싶지만
너를 고민고민해도 좋은 걸 어쩌니

거울 앞에서 새벽까지 연습한 인사가
손을 들고 웃는 얼굴을 하고서 고개를 숙였다

아, 아, 아직도 준비가 안됐나 봐요
소용돌이쳐 어지럽다구

쏟아지는 맘을 멈출 수가 없을까?
너의 작은 인사 한마디에 요란해져서
네 맘의 비밀번호 눌러 열고 싶지만
너를 고민고민해도 좋은 걸

이러지도 저러지도 못하는데
속이 왈칵 뒤집히고
이쯤 왔으면 눈치 챙겨야지
날 봐달라구요!

좋아한다 너를 좋아한다 좋아해

너를 많이 많이 좋아한단 말이야
벅차오르다 못해 내 맘이 쿡쿡 아려와
두 번은 말 못 해 너 지금 잘 들어봐
매일 고민하고 연습했던 말
좋아해'),

       ('사랑은 늘 도망가', '홍진영', '강태규', 'upload/사랑은 늘 도망가.mp4', 'Ballad', true, 'upload/사랑은 늘 도망가.mp3', '2021-10-11', 7, '눈물이 난다 이 길을 걸으면
그 사람 손길이 자꾸 생각이 난다
붙잡지 못하고 가슴만 떨었지
내 아름답던 사람아
사랑이란 게 참 쓰린 거더라
잡으려 할수록 더 멀어지더라
이별이란 게 참 쉬운 거더라
내 잊지 못할 사람아
사랑아 왜 도망가
수줍은 아이처럼
행여 놓아버릴까 봐
꼭 움켜쥐지만
그리움이 쫓아 사랑은 늘 도망가
잠시 쉬어가면 좋을 텐데
바람이 분다 옷깃을 세워도
차가운 이별의 눈물이 차올라
잊지 못해서 가슴에 사무친
내 소중했던 사람아
사랑아 왜 도망가
수줍은 아이처럼
행여 놓아버릴까 봐
꼭 움켜쥐지만
그리움이 쫓아 사랑은 늘 도망가
잠시 쉬어가면 좋을 텐데
기다림도 애태움도 다 버려야 하는데
무얼 찾아 이 길을 서성일까
무얼 찾아 여기 있나
사랑아 왜 도망가
수줍은 아이처럼
행여 놓아버릴까 봐
꼭 움켜쥐지만
그리움이 쫓아 사랑은 늘 도망가
잠시 쉬어가면 좋을 텐데
잠시 쉬어가면 좋을 텐데'),

       ('SPOT! (feat. JENNIE)', '지코 (ZICO), 은희영, 노 아이덴티티 (No Identity)', '지코 (ZICO)', 'upload/SPOT! (feat. JENNIE).mp4',
        'HipHop', true, 'upload/SPOT! (feat. JENNIE).mp3', '2024-04-26', 8, 'Everything ok my man
Turn the music up

Uhm we’re not going home tonight, alright
네 계획에 없던 party
Up and down round and round
Hit the spot spot spot spot
엎치락뒤치락 정신을 왜 차려 왜

Hey girl where you at
데리러 갈게 send me the address
No dress code 대충 걸치면 돼
우린 꾸밈없고, 나머진 억텐 yeah

농익은 분위기 it’s too sticky
마구 부대껴 어머! 정전기 찌릿
여긴 내 동생 저기는 내 homie
순둥이지만 음악 틀면 눈 돌지

Chillin’ out, we yellin’ out, one more
찐친 바이브 위아래 안 따져
부끄런 I 피식 E를 드러내
포위됐어 넌 now hands in the air

Uhm we’re not going home tonight, alright
네 계획에 없던 party
Up and down round and round
Hit the spot spot spot spot
엎치락뒤치락 정신을 왜 차려 왜

Up and down round and round
Everybody hit the spot
Up and down round and round
Everybody hit the top
Up and down round and round
Everybody make it loud (Make it loud)
Up and down round and round
Ain’t nobody hold us down

어깨 툭툭 he say “Yo JENNIE,
Told you that 도망치면 배신”
Yeah, I know I know
일단 더우니까 바람 쐬러 나가

Bae 나갈 때 뒤로 딱 붙어
땀 뺐으니까 후딱 아이스크림 go
들키면 피곤해져 put your mask on
한바퀴 돌고 퀵하게 조인해

우리 프로젝트 타이틀 명은 J Z
We gon’ run this town, that’s crazy
짱박아 놨던 네 똘끼를 꺼내
해방됐어 넌 now hands in the air

Uhm we’re not going home tonight, alright
네 계획에 없던 party
Up and down round and round
Hit the spot spot spot spot
엎치락뒤치락 정신을 왜 차려 왜

Up and down round and round
Everybody hit the spot
Up and down round and round
Everybody hit the top
Up and down round and round
Everybody make it loud
Up and down round and round
Everybody Stop
Wait a minute ahhh

Come vibe with us
Ride with us'),

       ('나는 아픈 건 딱 질색이니까', '소연 ((여자)아이들), Pop Time, Daily, Likey', '소연 ((여자)아이들)', null, 'Dance', false,
        'upload/나는 아픈 건 딱 질색이니까.mp3', '2024-01-29', 9, '오늘도 아침엔 입에 빵을 물고
똑같이 하루를 시작하고
온종일 한 손엔 아이스 아메리카노
피곤해 죽겠네

지하철 속 이 장면 어제 꿈에서 봤나
아참 매일이지 지나치고
바쁜 이 삶에 그냥 흔한 날에
그 애를 보고 말야

평온했던 하늘이 무너지고
어둡던 눈앞이 붉어지며
뭔가 잊고 온 게 있는 것 같아
괜히 이상하게 막 울 것만 같고
그냥 지나치는 게 나을 것 같아
나는 생각은 딱 질색이니까

카페인으로 잡은 정신은 빠졌고
하루 종일 신경 쓰여 토할 것 같아
저녁이 돼도 배고픔까지 까먹고
그치 이상하지 근데 말야 있잖아

처음 본 순간 뭐라 할까 그립달까
나도 웃긴데 말야

평온했던 하늘이 무너지고
어둡던 눈앞이 붉어지며
뭔가 잊고 온 게 있는 것 같아
괜히 이상하게 막 울 것만 같고
그냥 지나치는 게 나을 것 같아
나는 생각은 딱 질색이니까

오랫동안 나를 아는
슬픈 표정을 하고 Oh
흔적 없는 기억 밖
혹 과거에 미래에 딴 차원에 세계에
1 2 3 4 5 6 7 8

평온했던 하늘이 무너지고
어둡던 눈앞이 붉어져도
다시 놓쳐버리는 것만 같아
괜히 이상하게 막 울 것만 같고
그냥 지나치는 게 나을 것 같아
나는 생각은 딱 질색이니까

아냐 지나치는 게 나을 것 같아
나는 아픈 건 딱 질색이니까'),

       ('Magnetic',
        'Slow Rabbit, "Hitman" Bang, martin, salem ilese, danke, VINCENZO, 이이진, piri, Lauren Amber Aquilina, Marcus Andersson, 김키위, 오현선 (lalala studio), JAMES',
        'Slow Rabbit, "Hitman" Bang, martin, salem ilese, danke, VINCENZO, 이이진, piri, Lauren Amber Aquilina, Marcus Andersson, 김키위, 오현선 (lalala studio), JAMES',
        'upload/Magnetic.mp4', 'Dance', true, 'upload/Magnetic.mp3', '2024-03-25', 10, 'Baby
I’m just trying to play it cool
But I just can’t hide that
I want you

Wait a minute 이게 뭐지?
내 심장이 lub-dub
자꾸만 뛰어

저 멀리서도 oh my gosh!
끌어당겨 you’re my crush!
초능력처럼

거대한 자석이 된 것만 같아 my heart
네 모든 게 내 맘에 달라붙어버려 boy

We’re magnetized 인정할게
This time I want

You You You You like it’s magnetic
U U U U U U U U super 이끌림
You You You You like it’s magnetic
U U U U U U U U super 이끌림

BAE BAE BAE BAE BAE BAE BAE BAE BAE
Dash-da-da Dash-da-da Dash-da
Like it’s magnetic
BAE BAE BAE BAE BAE BAE BAE BAE BAE
Dash-da-da Dash-da-da
Baby don’t say no

정반대 같아 our type
넌 J 난 완전 P
S와 N 극이지만
그래서 끌리지

내가 만들래 green light
여잔 배짱이지
So let’s go let’s go
Let’s go let’s go

숨기고 싶지 않아 자석 같은 my heart
내 맘의 끌림대로 너를 향해 갈게 boy

We’re magnetized 인정할게
This time I want

You You You You like it’s magnetic
U U U U U U U U super 이끌림
You You You You like it’s magnetic
U U U U U U U U super 이끌림

No push and pull
전속력으로 너에게 갈게
(In a rush in a rush)
Our chemistry
난 과몰입해 지금 순간에
(Baby you’re my crush you’re my crush)

No push and pull
네게 집중 후회는 안 할래
(Gonna dash gonna dash)
Never holding back
직진해 yeah
This time I want

You You You You like it’s magnetic
U U U U U U U U super 이끌림
You You You You like it’s magnetic
U U U U U U U U super 이끌림

BAE BAE BAE BAE BAE BAE BAE BAE BAE
Dash-da-da Dash-da-da Dash-da
Like it’s magnetic
BAE BAE BAE BAE BAE BAE BAE BAE BAE
Dash-da-da Dash-da-da
Baby don’t say no'),

       ('소나기', '한성호, 박수석, Moon Kim (Room 01)', '한성호, 수윤 (Sooyoon)', null, 'Ballad', true, 'upload/소나기.mp3',
        '2024-04-08', 11, '그치지 않기를 바랬죠
    처음 그대 내게로 오던 그날에
    잠시 동안 적시는
    그런 비가 아니길
    간절히 난 바래왔었죠

    그대도 내 맘 아나요
    매일 그대만 그려왔던 나를
    오늘도 내 맘에 스며들죠

    그대는 선물입니다
    하늘이 내려준
    홀로 선 세상 속에
    그댈 지켜줄게요
    어느 날 문득
    소나기처럼
    내린 그대지만
    오늘도 불러 봅니다
    내겐 소중한 사람
    Oh

    떨어지는 빗물이
    어느새 날 깨우고
    그대 생각에 잠겨요

    이제는 내게로 와요
    언제나처럼 기다리고 있죠
    그대 손을 꼭 잡아줄게요

    그대는 선물입니다
    하늘이 내려준
    홀로 선 세상 속에
    그댈 지켜줄게요
    어느 날 문득
    소나기처럼
    내린 그대지만
    오늘도 불러 봅니다
    내겐 소중한 사람

    잊고 싶던 아픈 기억들도
    빗방울과 함께 흘려보내면 돼요
    때로는 지쳐도
    하늘이 흐려도
    내가 있다는 걸 잊지 말아요

    그대는 사랑입니다
    하나뿐인 사랑
    다시는 그대와 같은
    사랑 없을 테니
    잊지 않아요
    내게 주었던
    작은 기억 하나도
    오늘도 새겨봅니다
    내겐 선물인 그댈');


-- song_tb에 더미 데이터 삽입
INSERT INTO song_tb (title, song_writer, lyricist, music_video, genre, is_title, music_file, created_at, album_id,
                     lyrics)
VALUES ('ON', 'Pdogg, RM, August Rigo, Melanie Fontana, Michel ''Lindgren'' Schulz, SUGA, j-hope, Antonina Armato, Krysta Youngs, Julia Ross
', 'Pdogg, RM, August Rigo, Melanie Fontana, Michel ''Lindgren'' Schulz, SUGA, j-hope, Antonina Armato, Krysta Youngs, Julia Ross
', '/upload/song/ON.mp4', 'Dance', TRUE, '/upload/song/ON.mp3', '2020-02-21', 12, 'I can''t understand what people are sayin''
어느 장단에 맞춰야 될지
한 발자국 떼면 한 발자국 커지는 shadow
잠에서 눈을 뜬 여긴 또 어디
어쩜 서울 또 New York or Paris
일어나니 휘청이는 몸

Look at my feet, look down
날 닮은 그림자
흔들리는 건 이놈인가
아니면 내 작은 발끝인가
두렵잖을 리 없잖아
다 괜찮을 리 없잖아
그래도 I know
서툴게 I flow
저 까만 바람과 함께 날아

Hey na na na
미치지 않으려면 미쳐야 해
Hey na na na
나를 다 던져 이 두 쪽 세상에
Hey na na na
Can’t hold me down cuz you know I’m a fighter
제 발로 들어온 아름다운 감옥
Find me and I''m gonna live with ya

(Eh-oh)
가져와 bring the pain oh yeah
(Eh-oh)
올라타봐 bring the pain oh yeah
Rain be pourin''
Sky keep fallin''
Everyday oh na na na
(Eh-oh)
가져와 bring the pain oh yeah

Bring the pain
모두 내 피와 살이 되겠지
Bring the pain
No fear, 방법을 알겠으니
작은 것에 breathe
그건 어둠 속 내 산소와 빛
내가 나이게 하는 것들의 힘
넘어져도 다시 일어나 scream

넘어져도 다시 일어나 scream
언제나 우린 그랬으니
설령 내 무릎이 땅에 닿을지언정
파묻히지 않는 이상
그저 그런 해프닝쯤 될 거란 걸
Win no matter what
Win no matter what
Win no matter what
네가 뭐라던 누가 뭐라던
I don''t give a uhh
I don''t give a uhh
I don''t give a uhh

Hey na na na
미치지 않으려면 미쳐야 해
Hey na na na
나를 다 던져 이 두 쪽 세상에
Hey na na na
Can’t hold me down cuz you know I’m a fighter
제 발로 들어온 아름다운 감옥
Find me and I''m gonna live with ya

(Eh-oh)
가져와 bring the pain oh yeah
(Eh-oh)
올라타봐 bring the pain oh yeah
Rain be pourin''
Sky keep fallin''
Everyday oh na na na
(Eh-oh)
가져와 bring the pain oh yeah

나의 고통이 있는 곳에
내가 숨 쉬게 하소서
My everythin’
My blood and tears
Got no fears
I''m singin’ ohhhhh
Oh I’m takin’ over
You should know yeah
Can’t hold me down cuz you know I’m a fighter
깜깜한 심연 속 기꺼이 잠겨
Find me and I’m gonna bleed with ya

(Eh-oh)
가져와 bring the pain oh yeah
(Eh-oh)
올라타봐 bring the pain oh yeah
Rain be pourin''
Sky keep fallin''
Everyday oh na na na
(Eh-oh)
Find me and I’m gonna bleed with ya

(Eh-oh)
가져와 bring the pain oh yeah
(Eh-oh)
올라타봐 bring the pain oh yeah
All that I know
is just goin’ on & on & on & on
(Eh-oh)
가져와 bring the pain oh yeah
');
INSERT INTO song_tb (title, song_writer, lyricist, music_video, genre, is_title, music_file, created_at, album_id,
                     lyrics)
VALUES ('Lovesick Girls', 'TEDDY, 24, 제니 (JENNIE), Brian Lee, Leah Haywood, R.Tee, David Guetta', 'TEDDY, LØREN, 지수 (JISOO), 제니 (JENNIE), DANNY CHUNG
', '/upload/song/Lovesick Girls.mp4', 'Pop', TRUE, '/upload/song/Lovesick Girls.mp3', '2020-10-02', 13, '영원한 밤
창문 없는 방에
우릴 가둔 love
What can we say
매번 아파도 외치는 love

다치고 망가져도 나
뭘 믿고 버티는 거야
어차피 떠나면
상처투성인 채로
미워하게 될걸
끝장을 보기 전
끝낼 순 없어
이 아픔을 기다린 것처럼

아마 다 잠깐 일지도 몰라
우린 무얼 찾아서 헤매는 걸까

But I don’t care
I’ll do it over and over
내 세상 속엔 너만 있으면 돼

We are the lovesick girls
네 멋대로
내 사랑을 끝낼순 없어
We are the lovesick girls
이 아픔 없인
난 아무 의미가 없어

But we were born to be alone
Yeah we were born to be alone
Yeah we were born to be alone
But why we still looking for love

No love letters, no x and o’s
No love never, my exes know
No diamond rings
that set in stone
To the left, better left alone

Didn’t wanna be
a princess, I’m priceless
A prince not even on my list
Love is a drug that I quit
No doctor could help
when I’m lovesick

아마 다 잠깐 일지도 몰라
우린 무얼 찾아서 헤매는 걸까

불안한 내 눈빛 속에 널 담아
아프더라도 너만 있으면 돼

We are the lovesick girls
네 멋대로
내 사랑을 끝낼 순 없어
We are the lovesick girls
이 아픔 없인
난 아무 의미가 없어

But we were born to be alone
Yeah we were born to be alone
Yeah we were born to be alone
But why we still looking for love

사랑은 slippin’ and fallin’
사랑은 killin’ your darlin’
아프다 아물면
또 찾아오는 이 겁 없는 떨림

들리지 않아 what you say
이 아픔이 난 행복해
나를 불쌍해 하는
네가 내 눈엔 더 불쌍해

We are the lovesick girls
네 멋대로
내 사랑을 끝낼 순 없어
We are the lovesick girls
이 아픔없인
난 아무 의미가 없어

Lovesick girls
모두 결국 떠나가고
Lovesick girls
내 눈물이 무뎌져도
Lovesick girls
아프고 또 아파도
Lovesick girls
But we’re still looking for love
');
INSERT INTO song_tb (title, song_writer, lyricist, music_video, genre, is_title, music_file, created_at, album_id,
                     lyrics)
VALUES ('팔레트 (Feat. G-DRAGON)', '아이유 (IU)', '아이유 (IU)', '/upload/song/Palette.mp4', 'Ballade', TRUE,
        '/upload/song/Palette.mp3', '2017-04-21', 14, '이상하게도 요즘엔 그냥 쉬운 게 좋아
하긴 그래도 여전히 코린 음악은 좋더라
Hot Pink 보다 진한
보라색을 더 좋아해
또 뭐더라 단추 있는
Pajamas Lipstick
좀 짓궂은 장난들
I like it I''m twenty five
날 좋아하는 거 알아
I got this I''m truly fine
이제 조금 알 것 같아 날
긴 머리보다 반듯이 자른
단발이 좋아
하긴 그래도 좋은 날 부를 땐
참 예뻤더라
오 왜 그럴까 조금
촌스러운 걸 좋아해
그림보다 빼곡히 채운 Palette 일기 잠들었던 시간들
I like it I''m twenty five
날 미워하는 거 알아
I got this I''m truly fine
이제 조금 알 것 같아 날
어려서 모든 게 어려워
잔소리에 매 서러워
꾸중만 듣던 철부지 애
겨우 스무고개 넘어 기쁨도 잠시 어머
아프니까 웬 청춘이래
지은아 오빠는 말이야 지금 막 서른인데
나는 절대로 아니야 근데 막 어른이 돼
아직도 한참 멀었는데 너보다 다섯 살 밖에 안 먹었는데
스물 위 서른 아래
고맘때 Right there
애도 어른도 아닌 나이 때
그저 나일 때
가장 찬란하게 빛이 나
어둠이 드리워질 때도 겁내지 마
너무 아름다워서 꽃잎 활짝 펴서
언제나 사랑 받는 아이 YOU
Palette 일기 잠들었던 시간들
I like it I''m twenty five
날 좋아하는 거 알아
I got this I''m truly fine
이제 조금 알 것 같아 날
아직 할 말이 많아
I like it I''m twenty five
날 미워하는 거 알아
I got this I''ve truly found
이제 조금 알 것 같아 날
');
INSERT INTO song_tb (title, song_writer, lyricist, music_video, genre, is_title, music_file, created_at, album_id,
                     lyrics)
VALUES ('I CAN`T STOP ME', 'Melanie Fontana, Michel ''Lindgren'' Schulz, A Wright
', 'J.Y. Park "The Asiansoul", 심은지', '/upload/song/I CAN`T STOP ME.mp4', 'Dance', TRUE, '/upload/song/I CAN`T STOP ME.mp3',
        '2020-10-26', 15, '알람이 울려대
Ring ring a ling
서로의 눈길이 닿을 때마다
알면서 빙빙 도는데
점점 다가가잖아
I know it’s too late
마음속으로는
다 알고 있잖아
결국에는 선을
넘게 될 거라는 걸
I’m warning myself
너 그러면 안 돼
매분, 매초
내 맘이 내 맘을 추월해
Out of control

나를 감시하는 저
Spot spot spotlight
비출수록
어둠 속으로 빨려 들어
끝이 보이는데
I know it’s not right
I can’t stop me
can’t stop me

내 앞에 놓여진 이
Red red red line
건너편의 너와 난
이미 눈을 맞춰
느끼고 싶어
짜릿한 Highlight
I can’t stop me
can’t stop me

I can’t stop me
can’t stop me

눈감아 달라구 Ya ya
딱 한 번만
No rules ah ah
모른 척해 줘
Lights off tonight
나 참을 수 없을 거 같아
Losing myself

이제는 Turning back
불가능해 난 점점
더 깊은 어둠에
너무나 짜릿해
나 눈을 감을래
다시는 돌아갈 수
없을 것만 같애
Out of control

나를 감시하는 저
Spot spot spotlight
비출수록
어둠 속으로 빨려 들어
끝이 보이는데
I know it’s not right
I can’t stop me
can’t stop me

내 앞에 놓여진 이
Red red red line
건너편의 너와 난
이미 눈을 맞춰
느끼고 싶어
짜릿한 Highlight
I can’t stop me
can’t stop me

Risky risky wiggy 위기
This is an emergency
Help me, help me
somebody stop me
Cuz I know I can’t stop me
답은 알고 있잖아
근데 가고 있잖아
이러고 싶지 않아
내 안에 내가 또 있나 봐

나는 원하는데
원하는 게 안돼
Guilty 난 싫은데
I can’t stop me
can’t stop me
can’t stop me

나를 감시하는 저
Spot spot spotlight
비출수록
어둠 속으로 빨려 들어
끝이 보이는데
I know it’s not right
I can’t stop me
can’t stop me

내 앞에 놓여진 이
Red red red line
건너편의 너와 난
이미 눈을 맞춰
느끼고 싶어
짜릿한 Highlight
I can’t stop me
can’t stop me

I can’t stop me
can’t stop me
');
INSERT INTO song_tb (title, song_writer, lyricist, music_video, genre, is_title, music_file, created_at, album_id,
                     lyrics)
VALUES ('Tempo', 'Tay Jasper, Leven Kali, MZMC, JAMIL “DIGI” CHAMMAS, Adrian McKinnon
', 'JQ, 페노메코 (PENOMECO), 유영진', 'tempo_mv.mp4', 'Dance', TRUE, '/upload/song/Tempo.mp3', '2018-11-02', 16, 'I can''t believe
기다렸던 이런 느낌
나만 듣고 싶은 그녀는 나의 멜로디
하루 종일 go on and on and oh
떠나지 않게 그녈 내 곁에
Don''t mess up my tempo
들어봐 이건 충분히
I said don''t mess up my tempo
그녀의 맘을 훔칠 beat
어디에도 없을 리듬에 맞춰 1, 2, 3
Don''t mess up my tempo
멈출 수 없는 이끌림
매혹적인 넌 lovely
틈 없이 좁혀진 거리
불규칙해지는 heartbeat
잠시 눈을 감아 trust me
밖으로 나갈 채비 미리 해둬 Are you ready?
오늘은 내가 캐리 도시 나 사이의 케미
이미 나와 놓곤 뭐가 창피해 ma boo
어정쩡 어버버 할 필요 없다고
챙길 건 없으니 손잡아 my lady
가는 길마다 레드 카펫 또 런웨이인걸
발걸음이 남달라
지금 이 속도 맞춰보자 tempo
Baby girl 아침을 설레게 하는 모닝콜
매일 봐도 보고 싶은 맘인걸
지금부터 나와 Let''s get down
모든 것이 완벽하게 좋아
So don''t slow it up for me
Don''t mess up my tempo
들어봐 이건 충분히
I said don''t mess up my tempo
그녀의 맘을 훔칠 beat
어디에도 없을 리듬에 맞춰 1, 2, 3
Don''t mess up my tempo
멈출 수 없는 이끌림
주윌 둘러봐 lovely
틈 없이 좁혀진 거리
너에게 맞춰진 heartbeat
하고 싶은 대로 teach me
여긴 내 구역 Don''t test me
혼자 있기 어색하다면 보내줘 message
Now you got me flexin''
주윌 둘러봐
널 보는 들러리들 속 위대한 개츠비 (Hold on wow)
I''m doing alright baby girl you don''t know
치워 네 머리 위에 물음표
내 사전에 없는 L.I.E
너는 이미 자연스럽게 맞추고 있어 내 tempo
Baby girl 내 어깨에 살짝 기댄 그대의
아련한 향기가 다시 내 맘에
소용돌이치며 몰아친다
이대로 난 영원하고 싶다
So don''t mess up my tempo baby
Don''t slow it up for me
Don''t mess up my tempo
Don''t mess up my tempo
Don''t mess up my tempo
Don''t mess up my tempo
Don''t mess up my tempo
Don''t mess up my tempo
Don''t mess up my tempo
내 눈을 바라보고 말해
나의 귓가에만 닿게
나만 사랑한다 말해
나밖에 없다고 말해
더 이상 흔들리지 않게
절대 널 뺏기지 않게
누구도 건들 수 없게
내 곁에 너를 지킬게
내 마음이 느껴지니
나를 감싸 안은 유일한 나만의 savior
모두 그런 널 바라보게 돼
I can''t believe
기다렸던 이런 느낌
나만 듣고 싶은 그녀는 나의 멜로디
하루 종일 go on and on and oh
떠나지 않게 그녈 내 곁에
Don''t mess up my tempo
따라와 이건 충분히
I said don''t mess up my tempo
완전히 다른 색의 beat
어디에도 없을 이런 완벽한 1, 2, 3
Don''t mess up my tempo
멈출 수 없는 이끌림
');
INSERT INTO song_tb (title, song_writer, lyricist, music_video, genre, is_title, music_file, created_at, album_id,
                     lyrics)
VALUES ('Psycho', 'Andrew Scott, Cazzi Opeia, EJAE', 'Kenzie', '/upload/song/Psycho.mp4', 'Dance', TRUE, '/upload/song/Psycho.mp3', '2019-12-23', 17,
        'Psycho
널 어쩌면 좋을까
이런 맘은 또 첨이라
Up & Down이 좀 심해
조절이 자꾸 잘 안돼
하나 확실한 건
I don''t play the game
우리 진짜 별나대
그냥 내가 너무 좋아해
넌 그걸 너무 잘 알고
날 쥐락펴락해
나도 마찬가지인걸
우린 참 별나고 이상한 사이야
서로를 부서지게
(부서지게)
그리곤 또 껴안아
(그리곤 또 껴안아)
You got me feeling like a
psycho psycho
우릴 보고 말해 자꾸 자꾸
다시 안 볼 듯 싸우다가도
붙어 다니니 말야
이해가 안 간대
웃기지도 않대
맞아 Psycho psycho
서로 좋아 죽는 바보 바보
너 없인 어지럽고 슬퍼져
기운도 막 없어요
둘이 잘 만났대
Hey now we''ll be ok
Hey trouble
경고 따윈 없이 오는 너
I''m original visual
우린 원래 이랬어 Yeah
두렵지는 않아
(흥미로울 뿐)
It''s hot! Let me just hop
어떻게 널 다룰까? Ooh
어쩔 줄을 몰라 너를 달래고
매섭게 발로 차도
가끔 내게 미소 짓는 널
어떻게 놓겠어 Ooh
우린 아름답고 참 슬픈 사이야
서로를 빛나게 해
(Tell me now)
마치 달과 강처럼
그리곤 또 껴안아
You got me feeling like a
psycho psycho
우릴 보고 말해 자꾸 자꾸
다시 안 볼 듯 싸우다가도
붙어 다니니 말야
이해가 안 간대
웃기지도 않대
맞아 Psycho psycho
서로 좋아 죽는 바보 바보
너 없인 어지럽고 슬퍼져
기운도 막 없어요
둘이 잘 만났대
Hey now we''ll be ok
Don''t look back
그렇게 우리답게 가보자
난 온몸으로 널 느끼고 있어
Everything will be ok
(You got me feeling like a psycho)
Like a psycho psycho
우릴 보고 말해 자꾸 자꾸
다시 안 볼 듯 싸우다가도
붙어 다니니 말야
둘이 잘 만났대
Hey now we''ll be ok
Hey now we''ll be ok
Hey now we''ll be ok
Hey now we''ll be ok
Hey now we''ll be ok
It''s alright
It''s alright
Hey now we''ll be ok
Hey now we''ll be ok
Hey now we''ll be ok
Hey now we''ll be ok
It''s alright
It''s alright
우린 좀 이상해
Psycho
');
INSERT INTO song_tb (title, song_writer, lyricist, music_video, genre, is_title, music_file, created_at, album_id,
                     lyrics)
VALUES ('천둥벌거숭이 (Feat. Jvcki Wai, 염따)', '지코 (ZICO), Pop Time', '지코 (ZICO)', '/upload/song/Daredevil.mp4', 'Hip Hop', TRUE, '/upload/song/Daredevil.mp3', CURRENT_TIMESTAMP, 7,
        'I just wanna be happier...');
INSERT INTO song_tb (title, song_writer, lyricist, music_video, genre, is_title, music_file, created_at, album_id,
                     lyrics)
VALUES ('Siren', 'Sunmi', 'Sunmi', 'siren_mv.mp4', 'Pop', TRUE, 'siren.mp3', CURRENT_TIMESTAMP, 8,
        'Get away out of my face...');
INSERT INTO song_tb (title, song_writer, lyricist, music_video, genre, is_title, music_file, created_at, album_id,
                     lyrics)
VALUES ('Fear', 'Woozi', 'Woozi', 'fear_mv.mp4', 'Pop', TRUE, 'fear.mp3', CURRENT_TIMESTAMP, 9,
        'Even though I’m anxious...');
INSERT INTO song_tb (title, song_writer, lyricist, music_video, genre, is_title, music_file, created_at, album_id,
                     lyrics)
VALUES ('Make A Wish (Birthday Song)', 'Kenzie', 'Kenzie', 'makeawish_mv.mp4', 'Pop', TRUE, 'makeawish.mp3',
        CURRENT_TIMESTAMP, 10, 'I can do this all day...');


--  테이블 : playlist

insert into playlist_tb(user_id, admin_id, name, created_at)
values (1, null, '최애곡 모음', '2024-06-21');
insert into playlist_tb(user_id, admin_id, name, created_at)
values (2, null, '여름이면 생각나는 노래', '2024-06-21');
insert into playlist_tb(user_id, admin_id, name, created_at)
values (3, null, '핫한 레전드 음원', '2024-06-21');
insert into playlist_tb(user_id, admin_id, name, created_at)
values (4, null, '카페에서 나올 법한 노래 모음', '2024-06-21');


-- 노래 플레이리스트 테이블

insert into playlist_song_tb (playlist_id, song_id)
values (1, 1);
insert into playlist_song_tb (playlist_id, song_id)
values (1, 2);
insert into playlist_song_tb (playlist_id, song_id)
values (1, 3);
insert into playlist_song_tb (playlist_id, song_id)
values (1, 4);
insert into playlist_song_tb (playlist_id, song_id)
values (1, 5);

insert into playlist_song_tb (playlist_id, song_id)
values (4, 6);
insert into playlist_song_tb (playlist_id, song_id)
values (4, 7);
insert into playlist_song_tb (playlist_id, song_id)
values (4, 8);
insert into playlist_song_tb (playlist_id, song_id)
values (4, 9);
insert into playlist_song_tb (playlist_id, song_id)
values (4, 10);

