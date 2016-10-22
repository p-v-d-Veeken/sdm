
<a name="definitions"></a>
## Definitions

<a name="apiclient"></a>
### ApiClient

|Name|Description|Schema|
|---|---|---|
|**createdAt**  <br>*optional*|The creation date|string|
|**email**  <br>*required*|The email of the client|string|
|**fname**  <br>*required*|The first name of the client|string|
|**id**  <br>*optional*|The id of the client|integer|
|**lname**  <br>*required*|The last name of the client|string|
|**updatedAt**  <br>*optional*|The update date|string|


<a name="apirecord"></a>
### ApiRecord

|Name|Description|Schema|
|---|---|---|
|**client_id**  <br>*optional*|The id of the owning client|integer|
|**createdAt**  <br>*optional*|The creation date|string|
|**id**  <br>*optional*|The id of the client|integer|
|**name**  <br>*required*|The name of the ApiRecord|string|
|**updatedAt**  <br>*optional*|The update date|string|
|**value**  <br>*required*|The value of the ApiRecord|string|


<a name="query"></a>
### Query

|Name|Description|Schema|
|---|---|---|
|**column**  <br>*required*|The clumn you want to filter on|string|
|**operator**  <br>*required*|The operation to use for comparison|string|
|**value**  <br>*required*|The value you want to compare the entry against, text for key and numeric for value|string|



