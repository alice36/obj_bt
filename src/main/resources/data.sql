INSERT INTO voucher(id, numer, is_available, version) VALUES (1, '22344', 0, 1);
INSERT INTO voucher(id, numer, is_available, version) VALUES (2, '12344', 1, 1);
INSERT INTO voucher(id, numer, is_available, version) VALUES (3, '02344', 1, 1);

INSERT INTO USER(username, password, enabled) values ('admin', '{noop}admin', true);
INSERT INTO USER(username, password, enabled) values ('user', '{noop}user', true);
INSERT INTO USER_ROLE(username, role) values ('admin', 'ROLE_ADMIN');
INSERT INTO USER_ROLE(username, role) values ('user', 'ROLE_USER');

INSERT INTO login(id, login_name, has_permission, has_permission_load, has_permission_export) values (1, 'Alice', true, true, false);
INSERT INTO login(id, login_name, has_permission, has_permission_load, has_permission_export) values (2, 'anicieja', true, true, true);
INSERT INTO login(id, login_name, has_permission, has_permission_load, has_permission_export) values (3, 'ssiewiertoka', true, true, true);
INSERT INTO ticket(id, voucher_id, person, login, from_place, to_place, travel_date, client_name, booking_date ) VALUES (1, 1, 'Jadzia', 'wwolna', 'Wroclaw', 'Katowice', '2018-09-22', 'AMS', '2018-09-29')
