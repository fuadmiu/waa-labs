-- USERS

INSERT INTO user_tbl (id, email, firstname, lastname, password)
VALUES (111, 'admin@miu.edu', 'Admin', 'Admin', '$2a$12$IKEQb00u5QpZMx4v5zMweu.3wrq0pS7XLCHO4yHZ.BW/yvWu1feo2'); --123
INSERT INTO user_tbl (id, email, firstname, lastname, password)
VALUES (112, 'testuser01@miu.edu', 'Test', 'User', '$2a$12$IKEQb00u5QpZMx4v5zMweu.3wrq0pS7XLCHO4yHZ.BW/yvWu1feo2'); --123
INSERT INTO user_tbl (id, email, firstname, lastname, password)
VALUES (113, 'mohammad.fuad@miu.edu', 'Mohammad', 'Fuad', '$2a$12$IKEQb00u5QpZMx4v5zMweu.3wrq0pS7XLCHO4yHZ.BW/yvWu1feo2'); --123

INSERT INTO role (id, role)
VALUES (1, 'ADMIN');
INSERT INTO role (id, role)
VALUES (2, 'CLIENT');


INSERT INTO user_tbl_roles (user_id, roles_id)
VALUES (111, 1);
INSERT INTO user_tbl_roles (user_id, roles_id)
VALUES (112, 2);
INSERT INTO user_tbl_roles (user_id, roles_id)
VALUES (113, 2);


-- POSTS
INSERT INTO post (id, title, content, author, user_id)
VALUES (211, 'Spring', 'Spring boot blog', 'Fuad', 111);

INSERT INTO post (id, title, content, author, user_id)
VALUES (212, 'React', 'React blog', 'Fuad', 111);

INSERT INTO post (id, title, content, author, user_id)
VALUES (213, 'Civil Engg', 'Blog about skyscrapper designing', 'J', 113);

INSERT INTO post (id, title, content, author, user_id)
VALUES (214, 'BBA', 'Blog about Business studies', 'S', 112);

-- Comments
INSERT INTO comment (id, name, post_id) VALUES (311, 'Spring is great', 211);

INSERT INTO comment (id, name, post_id) VALUES (312, 'Spring Boot is great too', 211);

INSERT INTO comment (id, name, post_id) VALUES (313, 'React is Frontend tech', 212);