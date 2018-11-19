insert into posts(id, user_id, title, text, created_date, created_by_id, last_modified_date, last_modified_by_id)
SELECT nextval('hibernate_sequence'),
  u.id,
  'Article with Markdown',
  E'# gei-776' || chr(10) ||
'Projet GEI 776' || chr(10) ||
'' || chr(10) ||
'## Requis' || chr(10) ||
'' || chr(10) ||
'* [Java 1.8](https://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)' || chr(10) ||
'* Dernière version de [Docker](https://store.docker.com/search?type=edition&offering=community)' || chr(10) ||
'' || chr(10) ||
'## Lancer l''application' || chr(10) ||
'' || chr(10) ||
'D''abord, générer le JAR exécutable:' || chr(10) ||
'' || chr(10) ||
'```' || chr(10) ||
'> mvnw package' || chr(10) ||
'```' || chr(10) ||
'' || chr(10) ||
'Ensuite, démarrer les conteneurs Docker:' || chr(10) ||
'' || chr(10) ||
'```' || chr(10) ||
'> docker-compose up' || chr(10) ||
'```' || chr(10) ||
'' || chr(10) ||
'## Utiliser l''application' || chr(10) ||
'' || chr(10) ||
'Rendez-vous sur [http://localhost:8080]() et connectez-vous en utilisant l''identifiant suivant:' || chr(10) ||
'' || chr(10) ||
'```' || chr(10) ||
'User:      admin@syntaxerror.blog' || chr(10) ||
'Password:  password' || chr(10) ||
'```',
  current_timestamp,
  u.id,
  current_timestamp,
  u.id
FROM users u LIMIT 1;