PRAGMA foreign_keys=OFF;
BEGIN TRANSACTION;
CREATE TABLE IF NOT EXISTS "details" (
	"username"	TEXT,
	"pwd"	TEXT,
	"usertype"	TEXT DEFAULT 'user'
);
INSERT INTO details VALUES('MANVI','Lock','admin');
INSERT INTO details VALUES('ARADHANA','Key','admin');
INSERT INTO details VALUES('GARVIT','gJaiswal','user');
INSERT INTO details VALUES('SARTHAK','Abcdefgh','user');
INSERT INTO details VALUES('SAKSHAM','Saksham#123','user');
COMMIT;
