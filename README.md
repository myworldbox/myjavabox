# myjavabox

Automation testing with Java + Intellij + Appium Studio 

## Quick start

```bash
adb reverse tcp:8081 tcp:8081
appium -a 127.0.0.1 -p 5000
```

## File structure

```bash
├── pom.xml
├── README.md
├── json
│   ├── correct.json
│   ├── run.json
│   ├── pipeline.json
│   └── wrong.json
└── src->main->java->org.example
    ├── action
    │   ├── auth
    │   ├── init
    │   └── order
    ├── global
    │   ├── allure
    │   ├── appium
    │   ├── format
    │   ├── selenium
    │   ├── system
    │   └── variable
    ├── root
    └── test
```

## Test case

```bash
{
    "test_case" :[
        {
            "index": 0,
            "id": "test_1",
            "action": [
                {
                    "func": "init.close"
                },
                {
                    "func": "init.open"
                },
                {
                    "func": "auth.login",
                    "input_id": "correct.account.level_3"
                },
                {
                    "func": "order.market.buy",
                    "input_id": "correct.order.small"
                },
                {
                    "func": "order.pending.buy",
                    "input_id": "correct.order.big"
                },
                {
                    "func": "auth.logout"
                }
            ]
        }
 ]
}
```