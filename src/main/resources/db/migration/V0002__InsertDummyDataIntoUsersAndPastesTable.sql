INSERT INTO users (name, email, password) VALUES
('Harry', 'harry@example.com', 'password123A'),
('John Doe', 'john@doe.com', 'dummyPassword');

INSERT INTO pastes (body, user_id) VALUES
('This is the first paste of Harry', 1),
('This is the second paste of Harry', 1),
('This is the first paste of John Doe', 2);