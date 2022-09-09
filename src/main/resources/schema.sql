
CREATE TABLE UsersTable(
	username VARCHAR(50) NOT NULL PRIMARY KEY,
	PASSWORD VARCHAR(200) NOT NULL,
	email VARCHAR(100) NOT NULL,
	enabled BOOLEAN NOT NULL
);

CREATE TABLE authorities (
	username VARCHAR(50) NOT NULL,
	authority VARCHAR(50) NOT NULL,
	CONSTRAINT fk_authorities_users FOREIGN KEY(username) REFERENCES UsersTable(username)
);

CREATE UNIQUE INDEX ix_auth_username ON authorities (username,authority);
