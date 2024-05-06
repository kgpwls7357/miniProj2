CREATE TABLE article(
                        id INT(10) UNSIGNED NOT NULL PRIMARY KEY AUTO_INCREMENT,
                        regDate DATETIME NOT NULL,
                        updateDate DATETIME NOT NULL,
                        title CHAR(100) NOT NULL,
                        `body` TEXT NOT NULL
);


INSERT into article
SET regDate = NOW(),
updateDate = NOW(),
title = '제목1',
`body` = '내용1';

INSERT into article
SET regDate = NOW(),
updateDate = NOW(),
title = '제목2',
`body` = '내용2';

INSERT into article
SET regDate = NOW(),
updateDate = NOW(),
title = '제목3',
`body` = '내용3';

#회원 테이블 생
CREATE TABLE `member`(
                         id INT(10) UNSIGNED NOT NULL PRIMARY KEY AUTO_INCREMENT,
                         regDate DATETIME NOT NULL,
                         updateDate DATETIME NOT NULL,
                         loginId CHAR(20) NOT NULL,
                         loginPW CHAR(60) NOT NULL,
                         `authLevel` SMALLINT(2) UNSIGNED DEFAULT 3 COMMENT '권한레벨 (3=일반, 7=관리자)',
                         `name` CHAR(20) NOT NULL,
                         `nickname` CHAR(20) NOT NULL,
                         cellphoneNo CHAR(20) NOT NULL,
                         email CHAR(50) NOT NULL,
                         delStatus TINYINT(1) UNSIGNED NOT NULL DEFAULT 0 COMMENT '탈퇴여부(0=탈퇴, 1=탈퇴)',
                         delDate DATETIME COMMENT '탈퇴날짜'
);

INSERT INTO `member` (regDate, updateDate, loginId, loginPW, authLevel, `name`, nickname, cellphoneNo, email)
VALUES (NOW(), NOW(), 'admin', 'admin', 7, '관리자', '관리자', '01011111111', 'kosa1@gmail.com');

INSERT INTO `member`
SET regDate = NOW(),
    updateDate = NOW(),
    loginId = 'user1',
    loginPW = 'user1',
    `name` = 'user1',
    `nickname` = 'user1',
    cellphoneNo = '01022222222',
    email = 'user1@gmail.com';

INSERT INTO `member`
SET regDate = NOW(),
    updateDate = NOW(),
    loginId = 'user2',
    loginPW = 'user2',
    `name` = 'user2',
    `nickname` = 'user2',
    cellphoneNo = '01033333333',
    email = 'user2@gmail.com';
