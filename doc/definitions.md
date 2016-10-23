
<a name="definitions"></a>
## Definitions

<a name="apiclient"></a>
### ApiClient

|Name|Description|Schema|
|---|---|---|
|**created_at**  <br>*optional*|The creation date|string|
|**email**  <br>*required*|The email of the client|string|
|**fname**  <br>*required*|The first name of the client|string|
|**id**  <br>*optional*|The id of the client|integer|
|**lname**  <br>*required*|The last name of the client|string|
|**updated_at**  <br>*optional*|The update date|string|


<a name="apirecord"></a>
### ApiRecord

|Name|Description|Schema|
|---|---|---|
|**created_at**  <br>*optional*|The creation date|string|
|**id**  <br>*optional*|The id of the client|integer|
|**name**  <br>*required*|The name of the record|string|
|**updated_at**  <br>*optional*|The update date|string|
|**value**  <br>*required*|The value of the record|string|


<a name="apiretrievalanswer"></a>
### ApiRetrievalAnswer

|Name|Description|Schema|
|---|---|---|
|**answer**  <br>*required*|Answer to the current step|string|
|**previous**  <br>*required*|The hashed answer to the previous step|string|
|**step**  <br>*required*|The current step in the process (out of 3)|integer|


<a name="apiretrievalresponse"></a>
### ApiRetrievalResponse

|Name|Description|Schema|
|---|---|---|
|**hash**  <br>*required*|The hashed answer to the question if it is correct|string|


<a name="clientbundle"></a>
### ClientBundle

|Name|Description|Schema|
|---|---|---|
|**client**  <br>*required*||[ApiClient](#apiclient)|
|**keyring**  <br>*required*||[Keyring](#keyring)|


<a name="keyring"></a>
### Keyring

|Name|Description|Schema|
|---|---|---|
|**keyring**  <br>*required*|The unlocked keyring|string|


<a name="query"></a>
### Query

|Name|Description|Schema|
|---|---|---|
|**column**  <br>*required*|The clumn you want to filter on|enum (KEY, VALUE)|
|**operator**  <br>*required*|The operation to use for comparison|enum (<, >=, =)|
|**value**  <br>*required*|The value you want to compare the entry against, text for key and numeric for value|string|


<a name="querybundle"></a>
### QueryBundle

|Name|Description|Schema|
|---|---|---|
|**keyring**  <br>*required*||[Keyring](#keyring)|
|**query**  <br>*required*||< [Query](#query) > array|


<a name="recordbundle"></a>
### RecordBundle

|Name|Description|Schema|
|---|---|---|
|**keyring**  <br>*required*||[Keyring](#keyring)|
|**record**  <br>*required*||[ApiRecord](#apirecord)|



