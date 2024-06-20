-- 테이블: user
-- 칼럼: 이메일, 비밀번호, 전화번호, 프로바이더, 생성날짜, 생년월일

INSERT INTO user_tb (email, password, phone, provider, created_at, birth) VALUES
                                                                              ('ssar@nate.com', '1234', '010-1234-5678', 'Email', '2023-02-15', '1990-01-15'),
                                                                              ('john@nate.com', '1234', '010-2345-6789', 'Email', '2023-04-25', '1985-03-22'),
                                                                              ('jane@naver.com', '1234', '010-3456-7890', 'Naver', '2023-06-20', '1992-07-30'),
                                                                              ('sam@gmail.com', '1234', '010-4567-8901', 'Kakao', '2023-08-05', '1988-12-05'),
                                                                              ('lisa@naver.com', '1234', '010-5678-9012', 'Naver', '2023-10-12', '1995-05-25'),
                                                                              ('tom@nate.com', '1234', '010-6789-0123', 'Email', '2023-11-20', '1991-11-10'),
                                                                              ('emily@naver.com', '1234', '010-7890-1234', 'Kakao', '2023-12-15', '1987-04-05'),
                                                                              ('chris@nate.com', '1234', '010-8901-2345', 'Email', '2024-01-05', '1993-02-17'),
                                                                              ('julia@naver.com', '1234', '010-9012-3456', 'Naver', '2024-02-12', '1994-09-09'),
                                                                              ('mark@gmail.com', '1234', '010-0123-4567', 'Kakao', '2024-03-18', '1986-06-30');

-- 테이블: artist
-- 칼럼: 가수이름, 아티스트타입, 아티스트사진, 생성날짜

INSERT INTO artist_tb (name, artist_type, artist_img, created_at) VALUES
                                                                      ('노을', 'Solo', 'upload/노을.jpg',now()),
                                                                      ('aespa', 'Group', 'upload/에스파.jpg', '2023-02-15'),
                                                                      ('NewJeans', 'Group', 'upload/뉴진스.jpg', '2023-03-20'),
                                                                      ('IVE (아이브)', 'Group', 'upload/아이브.jpg', '2023-05-05'),
                                                                      ('TWS (투어스)', 'Group', 'upload/투어스.jpg', '2023-06-10'),
                                                                      ('QWER', 'Group', 'upload/qwer.jpg', '2023-07-15'),
                                                                      ('임영웅', 'Solo', 'upload/임영웅.jpg', '2023-08-20'),
                                                                      ('지코 (ZICO)', 'Solo', 'upload/지코.jpg', '2023-09-25'),
                                                                      ('(여자)아이들', 'Group', 'upload/여자아이들.jpg', '2023-10-30'),
                                                                      ('아일릿(ILLIT)', 'Group', 'upload/아일릿.jpg', '2023-11-15'),
                                                                      ('이클립스 (ECLIPSE)', 'Solo', 'upload/이클립스.jpg', '2023-12-01');


--  샘플용 더미

-- 테이블: album

