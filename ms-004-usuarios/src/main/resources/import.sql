INSERT INTO `usuarios`(username, password, enabled, nombre, apellido, email) VALUES ('admin', '$2a$10$VekapGuFOFwbVBh0Svtna.sGxPohpIVoFrd4Ys6BLnZeoscYgmGJ6', 1, 'DJ', 'Zubaray', 'djzubaray@gmail.com')
INSERT INTO `usuarios` (username, password, enabled, nombre, apellido, email) VALUES ('dario', '$2a$10$g5UDq.Kh6JFABHGNHXq/0u8UWHV7AGCnre0N3nB7v4GJLygXZ4/fC', 1, 'Dario', 'Zubaray', 'dzubaray@gmail.com')

INSERT INTO `roles` (nombre) VALUES ('ROLE_USER')
INSERT INTO `roles` (nombre) VALUES ('ROLE_ADMIN')

INSERT INTO `usuarios_roles`(usuario_id, role_id) VALUES (1, 1)
INSERT INTO `usuarios_roles` (usuario_id, role_id) VALUES (2, 2)
INSERT INTO `usuarios_roles` (usuario_id, role_id) VALUES (2, 1)