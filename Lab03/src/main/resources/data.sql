-- USERS

INSERT INTO user_tbl (id, name) VALUES (111, 'Fuad');

INSERT INTO user_tbl (id, name) VALUES (112, 'Sadia');

INSERT INTO user_tbl (id, name) VALUES (113, 'Jemima');

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