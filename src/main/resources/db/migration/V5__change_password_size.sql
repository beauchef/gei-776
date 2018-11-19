-- shrink column size, size we hash passwords using bcrypt
ALTER TABLE users ALTER COLUMN password TYPE varchar(60);
