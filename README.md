# Автотесты на сайт StopGame.ru

## 💼 О проекте

🎮Данный проект создан для тестирования сайта [StopGame.ru](https://stopgame.ru/)

🛠️Используемый стэк в проекте

<img src="img/gradle_logo.jpg" width=10% height=10%> <img src="img/allure.jpg" width=10% height=10%> <img src="img/intellij.jpg" width=10% height=10%> <img src="img/java.png" width=10% height=10%> <img src="img/jenkins.jpg" width=15.02% height=15.02%> <img src="img/junit5.png" width=10.2% height=10.2%> <img src="img/selenide.jpg" width=10% height=10%> <img src="img/jira_logo.png" width=10% height=10%> <img src="img/img/appium_logo.png" width=10% height=10%> <img src="img/img/Rest-assured_logo.jpg" width=10% height=10%>
---
<details>
<summary>🧰Список тестов в проекте</summary>

<details><summary>📅 UI тесты</summary>

+ **Open site** - тест, проверяющий открытие страницы


+ **Login - Logout** - тест, проверяющий работы входа и выхода в учетную запись


+ **Searching all** - параметризированный тест, проверяющий работу поиска по сайту


+ **Open About resource page** - тест, проверяющий работу раздела "О проекте"


+ **Checking tags** - тест, проверяющий работу тэгов внутри страниц игр


+ **Checking developers** - тест, проверяющий работу разработчиков внутри страниц игр


+ **Checking last comment** - тест, проверяющий раздел последних комментариев и переход к ним


+ **Adding the game to the profile** - тест, проверяющий возможность добавить и удалить игру в свой профиль


+ **Searching Users** - тест, проверяющий работу поиска юзеров по сайту


+ **Social networks check** - тест, проверяющий наличие ссылок на социальные сети

</details>

<details><summary>🛃 API тесты</summary>

+ **Login via API** - тест, проверяющий возможность залогиниться через API


+ **Add the game via API - authorized** - тест, проверяющий возможность добавить в профиль авторизированного пользователя игру через API


+ **Add the game via API - not authorized** - тест, проверяющий возможность добавить игру в профиль неавторизированного пользователя через API


+ **Add the news to favourite via API - authorized** - тест, проверяющий возможность добавить новость в избранное в профиль авторизированного пользователя через API 


+ **Add the news to favourite via API - not authorized** - тест, проверяющий возможность добавить новость в избранное в профиль неавторизированного пользователя через API 

</details>

<details><summary>📱 Мобильные тесты</summary>

❕ Так как у StopGame.ru нет своего мобильного приложения, было решено написать мобильные тесты для приложения Яндекс.Переводчик. ❕


+ **Translation text** - тест, проверяющий перевод текста с одного языка на другой


+ **Switching language** - тест, проверяющий работу смены языка


+ **Open Settings** - тест, проверяющий работу кнопки Настройки (Settings)

</details>


</details>

---
🤖Пример прохождения теста ***Adding the game to the profile***:

![addGameTest](img/stopgame-gif-test.gif)

---
## 🏗️ Сборка

👨‍✈️ Сборка проекта происходит через Jenkins

<img src="img/jenkins_cloud.png" width=100% height=100%>

⚙️ Также в Jenkins реализован выбор параметров запуска сборки

<img src="img/jenkins_parameters.png" width=100% height=100%>

<img src="img/jenkins_parameters_2.png" width=100% height=100%>

---

## 📑 Отчетность

📃 В Jenkins реализована интеграция с Allure

Allure Reports
<img src="img/allure_report.png" width=100% height=100%>

Allure TestOps
<img src="img/allure_test_ops.png" width=100% height=100%>

Allure TestOps dashboards
<img src="img/allure_test_ops_dashboard.png" width=100% height=100%>
<img src="img/allure_test_ops_dashboard2.png" width=100% height=100%>


<img src="img/tg_logo.png" width=2% height=2%> Также реализована интеграция с ботом Telegram

<img src="img/telegram_bot.png" width=100% height=100%>




