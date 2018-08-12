INSERT INTO community(id, name, address) VALUES (1, 'Zielona Brzoza', 'Warszawa');
INSERT INTO community(id, name, address) VALUES (2, 'Zimowy zakątek', 'Wrocław');

INSERT INTO flat(id, number, area, community_id) VALUES (1, 22, 55.5, 1);
INSERT INTO flat(id, number, area, community_id) VALUES (2, 33, 85.0, 2);
INSERT INTO flat(id, number, area, community_id) VALUES (3, 11, 120.0, 1);
INSERT INTO flat(id, number, area, community_id) VALUES (4, 7, 65.8, 2);

INSERT INTO resident(id, first_name, last_name, gender, flat_id) VALUES (1, 'Zofia', 'Abacka', 'K', 2);
INSERT INTO resident(id, first_name, last_name, gender, flat_id) VALUES (2, 'Jan', 'Wolski', 'M', 1);
INSERT INTO resident(id, first_name, last_name, gender, flat_id) VALUES (3, 'Marta', 'Polska', 'K', 2);
INSERT INTO resident(id, first_name, last_name, gender, flat_id) VALUES (4, 'Krystian', 'Winny', 'M', 3);
INSERT INTO resident(id, first_name, last_name, gender, flat_id) VALUES (5, 'Pawel', 'Robak', 'M', 4);
INSERT INTO resident(id, first_name, last_name, gender, flat_id) VALUES (6, 'Anna', 'Wrok', 'K', 3);