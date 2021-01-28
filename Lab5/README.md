# Selenide

Biblioteka Selenide służy do tworzenia czytelnych, stabilnych testów automatycznych dla aplikacji webowych w Javie
oraz większości języków korzystających z JVM. Selenide opakowuje Selenium Web Driver, definując inne,  spójne i
przejrzyste Api oraz assercje w języku naturalnym.

##### Wymagania:

JDK >= 11

#### Wymagane zależności:
```
<dependency>
    <groupId>com.codeborne</groupId>
    <artifactId>selenide</artifactId>
    <version>5.18.0</version>
</dependency>
<dependency>
    <groupId>junit</groupId>
    <artifactId>junit</artifactId>
    <version>4.13</version>
    <scope>test</scope>
</dependency>
```
#### Przykłady: 
W pliku [ SelenideExampleTest.java](src/test/java/SelenideExampleTest.java#27) zawierają się dwa testy

[Test1](src/test/java/SelenideExampleTest.java#27)  
[Wynik](test-result/reports/SelenideExampleTest/checkGoogleSearch/1611853552274.0.png)  

[Test2](src/test/java/SelenideExampleTest.java#39)  
[Wynik](test-result/reports/SelenideExampleTest/checkOnetIncorrectLoginDataMessage)

#### Linki:
https://selenide.org/
