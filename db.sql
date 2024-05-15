CREATE TABLE books (
  isbn SERIAL,
  title VARCHAR(255),
  author VARCHAR(255)
);

CREATE TABLE members (
  member_id SERIAL,
  full_name VARCHAR(255)
);
