## Сообщение результата исследования [/json/patReferral/setResult]

### /json/patReferral/setResult [PUT]
Данным запросом ЛИС оповещает МИС о результатах исследований.  

В запросе передаётся объект - APPOINTMENT_RESULT.

**APPOINTMENT_RESULT**:
- APP_ID - Идентификатор направления в МИС 
- DOC_DATE - Дата заключения 
- DOC_MICRO - Микро-описание заключения 
- GLASS_MICRO - Микро-описания выбранных врачом стекол
- MACRO - Макро-описания макро-препаратов
- CONTENT - Текст заключения
- MKB_CODE - Код диагноза МКБ
- MKB_TITLE - Текст диагноза МКБ
- MKBO_CODE - Код диагноза МКБ-О
- MKBO_TITLE - Текст диагноза МКБ-О
- SERVICE - Оказанная услуга


+ Request (application/json)
    + Body

            {
              "APPOINTMENT_RESULT": {
                "APP_ID": "1745691",
                "DOC_DATE": "2016-04-30T09:00:00.000",
                "DOC_MICRO": "Микро-описание заключения",
                "GLASS_MICRO": "Микро-описания выбранных врачом стекол",
                "MACRO": "Макро-описания макро-препаратов",
                "CONTENT": "Текст заключения",
                "MKB_CODE": "С25.1",
                "MKB_TITLE": "ЗНО Тела поджелудочной железы",
                "MKBO_CODE": "9053/0",
                "MKBO_TITLE": "Мезотелиома, двухфазная, доброкачественная",
                "SERVICE": "Микроскопическое исследование"
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
                "CODE": "4",
                "NOTES": "Невозможно обновить данные документа со статусом 'Готов'",
                "NAME": "com.siams.med.api.DocAlreadyReadyException",
                "UUID": "b145acc8-3fd1-4cb0-bdba-f7532e047cb5"
              }
            }      


