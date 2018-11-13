create table posts
(
	id bigint not null constraint posts_pkey primary key,
  user_id bigint constraint fk_posts_user_id references users,
  title varchar(255) not null,
	text varchar(50000) not null,
	created_date timestamp,
	created_by_id bigint constraint fk_posts_created_by_user references users,
	last_modified_date timestamp,
	last_modified_by_id bigint constraint fk_posts_modified_by_user references users
);
