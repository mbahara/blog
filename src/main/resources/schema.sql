--
-- Create DB schema
--

CREATE TABLE "USER" (
                        id INT PRIMARY KEY AUTO_INCREMENT,
                        login VARCHAR(100) NOT NULL,
                        password VARCHAR(100) NOT NULL,
                        name VARCHAR(100) NOT NULL,
                        UNIQUE (login)
);

CREATE TABLE ARTICLE (
    id INT PRIMARY KEY AUTO_INCREMENT,
    title VARCHAR(100) NOT NULL,
    lead VARCHAR(1000) NOT NULL,
    text VARCHAR(10000) NOT NULL
);

CREATE TABLE COMMENT (
    id INT PRIMARY KEY AUTO_INCREMENT,
    text VARCHAR(100) NOT NULL,
    article_id INT NOT NULL,
    user_id INT NOT NULL
);