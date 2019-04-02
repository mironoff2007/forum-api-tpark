DROP TABLE IF EXISTS forum;

CREATE TABLE "forum" (

  posts int DEFAULT NULL,

  slugs varchar DEFAULT NULL,

  title varchar DEFAULT NULL,

  "user" varchar DEFAULT NULL
) ;

INSERT INTO "forum" VALUES
	(1,'slugs1','title1','user1'),
    (2,'slugs2','title2','user2');