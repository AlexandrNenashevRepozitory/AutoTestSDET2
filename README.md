# AutoTestSDET2
**Практикум по разработке в тестировании (SDET: Java и Python)**  
<br>
<br>
Добрый день.
<br>
<br>
Данный проект реализован для тестирования формы регистрации: https://www.globalsqa.com/angularJs-protractor/BankingProject/#/manager
<br>
В проекте используется: Java, Maven, Junit5, Allure, Selenium
<br>
<br>
Проект запускается в терминале с помощью команды `mvn test`. После выполнения команды автоматически генерируется дирректория target/allure-results. В ней хранятся файлы, которые
представляют собой исходные данные для создания отчетов Allure.
<br>
<br>
Для формирования и открытия отчёта можно воспользоваться командой `mvn allure:serve`. При выполнении отчёт автоматически сформируется и откроется в браузере.
<br>
<br>
C помощью команды `mvn allure:report` можно сгенерировать отчёт и он появится в проекте по пути : `AutoTestSDET2\target\site\allure-maven-plugin\index.html`
<br>
<br>