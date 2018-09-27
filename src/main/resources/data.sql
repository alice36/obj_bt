INSERT INTO voucher(id, numer, is_available) VALUES (1, '22344', 0);
INSERT INTO voucher(id, numer, is_available) VALUES (2, '12344', 1);
INSERT INTO voucher(id, numer, is_available) VALUES (3, '02344', 1);

INSERT INTO USER(username, password, enabled) values ('admin', '{noop}admin', true);
INSERT INTO USER(username, password, enabled) values ('user', '{noop}user', true);
INSERT INTO USER_ROLE(username, role) values ('admin', 'ROLE_ADMIN');
INSERT INTO USER_ROLE(username, role) values ('user', 'ROLE_USER');