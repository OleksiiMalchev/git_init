CREATE TABLE user (
  id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  user_name VARCHAR(128) DEFAULT NULL,
  password VARCHAR(128) DEFAULT NULL,
  email VARCHAR(128) DEFAULT NULL,
  role VARCHAR(128) DEFAULT 'ROLE_USER',
  UNIQUE (user_name),
  UNIQUE (email)
);

CREATE TABLE user_roles (
  user_id BIGINT NOT NULL,
  role VARCHAR(255),
  PRIMARY KEY (user_id, role),
  CONSTRAINT FK_user_roles_user_id FOREIGN KEY (user_id) REFERENCES user(id)
);
