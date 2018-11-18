UPDATE users
SET created_date=(TIMESTAMP '2018-11-14 15:36:38'),
    last_modified_date=(TIMESTAMP '2018-11-14 15:36:38'),
    created_by_id=first_user.id,
    last_modified_by_id=first_user.id
FROM (SELECT id FROM users LIMIT 1) AS first_user;

UPDATE posts
SET created_date=(TIMESTAMP '2018-11-14 15:36:38'),
    last_modified_date=(TIMESTAMP '2018-11-14 15:36:38'),
    created_by_id=first_user.id,
    last_modified_by_id=first_user.id
FROM (SELECT id FROM users LIMIT 1) AS first_user;

ALTER TABLE users
  ALTER COLUMN created_date SET NOT NULL,
  ALTER COLUMN created_by_id SET NOT NULL,
  ALTER COLUMN last_modified_date SET NOT NULL,
  ALTER COLUMN last_modified_by_id SET NOT NULL;

ALTER TABLE posts
  ALTER COLUMN created_date SET NOT NULL,
  ALTER COLUMN created_by_id SET NOT NULL,
  ALTER COLUMN last_modified_date SET NOT NULL,
  ALTER COLUMN last_modified_by_id SET NOT NULL;
