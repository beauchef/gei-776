insert into users(id, display_name, email, password, is_enabled) values (1, 'admin', 'admin@syntaxerror.blog', 'password', true);
insert into user_roles(user_id, role_name) values (1, 'ROLE_USER');
insert into user_roles(user_id, role_name) values (1, 'ROLE_ADMIN');

insert into users(id, display_name, email, password, is_enabled) values (2, 'user', 'user@syntaxerror.blog', 'password', true);
insert into user_roles(user_id, role_name) values (2, 'ROLE_USER');

insert into users(id, display_name, email, password, is_enabled) values (3, 'moderator', 'moderator@syntaxerror.blog', 'password', true);
insert into user_roles(user_id, role_name) values (3, 'ROLE_ADMIN');

alter sequence hibernate_sequence restart with 4;
