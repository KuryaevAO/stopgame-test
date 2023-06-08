# StopGame.ru tests

## О проекте

🎮Данный проект создан для тестирования сайта [StopGame.ru](https://stopgame.ru/)

### 🛠️Используемый стэк в проекте

<img src="img/gradle_logo.jpg" width=10% height=10%> <img src="img/allure.jpg" width=10% height=10%> <img src="img/intellij.jpg" width=10% height=10%> <img src="img/java.png" width=10% height=10%> <img src="img/jenkins.jpg" width=15.02% height=15.02%> <img src="img/junit5.png" width=10.2% height=10.2%> <img src="img/selenide.jpg" width=10% height=10%>
---
<details>
<summary>🧰Список тестов в проекте</summary>

+ **openSiteTest** - тест, проверяющий открытие страницы


+ **loginLogoutTest** - тест, проверяющий работы входа и выхода в учетную запись


+ **searchTest** - параметризированный тест, проверяющий работу поиска по сайту


+ **aboutResourceTest** - тест, проверяющий работу раздела "О проекте"


+ **tagCheckTest** - тест, проверяющий работу тэгов внутри страниц игр


+ **developerCheckTest** - тест, проверяющий работу разработчиков внутри страниц игр


+ **latestCommentTest** - тест, проверяющий раздел последних комментариев и переход к ним


+ **addGameTest** - тест, проверяющий возможность добавить и удалить игру в свой профиль


+ **checkUsersTest** - тест, проверяющий работу поиска юзеров по сайту


+ **checkSocialNetworksTest** - тест, проверяющий наличие ссылок на социальные сети
</details>

🤖Пример прохождения теста **addGameTest**:

![addGameTest](img/stopgame-gif-test.gif)

### 🏗️ Сборка

👨‍✈️ Сборка проекта происходит через Jenkins

<img src="img/jenkins_cloud.png" width=100% height=100%>

⚙️ Также в Jenkins реализован выбор параметров запуска сборки

<img src="img/jenkins_parameters.png" width=100% height=100%>

### 📑 Отчетность

📃 В Jenkins реализована интеграция с Allure

Allure Reports
<img src="img/allure_report.png" width=100% height=100%>

Allure TestOps
<img src="img/allure_test_ops.png" width=100% height=100%>

<img src="img/tg_logo.png" width=5% height=5%> Также реализована интеграция с ботом Telegram

<img src="img/telegram_bot.png" width=100% height=100%>


