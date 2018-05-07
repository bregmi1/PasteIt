INSERT INTO users (name, email, password, enabled) VALUES
('Harry', 'harry@example.com', '$2a$10$D4OLKI6yy68crm.3imC9X.P2xqKHs5TloWUcr6z5XdOqnTrAK84ri', TRUE ),
('John Doe', 'john@doe.com', '$2a$10$D4OLKI6yy68crm.3imC9X.P2xqKHs5TloWUcr6z5XdOqnTrAK84ri', TRUE ),
('John Doe', 'johndoe', '$2a$10$D4OLKI6yy68crm.3imC9X.P2xqKHs5TloWUcr6z5XdOqnTrAK84ri', TRUE );

INSERT INTO pastes (title, body, user_id) VALUES
('Harry: First Paste', 'This is the first paste of Harry', 1),
('Harry: Second Paste', 'This is the second paste of Harry', 1),
('John: First Paste', 'This is the first paste of John Doe', 2);