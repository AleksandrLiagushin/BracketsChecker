# BracketsChecker

## _Description_

> Service allows users to check right brackets sequence in sent text.
> Used Spring Boot 3.1.3
> Java version Correto 17

## Project deployment

> Download jar file [BracketsChecker](https://github.com/AleksandrLiagushin/BracketsChecker/blob/master/target/BracketsChecker-0.0.1-SNAPSHOT.jar) from open GitHub repository<br>
> Run file depends on your OS<br>
> Full repository link [repository](https://github.com/AleksandrLiagushin/BracketsChecker)<br>
> Tests added and possible to run before deploying<br>
> JUnit used as primary test system<br>

## _Used HTTP methods_

| Method | Description                                                                                                                                                   |
|--------|---------------------------------------------------------------------------------------------------------------------------------------------------------------|
| GET    | Allows the user to check their text.<br/>Body required json format {"text": "userText"}.<br/> Sent answer contains json body in format {"isCorrect": boolean} |


## _Possible HTTP response codes_

| Code | Description                                                 |
|------|-------------------------------------------------------------|
| 200  | OK                                                          |
| 400  | Bad request in case of wrong json format or empty text      |
| 405  | Method not allowed if another method other than GET is used |


## _End points_

> CheckerController

| Method | URL                | Description                                                      | Params                  |
|--------|--------------------|------------------------------------------------------------------|-------------------------|
| GET    | /api/checkBrackets | Returns json answer. <br/> Answer format {"isCorrect": boolean}  | N/A                     |

## _Project structure_

> Used Spring Boot 3.1.3<br>
> Java version Correto 17<br>
> Used Maven build system
> Used JUnit library for test system

> Two main layers of app<br>
> Controllers includes CheckerController, that processes users requests<br>
> Service layer includes two packages:<br>
> handler with ErrorHandler class (processes app exceptions)
> util with BracketsChecker and JsonParser classes<br>

