DROP TABLE IF EXISTS forum;

CREATE TABLE "forum" (

  posts int DEFAULT NULL,

  threads int DEFAULT NULL,

  slug varchar DEFAULT NULL,

  title varchar DEFAULT NULL,

  "user" varchar DEFAULT NULL
) ;

