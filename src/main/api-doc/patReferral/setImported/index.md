## Оповещение об импорте направления [/json/patReferral/setImported]

### /json/patReferral/setImported [PATCH]
Оповещение об импорте направления.
Данным запросом ЛИС оповещает МИС о том, что направление было успешно проимпортировано в ЛИС. 

В запросе передаётся объект - IMPORTED_APPOINTMENT.

+ Request (application/json)
    + Body

            {
              "IMPORTED_APPOINTMENT": {
                "APP_ID": "1745691"
              }
            }
            
+ Response 200 (application/json)
    + Body

            {
              "ERROR": {
                "CODE": "0",
                "NOTES": "Успешно",
                "NAME": "",
                "UUID": ""
              }
            }      

+ Response 422 (application/json)
    + Body

            {
              "ERROR": {
                "CODE": "1",
                "NOTES": "Невозможно преобразовать параметр в целое число (APP_ID, 'z123')",
                "NAME": "com.siams.med.api.IntegerFormatErrorException",
                "UUID": "b145acc8-3fd1-4cb0-bdba-f7532e047cb5"
              }
            }      

+ Response 422 (application/json)
    + Body

            {
              "ERROR": {
                "CODE": "3",
                "NOTES": "Неверная структура запроса",
                "NAME": "com.siams.med.api.QueryParamsException",
                "UUID": "b145acc8-3fd1-4cb0-bdba-f7532e047cb5"
              }
            }      

