-- -----------------------------------------------------
-- Table user
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS user (
  id BIGINT NOT NULL AUTO_INCREMENT,
  full_name VARCHAR(100) NULL,
  email VARCHAR(100) NULL,
  nickname VARCHAR(50) NULL,
  password VARCHAR(255) NULL,
  created_at TIMESTAMP NULL,
  PRIMARY KEY (id)
);


-- -----------------------------------------------------
-- Table challenge
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS challenge (
  id BIGINT NOT NULL,
  name VARCHAR(100) NULL,
  slug VARCHAR(50) NULL,
  created_at TIMESTAMP NULL,
  PRIMARY KEY (`id`)
);


-- -----------------------------------------------------
-- Table acceleration
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS acceleration (
  id BIGINT NOT NULL,
  name VARCHAR(100) NULL,
  slug VARCHAR(50) NULL,
  challenge_id BIGINT NOT NULL,
  created_at TIMESTAMP NULL,
  PRIMARY KEY (id, challenge_id),
    FOREIGN KEY (challenge_id) REFERENCES challenge (id)
);


-- -----------------------------------------------------
-- Table company
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS company (
  id BIGINT NOT NULL,
  name VARCHAR(100) NULL,
  slug VARCHAR(50) NULL,
  created_at TIMESTAMP NULL,
  PRIMARY KEY (id)
);


-- -----------------------------------------------------
-- Table candidate
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS candidate (
  user_id BIGINT NOT NULL,
  acceleration_id BIGINT NOT NULL,
  company_id BIGINT NOT NULL,
  status INT NULL,
  created_at TIMESTAMP NULL,
  PRIMARY KEY (user_id, acceleration_id, company_id),
    FOREIGN KEY (user_id) REFERENCES user (id),
    FOREIGN KEY (acceleration_id) REFERENCES acceleration (id),
    FOREIGN KEY (company_id) REFERENCES company (id)
);



-- -----------------------------------------------------
-- Table submission
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS submission (
  user_id BIGINT NOT NULL,
  challenge_id BIGINT NOT NULL,
  score FLOAT NULL,
  created_at TIMESTAMP NULL,
  PRIMARY KEY (user_id, challenge_id),
    FOREIGN KEY (challenge_id) REFERENCES challenge (id),
    FOREIGN KEY (user_id) REFERENCES user (id)
);


