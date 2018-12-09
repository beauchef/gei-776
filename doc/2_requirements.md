# Phase 2: Exigences (_Requirements_)

Cette section couvre la phase 2 du cadre de développement SDL, soit les exigences [[SDL2]](#sdl2).

## Pratique #2: Déterminer les exigences de sécurité et de confidentialité 
_SDL Practice #2: Establish Security and Privacy Requirements_

Pour l'application de blogage, il existera 3 types d'utilisateurs:
* **Utilisateur anonyme**: cet utilisateur peut lire les blogs, et n'a pas besoin de s'authentifier
* **Blogueur**: cet utilisateur peut créer, mettre à jour, et détruire ses articles
* **Administrateur**: cet utilisateur peut créer, mettre à jour, et détruire un utilisateur

Il sera donc impossible à quiconque de mettre à jour ou de détruire les articles d'un autre blogueur.

Seul un utilisateur anonyme n'aura pas besoin d'être authentifier.
Les blogueurs et les administrateurs eux, devront s'authentifier à l'aide de leur adresse courriel et d'un mot de passe.
Il existera donc 2 groupes de sécurité pour l'application:
* **USER**: Groupe permettant de créer, mettre à jour, et détruire un article
* **ADMIN**: Groupe permettant de créer, mettre à jour, et détruire un utilisateur 

## Pratique #3: Établir des objectifs de qualité
_SDL Practice #3: Create Quality Gates/Bug Bars_

### Couverture de tests

Ue seuil minimum pour la couverture de tests sera fixé, et contrôlé à l'aide de JaCoCo, directement lors du build.
Dans la section `properties` du `pom.xml`, des variables ont été définies pour contrôller ces objectifs de qualité.

```
        <quality-gate.coverage-ratio.line>0.80</quality-gate.coverage-ratio.line>
        <quality-gate.coverage-ratio.instruction>0.70</quality-gate.coverage-ratio.instruction>
```

Les objectifs de qualité sont donc:
* 80% de couverture de tests pour les lignes de code
* 70% de couverture de tests pour les insructions

### Dépendances de l'application

La librairie [OWASP dependency check](https://www.owasp.org/index.php/OWASP_Dependency_Check) sera utilisée pour contrôler la sécurité des librairies utilisées par l'application.
Dans la section `properties` du `pom.xml`, une variable a été définie pour contrôller cet objectif de qualité:

```
        <quality-gate.dependencies.min-cvss-score>6</quality-gate.dependencies.min-cvss-score>
```

L'objectif de qualité est donc:
* Niveau 6 minimum (le niveau peut aller de 1 à 10, 10 étant le plus sévère)  

### Failles de sécurité décelées lors de l'analyse statique
Sonar peut également détecter une faille de sécurité. Il sera possible de le voir directement sur le `README.md`du projet.

![Quality Gates failed](img/2_quality_gates_failed.jpg)



Voir: 
* https://msdn.microsoft.com/en-us/library/cc307404.aspx
* https://msdn.microsoft.com/en-us/library/cc307403.aspx

Quality Gates (à revoir):
* Code Coverage: 80%
* Utiliser: https://www.owasp.org/index.php/OWASP_Dependency_Check
* Utiliser: http://find-sec-bugs.github.io/
* Utiliser: http://findbugs.sourceforge.net/
* Utiliser: http://checkstyle.sourceforge.net/
* Utiliser: https://pmd.github.io/

## Pratique #4: Évaluer les risques en matière de sécurité et de confidentialité
_SDL Practice #4: Perform Security and Privacy Risk Assessments_



<br/>

###### Références
|||
|---| ---|
|[SDL2] | <a name="sdl2"></a>[Security Development Lifecycle, Phase 2: Requirements](https://www.microsoft.com/en-us/SDL/process/requirements.aspx), Microsoft|
