# gei-776

[![Run Status](https://img.shields.io/shippable/5c02fc4f0dd1c207005ee971/master.svg)](https://app.shippable.com/projects/5c02fc4f0dd1c207005ee971)
[![Quality Gate](https://sonarcloud.io/api/project_badges/measure?project=beauchef_gei-776&metric=alert_status)](https://sonarcloud.io/component_measures?id=beauchef_gei-776&metric=alert_status)
[![Security Rating](https://sonarcloud.io/api/project_badges/measure?project=beauchef_gei-776&metric=security_rating)](https://sonarcloud.io/component_measures?id=beauchef_gei-776&metric=security_rating)

[![Coverage](https://sonarcloud.io/api/project_badges/measure?project=beauchef_gei-776&metric=coverage)](https://sonarcloud.io/component_measures?id=beauchef_gei-776&metric=coverage)
[![Bugs](https://sonarcloud.io/api/project_badges/measure?project=beauchef_gei-776&metric=bugs)](https://sonarcloud.io/component_measures?id=beauchef_gei-776&metric=bugs)
[![Code Smells](https://sonarcloud.io/api/project_badges/measure?project=beauchef_gei-776&metric=code_smells)](https://sonarcloud.io/component_measures?id=beauchef_gei-776&metric=code_smells)
[![Vulnerabilities](https://sonarcloud.io/api/project_badges/measure?project=beauchef_gei-776&metric=vulnerabilities)](https://sonarcloud.io/component_measures?id=beauchef_gei-776&metric=vulnerabilities)

[![gei-776](https://img.shields.io/badge/homepage-gei--776-blue.svg)](http://syntaxerror.blog)

Le but du projet et de construire une application pour créer un blog.
Un seul utilisateur est disponible au début. 
Cet utilisateur à des droits d'administrateur, et pourra créer d'autres utilisateurs
Mais ceux-ci n'auront pas de droits d'aministrateur.
Il existe donc 2 roles:

* ADMIN
* USER

Chaque utilisateur peut poster des articles.
Le format des articles est le format [MarkDown](https://en.wikipedia.org/wiki/Markdown).
Chaque utilisateur peut détruire ses articles.

* [Rapport](doc/index.md)

## Requis

* [Java 1.8](https://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
* Dernière version de [Docker](https://store.docker.com/search?type=edition&offering=community)

## Lancer l'application

D'abord, générer le JAR exécutable:

```
> mvnw package
```

Ensuite, démarrer les conteneurs Docker:

```
> docker-compose up
```

## Utiliser l'application

Rendez-vous sur [http://localhost:8080](http://localhost:8080) et connectez-vous en utilisant l'identifiant suivant:

```
User:      admin@syntaxerror.blog
Password:  password
```
