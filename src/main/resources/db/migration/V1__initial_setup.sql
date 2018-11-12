create sequence hibernate_sequence;

create table users
(
	id bigint not null constraint users_pkey primary key,
	display_name varchar(255) constraint uk_users_name unique,
	email varchar(255) constraint uk_users_email unique,
	password varchar(255) not null,
	is_enabled boolean not null,
	created_date timestamp,
	created_by_id bigint constraint fk_users_created_by_user references users,
	last_modified_date timestamp,
	last_modified_by_id bigint constraint fk_users_modified_by_user references users
);

create table user_roles
(
	id bigint not null constraint user_roles_pkey primary key,
	user_id bigint constraint fk_user_roles_user_id references users,
	role_name varchar(255)
);

-- Insert default 'admin' user, with password 'password'
insert into users(id, display_name, email, password, is_enabled)
values (nextval('hibernate_sequence'), 'admin', 'admin@syntaxerror.blog', '$2a$11$OT6u/y9k9vKDltSIDfuMmegQ73r6O05qTOcF8n5KmdO1/r32sJIlC', true);

insert into user_roles(id, user_id, role_name)
select nextval('hibernate_sequence'), u.id, 'ROLE_ADMIN' from users u where u.email='admin@syntaxerror.blog';
insert into user_roles(id, user_id, role_name)
select nextval('hibernate_sequence'), u.id, 'ROLE_USER' from users u where u.email='admin@syntaxerror.blog';

commit;