INSERT INTO album_tb (title, distributor, agency, nationality, category, album_img, artist_id, created_at, intro) VALUES
                                                                                                                      ('전부 너였다', 'Dreamus', '제이와이피엔터테인먼트', '국내', '발라드', 'upload/전부너였다.jpg', 1, NOW(), '- 섬세한 사랑의 감정을 노래한 "전부 너였다" 붙잡고도, 인연, 아파도 아파도, 청혼 등 2장의 앨범을 통해서 색깔있는 가창력을 선보였던 그룹 ''노을''이 기나긴 작업 기간을 보내고 섬세한 사랑의 감정을 담은 세번째 앨범 "전부 너였다"로 돌아왔다. 데뷔앨범인 "붙잡고도"와 2집 앨범 "아파도 아파도"를 통해 뛰어난 가창력과 멤버 각각의 독특한 보이스 칼라로 최고의 R&B그룹으로 평가 받아왔던 노을이 또 한번의 음악적 변신을 시도한다. 기나긴 작업기간 동안 4명의 멤버가 가장 신경쓴 부분은 각각의 보이스 컬러의 조화와 모든 이들이 공감할 수 있는 편안한 모습으로 팬들에게 다가가는 것이었다. 이번 앨범에서는 그 동안 노을이 보여주었던 슬픔의 극대화가 아닌 슬픈 감정의 절제를 노래하는 노을을 만나볼 수 있을 것이다. 타이틀 곡인 ''전부 너였다''는 제목이 주는 이미지 그대로 누구나 공감할 수 있는 가사가 돋보이는 곡으로 노을의 ''청혼''과 god의 ''보통날''을 작곡했던 권태은의 서정적인 멜로디에 양재선의 감성적인 노랫말과 노을의 Voice가 잘 조화된 곡으로 이별의 슬픈 감정을 절제하면서 덤덤하게 노래하여 이번 앨범의 컨셉을 가장 잘 표현하였다. - "노을스럽다"를 보여주는 곡 "나무" 사랑의 감정을 한 곳에 뿌리박은 나무에 비유한 "나무"는 노을 Voice와 웅장한 오케스트레이션의 조화가 돋보이며 최고의 프로듀서 방시혁의 노랫말이 귀에 쏙쏙 들어오며 가장 ''노을스럽다''라는 말이 어울리는 곡이다. 또한 이외에도 일본의 여가수 아무로 나미에의 최근작인 히트 발라드 "All for you"를 노을 만의 감성으로 새롭게 재해석한 "All for you"와 드라마 궁의 OST "perhaps love"를 작곡한 박근철의 "A better tomorrow", MC몽의 ''180도'', M(이민우)의 "Last first kiss"등을 작곡한 장준호의 멜로디와 "10 Minetes"의 작사가 Maybee의 가사의 조화가 돋보이는 댄스넘버 "남자라서", 조성모, BMK 및 여러 가수들의 앨범을 프로듀서한 mAd sOuL cHiLd가 선사하는 트랜디한 사운드와 감성의 조화가 돋보이는 ''A nice day'', 천상의 목소리 이소은과 노을의 리더 이상곤이 듀엣으로 노래한 러브 발라드 "여행" 등을 통해 또 한번 새로운 노을만의 색깔을 선보일 예정이다. 이번 노을의 세번째 앨범 ''전부 너였다''는 노을의 음악세계에 새로운 변화를 제시하며 동시에 가장 ''노을스럽다''라는 말이 어울리는 듣는이로 하여금 편안한 감동을 선사할 수 있는 최고의 앨범이 될 것이다.'),
                                                                                                                      ('Armageddon - The 1st Album', '카카오엔터테인먼트', 'SM ENTERTAINMENT', '국내', 'Dance', 'upload/슈퍼노바.jpg', 2, '2024-05-27', 'aespa, 첫 정규 앨범 ‘Armageddon’ 발매! 힙한 무드 ‘Supernova’→힙합 댄스곡 ‘Armageddon’으로 강렬한 질주! 세계관 시즌 2 서사 담은 역대급 스케일 음악+비주얼! ‘글로벌 히트메이커’ aespa가 첫 정규 앨범 ‘Armageddon’을 발매했다. aespa의 첫 정규 앨범 ‘Armageddon’은 미니멀한 트랙사운드와 캐치한 탑라인이 매력적인 선공개곡 ‘Supernova’와 트렌디한 트랙과 거칠고 절제된 음색이 돋보이는 타이틀 곡 ‘Armageddon’을 포함하여 에너제틱한 힙합부터 밝고 경쾌한 댄스곡, 리드미컬한 모던 팝, 발라드까지 다채로운 장르로 구성되어 aespa만의 독보적인 음악 색깔을 만끽하기에 충분하다. 특히 이번 앨범은 리얼 월드와 디지털 세계를 넘어 다중 우주로 확장되는 aespa 세계관 시즌 2의 서사를 담아, aespa가 평행 세계에 존재하는 각기 다른 ‘나’를 만나 무한한 가능성을 마주하고 완전한 ‘나’로 거듭나는 과정들을 파워풀하고 유니크한 음악과 비주얼을 통해 보여줄 예정이어서 기대가 모인다.'),
                                                                                                                      ('How Sweet', 'YG PLUS', 'ADOR', '국내', 'Dance', 'upload/sweet.jpg', 3, '2024-05-24', '뉴진스가 2024년 또다시 새로운 모습으로 돌아왔다. 타이틀 곡 ‘How Sweet’은 신선한 느낌을 선사하는 장르적 접근이 돋보이는 새롭고 독특한 매력의 Dance Pop 곡으로 Sparkle한 일렉트로닉 사운드가 중독성있는 곡이다. 또 함께 수록된 ‘Bubble Gum’은 트랙의 진행에 따른 다양한 무드 체인지를 통해 다채로운 매력을 느낄 수 있는 곡이다. 과장되지 않은 자연스러움으로 오히려 신선한 느낌을 선사하는 뉴진스 멤버들의 보컬과 개성있고 매력 넘치는 트랙들로 구성된 싱글 앨범 ‘How Sweet’은 한 번만 들어도 모든 이의 귀를 사로잡을 만큼 뉴진스의 매력을 잘 담아내고 있다. 그간 뉴진스를 기다려 온 전세계 팬들에게 화답이 되는 앨범이 되길 바란다.'),
                                                                                                                      ('IVE SWITCH', '카카오엔터테인먼트', '스타쉽 엔터테인먼트', '국내', 'Dance', 'upload/해야.jpg', 4, '2024-04-29', '뚜렷한 컬러로 K팝 최고의 순간을 물들인 아이브가 극적인 반전을 선사한다. 아이브의 정체성은 주체적인 자신감과 당당함. 여기에 색다른 매력을 더해 또 다른 변주를 시도했다. 최적의 타이밍에서 맞이한 확신의 변화다. 언제나 자신감 넘치는 애티튜드로 자아 성취를 보여준 아이브가 세련되면서도 감각적인 시도로 새로운 시작을 알린다.'),
                                                                                                                      ('TWS 1st Mini Album ‘Sparkling Blue’', 'YG PLUS', '플레디스엔터테인먼트', '국내', 'Dance', 'upload/첫만남.jpg', 5, '2024-01-22', '‘2024년 최고 기대주’ TWS, 데뷔 앨범 ‘Sparkling Blue’ 공개 "언제나 TWS와 함께"…반짝이는 음률의 향연 ‘Sparkling Blue’ 설렘 가득한 데뷔 타이틀곡 ‘첫 만남은 계획대로 되지 않아’'),
                                                                                                                      ('1st Mini Album ''MANITO''', '카카오엔터테인먼트', '타마고 프로덕션', '국내', 'Rock/Metal', 'upload/고민중독.jpg', 6, '2023-08-15', '1st Mini Album ''MANITO'' ‘불협화음에서 만들어낸 하모니’라는 그들만의 독특한 스토리를 써 내려갔던 밴드 QWER이 미니 앨범 ''MANITO''로 돌아왔다. 첫 싱글에서는 각기 다른 출신의 배경을 가진 멤버 쵸단, 마젠타, 히나, 시연 넷의 결성까지의 과정과 팀의 아이덴티티를 이야기했다면, ''MANITO''에서는 운명과도 같은 만남을 경험한 QWER의 속마음을 한 편의 드라마로 풀어나갈 예정이다.'),
                                                                                                                      ('신사와 아가씨 OST Part.2', 'NHN벅스', '모스트콘텐츠', '국내', 'Ballad', 'upload/도망가.jpg', 7, '2021-10-11', '''임영웅 - 사랑은 늘 도망가'' KBS 2TV 주말드라마 ''신사와 아가씨''는 우연인 듯 인연인 듯 계속된 만남을 가지게 된 박단단(이세희 분)과 이영국(지현우 분)이 한집살이를 시작하며 흥미진진한 서사와 디테일한 연출로 시청자들을 사로잡고 있다.'),
                                                                                                                      ('SPOT!', '	YG PLUS', 'KOZ 엔터테인먼트', '국내', 'HipHop', 'upload/스팟.jpg', 8, '2024-04-26', '지코의 첫 번째 정규앨범 "SPOT!"는 독창적인 음악성과 심오한 가사를 담은 작품입니다. 타이틀 곡 "Thinking"은 지코 특유의 스타일과 제니의 감각적인 보컬이 어우러진 곡입니다.'),
                                                                                                                      ('2', '카카오엔터테인먼트', '큐브 엔터테인먼트', '국내', 'K-POP', 'upload/질색.jpg', 9, '2024-01-29', '''Super Lady''의 아름다움과 그 힘에 대한 찬가 콘셉트 장인 (여자)아이들의 화려한 귀환'),
                                                                                                                      ('SUPER REAL ME', '지니뮤직, Stone Music Entertainment', '빌리프랩', '국내', 'Dance', 'upload/마그넷.jpg', 10, '2024-03-25', '‘하이브 막내딸’ 아일릿, 3월 25일 첫 번째 미니 앨범 ‘SUPER REAL ME’로 데뷔! 엉뚱•발랄•자유로움 아일릿…무엇이든 될 수 있는 무한 가능성의 소녀들 ‘눈 앞에 최선을, 나머지는 되는 대로’, 진짜 ‘나’의 이야기로 전속력으로 달려가는 아일릿 ‘리얼 10대 감성’ 아일릿 시작부터 다르다! 방시혁 프로듀서x10대 프로듀서 만남'),
                                                                                                                      ('선재 업고 튀어 OST Part 1', 'Stone Music Entertainment', 'BON FACTORY, Stone Music Entertainment', '국내', 'OST', 'upload/소나기.jpg', 11, '2024-01-10', '드라마 속 밴드 ''이클립스''가 선보이는 첫 번째 OST! tvN 월화드라마 ‘선재 업고 튀어’가 드라마의 몰입도를 높일 OST들을 선공개한다');

-- 테이블: song

INSERT INTO song_tb (title, song_writer, lyricist, music_video, genre, is_title, music_file, created_at, album_id, lyrics) VALUES
                                                                                                                               ('전부 너였다','런치송 프로젝트','양재선','upload/전부너였다.mp4','Ballad',true,'upload/전부너였다.mp3',now(),1,'가슴을 떼어 놓은
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

                                                                                                                               ('Supernova', 'Kenzie, Paris Alexa, Dwayne “Dem Jointz” Abernathy Jr.', 'Kenzie', 'upload/슈퍼노바.mp4', 'Dance', true, 'upload/슈퍼노바.mp3', 2024-05-13, 2, 'I’m like some kind of Supernova
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
Supernova' ),

                                                                                                                               ('Armageddon', 'EJAE, SUMIN (수민), Waker (153/Joombas), 노 아이덴티티 (No Identity)', '방혜현 (Jam Factory)', 'upload/Armageddon.mp4', 'Dance', true, 'upload/Armageddon.mp3', 2024-05-27, 2, 'Armageddon
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

                                                                                                                               ('Set The Tone', 'Ludwig Lindell, Daniel Caesar, Ylva Dimberg', '조윤경', null, 'Dance', false, 'upload/tone.mp3', 2024-05-27, 2, 'We Set The Tone
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
                                                                                                                               ('Mine', 'Mike Daley, Mitchell Owens, Nicole “Kole” Cohen, Adrian McKinnon', '이은화 (153/Joombas)', null, 'Dance', false, 'upload/Mine.mp3',2024-05-27, 2, '예고 없이
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

                                                                                                                               ('Licorice', 'Daniel Davidsen, Peter Wallevik, Moa “Cazzi Opeia” Carlebecker, Karen Poole', '강은정', 'upload/Licorice.mp4', 'Dance', false, 'upload/Licorice.mp3', 2024-05-27, 2, '넌 정말
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

                                                                                                                               ('BAHAMA', 'Kenzie, Jonatan Gusmark, Ludvig Evers, Moa “Cazzi Opeia” Carlebecker, Ellen Berg', 'Kenzie', null, 'Dance', false, 'upload/BAHAMA.mp3', 2024-05-27, 2, 'Bahama,
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
Bahama')

    ('Long Chat (#♥)', 'Stian Nyhammer Olsen, Live Rabo Lund-Roland, Nora Grefstad, Julia Finnseter', '문설리', 'upload/Long Chat.mp4', 'Dance', false, 'upload/Long Chat.mp3', 2024-05-27, 2, 'Ha I’ll be the
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

    ('Prologue', 'Gil Lewis, Micky Blue', 'Mola (PNP), 미아 (153/Joombas)', null, 'R&B', false, 'upload/Prologue.mp3', 2024-05-27, 2, 'Woo Woo Woo
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

    ('Live My Life', 'Sophia Brenan, Nick Hahn, Edvard Forre Erfjord', 'Leslie', 'upload/Live My Life.mp4', 'Rock/Metal', false, 'upload/Live My Life.mp3', 2024-05-27, 2, 'Bye 따분한
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

Life')

    ('목소리 (Melody)', '밍지션 (minGtion), Sophia Pae', '이오늘', null, 'Ballad', false, 'upload/목소리 (Melody).mp3', 2024-05-27, 2, 'Every night
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
feel like I''m lucky
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

    ('How Sweet', '250, Sarah Aarons, Elvira Anderfjard, Oscar Scheller, Stella Bennett, Tove Burman', 'Gigi, Sarah Aarons, Elvira Anderfjard, Oscar Scheller, Stella Bennett, Tove Burman, 다니엘(DANIELLE)', 'upload/How Sweet.mp4', 'Dance', true, 'upload/How Sweet.mp3', 2024-05-24, 3, 'All I know is now
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

    ('해야 (HEYA)', 'Ryan S. Jhun, Dwayne Abernathy Jr., Ido Nadjar, Kloe Latimer, Jack Brady, Jordan Roman', '이스란, 엑시 (우주소녀), 솔희 (SOHLHEE)', 'upload/해야 (HEYA).mp4', 'Dance', true, 'upload/해야 (HEYA).mp3', 2024-04-29, 4, 'Let’s get it
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

    ('첫 만남은 계획대로 되지 않아', 'WASURENAI, 전진, Ohway!, Nmore, Heon Seo (헌서), BuildingOwner, Glenn, T-SK (Chizaki Taisuke), YouthK', 'WASURENAI, 브라더수, 전진, BuildingOwner, Glenn', 'upload/첫 만남은 계획대로 되지 않아.mp4', 'Dance', true, 'upload/첫 만남은 계획대로 되지 않아.mp3', 2024-01-22, 5, 'Ay ay ay ay ay

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

    ('고민중독', '이동혁, 홍훈기 (PRISMFILTER), Elum, Gesture (PRISMFILTER), 한아영', '이동혁, Gesture (PRISMFILTER), 김혜정, Elum, 마젠타', 'upload/고민중독.mp4', 'Rock/Metal', true, 'upload/고민중독.mp3', 2024-04-01, 6, 'One! Two! Q! W! E! R!

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

    ('사랑은 늘 도망가', '홍진영', '강태규', 'upload/사랑은 늘 도망가.mp4', 'Ballad', true, 'upload/사랑은 늘 도망가.mp3', 2021-10-11, 7, '눈물이 난다 이 길을 걸으면
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

    ('SPOT! (feat. JENNIE)', '지코 (ZICO), 은희영, 노 아이덴티티 (No Identity)', '지코 (ZICO)', 'upload/SPOT! (feat. JENNIE).mp4', 'HipHop', true, 'upload/SPOT! (feat. JENNIE).mp3', 2024-04-26, 8, 'Everything ok my man
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

    ('나는 아픈 건 딱 질색이니까', '소연 ((여자)아이들), Pop Time, Daily, Likey', '소연 ((여자)아이들)', null, 'Dance', false, 'upload/나는 아픈 건 딱 질색이니까.mp3', 2024-01-29, 9, '오늘도 아침엔 입에 빵을 물고
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

    ('Magnetic', 'Slow Rabbit, "Hitman" Bang, martin, salem ilese, danke, VINCENZO, 이이진, piri, Lauren Amber Aquilina, Marcus Andersson, 김키위, 오현선 (lalala studio), JAMES', 'Slow Rabbit, "Hitman" Bang, martin, salem ilese, danke, VINCENZO, 이이진, piri, Lauren Amber Aquilina, Marcus Andersson, 김키위, 오현선 (lalala studio), JAMES', 'upload/Magnetic.mp4', 'Dance', true, 'upload/Magnetic.mp3', 2024-03-25, 10, 'Baby
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

    ('소나기', '한성호, 박수석, Moon Kim (Room 01)', '한성호, 수윤 (Sooyoon)', null, 'Ballad', true, 'upload/소나기.mp3', 2024-04-08, 11, '' ||
     '그치지 않기를 바랬죠
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