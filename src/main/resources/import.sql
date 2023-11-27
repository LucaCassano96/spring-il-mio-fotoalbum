INSERT INTO photos (title, description, photo_url, visible, created_at) VALUES ('gatto','gatto che gioca', 'https://www.marthastewart.com/thmb/olgJmSzOD4Jgfa07bLZV741U2FU=/1500x0/filters:no_upscale():max_bytes(150000):strip_icc()/cat-playing-getty-845697720-3ca118e58ba0443995c897c4de64ae5e.jpg',true, '2023-11-09T11:35:00');
INSERT INTO photos (title, description, photo_url, visible, created_at) VALUES ('cane','cane che gioca', 'https://www.fourpaws.com/-/media/Project/OneWeb/FourPaws/Images/articles/family-matters/dog-playtime/dog-playtime-927x388.jpg',true, '2023-11-09T11:35:00');
INSERT INTO photos (title, description, photo_url, visible, created_at) VALUES ('scoiattolo','scoiattolo che si arrampica', 'https://upload.wikimedia.org/wikipedia/commons/1/15/EasternGraySquirrel_GAm.jpg',true, '2023-11-09T11:35:00');

INSERT INTO categories (name) VALUES ('ritratto');
INSERT INTO categories (name) VALUES ('paesaggio');
INSERT INTO categories (name) VALUES ('animali');
INSERT INTO categories (name) VALUES ('architettura');
INSERT INTO categories (name) VALUES ('street-photograpy');
INSERT INTO categories (name) VALUES ('pubblicità');

INSERT INTO roles (id, name) VALUES(1, 'ADMIN');
INSERT INTO roles (id, name) VALUES(2, 'USER');

INSERT INTO users (email, first_name, last_name, registered_at, password) VALUES('luca@email.com', 'Luca', 'Cassano', '2023-11-26 10:35', '{noop}luca');
INSERT INTO users (email, first_name, last_name, registered_at, password) VALUES('alessio@email.com', 'Alessio', 'Cassano', '2023-11-26 10:35','{noop}alessio');

INSERT INTO users_roles (user_id, roles_id) VALUES(1, 1);
INSERT INTO users_roles (user_id, roles_id) VALUES(1, 2);
INSERT INTO users_roles (user_id, roles_id) VALUES(2, 2);