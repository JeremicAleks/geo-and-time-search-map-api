INSERT INTO `role` VALUES (1,'ADMIN'),(2,'USER');

INSERT INTO `user` (email, first_name, last_name, password, username, role_id) VALUES ('jeremic@mail.com','Aleksandar','Jeremic','{bcrypt}$2a$10$/dGxtSvgJPMdOPEuewh8ZOpj2X8DI2/QRgaTrsdavf1YueHrdwxkW','acika',1);
