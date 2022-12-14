CREATE TABLE MenuItem(
	mid			BIGINT			PRIMARY KEY AUTO_INCREMENT,
	cateFk		BIGINT			NOT NULL,
	menuName	VARCHAR(50)		NOT NULL,
	menuSize	VARCHAR(50)		NOT NULL,
	menuPrice	DOUBLE			NOT NULL,
	imgUrl		VARCHAR(100)	NOT NULL,
	regDate		TIMESTAMP		NOT NULL	DEFAULT CURRENT_TIMESTAMP,
	
	CONSTRAINT MenuItem_cateFk_FK
		FOREIGN KEY(cateFk) REFERENCES Category(cid) ON DELETE CASCADE
)AUTO_INCREMENT = 201;

CREATE TABLE Category(
	cid			BIGINT			PRIMARY KEY AUTO_INCREMENT,
	cateType	VARCHAR(20)		NOT NULL,
	cateName	VARCHAR(20)		NOT NULL,
	regDate		TIMESTAMP		NOT NULL	DEFAULT CURRENT_TIMESTAMP
)AUTO_INCREMENT = 101;

CREATE TABLE Cart(
	caid		BIGINT			PRIMARY KEY AUTO_INCREMENT, 
	orderid		BIGINT			NOT NULL,  /** 주문번호?결제하기할때 +1 **/
	menuName	VARCHAR(50)		NOT NULL,
	number		BIGINT			NOT NULL,
	menuPrice	DOUBLE			NOT NULL,
	regDate		TIMESTAMP		NOT NULL	DEFAULT CURRENT_TIMESTAMP
	
)AUTO_INCREMENT = 301;

/**카트 커맨드에서 결제하기가 눌러졌을때 스테틱변수인orderid 값을 1증가**/


SELECT * FROM MenuItem;
SELECT * FROM Category;
SELECT * FROM Cart;

DELETE FROM MenuItem WHERE cateFk = 101;

DROP TABLE MenuItem;
DROP TABLE Category;
DROP TABLE Cart;