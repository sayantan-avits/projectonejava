CREATE TABLE bk_time_log (
  ID varchar(45) NOT NULL,
  CREATED_AT timestamp without time zone DEFAULT NULL,
  REQST_TYPE varchar(45) DEFAULT NULL,
  PLANTID varchar(45) DEFAULT NULL,
  LINEID varchar(45) DEFAULT NULL,
  PRODID varchar(45) DEFAULT NULL,
  BK_TIME varchar(45) DEFAULT NULL,
  T1 varchar(45) DEFAULT NULL,
  T2 varchar(45) DEFAULT NULL,
  T3 varchar(45) DEFAULT NULL,
  T4 varchar(45) DEFAULT NULL,
  T5 varchar(45) DEFAULT NULL,
  T6 varchar(45) DEFAULT NULL,
  PRIMARY KEY (ID)
  );