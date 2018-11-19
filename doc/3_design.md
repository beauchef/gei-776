# Phase 3: Conception (_Design_)

Cette section couvre la phase 3 du cadre de développement SDL, soit la conception [[SDL3]](#sdl3).

## Pratique #5: Déterminer les exigences de conception 
_SDL Practice #5: Establish Design Requirements_

### Hachage de mot de passe

Microsoft ne fait pas de recommendation quant au hachage de mot de passe [[MSCR]](#mscr).
L'OWASP suggère d'utiliser une fonction de hachage à sens unique [[PSCS]](#pscs).
Ils proposent les algorithmes suivants:

* Argon2, algorithme qui a remporté la compétition de _Password Hashing_ ([password hashing competition](https://password-hashing.net/)).
* PBKDF2
* scrypt
* bcrypt

Il n'y a pas d'implémentation fiable de Argon2 disponible en Java. 
OWASP suggére de n'utiliser bcrypt que si PBKDF2 ou scrypt n'est pas disponible.
Des implémentations de PBKDF2, scrypt et bcrypt sont disponibles dans _Spring Security_.
Nous utiliserons malgré tout bcrypt pour sa simplicité. 

## Pratique #6: Déterminer les exigences de conception
_SDL Practice #6: Perform Attack Surface Analysis/Reduction_

## Pratique #7: Modélisation de la menace
_SDL Practice #7: Use Threat Modeling_

<br/>

###### Références
|||
|---| ---|
|[MSCR] | <a name="mscr"></a>[Microsoft SDL Cryptographic Recommendations](http://download.microsoft.com/download/6/3/A/63AFA3DF-BB84-4B38-8704-B27605B99DA7/Microsoft%20SDL%20Cryptographic%20Recommendations.pdf), Microsoft|
|[PSCS] | <a name="pscs"></a>[Password Storage Cheat Sheet](https://www.owasp.org/index.php/Password_Storage_Cheat_Sheet), OWASP|
|[SDL3] | <a name="sdl3"></a>[Security Development Lifecycle, Phase 3: Design](https://www.microsoft.com/en-us/SDL/process/design.aspx), Microsoft|
