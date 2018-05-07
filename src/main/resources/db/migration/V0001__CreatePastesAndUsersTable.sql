CREATE TABLE users (
  user_id BIGSERIAL PRIMARY KEY,
  name TEXT NOT NULL,
  email TEXT NOT NULL UNIQUE,
  password TEXT NOT NULL,
  enabled BOOLEAN,
  created_on TIMESTAMP WITH TIME ZONE NOT NULL DEFAULT NOW(),
  updated_on TIMESTAMP WITH TIME ZONE NOT NULL DEFAULT NOW()
);

ALTER TABLE users ADD CONSTRAINT chk_updated_on_valid CHECK (created_on <= updated_on);

CREATE TABLE pastes (
  paste_id BIGSERIAL PRIMARY KEY,
  title TEXT NOT NULL,
  body TEXT NOT NULL,
  user_id BIGINT NOT NULL REFERENCES users (user_id),
  expires_on TIMESTAMP WITH TIME ZONE,
  created_on TIMESTAMP WITH TIME ZONE NOT NULL DEFAULT NOW(),
  updated_on TIMESTAMP WITH TIME ZONE NOT NULL DEFAULT NOW()
);

ALTER TABLE pastes ADD CONSTRAINT chk_updated_on_valid CHECK (created_on <= updated_on);
ALTER TABLE pastes ADD CONSTRAINT chk_expires_on_valid CHECK (expires_on >= created_on);