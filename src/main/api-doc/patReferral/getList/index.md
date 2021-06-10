## Запрос списка направлений [/json/patReferral/getList{?APP_ID,SURNAME,MR_NUM,IMPORTED}]

### /json/patReferral/getList [GET]
Запрос списка текущих направлений, существующих в МИС.

В ответе передается объект APPOINTMENTS, содержащий массив направлений.
Запрос может быть выполнен без параметров – в этом случае возвращается список всех направлений на ПГИ

+ Parameters

    + APP_ID: 1745691 (optional,integer) - Идентификатор направления в МИС. Накладывается условие равенства
    + SURNAME: `ИВАН` (optional,string) - Фамилия пациента. Накладывается условие LIKE ‘SURNAME%’
    + MR_NUM: `16-456` (optional,string) - Номер и/б или а/к пациента. Накладывается условие LIKE ‘MRNUM%’
    + IMPORTED: 0 (optional,integer) - Фильтр по признаку «импортировано в ЛИС». 1 – возвращать только импортированные, 0 – только не импортированные, если не указано – возвращается все

+ Response 200 (application/json)
    + Body

            {
              "APPOINTMENTS": [
                {
                  "APP_ID": "1745691",
                  "PATIENT_ID": "75691",
                  "SURNAME": "Макаревич",
                  "NAME": "Андрей",
                  "PATRONYMIC": "Вадимович",
                  "MALE": "1",
                  "CARD_NUM": "6290",
                  "APP_DATE": "2016-04-30T09:00:00.000",
                  "DEPARTMENT": "Поликлиника",
                  "DOCTOR":"Селезнев ВА",
                  "MATERIAL": "не указан",
                  "PAYTYPE" :"ОМС",
                  "IMPORTED" :"1"
                }
              ]
            }
+ Response 422 (application/json)
    + Body
    
            {
              "ERROR": {
                "CODE":"1",
                "NOTES": "Невозможно преобразовать параметр в целое число (APP_ID, 'z123')",
                "NAME": "com.siams.med.api.IntegerFormatErrorException",
                "UUID": "b145acc8-3fd1-4cb0-bdba-f7532e047cb5"
              }
            }      
            